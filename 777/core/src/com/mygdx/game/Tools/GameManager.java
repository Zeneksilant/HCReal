package com.mygdx.game.Tools;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public class GameManager {
    public static Button ActionButtonClass;

    static Texture ActionButtonTexture;
    public static Vector3 temp = new Vector3(); // временный вектор для хранения входных координат

    private static final float BUTTON_RESIZE_FACTOR = 2500f;
    // правая и левая кнопка

    //Верхняя и нижняя
    private static final float BUTTONS_ACTION_HORIZ = 8;
    private static final float BUTTONS_ACTION_VERT = 6;

    public static float width, height;

    public static void initialize(float width, float height) {
        GameManager.width = width;
        GameManager.height = height;
        ActionButtonTexture = new Texture(Gdx.files.internal("Buttons/circle.png"));

        ActionButtonClass = new Button();

        initButtons();
    }

    public static void renderGame(SpriteBatch batch) {
        ActionButtonClass.render(batch);
    }
    public static void dispose(){
        ActionButtonTexture.dispose();
    }

    public static void initButtons() {
        ActionButtonClass.position.set(1600, 30);

        ActionButtonClass.ActionButtonSprite = new Sprite(ActionButtonTexture);

        ActionButtonClass.width = ActionButtonClass.ActionButtonSprite.getWidth() * (width/BUTTON_RESIZE_FACTOR);
        ActionButtonClass.height = ActionButtonClass.ActionButtonSprite.getHeight() * (width/BUTTON_RESIZE_FACTOR);

        ActionButtonClass.ActionButtonSprite.setSize(300, 300);

        ActionButtonClass.ActionButtonSprite.setPosition(ActionButtonClass.position.x, ActionButtonClass.position.y);
    }
}
