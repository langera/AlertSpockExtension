package org.langera.spockextensions.alert.alerts


interface Alerter {

    void alert(String annotationValue, String methodName);
}