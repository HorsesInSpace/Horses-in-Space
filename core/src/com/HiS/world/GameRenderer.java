package com.HiS.world;

import java.util.List;

import com.HiS.gameobject.GameObject;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class GameRenderer {
	
	private ShapeRenderer shapeRenderer;
	
	private GameWorld world;
	private OrthographicCamera cam;
	
	private float width, height;
	
	public GameRenderer(GameWorld world, float width, float height) {
		this.world = world;
		
		this.width = width;
		this.height = height;
		
		this.cam = new OrthographicCamera();
		this.cam.setToOrtho(true, width, height);
		
		this.shapeRenderer = new ShapeRenderer();
		this.shapeRenderer.setProjectionMatrix(this.cam.combined);
	}
	
	public void render(List<GameObject> gameObjects) {
		Gdx.gl.glClearColor(255, 255, 0, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		for(GameObject gameObject : gameObjects) {
			
			this.shapeRenderer.begin(ShapeType.Filled);
			this.shapeRenderer.setColor(Color.BLACK);
			
			this.shapeRenderer.rect(gameObject.getPhysics().getPosition().x,
					gameObject.getPhysics().getPosition().y, gameObject.getPhysics().getWidth(),
					gameObject.getPhysics().getHeight());
			
			this.shapeRenderer.end();
		}
	}
}
