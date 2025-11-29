package io.netty.handler.codec.mqtt;

public final class MqttUnsubAckMessage extends MqttMessage {
    public MqttUnsubAckMessage(MqttFixedHeader mqttFixedHeader, MqttMessageIdAndPropertiesVariableHeader mqttMessageIdAndPropertiesVariableHeader, MqttUnsubAckPayload mqttUnsubAckPayload) {
        super(mqttFixedHeader, mqttMessageIdAndPropertiesVariableHeader, MqttUnsubAckPayload.withEmptyDefaults(mqttUnsubAckPayload));
    }

    private static MqttMessageIdAndPropertiesVariableHeader fallbackVariableHeader(MqttMessageIdVariableHeader mqttMessageIdVariableHeader) {
        return mqttMessageIdVariableHeader instanceof MqttMessageIdAndPropertiesVariableHeader ? (MqttMessageIdAndPropertiesVariableHeader) mqttMessageIdVariableHeader : new MqttMessageIdAndPropertiesVariableHeader(mqttMessageIdVariableHeader.messageId(), MqttProperties.NO_PROPERTIES);
    }

    public MqttMessageIdAndPropertiesVariableHeader idAndPropertiesVariableHeader() {
        return (MqttMessageIdAndPropertiesVariableHeader) super.variableHeader();
    }

    public MqttUnsubAckMessage(MqttFixedHeader mqttFixedHeader, MqttMessageIdVariableHeader mqttMessageIdVariableHeader, MqttUnsubAckPayload mqttUnsubAckPayload) {
        this(mqttFixedHeader, fallbackVariableHeader(mqttMessageIdVariableHeader), mqttUnsubAckPayload);
    }

    public MqttUnsubAckPayload payload() {
        return (MqttUnsubAckPayload) super.payload();
    }

    public MqttMessageIdVariableHeader variableHeader() {
        return (MqttMessageIdVariableHeader) super.variableHeader();
    }

    public MqttUnsubAckMessage(MqttFixedHeader mqttFixedHeader, MqttMessageIdVariableHeader mqttMessageIdVariableHeader) {
        this(mqttFixedHeader, mqttMessageIdVariableHeader, (MqttUnsubAckPayload) null);
    }
}
