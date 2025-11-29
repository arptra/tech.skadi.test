package io.netty.handler.codec.mqtt;

import io.netty.util.internal.StringUtil;

public final class MqttReasonCodeAndPropertiesVariableHeader {
    public static final byte REASON_CODE_OK = 0;
    private final MqttProperties properties;
    private final byte reasonCode;

    public MqttReasonCodeAndPropertiesVariableHeader(byte b, MqttProperties mqttProperties) {
        this.reasonCode = b;
        this.properties = MqttProperties.withEmptyDefaults(mqttProperties);
    }

    public MqttProperties properties() {
        return this.properties;
    }

    public byte reasonCode() {
        return this.reasonCode;
    }

    public String toString() {
        return StringUtil.simpleClassName((Object) this) + '[' + "reasonCode=" + this.reasonCode + ", properties=" + this.properties + ']';
    }
}
