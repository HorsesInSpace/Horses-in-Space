package com.HiS.physics;

import java.util.List;

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

		if (physics.isOnTopOfObject()) {
			if (physics.getPosition().x > (physics.getOnTopOfObject()
					.getPosition().x + physics.getOnTopOfObject().getRect().width)) {
				physics.setOnTopOfObject(null);
			}
		}

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

			} else if (physics.isOnTopOfObject()) {
				physics.getVelocity().y = 0f;
				physics.getPosition().y = physics.getOnTopOfObject()
						.getPosition().y - physics.getRect().height;
			} else {
				physics.getVelocity().add(physics.getAcceleration().x * delta,
						physics.getAcceleration().y * delta);

				if (physics.getVelocity().y > 100) {
					physics.getVelocity().y = 100;
				}

				if ((physics.getPosition().y + physics.getRect().height + 15) > GameScreen.gameHeight) {
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
			boolean collided = false;
			boolean platform = object.getPhysics().isPlatform();

			if (!object.equals(subject)) {

				if (Intersector.overlapConvexPolygons(subject.getPhysics()
						.getPoly(), object.getPhysics().getPoly())) {
					collided = true;
				}

				if (collided && platform) {
					if (object.getPhysics().getPosition().y >= ((subject
							.getPhysics().getPosition().y + subject
							.getPhysics().getRect().height) - 2f)) {
						subject.getPhysics().setOnTopOfObject(
								object.getPhysics());

						return PhysEngine.collision.setCollision(subject,
								object, CollisionType.ONTOP);
					} else {
						return PhysEngine.collision.setCollision(subject,
								object, CollisionType.CRASHED);
					}
				} else if (collided) {
					return PhysEngine.collision.setCollision(subject, object,
							CollisionType.CRASHED);
				} else if ((subject.getPhysics().getRect().x + (subject
						.getPhysics().getRect().width / 2)) > (object
								.getPhysics().getRect().x + object.getPhysics()
								.getRect().width)) {
					return PhysEngine.collision.setCollision(subject, object,
							CollisionType.PASSED);
				}
			}
		}

		return PhysEngine.collision.setCollision(subject, null,
				CollisionType.NONE);
	}
}
