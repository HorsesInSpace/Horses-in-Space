package com.HiS.world;

import java.util.List;

import com.HiS.gameobject.GameObject;
import com.HiS.hishelpers.AssetLoader;
import com.HiS.screen.GameScreen;
import com.HiS.physics.PhysObject;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class GameRenderer {
	
	private ShapeRenderer shapeRenderer;
	private SpriteBatch batch;
	
	private GameWorld world;
	private OrthographicCamera cam;
	
	private float width, height;
	
	public GameRenderer(GameWorld world, float width, float height) {
		this.world = world;
		
		this.width = width;
		this.height = height;
		
		this.cam = new OrthographicCamera();
		this.cam.setToOrtho(true, width, height);
		
		this.batch = new SpriteBatch();
		this.batch.setProjectionMatrix(this.cam.combined);
		
		this.shapeRenderer = new ShapeRenderer();
		this.shapeRenderer.setProjectionMatrix(this.cam.combined);
	}
	
	public void render(float runTime, List<? extends PhysObject> gameObjects) {
		Gdx.gl.glClearColor(255, 255, 0, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.begin();

		batch.disableBlending();
		//batch.draw(AssetLoader.backGround, 0,0,width,height);
		batch.draw(AssetLoader.backGround, 0, 0, width, height);
		batch.enableBlending();
		for(PhysObject gameObject : gameObjects) {
			batch.draw(AssetLoader.horse,
	                gameObject.getPhysics().getPosition().x, 
	                gameObject.getPhysics().getPosition().y, 
	                gameObject.getPhysics().getWidth(), 
	                gameObject.getPhysics().getHeight());
		}
		batch.end();
	}
}
