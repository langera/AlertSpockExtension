package org.langera.spockextensions.alert

import org.langera.spockextensions.alert.alerts.Alerter
import org.spockframework.runtime.extension.AbstractAnnotationDrivenExtension
import org.spockframework.runtime.model.FeatureInfo
import org.spockframework.runtime.model.SpecInfo

class AlertExtension extends AbstractAnnotationDrivenExtension<Alert> {

    @Override
    void visitSpecAnnotation(Alert alert, SpecInfo spec) {
        spec.features.each { FeatureInfo feature ->
            if (!feature.featureMethod.reflection.isAnnotationPresent(Alert)) {
                visitFeatureAnnotation(alert, feature)
            }
        }
    }

    @Override
    void visitFeatureAnnotation(Alert alert, FeatureInfo feature) {
        Alerter[] alerters = alert.value().collect { it.alerter }
        def interceptor = new AlertInterceptor(alert, feature, alerters)
        feature.getFeatureMethod().addInterceptor(interceptor)
    }
}
