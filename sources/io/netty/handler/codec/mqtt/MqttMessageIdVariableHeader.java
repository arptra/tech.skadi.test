package io.netty.handler.codec.mqtt;

import io.netty.util.internal.StringUtil;

public class MqttMessageIdVariableHeader {
    private final int messageId;

    public MqttMessageIdVariableHeader(int i) {
        this.messageId = i;
    }

    public static MqttMessageIdVariableHeader from(int i) {
        if (i >= 1 && i <= 65535) {
            return new MqttMessageIdVariableHeader(i);
        }
        throw new IllegalArgumentException("messageId: " + i + " (expected: 1 ~ 65535)");
    }

    public int messageId() {
        return this.messageId;
    }

    public String toString() {
        return StringUtil.simpleClassName((Object) this) + '[' + "messageId=" + this.messageId + ']';
    }

    public MqttMessageIdAndPropertiesVariableHeader withDefaultEmptyProperties() {
        return withEmptyProperties();
    }

    public MqttMessageIdAndPropertiesVariableHeader withEmptyProperties() {
        return new MqttMessageIdAndPropertiesVariableHeader(this.messageId, MqttProperties.NO_PROPERTIES);
    }
}
