package com.HiS.hishelpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetLoader {
	private static Texture texture;
	
	public static TextureRegion horse;
	
	public static void load() {
		texture = new Texture(Gdx.files.internal("data/textures.png"));
		texture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		
		horse = new TextureRegion(texture, 0,0,100,94);
		horse.flip(false, true);
	}
	
	public static void dispose() {
		texture.dispose();
	}
}
