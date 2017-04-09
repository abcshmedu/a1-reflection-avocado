package edu.hm.sbecker.pstrasse.renderer;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Die Implementierung des Renderers für die 1. Abgabe im Fach
 * Software-Architektur.
 * 
 * @author Sebastian Becker
 * @author Peter Straßer
 */
public class Renderer {
    private Object object;

    /**
     * Ctor der Renderer-Klasse.
     * @param object Object, welches gerendert werden soll
     */
    public Renderer(Object object) {
        this.object = object;
    }

    /**
     * Das ist die render-Methode die als erstes aufgerufen wird.
     * Sie kümmert sich um das Aufrufen der (falls benötigt) anderen
     * render-Methoden.
     * @return returned einen String der das Object beschreibt
     */
    public String render() {
        String renderedString = "";
        Field[] fields;
        Method[] methods;
        Class< ? > objectClass = object.getClass();
        renderedString += "Instance of " + objectClass.getName() + ":\n";


        // Start the rendering for the variables
        fields = objectClass.getDeclaredFields();
        renderedString += renderVariables(fields);

        // Start the rendering for the methods
        methods = objectClass.getMethods();
        renderedString += renderMethods(methods);
        

        return renderedString;
    }
    
    /**
     * Diese Methode kümmert sich um das Rendern der Variablen des Objects.
     * @param fields Felder, welche gerendert werden sollen
     * @return einen String der die Variablen des Objects beschreibt
     */
    private String renderVariables(Field[] fields) {
        String renderedString = "";
        
        for (Field f : fields) {
            f.setAccessible(true);
            RenderMe renderMe = f.getAnnotation(RenderMe.class);
            Class< ? > renderer = null;
            try {
                renderer = Class.forName(renderMe.with());
            } catch (ClassNotFoundException e1) {
                e1.printStackTrace();
            }

            renderedString += f.getName() + " ";
            renderedString += "(Type ";
            try {

                if (renderMe.with().equals("edu.hm.sbecker.pstrasse.renderer.DefaultRenderer")) {
                    Object correctRenderer = renderer.getConstructor().newInstance();
                    Method method = renderer.getMethod("render", Field.class, Object.class);
                    renderedString += method.invoke(correctRenderer, f, object);
                } else if (renderMe.with().equals("edu.hm.sbecker.pstrasse.renderer.ArrayRenderer")) {
                    Object correctRenderer = renderer.getConstructor().newInstance();
                    Method method = renderer.getMethod("render", int[].class);
                    renderedString += method.invoke(correctRenderer, (int[]) f.get(object));
                }

            } catch (InstantiationException e1) {
                e1.printStackTrace();
            } catch (IllegalAccessException e1) {
                e1.printStackTrace();
            } catch (IllegalArgumentException e1) {
                e1.printStackTrace();
            } catch (InvocationTargetException e1) {
                e1.printStackTrace();
            } catch (NoSuchMethodException e1) {
                e1.printStackTrace();
            } catch (SecurityException e1) {
                e1.printStackTrace();
            }
        }
        
        return renderedString;
    }
    
    /**
     * Diese Methode kümmert sich um das Rendern der Methoden des Objects.
     * @param methods Methoden, welche gerendert werden sollen
     * @return Ein String der die Methoden des Objects beschreibt
     */
    private String renderMethods(Method[] methods) {
        String renderedString = "";
        
        for (Method m : methods) {
            m.setAccessible(true);
            Annotation[] annotations = m.getDeclaredAnnotations();

            for (Annotation a : annotations) {
                if (a instanceof RenderMe && !m.getReturnType().equals(Void.TYPE)) {
                    renderedString += m.getName() + " ";
                    renderedString += "(Returntype " + m.getReturnType() + "): ";
                    try {
                        renderedString += m.invoke(object).toString() + "\n";
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (IllegalArgumentException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        
        return renderedString;
        }
}
