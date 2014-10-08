package com.HiS.gameobject.obstacle;

import com.HiS.hishelpers.AssetLoader;

public class Fence extends Obstacle {

	public Fence(float x, float y) {
		super(AssetLoader.fence, 1000, 1, 9, 1000, x, y, null);
	}

	@Override
	public void update(float delta, float runTime) {

	}
}
