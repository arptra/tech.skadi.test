package io.netty.handler.codec.mqtt;

import io.netty.util.internal.StringUtil;

public final class MqttConnectVariableHeader {
    private final boolean hasPassword;
    private final boolean hasUserName;
    private final boolean isCleanSession;
    private final boolean isWillFlag;
    private final boolean isWillRetain;
    private final int keepAliveTimeSeconds;
    private final String name;
    private final MqttProperties properties;
    private final int version;
    private final int willQos;

    public MqttConnectVariableHeader(String str, int i, boolean z, boolean z2, boolean z3, int i2, boolean z4, boolean z5, int i3) {
        this(str, i, z, z2, z3, i2, z4, z5, i3, MqttProperties.NO_PROPERTIES);
    }

    public boolean hasPassword() {
        return this.hasPassword;
    }

    public boolean hasUserName() {
        return this.hasUserName;
    }

    public boolean isCleanSession() {
        return this.isCleanSession;
    }

    public boolean isWillFlag() {
        return this.isWillFlag;
    }

    public boolean isWillRetain() {
        return this.isWillRetain;
    }

    public int keepAliveTimeSeconds() {
        return this.keepAliveTimeSeconds;
    }

    public String name() {
        return this.name;
    }

    public MqttProperties properties() {
        return this.properties;
    }

    public String toString() {
        return StringUtil.simpleClassName((Object) this) + '[' + "name=" + this.name + ", version=" + this.version + ", hasUserName=" + this.hasUserName + ", hasPassword=" + this.hasPassword + ", isWillRetain=" + this.isWillRetain + ", isWillFlag=" + this.isWillFlag + ", isCleanSession=" + this.isCleanSession + ", keepAliveTimeSeconds=" + this.keepAliveTimeSeconds + ']';
    }

    public int version() {
        return this.version;
    }

    public int willQos() {
        return this.willQos;
    }

    public MqttConnectVariableHeader(String str, int i, boolean z, boolean z2, boolean z3, int i2, boolean z4, boolean z5, int i3, MqttProperties mqttProperties) {
        this.name = str;
        this.version = i;
        this.hasUserName = z;
        this.hasPassword = z2;
        this.isWillRetain = z3;
        this.willQos = i2;
        this.isWillFlag = z4;
        this.isCleanSession = z5;
        this.keepAliveTimeSeconds = i3;
        this.properties = MqttProperties.withEmptyDefaults(mqttProperties);
    }
}
