package com.HiS.screen;

import com.HiS.graphics.GameRenderer;
import com.HiS.hishelpers.InputHandler;
import com.HiS.world.GameWorld;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

public class GameScreen implements Screen {
	
	private GameWorld world;
	private GameRenderer renderer;
	public static float gameHeight;
	public static float gameWidth = 136;
	public float runTime;
	
	public GameScreen() {
		Gdx.app.log("GameScreen", "CREATED");
		
		int screenWidth = Gdx.graphics.getWidth();
		int screenHeight = Gdx.graphics.getHeight();

		GameScreen.gameHeight = screenHeight / (screenWidth / gameWidth);
		this.runTime = 0;
		this.world = new GameWorld();
		
		this.renderer = new GameRenderer(this.world, gameWidth, gameHeight);
		
		Gdx.input.setInputProcessor(new InputHandler(this.world));
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
		runTime += delta;
		this.world.update(delta);
		this.renderer.render(delta, runTime);
	}

	@Override
	public void resize(int arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

}
