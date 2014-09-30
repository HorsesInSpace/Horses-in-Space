package com.HiS.gameobject;

import com.HiS.graphics.GfxObject;
import com.HiS.physics.PhysObject;
import com.HiS.physics.Physics;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class PhysGameObject implements GameObject, PhysObject, GfxObject {
	
	protected Physics physics;
	protected TextureRegion texture;

	public PhysGameObject(TextureRegion texture, int width, int height, float weight, float posX, float posY) {
		this.physics = new Physics(width, height, weight, posX, posY);
		this.texture = texture;
	}
	
	@Override
	public void update(float delta) {
		// TODO Auto-generated method stub

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}
	
	@Override
	public Physics getPhysics() {
		return this.physics;
	}

	@Override
	public TextureRegion getTexture() {
		return this.texture;
	}

	public void setTexture(TextureRegion texture) {
		this.texture = texture;
	}
	
	/**
	 * Sets the Physics.grounded to true
	 */
	@Override
	public void ground() {
		this.physics.setGrounded(true);
	}
	
	@Override
	public void setPhysics(Physics physics) {
		this.physics = physics;
	}
	
	@Override
	public void handleCollision(PhysObject object) {
	}
	
	@Override
	public void setCrashed(boolean crash) {
	}
	
	@Override
	public boolean hasCrashed() {
		return false;
	}
	
	@Override
	public Vector2 getPosition() {
		return this.physics.getPosition();
	}
	
	@Override
	public void setPosition(int x, int y) {
		this.physics.setPosition(new Vector2(x, y));
	}
	
	@Override
	public Rectangle getRect() {
		return this.getPhysics().getRect();
	}

}
