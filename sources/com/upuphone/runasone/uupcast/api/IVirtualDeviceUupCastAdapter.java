package com.upuphone.runasone.uupcast.api;

import android.os.Bundle;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.upuphone.hub.Hub;
import com.upuphone.runasone.device.StarryDevice;
import java.lang.reflect.Type;

public final class IVirtualDeviceUupCastAdapter {
    private final IVirtualDeviceUupCast adaptee;
    private final Gson gson = new Gson();

    public IVirtualDeviceUupCastAdapter(IVirtualDeviceUupCast iVirtualDeviceUupCast) {
        this.adaptee = iVirtualDeviceUupCast;
    }

    public void adapt(Bundle bundle, Bundle bundle2) {
        String string = bundle.getString("method");
        if ("startSinkServer".equals(string)) {
            Type type = new TypeToken<StarryDevice>() {
            }.getType();
            String string2 = bundle.getString("device");
            bundle2.putInt("result", this.adaptee.startSinkServer((StarryDevice) this.gson.fromJson(string2, type)));
        } else if ("stopSinkServer".equals(string)) {
            bundle2.putInt("result", this.adaptee.stopSinkServer());
        } else if ("stopSourceClient".equals(string)) {
            bundle2.putInt("result", this.adaptee.stopSourceClient());
        } else if ("startSourceClient".equals(string)) {
            bundle2.putInt("result", this.adaptee.startSourceClient());
        } else if ("registerVirtualMic".equals(string)) {
            bundle2.putInt("result", this.adaptee.registerVirtualMic(bundle.getInt("id")));
        } else if ("unregisterVirtualMic".equals(string)) {
            bundle2.putInt("result", this.adaptee.unregisterVirtualMic(bundle.getInt("id")));
        } else if ("registerVirtualModem".equals(string)) {
            bundle2.putInt("result", this.adaptee.registerVirtualModem(bundle.getInt("id")));
        } else if ("unregisterVirtualModem".equals(string)) {
            bundle2.putInt("result", this.adaptee.unregisterVirtualModem(bundle.getInt("id")));
        } else if ("registerVirtualCamera".equals(string)) {
            bundle2.putInt("result", this.adaptee.registerVirtualCamera(bundle.getInt("id")));
        } else if ("unregisterVirtualCamera".equals(string)) {
            bundle2.putInt("result", this.adaptee.unregisterVirtualCamera(bundle.getInt("id")));
        } else {
            IVirtualDeviceEventListenerProxy iVirtualDeviceEventListenerProxy = null;
            if ("setSourceEventCallback".equals(string)) {
                Hub asInterface = Hub.Stub.asInterface(bundle.getBinder(ServiceSpecificExtraArgs.CastExtraArgs.LISTENER));
                if (asInterface != null) {
                    iVirtualDeviceEventListenerProxy = new IVirtualDeviceEventListenerProxy(asInterface);
                }
                bundle2.putInt("result", this.adaptee.setSourceEventCallback(iVirtualDeviceEventListenerProxy));
            } else if ("unsetSourceEventCallback".equals(string)) {
                bundle2.putInt("result", this.adaptee.unsetSourceEventCallback());
            } else if ("setSinkEventCallback".equals(string)) {
                Hub asInterface2 = Hub.Stub.asInterface(bundle.getBinder(ServiceSpecificExtraArgs.CastExtraArgs.LISTENER));
                if (asInterface2 != null) {
                    iVirtualDeviceEventListenerProxy = new IVirtualDeviceEventListenerProxy(asInterface2);
                }
                bundle2.putInt("result", this.adaptee.setSinkEventCallback(iVirtualDeviceEventListenerProxy));
            } else if ("unsetSinkEventCallback".equals(string)) {
                bundle2.putInt("result", this.adaptee.unsetSinkEventCallback());
            } else if ("enableMicByType".equals(string)) {
                bundle2.putInt("result", this.adaptee.enableMicByType(bundle.getInt("micType")));
            } else if ("enableCameraByType".equals(string)) {
                bundle2.putInt("result", this.adaptee.enableCameraByType(bundle.getInt("cameraType")));
            } else {
                throw new UnsupportedOperationException("target method not found");
            }
        }
    }
}
