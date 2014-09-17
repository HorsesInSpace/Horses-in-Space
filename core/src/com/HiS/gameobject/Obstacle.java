package com.HiS.gameobject;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public abstract class Obstacle extends PhysGameObject {

	private boolean crashed;
	
	public Obstacle(TextureRegion texture, int width, int height, float weight,
			float posX, float posY) {
		super(texture, width, height, weight, posX, posY);
		// TODO Auto-generated constructor stub
		crashed = false;
	}
	
	@Override
	public boolean hasCrashed() {
		return crashed;
	}
	
	@Override
	public void setCrashed(boolean crash) {
		this.crashed = crash;
	}
	
}
