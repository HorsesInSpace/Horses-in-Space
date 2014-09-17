package com.HiS.graphics;

import com.HiS.gameobject.PhysGameObject;
import com.HiS.world.GameWorld;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class GameRenderer {

	private float fgRenderTime;
	private float mgRenderTime;

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

	public void render(float delta, float runTime) {
		// Draw window color
		Gdx.gl.glClearColor(255, 255, 0, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		// BATCH BEGIN
		this.batch.begin();



		// Draw background
		this.batch.disableBlending(); // Background is solid
		this.batch.draw(this.world.getBackground().getTexture(), 0, -10, this.width, this.height);

		// TODO Add comment for this. I don't get it completely
		//renderTime plus delta equals total renderTime, when rendertime is such that it has moved the
		//middleground all the way out of the screen, the texture is set to 0, so the middleground
		//is reset. this WILL change for the better later
		this.mgRenderTime += delta;
		if(this.mgRenderTime*15 >= this.width) {
			this.mgRenderTime = 0;
		}

		// Draw middleground 1
		this.batch.enableBlending(); // Middleground has transparent areas
		this.batch.draw(this.world.getMiddleground1().getTexture(), (float) (0-(this.mgRenderTime*15)), this.height-15-(this.height/4), this.width, this.height/4);
		this.batch.draw(this.world.getMiddleground1().getTexture(), (float) (this.width-(this.mgRenderTime*15)), this.height-15-(this.height/4), this.width, this.height/4);

		// Draw game objects
		for(PhysGameObject gameObject : world.getObjects()) {
			if(gameObject.getPhysics().getRect().x + width > 0 && gameObject.getPhysics().getRect().x < width) {
				this.batch.draw(
						gameObject.getTexture(),
						gameObject.getPhysics().getRect().x, 
						gameObject.getPhysics().getRect().y, 
						gameObject.getPhysics().getRect().width, 
						gameObject.getPhysics().getRect().height);	
			}
		}

		// TODO Add comment for this. I don't get it completely
		fgRenderTime += delta;
		if(fgRenderTime*65 >= this.width) {
			fgRenderTime = 0;
		}
		
		// Foreground
		this.batch.disableBlending(); // Foreground is solid
		this.batch.draw(this.world.getForeground().getTexture(), 0-(fgRenderTime*65), this.height-15, this.width+2, 15);
		this.batch.draw(this.world.getForeground().getTexture(), this.width-(fgRenderTime*65), this.height-15, this.width+2, 15);

		// BATCH END
		this.batch.end();
	}
}
