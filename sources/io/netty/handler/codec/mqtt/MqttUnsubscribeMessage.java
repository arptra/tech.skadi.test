package io.netty.handler.codec.mqtt;

public final class MqttUnsubscribeMessage extends MqttMessage {
    public MqttUnsubscribeMessage(MqttFixedHeader mqttFixedHeader, MqttMessageIdAndPropertiesVariableHeader mqttMessageIdAndPropertiesVariableHeader, MqttUnsubscribePayload mqttUnsubscribePayload) {
        super(mqttFixedHeader, mqttMessageIdAndPropertiesVariableHeader, mqttUnsubscribePayload);
    }

    public MqttMessageIdAndPropertiesVariableHeader idAndPropertiesVariableHeader() {
        return (MqttMessageIdAndPropertiesVariableHeader) super.variableHeader();
    }

    public MqttUnsubscribeMessage(MqttFixedHeader mqttFixedHeader, MqttMessageIdVariableHeader mqttMessageIdVariableHeader, MqttUnsubscribePayload mqttUnsubscribePayload) {
        this(mqttFixedHeader, mqttMessageIdVariableHeader.withDefaultEmptyProperties(), mqttUnsubscribePayload);
    }

    public MqttUnsubscribePayload payload() {
        return (MqttUnsubscribePayload) super.payload();
    }

    public MqttMessageIdVariableHeader variableHeader() {
        return (MqttMessageIdVariableHeader) super.variableHeader();
    }
}
