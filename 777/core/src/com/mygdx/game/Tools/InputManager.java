package com.mygdx.game.Tools;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;

import static com.mygdx.game.Tools.Assets.Sword;
import static com.mygdx.game.Tools.GameManager.ActionButtonClass;

public class InputManager {
    public static void handleInput(OrthographicCamera camera, Sprite Samurai) {
        if (Gdx.input.justTouched()) {
            // Получаем координаты касания
            // И устанавливаем значения координат в вектор temp
            GameManager.temp.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            // получаем координаты касания
            // относительно области просмотра нашей "камеры"
            camera.unproject(GameManager.temp);
            float touchX = GameManager.temp.x;
            float touchY = GameManager.temp.y;

            if((touchX >= ActionButtonClass.position.x) && touchX <= (ActionButtonClass.position.x + ActionButtonClass.width) && (touchY >= ActionButtonClass.position.y)
                    && touchY <= (ActionButtonClass.position.y + ActionButtonClass.height)){
                Sword.rotate90(true);
            }
        }


    }
}
