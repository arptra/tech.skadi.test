package io.netty.handler.codec.mqtt;

import io.netty.util.internal.StringUtil;

public final class MqttPublishVariableHeader {
    private final int packetId;
    private final MqttProperties properties;
    private final String topicName;

    public MqttPublishVariableHeader(String str, int i) {
        this(str, i, MqttProperties.NO_PROPERTIES);
    }

    @Deprecated
    public int messageId() {
        return this.packetId;
    }

    public int packetId() {
        return this.packetId;
    }

    public MqttProperties properties() {
        return this.properties;
    }

    public String toString() {
        return StringUtil.simpleClassName((Object) this) + '[' + "topicName=" + this.topicName + ", packetId=" + this.packetId + ']';
    }

    public String topicName() {
        return this.topicName;
    }

    public MqttPublishVariableHeader(String str, int i, MqttProperties mqttProperties) {
        this.topicName = str;
        this.packetId = i;
        this.properties = MqttProperties.withEmptyDefaults(mqttProperties);
    }
}
