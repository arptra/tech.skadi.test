package io.netty.handler.codec.mqtt;

import io.netty.util.CharsetUtil;
import io.netty.util.internal.ObjectUtil;

public enum MqttVersion {
    MQTT_3_1("MQIsdp", (byte) 3),
    MQTT_3_1_1("MQTT", (byte) 4),
    MQTT_5("MQTT", (byte) 5);
    
    private final byte level;
    private final String name;

    private MqttVersion(String str, byte b) {
        this.name = (String) ObjectUtil.checkNotNull(str, "protocolName");
        this.level = b;
    }

    public static MqttVersion fromProtocolNameAndLevel(String str, byte b) {
        MqttVersion mqttVersion = b != 3 ? b != 4 ? b != 5 ? null : MQTT_5 : MQTT_3_1_1 : MQTT_3_1;
        if (mqttVersion == null) {
            throw new MqttUnacceptableProtocolVersionException(str + " is an unknown protocol name");
        } else if (mqttVersion.name.equals(str)) {
            return mqttVersion;
        } else {
            throw new MqttUnacceptableProtocolVersionException(str + " and " + b + " don't match");
        }
    }

    public byte protocolLevel() {
        return this.level;
    }

    public String protocolName() {
        return this.name;
    }

    public byte[] protocolNameBytes() {
        return this.name.getBytes(CharsetUtil.UTF_8);
    }
}
