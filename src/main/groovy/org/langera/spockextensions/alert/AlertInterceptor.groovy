package org.langera.spockextensions.alert

import org.langera.spockextensions.alert.alerts.Alerter
import org.spockframework.runtime.extension.IMethodInterceptor
import org.spockframework.runtime.extension.IMethodInvocation
import org.spockframework.runtime.model.FeatureInfo

class AlertInterceptor implements IMethodInterceptor {

    private final String[] params
    private final FeatureInfo featureInfo
    private final Alerter[] alerters

    AlertInterceptor(Alert alert, FeatureInfo featureInfo, Alerter... alerters) {
        this.params = alert.params()
        this.featureInfo = featureInfo
        this.alerters = alerters
    }

    @Override
    void intercept(IMethodInvocation invocation) throws Throwable {
        try {
            invocation.proceed()
        } catch (Throwable t) {
            def methodName = featureInfo.getFeatureMethod().name
            alerters.each { alerter ->
                try {
                    alerter.alert(params, methodName)
                } catch (ignored) {}
            }
            throw t
        }
    }}
