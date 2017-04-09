package edu.hm.sbecker.pstrasse.renderer;

import java.lang.reflect.Field;

/**
 * Die Implementierung des DefaultRenderers für die 1. Abgabe im Fach
 * Software-Architektur.
 * 
 * @author Sebastian Becker
 * @author Peter Straßer
 */
public class DefaultRenderer {
    /**
     * Das ist die render-Methode des DefaultRenderers.
     * @param f Field of the object
     * @param object object
     * @return returns a part of the rendered string
     */
    public String render(Field f, Object object) {
        String renderedString = "";
        renderedString += f.getType().getName() + "): ";
        try {
            renderedString += f.get(object) + "\n";
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return renderedString;
    }
}
