package com.mygdx.game.Sceens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.HighCastle;
import com.mygdx.game.Tools.Assets;

public class LangSelect implements Screen {
    final HighCastle game;
    OrthographicCamera camera;
    static int x, y;
    Vector3 touch;
    int samX = 960 - 64;
    int samY = 540 - 64;
    public static boolean English;
    public static boolean Russian;
    public static boolean Japanese;

    public LangSelect(final HighCastle game) {
        this.game = game;

        touch = new Vector3();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1920, 1080);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1F, 1F, 1F, 1F);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        game.batch.draw(Assets.LangSelect, 0, 0);
        game.batch.end();
        if(Gdx.input.isTouched()){
            touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touch);
            samX = (int)touch.x;
            samY = (int)touch.y;
        }
        if(samX>392 && samX<1004 && samY>1080-396 && samY<1080-257){
            English = true;
            game.setScreen(new MainMenuScreen(game));
            dispose();
        }
        if(samX>393 && samX<1005 && samY>1080-576 && samY<1080-437){
            Russian = true;
            game.setScreen(new MainMenuScreenRus(game));
            dispose();
        }
        if(samX>393 && samX<1005 && samY>1080-756 && samY<1080-617){
            Japanese = true;
            game.setScreen(new MainMenuScreenJP(game));
            dispose();
        }
    }

    @Override
    public void show() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }


    @Override
    public void dispose() {
    }

    @Override
    public void resize(int width, int height) {}

    @Override
    public void hide() {}
}

