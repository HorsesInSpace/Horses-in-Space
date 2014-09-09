package com.HiS.game.desktop;

import com.HiS.game.MyHorseGame;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Horses in Space";
		config.width = 400;
		config.height = 240;
		new LwjglApplication(new MyHorseGame(), config);
	}
}
