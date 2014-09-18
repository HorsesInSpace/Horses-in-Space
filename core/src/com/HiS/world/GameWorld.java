package com.HiS.world;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.HiS.gameobject.Fence;
import com.HiS.gameobject.Horse;
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
	private GfxObject foreground;
	private GfxObject foreground2;

	private PhysEngine physEngine;
	
	private Random rand;
	
	private Fence rightmostFence = null;

	public GameWorld() {
		this.objects.add(new Fence(200, 75));
		this.objects.add(new Fence(300, 75));
		this.objects.add(new Fence(400, 75));
		this.objects.add(new Horse(AssetLoader.horse, 20, 15, 300, 15, (float)(GameScreen.gameHeight - 15) - 15));
		
		this.background = new TexObject(AssetLoader.background);
		this.middleground1 = new TexObject(AssetLoader.middleground1);
		this.middleground2 = new TexObject(AssetLoader.middleground1);
		this.foreground = new TexObject(AssetLoader.foreground);
		this.foreground2 = new TexObject(AssetLoader.foreground);
		
		this.physEngine = new PhysEngine();
		
		rand = new Random();
	}

	public void update(float delta) {
		
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
			if(gameObject instanceof Fence) {
				gameObject.getPhysics().setVelocity(new Vector2(-65,0));
				Rectangle rect = gameObject.getPhysics().getRect();
				if((rect.x + rect.width) < 0) {
					float nextPos = GameScreen.gameWidth;
					if (rightmostFence != null) {
						nextPos = rightmostFence.getPosition().x + rand.nextInt((int) (GameScreen.gameWidth*0.66)) + (GameScreen.gameWidth/2);
						Gdx.app.log("NextPos", "" + nextPos);
					}
					
					gameObject.getPhysics().setPosition(new Vector2(nextPos, rect.y));
					gameObject.setCrashed(false);
					
					Gdx.app.log("RecentFence", rightmostFence.toString());
				}
				if(rightmostFence == null ||
						gameObject.getPosition().x > rightmostFence.getPosition().x) {
					rightmostFence = (Fence) gameObject;
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

	public GfxObject getForeground() {
		return foreground;
	}
}
