package org.langera.spockextensions.alert

import org.langera.spockextensions.alert.alerts.Alerter
import org.langera.spockextensions.alert.alerts.Say
import org.spockframework.runtime.extension.IMethodInterceptor
import org.spockframework.runtime.extension.IMethodInvocation
import org.spockframework.runtime.model.FeatureInfo

class AlertInterceptor implements IMethodInterceptor {

    public static final Say DEFAULT_ALERTER = new Say()

    private final Alert alert
    private final FeatureInfo featureInfo
    private final Alerter alerter

    AlertInterceptor(Alert alert, FeatureInfo featureInfo) {
        this(alert, featureInfo, DEFAULT_ALERTER)
    }

    AlertInterceptor(Alert alert, FeatureInfo featureInfo, Alerter alerter) {
        this.alert = alert
        this.featureInfo = featureInfo
        this.alerter = alerter
    }

    @Override
    void intercept(IMethodInvocation invocation) throws Throwable {
        try {
            invocation.proceed()
        } catch (Throwable t) {
            def methodName = featureInfo.getFeatureMethod().name
            try {
                alerter.alert(alert.value(), methodName)
            } catch (ignored) {}
            throw t
        }
    }}
