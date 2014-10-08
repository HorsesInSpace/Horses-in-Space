package com.HiS.physics;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;


public final class IntersectorPlus {

	public static boolean overlapConcavePolygonRect(Polygon polygon, Rectangle rectangle) {
		Vector2 topLeft = new Vector2(rectangle.x, rectangle.y + rectangle.height);
		Vector2 topRight = new Vector2(rectangle.x + rectangle.width, rectangle.y + rectangle.height);
		Vector2 bottomLeft = new Vector2(rectangle.x, rectangle.y);
		Vector2 bottomRight = new Vector2(rectangle.x + rectangle.width, rectangle.y);
		
		if (Intersector.intersectLinePolygon(topLeft, bottomLeft, polygon)) {
			return true;
		} else if (Intersector.intersectLinePolygon(topLeft, topRight, polygon)) {
			return true;
		} else if (Intersector.intersectLinePolygon(bottomLeft, bottomRight, polygon)) {
			return true;
		} else if (Intersector.intersectLinePolygon(topRight, bottomRight, polygon)) {
			return true;
		} else {
			return false;
		}
	}
}
