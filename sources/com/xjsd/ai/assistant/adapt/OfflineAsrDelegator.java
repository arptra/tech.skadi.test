package com.xjsd.ai.assistant.adapt;

import com.honey.account.w9.b;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/xjsd/ai/assistant/adapt/OfflineAsrDelegator;", "", "<init>", "()V", "Lcom/xjsd/ai/assistant/adapt/OfflineAsrDelegate;", "b", "()Lcom/xjsd/ai/assistant/adapt/OfflineAsrDelegate;", "Lcom/xjsd/ai/assistant/adapt/OfflineAsrDelegate;", "delegate", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class OfflineAsrDelegator {

    /* renamed from: a  reason: collision with root package name */
    public static final OfflineAsrDelegator f8382a = new OfflineAsrDelegator();
    public static OfflineAsrDelegate b;

    public static final Object c(Object obj, Method method, Object[] objArr) {
        OfflineAsrDelegate offlineAsrDelegate = b;
        if (offlineAsrDelegate != null) {
            return (objArr == null || objArr.length == 0) ? method.invoke(offlineAsrDelegate, (Object[]) null) : method.invoke(offlineAsrDelegate, Arrays.copyOf(objArr, objArr.length));
        }
        return null;
    }

    public final OfflineAsrDelegate b() {
        Object newProxyInstance = Proxy.newProxyInstance(OfflineAsrDelegator.class.getClassLoader(), new Class[]{OfflineAsrDelegate.class}, new b());
        Intrinsics.checkNotNull(newProxyInstance, "null cannot be cast to non-null type com.xjsd.ai.assistant.adapt.OfflineAsrDelegate");
        return (OfflineAsrDelegate) newProxyInstance;
    }
}
