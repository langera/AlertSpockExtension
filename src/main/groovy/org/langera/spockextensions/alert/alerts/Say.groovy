package org.langera.spockextensions.alert.alerts


class Say implements Alerter {

    @Override
    void alert(String annotationValue, String methodName) {
        def text = annotationValue ?: "$methodName failed"
        "say $text".execute()
    }
}
