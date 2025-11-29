package com.upuphone.runasone.ble;

import com.google.gson.Gson;

public final class ApiAdapter {
    private final Api adaptee;
    private final Gson gson = new Gson();

    public ApiAdapter(Api api) {
        this.adaptee = api;
    }

    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v1, types: [com.upuphone.runasone.ble.MtuCallback] */
    /* JADX WARNING: type inference failed for: r2v3, types: [com.upuphone.runasone.ble.OpenNotifyCallback] */
    /* JADX WARNING: type inference failed for: r2v5, types: [com.upuphone.runasone.ble.ReadCallback] */
    /* JADX WARNING: type inference failed for: r2v7, types: [com.upuphone.runasone.ble.WriteCallback] */
    /* JADX WARNING: type inference failed for: r2v9, types: [com.upuphone.runasone.ble.InitSessionCallback] */
    /* JADX WARNING: type inference failed for: r2v11, types: [com.upuphone.runasone.ble.SessionCallback] */
    /* JADX WARNING: type inference failed for: r2v13, types: [com.upuphone.runasone.ble.DeviceCallback] */
    /* JADX WARNING: type inference failed for: r2v15 */
    /* JADX WARNING: type inference failed for: r2v16 */
    /* JADX WARNING: type inference failed for: r2v17 */
    /* JADX WARNING: type inference failed for: r2v18 */
    /* JADX WARNING: type inference failed for: r2v19 */
    /* JADX WARNING: type inference failed for: r2v20 */
    /* JADX WARNING: type inference failed for: r2v21 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void adapt(android.os.Bundle r6, android.os.Bundle r7) {
        /*
            r5 = this;
            java.lang.String r0 = "method"
            java.lang.String r0 = r6.getString(r0)
            java.lang.String r1 = "registerDeviceCallback"
            boolean r1 = r1.equals(r0)
            r2 = 0
            java.lang.String r3 = "callback"
            java.lang.String r4 = "deviceId"
            if (r1 == 0) goto L_0x002d
            java.lang.String r7 = r6.getString(r4)
            android.os.IBinder r6 = r6.getBinder(r3)
            com.upuphone.hub.Hub r6 = com.upuphone.hub.Hub.Stub.asInterface(r6)
            if (r6 == 0) goto L_0x0026
            com.upuphone.runasone.ble.DeviceCallbackProxy r2 = new com.upuphone.runasone.ble.DeviceCallbackProxy
            r2.<init>(r6)
        L_0x0026:
            com.upuphone.runasone.ble.Api r5 = r5.adaptee
            r5.registerDeviceCallback(r7, r2)
            goto L_0x01ac
        L_0x002d:
            java.lang.String r1 = "unregisterDeviceCallback"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0041
            java.lang.String r6 = r6.getString(r4)
            com.upuphone.runasone.ble.Api r5 = r5.adaptee
            r5.unregisterDeviceCallback(r6)
            goto L_0x01ac
        L_0x0041:
            java.lang.String r1 = "connect"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x006b
            java.lang.String r7 = r6.getString(r4)
            com.upuphone.runasone.ble.ApiAdapter$1 r0 = new com.upuphone.runasone.ble.ApiAdapter$1
            r0.<init>()
            java.lang.reflect.Type r0 = r0.getType()
            java.lang.String r1 = "config"
            java.lang.String r6 = r6.getString(r1)
            com.google.gson.Gson r1 = r5.gson
            java.lang.Object r6 = r1.fromJson((java.lang.String) r6, (java.lang.reflect.Type) r0)
            com.upuphone.runasone.ble.ConnectConfig r6 = (com.upuphone.runasone.ble.ConnectConfig) r6
            com.upuphone.runasone.ble.Api r5 = r5.adaptee
            r5.connect(r7, r6)
            goto L_0x01ac
        L_0x006b:
            java.lang.String r1 = "disconnect"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x007e
            java.lang.String r6 = r6.getString(r4)
            com.upuphone.runasone.ble.Api r5 = r5.adaptee
            r5.disconnect(r6)
            goto L_0x01ac
        L_0x007e:
            java.lang.String r1 = "registerSessionCallback"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x00a0
            java.lang.String r7 = r6.getString(r4)
            android.os.IBinder r6 = r6.getBinder(r3)
            com.upuphone.hub.Hub r6 = com.upuphone.hub.Hub.Stub.asInterface(r6)
            if (r6 == 0) goto L_0x0099
            com.upuphone.runasone.ble.SessionCallbackProxy r2 = new com.upuphone.runasone.ble.SessionCallbackProxy
            r2.<init>(r6)
        L_0x0099:
            com.upuphone.runasone.ble.Api r5 = r5.adaptee
            r5.registerSessionCallback(r7, r2)
            goto L_0x01ac
        L_0x00a0:
            java.lang.String r1 = "unregisterSessionCallback"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x00b4
            java.lang.String r6 = r6.getString(r4)
            com.upuphone.runasone.ble.Api r5 = r5.adaptee
            r5.unregisterSessionCallback(r6)
            goto L_0x01ac
        L_0x00b4:
            java.lang.String r1 = "initSession"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x00ed
            java.lang.String r7 = r6.getString(r4)
            com.upuphone.runasone.ble.ApiAdapter$2 r0 = new com.upuphone.runasone.ble.ApiAdapter$2
            r0.<init>()
            java.lang.reflect.Type r0 = r0.getType()
            java.lang.String r1 = "sessionConfig"
            java.lang.String r1 = r6.getString(r1)
            com.google.gson.Gson r4 = r5.gson
            java.lang.Object r0 = r4.fromJson((java.lang.String) r1, (java.lang.reflect.Type) r0)
            com.upuphone.runasone.ble.SessionConfig r0 = (com.upuphone.runasone.ble.SessionConfig) r0
            android.os.IBinder r6 = r6.getBinder(r3)
            com.upuphone.hub.Hub r6 = com.upuphone.hub.Hub.Stub.asInterface(r6)
            if (r6 == 0) goto L_0x00e6
            com.upuphone.runasone.ble.InitSessionCallbackProxy r2 = new com.upuphone.runasone.ble.InitSessionCallbackProxy
            r2.<init>(r6)
        L_0x00e6:
            com.upuphone.runasone.ble.Api r5 = r5.adaptee
            r5.initSession(r7, r0, r2)
            goto L_0x01ac
        L_0x00ed:
            java.lang.String r1 = "write"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x011d
            java.lang.String r7 = r6.getString(r4)
            java.lang.String r0 = "writeUUID"
            java.lang.String r0 = r6.getString(r0)
            java.lang.String r1 = "data"
            byte[] r1 = r6.getByteArray(r1)
            android.os.IBinder r6 = r6.getBinder(r3)
            com.upuphone.hub.Hub r6 = com.upuphone.hub.Hub.Stub.asInterface(r6)
            if (r6 == 0) goto L_0x0116
            com.upuphone.runasone.ble.WriteCallbackProxy r2 = new com.upuphone.runasone.ble.WriteCallbackProxy
            r2.<init>(r6)
        L_0x0116:
            com.upuphone.runasone.ble.Api r5 = r5.adaptee
            r5.write(r7, r0, r1, r2)
            goto L_0x01ac
        L_0x011d:
            java.lang.String r1 = "read"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0144
            java.lang.String r7 = r6.getString(r4)
            java.lang.String r0 = "readUUID"
            java.lang.String r0 = r6.getString(r0)
            android.os.IBinder r6 = r6.getBinder(r3)
            com.upuphone.hub.Hub r6 = com.upuphone.hub.Hub.Stub.asInterface(r6)
            if (r6 == 0) goto L_0x013e
            com.upuphone.runasone.ble.ReadCallbackProxy r2 = new com.upuphone.runasone.ble.ReadCallbackProxy
            r2.<init>(r6)
        L_0x013e:
            com.upuphone.runasone.ble.Api r5 = r5.adaptee
            r5.read(r7, r0, r2)
            goto L_0x01ac
        L_0x0144:
            java.lang.String r1 = "openNotify"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x016b
            java.lang.String r7 = r6.getString(r4)
            java.lang.String r0 = "notifyUUID"
            java.lang.String r0 = r6.getString(r0)
            android.os.IBinder r6 = r6.getBinder(r3)
            com.upuphone.hub.Hub r6 = com.upuphone.hub.Hub.Stub.asInterface(r6)
            if (r6 == 0) goto L_0x0165
            com.upuphone.runasone.ble.OpenNotifyCallbackProxy r2 = new com.upuphone.runasone.ble.OpenNotifyCallbackProxy
            r2.<init>(r6)
        L_0x0165:
            com.upuphone.runasone.ble.Api r5 = r5.adaptee
            r5.openNotify(r7, r0, r2)
            goto L_0x01ac
        L_0x016b:
            java.lang.String r1 = "setMtu"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0192
            java.lang.String r7 = r6.getString(r4)
            java.lang.String r0 = "mtuSize"
            int r0 = r6.getInt(r0)
            android.os.IBinder r6 = r6.getBinder(r3)
            com.upuphone.hub.Hub r6 = com.upuphone.hub.Hub.Stub.asInterface(r6)
            if (r6 == 0) goto L_0x018c
            com.upuphone.runasone.ble.MtuCallbackProxy r2 = new com.upuphone.runasone.ble.MtuCallbackProxy
            r2.<init>(r6)
        L_0x018c:
            com.upuphone.runasone.ble.Api r5 = r5.adaptee
            r5.setMtu(r7, r0, r2)
            goto L_0x01ac
        L_0x0192:
            java.lang.String r1 = "getFoundDeviceList"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x01ad
            java.lang.String r0 = "vid"
            java.lang.String r6 = r6.getString(r0)
            com.upuphone.runasone.ble.Api r5 = r5.adaptee
            java.util.ArrayList r5 = r5.getFoundDeviceList(r6)
            java.lang.String r6 = "result"
            r7.putParcelableArrayList(r6, r5)
        L_0x01ac:
            return
        L_0x01ad:
            java.lang.UnsupportedOperationException r5 = new java.lang.UnsupportedOperationException
            java.lang.String r6 = "target method not found"
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.runasone.ble.ApiAdapter.adapt(android.os.Bundle, android.os.Bundle):void");
    }
}
