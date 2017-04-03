package edu.hm.sbecker.pstrasse.renderer;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface RenderMe {
	String with() default "edu.hm.sbecker.pstrasse.renderer.DefaultRenderer";
}
