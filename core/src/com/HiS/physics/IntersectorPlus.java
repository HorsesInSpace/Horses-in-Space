package com.HiS.physics;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;

public final class IntersectorPlus {

	public static boolean overlapConvexPolygonRect(Polygon polygon,
			Rectangle rectangle) {
		Polygon rectPoly = new Polygon(new float[] { rectangle.x, rectangle.y,
				rectangle.x + rectangle.width, rectangle.y,
				rectangle.x + rectangle.width, rectangle.y + rectangle.height,
				rectangle.x, rectangle.y + rectangle.height });
		return Intersector.overlapConvexPolygons(polygon, rectPoly);
	}

	// public static boolean overlapConcavePolygonRect(Polygon polygon,
	// Rectangle rectangle) {
	// Vector2 topLeft = new Vector2(rectangle.x, rectangle.y
	// + rectangle.height);
	// Vector2 topRight = new Vector2(rectangle.x + rectangle.width,
	// rectangle.y + rectangle.height);
	// Vector2 bottomLeft = new Vector2(rectangle.x, rectangle.y);
	// Vector2 bottomRight = new Vector2(rectangle.x + rectangle.width,
	// rectangle.y);
	//
	// if (intersectLinePolygon(topLeft, bottomLeft, polygon)) {
	// return true;
	// } else if (Intersector.intersectSegmentPolygon(topLeft, topRight,
	// polygon)) {
	// return true;
	// } else if (Intersector.intersectSegmentPolygon(bottomLeft, bottomRight,
	// polygon)) {
	// return true;
	// } else if (Intersector.intersectSegmentPolygon(topRight, bottomRight,
	// polygon)) {
	// return true;
	// } else {
	// return false;
	// }
	// }
	//
	// public static boolean intersectLinePolygon(Vector2 p1, Vector2 p2,
	// Polygon polygon) {
	// float[] vertices = polygon.getTransformedVertices();
	// float x1 = p1.x, y1 = p1.y, x2 = p2.x, y2 = p2.y;
	// int n = vertices.length;
	// float x3 = vertices[n - 2], y3 = vertices[n - 1];
	// for (int i = 0; i < n; i += 2) {
	// float x4 = vertices[i], y4 = vertices[i + 1];
	// float d = ((y4 - y3) * (x2 - x1)) - ((x4 - x3) * (y2 - y1));
	// if (d != 0) {
	// float yd = y1 - y3;
	// float xd = x1 - x3;
	// float ua = (((x4 - x3) * yd) - ((y4 - y3) * xd)) / d;
	// if ((ua >= 0) && (ua <= 1)) {
	// return true;
	// }
	// }
	// x3 = x4;
	// y3 = y4;
	// }
	// return false;
	// }
}
