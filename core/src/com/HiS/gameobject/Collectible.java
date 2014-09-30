package com.HiS.gameobject;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Collectible extends PhysGameObject {
	
	private int points;

	public Collectible(TextureRegion texture, int width, int height,
			float weight, float posX, float posY, int points) {
		super(texture, width, height, weight, posX, posY);
		
		this.points = points;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

}
