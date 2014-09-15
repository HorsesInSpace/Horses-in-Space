package com.HiS.game;

import com.HiS.hishelpers.AssetLoader;
import com.HiS.screen.GameScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

/**
 * The game class, which also sets the screen and 
 * loads the assets used by the application
 * @author Morten
 * @version 0.1
 */
public class HorseGame extends Game {

	/**
	 * Method called upon game launch
	 */
	@Override
	public void create() {
		// TODO Auto-generated method stub
		Gdx.app.log("Game", "created");
		AssetLoader.load();
		setScreen(new GameScreen());
		AssetLoader.badHorsie.play();
	}
	
	/**
	 * Method called on application close, gets rid of
	 * assets from memory.
	 */
	@Override
	public void dispose() {
		super.dispose();
		AssetLoader.dispose();
	}

}
