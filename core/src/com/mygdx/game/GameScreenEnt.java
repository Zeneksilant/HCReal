package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.Tools.GameManager;
import com.mygdx.game.Tools.InputManager;

import static com.mygdx.game.Tools.Assets.CEgate;
import static com.mygdx.game.Tools.Assets.Enterance;
import static com.mygdx.game.Tools.Assets.Samurai;
import static com.mygdx.game.Tools.Assets.dog1;
import static com.mygdx.game.Tools.Assets.texture_dog1;
import static com.mygdx.game.Tools.Assets.uverworld;

public class GameScreenEnt implements Screen {
    HighCastle game;
    OrthographicCamera camera;
    SpriteBatch batch;
    Vector3 touch;
    int samX;
    int samY;
    int dogX;
    int dogY;
    OrthogonalTiledMapRenderer renderer;
    private float w,h;

    public GameScreenEnt(HighCastle game) {
        this.game = game;
        touch = new Vector3();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1920, 1080);

        batch = new SpriteBatch();
        renderer = new OrthogonalTiledMapRenderer(Enterance);
        samX = 960 - 64;
        samY = 540 - 64;
        dogX = samX + 10;
        dogY = samY +10;
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
        batch.draw(dog1, dogX, dogY);
        batch.setProjectionMatrix(camera.combined);
        Samurai.draw(batch);
        GameManager.renderGame(batch);
        batch.end();

    }

    public void generalupdate(Vector3 touch, OrthographicCamera camera){
        if(Gdx.input.isTouched()){
            touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touch);
            samX = (int)touch.x;
            samY = (int)touch.y;
        }
        if(samX>1900){
            game.setScreen(new GameScreen(game));
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
