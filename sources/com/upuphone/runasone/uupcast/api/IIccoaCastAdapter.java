package com.upuphone.runasone.uupcast.api;

import com.google.gson.Gson;

public final class IIccoaCastAdapter {
    private final IIccoaCast adaptee;
    private final Gson gson = new Gson();

    public IIccoaCastAdapter(IIccoaCast iIccoaCast) {
        this.adaptee = iIccoaCast;
    }

    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r3v2, types: [com.upuphone.runasone.uupcast.api.IHandleReceiverCarMessageListener] */
    /* JADX WARNING: type inference failed for: r3v4, types: [com.upuphone.runasone.uupcast.api.IccoaConnectListener] */
    /* JADX WARNING: type inference failed for: r3v6 */
    /* JADX WARNING: type inference failed for: r3v7 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void adapt(android.os.Bundle r5, android.os.Bundle r6) {
        /*
            r4 = this;
            java.lang.String r0 = "method"
            java.lang.String r0 = r5.getString(r0)
            java.lang.String r1 = "initSession"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x002c
            com.upuphone.runasone.uupcast.api.IIccoaCastAdapter$1 r6 = new com.upuphone.runasone.uupcast.api.IIccoaCastAdapter$1
            r6.<init>()
            java.lang.reflect.Type r6 = r6.getType()
            java.lang.String r0 = "config"
            java.lang.String r5 = r5.getString(r0)
            com.google.gson.Gson r0 = r4.gson
            java.lang.Object r5 = r0.fromJson((java.lang.String) r5, (java.lang.reflect.Type) r6)
            com.upuphone.runasone.uupcast.SinkDisplayConfig r5 = (com.upuphone.runasone.uupcast.SinkDisplayConfig) r5
            com.upuphone.runasone.uupcast.api.IIccoaCast r4 = r4.adaptee
            r4.initSession(r5)
            goto L_0x0180
        L_0x002c:
            java.lang.String r1 = "buildVirtualAfterBleConnected"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x003b
            com.upuphone.runasone.uupcast.api.IIccoaCast r4 = r4.adaptee
            r4.buildVirtualAfterBleConnected()
            goto L_0x0180
        L_0x003b:
            java.lang.String r1 = "sendCarMessage"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0053
            java.lang.String r6 = "uCarMessage"
            android.os.Parcelable r5 = r5.getParcelable(r6)
            com.upuphone.starryiccoaproto.UCarMessage r5 = (com.upuphone.starryiccoaproto.UCarMessage) r5
            com.upuphone.runasone.uupcast.api.IIccoaCast r4 = r4.adaptee
            r4.sendCarMessage(r5)
            goto L_0x0180
        L_0x0053:
            java.lang.String r1 = "startCast"
            boolean r1 = r1.equals(r0)
            java.lang.String r2 = "data"
            if (r1 == 0) goto L_0x0070
            java.lang.String r6 = "mode"
            int r6 = r5.getInt(r6)
            android.os.Parcelable r5 = r5.getParcelable(r2)
            android.os.Bundle r5 = (android.os.Bundle) r5
            com.upuphone.runasone.uupcast.api.IIccoaCast r4 = r4.adaptee
            r4.startCast(r6, r5)
            goto L_0x0180
        L_0x0070:
            java.lang.String r1 = "stopPlay"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x007f
            com.upuphone.runasone.uupcast.api.IIccoaCast r4 = r4.adaptee
            r4.stopPlay()
            goto L_0x0180
        L_0x007f:
            java.lang.String r1 = "destroyVirtualDisplayWhenConnectFail"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x008e
            com.upuphone.runasone.uupcast.api.IIccoaCast r4 = r4.adaptee
            r4.destroyVirtualDisplayWhenConnectFail()
            goto L_0x0180
        L_0x008e:
            java.lang.String r1 = "setIccoaConnectListener"
            boolean r1 = r1.equals(r0)
            r3 = 0
            if (r1 == 0) goto L_0x00af
            java.lang.String r6 = "iccoaConnectListener"
            android.os.IBinder r5 = r5.getBinder(r6)
            com.upuphone.hub.Hub r5 = com.upuphone.hub.Hub.Stub.asInterface(r5)
            if (r5 == 0) goto L_0x00a8
            com.upuphone.runasone.uupcast.api.IccoaConnectListenerProxy r3 = new com.upuphone.runasone.uupcast.api.IccoaConnectListenerProxy
            r3.<init>(r5)
        L_0x00a8:
            com.upuphone.runasone.uupcast.api.IIccoaCast r4 = r4.adaptee
            r4.setIccoaConnectListener(r3)
            goto L_0x0180
        L_0x00af:
            java.lang.String r1 = "setIHandleReceiverCarMessageListener"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x00cf
            java.lang.String r6 = "listener"
            android.os.IBinder r5 = r5.getBinder(r6)
            com.upuphone.hub.Hub r5 = com.upuphone.hub.Hub.Stub.asInterface(r5)
            if (r5 == 0) goto L_0x00c8
            com.upuphone.runasone.uupcast.api.IHandleReceiverCarMessageListenerProxy r3 = new com.upuphone.runasone.uupcast.api.IHandleReceiverCarMessageListenerProxy
            r3.<init>(r5)
        L_0x00c8:
            com.upuphone.runasone.uupcast.api.IIccoaCast r4 = r4.adaptee
            r4.setIHandleReceiverCarMessageListener(r3)
            goto L_0x0180
        L_0x00cf:
            java.lang.String r1 = "reAuth"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x00e4
            java.lang.String r6 = "confirm"
            boolean r5 = r5.getBoolean(r6)
            com.upuphone.runasone.uupcast.api.IIccoaCast r4 = r4.adaptee
            r4.reAuth(r5)
            goto L_0x0180
        L_0x00e4:
            java.lang.String r1 = "setUibcDisplayId"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x00f9
            java.lang.String r6 = "displayId"
            int r5 = r5.getInt(r6)
            com.upuphone.runasone.uupcast.api.IIccoaCast r4 = r4.adaptee
            r4.setUibcDisplayId(r5)
            goto L_0x0180
        L_0x00f9:
            java.lang.String r1 = "isCarInCache"
            boolean r1 = r1.equals(r0)
            java.lang.String r3 = "id"
            if (r1 == 0) goto L_0x0113
            byte[] r5 = r5.getByteArray(r3)
            com.upuphone.runasone.uupcast.api.IIccoaCast r4 = r4.adaptee
            boolean r4 = r4.isCarInCache(r5)
            java.lang.String r5 = "result"
            r6.putBoolean(r5, r4)
            goto L_0x0180
        L_0x0113:
            java.lang.String r6 = "removeCarCache"
            boolean r1 = r6.equals(r0)
            if (r1 == 0) goto L_0x0121
            com.upuphone.runasone.uupcast.api.IIccoaCast r4 = r4.adaptee
            r4.removeCarCache()
            goto L_0x0180
        L_0x0121:
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0131
            byte[] r5 = r5.getByteArray(r3)
            com.upuphone.runasone.uupcast.api.IIccoaCast r4 = r4.adaptee
            r4.removeCarCache(r5)
            goto L_0x0180
        L_0x0131:
            java.lang.String r6 = "updatePincode"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0146
            java.lang.String r6 = "pinCode"
            java.lang.String r5 = r5.getString(r6)
            com.upuphone.runasone.uupcast.api.IIccoaCast r4 = r4.adaptee
            r4.updatePincode(r5)
            goto L_0x0180
        L_0x0146:
            java.lang.String r6 = "sendMessage"
            boolean r6 = r6.equals(r0)
            java.lang.String r1 = "what"
            if (r6 == 0) goto L_0x015b
            int r5 = r5.getInt(r1)
            com.upuphone.runasone.uupcast.api.IIccoaCast r4 = r4.adaptee
            r4.sendMessage(r5)
            goto L_0x0180
        L_0x015b:
            java.lang.String r6 = "sendCastMessage"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0173
            int r6 = r5.getInt(r1)
            android.os.Parcelable r5 = r5.getParcelable(r2)
            android.os.Bundle r5 = (android.os.Bundle) r5
            com.upuphone.runasone.uupcast.api.IIccoaCast r4 = r4.adaptee
            r4.sendCastMessage(r6, r5)
            goto L_0x0180
        L_0x0173:
            java.lang.String r5 = "initPhoneState"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0181
            com.upuphone.runasone.uupcast.api.IIccoaCast r4 = r4.adaptee
            r4.initPhoneState()
        L_0x0180:
            return
        L_0x0181:
            java.lang.UnsupportedOperationException r4 = new java.lang.UnsupportedOperationException
            java.lang.String r5 = "target method not found"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.runasone.uupcast.api.IIccoaCastAdapter.adapt(android.os.Bundle, android.os.Bundle):void");
    }
}
