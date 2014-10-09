package com.HiS.gameobject.obstacle;

import com.HiS.hishelpers.AssetLoader;

public class Fence extends Obstacle {

	public Fence(float x, float y) {
		super(AssetLoader.fence, 1000, 1, 9, 1000, x, y, null);
		getPhysics().getPoly().setPosition(x, y + 50);
	}
}
