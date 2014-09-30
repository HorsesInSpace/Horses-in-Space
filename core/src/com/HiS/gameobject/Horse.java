package com.HiS.gameobject;

import com.HiS.game.HorseGame;
import com.HiS.hishelpers.AssetLoader;
import com.HiS.physics.PhysObject;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Class that defines the horse, or the player, if you will
 * @author morten, lars
 * @version 0.3
 */
public class Horse extends PhysGameObject implements GameObject, PhysObject {

	private static Horse instance = null;
	private boolean sliding = false;
	
	public static Horse getInstance() {
		if(instance == null) {
			instance = new Horse(null, 10,7,300,10,10);
		}
		return instance;
	}
	
	//TODO can still be made into Singleton by making constructor private. 
	//public now b/c testing purposes
	public Horse(TextureRegion horse, int width, int height, float weight, float posX, float posY) {
		super(horse, width, height, weight, posX, posY);
	}
	
	@Override
	public void update(float delta, float runTime) {
		// TODO Update the object
		if(!this.getPhysics().isGrounded()) {
			this.texture = AssetLoader.horseJump;
		} else if (this.sliding) {
			this.texture = AssetLoader.horseJump;
		} else {
			this.texture = AssetLoader.anim.getKeyFrame(runTime);
			AssetLoader.gallopSound.resume(HorseGame.gallopSoundID);
		}
	}
	
	/**
	 * Makes the horse jump if it is grounded
	 * Does nothing if in the air
	 */
	public void jump() {
		
		// TODO Somehow move the logic below so that PhysEngine can take care of how a jump is made
		if(this.physics.isGrounded()) {
			Gdx.app.log("Horse", "jumping");
			
			AssetLoader.gallopSound.pause(HorseGame.gallopSoundID);
			AssetLoader.whinning.play(1f);
			
			this.physics.setGrounded(false);
			this.physics.getVelocity().y = (float) - (120 - (this.physics.getWeight() * 0.05));
			
//			MEGAJUMP this.physics.getAcceleration().y = (float) - (140 - (this.physics.getWeight() * 0.05));
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
	
	@Override
	public void handleCollision(PhysObject object) {
		if(!object.hasCrashed()) {
			object.setCrashed(true);
			AssetLoader.punch.play(1);
			Gdx.app.log("Horse", "collided");
		}
		
	}

	public void slide() {
		Gdx.app.log("Horse", "slidin");
		this.sliding = true;
		this.physics.getRect().height /= 2;
		
	}
	
	public void unSlide() {
		if(this.sliding) {
			Gdx.app.log("Horse", "not slidin");
			this.sliding = false;
			this.physics.getRect().height *= 2;
		}
	}

}
