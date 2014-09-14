package com.HiS.world;

import java.util.ArrayList;

import com.HiS.gameobject.GameObject;
import com.HiS.gameobject.Horse;
import com.HiS.physics.PhysEngine;
import com.HiS.physics.Physics;
import com.HiS.screen.GameScreen;

public class GameWorld {

	private ArrayList<GameObject> objects = new ArrayList<>();

	private PhysEngine physEngine;

	public GameWorld() {
		this.objects.add(new Horse(null, 20, 15, 80, 20, (GameScreen.gameHeight - 15) - 80));
		this.objects.add(new Horse(null, 20, 15, 200, 15, (GameScreen.gameHeight - 15) - 15));
		this.objects.add(new Horse(null, 20, 15, 300, 45, (GameScreen.gameHeight - 15) - 15));
		this.objects.add(new Horse(null, 20, 15, 400, 75, (GameScreen.gameHeight - 15) - 15));
		this.physEngine = new PhysEngine();
	}

	public void update(float delta) {
		for(GameObject gameObject : objects) {
			Physics physics = gameObject.getPhysics();
			physics = this.physEngine.update(physics, delta);
			if(gameObject instanceof Horse) {
				physEngine.collisionCheck(gameObject, objects);
			}
			if(physics == null) {
				this.objects.remove(gameObject);
				gameObject = null;
			}
		}

	}

	public ArrayList<GameObject> getObjects() {
		return objects;
	}
}
