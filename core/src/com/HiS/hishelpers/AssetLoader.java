package com.HiS.hishelpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Static class used to load data such as Textures, sounds and other
 * assets from files
 * @author Morten, Lars
 * @version 0.3
 */
public class AssetLoader {
	private static Texture texture;
	
	public static TextureRegion horse;
	public static TextureRegion backGround;
	public static TextureRegion ground;
	public static TextureRegion fence;
	
	public static Sound whinning;
	public static Sound gallop;
	
	public static Music badHorsie;
	public static Music journey;
	
	/**
	 * Loads all assets into memory for universal access
	 */
	public static void load() {
		texture = new Texture(Gdx.files.internal("data/textures.png"));
		texture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		
		horse = new TextureRegion(texture, 0,0,99,94);
		horse.flip(false, true);
		
		backGround = new TextureRegion(texture, 101, 0, 399, 240);
		backGround.flip(false, true);
		
		ground = new TextureRegion(texture, 102, 250, 399, 62);
		ground.flip(false, true);
		
		fence = new TextureRegion(texture, 0, 0, 83,94);
		fence.flip(false, true);
		
		whinning = Gdx.audio.newSound(Gdx.files.internal("data/whinning.mp3"));
		gallop = Gdx.audio.newSound(Gdx.files.internal("data/gallop.mp3"));
		
		badHorsie = Gdx.audio.newMusic(Gdx.files.internal("data/bad_horsie.mp3"));
		journey = Gdx.audio.newMusic(Gdx.files.internal("data/Journey.mp3"));
	}
	
	/**
	 * removes assets from memory
	 */
	public static void dispose() {
		texture.dispose();
	}
}
