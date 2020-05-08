package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.Sceens.FirstScreen;

public class Unit {
    private Body body;
    private Sprite sprite;

    public static final float RADIUS = 20f;

    public Unit(float x, float y, World world, Sprite sprite){
        body = createCircle(x, y, 60,  world);
        this.sprite = sprite;
        body.setLinearDamping(1);
    }


    public void draw(SpriteBatch batch){
        float divR = RADIUS *  FirstScreen.UNIT_SCALE;
        batch.draw(sprite, body.getPosition().x - divR, body.getPosition().y - divR, 300, 300);
    }

    public float getpX(){
        return body.getPosition().x;
    }

    public float getpY(){
        return body.getPosition().y;
    }

    public void applyForce(Vector2 v){
        body.applyForceToCenter(v, true);

    }

    public void setVelocity(float x, float y){
        body.setLinearVelocity(x, y);
    }

    private Body createCircle(float x, float y, float radius, World world){
        BodyDef def = new BodyDef();
        def.type = BodyDef.BodyType.DynamicBody;
        def.fixedRotation = true;
        Body body = world.createBody(def);

        CircleShape circle = new CircleShape();
        circle.setPosition(new Vector2(0, 0));
        circle.setRadius(radius);
        Fixture f = body.createFixture(circle, 1f);
        circle.dispose();

        body.setTransform(x, y, 0);

        return body;
    }
}
