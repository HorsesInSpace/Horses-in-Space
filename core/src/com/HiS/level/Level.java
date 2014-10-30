package com.HiS.level;

import java.util.ArrayList;
import java.util.List;

import com.HiS.gameobject.PhysGameObject;
import com.HiS.gameobject.obstacle.Fence;
import com.HiS.gameobject.obstacle.FloatyPlatform;
import com.HiS.gameobject.obstacle.Ufo;
import com.HiS.hishelpers.AssetLoader;
import com.HiS.hishelpers.CsvLoader;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Level {

	private String name;
	private TextureRegion backGround;
	private TextureRegion middleGround;
	private TextureRegion foreGround;
	private int length;

	private List<PhysGameObject> objects = new ArrayList<PhysGameObject>();

	public Level(String filePath) {
		List<String[]> list = CsvLoader.LevelLoader(filePath);
		String[] levelDetails = list.get(0);
		List<PhysGameObject> objects = new ArrayList<PhysGameObject>();
		int length = 0;
		int prevX = 0;
		for (int i = 1; i < list.size(); i++) {
			String[] values = list.get(i);
			int x = Integer.parseInt(values[1]);
			System.out.println(x);
			if (length <= x) {
				length = x;
			}
			try {
				PhysGameObject physGameObject = createPhysGameObject(values,
						prevX);
				objects.add(physGameObject);
				prevX += x + physGameObject.getPhysics().getRect().width;
			} catch (PhysGameObjectNotRecognizedException e) {
				prevX += x;
				continue;
			}
		}
		length = length + 100;
		generateLevel(this.backGround, this.middleGround, this.foreGround,
				levelDetails[0], objects);
		setLength(length);
	}

	private PhysGameObject createPhysGameObject(String[] values, int prevX)
			throws PhysGameObjectNotRecognizedException {
		String typeString = values[0];
		char type = typeString.charAt(0);
		int x = Integer.parseInt(values[1]) + prevX;
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
		generateLevel(backGround, middleGround, foreGround, name, objects);
	}

	private void generateLevel(TextureRegion backGround,
			TextureRegion middleGround, TextureRegion foreGround, String name,
			List<PhysGameObject> objects) {
		if (name.equals("moon")) {
			this.name = "moon";
			this.backGround = AssetLoader.moonBackground;
			this.foreGround = AssetLoader.moonForeground;
			this.middleGround = AssetLoader.moonMiddleground;
			setObjects(objects);
		} else {
			this.name = name;
			this.backGround = null;
			this.middleGround = null;
			this.foreGround = null;
			setObjects(objects);
		}
	}

	public List<PhysGameObject> getObjects() {
		return this.objects;
	}

	public void setObjects(List<PhysGameObject> objects) {
		this.objects = objects;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TextureRegion getBackGround() {
		return this.backGround;
	}

	public void setBackGround(TextureRegion backGround) {
		this.backGround = backGround;
	}

	public TextureRegion getMiddleGround() {
		return this.middleGround;
	}

	public void setMiddleGround(TextureRegion middleGround) {
		this.middleGround = middleGround;
	}

	public TextureRegion getForeGround() {
		return this.foreGround;
	}

	public void setForeGround(TextureRegion foreGround) {
		this.foreGround = foreGround;
	}

	public int getLength() {
		return this.length;
	}

	public void setLength(int length) {
		this.length = length;
	}

}
