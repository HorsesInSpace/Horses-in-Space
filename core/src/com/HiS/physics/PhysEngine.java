package com.HiS.physics;

import java.util.List;

import com.HiS.gameobject.obstacle.FloatyPlatform;
import com.HiS.screen.GameScreen;
import com.badlogic.gdx.math.Intersector;

/**
 * The PhysEngine is a physics engine that is supposed to take care of all
 * physical aspects of gameObjects, like position, speed, collision etc.
 * 
 * @author lars, morten
 * @version 0.2
 * 
 */
public class PhysEngine {

	private static Collision collision;

	/**
	 * Constructor for physEngine TODO: make class and method static, no need
	 * for the object itself?
	 */
	public PhysEngine() {
		PhysEngine.collision = new Collision(null, null, null);
	}

	/**
	 * Main physics update method
	 * 
	 * @param physics
	 *            the object that should be manipulated according to physical
	 *            laws
	 * @param delta
	 *            the amount of time between frames, used to measure movement
	 *            per frame
	 * @return the physics after the update
	 */
	public Physics update(PhysObject physObject, float delta) {
		Physics physics = physObject.getPhysics();

		if (physics.getWeight() == 0) {
			physics.getVelocity().add(physics.getAcceleration().x * delta, 0);
			physics.getPosition().add(physics.getVelocity().x * delta, 0);
			physics.getRect().setX(physics.getPosition().x);
			physics.getRect().setY(physics.getPosition().y);
			return physics;
		} else {

			if (physics.isGrounded()) {
				physics.getVelocity().y = 0f;
				physics.getPosition().y = GameScreen.gameHeight
						- (physics.getRect().height + 15);

			} else if (physics.onTopOfObject()) {
				physics.getVelocity().y = 0f;
				physics.getPosition().y = physics.getOnTopOfObject()
						.getPosition().y
						- physics.getOnTopOfObject().getRect().height;

			} else {
				physics.getVelocity().add(physics.getAcceleration().x * delta,
						physics.getAcceleration().y * delta);

				if (physics.getVelocity().y > 100) {
					physics.getVelocity().y = 100;
				}

				if (physics.getPosition().y + physics.getRect().height + 15 > GameScreen.gameHeight) {
					physObject.ground();
				}
			}

			physics.getPosition().add(physics.getVelocity().x * delta,
					physics.getVelocity().y * delta);

			physics.getRect().setX(physics.getPosition().x);
			physics.getRect().setY(physics.getPosition().y);

			return physics;
		}
	}

	/**
	 * A method that check for collisions between objects
	 * 
	 * @param subject
	 *            the subject to check against all other objects
	 * @param objects
	 *            the objects in the game that may collide with the subject
	 * @return true if a crash happens, false if not
	 */
	public Collision collisionCheck(PhysObject subject,
			List<? extends PhysObject> objects) {
		for (PhysObject object : objects) {
			if (object instanceof FloatyPlatform) {

				// legg til posisjon hvor objektet er plassert y-aksen + høyden
				// av objektet.

				// if(subject.getPhysics().getPosition().y >
				// object.getPhysics().getPosition().y +
				// object.getPhysics().getRect().height){
				if (Intersector.overlaps(subject.getPhysics().getRect(), object
						.getPhysics().getRect())) {
					// && subject.getPhysics().getPosition().y >
					// object.getPhysics().getPosition().y){
					subject.handleCollision(object);
					PhysEngine.collision.setSubject(subject);
					PhysEngine.collision.setObject(object);
					// object.getPhysics().getRect().height +
					subject.getPhysics().getVelocity().y = 0f;
					subject.getPhysics().getPosition().y = GameScreen.gameHeight
							- (object.getPhysics().getPosition().y);
					subject.getPhysics().setOnTopOfObject(object.getPhysics());
					PhysEngine.collision.setCollisionType(CollisionType.PASSED);
					return PhysEngine.collision;

				} else {
					PhysEngine.collision.setCollisionType(CollisionType.PASSED);
					return PhysEngine.collision;
				}

			}

			if (!object.equals(subject)) {
				if (Intersector.overlaps(subject.getPhysics().getRect(), object
						.getPhysics().getRect())) {
					subject.handleCollision(object);
					PhysEngine.collision.setSubject(subject);
					PhysEngine.collision.setObject(object);
					PhysEngine.collision
							.setCollisionType(CollisionType.CRASHED);
					return PhysEngine.collision;
				} else if (subject.getPhysics().getRect().x
						+ (subject.getPhysics().getRect().width / 2) > object
						.getPhysics().getRect().x
						+ object.getPhysics().getRect().width) {
					PhysEngine.collision.setSubject(subject);
					PhysEngine.collision.setObject(object);
					PhysEngine.collision.setCollisionType(CollisionType.PASSED);
					return PhysEngine.collision;
				}
			}
		}
		PhysEngine.collision.setSubject(subject);
		PhysEngine.collision.setObject(null);
		PhysEngine.collision.setCollisionType(CollisionType.NONE);
		return PhysEngine.collision;
	}

}
