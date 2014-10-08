package com.HiS.graphics;

import com.HiS.gameobject.PhysGameObject;
import com.HiS.hishelpers.AssetLoader;
import com.HiS.screen.GameScreen;
import com.HiS.world.GameWorld;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameRenderer {

	private SpriteBatch batch;

	private GameWorld world;
	private OrthographicCamera cam;

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

		// Draw middleground 1 and 2
		this.batch.enableBlending(); // Middleground has transparent areas
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

		String score = "Score: ";

		AssetLoader.font.draw(this.batch, score, GameScreen.gameWidth / 2, 0);
		String str = this.world.score + "";
		AssetLoader.font.draw(this.batch, str, GameScreen.gameWidth
				- (GameScreen.gameWidth / 16) - (str.length() * 3f), 0);

		if (!GameScreen.running) {
			String highscoreTitle;
			String highscore;
			if (this.world.score < AssetLoader.getHighScore()) {
				highscoreTitle = "Old highscore: ";
				highscore = AssetLoader.getHighScore() + "";
			} else {

				AssetLoader.setHighScore(this.world.score);
				highscoreTitle = "New highscore!";
				highscore = this.world.score + "";
			}
			AssetLoader.font.draw(this.batch, highscoreTitle, (136 / 2)
					- ((3 * score.length()) - 1), 11);
			AssetLoader.font.draw(this.batch, highscore + "", (136 / 2)
					- ((3 * score.length()) - 1), 30);
		}

		// BATCH END
		this.batch.end();

		// Horse collision box KEEP FOR TESTING
		// ShapeRenderer shape = new ShapeRenderer();
		// shape.setProjectionMatrix(cam.combined);
		// shape.begin(ShapeType.Line);
		// shape.setColor(Color.RED);
		// for(PhysGameObject gameobject : world.getObjects()) {
		// if(gameobject instanceof Horse) {
		// // shape.polygon(new float[]{2f, 5f, 10f, 4f, 20f, 19f});
		// shape.polygon(((Horse)
		// gameobject).getPhysics().getPoly().getTransformedVertices());
		// // for (float f : ((Horse)
		// gameobject).getPhysics().getPoly().getTransformedVertices()) {
		// // System.out.print(f + " ");
		// // }
		// // System.out.println("");
		// // shape.rect(gameobject.getPhysics().getRect().x,
		// gameobject.getPhysics().getRect().y,
		// gameobject.getPhysics().getRect().width,
		// gameobject.getPhysics().getRect().height);
		// }
		// }
		// shape.end();
	}

	public void setWorld(GameWorld world) {
		this.world = world;
	}
}
