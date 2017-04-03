package edu.hm.sbecker.pstrasse.renderer;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Renderer {
	private Object object;
	
	public Renderer(Object object){
		this.object = object;
	}
	
	public String render(){
		String renderedString = "";
		Class<?> objectClass = object.getClass();
		Field[] fields = objectClass.getDeclaredFields();
		renderedString += "Instance of " + objectClass.getName()+":\n ";
		for(Field f: fields){
			f.setAccessible(true);
			RenderMe renderMe = f.getAnnotation(RenderMe.class);
			Class<?> renderer = null;
			try {
				renderer = Class.forName(renderMe.with());
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
			try {
				Object correctRenderer = renderer.getConstructor().newInstance();
				Method method = renderer.getMethod("render", Field.class, Object.class);
				renderedString += method.invoke(correctRenderer, f, object);
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			} catch (IllegalArgumentException e1) {
				e1.printStackTrace();
			} catch (InvocationTargetException e1) {
				e1.printStackTrace();
			} catch (NoSuchMethodException e1) {
				e1.printStackTrace();
			} catch (SecurityException e1) {
				e1.printStackTrace();
			}
			
		}
		
		return renderedString;
	}

	public Object getObject() {
		return object;
	}
}
