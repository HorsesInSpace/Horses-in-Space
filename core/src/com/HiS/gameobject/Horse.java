package com.HiS.gameobject;

import com.HiS.physics.Physics;
import com.badlogic.gdx.Gdx;

public class Horse implements GameObject {

	private static Horse instance = null;
	
	private Physics physics;
	
	public static Horse getInstance() {
		if(instance == null) {
			instance = new Horse(10,7,300,10,10);
		}
		return instance;
	}
	
	//TODO can still be made into Singleton by making constructor private. 
	//public now b/c testing purposes
	public Horse(int width, int height, float weight, float posX, float posY) {
		this.physics = new Physics(width, height, weight, posX, posY);
	}
	
	@Override
	public void update(float delta) {
		// TODO Update the object
		Gdx.app.log("Horse", "updating");
	}

	@Override
	public void destroy() {
		// TODO Correctly and effectively destroy the object
		Gdx.app.log("Horse", "destroyed");
	}

	@Override
	public Physics getPhysics() {
		return this.physics;
	}

}