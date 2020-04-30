package com.mygdx.game.Tools;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Button {
    static Sprite ButtonUpSprite;
    static Sprite ButtonDownSprite;
    static Sprite ButtonRightSprite;
    static Sprite ButtonLeftSprite;
    static Sprite ActionButtonSprite;
    public Vector2 position = new Vector2();

    public float height;
    public float width;

    public void render(SpriteBatch batch){
        ButtonUpSprite.draw(batch);
        ButtonDownSprite.draw(batch);
        ButtonRightSprite.draw(batch);
        ButtonLeftSprite.draw(batch);
        ActionButtonSprite.draw(batch);

    }
}
