package com.HiS.physics;

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
		
		physics.getVelocity().add(physics.getAcceleration().x * delta, 
								  physics.getAcceleration().y * delta);

        if (physics.getVelocity().y > 200) {
        	physics.getVelocity().y = 200;
        }

        physics.getPosition().add(physics.getVelocity().x * delta, 
        						  physics.getVelocity().y * delta);
		
		
		if (physics.getPosition().y + physics.getHeight() + 15 > GameScreen.gameHeight) {
			physics.getVelocity().y = (float) - (140 - (physics.getWeight() * 0.05));
		}
//		boolean isDead = collisionCheck(physics);
		
		// TODO Check if something collides, and return null if it should be destroyed.
		
		return physics;
	}
//	
//	public boolean collisionCheck(Physics physics) {
//		Rectangle rect = new Rectangle(0,0,10,10);
//		if(Intersector.overlaps(physics.getRect(), rect)) {
//			if(physics.getPosition().x + (physics.getWidth()/2) > rect.getX() || 
//				physics.getPosition().x + (physics.getWidth()/2) < rect.getX() + rect.getWidth()) {
//					return true;
//				}
//		}
//		return false;
//		
//	}
}
