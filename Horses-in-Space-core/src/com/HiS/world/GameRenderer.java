package com.HiS.world;

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
		this.shapeRenderer.setProjectionMatrix(cam.combined);
	}
	
	public void render() {
		Gdx.gl.glClearColor(255, 0, 255, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		this.shapeRenderer.begin(ShapeType.Filled);
		this.shapeRenderer.setColor(Color.RED);
		
		this.shapeRenderer.rect(this.world.getRect().x,
				this.world.getRect().y, this.world.getRect().width,
				this.world.getRect().height);
		
		this.shapeRenderer.end();
	}
}
