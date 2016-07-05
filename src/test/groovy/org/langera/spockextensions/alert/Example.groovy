package org.langera.spockextensions.alert

import spock.lang.Specification

import static org.langera.spockextensions.alert.AlertType.PLAY
import static org.langera.spockextensions.alert.AlertType.SAY


class Example extends Specification {


//    @Alert(value = [SAY, PLAY], params = ['say:the test failed', 'play:/Users/alanger/dev/alert/anarchyintheuk.m4a'])
    @Alert(value = [SAY, PLAY], params = ['play:<path to your favourite/annoying music track>'])
    def 'test method'() {
        expect:
            1 + 2 == 3
//            1 + 2 == 4
    }
}