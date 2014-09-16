package com.HiS.gameobject;

import com.HiS.physics.PhysObject;
import com.HiS.physics.Physics;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public abstract class PhysGameObject implements GameObject, PhysObject {
	
	protected Physics physics;
	protected TextureRegion texture;

	public PhysGameObject(TextureRegion horse, int width, int height, float weight, float posX, float posY) {
		this.physics = new Physics(width, height, weight, posX, posY);
		this.texture = horse;
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

}
