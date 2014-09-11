package com.HiS.gameobject;

import com.HiS.physics.Physics;

/**
 * Interface for gameObjects. All objects with physics are gameObjects
 * They have a non-optional update method, and will all be added to a list of gameObects on creation
 * in the game.
 * @author Morten
 *
 */
public interface GameObject {
	
	/**
	 * This method gets called for each gameobject for each frame.
	 * @param delta deltatime measures the time it takes a frame to render and is used to normalize
	 * movement independently from framerate.
	 */
	public void update(float delta);
	
	/**
	 * This method returns a Physics object related to the gameObject
	 * @return physics of the gameObject
	 */
	public Physics getPhysics();
	
	/**
	 * Destroys the object.
	 */
	public void destroy();
}
