package com.luxoft.demo.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotations provide data about program that is not part of the program.
 *
 * Common use cases^
 * - information for the compiler (e.g. detecting errors)
 * - compile-time and deployment-time processing
 *   (e.g. annotation information can be used to generate code, XML or JSON files)
 * - runtime processing (it's possible to alter a program based on annotation information)
 */
public class Annotations {

    @Override
    public String toString() {
        return "Annotations";
    }

    @FunctionalInterface
    interface Func<T, R> {
        R apply(T param);
    }

    /**
     * @Retention(RetentionPolicy.SOURCE) // The marked annotation is retained only in the source level and
     * is ignored by the compiler
     * @Retention(RetentionPolicy.CLASS) default. The marked annotation is retained by the compiler at compile time,
     * but is ignored by the Java Virtual Machine (JVM).
     * @Retention(RetentionPolicy.RUNTIME) //The marked annotation is retained by the JVM so it can be used
     * by the runtime environment. Mostly used by frameworks to enhance annotated code using code generation or
     * Java reflection API.
     *
     * Important: Annotation have to be processed somehow by a preprocessor or a framework otherwise there is no
     * effect of using annotation
     */
    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD})
    @interface MyCustomAnnotation {
        String name();
        String defaultValue() default "default";
        String[] multipleValues();
    }

    @MyCustomAnnotation(
        name = "ctor",
        multipleValues = { "One", "Two" }
    )
    public Annotations() {
    }


}
