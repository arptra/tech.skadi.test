package com.honey.account.w9;

import com.xjsd.ai.assistant.adapt.ImDelegator;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public final /* synthetic */ class a implements InvocationHandler {
    public final Object invoke(Object obj, Method method, Object[] objArr) {
        return ImDelegator.c(obj, method, objArr);
    }
}
