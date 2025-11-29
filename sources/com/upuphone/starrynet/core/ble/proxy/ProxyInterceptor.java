package com.upuphone.starrynet.core.ble.proxy;

import java.lang.reflect.Method;

public interface ProxyInterceptor {
    boolean onIntercept(Object obj, Method method, Object[] objArr);
}
