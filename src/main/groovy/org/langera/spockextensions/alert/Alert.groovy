package org.langera.spockextensions.alert

import org.spockframework.runtime.extension.ExtensionAnnotation

import java.lang.annotation.ElementType
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import java.lang.annotation.Target

import static org.langera.spockextensions.alert.AlertType.SAY

/**
 *  original idea "borrowed" from kensipe spock presentation javaone 2014
 */

@Retention(RetentionPolicy.RUNTIME)
@Target([ElementType.TYPE, ElementType.METHOD])
@ExtensionAnnotation(AlertExtension)
public @interface Alert {

    AlertType[] value() default [ SAY ]
    String[] params() default []
}