package com.HiS.hishelpers;

import com.HiS.gameobject.GameObject;
import com.HiS.gameobject.Horse;
import com.HiS.world.GameWorld;
import com.badlogic.gdx.InputProcessor;

/**
 * Class that handles input for control of the game
 * @author Vemund, Lars
 * @version 0.3
 *
 */
public class InputHandler implements InputProcessor{
	
	private GameWorld world;
	
	/**
	 * Constructor for class InputHandler
	 * @param world the world of the game
	 */
	public InputHandler(GameWorld world) {
		this.world = world;
	}
	
	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		for(GameObject gameObject : world.getObjects()) {
			if (gameObject instanceof Horse) {
				((Horse) gameObject).jump();
			}
		}
		return true;
	}
	
	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
		}
		
	@Override
	public boolean keyDown(int keycode) {
		return false;
	}
	
	@Override
	public boolean keyUp(int keycode) {
		return false;
	}
	
	@Override
	public boolean keyTyped(char character) {
		return false;
	}
	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
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