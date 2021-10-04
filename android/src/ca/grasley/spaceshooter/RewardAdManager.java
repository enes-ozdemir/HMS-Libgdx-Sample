package ca.grasley.spaceshooter;


import android.app.Activity;
import android.content.Context;

import com.huawei.hms.ads.AdParam;
import com.huawei.hms.ads.HwAds;
import com.huawei.hms.ads.reward.Reward;
import com.huawei.hms.ads.reward.RewardAd;
import com.huawei.hms.ads.reward.RewardAdLoadListener;
import com.huawei.hms.ads.reward.RewardAdStatusListener;

class RewardAdManager {
    private static volatile RewardAdManager instance;

    public static synchronized RewardAdManager getInstance() {
        if (instance == null) {
            synchronized (RewardAdManager.class) {
                if (instance == null) {
                    instance = new RewardAdManager();
                }
            }
        }
        return instance;
    }

    private RewardAd mRewardAd;

    public void init(Context context) {
        HwAds.init(context);
        mRewardAd = new RewardAd(context, "testx9dtjwj8hp");
    }

    public void show(final Activity activity, final RewardAdStatusCallback callback) {
        mRewardAd.show(activity, new RewardAdStatusListener() {
            @Override
            public void onRewardAdClosed() {
                super.onRewardAdClosed();
                callback.onRewardAdClosed();
            }

            @Override
            public void onRewardAdFailedToShow(int i) {
                super.onRewardAdFailedToShow(i);
                callback.onRewardAdFailedToShow(i);
            }

            @Override
            public void onRewardAdOpened() {
                super.onRewardAdOpened();
                callback.onRewardAdOpened();
            }

            @Override
            public void onRewarded(Reward reward) {
                super.onRewarded(reward);
                callback.onRewarded();
            }
        });
    }

    public void load(final RewardAdLoadCallback callback) {
        mRewardAd.loadAd(new AdParam.Builder().build(), new RewardAdLoadListener() {
            @Override
            public void onRewardAdFailedToLoad(int i) {
                callback.onRewardAdFailedToLoad(i);
            }

            @Override
            public void onRewardedLoaded() {
                callback.onRewardedLoaded();
            }
        });
    }

    public boolean isLoaded() {
        return mRewardAd.isLoaded();
    }
}
