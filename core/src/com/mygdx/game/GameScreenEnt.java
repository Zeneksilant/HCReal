package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.Tools.GameManager;
import com.mygdx.game.Tools.InputManager;

import static com.mygdx.game.Tools.Assets.CEgate;
import static com.mygdx.game.Tools.Assets.Enterance;
import static com.mygdx.game.Tools.Assets.Samurai;
import static com.mygdx.game.Tools.Assets.dog1;
import static com.mygdx.game.Tools.Assets.dog2;
import static com.mygdx.game.Tools.Assets.dog3;
import static com.mygdx.game.Tools.Assets.texture_dog1;
import static com.mygdx.game.Tools.Assets.texture_sam;
import static com.mygdx.game.Tools.Assets.uverworld;
import static com.mygdx.game.Tools.GameManager.ButtonDownClass;
import static com.mygdx.game.Tools.GameManager.ButtonLeftClass;
import static com.mygdx.game.Tools.GameManager.ButtonRightClass;
import static com.mygdx.game.Tools.GameManager.ButtonUpClass;

public class GameScreenEnt implements Screen {
    HighCastle game;
    OrthographicCamera camera;
    SpriteBatch batch;
    Vector3 touch;
    int samX;
    int samY;
    int dogX, dogY, dog2X, dog2Y, dog3X, dog3Y;
    OrthogonalTiledMapRenderer renderer;
    private float w, h;
    int ht;

    public GameScreenEnt(HighCastle game) {
        this.game = game;
        touch = new Vector3();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1920, 1080);

        batch = new SpriteBatch();
        renderer = new OrthogonalTiledMapRenderer(Enterance);
        samX = 960 - 64;
        samY = 540 - 64;
        dogX = 600;
        dogY = 600;
        dog2X = 300;
        dog2Y = 300;
        dog3X = 700;
        dog3Y = 700;
        ht = 3;
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
        batch.draw(dog2, dog2X, dog2Y);
        batch.draw(dog3, dog3X, dog3Y);
        batch.setProjectionMatrix(camera.combined);
        Samurai.draw(batch);
        GameManager.renderGame(batch);

        batch.end();

    }

    public void generalupdate(Vector3 touch, OrthographicCamera camera) {
        if(Gdx.input.isTouched()){
            touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touch);
            samX = (int)touch.x;
            samY = (int)touch.y;
        }
        if (samX > 1900) {
            game.setScreen(new GameScreen(game));
            dispose();
        }
            if(Gdx.input.justTouched()){
        // Получаем координаты касания
        // И устанавливаем значения координат в вектор temp
        GameManager.temp.set(Gdx.input.getX(), Gdx.input.getY(), 0);
        // получаем координаты касания
        // относительно области просмотра нашей "камеры"
        camera.unproject(GameManager.temp);
        float touchX = GameManager.temp.x;
        float touchY = GameManager.temp.y;

        if ((touchX >= ButtonUpClass.position.x) && touchX <= (ButtonUpClass.position.x + ButtonUpClass.width) && (touchY >= ButtonUpClass.position.y) && touchY <= (ButtonUpClass.position.y + ButtonUpClass.height)) {
            dogY -= 40; dog3Y -= 40; dog2Y += 40;
        }
        if ((touchX >= ButtonDownClass.position.x) && touchX <= (ButtonDownClass.position.x + ButtonDownClass.width) && (touchY >= ButtonDownClass.position.y) && touchY <= (ButtonDownClass.position.y + ButtonDownClass.height)) {
            dogY += 40; dog3Y -= 40; dog2Y -= 40;
        }
        if ((touchX >= ButtonRightClass.position.x) && touchX <= (ButtonRightClass.position.x + ButtonRightClass.width) && (touchY >= ButtonRightClass.position.y) && touchY <= (ButtonRightClass.position.y + ButtonRightClass.height)) {
            dogX -= 40; dog3X -= 40; dog2X += 40;
        }
        if ((touchX >= ButtonLeftClass.position.x) && touchX <= (ButtonLeftClass.position.x + ButtonLeftClass.width) && (touchY >= ButtonLeftClass.position.y) && touchY <= (ButtonLeftClass.position.y + ButtonLeftClass.height)) {
            dogX += 40; dog3X -= 40; dog2X -= 40;
        }
    }
        if((Samurai.getX() - dogX >10) | (Samurai.getX() - dog2X > 10) | (Samurai.getX() - dog3X > 10) | (Samurai.getY() - dogY == 10) | (Samurai.getY() - dog2Y == 10) | (Samurai.getY() - dog3Y == 10)){
            ht--;
        }
        if(ht==0){
            game.setScreen(new GameoverScreen(game));
            dispose();
        }
        if(GameoverScreen.x>750){
            game.setScreen(new GameScreenEnt(game));
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
