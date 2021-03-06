package com.HiS.gameobject.obstacle;

import com.HiS.hishelpers.AssetLoader;

public class FloatyPlatform extends Obstacle {

	public FloatyPlatform(float posX, float posY) {
		super(AssetLoader.moonForeground, 0, 20, 3, 0, posX, posY, null);
		this.getPhysics().setPlatform(true);
	}
}
