package org.langera.spockextensions.alert.alerts


class AlertUtil {

    Process execute(String command) {
        command.execute()
    }

    String getParam(String[] params, String paramName, String defaultValue) {
        String protocol = "$paramName:"
        String param = params.find() { it.startsWith(protocol) }
        return param ? param.substring(protocol.length()) : defaultValue
    }
}
