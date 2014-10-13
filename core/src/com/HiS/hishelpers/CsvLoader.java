package com.HiS.hishelpers;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

public class CsvLoader {
	public static List<String[]> LevelLoader(String filePath) {
		FileHandle handle = Gdx.files.internal(filePath);
		BufferedReader br = handle.reader(200);
		String line;
		String[] values;
		List<String[]> list = new ArrayList<String[]>();
		try {
			while ((line = br.readLine()) != null) {
				values = line.split(",");
				list.add(values);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
