package org.langera.spockextensions.alert.alerts

import spock.lang.Specification
import spock.lang.Subject


class SaySpec extends Specification {

    private AlertUtil util

    @Subject
    Say say = new Say()

    def setup() {
        util = Spy(AlertUtil)
        say.util = util
    }

    def 'say will use param'() {
        when:
            say.alert(['say:say this'] as String[], 'method name')
        then:
            1 * util.execute('say say this') >> {}
    }

    def 'say will use method name'() {
        when:
            say.alert([] as String[], 'method name')
        then:
            1 * util.execute('say method name failed') >> {}

    }
}
