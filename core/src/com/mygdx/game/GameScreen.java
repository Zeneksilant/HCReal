package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.Tools.Assets;
import static com.mygdx.game.Tools.Assets.Samurai;
import static com.mygdx.game.Tools.Assets.doortouw;
import static com.mygdx.game.Tools.Assets.townmap;
import static com.mygdx.game.Tools.Assets.uverworld;

public class GameScreen implements Screen {

    HighCastle game;
    OrthographicCamera camera;
    SpriteBatch batch;
    Vector3 touch;
    int samX;
    int samY;
    int dtuwX;
    int dtuwY;
    OrthogonalTiledMapRenderer renderer;
    public GameScreenUW UW;

    public GameScreen(HighCastle game) {
        this.game = game;
        touch = new Vector3();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1920, 1080);

        batch = new SpriteBatch();
        renderer = new OrthogonalTiledMapRenderer(townmap);
        samX = 960 - 64;
        samY = 540 - 64;
        dtuwX = 760;
        dtuwY = 890;
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1F, 1F, 1F, 1F);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
        camera.update();
        generalupdate(touch, camera);
        batch.setProjectionMatrix(camera.combined);
        renderer.setView(camera);
        renderer.render();

        batch.begin();
            batch.draw(Samurai, samX, samY, 150, 150);
            batch.draw(doortouw, dtuwX, dtuwY);
        batch.end();

    }

    public void generalupdate(Vector3 touch, OrthographicCamera camera){
        if(Gdx.input.isTouched()){
            touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touch);
            samX = (int)touch.x;
            samY = (int)touch.y;
        }
        if((samY > 900)){
            game.setScreen(new GameScreenUW(game));
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