package ca.grasley.spaceshooter;

public interface RewardAdListener {
    void showRewardAd(RewardAdStatusCallback callback);
    void loadRewardAd(RewardAdLoadCallback callback);
    boolean isAdLoaded();
}
interface RewardAdLoadCallback {
    void onRewardAdFailedToLoad(int i);
    void onRewardedLoaded();
}
interface RewardAdStatusCallback {
    void onRewardAdClosed();
    void onRewardAdFailedToShow(int i);
    void onRewardAdOpened();
    void onRewarded();
}
interface ToastHandler {
    void showToast(String msg);
}
