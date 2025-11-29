package com.share.connect.wifip2p.proxy;

import android.annotation.SuppressLint;
import android.net.wifi.p2p.WifiP2pConfig;
import com.easy.logger.EasyLog;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@SuppressLint({"NewApi", "PrivateApi"})
public class WifiP2pConfigBuilderProxy {

    /* renamed from: a  reason: collision with root package name */
    public static Class f9965a;
    public static Field b;
    public static Method c;
    public static Method d;
    public static Method e;
    public static Method f;
    public static Method g;

    static {
        Class<String> cls = String.class;
        try {
            Class<?> cls2 = Class.forName("android.net.wifi.p2p.WifiP2pConfig$Builder");
            f9965a = cls2;
            c = cls2.getDeclaredMethod("setNetworkName", new Class[]{cls});
            d = f9965a.getDeclaredMethod("setPassphrase", new Class[]{cls});
            Class cls3 = f9965a;
            Class cls4 = Integer.TYPE;
            e = cls3.getDeclaredMethod("setGroupOperatingFrequency", new Class[]{cls4});
            f = f9965a.getDeclaredMethod("setGroupOperatingBand", new Class[]{cls4});
            g = f9965a.getDeclaredMethod(JsonPOJOBuilder.DEFAULT_BUILD_METHOD, (Class[]) null);
            try {
                Field declaredField = f9965a.getDeclaredField("mNetworkName");
                b = declaredField;
                declaredField.setAccessible(true);
            } catch (Exception e2) {
                EasyLog.i("ConfigBuilderProxy", "Reflect private field failed, reasonable. " + e2.getMessage());
            }
        } catch (Exception e3) {
            EasyLog.d("ConfigBuilderProxy", "Reflect initialize failed.", e3);
        }
    }

    public static WifiP2pConfig a(GroupInfo groupInfo) {
        try {
            Object newInstance = f9965a.newInstance();
            try {
                b.set(newInstance, groupInfo.c());
            } catch (Exception e2) {
                EasyLog.i("ConfigBuilderProxy", "Set network name by field failed. " + e2.getMessage());
                c.invoke(newInstance, new Object[]{groupInfo.c()});
            }
            d.invoke(newInstance, new Object[]{groupInfo.d()});
            if (groupInfo.b() == 0) {
                f.invoke(newInstance, new Object[]{Integer.valueOf(groupInfo.a())});
            } else {
                e.invoke(newInstance, new Object[]{Integer.valueOf(groupInfo.b())});
            }
            return (WifiP2pConfig) g.invoke(newInstance, (Object[]) null);
        } catch (Exception e3) {
            EasyLog.c("ConfigBuilderProxy", "Get WifiP2pConfig failed. " + e3.getMessage());
            return null;
        }
    }
}
