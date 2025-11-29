package io.netty.handler.codec.mqtt;

public final class MqttSubscribeMessage extends MqttMessage {
    public MqttSubscribeMessage(MqttFixedHeader mqttFixedHeader, MqttMessageIdAndPropertiesVariableHeader mqttMessageIdAndPropertiesVariableHeader, MqttSubscribePayload mqttSubscribePayload) {
        super(mqttFixedHeader, mqttMessageIdAndPropertiesVariableHeader, mqttSubscribePayload);
    }

    public MqttMessageIdAndPropertiesVariableHeader idAndPropertiesVariableHeader() {
        return (MqttMessageIdAndPropertiesVariableHeader) super.variableHeader();
    }

    public MqttSubscribeMessage(MqttFixedHeader mqttFixedHeader, MqttMessageIdVariableHeader mqttMessageIdVariableHeader, MqttSubscribePayload mqttSubscribePayload) {
        this(mqttFixedHeader, mqttMessageIdVariableHeader.withDefaultEmptyProperties(), mqttSubscribePayload);
    }

    public MqttSubscribePayload payload() {
        return (MqttSubscribePayload) super.payload();
    }

    public MqttMessageIdVariableHeader variableHeader() {
        return (MqttMessageIdVariableHeader) super.variableHeader();
    }
}
