package com.upuphone.starrynet.core.ble.proxy;

import com.upuphone.starrynet.core.ble.utils.BluetoothLog;
import java.lang.reflect.Method;

public class ProxyBulk {
    public Object[] args;
    public Method method;
    public Object object;

    public ProxyBulk(Object obj, Method method2, Object[] objArr) {
        this.object = obj;
        this.method = method2;
        this.args = objArr;
    }

    public Object safeInvoke() {
        try {
            return this.method.invoke(this.object, this.args);
        } catch (Throwable th) {
            BluetoothLog.e(th);
            return null;
        }
    }

    public static Object safeInvoke(Object obj) {
        return ((ProxyBulk) obj).safeInvoke();
    }
}
