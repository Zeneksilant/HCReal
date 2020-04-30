package com.mygdx.game.Tools;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public class GameManager {
    public static Button ButtonUpClass;
    public static Button ButtonDownClass;
    public static Button ButtonRightClass;
    public static Button ButtonLeftClass;
    public static Button ActionButtonClass;

    static Texture ButtonDownTexture;
    static Texture ButtonUpTexture;
    static Texture ButtonRightTexture;
    static Texture ButtonLeftTexture;
    static Texture ActionButtonTexture;
    public static Vector3 temp = new Vector3(); // временный вектор для хранения входных координат

    private static final float BUTTON_RESIZE_FACTOR = 2500f;
    // правая и левая кнопка
    private static final float BUTTONS_RIGHT_VERT = 8.5f;
    private static final float BUTTONS_LEFT_VERT = 8.5f;
    private static final float BUTTONS_RIGHT_HORIZ = 6;
    private static final float BUTTONS_LEFT_HORIZ = 12;

    //Верхняя и нижняя
    private static final float BUTTONS_UP_HORIZ = 8;
    private static final float BUTTONS_DOWN_HORIZ = 8;
    private static final float BUTTONS_UP_VERT = 6;
    private static final float BUTTONS_DOWN_VERT = 16;

    private static final float BUTTONS_ACTION_HORIZ = 8;
    private static final float BUTTONS_ACTION_VERT = 6;

    public static float width, height;





    public static void initialize(float width, float height) {
        GameManager.width = width;
        GameManager.height = height;
        ButtonUpTexture = new Texture(Gdx.files.internal("Buttons/flatDark25.png"));
        ButtonDownTexture = new Texture(Gdx.files.internal("Buttons/flatDark26.png"));
        ButtonRightTexture = new Texture(Gdx.files.internal("Buttons/flatDark24.png"));
        ButtonLeftTexture = new Texture(Gdx.files.internal("Buttons/flatDark23.png"));
        ActionButtonTexture = new Texture(Gdx.files.internal("Buttons/circle.png"));

        ButtonUpClass = new Button();
        ButtonDownClass = new Button();
        ButtonRightClass = new Button();
        ButtonLeftClass = new Button();
        ActionButtonClass = new Button();

        initButtons();
    }

    public static void renderGame(SpriteBatch batch) {
        ButtonUpClass.render(batch);
        ButtonDownClass.render(batch);
        ButtonRightClass.render(batch);
        ButtonLeftClass.render(batch);
        ActionButtonClass.render(batch);
    }
    public static void dispose(){
        ButtonUpTexture.dispose();
        ButtonDownTexture.dispose();
        ButtonRightTexture.dispose();
        ButtonLeftTexture.dispose();
        ActionButtonTexture.dispose();
    }

    public static void initButtons() {

        ButtonUpClass.position.set(width/BUTTONS_UP_HORIZ, height/BUTTONS_UP_VERT);
        ButtonDownClass.position.set(width/BUTTONS_DOWN_HORIZ, height/BUTTONS_DOWN_VERT);
        ButtonRightClass.position.set(width/BUTTONS_RIGHT_HORIZ, height/BUTTONS_RIGHT_VERT);
        ButtonLeftClass.position.set(width/BUTTONS_LEFT_HORIZ, height/BUTTONS_LEFT_VERT);
        ActionButtonClass.position.set(1600, 30);




        ButtonUpClass.ButtonUpSprite = new Sprite(ButtonUpTexture);
        ButtonDownClass.ButtonDownSprite = new Sprite(ButtonDownTexture);
        ButtonRightClass.ButtonRightSprite = new Sprite(ButtonRightTexture);
        ButtonLeftClass.ButtonLeftSprite = new Sprite(ButtonLeftTexture);
        ActionButtonClass.ActionButtonSprite = new Sprite(ActionButtonTexture);

        ButtonUpClass.width = ButtonUpClass.ButtonUpSprite.getWidth() * (width/BUTTON_RESIZE_FACTOR);
        ButtonUpClass.height = ButtonUpClass.ButtonUpSprite.getHeight() * (width/BUTTON_RESIZE_FACTOR);
        ButtonDownClass.width = ButtonDownClass.ButtonDownSprite.getWidth() * (width/BUTTON_RESIZE_FACTOR);
        ButtonDownClass.height = ButtonDownClass.ButtonDownSprite.getHeight() * (width/BUTTON_RESIZE_FACTOR);
        ButtonRightClass.width = ButtonRightClass.ButtonRightSprite.getWidth() * (width/BUTTON_RESIZE_FACTOR);
        ButtonRightClass.height = ButtonRightClass.ButtonRightSprite.getHeight() * (width/BUTTON_RESIZE_FACTOR);
        ButtonLeftClass.width = ButtonLeftClass.ButtonLeftSprite.getWidth() * (width/BUTTON_RESIZE_FACTOR);
        ButtonLeftClass.height = ButtonLeftClass.ButtonLeftSprite.getHeight() * (width/BUTTON_RESIZE_FACTOR);
        ActionButtonClass.width = ActionButtonClass.ActionButtonSprite.getWidth() * (width/BUTTON_RESIZE_FACTOR);
        ActionButtonClass.height = ActionButtonClass.ActionButtonSprite.getHeight() * (width/BUTTON_RESIZE_FACTOR);

        ButtonUpClass.ButtonUpSprite.setSize(ButtonUpClass.width, ButtonUpClass.height);
        ButtonDownClass.ButtonDownSprite.setSize(ButtonDownClass.width, ButtonDownClass.height);
        ButtonRightClass.ButtonRightSprite.setSize(ButtonRightClass.width, ButtonRightClass.height);
        ButtonLeftClass.ButtonLeftSprite.setSize(ButtonLeftClass.width, ButtonLeftClass.height);
        ActionButtonClass.ActionButtonSprite.setSize(300, 300);

        ButtonUpClass.ButtonUpSprite.setPosition(ButtonUpClass.position.x, ButtonUpClass.position.y);
        ButtonDownClass.ButtonDownSprite.setPosition(ButtonDownClass.position.x, ButtonDownClass.position.y);
        ButtonRightClass.ButtonRightSprite.setPosition(ButtonRightClass.position.x, ButtonRightClass.position.y);
        ButtonLeftClass.ButtonLeftSprite.setPosition(ButtonLeftClass.position.x, ButtonLeftClass.position.y);
        ActionButtonClass.ActionButtonSprite.setPosition(ActionButtonClass.position.x, ActionButtonClass.position.y);
    }
}
