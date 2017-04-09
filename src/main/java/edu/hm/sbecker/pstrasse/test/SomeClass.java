package edu.hm.sbecker.pstrasse.main;

import java.util.Date;

import edu.hm.sbecker.pstrasse.renderer.RenderMe;

public class SomeClass {
	@RenderMe
	private int foo;
	@RenderMe(with = "edu.hm.sbecker.pstrasse.renderer.ArrayRenderer")
	int[] array = { 1, 2, 3, };
	@RenderMe
	private Date date = new Date(123456789);

	public SomeClass(int foo) {
		this.foo = foo;
	}
	
	@RenderMe
	public int returnInt(){
		return (int) (Math.random() * 10);
	}
	
}