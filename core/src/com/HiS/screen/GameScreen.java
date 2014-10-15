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
	public static float gameHeight;
	public static float gameWidth = 136;
	public static int screenWidth = Gdx.graphics.getWidth();
	public static int screenHeight = Gdx.graphics.getHeight();
	public static boolean running = true;
	
	public Stage stage;
	
	public TextureAtlas buttonAtlas, pbuttonAtlas;
	public ImageButtonStyle buttonStyle,pbuttonStyle;
	public ImageButton button,pbutton;
	Skin skin,pskin;
	
	public float runTime;
	
	
	
	public GameScreen() {
		Gdx.app.log("GameScreen", "CREATED");

		GameScreen.gameHeight = screenHeight / (screenWidth / gameWidth);
		this.runTime = 0;
		this.world = new GameWorld();
		this.stage = new Stage();
		
		this.renderer = new GameRenderer(this.world);
		
//		Gdx.input.setInputProcessor(new InputHandler(this.world, this));
		
		InputProcessor inputProcessorTwo = new InputHandler(this.world, this);
		InputMultiplexer inputMultiplexer = new InputMultiplexer();
		inputMultiplexer.addProcessor(stage);
		inputMultiplexer.addProcessor(inputProcessorTwo);
		Gdx.input.setInputProcessor(inputMultiplexer);
		
		
	

		
		
		skin = new Skin();
		buttonAtlas = new TextureAtlas("data/buttons/button.pack");
		skin.addRegions(buttonAtlas);
		
		pskin = new Skin();
		pbuttonAtlas = new TextureAtlas("data/buttons/pbutton.pack");
		pskin.addRegions(pbuttonAtlas);
		
		
		buttonStyle = new ImageButtonStyle();
		buttonStyle.up = skin.getDrawable("button");
		buttonStyle.checked = skin.getDrawable("buttonpressed");
		
		pbuttonStyle = new ImageButtonStyle();
		pbuttonStyle.up = pskin.getDrawable("pbutton");
		pbuttonStyle.checked = pskin.getDrawable("pbuttonpressed");
		
		
		button = new ImageButton(buttonStyle);
		stage.addActor(button);
		
		pbutton = new ImageButton(pbuttonStyle);
		stage.addActor(pbutton);
		
		
		
		button.setPosition(5, 5);
		pbutton.setPosition(Gdx.graphics.getWidth() - 23,5);
		
//		Gdx.input.setInputProcessor(stage);
		
		button.addListener(new InputListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				// TODO Auto-generated method stub
				System.out.print("Button clicked ");
				return true;
			}
			
		});
		
		pbutton.addListener(new InputListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				// TODO Auto-generated method stub
				System.out.print("PButton clicked ");
				world.setPause(!world.getPause());
				return true;
				
			}
		});
		
		
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
		if (running) this.world.update(delta, runTime);
		this.renderer.render(delta, runTime);
		stage.draw();
		stage.act();
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
