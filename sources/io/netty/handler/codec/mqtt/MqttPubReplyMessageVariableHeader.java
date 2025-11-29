package io.netty.handler.codec.mqtt;

import io.netty.util.internal.StringUtil;

public final class MqttPubReplyMessageVariableHeader extends MqttMessageIdVariableHeader {
    public static final byte REASON_CODE_OK = 0;
    private final MqttProperties properties;
    private final byte reasonCode;

    public MqttPubReplyMessageVariableHeader(int i, byte b, MqttProperties mqttProperties) {
        super(i);
        if (i < 1 || i > 65535) {
            throw new IllegalArgumentException("messageId: " + i + " (expected: 1 ~ 65535)");
        }
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
        return StringUtil.simpleClassName((Object) this) + "[messageId=" + messageId() + ", reasonCode=" + this.reasonCode + ", properties=" + this.properties + ']';
    }
}
