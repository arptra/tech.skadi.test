package io.netty.handler.codec.mqtt;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class MqttUnsubAckPayload {
    private static final MqttUnsubAckPayload EMPTY = new MqttUnsubAckPayload(new short[0]);
    private final List<Short> unsubscribeReasonCodes;

    public MqttUnsubAckPayload(short... sArr) {
        ObjectUtil.checkNotNull(sArr, "unsubscribeReasonCodes");
        ArrayList arrayList = new ArrayList(sArr.length);
        for (short valueOf : sArr) {
            arrayList.add(Short.valueOf(valueOf));
        }
        this.unsubscribeReasonCodes = Collections.unmodifiableList(arrayList);
    }

    public static MqttUnsubAckPayload withEmptyDefaults(MqttUnsubAckPayload mqttUnsubAckPayload) {
        return mqttUnsubAckPayload == null ? EMPTY : mqttUnsubAckPayload;
    }

    public String toString() {
        return StringUtil.simpleClassName((Object) this) + '[' + "unsubscribeReasonCodes=" + this.unsubscribeReasonCodes + ']';
    }

    public List<Short> unsubscribeReasonCodes() {
        return this.unsubscribeReasonCodes;
    }

    public MqttUnsubAckPayload(Iterable<Short> iterable) {
        ObjectUtil.checkNotNull(iterable, "unsubscribeReasonCodes");
        ArrayList arrayList = new ArrayList();
        for (Short next : iterable) {
            ObjectUtil.checkNotNull(next, "unsubscribeReasonCode");
            arrayList.add(next);
        }
        this.unsubscribeReasonCodes = Collections.unmodifiableList(arrayList);
    }
}
