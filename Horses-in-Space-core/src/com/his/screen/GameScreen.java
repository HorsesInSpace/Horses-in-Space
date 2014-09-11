package com.HiS.screen;

import com.HiS.world.GameRenderer;
import com.HiS.world.GameWorld;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

public class GameScreen implements Screen {
	
	private GameWorld world;
	private GameRenderer renderer;
	
	public GameScreen() {
		Gdx.app.log("GameScreen", "CREATED");
		
		int screenWidth = Gdx.graphics.getWidth();
		int screenHeight = Gdx.graphics.getHeight();
		float gameWidth = 136;
		float gameHeight = screenHeight / (screenWidth / gameWidth);
		
		this.world = new GameWorld();
		
		this.renderer = new GameRenderer(this.world, gameWidth, gameHeight);
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
		this.world.update(delta);
		this.renderer.render();
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