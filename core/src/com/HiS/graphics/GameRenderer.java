package com.HiS.graphics;

import com.HiS.gameobject.PhysGameObject;
import com.HiS.screen.GameScreen;
import com.HiS.world.GameWorld;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class GameRenderer {

	private ShapeRenderer shapeRenderer;
	private SpriteBatch batch;

	private GameWorld world;
	private OrthographicCamera cam;

	public GameRenderer(GameWorld world) {
		this.world = world;

		this.cam = new OrthographicCamera();
		this.cam.setToOrtho(true, GameScreen.gameWidth, GameScreen.gameHeight);

		this.batch = new SpriteBatch();
		this.batch.setProjectionMatrix(this.cam.combined);

		this.shapeRenderer = new ShapeRenderer();
		this.shapeRenderer.setProjectionMatrix(this.cam.combined);
	}

	public void render(float delta, float runTime) {
		// Draw window color
		Gdx.gl.glClearColor(255, 255, 0, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		// BATCH BEGIN
		this.batch.begin();

		// Draw background
		this.batch.disableBlending(); // Background is solid
		this.batch.draw(this.world.getBackground().getTexture(), this.world.getBackground().getRect().x, this.world.getBackground().getRect().y, this.world.getBackground().getRect().width, this.world.getBackground().getRect().height);

		// Draw middleground 1 and 2
		this.batch.enableBlending(); // Middleground has transparent areas
		this.batch.draw(this.world.getMiddleground1().getTexture(), this.world.getMiddleground1().getRect().x, this.world.getMiddleground1().getRect().y, this.world.getMiddleground1().getRect().width, this.world.getMiddleground1().getRect().height);
		this.batch.draw(this.world.getMiddleground2().getTexture(), this.world.getMiddleground2().getRect().x, this.world.getMiddleground2().getRect().y, this.world.getMiddleground2().getRect().width, this.world.getMiddleground2().getRect().height);

		// Draw game objects
		for(PhysGameObject gameObject : world.getObjects()) {
			if(gameObject.getPhysics().getRect().x + GameScreen.gameWidth > 0 && gameObject.getPhysics().getRect().x < GameScreen.gameWidth) {
				this.batch.draw(
						gameObject.getTexture(),
						gameObject.getPhysics().getRect().x, 
						gameObject.getPhysics().getRect().y, 
						gameObject.getPhysics().getRect().width, 
						gameObject.getPhysics().getRect().height);	
			}
		}
		
		// Foreground
		this.batch.disableBlending(); // Foreground is solid
		this.batch.draw(this.world.getForeground1().getTexture(), this.world.getForeground1().getRect().x, this.world.getForeground1().getRect().y, this.world.getForeground1().getRect().width, this.world.getForeground1().getRect().height);
		this.batch.draw(this.world.getForeground2().getTexture(), this.world.getForeground2().getRect().x, this.world.getForeground2().getRect().y, this.world.getForeground2().getRect().width, this.world.getForeground2().getRect().height);

		// BATCH END
		this.batch.end();
	}
}
