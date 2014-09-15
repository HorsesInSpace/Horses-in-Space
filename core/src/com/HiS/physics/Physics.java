package com.HiS.physics;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Physics is an object which stores a game object's physical values.
 * It assumes all objects as rectangles
 * 
 * @author lars, morten
 * @version 0.2
 *
 */
public class Physics {
	
	private int width;
	private int height;
	private float weight;
	
	private boolean isGrounded;
	
	private Rectangle rect;
	
	private Vector2 velocity;
	private Vector2 position;
	private Vector2 acceleration;
	
	/**
	 * Constructor for class Physics
	 * @param width width of the object
	 * @param height height of the object
	 * @param weight weight of the object, used to offset jump height
	 * @param posX position on screen, X axis
	 * @param posY position on screen, Y axis
	 */
	public Physics(int width, int height, float weight, float posX, float posY) {
		this.width = width;
		this.height = height;
		this.weight = weight;
		
        this.rect = new Rectangle(posX+height,posY,width,height); 
        //Rectangle is used as an easier way to detect collisions in physEngine
		
		this.position = new Vector2(posX, posY);
        this.velocity = new Vector2(0, 0);
        this.acceleration = new Vector2(0, this.weight);
        
	}

	/**
	 * getter for the width field
	 * @return the current width of the object
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * setter for the width field
	 * @param width the new width of the object
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * getter for the height of the object
	 * @return the current height of the object
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * setter for the height parameter of the object
	 * @param height the new height for the object
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	
	/**
	 * getter for the weight of the object
	 * @return the current weight of the object
	 */
	public float getWeight() {
		return weight;
	}

	/**
	 * setter for the weight parameter of the object
	 * @param height the new weight for the object
	 */
	public void setWeight(float weight) {
		this.weight = weight;
	}

	/**
	 * boolean to check if the object is on the ground
	 * @return true if horse is on the ground, false if not
	 */
	public boolean isGrounded() {
		return isGrounded;
	}

	/**
	 * sets the value of grounded to true or false
	 * @param isGrounded the new value for isGrounded
	 */
	public void setGrounded(boolean isGrounded) {
		this.isGrounded = isGrounded;
	}

	/**
	 * Getter for the rectangle of the object
	 * @return the rectangle
	 */
	public Rectangle getRect() {
		return rect;
	}

	/**
	 * setter for the rectangle of the object
	 * @param rect the new rectangle of the object
	 */
	public void setRect(Rectangle rect) {
		this.rect = rect;
	}

	/**
	 * getter for the objects velocity
	 * @return the objects velocity
	 */
	public Vector2 getVelocity() {
		return velocity;
	}

	/**
	 * setter for the objects velocity
	 * @param velocity the new velocity of the object
	 */
	public void setVelocity(Vector2 velocity) {
		this.velocity = velocity;
	}

	/**
	 * getter for the objects current position
	 * @return the position of the object
	 */
	public Vector2 getPosition() {
		return position;
	}

	/**
	 * setter for the objects position
	 * @param position the new position
	 */
	public void setPosition(Vector2 position) {
		this.position = position;
	}

	/**
	 * getter for the current acceleration of the object
	 * @return the acceleration of the object
	 */
	public Vector2 getAcceleration() {
		return acceleration;
	}

	/**
	 * setter for the objects acceleration
	 * @param acceleration the new acceleration of the object
	 */
	public void setAcceleration(Vector2 acceleration) {
		this.acceleration = acceleration;
	}
}
