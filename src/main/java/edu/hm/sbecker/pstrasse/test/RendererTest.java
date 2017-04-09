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

    @Before
    public void setUp() {
        toRender = new SomeClass(5);
        renderer = new Renderer(toRender);
    }

    @Test
    public void testRendering() throws Exception {
        assertEquals(
                "Instance of edu.hm.sbecker.pstrasse.main.SomeClass:\nfoo (Type int): 5\narray (Type int[]) [1, 2, 3, ]\ndate "
                        + "(Type java.util.Date): Fri Jan 02 11:17:36 CET 1970\n",
                renderer.render());
    }
}