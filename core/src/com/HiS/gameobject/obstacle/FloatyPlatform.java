package com.HiS.gameobject.obstacle;

import com.HiS.hishelpers.AssetLoader;

public class FloatyPlatform extends Obstacle {

	public FloatyPlatform(float posX, float posY) {
		super(AssetLoader.moonForeground, 1500, 20, 3, 0, posX, posY, null);
		getPhysics().setPlatform(true);
	}
}
