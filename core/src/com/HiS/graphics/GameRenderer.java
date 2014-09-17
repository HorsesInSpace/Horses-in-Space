package com.HiS.graphics;

import com.HiS.gameobject.PhysGameObject;
import com.HiS.hishelpers.AssetLoader;
import com.HiS.world.GameWorld;
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
	
	private TextureRegion backGround, ground, middleground1;
	
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
	
	public void render(float delta, float runTime) {
		Gdx.gl.glClearColor(255, 255, 0, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.begin();

		batch.disableBlending();
		batch.draw(backGround, 0, -10, width, height);
		batch.enableBlending();
		batch.draw(middleground1, 0, 30, width, height/4);
		for(PhysGameObject gameObject : world.getObjects()) {
			batch.draw(gameObject.getTexture(),
	                gameObject.getPhysics().getRect().x, 
	                gameObject.getPhysics().getRect().y, 
	                gameObject.getPhysics().getRect().width, 
	                gameObject.getPhysics().getRect().height);
		}
		
		renderTime += delta;
		if(renderTime*65 >= width) {
			renderTime = 0;
		}
		batch.disableBlending();
		batch.draw(ground, 0-(renderTime*65), height-15, width+2, 15);
		batch.draw(ground, width-(renderTime*65), height-15, width+2, 15);
		batch.end();
	}
	
	public void initAssets() {
		this.backGround = AssetLoader.backGround;
		this.ground = AssetLoader.ground;
		this.middleground1 = AssetLoader.middleground1;
	}
}
