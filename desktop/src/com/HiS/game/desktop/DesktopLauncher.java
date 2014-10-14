package com.HiS.game.desktop;

import java.awt.Toolkit;

import com.HiS.game.HorseGame;
import com.badlogic.gdx.Files.FileType;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopLauncher {
	public static void main(String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.title = "Horses in Space";
		config.width = Toolkit.getDefaultToolkit().getScreenSize().width / 2;
		config.height = Toolkit.getDefaultToolkit().getScreenSize().height / 2;

		float ratio = (float) config.width / (float) config.height;

		if (ratio < 1.7) {
			config.height = 675;
			config.width = 1200;
		}

		config.addIcon("data/gfx/his_logo2_128.png", FileType.Internal);
		config.addIcon("data/gfx/his_logo2_32.png", FileType.Internal);
		config.addIcon("data/gfx/his_logo2_16.png", FileType.Internal);
		new LwjglApplication(new HorseGame(HorseGame.Platform.DESKTOP), config);
	}
}
