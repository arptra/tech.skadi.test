package com.xjsd.ai.assistant.common;

import android.text.TextUtils;
import com.xjsd.ai.assistant.core.AbilityManager;
import com.xjsd.ai.assistant.core.api.cache.CacheAbility;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.protocol.AssistantConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u000f\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/xjsd/ai/assistant/common/SessionHelper;", "", "<init>", "()V", "", "sessionId", "", "c", "(Ljava/lang/String;)V", "a", "()Ljava/lang/String;", "", "b", "(Ljava/lang/String;)Z", "Ljava/lang/String;", "mSessionId", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class SessionHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final SessionHelper f8413a = new SessionHelper();
    public static String b = "-1";

    public final String a() {
        return b;
    }

    public final boolean b(String str) {
        String str2 = b;
        ILog.a("SessionHelper", "当前sessionId->" + str2 + "，待对比的sessionId->" + str);
        if (Intrinsics.areEqual((Object) b, (Object) "-1")) {
            return true;
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return !Intrinsics.areEqual((Object) b, (Object) str);
    }

    public final void c(String str) {
        Intrinsics.checkNotNullParameter(str, AssistantConstants.Key.SESSION_ID);
        b = str;
        CacheAbility cacheAbility = (CacheAbility) AbilityManager.b.b(CacheAbility.class);
        if (cacheAbility != null) {
            cacheAbility.cache(AssistantConstants.Key.SESSION_ID, str);
        }
    }
}
