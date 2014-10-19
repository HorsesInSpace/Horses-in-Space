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
		 * Works with desktop, not with android, calling pause on a specific
		 * sound object is suddenly global on android.
		 */
		AssetLoader.gallopSound.pause();

		/**
		 * But check this out! when gallopSound.play is called it creates a long
		 * for the playback ID!
		 */
		long soundId = AssetLoader.gallopSound.play(volume);

		/**
		 * Use this with android and it suddenly works!
		 */
		AssetLoader.gallopSound.pause(soundId);

		/**
		 * The problem is that one solution works and one does not, this is not
		 * explained at all in the documentation.
		 */
	}
}
