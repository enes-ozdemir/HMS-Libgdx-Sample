package ca.grasley.spaceshooter;

import android.content.Context;
import android.util.Log;

import com.huawei.hms.ads.AdListener;
import com.huawei.hms.ads.AdParam;
import com.huawei.hms.ads.BannerAdSize;
import com.huawei.hms.ads.banner.BannerView;

public class BannerAdManager {
    private static volatile BannerAdManager instance;

    public static synchronized BannerAdManager getInstance(){
        if(instance == null){
            synchronized (BannerAdManager.class){
                if(instance == null){
                    instance = new BannerAdManager();
                }
            }
        }
        return instance;
    }


    private static final String TAG = "BannerAdManager";

    private BannerView mBannerView;
    private static final String BANNER_AD_TEST_ID = "testw6vs28auh3";

    public BannerView getBannerView(Context context){
        mBannerView = new BannerView(context);
        mBannerView.setBannerAdSize(BannerAdSize.BANNER_SIZE_360_57);
        setAdId(BANNER_AD_TEST_ID);
        setAdListener();
        loadAd();
        return mBannerView;
    }

    public BannerView setBannerSize(Context context,BannerAdSize size) {
        mBannerView = new BannerView(context);
        mBannerView.setBannerAdSize(size);
        setAdId(BANNER_AD_TEST_ID);
        setAdListener();
        loadAd();
        return mBannerView;
    }

    public void setAdListener(){
        mBannerView.setAdListener(new AdListener(){
            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                Log.i(TAG, "onAdLoaded: ");
            }
        });
    }

    public void setAdId(String adId){
        mBannerView.setAdId(adId);
    }

    public void loadAd(){
        mBannerView.loadAd(new AdParam.Builder().build());
    }


}