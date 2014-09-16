package com.HiS.game.desktop;

import java.awt.Toolkit;

import com.HiS.game.HorseGame;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		
		config.title = "Horses in Space";
		config.width = Toolkit.getDefaultToolkit().getScreenSize().width/2;
		config.height = Toolkit.getDefaultToolkit().getScreenSize().height/2;
		
		config.fullscreen = false;
		new LwjglApplication(new HorseGame(), config);
	}
}
