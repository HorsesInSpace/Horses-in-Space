package com.HiS.gameobject;

import com.HiS.physics.Physics;
import com.badlogic.gdx.Gdx;

public class Horse implements GameObject {

//	private static Horse instance = null;
	
	private Physics physics;
	
//	public static Horse getInstance() {
//		if(instance == null) {
//			instance = new Horse();
//		}
//		return instance;
//	}
	
	//TODO can still be made into Singleton because the constructor can be parameterless and private
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
