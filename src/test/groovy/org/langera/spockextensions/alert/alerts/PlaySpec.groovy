package org.langera.spockextensions.alert.alerts

import spock.lang.Specification
import spock.lang.Subject


class PlaySpec extends Specification {

    private AlertUtil util

    @Subject
    Play play = new Play()

    def setup() {
        util = Spy()
        play.util = util
    }

    def 'play will use param'() {
        when:
            play.alert(['play:file.mp3'] as String[], 'method name')
        then:
            1 * util.execute('afplay file.mp3') >> {}
    }

    def 'play will use default'() {
        when:
            play.alert([] as String[], 'method name')
        then:
            1 * util.execute("afplay $Play.DEFUALT_TRACK") >> {}

    }
}
