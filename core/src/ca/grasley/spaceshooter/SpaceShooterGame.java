package ca.grasley.spaceshooter;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

import java.util.Random;

public class SpaceShooterGame extends Game {
    GameScreen gameScreen;
    ToastHandler toastHandler;
    RewardAdListener rewardAdListener;
    public static Random random = new Random();

    @Override
    public void create() {
        gameScreen = new GameScreen();
        setScreen(gameScreen);
    }

       @Override
    public void dispose() {
        gameScreen.dispose();
    }

    @Override
    public void render() {
        super.render();
          }

    @Override
    public void resize(int width, int height) {
        gameScreen.resize(width, height);
    }
}
