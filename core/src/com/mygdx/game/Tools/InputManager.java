package com.mygdx.game.Tools;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;

import static com.mygdx.game.Tools.Assets.Sword;
import static com.mygdx.game.Tools.GameManager.ButtonDownClass;
import static com.mygdx.game.Tools.GameManager.ButtonLeftClass;
import static com.mygdx.game.Tools.GameManager.ButtonRightClass;
import static com.mygdx.game.Tools.GameManager.ButtonUpClass;
import static com.mygdx.game.Tools.GameManager.ActionButtonClass;

public class InputManager {
    public static void handleInput(OrthographicCamera camera, Sprite sprite) {
        if (Gdx.input.justTouched()) {
            // Получаем координаты касания
            // И устанавливаем значения координат в вектор temp
            GameManager.temp.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            // получаем координаты касания
            // относительно области просмотра нашей "камеры"
            camera.unproject(GameManager.temp);
            float touchX = GameManager.temp.x;
            float touchY = GameManager.temp.y;


            if ((touchX >= ButtonUpClass.position.x) && touchX <= (ButtonUpClass.position.x + ButtonUpClass.width) && (touchY >= ButtonUpClass.position.y) && touchY <= (ButtonUpClass.position.y + ButtonUpClass.height)) {

                sprite.translateY(60.0f);
            }
            if ((touchX >= ButtonDownClass.position.x) && touchX <= (ButtonDownClass.position.x + ButtonDownClass.width) && (touchY >= ButtonDownClass.position.y) && touchY <= (ButtonDownClass.position.y + ButtonDownClass.height)) {

                sprite.translateY(-60.0f);

            }
            if ((touchX >= ButtonRightClass.position.x) && touchX <= (ButtonRightClass.position.x + ButtonRightClass.width) && (touchY >= ButtonRightClass.position.y) && touchY <= (ButtonRightClass.position.y + ButtonRightClass.height)) {
                sprite.translateX(60.0f);
            }
            if ((touchX >= ButtonLeftClass.position.x) && touchX <= (ButtonLeftClass.position.x + ButtonLeftClass.width) && (touchY >= ButtonLeftClass.position.y) && touchY <= (ButtonLeftClass.position.y + ButtonLeftClass.height)) {
                sprite.translateX(-60.0f);
            }
            if((touchX >= ActionButtonClass.position.x) && touchX <= (ActionButtonClass.position.x + ActionButtonClass.width) && (touchY >= ActionButtonClass.position.y) && touchY <= (ActionButtonClass.position.y + ActionButtonClass.height)){
                Sword.rotate90(true);
            }
        }


    }
}
