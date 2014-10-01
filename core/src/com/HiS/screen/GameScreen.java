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
	public static int screenWidth = Gdx.graphics.getWidth();
	public static int screenHeight = Gdx.graphics.getHeight();
	public static boolean running = true;
	
	public float runTime;
	
	public GameScreen() {
		Gdx.app.log("GameScreen", "CREATED");

		GameScreen.gameHeight = screenHeight / (screenWidth / gameWidth);
		this.runTime = 0;
		this.world = new GameWorld();
		
		this.renderer = new GameRenderer(this.world);
		
		Gdx.input.setInputProcessor(new InputHandler(this.world, this));
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
		if (running) {
			this.world.update(delta, runTime);
			this.renderer.render(delta, runTime);
		}
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
	
	public GameWorld restart() {
		//don't know why, but this helps the garbage collector with its anorexia
		this.world = null;
		this.world = new GameWorld();
		this.renderer.setWorld(this.world);
		GameScreen.running = true;
		
		return this.world;
	}

}
