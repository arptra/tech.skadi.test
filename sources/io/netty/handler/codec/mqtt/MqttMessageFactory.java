package io.netty.handler.codec.mqtt;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.DecoderResult;

public final class MqttMessageFactory {

    /* renamed from: io.netty.handler.codec.mqtt.MqttMessageFactory$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType;

        /* JADX WARNING: Can't wrap try/catch for region: R(32:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|32) */
        /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                io.netty.handler.codec.mqtt.MqttMessageType[] r0 = io.netty.handler.codec.mqtt.MqttMessageType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType = r0
                io.netty.handler.codec.mqtt.MqttMessageType r1 = io.netty.handler.codec.mqtt.MqttMessageType.CONNECT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType     // Catch:{ NoSuchFieldError -> 0x001d }
                io.netty.handler.codec.mqtt.MqttMessageType r1 = io.netty.handler.codec.mqtt.MqttMessageType.CONNACK     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.netty.handler.codec.mqtt.MqttMessageType r1 = io.netty.handler.codec.mqtt.MqttMessageType.SUBSCRIBE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType     // Catch:{ NoSuchFieldError -> 0x0033 }
                io.netty.handler.codec.mqtt.MqttMessageType r1 = io.netty.handler.codec.mqtt.MqttMessageType.SUBACK     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType     // Catch:{ NoSuchFieldError -> 0x003e }
                io.netty.handler.codec.mqtt.MqttMessageType r1 = io.netty.handler.codec.mqtt.MqttMessageType.UNSUBACK     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType     // Catch:{ NoSuchFieldError -> 0x0049 }
                io.netty.handler.codec.mqtt.MqttMessageType r1 = io.netty.handler.codec.mqtt.MqttMessageType.UNSUBSCRIBE     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType     // Catch:{ NoSuchFieldError -> 0x0054 }
                io.netty.handler.codec.mqtt.MqttMessageType r1 = io.netty.handler.codec.mqtt.MqttMessageType.PUBLISH     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType     // Catch:{ NoSuchFieldError -> 0x0060 }
                io.netty.handler.codec.mqtt.MqttMessageType r1 = io.netty.handler.codec.mqtt.MqttMessageType.PUBACK     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType     // Catch:{ NoSuchFieldError -> 0x006c }
                io.netty.handler.codec.mqtt.MqttMessageType r1 = io.netty.handler.codec.mqtt.MqttMessageType.PUBREC     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType     // Catch:{ NoSuchFieldError -> 0x0078 }
                io.netty.handler.codec.mqtt.MqttMessageType r1 = io.netty.handler.codec.mqtt.MqttMessageType.PUBREL     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType     // Catch:{ NoSuchFieldError -> 0x0084 }
                io.netty.handler.codec.mqtt.MqttMessageType r1 = io.netty.handler.codec.mqtt.MqttMessageType.PUBCOMP     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType     // Catch:{ NoSuchFieldError -> 0x0090 }
                io.netty.handler.codec.mqtt.MqttMessageType r1 = io.netty.handler.codec.mqtt.MqttMessageType.PINGREQ     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType     // Catch:{ NoSuchFieldError -> 0x009c }
                io.netty.handler.codec.mqtt.MqttMessageType r1 = io.netty.handler.codec.mqtt.MqttMessageType.PINGRESP     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType     // Catch:{ NoSuchFieldError -> 0x00a8 }
                io.netty.handler.codec.mqtt.MqttMessageType r1 = io.netty.handler.codec.mqtt.MqttMessageType.DISCONNECT     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = $SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType     // Catch:{ NoSuchFieldError -> 0x00b4 }
                io.netty.handler.codec.mqtt.MqttMessageType r1 = io.netty.handler.codec.mqtt.MqttMessageType.AUTH     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.mqtt.MqttMessageFactory.AnonymousClass1.<clinit>():void");
        }
    }

    private MqttMessageFactory() {
    }

    public static MqttMessage newInvalidMessage(Throwable th) {
        return new MqttMessage((MqttFixedHeader) null, (Object) null, (Object) null, DecoderResult.failure(th));
    }

    public static MqttMessage newMessage(MqttFixedHeader mqttFixedHeader, Object obj, Object obj2) {
        switch (AnonymousClass1.$SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType[mqttFixedHeader.messageType().ordinal()]) {
            case 1:
                return new MqttConnectMessage(mqttFixedHeader, (MqttConnectVariableHeader) obj, (MqttConnectPayload) obj2);
            case 2:
                return new MqttConnAckMessage(mqttFixedHeader, (MqttConnAckVariableHeader) obj);
            case 3:
                return new MqttSubscribeMessage(mqttFixedHeader, (MqttMessageIdVariableHeader) obj, (MqttSubscribePayload) obj2);
            case 4:
                return new MqttSubAckMessage(mqttFixedHeader, (MqttMessageIdVariableHeader) obj, (MqttSubAckPayload) obj2);
            case 5:
                return new MqttUnsubAckMessage(mqttFixedHeader, (MqttMessageIdVariableHeader) obj, (MqttUnsubAckPayload) obj2);
            case 6:
                return new MqttUnsubscribeMessage(mqttFixedHeader, (MqttMessageIdVariableHeader) obj, (MqttUnsubscribePayload) obj2);
            case 7:
                return new MqttPublishMessage(mqttFixedHeader, (MqttPublishVariableHeader) obj, (ByteBuf) obj2);
            case 8:
                return new MqttPubAckMessage(mqttFixedHeader, (MqttMessageIdVariableHeader) obj);
            case 9:
            case 10:
            case 11:
                return new MqttMessage(mqttFixedHeader, obj);
            case 12:
            case 13:
                return new MqttMessage(mqttFixedHeader);
            case 14:
            case 15:
                return new MqttMessage(mqttFixedHeader, obj);
            default:
                throw new IllegalArgumentException("unknown message type: " + mqttFixedHeader.messageType());
        }
    }

    public static MqttMessage newInvalidMessage(MqttFixedHeader mqttFixedHeader, Object obj, Throwable th) {
        return new MqttMessage(mqttFixedHeader, obj, (Object) null, DecoderResult.failure(th));
    }
}
