package com.upuphone.runasone.relay.api;

import com.google.gson.Gson;

public final class ApiRelayMsgAdapter {
    private final ApiRelayMsg adaptee;
    private final Gson gson = new Gson();

    public ApiRelayMsgAdapter(ApiRelayMsg apiRelayMsg) {
        this.adaptee = apiRelayMsg;
    }

    /* JADX WARNING: type inference failed for: r9v0, types: [com.upuphone.runasone.relay.api.SendRelayMessageCallBack] */
    /* JADX WARNING: type inference failed for: r2v2, types: [com.upuphone.runasone.relay.api.SendRelayMessageCallBackProxy] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void adapt(android.os.Bundle r11, android.os.Bundle r12) {
        /*
            r10 = this;
            java.lang.String r0 = "method"
            java.lang.String r0 = r11.getString(r0)
            java.lang.String r1 = "setRelayListener"
            boolean r1 = r1.equals(r0)
            r2 = 0
            java.lang.String r3 = "receiveUniteCode"
            java.lang.String r4 = "sendUniteCode"
            if (r1 == 0) goto L_0x0033
            java.lang.String r12 = r11.getString(r4)
            java.lang.String r0 = r11.getString(r3)
            java.lang.String r1 = "listener"
            android.os.IBinder r11 = r11.getBinder(r1)
            com.upuphone.hub.Hub r11 = com.upuphone.hub.Hub.Stub.asInterface(r11)
            if (r11 == 0) goto L_0x002c
            com.upuphone.runasone.relay.api.RelayCallbackProxy r2 = new com.upuphone.runasone.relay.api.RelayCallbackProxy
            r2.<init>(r11)
        L_0x002c:
            com.upuphone.runasone.relay.api.ApiRelayMsg r10 = r10.adaptee
            r10.setRelayListener(r12, r0, r2)
            goto L_0x0124
        L_0x0033:
            java.lang.String r1 = "removeRelayListener"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x004a
            java.lang.String r12 = r11.getString(r4)
            java.lang.String r11 = r11.getString(r3)
            com.upuphone.runasone.relay.api.ApiRelayMsg r10 = r10.adaptee
            r10.removeRelayListener(r12, r11)
            goto L_0x0124
        L_0x004a:
            java.lang.String r1 = "startRemote"
            boolean r1 = r1.equals(r0)
            java.lang.String r3 = "param"
            java.lang.String r4 = "starryTag"
            if (r1 == 0) goto L_0x0090
            android.os.Parcelable r12 = r11.getParcelable(r4)
            r5 = r12
            com.upuphone.runasone.relay.StarryTag r5 = (com.upuphone.runasone.relay.StarryTag) r5
            java.lang.String r12 = "host"
            java.lang.String r6 = r11.getString(r12)
            java.lang.String r12 = "message"
            android.os.Parcelable r12 = r11.getParcelable(r12)
            r7 = r12
            com.upuphone.runasone.ArrayData r7 = (com.upuphone.runasone.ArrayData) r7
            java.lang.String r12 = "type"
            int r8 = r11.getInt(r12)
            com.upuphone.runasone.relay.api.ApiRelayMsgAdapter$1 r12 = new com.upuphone.runasone.relay.api.ApiRelayMsgAdapter$1
            r12.<init>()
            java.lang.reflect.Type r12 = r12.getType()
            java.lang.String r11 = r11.getString(r3)
            com.google.gson.Gson r0 = r10.gson
            java.lang.Object r11 = r0.fromJson((java.lang.String) r11, (java.lang.reflect.Type) r12)
            r9 = r11
            com.upuphone.runasone.relay.StarryParam r9 = (com.upuphone.runasone.relay.StarryParam) r9
            com.upuphone.runasone.relay.api.ApiRelayMsg r4 = r10.adaptee
            r4.startRemote(r5, r6, r7, r8, r9)
            goto L_0x0124
        L_0x0090:
            java.lang.String r1 = "stopRemote"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x00b9
            android.os.Parcelable r12 = r11.getParcelable(r4)
            com.upuphone.runasone.relay.StarryTag r12 = (com.upuphone.runasone.relay.StarryTag) r12
            com.upuphone.runasone.relay.api.ApiRelayMsgAdapter$2 r0 = new com.upuphone.runasone.relay.api.ApiRelayMsgAdapter$2
            r0.<init>()
            java.lang.reflect.Type r0 = r0.getType()
            java.lang.String r11 = r11.getString(r3)
            com.google.gson.Gson r1 = r10.gson
            java.lang.Object r11 = r1.fromJson((java.lang.String) r11, (java.lang.reflect.Type) r0)
            com.upuphone.runasone.relay.StarryParam r11 = (com.upuphone.runasone.relay.StarryParam) r11
            com.upuphone.runasone.relay.api.ApiRelayMsg r10 = r10.adaptee
            r10.stopRemote(r12, r11)
            goto L_0x0124
        L_0x00b9:
            java.lang.String r1 = "sendMessageQos"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0105
            android.os.Parcelable r12 = r11.getParcelable(r4)
            r5 = r12
            com.upuphone.runasone.relay.StarryTag r5 = (com.upuphone.runasone.relay.StarryTag) r5
            java.lang.String r12 = "msg"
            android.os.Parcelable r12 = r11.getParcelable(r12)
            r6 = r12
            com.upuphone.runasone.ArrayData r6 = (com.upuphone.runasone.ArrayData) r6
            java.lang.String r12 = "qos"
            int r7 = r11.getInt(r12)
            com.upuphone.runasone.relay.api.ApiRelayMsgAdapter$3 r12 = new com.upuphone.runasone.relay.api.ApiRelayMsgAdapter$3
            r12.<init>()
            java.lang.reflect.Type r12 = r12.getType()
            java.lang.String r0 = r11.getString(r3)
            com.google.gson.Gson r1 = r10.gson
            java.lang.Object r12 = r1.fromJson((java.lang.String) r0, (java.lang.reflect.Type) r12)
            r8 = r12
            com.upuphone.runasone.relay.StarryParam r8 = (com.upuphone.runasone.relay.StarryParam) r8
            java.lang.String r12 = "callback"
            android.os.IBinder r11 = r11.getBinder(r12)
            com.upuphone.hub.Hub r11 = com.upuphone.hub.Hub.Stub.asInterface(r11)
            if (r11 == 0) goto L_0x00fe
            com.upuphone.runasone.relay.api.SendRelayMessageCallBackProxy r2 = new com.upuphone.runasone.relay.api.SendRelayMessageCallBackProxy
            r2.<init>(r11)
        L_0x00fe:
            r9 = r2
            com.upuphone.runasone.relay.api.ApiRelayMsg r4 = r10.adaptee
            r4.sendMessageQos(r5, r6, r7, r8, r9)
            goto L_0x0124
        L_0x0105:
            java.lang.String r1 = "getRelayDeviceList"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x0125
            java.lang.String r0 = "appUniteCode"
            java.lang.String r11 = r11.getString(r0)
            com.upuphone.runasone.relay.api.ApiRelayMsg r0 = r10.adaptee
            java.util.List r11 = r0.getRelayDeviceList(r11)
            com.google.gson.Gson r10 = r10.gson
            java.lang.String r10 = r10.toJson((java.lang.Object) r11)
            java.lang.String r11 = "result"
            r12.putString(r11, r10)
        L_0x0124:
            return
        L_0x0125:
            java.lang.UnsupportedOperationException r10 = new java.lang.UnsupportedOperationException
            java.lang.String r11 = "target method not found"
            r10.<init>(r11)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.runasone.relay.api.ApiRelayMsgAdapter.adapt(android.os.Bundle, android.os.Bundle):void");
    }
}
