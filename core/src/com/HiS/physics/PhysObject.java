package com.HiS.physics;

public interface PhysObject {
	
	/**
	 * This method returns a Physics object related to the gameObject
	 * @return physics of the gameObject
	 */
	public Physics getPhysics();
	
	public void ground();
	
	public void setPhysics(Physics physics);
	
	public void handleCollision(PhysObject object);
	
	public boolean hasCrashed();
	
	public void setCrashed(boolean crash);
}