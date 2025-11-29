package com.xjsd.ai.assistant.adapt;

import com.honey.account.w9.a;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0006R\u0016\u0010\t\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/xjsd/ai/assistant/adapt/ImDelegator;", "", "<init>", "()V", "Lcom/xjsd/ai/assistant/adapt/ImDelegate;", "d", "()Lcom/xjsd/ai/assistant/adapt/ImDelegate;", "b", "Lcom/xjsd/ai/assistant/adapt/ImDelegate;", "delegate", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class ImDelegator {

    /* renamed from: a  reason: collision with root package name */
    public static final ImDelegator f8381a;
    public static ImDelegate b;

    static {
        ImDelegator imDelegator = new ImDelegator();
        f8381a = imDelegator;
        b = imDelegator.b();
    }

    public static final Object c(Object obj, Method method, Object[] objArr) {
        return null;
    }

    public final ImDelegate b() {
        Object newProxyInstance = Proxy.newProxyInstance(ImDelegator.class.getClassLoader(), new Class[]{ImDelegate.class}, new a());
        Intrinsics.checkNotNull(newProxyInstance, "null cannot be cast to non-null type com.xjsd.ai.assistant.adapt.ImDelegate");
        return (ImDelegate) newProxyInstance;
    }

    public final ImDelegate d() {
        return b;
    }
}
