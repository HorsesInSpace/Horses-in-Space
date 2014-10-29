package com.HiS.screen;

import com.HiS.graphics.GameRenderer;
import com.HiS.hishelpers.InputHandler;
import com.HiS.world.GameWorld;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class GameScreen implements Screen {

	private GameWorld world;
	private GameRenderer renderer;
	public static float gameHeight = 76.5f;
	public static float gameWidth;
	public static int screenWidth = Gdx.graphics.getWidth();
	public static int screenHeight = Gdx.graphics.getHeight();
	public static boolean running = true;

	public InputMultiplexer inputMultiplexer = new InputMultiplexer();
	public InputProcessor inputProcessorTwo;

	public Stage stage;

	public TextureAtlas buttonAtlas, pbuttonAtlas;
	public ImageButtonStyle buttonStyle, pbuttonStyle;
	public ImageButton soundButton, pauseButton;
	Skin skin, pskin;

	public float runTime;

	public GameScreen() {
		Gdx.app.log("GameScreen", "CREATED");

		GameScreen.gameWidth = screenWidth / (screenHeight / gameHeight);
		this.runTime = 0;
		this.world = new GameWorld();
		this.stage = new Stage();

		this.renderer = new GameRenderer(this.world);

		// Gdx.input.setInputProcessor(new InputHandler(this.world, this));

		this.inputProcessorTwo = new InputHandler(this.world, this);

		this.inputMultiplexer.addProcessor(this.stage);
		this.inputMultiplexer.addProcessor(this.inputProcessorTwo);
		Gdx.input.setInputProcessor(this.inputMultiplexer);

		this.skin = new Skin();
		this.buttonAtlas = new TextureAtlas("data/buttons/button.pack");
		this.skin.addRegions(this.buttonAtlas);

		this.pskin = new Skin();
		this.pbuttonAtlas = new TextureAtlas("data/buttons/pbutton.pack");
		this.pskin.addRegions(this.pbuttonAtlas);

		this.buttonStyle = new ImageButtonStyle();
		this.buttonStyle.up = this.skin.getDrawable("button");
		this.buttonStyle.checked = this.skin.getDrawable("buttonpressed");

		this.pbuttonStyle = new ImageButtonStyle();
		this.pbuttonStyle.up = this.pskin.getDrawable("pbutton");
		this.pbuttonStyle.checked = this.pskin.getDrawable("pbuttonpressed");

		this.soundButton = new ImageButton(this.buttonStyle);
		this.stage.addActor(this.soundButton);

		this.pauseButton = new ImageButton(this.pbuttonStyle);
		this.stage.addActor(this.pauseButton);

		float sizeXRatio = GameScreen.screenHeight / GameScreen.gameHeight;
		float sizeYRatio = GameScreen.screenWidth / GameScreen.gameWidth;

		this.pauseButton.setSize(GameScreen.screenWidth / 16,
				GameScreen.screenWidth / 16);
		this.soundButton.setSize(GameScreen.screenWidth / 16,
				GameScreen.screenWidth / 16);

		this.pauseButton.setPosition(
				GameScreen.screenWidth - this.pauseButton.getWidth()
						- (this.pauseButton.getWidth() / 2),
				GameScreen.screenHeight - this.pauseButton.getHeight()
						- (this.pauseButton.getHeight() / 2));

		this.soundButton.setPosition(
				this.pauseButton.getX() - this.soundButton.getWidth()
						- (this.soundButton.getWidth() / 2),
				GameScreen.screenHeight - this.soundButton.getHeight()
						- (this.soundButton.getHeight() / 2));

		// Gdx.input.setInputProcessor(stage);

		this.soundButton.addListener(new InputListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				// TODO Auto-generated method stub
				System.out.print("Sound button clicked");

				return true;
			}

		});

		this.pauseButton.addListener(new InputListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				// TODO Auto-generated method stub
				System.out.print("Pause button clicked ");
				boolean paused = GameScreen.this.world.getPause();
				if (paused) {
					GameScreen.this.world.setPause(false);
				} else {
					GameScreen.this.world.setPause(true);
				}

				return true;

			}
		});
		// LARS: bare for å vise hvordan man fjerner inputProcessor, det funker
		// ikke inne i addListener fordi det går i separat klasse!

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
		this.runTime += delta;
		if (running)
			this.world.update(delta, this.runTime);
		this.renderer.render(delta, this.runTime);
		this.stage.draw();
		this.stage.act();
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
		// don't know why, but this helps the garbage collector with its
		// anorexia
		this.world = null;
		this.world = new GameWorld();
		this.renderer.setWorld(this.world);
		GameScreen.running = true;
		return this.world;
	}

}
