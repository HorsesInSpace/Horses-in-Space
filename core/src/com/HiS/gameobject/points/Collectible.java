package com.HiS.gameobject.points;

import com.HiS.gameobject.obstacle.Obstacle;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Polygon;

public class Collectible extends Obstacle implements PointObject {

	public Collectible(TextureRegion texture, int width, int height,
			float weight, float posX, float posY, int points, Polygon poly) {
		super(texture, points, width, height, weight, posX, posY, poly);
	}

	@Override
	public void setPassed(boolean passed) {
		super.setPassed(passed);
		if (passed) {
			// TODO: Test. Really test this. Seriously. Dude. Not joking. Test
			// this.
			this.texture = new TextureRegion();
		}
	}
}
