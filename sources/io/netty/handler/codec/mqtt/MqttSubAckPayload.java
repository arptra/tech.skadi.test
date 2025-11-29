package io.netty.handler.codec.mqtt;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class MqttSubAckPayload {
    private final List<Integer> reasonCodes;

    public MqttSubAckPayload(int... iArr) {
        ObjectUtil.checkNotNull(iArr, "reasonCodes");
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int valueOf : iArr) {
            arrayList.add(Integer.valueOf(valueOf));
        }
        this.reasonCodes = Collections.unmodifiableList(arrayList);
    }

    public List<Integer> grantedQoSLevels() {
        ArrayList arrayList = new ArrayList(this.reasonCodes.size());
        for (Integer next : this.reasonCodes) {
            if (next.intValue() > MqttQoS.EXACTLY_ONCE.value()) {
                arrayList.add(Integer.valueOf(MqttQoS.FAILURE.value()));
            } else {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public List<Integer> reasonCodes() {
        return this.reasonCodes;
    }

    public String toString() {
        return StringUtil.simpleClassName((Object) this) + '[' + "reasonCodes=" + this.reasonCodes + ']';
    }

    public MqttSubAckPayload(Iterable<Integer> iterable) {
        Integer next;
        ObjectUtil.checkNotNull(iterable, "reasonCodes");
        ArrayList arrayList = new ArrayList();
        Iterator<Integer> it = iterable.iterator();
        while (it.hasNext() && (next = it.next()) != null) {
            arrayList.add(next);
        }
        this.reasonCodes = Collections.unmodifiableList(arrayList);
    }
}
