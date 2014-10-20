package com.HiS.game;

import com.HiS.hishelpers.AssetLoader;

public class AudioExamples {

	public static void testAudio() {
		float volume = 0.5f;

		/**
		 * Works with desktop, not with android, sound volumes get all messed up
		 */
		AssetLoader.gallopSound.play();

		/**
		 * Works with both. Distinction not in documentation
		 */
		AssetLoader.gallopSound.play(volume);

		/**
		 * works locally on desktop, global on android
		 */
		AssetLoader.gallopSound.pause();

		/**
		 * playback id
		 */
		long soundId = AssetLoader.gallopSound.play(volume);

		/*
		 * Works with both
		 */
		AssetLoader.gallopSound.pause(soundId);
	}
}
