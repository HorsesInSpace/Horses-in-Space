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
	public static TextureRegion background;
	public static TextureRegion foreground;
	public static TextureRegion fence;
	public static TextureRegion middleground1;
	
	public static Sound whinning;
	public static Sound gallop;
	public static Sound punch;
	public static Sound horsePain;
	
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
		
		background = new TextureRegion(texture, 101, 0, 399, 240);
		background.flip(false, true);
		
		middleground1 = new TextureRegion(texture, 11, 326, 1277,99);
		middleground1.flip(false, true);
		
		foreground = new TextureRegion(texture, 102, 250, 399, 62);
		foreground.flip(false, true);
		
		fence = new TextureRegion(texture, 0, 0, 83,94);
		fence.flip(false, true);
		
		whinning = Gdx.audio.newSound(Gdx.files.internal("data/whinning.mp3"));
		gallop = Gdx.audio.newSound(Gdx.files.internal("data/gallop.mp3"));
		
		badHorsie = Gdx.audio.newMusic(Gdx.files.internal("data/bad_horsie.mp3"));
		journey = Gdx.audio.newMusic(Gdx.files.internal("data/Journey.mp3"));
		
		punch = Gdx.audio.newSound(Gdx.files.internal("data/punchPain.mp3"));
	}
	
	/**
	 * removes assets from memory
	 */
	public static void dispose() {
		texture.dispose();
	}
}
