package io.netty.handler.codec.mqtt;

public final class MqttSubscriptionOption {
    private final boolean noLocal;
    private final MqttQoS qos;
    private final boolean retainAsPublished;
    private final RetainedHandlingPolicy retainHandling;

    public enum RetainedHandlingPolicy {
        SEND_AT_SUBSCRIBE(0),
        SEND_AT_SUBSCRIBE_IF_NOT_YET_EXISTS(1),
        DONT_SEND_AT_SUBSCRIBE(2);
        
        private final int value;

        private RetainedHandlingPolicy(int i) {
            this.value = i;
        }

        public int value() {
            return this.value;
        }

        public static RetainedHandlingPolicy valueOf(int i) {
            if (i == 0) {
                return SEND_AT_SUBSCRIBE;
            }
            if (i == 1) {
                return SEND_AT_SUBSCRIBE_IF_NOT_YET_EXISTS;
            }
            if (i == 2) {
                return DONT_SEND_AT_SUBSCRIBE;
            }
            throw new IllegalArgumentException("invalid RetainedHandlingPolicy: " + i);
        }
    }

    public MqttSubscriptionOption(MqttQoS mqttQoS, boolean z, boolean z2, RetainedHandlingPolicy retainedHandlingPolicy) {
        this.qos = mqttQoS;
        this.noLocal = z;
        this.retainAsPublished = z2;
        this.retainHandling = retainedHandlingPolicy;
    }

    public static MqttSubscriptionOption onlyFromQos(MqttQoS mqttQoS) {
        return new MqttSubscriptionOption(mqttQoS, false, false, RetainedHandlingPolicy.SEND_AT_SUBSCRIBE);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || MqttSubscriptionOption.class != obj.getClass()) {
            return false;
        }
        MqttSubscriptionOption mqttSubscriptionOption = (MqttSubscriptionOption) obj;
        if (this.noLocal == mqttSubscriptionOption.noLocal && this.retainAsPublished == mqttSubscriptionOption.retainAsPublished && this.qos == mqttSubscriptionOption.qos) {
            return this.retainHandling == mqttSubscriptionOption.retainHandling;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.qos.hashCode() * 31) + (this.noLocal ? 1 : 0)) * 31) + (this.retainAsPublished ? 1 : 0)) * 31) + this.retainHandling.hashCode();
    }

    public boolean isNoLocal() {
        return this.noLocal;
    }

    public boolean isRetainAsPublished() {
        return this.retainAsPublished;
    }

    public MqttQoS qos() {
        return this.qos;
    }

    public RetainedHandlingPolicy retainHandling() {
        return this.retainHandling;
    }

    public String toString() {
        return "SubscriptionOption[qos=" + this.qos + ", noLocal=" + this.noLocal + ", retainAsPublished=" + this.retainAsPublished + ", retainHandling=" + this.retainHandling + ']';
    }
}
