package edu.hm.sbecker.pstrasse.renderer;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Das Interface "RenderMe" für die 1. Abgabe im Fach
 * Software-Architektur.
 * 
 * @author Sebastian Becker
 * @author Peter Straßer
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface RenderMe {
    /**
     * Gibt an welcher Renderer genutzt werden soll.
     * @return Repräsentation des Renderers als String.
     */
    String with() default "edu.hm.sbecker.pstrasse.renderer.DefaultRenderer";
}
