package com.share.connect.wifip2p.proxy;

import android.annotation.SuppressLint;
import android.net.wifi.p2p.WifiP2pGroup;
import android.net.wifi.p2p.WifiP2pManager;
import android.text.TextUtils;
import com.easy.logger.EasyLog;
import com.share.connect.wifip2p.LogActionListener;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Collection;
import java.util.Iterator;

@SuppressLint({"PrivateApi", "DiscouragedPrivateApi"})
public class WifiP2pManagerProxy {

    public interface PersistentGroupInfoListener {
        void a(Collection collection);
    }

    public static void a(final WifiP2pManager wifiP2pManager, final WifiP2pManager.Channel channel) {
        EasyLog.a("WifiP2pManagerProxy", "Delete all persistent groups.");
        try {
            final Method declaredMethod = WifiP2pGroup.class.getDeclaredMethod("getNetworkId", (Class[]) null);
            c(wifiP2pManager, channel, new PersistentGroupInfoListener() {
                public void a(Collection collection) {
                    int i;
                    Iterator it = collection.iterator();
                    while (it.hasNext()) {
                        try {
                            i = ((Integer) declaredMethod.invoke((WifiP2pGroup) it.next(), (Object[]) null)).intValue();
                        } catch (IllegalAccessException | InvocationTargetException e) {
                            EasyLog.d("WifiP2pManagerProxy", "getNetworkId exception ", e);
                            i = 0;
                        }
                        WifiP2pManager wifiP2pManager = wifiP2pManager;
                        WifiP2pManager.Channel channel = channel;
                        WifiP2pManagerProxy.b(wifiP2pManager, channel, i, new LogActionListener("WifiP2pManagerProxy", "Delete " + i));
                    }
                }
            });
        } catch (Exception e) {
            EasyLog.j("WifiP2pManagerProxy", "Delete all persistent group failed.", e);
        }
    }

    public static void b(WifiP2pManager wifiP2pManager, WifiP2pManager.Channel channel, int i, WifiP2pManager.ActionListener actionListener) {
        EasyLog.a("WifiP2pManagerProxy", "Delete persistent group.");
        try {
            WifiP2pManager.class.getDeclaredMethod("deletePersistentGroup", new Class[]{WifiP2pManager.Channel.class, Integer.TYPE, WifiP2pManager.ActionListener.class}).invoke(wifiP2pManager, new Object[]{channel, Integer.valueOf(i), actionListener});
        } catch (Exception e) {
            EasyLog.b("WifiP2pManagerProxy", "Delete persistent group failed.", e);
        }
    }

    public static boolean c(WifiP2pManager wifiP2pManager, WifiP2pManager.Channel channel, final PersistentGroupInfoListener persistentGroupInfoListener) {
        try {
            final Method declaredMethod = Class.forName("android.net.wifi.p2p.WifiP2pGroupList").getDeclaredMethod("getGroupList", (Class[]) null);
            AnonymousClass1 r1 = new InvocationHandler() {
                public Object invoke(Object obj, Method method, Object[] objArr) {
                    if (TextUtils.equals("onPersistentGroupInfoAvailable", method.getName())) {
                        Collection collection = (Collection) declaredMethod.invoke(objArr[0], (Object[]) null);
                        PersistentGroupInfoListener persistentGroupInfoListener = persistentGroupInfoListener;
                        if (persistentGroupInfoListener != null) {
                            persistentGroupInfoListener.a(collection);
                        }
                    }
                    return null;
                }
            };
            Class<?> cls = Class.forName("android.net.wifi.p2p.WifiP2pManager$PersistentGroupInfoListener");
            Method declaredMethod2 = WifiP2pManager.class.getDeclaredMethod("requestPersistentGroupInfo", new Class[]{WifiP2pManager.Channel.class, cls});
            ClassLoader classLoader = cls.getClassLoader();
            if (classLoader == null) {
                return true;
            }
            declaredMethod2.invoke(wifiP2pManager, new Object[]{channel, Proxy.newProxyInstance(classLoader, new Class[]{cls}, r1)});
            return true;
        } catch (Exception e) {
            EasyLog.j("WifiP2pManagerProxy", "Request persistent group info failed.", e);
            return false;
        }
    }

    public static boolean d(WifiP2pManager wifiP2pManager, WifiP2pManager.Channel channel, int i, WifiP2pManager.ActionListener actionListener) {
        EasyLog.a("WifiP2pManagerProxy", "Try to set channel to " + i);
        Class<WifiP2pManager> cls = WifiP2pManager.class;
        Class<WifiP2pManager.Channel> cls2 = WifiP2pManager.Channel.class;
        try {
            Class cls3 = Integer.TYPE;
            cls.getDeclaredMethod("setWifiP2pChannels", new Class[]{cls2, cls3, cls3, WifiP2pManager.ActionListener.class}).invoke(wifiP2pManager, new Object[]{channel, 0, Integer.valueOf(i), actionListener});
            return true;
        } catch (Exception e) {
            EasyLog.d("WifiP2pManagerProxy", "setWifiP2pChannels invoke failed", e);
            return false;
        }
    }
}
