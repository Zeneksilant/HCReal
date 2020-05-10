package com.mygdx.game.Tools;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.mygdx.game.GameUI.JoystickArea;

import static com.mygdx.game.Sceens.Store.Blade;
import static com.mygdx.game.Sceens.Store.Bow;

public class Assets {
    // фон MainMenu
    public static Texture texture_back;
    public static Sprite sprite_back;
    public static Texture texture_backRus;
    public static Sprite sprite_backRus;
    public static Texture texture_backJP;
    public static Sprite sprite_backJP;
    //фон магазина
    public static Texture texture_store;
    public static Sprite sprite_store;
    public static Texture texture_storeRus;
    public static Sprite sprite_storeRus;
    public static Texture texture_storeJP;
    public static Sprite sprite_storeJP;
    // фон первого отрывка истории
    public static Texture texture_welcome;
    public static Sprite sprite_welcome;
    public static Texture texture_welcomerus;
    public static Sprite sprite_welcomerus;
    public static Texture texture_welcomejp;
    public static Sprite sprite_welcomejp;
    // фон второго отрыка истории
    public static Texture texture_story2;
    public static Sprite sprite_story2;
    public static Texture texture_story2rus;
    public static Sprite sprite_story2rus;
    public static Texture texture_story2jp;
    public static Sprite sprite_story2jp;
    //gameover фон
    public static Texture texture_gameover;
    public static Sprite sprite_gameover;
    //фон страницы выбора языка
    public static Texture texture_lang;
    public static Sprite LangSelect;
    // экран паузы
    public static Texture texture_pausescreen;
    public static Sprite pauseScreen;
    // иконка паузы
    public static Texture texture_pausebutton;
    public static Sprite pausebutton;
    // главный герой
    public static Texture texture_sam;
    public static Sprite Samurai;
    public static Texture texture_samEM;
    public static Sprite SamuraiEM;
    public static Texture texture_samBOW;
    public static Sprite SamuraiBOW;
    // враг собака
    public static Texture texture_dog1;
    public static Sprite dog1;
    // дверь
    public static Texture texture_dtuw;
    public static Sprite doortouw;
    public static Texture texture_CEgate;
    public static Sprite CEgate;
    //мечь
    public static Texture texture_sword;
    public static Sprite Sword;
    public static Texture texture_Emsword;
    public static Sprite EmSword;
    //смерть
    public static Texture texture_grave;
    public static Sprite Grave;
    // карта орода
    public static TiledMap townmap;
    public static TmxMapLoader mapLoader;
    // карта пригорода
    public static TiledMap uverworld;
    // карта входа в замок
    public static TiledMap Enterance;
    //стрела
    public static Texture texture_arrow;
    public static Sprite Arrow;
    //зона вокруг джойстика
    public static JoystickArea joystickArea;


    public static void load() {
        texture_back = new Texture(Gdx.files.internal("Backgrounds/MM-for-TLG.png"));
        texture_back.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        sprite_back = new Sprite(texture_back);
        texture_backRus = new Texture(Gdx.files.internal("Backgrounds/MM-for-TLGRus.png"));
        sprite_backRus = new Sprite(texture_backRus);
        texture_backJP = new Texture(Gdx.files.internal("Backgrounds/MM-for-TLGJP.png"));
        sprite_backJP = new Sprite(texture_backJP);

        texture_gameover = new Texture(Gdx.files.internal("Backgrounds/GameoverScreen.png"));
        sprite_gameover = new Sprite(texture_gameover);

        texture_lang = new Texture(Gdx.files.internal("Backgrounds/selectlanguage.png"));
        LangSelect = new Sprite(texture_lang);

        texture_welcome = new Texture(Gdx.files.internal("Backgrounds/Welcomepage.png"));
        sprite_welcome = new Sprite(texture_welcome);
        texture_welcomerus = new Texture(Gdx.files.internal("Backgrounds/WelcomePageRus.png"));
        sprite_welcomerus = new Sprite(texture_welcomerus);
        texture_welcomejp = new Texture(Gdx.files.internal("Backgrounds/WelcomePageJP.png"));
        sprite_welcomejp = new Sprite(texture_welcomejp);

        texture_story2 = new Texture(Gdx.files.internal("Backgrounds/story2.png"));
        sprite_story2 = new Sprite(texture_story2);
        texture_story2rus = new Texture(Gdx.files.internal("Backgrounds/story2Rus.png"));
        sprite_story2rus = new Sprite(texture_story2rus);
        texture_story2jp = new Texture(Gdx.files.internal("Backgrounds/story2JP.png"));
        sprite_story2jp = new Sprite(texture_story2jp);

        texture_store = new Texture(Gdx.files.internal("Backgrounds/store.png"));
        sprite_store = new Sprite(texture_store);
        texture_storeRus = new Texture(Gdx.files.internal("Backgrounds/storeRus.png"));
        sprite_storeRus = new Sprite(texture_storeRus);
        texture_storeJP = new Texture(Gdx.files.internal("Backgrounds/storeJP.png"));
        sprite_storeJP = new Sprite(texture_storeJP);

        texture_pausescreen = new Texture(Gdx.files.internal("Backgrounds/pausescreen.png"));
        pauseScreen = new Sprite(texture_pausescreen);

        texture_pausebutton = new Texture(Gdx.files.internal("Buttons/PauseIcon.png"));
        pausebutton = new Sprite(texture_pausebutton);

        texture_sam = new Texture(Gdx.files.internal("Samurai1.png"));
        Samurai = new Sprite(texture_sam);
        texture_samEM = new Texture(Gdx.files.internal("Samurai1EM.png"));
        SamuraiEM = new Sprite(texture_samEM);
        texture_samBOW = new Texture(Gdx.files.internal("Samurai1BOW.png"));
        SamuraiBOW = new Sprite(texture_samBOW);

        texture_dog1 = new Texture(Gdx.files.internal("Enemies/Dog1.png"));
        dog1 = new Sprite(texture_dog1);

        texture_dtuw = new Texture(Gdx.files.internal("dtuw.png"));
        doortouw = new Sprite(texture_dtuw);

        texture_CEgate = new Texture(Gdx.files.internal("CEgate.png"));
        CEgate = new Sprite(texture_CEgate);

        texture_sword = new Texture(Gdx.files.internal("sword.png"));
        Sword = new Sprite(texture_sword);
        texture_Emsword = new Texture(Gdx.files.internal("EmeraldSW.png"));
        EmSword = new Sprite(texture_Emsword);
        texture_arrow = new Texture(Gdx.files.internal("Arrow.png"));
        Arrow = new Sprite(texture_arrow);

        texture_grave = new Texture(Gdx.files.internal("dead.png"));
        Grave = new Sprite(texture_grave, 100, 100);

        Texture circle = new Texture("Buttons/jcircle.png");
        Texture curJoystick = new Texture("Buttons/JoyStickKrug.png");
        joystickArea = new JoystickArea(circle, curJoystick);

        mapLoader = new TmxMapLoader();
        townmap = mapLoader.load("Maps/town.tmx");
        uverworld = mapLoader.load("Maps/uverworld.tmx");
        Enterance = mapLoader.load("Maps/CastleEntry.tmx");
    }
}
