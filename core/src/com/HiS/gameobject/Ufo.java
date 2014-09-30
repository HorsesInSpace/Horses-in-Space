package com.HiS.gameobject;

import com.HiS.hishelpers.AssetLoader;

public class Ufo extends Obstacle {

	public Ufo(float x, float y) {
		super(AssetLoader.fence, 2, 7, 1000, x, y);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void update(float delta, float runTime) {

	}

}
