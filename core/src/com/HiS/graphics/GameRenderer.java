package com.HiS.graphics;

import com.HiS.gameobject.PhysGameObject;
import com.HiS.hishelpers.AssetLoader;
import com.HiS.screen.GameScreen;
import com.HiS.world.GameWorld;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class GameRenderer {

	private final SpriteBatch batch;

	private GameWorld world;
	private final OrthographicCamera cam;

	public GameRenderer(GameWorld world) {
		this.world = world;

		this.cam = new OrthographicCamera();
		this.cam.setToOrtho(true, GameScreen.gameWidth, GameScreen.gameHeight);

		this.batch = new SpriteBatch();
		this.batch.setProjectionMatrix(this.cam.combined);
	}

	public void render(float delta, float runTime) {
		// Draw window color
		Gdx.gl.glClearColor(255, 255, 0, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		// BATCH BEGIN
		this.batch.begin();

		// Draw background
		this.batch.disableBlending(); // Background is solid
		this.batch.draw(this.world.getBackground().getTexture(), this.world
				.getBackground().getRect().x, this.world.getBackground()
				.getRect().y, this.world.getBackground().getRect().width,
				this.world.getBackground().getRect().height);

		this.batch.enableBlending(); // Middleground has transparent areas
		// draw earth:
		this.batch.draw(AssetLoader.earth, 100, 30, 25, 25);

		// Draw middleground 1 and 2
		this.batch.draw(this.world.getMiddleground1().getTexture(), this.world
				.getMiddleground1().getRect().x, this.world.getMiddleground1()
				.getRect().y, this.world.getMiddleground1().getRect().width,
				this.world.getMiddleground1().getRect().height);
		this.batch.draw(this.world.getMiddleground2().getTexture(), this.world
				.getMiddleground2().getRect().x, this.world.getMiddleground2()
				.getRect().y, this.world.getMiddleground2().getRect().width,
				this.world.getMiddleground2().getRect().height);

		// Draw game objects
		for (PhysGameObject gameObject : this.world.getObjects()) {
			if (((gameObject.getPhysics().getRect().x + GameScreen.gameWidth) > 0)
					&& (gameObject.getPhysics().getRect().x < GameScreen.gameWidth)) {

				this.batch.draw(gameObject.getTexture(), gameObject
						.getPhysics().getRect().x, gameObject.getPhysics()
						.getRect().y, gameObject.getPhysics().getRect().width,
						gameObject.getPhysics().getRect().height);
			}
		}
		this.batch.draw(this.world.getHorse().getTexture(), this.world
				.getHorse().getRect().x, this.world.getHorse().getRect().y,
				this.world.getHorse().getRect().width, this.world.getHorse()
				.getRect().height);

		// Foreground
		this.batch.disableBlending(); // Foreground is solid
		this.batch.draw(this.world.getForeground1().getTexture(), this.world
				.getForeground1().getRect().x, this.world.getForeground1()
				.getRect().y, this.world.getForeground1().getRect().width,
				this.world.getForeground1().getRect().height);
		this.batch.draw(this.world.getForeground2().getTexture(), this.world
				.getForeground2().getRect().x, this.world.getForeground2()
				.getRect().y, this.world.getForeground2().getRect().width,
				this.world.getForeground2().getRect().height);

		this.batch.enableBlending();


		// POENGSCORE
		String str = this.world.score + "";
		AssetLoader.scoreFont.draw(this.batch, str, GameScreen.gameWidth/64, GameScreen.gameHeight/64);

		if (!GameScreen.running) {
			String highscoreTitle;
			String highscore;
			// OLD HIGHSCORE
			if (this.world.score < AssetLoader.getHighScore()) {
				highscoreTitle = "Old highscore: ";
				highscoreTitle.toUpperCase();
				highscore = AssetLoader.getHighScore() + "";
			} else {
				// NEW HIGHSCORE
				AssetLoader.setHighScore(this.world.score);
				highscoreTitle = "New highscore! ";
				highscoreTitle.toUpperCase();
				highscore = this.world.score + "";
			}
			AssetLoader.scoreFont.draw(this.batch, highscoreTitle + " " + highscore, GameScreen.gameWidth/2-25, 30);
			//			AssetLoader.scoreFont.draw(this.batch, highscore + "", GameScreen.gameWidth - highscoreTitle.length(),  30);
		}

		// BATCH END
		this.batch.end();

		// Collision box KEEP FOR TESTING
		//		 ShapeRenderer shape = new ShapeRenderer();
		//		 shape.setProjectionMatrix(this.cam.combined);
		//		 shape.begin(ShapeType.Line);
		//		 shape.setColor(Color.RED);
		//		 for (PhysGameObject gameobject : this.world.getObjects()) {
		//		 shape.polygon(gameobject.getPhysics().getPoly()
		//		 .getTransformedVertices());
		//		 }
		//		 shape.setColor(Color.GREEN);
		//		 for (PhysGameObject gameobject : this.world.getObjects()) {
		//		 shape.rect(gameobject.getPhysics().getRect().x, gameobject
		//		 .getPhysics().getRect().y, gameobject.getPhysics()
		//		 .getRect().width, gameobject.getPhysics().getRect().height);
		//		 }
		//		 shape.end();
	}

	public void setWorld(GameWorld world) {
		this.world = world;
	}
}
