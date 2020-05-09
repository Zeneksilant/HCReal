package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Sceens.FirstScreen;
import com.mygdx.game.Sceens.WelcomeScreen;
import com.mygdx.game.Tools.Assets;

public class HighCastle extends Game {

	public SpriteBatch batch;
	public FirstScreen game_screen;
	public WelcomeScreen mm;
	public BitmapFont font;

	@Override
	public void create() {
		Assets.load();
		font = new BitmapFont();
		batch = new SpriteBatch();
		mm = new WelcomeScreen(this);
		setScreen(mm);
	}

	@Override
	public void render() {
		super.render();
	}

	@Override
	public void dispose(){
		super.dispose();
		batch.dispose();
		font.dispose();
	}
}