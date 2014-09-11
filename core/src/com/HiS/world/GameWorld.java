package com.HiS.world;

import java.util.ArrayList;

import com.HiS.gameobject.GameObject;
import com.HiS.gameobject.Horse;
import com.HiS.screen.GameScreen;
import com.badlogic.gdx.math.Rectangle;


public class GameWorld {
	
	private Rectangle rect = new Rectangle(0, 0, 34, 24);
	private ArrayList<GameObject> objects = new ArrayList<>();
	
	private boolean goingRight = true;
	private boolean goingDown = true;

	public GameWorld() {
		Horse horse = new Horse();
		objects.add(horse);
	}
	
	public void update(float delta) {
		for(GameObject gameObject : objects) {
			gameObject.update(delta);
		}
		if (rect.x == 0) {
			goingRight = true;
		} else if ((rect.x + rect.width) > 137) {
			goingRight = false;
		}
		
		if (rect.y == 0) {
			goingDown = true;
		} else if ((rect.y + rect.height) > GameScreen.gameHeight) {
			goingDown = false;
		}
		
		if (goingRight) {
			rect.x++;
		} else {
			rect.x--;
		}
		
		if (goingDown) {
			rect.y++;
		} else {
			rect.y--;
		}
	}

	public Rectangle getRect() {
		return rect;
	}
}
