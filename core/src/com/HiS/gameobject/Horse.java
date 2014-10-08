package com.HiS.gameobject;

import java.util.HashMap;

import com.HiS.game.HorseGame;
import com.HiS.hishelpers.AssetLoader;
import com.HiS.physics.PhysObject;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Polygon;

/**
 * Class that defines the horse, or the player, if you will
 * @author morten, lars
 * @version 0.3
 */
public class Horse extends PhysGameObject implements GameObject, PhysObject {

	private static Horse instance = null;
	private boolean sliding = false;
	private Polygon poly;
	private HashMap<TextureRegion, Polygon> polyMap;
	
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
		this.polyMap = new HashMap<TextureRegion, Polygon>();
		this.polyMap.put(AssetLoader.horse, AssetLoader.polyHorse);
		this.polyMap.put(AssetLoader.horse2, AssetLoader.polyHorse2);
		this.polyMap.put(AssetLoader.horse3, AssetLoader.polyHorse3);
		this.polyMap.put(AssetLoader.horseJump, AssetLoader.polyHorseJump);
		this.polyMap.put(AssetLoader.horseSlide, AssetLoader.polyHorseSlide);
		
		for (Polygon poly : polyMap.values()) {
			poly.setScale(0.15f, 0.16f);
			poly.setPosition(posX, posY+50);
		}
		
		this.poly = this.polyMap.get(this.texture);
	}
	
	@Override
	public void update(float delta, float runTime) {
		
		// TODO Move below line logic into physengine
		
		
		if(!this.physics.isGrounded()) {
			this.texture = AssetLoader.horseJump;
			if (this.sliding) this.texture = AssetLoader.horseSlide;
		} else if (this.sliding) {
			this.texture = AssetLoader.horseSlide;
		} else {
			this.texture = AssetLoader.anim.getKeyFrame(runTime);
			AssetLoader.gallopSound.resume(HorseGame.gallopSoundID);
		}
		this.poly = polyMap.get(this.texture);
		this.poly.setPosition(this.physics.getRect().x, this.physics.getRect().y);
	}
	
	/**
	 * Makes the horse jump if it is grounded
	 * Does nothing if in the air
	 */
	public void jump() {
		
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

	public Polygon getPoly() {
		return poly;
	}

	public void setPoly(Polygon poly) {
		this.poly = poly;
	}

}
