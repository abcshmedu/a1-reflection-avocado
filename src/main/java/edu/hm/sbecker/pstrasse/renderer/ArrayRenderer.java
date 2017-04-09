package edu.hm.sbecker.pstrasse.renderer;

/**
 * Die Implementierung des ArrayRenderers für die 1. Abgabe im Fach
 * Software-Architektur.
 * 
 * @author Sebastian Becker
 * @author Peter Straßer
 */
public class ArrayRenderer {
    /**
     * Die render-Methode für ein int-array.
     * 
     * @param array int-array
     * @return rendered string
     */
    public String render(int[] array) {
        String renderedString = "int[]) [";

        for (int i : array) {
            renderedString += i + ", ";
        }
        renderedString += "]\n";

        return renderedString;
    }
}
