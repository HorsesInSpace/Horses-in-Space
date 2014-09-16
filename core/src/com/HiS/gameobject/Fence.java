package com.HiS.gameobject;

import com.HiS.hishelpers.AssetLoader;
import com.badlogic.gdx.math.Vector2;

public class Fence extends Obstacle {

	public Fence(float x, float y) {
		super(AssetLoader.fence, 3, 7, 1000, x, y);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void update(float delta) {
		if((this.getPhysics().getRect().x + this.getPhysics().getRect().width) < 0) {
			this.getPhysics().setPosition(new Vector2(this.getPhysics().getPosition().x + 250, this.getPhysics().getPosition().y));
		}
	}
}
