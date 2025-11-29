package io.netty.handler.codec.mqtt;

public final class MqttSubAckMessage extends MqttMessage {
    public MqttSubAckMessage(MqttFixedHeader mqttFixedHeader, MqttMessageIdAndPropertiesVariableHeader mqttMessageIdAndPropertiesVariableHeader, MqttSubAckPayload mqttSubAckPayload) {
        super(mqttFixedHeader, mqttMessageIdAndPropertiesVariableHeader, mqttSubAckPayload);
    }

    public MqttMessageIdAndPropertiesVariableHeader idAndPropertiesVariableHeader() {
        return (MqttMessageIdAndPropertiesVariableHeader) super.variableHeader();
    }

    public MqttSubAckMessage(MqttFixedHeader mqttFixedHeader, MqttMessageIdVariableHeader mqttMessageIdVariableHeader, MqttSubAckPayload mqttSubAckPayload) {
        this(mqttFixedHeader, mqttMessageIdVariableHeader.withDefaultEmptyProperties(), mqttSubAckPayload);
    }

    public MqttSubAckPayload payload() {
        return (MqttSubAckPayload) super.payload();
    }

    public MqttMessageIdVariableHeader variableHeader() {
        return (MqttMessageIdVariableHeader) super.variableHeader();
    }
}
