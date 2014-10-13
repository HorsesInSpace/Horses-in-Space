package com.HiS.level;

import java.util.ArrayList;
import java.util.List;

import com.HiS.gameobject.PhysGameObject;
import com.HiS.gameobject.obstacle.Fence;
import com.HiS.gameobject.obstacle.FloatyPlatform;
import com.HiS.gameobject.obstacle.Ufo;
import com.HiS.hishelpers.CsvLoader;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Level {

	private String name;
	private TextureRegion backGround;
	private TextureRegion middleGround;
	private TextureRegion foreGround;

	private List<PhysGameObject> objects = new ArrayList<>();

	public Level(String filePath) {
		List<String[]> list = CsvLoader.LevelLoader(filePath);
		String[] levelDetails = list.get(0);
		List<PhysGameObject> objects = new ArrayList<>();
		for (int i = 1; i < list.size(); i++) {
			String[] values = list.get(i);
			try {
				objects.add(this.createPhysGameObject(values));
			} catch (PhysGameObjectNotRecognizedException e) {
				continue;
			}
		}

		this.generateLevel(this.backGround, this.middleGround, this.foreGround,
				levelDetails[0], objects);
	}

	private PhysGameObject createPhysGameObject(String[] values)
			throws PhysGameObjectNotRecognizedException {
		String typeString = values[0];
		char type = typeString.charAt(0);
		int x = Integer.parseInt(values[1]);
		int y = Integer.parseInt(values[2]);

		switch (type) {
		case 'F':
			return new Fence(x, y);
		case 'P':
			return new FloatyPlatform(x, y);
		case 'U':
			return new Ufo(x, y);
		default:
			throw new PhysGameObjectNotRecognizedException();
		}
	}

	public Level(TextureRegion backGround, TextureRegion middleGround,
			TextureRegion foreGround, String name, List<PhysGameObject> objects) {
		this.generateLevel(backGround, middleGround, foreGround, name, objects);
	}

	private void generateLevel(TextureRegion backGround,
			TextureRegion middleGround, TextureRegion foreGround, String name,
			List<PhysGameObject> objects) {
		this.name = name;
		this.backGround = backGround;
		this.middleGround = middleGround;
		this.foreGround = foreGround;
		this.setObjects(objects);

	}

	public List<PhysGameObject> getObjects() {
		return this.objects;
	}

	public void setObjects(List<PhysGameObject> objects) {
		this.objects = objects;
	}

}
