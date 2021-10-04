package ca.grasley.spaceshooter;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;

public class AndroidLauncher extends AndroidApplication implements ToastHandler {
    private static SpaceShooterGame myGame = new SpaceShooterGame();
    private static Ads ad = new Ads();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
        //	initializeForView(new SpaceShooterGame(), config);
        //initLayout();
        setContentView(initLayout());
        initRewardAd();
        ad.setToastHandler(this);
    }
	@Override
	public void showToast(final String msg) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(AndroidLauncher.this, msg, Toast.LENGTH_SHORT).show();
            }
        });
    }


    private RelativeLayout initLayout() {
        RelativeLayout layout = new RelativeLayout(this);

        AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
        //	myGame = new SpaceShooterGame();
        //initialize(new SpaceShooterGame(), config);
        View gameView = initializeForView(myGame, config);

        layout.addView(gameView);
        layout.addView(
                BannerAdManager.getInstance().getBannerView(this),
                new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT));


        return layout;
    }

    private void initRewardAd() {
        RewardAdManager.getInstance().init(this);
        ad.setRewardedAdListener(new RewardAdListener() {
            @Override
            public void showRewardAd(RewardAdStatusCallback callback) {
                RewardAdManager.getInstance().show(AndroidLauncher.this, callback);
            }

            @Override
            public void loadRewardAd(RewardAdLoadCallback callback) {
                RewardAdManager.getInstance().load(callback);
            }

            @Override
            public boolean isAdLoaded() {
                return RewardAdManager.getInstance().isLoaded();
            }
        });
    }
}
