package com.upuphone.ai.ttsengine.base.utils;

import com.upuphone.ai.ttsengine.base.enums.TtsAgentType;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bR&\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\t8\u0002X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u0012\u0004\b\f\u0010\u0003¨\u0006\u000e"}, d2 = {"Lcom/upuphone/ai/ttsengine/base/utils/AgentUtils;", "", "<init>", "()V", "Lcom/upuphone/ai/ttsengine/base/enums/TtsAgentType;", "type", "", "a", "(Lcom/upuphone/ai/ttsengine/base/enums/TtsAgentType;)I", "", "b", "Ljava/util/Map;", "getPriorityMap$annotations", "priorityMap", "aar_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class AgentUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final AgentUtils f5523a = new AgentUtils();
    public static final Map b = MapsKt.mapOf(TuplesKt.to(TtsAgentType.CACHE, 2147483646), TuplesKt.to(TtsAgentType.GOOGLE, 2147483645), TuplesKt.to(TtsAgentType.CLOUD, 2147483644), TuplesKt.to(TtsAgentType.BYTEDANCE, 2147483643), TuplesKt.to(TtsAgentType.LOCAL_FILE, 2147483642));

    public static final int a(TtsAgentType ttsAgentType) {
        Intrinsics.checkNotNullParameter(ttsAgentType, "type");
        Integer num = (Integer) b.get(ttsAgentType);
        if (num != null) {
            return num.intValue();
        }
        return Integer.MAX_VALUE;
    }
}
