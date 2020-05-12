package com.mygdx.game.Sceens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.mygdx.game.HighCastle;
import com.mygdx.game.Tools.Assets;

public class Story5 implements Screen {
    final HighCastle game;
    OrthographicCamera camera;
    int tt = 0;

    public Story5(final HighCastle game) {
        this.game = game;

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
        game.batch.draw(Assets.sprite_story5, 0, 0);
        game.batch.end();

        if (Gdx.input.isTouched()){
            tt++;
        }
        if(tt>20){
            game.setScreen(new CastleThirdRoom(game));
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
