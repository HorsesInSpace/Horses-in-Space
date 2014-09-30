package com.HiS.gameobject;

import com.HiS.hishelpers.AssetLoader;

public class Satellite extends Obstacle {

	public Satellite(float x, float y) {
		super(AssetLoader.fence, 2, 7, 1000, x, y);
	}

	@Override
	public void update(float delta) {

	}
	
}
