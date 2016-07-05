package org.langera.spockextensions.alert.alerts

class Play implements Alerter {

    static final String DEFUALT_TRACK = '/System/Library/Sounds/Frog.aiff'

    private AlertUtil util = new AlertUtil()

    @Override
    void alert(String[] params, String methodName) {
        String track = util.getParam(params, 'play', DEFUALT_TRACK)
        util.execute("afplay $track")
    }
}
