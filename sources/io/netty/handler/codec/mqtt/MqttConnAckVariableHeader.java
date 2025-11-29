package io.netty.handler.codec.mqtt;

import io.netty.util.internal.StringUtil;

public final class MqttConnAckVariableHeader {
    private final MqttConnectReturnCode connectReturnCode;
    private final MqttProperties properties;
    private final boolean sessionPresent;

    public MqttConnAckVariableHeader(MqttConnectReturnCode mqttConnectReturnCode, boolean z) {
        this(mqttConnectReturnCode, z, MqttProperties.NO_PROPERTIES);
    }

    public MqttConnectReturnCode connectReturnCode() {
        return this.connectReturnCode;
    }

    public boolean isSessionPresent() {
        return this.sessionPresent;
    }

    public MqttProperties properties() {
        return this.properties;
    }

    public String toString() {
        return StringUtil.simpleClassName((Object) this) + '[' + "connectReturnCode=" + this.connectReturnCode + ", sessionPresent=" + this.sessionPresent + ']';
    }

    public MqttConnAckVariableHeader(MqttConnectReturnCode mqttConnectReturnCode, boolean z, MqttProperties mqttProperties) {
        this.connectReturnCode = mqttConnectReturnCode;
        this.sessionPresent = z;
        this.properties = MqttProperties.withEmptyDefaults(mqttProperties);
    }
}
