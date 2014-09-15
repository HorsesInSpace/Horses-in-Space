package com.HiS.world;

import java.util.List;

import com.HiS.hishelpers.AssetLoader;
import com.HiS.physics.PhysObject;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class GameRenderer {
	
	private float renderTime;
	
	private ShapeRenderer shapeRenderer;
	private SpriteBatch batch;
	
	private GameWorld world;
	private OrthographicCamera cam;
	
	private TextureRegion horse, backGround, ground;
	
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
		
		initAssets();
	}
	
	public void render(float delta, float runTime, List<? extends PhysObject> gameObjects) {
		Gdx.gl.glClearColor(255, 255, 0, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.begin();

		batch.disableBlending();
		batch.draw(backGround, 0, -10, width, height);
		batch.enableBlending();
		for(PhysObject gameObject : gameObjects) {
			batch.draw(horse,
	                gameObject.getPhysics().getPosition().x, 
	                gameObject.getPhysics().getPosition().y, 
	                gameObject.getPhysics().getWidth(), 
	                gameObject.getPhysics().getHeight());
		}
		
		renderTime += delta;
		if(renderTime*40 >= width) {
			renderTime = 0;
		}
		batch.disableBlending();
		batch.draw(ground, 0-(renderTime*40), height-15, width+2, 15);
		batch.draw(ground, width-(renderTime*40), height-15, width+2, 15);
		batch.end();
	}
	
	public void initAssets() {
		this.horse = AssetLoader.horse;
		this.backGround = AssetLoader.backGround;
		this.ground = AssetLoader.ground;
	}
}
