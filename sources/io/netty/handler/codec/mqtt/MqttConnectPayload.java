package io.netty.handler.codec.mqtt;

import io.netty.util.CharsetUtil;
import io.netty.util.internal.StringUtil;
import java.util.Arrays;

public final class MqttConnectPayload {
    private final String clientIdentifier;
    private final byte[] password;
    private final String userName;
    private final byte[] willMessage;
    private final MqttProperties willProperties;
    private final String willTopic;

    /* JADX WARNING: Illegal instructions before constructor call */
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MqttConnectPayload(java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, java.lang.String r12) {
        /*
            r7 = this;
            io.netty.handler.codec.mqtt.MqttProperties r2 = io.netty.handler.codec.mqtt.MqttProperties.NO_PROPERTIES
            java.nio.charset.Charset r0 = io.netty.util.CharsetUtil.UTF_8
            byte[] r4 = r10.getBytes(r0)
            byte[] r6 = r12.getBytes(r0)
            r0 = r7
            r1 = r8
            r3 = r9
            r5 = r11
            r0.<init>(r1, r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.mqtt.MqttConnectPayload.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
    }

    public String clientIdentifier() {
        return this.clientIdentifier;
    }

    @Deprecated
    public String password() {
        byte[] bArr = this.password;
        if (bArr == null) {
            return null;
        }
        return new String(bArr, CharsetUtil.UTF_8);
    }

    public byte[] passwordInBytes() {
        return this.password;
    }

    public String toString() {
        return StringUtil.simpleClassName((Object) this) + '[' + "clientIdentifier=" + this.clientIdentifier + ", willTopic=" + this.willTopic + ", willMessage=" + Arrays.toString(this.willMessage) + ", userName=" + this.userName + ", password=" + Arrays.toString(this.password) + ']';
    }

    public String userName() {
        return this.userName;
    }

    @Deprecated
    public String willMessage() {
        byte[] bArr = this.willMessage;
        if (bArr == null) {
            return null;
        }
        return new String(bArr, CharsetUtil.UTF_8);
    }

    public byte[] willMessageInBytes() {
        return this.willMessage;
    }

    public MqttProperties willProperties() {
        return this.willProperties;
    }

    public String willTopic() {
        return this.willTopic;
    }

    public MqttConnectPayload(String str, String str2, byte[] bArr, String str3, byte[] bArr2) {
        this(str, MqttProperties.NO_PROPERTIES, str2, bArr, str3, bArr2);
    }

    public MqttConnectPayload(String str, MqttProperties mqttProperties, String str2, byte[] bArr, String str3, byte[] bArr2) {
        this.clientIdentifier = str;
        this.willProperties = MqttProperties.withEmptyDefaults(mqttProperties);
        this.willTopic = str2;
        this.willMessage = bArr;
        this.userName = str3;
        this.password = bArr2;
    }
}
