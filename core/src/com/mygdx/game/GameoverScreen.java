package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.mygdx.game.Tools.Assets;
import com.badlogic.gdx.math.Vector3;

public class GameoverScreen implements Screen {
    final HighCastle game;
    OrthographicCamera camera;
    static int x, y;
    Vector3 touch;

    public GameoverScreen(final HighCastle game) {
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
        game.batch.draw(Assets.sprite_gameover, 0, 0);
        game.batch.end();
        if(Gdx.input.isTouched()){
            touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touch);
            x = (int)touch.x;
            y = (int)touch.y;
        }
        if (x>750){
            game.setScreen(new MainMenu(game));
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
