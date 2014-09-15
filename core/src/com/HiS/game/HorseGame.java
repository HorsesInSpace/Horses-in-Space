package com.HiS.game;

import com.HiS.hishelpers.AssetLoader;
import com.HiS.screen.GameScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

public class HorseGame extends Game {

	@Override
	public void create() {
		// TODO Auto-generated method stub
		Gdx.app.log("Game", "created");
		AssetLoader.load();
		setScreen(new GameScreen());
	}
	
	@Override
	public void dispose() {
		super.dispose();
		AssetLoader.dispose();
	}

}
