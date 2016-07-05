package org.langera.spockextensions.alert

import spock.lang.Specification

import static org.langera.spockextensions.alert.AlertType.PLAY
import static org.langera.spockextensions.alert.AlertType.SAY


class Example extends Specification {


    @Alert(value = [SAY, PLAY], params = ['play:/Users/alanger/dev/alert/anarchyintheuk.m4a'])
    def 'test method'() {
        expect:
            1 + 2 == 3
//            1 + 2 == 4
    }
}