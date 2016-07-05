package org.langera.spockextensions.alert.alerts

class Say implements Alerter {

    private AlertUtil util = new AlertUtil()


    @Override
    void alert(String[] params, String methodName) {
        def text = util.getParam(params, 'say', "$methodName failed")
        util.execute("say $text")
    }
}
