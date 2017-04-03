package edu.hm.sbecker.pstrasse.renderer;

import java.lang.reflect.Field;
import java.util.Arrays;

public class ArrayRenderer {
	public String render(Field f, Object object) {

		Class<?> c = f.getType();
		String renderedString = f.getName() + " ";
		String arrayType = f.toString().split(" ")[0];
		renderedString += "(Type " + arrayType + ") ";
		try {
			renderedString += Arrays.toString((int[]) f.get(object)) + "\n ";
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return renderedString;
	}
}
