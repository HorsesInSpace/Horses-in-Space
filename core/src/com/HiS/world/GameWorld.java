package com.HiS.world;

import java.util.ArrayList;
import java.util.List;

import com.HiS.gameobject.Fence;
import com.HiS.gameobject.Horse;
import com.HiS.gameobject.PhysGameObject;
import com.HiS.hishelpers.AssetLoader;
import com.HiS.physics.PhysEngine;
import com.HiS.physics.Physics;
import com.HiS.screen.GameScreen;
import com.badlogic.gdx.math.Vector2;

public class GameWorld {

	private List<PhysGameObject> objects = new ArrayList<>();

	private PhysEngine physEngine;

	public GameWorld() {
		this.objects.add(new Fence());
//		this.objects.add(new Horse(null, 20, 15, 3, 20, (GameScreen.gameHeight - 15) - 80));
		this.objects.add(new Horse(AssetLoader.horse, 20, 15, 200, 15, (float)(GameScreen.gameHeight - 15) - 15));
//		this.objects.add(new Horse(null, 20, 15, 300, 45, (GameScreen.gameHeight - 15) - 15));
//		this.objects.add(new Horse(null, 20, 15, 400, 75, (GameScreen.gameHeight - 15) - 15));
		this.physEngine = new PhysEngine();
	}

	public void update(float delta) {
		for(PhysGameObject gameObject : objects) {
			Physics physics = gameObject.getPhysics();
			physics = this.physEngine.update(gameObject, delta);
			if(gameObject instanceof Horse) {
				this.physEngine.collisionCheck(gameObject, objects);
			}
			if(physics == null) {
				this.objects.remove(gameObject);
				gameObject = null;
			}
			if(gameObject instanceof Fence) {
				gameObject.getPhysics().setVelocity(new Vector2(-35,0));
			}
		}
		
	}

	public List<PhysGameObject> getObjects() {
		return objects;
	}
}
