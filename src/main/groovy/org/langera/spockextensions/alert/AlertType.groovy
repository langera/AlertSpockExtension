package org.langera.spockextensions.alert

import org.langera.spockextensions.alert.alerts.Alerter
import org.langera.spockextensions.alert.alerts.Play
import org.langera.spockextensions.alert.alerts.Say


enum AlertType {

    SAY(new Say()),
    PLAY(new Play()),

    private Alerter alerter

    AlertType(final Alerter alerter) {
        this.alerter = alerter
    }

    Alerter getAlerter() {
        return alerter
    }
}