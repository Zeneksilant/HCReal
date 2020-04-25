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
    //gameover фон
    public static Texture texture_gameover;
    public static Sprite sprite_gameover;
    // экран паузы
    public static Texture texture_pausescreen;
    public static Sprite pauseScreen;
    // иконка паузы
    public static Texture texture_pausebutton;
    public static Sprite pausebutton;
    // главный герой
    public static Texture texture_sam;
    public static Sprite Samurai;
    // враг собака
    public static Texture texture_dog1;
    public static Sprite dog1;
    public static Sprite dog2;
    public static Sprite dog3;
    // дверь
    public static Texture texture_dtuw;
    public static Sprite doortouw;

    public static Texture texture_CEgate;
    public static Sprite CEgate;
    // карта орода
    public static TiledMap townmap;
    public static TmxMapLoader mapLoader;
    // карта пригорода
    public static TiledMap uverworld;
    // карта входа в замок
    public static TiledMap Enterance;


    public static void load() {
        texture_back = new Texture(Gdx.files.internal("backgrounds/MM-for-TLG.png"));
        texture_back.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        sprite_back = new Sprite(texture_back);

        texture_gameover = new Texture(Gdx.files.internal("backgrounds/GameoverScreen.png"));
        sprite_gameover = new Sprite(texture_gameover);

        texture_pausescreen = new Texture(Gdx.files.internal("backgrounds/pausescreen.png"));
        pauseScreen = new Sprite(texture_pausescreen);

        texture_pausebutton = new Texture(Gdx.files.internal("Buttons/PauseIcon.png"));
        pausebutton = new Sprite(texture_pausebutton);

        texture_sam = new Texture(Gdx.files.internal("Samurai1.png"));
        Samurai = new Sprite(texture_sam);

        texture_dog1 = new Texture(Gdx.files.internal("Enemies/Dog1.png"));
        dog1 = new Sprite(texture_dog1);
        dog2 = new Sprite(texture_dog1);
        dog3 = new Sprite(texture_dog1);

        texture_dtuw = new Texture(Gdx.files.internal("dtuw.png"));
        doortouw = new Sprite(texture_dtuw);

        texture_CEgate = new Texture(Gdx.files.internal("CEgate.png"));
        CEgate = new Sprite(texture_CEgate);

        mapLoader = new TmxMapLoader();
        townmap = mapLoader.load("maps/town.tmx");
        uverworld = mapLoader.load("maps/uverworld.tmx");
        Enterance = mapLoader.load("maps/CastleEntry.tmx");
    }
}
