package com.HiS.physics;

import java.util.List;

import com.HiS.hishelpers.AssetLoader;
import com.HiS.screen.GameScreen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Intersector;

/**
 * The PhysEngine is a physics engine that is supposed to take care
 * of all physical aspects of gameObjects, like position, speed,
 * collision etc.
 * 
 * @author lars, morten
 * @version 0.2
 *
 */
public class PhysEngine {

	/**
	 * Constructor for physEngine
	 * TODO: make class and method static, no need for the object itself?
	 */
	public PhysEngine() {

	}

	/**
	 * Main physics update method
	 * @param physics the object that should be manipulated according to physical
	 * laws
	 * @param delta the amount of time between frames, 
	 * used to measure movement per frame
	 * @return the physics after the update
	 */
	public Physics update(PhysObject physObject, float delta) {
		Physics physics = physObject.getPhysics();
		
		if(!physics.isGrounded()) {
			physics.getVelocity().add(physics.getAcceleration().x * delta, 
					physics.getAcceleration().y * delta);

			if (physics.getVelocity().y > 200) {
				physics.getVelocity().y = 200;
			}

			
		}

		physics.getPosition().add(physics.getVelocity().x * delta, 
				physics.getVelocity().y * delta);
		
		if (physics.getPosition().y + physics.getRect().height + 15 > GameScreen.gameHeight) {
			physObject.ground();
		}
		if(physics.isGrounded()) {
			physics.getVelocity().y = 0f;
			physics.getPosition().y = GameScreen.gameHeight - (physics.getRect().height + 15);
			AssetLoader.gallop.resume();
		}
		
		// TODO Check if something collides, and return null if it should be destroyed.
		physics.getRect().setX(physics.getPosition().x + physics.getRect().height);
		physics.getRect().setY(physics.getPosition().y);
		
		return physics;
	}

	/**
	 * A method that check for collisions between objects
	 * @param subject the subject to check against all other objects
	 * @param objects the objects in the game that may collide with the subject
	 * @return true if a crash happens, false if not
	 */
	public boolean collisionCheck(PhysObject subject, List<? extends PhysObject> objects) {
		for(PhysObject object : objects) {
			if(!object.equals(subject)) {
				if(Intersector.overlaps(subject.getPhysics().getRect(), object.getPhysics().getRect())) {
					return handleCollision(subject, object);
				}
			}
		}
		return false;
	}
	
	/**
	 * A method that handles a collision between two objects, to decide what
	 * happens with them.
	 * @param subject the subject of the crash
	 * @param object what object it crashed with
	 * @return boolean true if a crash should damage the subject, false if not
	 */
	public boolean handleCollision(PhysObject subject, PhysObject object) {
		Gdx.app.log("something", "collided");
		return true;
	}
	
}
