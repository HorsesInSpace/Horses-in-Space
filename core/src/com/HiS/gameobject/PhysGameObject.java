package com.HiS.gameobject;

import com.HiS.physics.PhysObject;
import com.HiS.physics.Physics;
import com.badlogic.gdx.graphics.Texture;

public abstract class PhysGameObject implements GameObject, PhysObject {
	
	protected Physics physics;
	protected Texture texture;

	public PhysGameObject(Texture texture, int width, int height, float weight, float posX, float posY) {
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
	public Texture getTexture() {
		return this.texture;
	}

	public void setTexture(Texture texture) {
		this.texture = texture;
	}

}
