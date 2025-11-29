package io.netty.handler.codec.mqtt;

import io.netty.util.internal.StringUtil;

public final class MqttTopicSubscription {
    private final MqttSubscriptionOption option;
    private final String topicFilter;

    public MqttTopicSubscription(String str, MqttQoS mqttQoS) {
        this.topicFilter = str;
        this.option = MqttSubscriptionOption.onlyFromQos(mqttQoS);
    }

    public MqttSubscriptionOption option() {
        return this.option;
    }

    public MqttQoS qualityOfService() {
        return this.option.qos();
    }

    public String toString() {
        return StringUtil.simpleClassName((Object) this) + '[' + "topicFilter=" + this.topicFilter + ", option=" + this.option + ']';
    }

    public String topicName() {
        return this.topicFilter;
    }

    public MqttTopicSubscription(String str, MqttSubscriptionOption mqttSubscriptionOption) {
        this.topicFilter = str;
        this.option = mqttSubscriptionOption;
    }
}
