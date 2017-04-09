package edu.hm.sbecker.pstrasse.test;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import edu.hm.sbecker.pstrasse.renderer.Renderer;

/**
 * Diese Klasse testet den Renderer mit Hilfe eines ParameterizedRunners.
 * @author Sebastian Becker
 * @author Peter Straßer
 */
@RunWith(Parameterized.class)
public class ParameterizedRendererTest {
    private String expectedString;
    private Renderer renderer;
    
    public static final int TESTS = 10;
    
    /**
     * Ctor um den ParameterizedRendererTest zu erstellen.
     * @param expectedString Der String der am Ende rauskommen soll.
     * @param renderer Das Renderer-Object, welches getestet wird.
     */
    public ParameterizedRendererTest(String expectedString, Renderer renderer) {
        this.expectedString = expectedString;
        this.renderer = renderer;
    }
    
    /**
     * Diese Methode erstellt die test-paare.
     * @return Die test-paare
     */
    @Parameters
    public static Collection<Object[]> testData() {
        AnotherClass aClass;
        Renderer render;
        int[] array;
        String string =  "Instance of edu.hm.sbecker.pstrasse.test.SomeClass:\n"
                +   "foo (Type int): 5\n"
                +   "array (Type int[]) [1, 2, 3, ]\n"
                +   "date (Type java.util.Date): Fri Jan 02 11:17:36 CET 1970\n";
        Object[][] data = new Object[TESTS][];
        
        for (int i = 0; i < TESTS; i++) {
            array = new int[]{i, i + 1, i + 2};
            aClass = new AnotherClass(i, array);
            render = new Renderer(aClass);
            string = "Instance of " + AnotherClass.class.getName() + ":\n";
            string += "foo (Type int): " + i + "\n";
            string += "array (Type int[]) [";
            for (int a : array) {
                string += a + ", ";
            }
            string += "]\ndate (Type java.util.Date): Fri Jan 02 11:17:36 CET 1970\n";
            //System.out.println(string);
            data[i] = new Object[]{string, render};
        }

        return Arrays.asList(data);
    }
    
    /**
     * Diese Methode testet die erstellten Szenarien.
     */
    @Test
    public void testRenderer() {
        //System.out.println(renderer.render());
        //System.out.println(expectedString);
        //System.out.println(renderer.render());
        Assert.assertEquals(expectedString, renderer.render());
    }
}
