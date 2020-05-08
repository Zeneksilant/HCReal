package com.mygdx.game.Tools;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Button {
    static Sprite ActionButtonSprite;
    public Vector2 position = new Vector2();

    public float height;
    public float width;

    public void render(SpriteBatch batch){
        ActionButtonSprite.draw(batch);

    }
}
