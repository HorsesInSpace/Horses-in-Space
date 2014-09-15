package com.HiS.gameobject;

import com.HiS.physics.PhysObject;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

/**
 * Class that defines the horse, or the player, if you will
 * @author morten, lars
 * @version 0.3
 */
public class Horse extends PhysGameObject implements GameObject, PhysObject {

	private static Horse instance = null;
	
	public static Horse getInstance() {
		if(instance == null) {
			instance = new Horse(null, 10,7,300,10,10);
		}
		return instance;
	}
	
	//TODO can still be made into Singleton by making constructor private. 
	//public now b/c testing purposes
	public Horse(Texture texture, int width, int height, float weight, float posX, float posY) {
		super(texture, width, height, weight, posX, posY);
	}
	
	@Override
	public void update(float delta) {
		// TODO Update the object
		Gdx.app.log("Horse", "updating");
	}
	
	/**
	 * Makes the horse jump if it is grounded
	 * Does nothing if in the air
	 */
	public void jump() {
		Gdx.app.log("Horse", "jumping");
		// TODO Somehow move the logic below so that PhysEngine can take care of how a jump is made
		if(this.physics.isGrounded()) {
			this.physics.setGrounded(false);
			this.physics.getVelocity().y = (float) - (140 - (this.physics.getWeight() * 0.05));
		}
	}
	
	/**
	 * Destroys the object, NOT YET IMPLEMENTED
	 */
	@Override
	public void destroy() {
		// TODO Correctly and effectively destroy the object
		Gdx.app.log("Horse", "destroyed");
	}

}
