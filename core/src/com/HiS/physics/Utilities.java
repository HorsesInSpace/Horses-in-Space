package com.HiS.physics;

import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;

public final class Utilities {
	public static Polygon rectangleToPolygon(Rectangle rectangle) {
		Polygon polygon = new Polygon();
		polygon.setOrigin(0, 0);
		polygon.setPosition(rectangle.x, rectangle.y);
		polygon.setVertices(new float[] { 0, 0, 0 + rectangle.width, 0,
				0 + rectangle.width, 0 + rectangle.height, 0,
				0 + rectangle.height });

		return polygon;
	}
}
