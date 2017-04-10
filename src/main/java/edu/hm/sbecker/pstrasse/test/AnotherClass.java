package edu.hm.sbecker.pstrasse.test;

import java.util.Date;

import edu.hm.sbecker.pstrasse.renderer.RenderMe;

/**
 * Diese Klasse ist von "SomeClass" abgewandelt und dient zum testen.
 * @author Sebastian Becker
 * @author Peter Straßer
 */
public class AnotherClass {
   
    //private static final int DATE_TIME = 123456789;
    
    @RenderMe
    private int foo;

    @RenderMe(with = "edu.hm.sbecker.pstrasse.renderer.ArrayRenderer")
    private int[] array;

    @RenderMe
    private Date date = null;
    
    /**
     * Ctor für AnotherClass-Objects.
     * @param foo   eine Zahl
     * @param array ein Array
     */
    public AnotherClass(int foo, int[] array) {
        this.foo = foo;
        this.array = array;
    }

//    @RenderMe
//    public int returnInt() {
//        return foo;
//    }
}