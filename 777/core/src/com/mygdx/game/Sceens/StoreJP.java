package com.mygdx.game.Sceens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.HighCastle;
import com.mygdx.game.Tools.Assets;

public class StoreJP implements Screen {
    final HighCastle game;
    OrthographicCamera camera;
    int samX = 960 - 64;
    int samY = 540 - 64;
    Vector3 touch;
    private int tt;

    public StoreJP(final HighCastle game) {
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
        generalupdate(touch, camera);

        game.batch.begin();
        game.batch.draw(Assets.sprite_storeJP, 0, 0);
        game.batch.end();
    }

    public void generalupdate(Vector3 touch, OrthographicCamera camera){
        if(Gdx.input.isTouched()){
            touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touch);
            samX = (int)touch.x;
            samY = (int)touch.y;
            tt++;
        }
        if(samX>125 && samX<550 && samY>1080-920 && samY<1080-215&& tt>20){
            Store.Blade = true;
            Store.vs = true;
            game.setScreen(new UverWorldScreen(game));
            dispose();
        }
        if(samX>645 && samX<1044 && samY>1080-925 && samY<1080-215&& tt>20){
            Store.Bow = true;
            Store.vs = true;
            game.setScreen(new UverWorldScreen(game));
            dispose();
        }
        if(samX>1190 && samX<1490 && samY>1080-710 && samY<1080-215 && tt>20){
            Store.Potion = true;
            Store.vs = true;
            game.setScreen(new UverWorldScreen(game));
            dispose();
        }
        if(samX>1650 && samX<1910 && samY>1080-910 && samY<1080-830&& tt>20){
            game.setScreen(new UverWorldScreen(game));
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
