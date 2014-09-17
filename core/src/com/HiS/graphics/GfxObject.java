package com.HiS.graphics;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public interface GfxObject {
	
	public TextureRegion getTexture();
	
	public void setTexture(TextureRegion texture);
	
	public Vector2 getPosition();
	
	public void setPosition(float x, float y);
}
