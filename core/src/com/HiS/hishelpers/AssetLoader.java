package com.HiS.hishelpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.PolygonRegionLoader;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Polygon;

/**
 * Static class used to load data such as Textures, sounds and other assets from
 * files
 *
 * @author Morten, Lars
 * @version 0.3
 */
public class AssetLoader {
	private static Texture texture;

	public static TextureRegion horse, horse2, horse3, horseJump, horseSlide,
			horseSplat, moonBackground, moonForeground, fence, ufo,
	earth;
	public static TextureRegion moonMiddleground;
	public static Animation anim;
	public static BitmapFont font, scoreFont;
	public static Polygon polyHorse, polyHorse2, polyHorse3, polyHorseJump,
	polyHorseSlide, polyUfo;

	public static Sound whinning, gallopSound, punch, thunder1;
	public static Music journey, gallopMusic, moon;

	public static Preferences prefs;

	/**
	 * Loads all assets into memory for universal access
	 */
	public static void load() {
		font = new BitmapFont(
				Gdx.files.internal("data/gfx/monohorseinspaced.fnt"));
		font.setScale(.10f, -.10f);
		
		scoreFont = new BitmapFont(
				Gdx.files.internal("data/gfx/audiowide.fnt"));
		scoreFont.setScale(.15f, -.15f);
		scoreFont.setColor(Color.WHITE);
		
		FileHandle textureHandle = Gdx.files.internal("data/gfx/textures.png");
		FileHandle horseHandle = Gdx.files
				.internal("data/polygon/horsetex.psh");
		FileHandle horse2Handle = Gdx.files
				.internal("data/polygon/horsetex2.psh");
		FileHandle horse3Handle = Gdx.files
				.internal("data/polygon/horsetex3.psh");
		FileHandle horseJumpHandle = Gdx.files
				.internal("data/polygon/horsetexjump.psh");
		FileHandle horseSlideHandle = Gdx.files
				.internal("data/polygon/horsetexslide.psh");
		FileHandle ufoHandle = Gdx.files.internal("data/polygon/ufotex.psh");

		texture = new Texture(textureHandle);
		texture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);

		horse = new TextureRegion(texture, 0, 450, 150, 93);
		horse.flip(false, true);
		horse2 = new TextureRegion(texture, 0, 548, 150, 93);
		horse2.flip(false, true);
		horse3 = new TextureRegion(texture, 0, 645, 150, 93);
		horse3.flip(false, true);
		horseJump = new TextureRegion(texture, 0, 748, 150, 93);
		horseJump.flip(false, true);
		horseSlide = new TextureRegion(texture, 0, 850, 150, 60);
		horseSlide.flip(false, true);
		horseSplat = new TextureRegion(texture, 210, 790, 190, 155);
		horseSplat.flip(false, true);
		ufo = new TextureRegion(texture, 280, 450, 345, 200);
		ufo.flip(false, true);

		PolygonRegionLoader prl = new PolygonRegionLoader();
		polyHorse = new Polygon(prl.load(horse, horseHandle).getVertices());
		polyHorse2 = new Polygon(prl.load(horse2, horse2Handle).getVertices());
		polyHorse3 = new Polygon(prl.load(horse3, horse3Handle).getVertices());
		polyHorseJump = new Polygon(prl.load(horseJump, horseJumpHandle)
				.getVertices());
		polyHorseSlide = new Polygon(prl.load(horseSlide, horseSlideHandle)
				.getVertices());
		polyUfo = new Polygon(prl.load(ufo, ufoHandle).getVertices());

		TextureRegion[] horses = { horse, horse2, horse3 };
		anim = new Animation(0.10f, horses);
		anim.setPlayMode(PlayMode.LOOP_PINGPONG);

		moonBackground = new TextureRegion(texture, 101, 0, 399, 240);
		moonBackground.flip(false, true);

		earth = new TextureRegion(texture, 1000, 445, 300, 300);
		earth.flip(false, true);

		moonMiddleground = new TextureRegion(texture, 11, 326, 1277, 99);
		moonMiddleground.flip(false, true);

		moonForeground = new TextureRegion(texture, 102, 250, 399, 62);
		moonForeground.flip(false, true);

		fence = new TextureRegion(texture, 920, 448, 9, 84);
		fence.flip(false, true);

		whinning = Gdx.audio.newSound(Gdx.files
				.internal("data/audio/sound/jump.ogg"));
		gallopSound = Gdx.audio.newSound(Gdx.files
				.internal("data/audio/sound/gallop.ogg"));
		thunder1 = Gdx.audio.newSound(Gdx.files
				.internal("data/audio/sound/thunder1.mp3"));
		journey = Gdx.audio.newMusic(Gdx.files
				.internal("data/audio/music/Journey.ogg"));
		gallopMusic = Gdx.audio.newMusic(Gdx.files
				.internal("data/audio/music/gallop.ogg"));
		moon = Gdx.audio.newMusic(Gdx.files
				.internal("data/audio/music/moon.mp3"));

		punch = Gdx.audio.newSound(Gdx.files
				.internal("data/audio/sound/punchPain.ogg"));

		// Create (or retrieve existing) preferences file
		prefs = Gdx.app.getPreferences("HorsesInSpace");

		// Provide default high score of 0
		if (!prefs.contains("highScore")) {
			prefs.putInteger("highScore", 0);
		}
	}

	// Receives an integer and maps it to the String highScore in prefs
	public static void setHighScore(long val) {
		prefs.putLong("highScore", val);
		prefs.flush();
	}

	// Retrieves the current high score
	public static long getHighScore() {
		return prefs.getLong("highScore");
	}

	public static void resetHighScore() {
		prefs.remove("highScore");
		prefs.flush();
	}

	/**
	 * removes assets from memory
	 */
	public static void dispose() {
		texture.dispose();

		gallopMusic.dispose();
		gallopSound.dispose();
		journey.dispose();
		punch.dispose();
		whinning.dispose();
		font.dispose();
	}
}
