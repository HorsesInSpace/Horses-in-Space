package com.HiS.game;

import com.HiS.hishelpers.AssetLoader;
import com.HiS.screen.StartMenu;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

/**
 * The game class, which also sets the screen and loads the assets used by the
 * application
 * 
 * @author Morten
 * @version 0.1
 */
public class HorseGame extends Game {

	public static enum Platform {
		ANDROID, DESKTOP, HTML, IOS
	}

	public static Platform platform;

	public static float musicVol, gallopVol, soundVol, thunderVol;

	public HorseGame(Platform platform) {
		HorseGame.platform = platform;
	}

	public static long gallopSoundID;

	/**
	 * Method called upon game launch
	 */
	@Override
	public void create() {
		Gdx.app.log("Game", "created");
		AssetLoader.load();
		try {
			Thread.sleep(100);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		setScreen(new StartMenu(this));

		switch (platform) {
		case ANDROID:
			thunderVol = 0.2f;
			musicVol = 1f;
			gallopVol = 0.6f;
			soundVol = 1;

			// AssetLoader.gallopMusic.setLooping(true);
			// AssetLoader.gallopMusic.setVolume(gallopVol);
			// AssetLoader.gallopMusic.play();
			break;
		case DESKTOP:
			thunderVol = 0.2f; // Don't work I guess :S
			musicVol = 1;
			gallopVol = 0.6f;
			soundVol = 1;
			// AssetLoader.gallopMusic.setLooping(true);
			// AssetLoader.gallopMusic.setVolume(gallopVol);
			// AssetLoader.gallopMusic.play();
			// AssetLoader.gallopSound.loop(gallopVol);
			break;
		default:
			thunderVol = 1;
			musicVol = 1;
			gallopVol = 0.6f;
			soundVol = 1;
			break;
		}
		AssetLoader.thunder1.setVolume(gallopSoundID, thunderVol);
		AssetLoader.thunder1.play();
		AssetLoader.moon.setLooping(true);
		AssetLoader.moon.setVolume(musicVol);
		AssetLoader.moon.play();
	}

	/**
	 * Method called on application close, gets rid of assets from memory.
	 */
	@Override
	public void dispose() {
		super.dispose();
		AssetLoader.dispose();
	}

}
