package com.HiS.graphics;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class TexObject implements GfxObject{

	private TextureRegion texture;
	
	public TexObject(TextureRegion texture) {
		this.texture = texture;
	}
	
	@Override
	public TextureRegion getTexture() {
		return this.texture;
	}

	@Override
	public void setTexture(TextureRegion texture) {
		this.texture = texture;
	}

	@Override
	public Vector2 getPosition() {
		return new Vector2(texture.getRegionX(), texture.getRegionY());
	}

	@Override
	public void setPosition(int x, int y) {
		this.texture.setRegionX(x);
		this.texture.setRegionY(y);
		
	}

}
