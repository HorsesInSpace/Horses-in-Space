package com.HiS.physics;

import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Physics is an object which stores a game object's physical values. It assumes
 * all objects as rectangles
 *
 * @author lars, morten
 * @version 0.2
 *
 */
public class Physics {

	private float weight;

	private boolean isGrounded = true;
	private Physics onTopOfObject = null;

	private boolean platform;

	private Rectangle rect;
	private Polygon poly;

	private Vector2 position;
	private Vector2 velocity;
	private Vector2 acceleration;

	/**
	 * Constructor for class Physics
	 *
	 * @param width
	 *            width of the object
	 * @param height
	 *            height of the object
	 * @param weight
	 *            weight of the object, used to offset jump height
	 * @param posX
	 *            position on screen, X axis
	 * @param posY
	 *            position on screen, Y axis
	 */
	public Physics(int width, int height, float weight, float posX, float posY,
			Polygon poly) {
		this.weight = weight;

		// Rectangle is used as an easier way to detect collisions in physEngine
		this.rect = new Rectangle(posX, posY + height, width, height);

		this.poly = poly;
		if (this.poly == null) {
			setPoly(Utilities.rectangleToPolygon(this.rect));
		}
		this.poly.setPosition(this.rect.x, this.rect.y);
		this.platform = false;

		this.position = new Vector2(posX, posY);
		this.velocity = new Vector2(0, 0);
		this.acceleration = new Vector2(0, this.weight);

	}

	/**
	 * getter for the weight of the object weight and the current weight of the
	 * object
	 */
	public float getWeight() {
		return this.weight;
	}

	/**
	 * setter for the weight parameter of the object
	 *
	 * @param height
	 *            the new weight for the object
	 */
	public void setWeight(float weight) {
		this.weight = weight;
	}

	/**
	 * boolean to check if the object is on the gthis.isGrounded@return true if
	 * horse is on the ground, false if not
	 */
	public boolean isGrounded() {
		return this.isGrounded;
	}

	/**
	 * sets the value of grounded to true or false
	 *
	 * @param isGrounded
	 *            the new value for isGrounded
	 */
	public void setGrounded(boolean isGrounded) {
		this.isGrounded = isGrounded;
	}

	public boolean isPlatform() {
		return this.platform;
	}

	public void setPlatform(boolean platform) {
		this.platform = platform;
	}

	/**
	 * boolean to check if the object is on tothis.isOnTopOfObject *
	 *
	 * @return isOnTopOfObject the new value for isOnTopOfObject
	 */
	public boolean isOnTopOfObject() {
		return this.onTopOfObject != null;
	}

	/**
	 * set the value of isOnTopOfObject to true or false
	 *
	 * @param isOnTopOfObject
	 *            the new value for isOnTopOfObject
	 */
	public void setOnTopOfObject(Physics onTopOfObject) {
		this.onTopOfObject = onTopOfObject;
	}

	public Physics getOnTopOfObject() {
		return this.onTopOfObject;
	}

	/**
	 * Getter for the rectangle of the object
	 *
	 * @return the rectangle
	 */
	public Rectangle getRect() {
		return this.rect;
	}

	/**
	 * setter for the rectangle of ththis.poly *
	 *
	 * @param rect
	 *            the new rectangle of the object
	 */
	public void setRect(Rectangle rect) {
		this.rect = rect;
	}

	public Polygon getPoly() {
		return this.poly;
	}

	public void setPoly(Polygon poly) {
		this.poly = poly;
	}

	/**
	 * getter for the objects velocity
	 *
	 * @return the objects velocity
	 */
	public Vector2 getVelocity() {
		return this.velocity;
	}

	/**
	 * setter for the objects velocity
	 *
	 * @param velocity
	 *            the new velocity of the object
	 */
	public void setVelocity(Vector2 velocity) {
		this.velocity = velocity;
	}

	/**
	 * getter for the objects current position
	 *
	 * @return the position of the object
	 */
	public Vector2 getPosition() {
		return this.position;
	}

	/**
	 * setter for the objects position
	 *
	 * @param position
	 *            the new position
	 */
	public void setPosition(Vector2 position) {
		this.position = position;
		this.rect.x = this.position.x;
		this.rect.y = this.position.y;
	}

	/**
	 * getter for the current acceleration of the object
	 *
	 * @return the acceleration of the object
	 */
	public Vector2 getAcceleration() {
		return this.acceleration;
	}

	/**
	 * setter for the objects acceleration
	 *
	 * @param acceleration
	 *            the new acceleration of the object
	 */
	public void setAcceleration(Vector2 acceleration) {
		this.acceleration = acceleration;
	}
}
