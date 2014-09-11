package com.HiS.physics;

import com.HiS.screen.GameScreen;

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
		
		// TODO (1/2) Fix this awful way of handling gravity. cpy() is bad. Mkay?
		physics.getVelocity().add(physics.getAcceleration().cpy().scl(delta));

        if (physics.getVelocity().y > 200) {
        	physics.getVelocity().y = 200;
        }

        // TODO (2/2) Fix this awful way of handling gravity. cpy() is bad. Mkay?
        physics.getPosition().add(physics.getVelocity().cpy().scl(delta));
		
		
		if (physics.getPosition().y + physics.getHeight() + 15 > GameScreen.gameHeight) {
			physics.getVelocity().y = (float) - (140 - ( physics.getWeight() *0.05));
		}
		
		// TODO Check if something collides, and return null if it should be destroyed.
		
		return physics;
	}
}
