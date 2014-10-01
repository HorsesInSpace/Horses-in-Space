package com.HiS.gameobject.points;

import com.HiS.gameobject.PhysGameObject;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Collectible extends PhysGameObject implements PointObject {
	
	private int points;

	public Collectible(TextureRegion texture, int width, int height,
			float weight, float posX, float posY, int points) {
		super(texture, width, height, weight, posX, posY);
		
		this.points = points;
	}

	@Override
	public int getPoints() {
		return points;
	}

	@Override
	public void setPoints(int points) {
		this.points = points;
	}

}
