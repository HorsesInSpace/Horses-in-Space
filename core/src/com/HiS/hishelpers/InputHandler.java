package com.HiS.hishelpers;

import com.HiS.gameobject.GameObject;
import com.HiS.gameobject.Horse;
import com.HiS.screen.GameScreen;
import com.HiS.world.GameWorld;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;

/**
 * Class that handles input for control of the game
 *
 * @author Vemund, Lars
 * @version 0.3
 *
 */
public class InputHandler implements InputProcessor {

	private GameWorld world;
	private GameScreen screen;

	/**
	 * Constructor for class InputHandler
	 *
	 * @param world
	 *            the world of the game
	 */
	public InputHandler(GameWorld world, GameScreen screen) {
		this.world = world;
		this.screen = screen;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {

		for (GameObject gameObject : this.world.getObjects()) {
			if (GameScreen.running && (gameObject instanceof Horse)) {
				if (screenX < (GameScreen.screenWidth / 2)) {
					((Horse) gameObject).jump();
				} else {
					((Horse) gameObject).slide();
				}
			}
		}

		if (!GameScreen.running) {
			this.world = this.screen.restart();
		}
		return true;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean keyDown(int keycode) {
		if (GameScreen.running
				&& ((keycode == Input.Keys.SPACE) || (keycode == Input.Keys.W) || (keycode == Input.Keys.UP))) {
			for (GameObject gameObject : this.world.getObjects()) {
				if (gameObject instanceof Horse) {
					((Horse) gameObject).jump();
				}
			}
			return true;
		}
		if (GameScreen.running
				&& ((keycode == Input.Keys.CONTROL_LEFT)
						|| (keycode == Input.Keys.S) || (keycode == Input.Keys.DOWN))) {
			for (GameObject gameObject : this.world.getObjects()) {
				if (gameObject instanceof Horse) {
					((Horse) gameObject).slide();
				}
			}
			return true;
		}
		if (!GameScreen.running && (keycode == Input.Keys.R)) {
			this.world = this.screen.restart();
		}

		// reset highscore TESTING PURPOSES
		if (Gdx.input.isKeyPressed(Keys.CONTROL_LEFT)
				&& Gdx.input.isKeyPressed(Keys.SHIFT_LEFT)
				&& Gdx.input.isKeyPressed(Keys.R)) {
			AssetLoader.resetHighScore();
		}
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		if (GameScreen.running
				&& ((keycode == Input.Keys.CONTROL_LEFT)
						|| (keycode == Input.Keys.S) || (keycode == Input.Keys.DOWN))) {
			for (GameObject gameObject : this.world.getObjects()) {
				if (gameObject instanceof Horse) {
					((Horse) gameObject).unSlide();
				}
			}
			return true;
		}
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		if (GameScreen.running) {
			for (GameObject gameObject : this.world.getObjects()) {
				if (gameObject instanceof Horse) {
					((Horse) gameObject).unSlide();
					return true;
				}
			}

		}
		return false;

	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}
}