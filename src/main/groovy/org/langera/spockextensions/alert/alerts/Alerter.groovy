package org.langera.spockextensions.alert.alerts

interface Alerter {

    void alert(String[] params, String methodName);
}