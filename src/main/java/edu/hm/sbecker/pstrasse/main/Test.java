package edu.hm.sbecker.pstrasse.main;

import edu.hm.sbecker.pstrasse.renderer.Renderer;

public class Test {
	public static void main(String[] args) {
		Object toRender = new SomeClass(5);
		Renderer renderer = new Renderer(toRender);
		System.out.println(renderer.render());
	}
}