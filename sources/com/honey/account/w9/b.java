package com.honey.account.w9;

import com.xjsd.ai.assistant.adapt.OfflineAsrDelegator;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public final /* synthetic */ class b implements InvocationHandler {
    public final Object invoke(Object obj, Method method, Object[] objArr) {
        return OfflineAsrDelegator.c(obj, method, objArr);
    }
}
