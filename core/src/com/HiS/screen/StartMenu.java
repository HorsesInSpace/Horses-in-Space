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
	private float alpha;

	private long gallopSoundID;

	public static float gameHeight;
	public static float gameWidth = 136;
	public static int screenWidth = Gdx.graphics.getWidth();
	public static int screenHeight = Gdx.graphics.getHeight();

	public StartMenu(Game g) {

		StartMenu.gameHeight = screenHeight / (screenWidth / gameWidth);

		this.game = g;

		this.alpha = 0;

	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		this.alpha += delta / 4;
		if (this.alpha >= 1) {
			this.sprite.setColor(1, 1, 1, 1);
		} else {
			this.sprite.setColor(1, 1, 1, this.alpha);
		}

		this.sprite.enableBlending();
		this.sprite.begin();
		this.sprite.draw(this.texture,
				(screenWidth / 2) - (this.texture.getWidth() / 2),
				(screenHeight / 2) - (this.texture.getHeight() / 2));
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
		this.texture = new Texture(Gdx.files.internal("data/logo-black.png"));

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