package com.HiS.physics;

import java.util.ArrayList;

import com.HiS.gameobject.GameObject;
import com.HiS.screen.GameScreen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;

/**
 * The PhysEngine is a physics engine that is supposed to take care
 * of all physical aspects of gameObjects, like position, speed,
 * collision etc.
 * 
 * @author lars
 * @version 0.1
 *
 */
public class PhysEngine {

	public PhysEngine() {
		
	}

	public Physics update(Physics physics, float delta) {

		if(!physics.isGrounded()) {
			physics.getVelocity().add(physics.getAcceleration().x * delta, 
					physics.getAcceleration().y * delta);

			if (physics.getVelocity().y > 200) {
				physics.getVelocity().y = 200;
			}

			physics.getPosition().add(physics.getVelocity().x * delta, 
					physics.getVelocity().y * delta);
		}

		if (physics.getPosition().y + physics.getHeight() + 15 > GameScreen.gameHeight) {
			physics.getVelocity().y = 0f;
			physics.getPosition().y = GameScreen.gameHeight - (physics.getHeight() + 15);
			physics.setGrounded(true);
		}
		//		boolean isDead = collisionCheck(physics);

		// TODO Check if something collides, and return null if it should be destroyed.
		physics.getRect().setX(physics.getPosition().x);
		physics.getRect().setY(physics.getPosition().y);
		return physics;
	}

	public boolean collisionCheck(GameObject subject, ArrayList<GameObject> objects) {
		for(GameObject object : objects) {
			if(!object.equals(subject)) {
			if(Intersector.overlaps(subject.getPhysics().getRect(), object.getPhysics().getRect())) {
					Gdx.app.log("Something", "collided");
				}
//				if(physics.getPosition().x + (physics.getWidth()/2) > rect.getX() || 
//						physics.getPosition().x + (physics.getWidth()/2) < rect.getX() + rect.getWidth()) {
//					return true;
//				}
		}
		}
		return false;

	}
}
