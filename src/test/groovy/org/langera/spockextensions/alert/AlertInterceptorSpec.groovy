package org.langera.spockextensions.alert

import org.langera.spockextensions.alert.alerts.Alerter
import org.spockframework.runtime.extension.IMethodInvocation
import org.spockframework.runtime.model.FeatureInfo
import org.spockframework.runtime.model.MethodInfo
import spock.lang.Specification
import spock.lang.Subject

@Alert('alert value')
class AlertInterceptorSpec extends Specification {

    Alerter alerter = Mock()
    FeatureInfo feature = Mock()
    IMethodInvocation invocation = Mock()

    @Subject
    AlertInterceptor interceptor =
            new AlertInterceptor(getClass().getAnnotation(Alert), feature, alerter)

    def 'when invocation succeeds no alert is fired'() {
        when:
            interceptor.intercept(invocation)
        then:
            1 * invocation.proceed()
    }

    def 'when invocation fails alert is fired'() {
        given:
            MethodInfo methodInfo = new MethodInfo()
            methodInfo.setName('method name')
            feature.getFeatureMethod() >> methodInfo

        when:
            interceptor.intercept(invocation)
        then:
            1 * invocation.proceed() >> { throw new RuntimeException() }
        then:
            thrown RuntimeException
            1 * alerter.alert('alert value', 'method name')
    }
}