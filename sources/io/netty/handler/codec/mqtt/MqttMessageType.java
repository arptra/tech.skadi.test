package io.netty.handler.codec.mqtt;

public enum MqttMessageType {
    CONNECT(1),
    CONNACK(2),
    PUBLISH(3),
    PUBACK(4),
    PUBREC(5),
    PUBREL(6),
    PUBCOMP(7),
    SUBSCRIBE(8),
    SUBACK(9),
    UNSUBSCRIBE(10),
    UNSUBACK(11),
    PINGREQ(12),
    PINGRESP(13),
    DISCONNECT(14),
    AUTH(15);
    
    private static final MqttMessageType[] VALUES = null;
    private final int value;

    static {
        MqttMessageType[] values = values();
        VALUES = new MqttMessageType[(values.length + 1)];
        int length = values.length;
        int i = 0;
        while (i < length) {
            MqttMessageType mqttMessageType = values[i];
            int i2 = mqttMessageType.value;
            MqttMessageType[] mqttMessageTypeArr = VALUES;
            if (mqttMessageTypeArr[i2] == null) {
                mqttMessageTypeArr[i2] = mqttMessageType;
                i++;
            } else {
                throw new AssertionError("value already in use: " + i2);
            }
        }
    }

    private MqttMessageType(int i) {
        this.value = i;
    }

    public int value() {
        return this.value;
    }

    public static MqttMessageType valueOf(int i) {
        if (i > 0) {
            MqttMessageType[] mqttMessageTypeArr = VALUES;
            if (i < mqttMessageTypeArr.length) {
                return mqttMessageTypeArr[i];
            }
        }
        throw new IllegalArgumentException("unknown message type: " + i);
    }
}
