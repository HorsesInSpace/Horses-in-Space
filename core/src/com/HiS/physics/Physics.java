package com.HiS.physics;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Physics is an object which stores a game object's physical values.
 * It assumes all objects as rectangles
 * 
 * @author lars
 * @version 0.1
 *
 */
public class Physics {
	
	private int width;
	private int height;
	private float weight;
	
	private Rectangle rect;
	
	private Vector2 velocity;
	private Vector2 position;
	
	public Physics(int width, int height, float weight, float posX, float posY) {
		this.width = width;
		this.height = height;
		this.weight = weight;
		
		this.position = new Vector2(posX, posY);
        this.velocity = new Vector2(0, 0);
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public Rectangle getRect() {
		return rect;
	}

	public void setRect(Rectangle rect) {
		this.rect = rect;
	}

	public Vector2 getVelocity() {
		return velocity;
	}

	public void setVelocity(Vector2 velocity) {
		this.velocity = velocity;
	}

	public Vector2 getPosition() {
		return position;
	}

	public void setPosition(Vector2 position) {
		this.position = position;
	}
}
