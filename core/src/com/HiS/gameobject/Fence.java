package com.HiS.gameobject;

import com.HiS.hishelpers.AssetLoader;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Fence extends Obstacle {

	public Fence(float x, float y) {
		super(AssetLoader.fence, 3, 7, 1000, x, y);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void update(float delta) {
		Rectangle rect = this.getPhysics().getRect();
		Vector2 position = this.getPhysics().getPosition();
		if((rect.x + rect.width) < 0) {
			this.getPhysics().setPosition(new Vector2(position.x + 250, position.y));
			this.setCrashed(false);
		}
	}
}
