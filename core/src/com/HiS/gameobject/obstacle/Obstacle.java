package com.HiS.gameobject.obstacle;

import com.HiS.gameobject.PhysGameObject;
import com.HiS.gameobject.points.PointObject;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Polygon;

public abstract class Obstacle extends PhysGameObject implements PointObject {

	private boolean crashed = false;
	private int points;
	private boolean passed = false;

	public Obstacle(TextureRegion texture, int points, int width, int height,
			float weight, float posX, float posY, Polygon poly) {
		super(texture, width, height, weight, posX, posY, poly);
		// TODO Auto-generated constructor stub
		this.points = points;
	}

	@Override
	public boolean hasCrashed() {
		return this.crashed;
	}

	@Override
	public void setCrashed(boolean crash) {
		this.crashed = crash;
	}

	@Override
	public int getPoints() {
		return this.points;
	}

	@Override
	public void setPoints(int points) {
		this.points = points;
	}

	@Override
	public boolean isPassed() {
		return this.passed;
	}

	@Override
	public void setPassed(boolean passed) {
		this.passed = passed;
	}
}
