package com.HiS.gameobject.obstacle;

import com.HiS.hishelpers.AssetLoader;

public class Ufo extends Obstacle {

	public Ufo(float x, float y) {
		super(AssetLoader.fence, 20, 2, 7, 1000, x, y);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void update(float delta, float runTime) {

	}

}
