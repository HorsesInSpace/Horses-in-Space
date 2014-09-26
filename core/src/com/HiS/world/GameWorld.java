package com.HiS.world;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.HiS.gameobject.Fence;
import com.HiS.gameobject.Horse;
import com.HiS.gameobject.Obstacle;
import com.HiS.gameobject.PhysGameObject;
import com.HiS.graphics.GfxObject;
import com.HiS.graphics.TexObject;
import com.HiS.hishelpers.AssetLoader;
import com.HiS.physics.PhysEngine;
import com.HiS.physics.Physics;
import com.HiS.screen.GameScreen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class GameWorld {

	private List<PhysGameObject> objects = new ArrayList<>();
	private GfxObject background;
	private GfxObject middleground1;
	private GfxObject middleground2;
	private GfxObject foreground1;
	private GfxObject foreground2;

	private PhysEngine physEngine;
	private float scrollSpeed = -(GameScreen.gameWidth/2);
	
	private Random rand;
	
	private Obstacle rightmostObstacle = null;

	public GameWorld() {
		this.objects.add(new Fence(200, 75));
		this.objects.add(new Fence(300, 75));
		this.objects.add(new Fence(400, 75));
		this.objects.add(new Horse(AssetLoader.horse, 22, 15, 300, 15, (float)(GameScreen.gameHeight - 15) - 15));
		
		this.background = new TexObject(AssetLoader.background, 
				0, 
				-90, 
				GameScreen.gameHeight, 
				GameScreen.gameWidth);

		this.middleground1 = new TexObject(AssetLoader.middleground1, 
				0, 
				GameScreen.gameHeight/4+(GameScreen.gameHeight/16), 
				GameScreen.gameHeight/4, GameScreen.gameWidth);
		this.middleground2 = new TexObject(AssetLoader.middleground1, 
				this.getMiddleground1().getRect().width, 
				GameScreen.gameHeight/4+(GameScreen.gameHeight/16), 
				GameScreen.gameHeight/4, GameScreen.gameWidth);
		
		this.foreground1 = new TexObject(AssetLoader.foreground, 
				0,
				(GameScreen.gameHeight/2)+(GameScreen.gameHeight/20), 
				GameScreen.gameHeight/4, GameScreen.gameWidth);
		this.foreground2 = new TexObject(AssetLoader.foreground, 
				this.foreground1.getRect().width, 
				(GameScreen.gameHeight/2)+(GameScreen.gameHeight/20), 
				GameScreen.gameHeight/4, GameScreen.gameWidth);

		
		this.physEngine = new PhysEngine();
		
		rand = new Random();
	}

	public void update(float delta) {
		scrollSpeed -= delta;
		this.foreground1.getRect().x += scrollSpeed*delta;
		this.foreground2.getRect().x += scrollSpeed*delta;
		if((this.foreground1.getRect().x + this.foreground1.getRect().width) < 0) {
			this.foreground1.getRect().x = this.foreground2.getRect().x + this.foreground2.getRect().width;
		}
		if((this.foreground2.getRect().x + this.foreground2.getRect().width) < 0) {
			this.foreground2.getRect().x = this.foreground1.getRect().x + this.foreground1.getRect().width;
		}
		this.middleground1.getRect().x += (scrollSpeed/4)*delta;
		this.middleground2.getRect().x += (scrollSpeed/4)*delta;
		if((this.middleground1.getRect().x + this.middleground1.getRect().width) < 0) {
			this.middleground1.getRect().x = this.getMiddleground2().getRect().x+this.getMiddleground2().getRect().width;
		}
		if((this.middleground2.getRect().x + this.middleground2.getRect().width) < 0) {
			this.middleground2.getRect().x = this.getMiddleground1().getRect().x+this.getMiddleground1().getRect().width;
		}
		
		for(PhysGameObject gameObject : objects) {
			
			gameObject.update(delta);
			
			Physics physics = gameObject.getPhysics();
			physics = this.physEngine.update(gameObject, delta);
			if(gameObject instanceof Horse) {
				this.physEngine.collisionCheck(gameObject, objects);
			}
			if(physics == null) {
//				this.objects.remove(gameObject);
//				gameObject = null;
			}
			if(gameObject instanceof Obstacle) {
				gameObject.getPhysics().setVelocity(new Vector2(scrollSpeed,0));
				Rectangle rect = gameObject.getPhysics().getRect();
				if((rect.x + rect.width) < 0) {
					float nextPos = GameScreen.gameWidth;
					if (rightmostObstacle != null) {
						nextPos = rightmostObstacle.getPosition().x + rand.nextInt((int) (GameScreen.gameWidth*0.66)) + (GameScreen.gameWidth/2);
						Gdx.app.log("NextPos", "" + nextPos);
					}
					
					gameObject.getPhysics().setPosition(new Vector2(nextPos, rect.y));
					gameObject.setCrashed(false);
					
					Gdx.app.log("RecentFence", rightmostObstacle.toString());
				}
				if(rightmostObstacle == null ||
						gameObject.getPosition().x > rightmostObstacle.getPosition().x) {
					rightmostObstacle = (Fence) gameObject;
				}
			}
		}
		
	}

	public List<PhysGameObject> getObjects() {
		return objects;
	}

	public GfxObject getBackground() {
		return background;
	}

	public GfxObject getMiddleground1() {
		return middleground1;
	}
	
	public GfxObject getMiddleground2() {
		return middleground2;
	}

	public GfxObject getForeground1() {
		return foreground1;
	}
	
	public GfxObject getForeground2() {
		return foreground2;
	}
}
