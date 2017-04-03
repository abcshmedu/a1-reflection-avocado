package edu.hm.sbecker.pstrasse.renderer;

import java.lang.reflect.Field;

public class DefaultRenderer{
	
	public String render(Field f, Object object){
		String renderedString = f.getName() + " ";
		renderedString += "(Type " + f.getType().getName() + "): ";
		try {
			renderedString += f.get(object) + ":\n ";
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return renderedString;
	}
}
