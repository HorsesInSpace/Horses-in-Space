package com.HiS.game;

import com.HiS.screen.GameScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

public class HorseGame extends Game {

	@Override
	public void create() {
		// TODO Auto-generated method stub
		Gdx.app.log("Game", "created");
		
		
		
		setScreen(new GameScreen());
	}

}
