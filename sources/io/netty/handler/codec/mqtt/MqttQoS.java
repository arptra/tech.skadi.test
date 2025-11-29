package io.netty.handler.codec.mqtt;

public enum MqttQoS {
    AT_MOST_ONCE(0),
    AT_LEAST_ONCE(1),
    EXACTLY_ONCE(2),
    FAILURE(128);
    
    private final int value;

    private MqttQoS(int i) {
        this.value = i;
    }

    public int value() {
        return this.value;
    }

    public static MqttQoS valueOf(int i) {
        if (i == 0) {
            return AT_MOST_ONCE;
        }
        if (i == 1) {
            return AT_LEAST_ONCE;
        }
        if (i == 2) {
            return EXACTLY_ONCE;
        }
        if (i == 128) {
            return FAILURE;
        }
        throw new IllegalArgumentException("invalid QoS: " + i);
    }
}
