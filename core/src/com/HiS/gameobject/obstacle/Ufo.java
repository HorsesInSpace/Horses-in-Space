package com.HiS.gameobject.obstacle;

import com.HiS.hishelpers.AssetLoader;

public class Ufo extends Obstacle {
	public Ufo(float x, float y) {
		super(AssetLoader.ufo, 2000, 30, 20, 0, x, y, AssetLoader.polyUfo);
		getPhysics().getPoly().setScale(0.087f, 0.1f);
		getPhysics().getPoly().setPosition(x, y + 50);
	}
}
