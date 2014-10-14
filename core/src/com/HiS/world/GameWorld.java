package com.HiS.world;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.HiS.gameobject.Horse;
import com.HiS.gameobject.PhysGameObject;
import com.HiS.gameobject.obstacle.Obstacle;
import com.HiS.graphics.GfxObject;
import com.HiS.graphics.TexObject;
import com.HiS.hishelpers.AssetLoader;
import com.HiS.level.Level;
import com.HiS.physics.Collision;
import com.HiS.physics.PhysEngine;
import com.HiS.screen.GameScreen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class GameWorld {

	private List<PhysGameObject> objects = new ArrayList<PhysGameObject>();
	private GfxObject background;
	private GfxObject middleground1;
	private GfxObject middleground2;
	private GfxObject foreground1;
	private GfxObject foreground2;

	private Level level;

	public long score;

	private PhysEngine physEngine;
	private final float scrollSpeed = -(GameScreen.gameWidth / 1.8f);

	private Random rand;

	private Obstacle rightmostObstacle = null;

	public GameWorld() {
		initWorld();
	}

	public void update(float delta, float runTime) {
		this.score += delta * 100;
		// Gdx.app.log("Score", this.score + "");
		// this.scrollSpeed -= delta;
		moveBackMiddle(delta);
		for (PhysGameObject gameObject : this.objects) {

			this.physEngine.update(gameObject, delta);
			gameObject.update(delta, runTime);
			if (gameObject instanceof Horse) {
				Collision col = this.physEngine.collisionCheck(gameObject,
						this.objects);
				Gdx.app.log("COLLISIONTYPE", col.getCollisionType().name()
						+ ":" + col.getObject());
				switch (col.getCollisionType()) {
				case PASSED:
					if (col.getObject() instanceof Obstacle) {
						Obstacle obstacle = (Obstacle) col.getObject();
						if (!obstacle.isPassed()) {
							this.score += obstacle.getPoints();
							obstacle.setPassed(true);
						}
					}
					break;

				case CRASHED:
					col.getSubject().handleCollision(col.getObject());
					GameScreen.running = false;
					gameObject.destroy();
					if (this.score > AssetLoader.getHighScore()) {
						AssetLoader.setHighScore(this.score);
					}
					break;
				default:
					//
					break;
				}
			} else if (gameObject instanceof Obstacle) {
				gameObject.getPhysics().setVelocity(
						new Vector2(this.scrollSpeed, 0));
				Rectangle rect = gameObject.getPhysics().getRect();
				if ((rect.x + rect.width) < 0) {
					float nextPos = GameScreen.gameWidth;
					if (this.rightmostObstacle != null) {
						nextPos = this.rightmostObstacle.getPosition().x
								+ this.rand
										.nextInt((int) (GameScreen.gameWidth * 0.66))
								+ (GameScreen.gameWidth / 2);
						Gdx.app.log("NextPos", "" + nextPos);
						Gdx.app.log("Score", this.score + "");
					}

					gameObject.getPhysics().setPosition(
							new Vector2(nextPos, rect.y));
					gameObject.setCrashed(false);
					((Obstacle) gameObject).setPassed(false);

					Gdx.app.log("RecentObstacle",
							this.rightmostObstacle.toString());
				}
				if ((this.rightmostObstacle == null)
						|| (gameObject.getPosition().x > this.rightmostObstacle
								.getPosition().x)) {
					this.rightmostObstacle = (Obstacle) gameObject;
				}
			}
		}
	}

	public List<PhysGameObject> getObjects() {
		return this.objects;
	}

	public GfxObject getBackground() {
		return this.background;
	}

	public GfxObject getMiddleground1() {
		return this.middleground1;
	}

	public GfxObject getMiddleground2() {
		return this.middleground2;
	}

	public GfxObject getForeground1() {
		return this.foreground1;
	}

	public GfxObject getForeground2() {
		return this.foreground2;
	}

	private void initWorld() {
		this.level = new Level("data/level/moon.csv");
		this.objects = this.level.getObjects();

		this.objects.add(new Horse(AssetLoader.horse, 22, 15, 300, 15,
				GameScreen.gameHeight - 15 - 15));

		this.background = new TexObject(AssetLoader.background, 0, -90,
				GameScreen.gameHeight, GameScreen.gameWidth);

		this.middleground1 = new TexObject(AssetLoader.middleground1, 0,
				(GameScreen.gameHeight / 4) + (GameScreen.gameHeight / 16),
				GameScreen.gameHeight / 4, GameScreen.gameWidth
						+ (GameScreen.gameWidth / 2));
		this.middleground2 = new TexObject(AssetLoader.middleground1,
				getMiddleground1().getRect().width, (GameScreen.gameHeight / 4)
						+ (GameScreen.gameHeight / 16),
				GameScreen.gameHeight / 4, GameScreen.gameWidth
						+ (GameScreen.gameWidth / 2));

		this.foreground1 = new TexObject(AssetLoader.foreground, 0,
				(GameScreen.gameHeight / 2) + (GameScreen.gameHeight / 20),
				GameScreen.gameHeight / 4, GameScreen.gameWidth);
		this.foreground2 = new TexObject(AssetLoader.foreground,
				this.foreground1.getRect().width, (GameScreen.gameHeight / 2)
						+ (GameScreen.gameHeight / 20),
				GameScreen.gameHeight / 4, GameScreen.gameWidth);

		// TODO Pass speed as parameter from level into PhysEngine constructor
		this.physEngine = new PhysEngine();

		this.rand = new Random();
	}

	private void moveBackMiddle(float delta) {
		this.foreground1.getRect().x += this.scrollSpeed * delta;
		this.foreground2.getRect().x += this.scrollSpeed * delta;
		if ((this.foreground1.getRect().x + this.foreground1.getRect().width) < 0) {
			this.foreground1.getRect().x = this.foreground2.getRect().x
					+ this.foreground2.getRect().width;
		}
		if ((this.foreground2.getRect().x + this.foreground2.getRect().width) < 0) {
			this.foreground2.getRect().x = this.foreground1.getRect().x
					+ this.foreground1.getRect().width;
		}
		this.middleground1.getRect().x += (this.scrollSpeed / 4) * delta;
		this.middleground2.getRect().x += (this.scrollSpeed / 4) * delta;
		if ((this.middleground1.getRect().x + this.middleground1.getRect().width) < 0) {
			this.middleground1.getRect().x = getMiddleground2().getRect().x
					+ getMiddleground2().getRect().width;
		}
		if ((this.middleground2.getRect().x + this.middleground2.getRect().width) < 0) {
			this.middleground2.getRect().x = getMiddleground1().getRect().x
					+ getMiddleground1().getRect().width;
		}
	}
}
