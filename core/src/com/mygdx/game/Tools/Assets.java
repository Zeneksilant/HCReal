package com.mygdx.game.Tools;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

public class Assets {
    // фон MainMenu
    public static Texture texture_back;
    public static Sprite sprite_back;
    // главный герой
    public static Texture texture_sam;
    public static Sprite Samurai;
    // дверь
    public static Texture texture_dtuw;
    public static Sprite doortouw;
    // карта орода
    public static TiledMap townmap;
    public static TmxMapLoader mapLoader;
    // карта пригорода
    public static TiledMap uverworld;

    public static void load() {
        texture_back = new Texture(Gdx.files.internal("backgrounds/MM-for-TLG.png"));
        texture_back.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        sprite_back = new Sprite(texture_back);

        texture_sam = new Texture(Gdx.files.internal("Samurai1.png"));
        Samurai = new Sprite(texture_sam);

        texture_dtuw = new Texture(Gdx.files.internal("dtuw.png"));
        doortouw = new Sprite(texture_dtuw);

        mapLoader = new TmxMapLoader();
        townmap = mapLoader.load("maps/town.tmx");
        uverworld = mapLoader.load("maps/uverworld.tmx");
    }
}
