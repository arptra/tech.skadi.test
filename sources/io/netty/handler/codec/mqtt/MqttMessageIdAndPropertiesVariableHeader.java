package io.netty.handler.codec.mqtt;

import io.netty.util.internal.StringUtil;

public final class MqttMessageIdAndPropertiesVariableHeader extends MqttMessageIdVariableHeader {
    private final MqttProperties properties;

    public MqttMessageIdAndPropertiesVariableHeader(int i, MqttProperties mqttProperties) {
        super(i);
        if (i < 1 || i > 65535) {
            throw new IllegalArgumentException("messageId: " + i + " (expected: 1 ~ 65535)");
        }
        this.properties = MqttProperties.withEmptyDefaults(mqttProperties);
    }

    public MqttProperties properties() {
        return this.properties;
    }

    public String toString() {
        return StringUtil.simpleClassName((Object) this) + "[messageId=" + messageId() + ", properties=" + this.properties + ']';
    }

    public MqttMessageIdAndPropertiesVariableHeader withDefaultEmptyProperties() {
        return this;
    }
}
