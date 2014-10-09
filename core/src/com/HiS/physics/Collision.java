package com.HiS.physics;

public class Collision {

	private CollisionType collisionType;
	private PhysObject subject;
	private PhysObject object;

	public Collision(CollisionType collisionType, PhysObject subject,
			PhysObject object) {
		super();
		this.collisionType = collisionType;
		this.subject = subject;
		this.object = object;
	}

	public CollisionType getCollisionType() {
		return this.collisionType;
	}

	public void setCollisionType(CollisionType collisionType) {
		this.collisionType = collisionType;
	}

	public PhysObject getSubject() {
		return this.subject;
	}

	public void setSubject(PhysObject subject) {
		this.subject = subject;
	}

	public PhysObject getObject() {
		return this.object;
	}

	public void setObject(PhysObject object) {
		this.object = object;
	}

	public Collision setCollision(PhysObject subject, PhysObject object,
			CollisionType collisionType) {
		this.setSubject(subject);
		this.setObject(object);
		this.setCollisionType(collisionType);
		return this;
	}

}