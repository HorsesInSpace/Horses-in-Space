package com.HiS.gameobject;

import com.badlogic.gdx.Gdx;

public class Horse implements GameObject {

	private static Horse instance = null;
	
	public static Horse getInstance() {
		if(instance == null) {
			instance = new Horse();
		}
		
		return instance;
	}
	
	@Override
	public void update(float delta) {
		// TODO Auto-generated method stub
		Gdx.app.log("GameObect", "updating");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
