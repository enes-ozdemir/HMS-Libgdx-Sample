package ca.grasley.spaceshooter;

public class Ads {

    public static ToastHandler toastHandler;
    public static RewardAdListener rewardAdListener;

    public void setToastHandler(ToastHandler toastHandler) {
        this.toastHandler = toastHandler;
    }
    public void setRewardedAdListener(RewardAdListener listener){
        this.rewardAdListener = listener;
        if(!listener.isAdLoaded()){
            loadRewardAd();
        }
    }
    private void loadRewardAd() {
        rewardAdListener.loadRewardAd(new RewardAdLoadCallback() {

            @Override
            public void onRewardAdFailedToLoad(int i) {
                toastHandler.showToast("onRewardAdFailedToLoad: " + i);
            }

            @Override
            public void onRewardedLoaded() {
                toastHandler.showToast("onRewardedLoaded");
            }
        });
    }

    public void showRewardAd() {
        if(rewardAdListener!=null) {

        rewardAdListener.showRewardAd(new RewardAdStatusCallback() {
            @Override
            public void onRewardAdClosed() {
                toastHandler.showToast("onRewardAdClosed");
            }

            @Override
            public void onRewardAdFailedToShow(int i) {
                toastHandler.showToast("onRewardAdFailedToShow: " + i);
            }

            @Override
            public void onRewardAdOpened() {
                toastHandler.showToast("onRewardAdOpened");
            }

            @Override
            public void onRewarded() {
                toastHandler.showToast("onRewardAdOpened");
            }
        });
        }

    }
}
