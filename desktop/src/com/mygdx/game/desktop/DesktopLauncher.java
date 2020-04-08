package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.HighCastle;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "HighCastle";
		config.useGL30 = true;
		config.width = 480;
		config.height = 320;
		new LwjglApplication(new HighCastle(), config);
	}
}
