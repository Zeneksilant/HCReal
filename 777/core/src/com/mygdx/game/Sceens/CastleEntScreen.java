package com.mygdx.game.Sceens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.HighCastle;
import com.mygdx.game.Tools.GameManager;
import com.mygdx.game.Unit;

import static com.mygdx.game.Tools.Assets.CEgate;
import static com.mygdx.game.Tools.Assets.Enterance;
import static com.mygdx.game.Tools.Assets.Grave;
import static com.mygdx.game.Tools.Assets.Samurai;
import static com.mygdx.game.Tools.Assets.Sword;
import static com.mygdx.game.Tools.Assets.dog1;
import static com.mygdx.game.Tools.Assets.doortouw;
import static com.mygdx.game.Tools.Assets.joystickArea;
import static com.mygdx.game.Tools.Assets.texture_dog1;
import static com.mygdx.game.Tools.Assets.texture_grave;
import static com.mygdx.game.Tools.Assets.texture_sam;
import static com.mygdx.game.Tools.Assets.townmap;
import static com.mygdx.game.Tools.GameManager.ActionButtonClass;

public class CastleEntScreen implements Screen, InputProcessor {
    HighCastle game;
    SpriteBatch batch;
    Texture img = texture_sam;
    Texture dd = texture_dog1;
    float size = 50;
    int count = 5;
    int samX = 960 - 64;
    int samY = 540 - 64;
    Vector3 touch;
    private Unit[] units = new Unit[count];
    public static final float UNIT_SCALE = 9;
    private World world;
    private OrthographicCamera camera = new OrthographicCamera();
    private OrthogonalTiledMapRenderer renderer;
    private Stage stage = new Stage();
    private float w,h;
    private int NU = 5;

    public CastleEntScreen(HighCastle game) {
        this.game = game;
        batch = new SpriteBatch();
        renderer = new OrthogonalTiledMapRenderer(Enterance);
        camera.setToOrtho(false, 1920, 1080);
        world = new World(new Vector2(), false);
        //box2DDebugRenderer =new Box2DDebugRenderer();
        touch = new Vector3();

        units[0] = new Unit(1800, 600, world, Samurai);
        units[1] = new Unit(350, 600, world, new Sprite(texture_dog1, 200, 200));
        units[2] = new Unit(300, 675, world, new Sprite(texture_dog1, 200, 200));
        units[3] = new Unit(350, 675, world, new Sprite(texture_dog1, 200, 200));
        units[4] = new Unit(500, 450, world, new Sprite(texture_dog1, 200, 200));
        units[0].applyForce(new Vector2(100000, 0));

        stage.addActor(joystickArea);
        InputMultiplexer multiplexer = new InputMultiplexer();
        multiplexer.addProcessor(stage);
        multiplexer.addProcessor(this);
        Gdx.input.setInputProcessor(multiplexer);
        w = Gdx.graphics.getWidth();
        h = Gdx.graphics.getWidth();
        GameManager.initialize(w, h);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if(joystickArea.isJoystickDown()){
            float x = 100 * joystickArea.getValueX();
            float y = 100 * joystickArea.getValueY();
            units[0].setVelocity(x, y);
            units[1].setVelocity(-x+100, y);
            units[2].setVelocity(-x+100, y);
            units[3].setVelocity(-x+100, y);
            units[4].setVelocity(-x+100, y);
        }
        else{
            units[0].setVelocity(0, 0);
            units[1].setVelocity(100, 0);
            units[2].setVelocity(100, 0);
            units[3].setVelocity(100, 0);
            units[4].setVelocity(100, 0);
        }
        world.step(delta, 4, 4);

        camera.update();
        renderer.setView(camera);
        renderer.render();
        generalupdate(touch, camera);
        batch.setProjectionMatrix(camera.combined);

        batch.begin();

        GameManager.renderGame(batch);

        //batch.draw(img, 20, 20, size * UNIT_SCALE, size * UNIT_SCALE);
        for (int i = 0; i < count; i++) {
            units[i].draw(batch);
        }

        if (Gdx.input.justTouched()) {

            GameManager.temp.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(GameManager.temp);
            float touchX = GameManager.temp.x;
            float touchY = GameManager.temp.y;

            if(((touchX >= ActionButtonClass.position.x) && touchX <= (ActionButtonClass.position.x + ActionButtonClass.width) && (touchY >= ActionButtonClass.position.y)
                    && touchY <= (ActionButtonClass.position.y + ActionButtonClass.height)) &&
                    ((units[0].getpX() < units[1].getpX()+200) && (units[0].getpX() > units[1].getpX()-200) && (units[0].getpY() < units[1].getpY()+200) && (units[0].getpY() > units[1].getpY()-200)) |
                            ((units[0].getpX() < units[2].getpX()+200) && (units[0].getpX() > units[2].getpX()-200) && (units[0].getpY() < units[2].getpY()+200) && (units[0].getpY() > units[2].getpY()-200)) |
                            ((units[0].getpX() < units[3].getpX()+200) && (units[0].getpX() > units[3].getpX()-200) && (units[0].getpY() < units[3].getpY()+200) && (units[0].getpY() > units[3].getpY()-200)) |
                            ((units[0].getpX() < units[4].getpX()+200) && (units[0].getpX() > units[4].getpX()-200) && (units[0].getpY() < units[4].getpY()+200) && (units[0].getpY() > units[4].getpY()-200))){
                batch.draw(Sword, units[0].getpX()-125, units[0].getpY()-50, 75, 75);
                Sword.rotate90(true);
                NU--;
            }
        }
        if(NU == 4){
            units[1]= new Unit(10000, 10000, world, new Sprite(texture_grave, 75, 75));
        }
        if(NU == 3){
            units[2]= new Unit(10000, 10000, world, new Sprite(texture_grave, 75, 75));
        }
        if(NU == 2){
            units[3]= new Unit(10000, 10000, world, new Sprite(texture_grave, 75, 75));
        }
        if(NU == 1){
            units[4]= new Unit(10000, 10000, world, new Sprite(texture_grave, 75, 75));
        }

        batch.end();

        stage.act(delta);
        stage.draw();
    }

    public void generalupdate(Vector3 touch, OrthographicCamera camera){
        if(Gdx.input.isTouched()){
            touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touch);
            samX = (int)touch.x;
            samY = (int)touch.y;
        }
        if(samX > 1900){
            game.setScreen(new FirstScreen(game));
            dispose();
        }
        if(units[0].getpX()<100){
            game.setScreen(new GameOverScreen(game));
            dispose();
        }
        if(units[0].getpX()>1820){
            game.setScreen(new FirstScreen(game));
            dispose();
        }
        if(units[0].getpY()<100){
            game.setScreen(new GameOverScreen(game));
            dispose();
        }
        if(units[0].getpY()>980){
            game.setScreen(new GameOverScreen(game));
            dispose();
        }
        if(((units[0].getpX() < units[1].getpX()+100) && (units[0].getpX() > units[1].getpX()-100) && (units[0].getpY() < units[1].getpY()+100) && (units[0].getpY() > units[1].getpY()-100)) |
                ((units[0].getpX() < units[2].getpX()+100) && (units[0].getpX() > units[2].getpX()-100) && (units[0].getpY() < units[2].getpY()+100) && (units[0].getpY() > units[2].getpY()-100)) |
                ((units[0].getpX() < units[3].getpX()+100) && (units[0].getpX() > units[3].getpX()-100) && (units[0].getpY() < units[3].getpY()+100) && (units[0].getpY() > units[3].getpY()-100)) |
                ((units[0].getpX() < units[4].getpX()+100) && (units[0].getpX() > units[4].getpX()-100) && (units[0].getpY() < units[4].getpY()+100) && (units[0].getpY() > units[4].getpY()-100))){
            game.setScreen(new GameOverScreen(game));
            dispose();
        }
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
