package edu.hm.sbecker.pstrasse.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import edu.hm.sbecker.pstrasse.renderer.Renderer;

/**
 * 
 * @author Prof. Dr.-Ing. Axel Böttcher
 *
 */

public class RendererTest {
    private SomeClass toRender;
    private Renderer renderer;
    
    private AnotherClass aClass;
    private Renderer renderer2;

    @Before
    public void setUp() {
        toRender = new SomeClass(5);
        renderer = new Renderer(toRender);
        aClass = new AnotherClass(5, new int[]{1, 2, 3});
        renderer2 = new Renderer(aClass);
    }

    @Test
    public void testRendering() throws Exception {
        //System.out.println(renderer.render());
        assertEquals(
                "Instance of edu.hm.sbecker.pstrasse.test.SomeClass:\nfoo (Type int): 5\narray (Type int[]) [1, 2, 3, ]\ndate "
                        + "(Type java.util.Date): Fri Jan 02 11:17:36 CET 1970\n",
                renderer.render());
    }
    
    @Test
    public void testRendering2() throws Exception {
        //System.out.println(renderer2.render());
        assertEquals("Instance of edu.hm.sbecker.pstrasse.test.AnotherClass:\nfoo (Type int): 1\narray (Type int[]) 1\ndate "
                + "(Type java.util.Date): Fri Jan 02 11:17:36 CET 1970\n", renderer2.render());
    }
}