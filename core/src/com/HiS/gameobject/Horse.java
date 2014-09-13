package com.HiS.gameobject;

import com.HiS.physics.Physics;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Horse implements GameObject {

	private static Horse instance = null;
	
	private Physics physics;
	private Texture texture;
	
	public static Horse getInstance() {
		if(instance == null) {
			instance = new Horse(null, 10,7,300,10,10);
		}
		return instance;
	}
	
	//TODO can still be made into Singleton by making constructor private. 
	//public now b/c testing purposes
	public Horse(Texture texture, int width, int height, float weight, float posX, float posY) {
		this.physics = new Physics(width, height, weight, posX, posY);
		this.texture = texture;
	}
	
	@Override
	public void update(float delta) {
		// TODO Update the object
		Gdx.app.log("Horse", "updating");
	}
	
	public void jump() {
		Gdx.app.log("Horse", "jumping");
		// TODO Somehow move the logic below so that PhysEngine can take care of how a jump is made
		if(this.physics.isGrounded()) {
			this.physics.setGrounded(false);
			this.physics.getVelocity().y = (float) - (140 - (this.physics.getWeight() * 0.05));
		}
	}

	@Override
	public Physics getPhysics() {
		return this.physics;
	}

	@Override
	public Texture getTexture() {
		return this.texture;
	}

	public void setTexture(Texture texture) {
		this.texture = texture;
	}
	
	@Override
	public void destroy() {
		// TODO Correctly and effectively destroy the object
		Gdx.app.log("Horse", "destroyed");
	}

}
