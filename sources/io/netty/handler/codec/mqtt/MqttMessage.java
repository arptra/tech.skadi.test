package io.netty.handler.codec.mqtt;

import io.netty.handler.codec.DecoderResult;
import io.netty.util.internal.StringUtil;

public class MqttMessage {
    public static final MqttMessage DISCONNECT;
    public static final MqttMessage PINGREQ;
    public static final MqttMessage PINGRESP;
    private final DecoderResult decoderResult;
    private final MqttFixedHeader mqttFixedHeader;
    private final Object payload;
    private final Object variableHeader;

    static {
        MqttMessageType mqttMessageType = MqttMessageType.PINGREQ;
        MqttQoS mqttQoS = MqttQoS.AT_MOST_ONCE;
        PINGREQ = new MqttMessage(new MqttFixedHeader(mqttMessageType, false, mqttQoS, false, 0));
        MqttQoS mqttQoS2 = mqttQoS;
        PINGRESP = new MqttMessage(new MqttFixedHeader(MqttMessageType.PINGRESP, false, mqttQoS2, false, 0));
        DISCONNECT = new MqttMessage(new MqttFixedHeader(MqttMessageType.DISCONNECT, false, mqttQoS2, false, 0));
    }

    public MqttMessage(MqttFixedHeader mqttFixedHeader2) {
        this(mqttFixedHeader2, (Object) null, (Object) null);
    }

    public DecoderResult decoderResult() {
        return this.decoderResult;
    }

    public MqttFixedHeader fixedHeader() {
        return this.mqttFixedHeader;
    }

    public Object payload() {
        return this.payload;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(StringUtil.simpleClassName((Object) this));
        sb.append('[');
        sb.append("fixedHeader=");
        String str = "";
        sb.append(fixedHeader() != null ? fixedHeader().toString() : str);
        sb.append(", variableHeader=");
        sb.append(variableHeader() != null ? this.variableHeader.toString() : str);
        sb.append(", payload=");
        if (payload() != null) {
            str = this.payload.toString();
        }
        sb.append(str);
        sb.append(']');
        return sb.toString();
    }

    public Object variableHeader() {
        return this.variableHeader;
    }

    public MqttMessage(MqttFixedHeader mqttFixedHeader2, Object obj) {
        this(mqttFixedHeader2, obj, (Object) null);
    }

    public MqttMessage(MqttFixedHeader mqttFixedHeader2, Object obj, Object obj2) {
        this(mqttFixedHeader2, obj, obj2, DecoderResult.SUCCESS);
    }

    public MqttMessage(MqttFixedHeader mqttFixedHeader2, Object obj, Object obj2, DecoderResult decoderResult2) {
        this.mqttFixedHeader = mqttFixedHeader2;
        this.variableHeader = obj;
        this.payload = obj2;
        this.decoderResult = decoderResult2;
    }
}
