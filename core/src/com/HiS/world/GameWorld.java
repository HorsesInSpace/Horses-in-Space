package com.HiS.world;

import com.badlogic.gdx.math.Rectangle;


public class GameWorld {
	
	private Rectangle rect = new Rectangle(0, 0, 34, 24);

	public GameWorld() {
		
	}
	
	public void update(float delta) {
		this.rect.x++;
		if (rect.x > 137) {
			rect.x = 0;
		}
	}

	public Rectangle getRect() {
		return rect;
	}
}
