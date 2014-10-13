package com.HiS.screen;

import com.HiS.game.HorseGame;
import com.HiS.hishelpers.AssetLoader;
import com.HiS.world.GameWorld;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class StartMenu implements Screen {
	private GameWorld world;
	private GameScreen screen;

	private final Game game;
	private Texture texture;
	private SpriteBatch sprite;

	private long gallopSoundID;

	public static float gameHeight;
	public static float gameWidth = 136;
	public static int screenWidth = Gdx.graphics.getWidth();
	public static int screenHeight = Gdx.graphics.getHeight();

	public StartMenu(Game g) {

		StartMenu.gameHeight = screenHeight / (screenWidth / gameWidth);

		this.game = g;

	}

	@Override
	public void render(float arg0) {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		this.sprite.enableBlending();
		this.sprite.begin();
		this.sprite.draw(this.texture, gameWidth / 2 + this.texture.getWidth()
				/ 2, gameHeight / 2);
		this.sprite.end();

		if (Gdx.input.justTouched()) {
			this.game.setScreen(new GameScreen());
			this.gallopSoundID = AssetLoader.gallopSound
					.loop(HorseGame.gallopVol);
		}

	}

	@Override
	public void show() {
		this.sprite = new SpriteBatch();
		this.texture = new Texture(Gdx.files.internal("data/his_logo2.png"));

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
	public void resize(int arg0, int arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

}