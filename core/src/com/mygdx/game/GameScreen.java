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
import com.mygdx.game.Tools.GameManager;
import com.mygdx.game.Tools.InputManager;

import static com.mygdx.game.Tools.Assets.CEgate;
import static com.mygdx.game.Tools.Assets.Samurai;
import static com.mygdx.game.Tools.Assets.doortouw;
import static com.mygdx.game.Tools.Assets.pauseScreen;
import static com.mygdx.game.Tools.Assets.townmap;
import static com.mygdx.game.Tools.Assets.uverworld;

public class GameScreen implements Screen {

    HighCastle game;
    OrthographicCamera camera;
    SpriteBatch batch;
    Vector3 touch;
    int samX;
    int samY;
    OrthogonalTiledMapRenderer renderer;
    public GameScreenUW UW;
    private float w,h;

    public GameScreen(HighCastle game) {
        this.game = game;
        touch = new Vector3();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1920, 1080);
        Samurai.setSize(400, 450);
        batch = new SpriteBatch();
        renderer = new OrthogonalTiledMapRenderer(townmap);
        samX = 960 - 64;
        samY = 540 - 64;
        w = Gdx.graphics.getWidth();
        h = Gdx.graphics.getWidth();
        GameManager.initialize(w, h);
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
        InputManager.handleInput(camera, Samurai);

        batch.begin();
            batch.setProjectionMatrix(camera.combined);
            Samurai.draw(batch);
            GameManager.renderGame(batch);
            batch.draw(doortouw, 760, 890);
            batch.draw(CEgate, 100, 960);
        batch.end();

    }

    public void generalupdate(Vector3 touch, OrthographicCamera camera){
        if(Gdx.input.isTouched()){
            touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touch);
            samX = (int)touch.x;
            samY = (int)touch.y;
        }
        if(samY > 900){
            game.setScreen(new GameScreenUW(game));
            dispose();
        }
        if(samX<100){
            game.setScreen(new GameScreenEnt(game));
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