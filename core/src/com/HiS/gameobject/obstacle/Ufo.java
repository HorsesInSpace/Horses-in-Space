package com.HiS.gameobject.obstacle;

import com.HiS.hishelpers.AssetLoader;
import com.badlogic.gdx.math.Polygon;

public class Ufo extends Obstacle {
	public Ufo(float x, float y) {
		super(AssetLoader.ufo, 1500, 30, 20, 0, x, y, new Polygon(
				AssetLoader.polyUfo.getVertices()));
		this.getPhysics().getPoly().setScale(0.087f, 0.1f);
		this.getPhysics().getPoly().setPosition(x, y + 50);
	}
}
