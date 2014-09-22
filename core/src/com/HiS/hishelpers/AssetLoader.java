package com.HiS.hishelpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Static class used to load data such as Textures, sounds and other
 * assets from files
 * @author Morten, Lars
 * @version 0.3
 */
public class AssetLoader {
	private static Texture texture;
	
	public static TextureRegion horse, horse2, horse3, horseJump;
	public static TextureRegion background;
	public static TextureRegion foreground;
	public static TextureRegion fence;
	public static TextureRegion middleground1;
	public static Animation anim;
	
	public static Sound whinning;
	public static Sound gallopSound;
	public static Sound punch;
	
	public static Music badHorsie;
	public static Music journey;
	public static Music gallopMusic;
	
	/**
	 * Loads all assets into memory for universal access
	 */
	public static void load() {
		texture = new Texture(Gdx.files.internal("data/textures.png"));
		texture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		
		horse = new TextureRegion(texture, 0,450,150,93);
		horse.flip(false, true);
		horse2 = new TextureRegion(texture, 0,550,150,93);
		horse2.flip(false, true);
		horse3 = new TextureRegion(texture, 0,645,150,93);
		horse3.flip(false, true);
		horseJump = new TextureRegion(texture, 0, 748, 150, 93);
		horseJump.flip(false, true);
		
		TextureRegion[] horses = {horse, horse2, horse3};
		anim = new Animation(0.10f, horses);
		anim.setPlayMode(PlayMode.LOOP_PINGPONG);
		
		background = new TextureRegion(texture, 101, 0, 399, 240);
		background.flip(false, true);
		
		middleground1 = new TextureRegion(texture, 11, 326, 1277,99);
		middleground1.flip(false, true);
		
		foreground = new TextureRegion(texture, 102, 250, 399, 62);
		foreground.flip(false, true);
		
		fence = new TextureRegion(texture, 920, 448, 9, 84);
		fence.flip(false, true);
		
		whinning = Gdx.audio.newSound(Gdx.files.internal("data/whinning.ogg"));
		gallopSound = Gdx.audio.newSound(Gdx.files.internal("data/gallop.ogg"));
		
		badHorsie = Gdx.audio.newMusic(Gdx.files.internal("data/bad_horsie.ogg"));
		journey = Gdx.audio.newMusic(Gdx.files.internal("data/Journey.ogg"));
		gallopMusic = Gdx.audio.newMusic(Gdx.files.internal("data/gallop.ogg"));
		
		punch = Gdx.audio.newSound(Gdx.files.internal("data/punchPain.ogg"));
	}
	
	/**
	 * removes assets from memory
	 */
	public static void dispose() {
		texture.dispose();

		badHorsie.dispose();
		gallopMusic.dispose();
		gallopSound.dispose();
		journey.dispose();
		punch.dispose();
		whinning.dispose();
	}
}
