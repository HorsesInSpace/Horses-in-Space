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
		return collisionType;
	}

	public void setCollisionType(CollisionType collisionType) {
		this.collisionType = collisionType;
	}

	public PhysObject getSubject() {
		return subject;
	}

	public void setSubject(PhysObject subject) {
		this.subject = subject;
	}

	public PhysObject getObject() {
		return object;
	}

	public void setObject(PhysObject object) {
		this.object = object;
	}
	
	
}