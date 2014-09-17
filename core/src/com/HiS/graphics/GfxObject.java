package com.HiS.graphics;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public interface GfxObject {
	
	/**
	 * This method returns a Texture object related to the gameObject
	 * @return texture
	 */
	public TextureRegion getTexture();
	
	public void setTexture(TextureRegion texture);
	
	public Vector2 getPosition();
	
	public void setPosition(int x, int y);
}
