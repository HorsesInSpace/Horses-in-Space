package com.HiS.gameobject;

import com.HiS.hishelpers.AssetLoader;

public class Fence extends Obstacle {

	public Fence(float x, float y) {
		super(AssetLoader.fence, 3, 7, 1000, x, y);
	}
	
	@Override
	public void update(float delta) {

	}
}
