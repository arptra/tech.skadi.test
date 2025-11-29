package com.upuphone.runasone.relay.api;

import com.google.gson.Gson;

public final class ApiRelayBypassMsgAdapter {
    private final ApiRelayBypassMsg adaptee;
    private final Gson gson = new Gson();

    public ApiRelayBypassMsgAdapter(ApiRelayBypassMsg apiRelayBypassMsg) {
        this.adaptee = apiRelayBypassMsg;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: com.upuphone.runasone.relay.api.BypassCallbackProxy} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: com.upuphone.runasone.relay.api.BypassCallbackProxy} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: com.upuphone.runasone.relay.api.BypassCallbackProxy} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v12, resolved type: com.upuphone.runasone.relay.api.BypassCallbackProxy} */
    /* JADX WARNING: type inference failed for: r11v0, types: [com.upuphone.runasone.relay.api.SendRelayMessageCallBack] */
    /* JADX WARNING: type inference failed for: r1v2, types: [com.upuphone.runasone.relay.api.SendRelayMessageCallBackProxy] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void adapt(android.os.Bundle r13, android.os.Bundle r14) {
        /*
            r12 = this;
            java.lang.String r14 = "method"
            java.lang.String r14 = r13.getString(r14)
            java.lang.String r0 = "setRelayListener"
            boolean r0 = r0.equals(r14)
            r1 = 0
            java.lang.String r2 = "callBack"
            java.lang.String r3 = "characterUuid"
            java.lang.String r4 = "serviceUuid"
            if (r0 == 0) goto L_0x0033
            java.lang.String r14 = r13.getString(r4)
            java.lang.String r0 = r13.getString(r3)
            android.os.IBinder r13 = r13.getBinder(r2)
            com.upuphone.hub.Hub r13 = com.upuphone.hub.Hub.Stub.asInterface(r13)
            if (r13 == 0) goto L_0x002c
            com.upuphone.runasone.relay.api.BypassCallbackProxy r1 = new com.upuphone.runasone.relay.api.BypassCallbackProxy
            r1.<init>(r13)
        L_0x002c:
            com.upuphone.runasone.relay.api.ApiRelayBypassMsg r12 = r12.adaptee
            r12.setRelayListener(r14, r0, r1)
            goto L_0x00d8
        L_0x0033:
            java.lang.String r0 = "removeRelayListener"
            boolean r0 = r0.equals(r14)
            if (r0 == 0) goto L_0x004a
            java.lang.String r14 = r13.getString(r4)
            java.lang.String r13 = r13.getString(r3)
            com.upuphone.runasone.relay.api.ApiRelayBypassMsg r12 = r12.adaptee
            r12.removeRelayListener(r14, r13)
            goto L_0x00d8
        L_0x004a:
            java.lang.String r0 = "setRelayListenerByCallback"
            boolean r0 = r0.equals(r14)
            java.lang.String r5 = "callBackTag"
            if (r0 == 0) goto L_0x0075
            java.lang.String r14 = r13.getString(r4)
            java.lang.String r0 = r13.getString(r3)
            java.lang.String r3 = r13.getString(r5)
            android.os.IBinder r13 = r13.getBinder(r2)
            com.upuphone.hub.Hub r13 = com.upuphone.hub.Hub.Stub.asInterface(r13)
            if (r13 == 0) goto L_0x006f
            com.upuphone.runasone.relay.api.BypassCallbackProxy r1 = new com.upuphone.runasone.relay.api.BypassCallbackProxy
            r1.<init>(r13)
        L_0x006f:
            com.upuphone.runasone.relay.api.ApiRelayBypassMsg r12 = r12.adaptee
            r12.setRelayListenerByCallback(r14, r0, r3, r1)
            goto L_0x00d8
        L_0x0075:
            java.lang.String r0 = "removeRelayListenerByCallback"
            boolean r0 = r0.equals(r14)
            if (r0 == 0) goto L_0x009e
            java.lang.String r14 = r13.getString(r4)
            java.lang.String r0 = r13.getString(r3)
            java.lang.String r3 = r13.getString(r5)
            android.os.IBinder r13 = r13.getBinder(r2)
            com.upuphone.hub.Hub r13 = com.upuphone.hub.Hub.Stub.asInterface(r13)
            if (r13 == 0) goto L_0x0098
            com.upuphone.runasone.relay.api.BypassCallbackProxy r1 = new com.upuphone.runasone.relay.api.BypassCallbackProxy
            r1.<init>(r13)
        L_0x0098:
            com.upuphone.runasone.relay.api.ApiRelayBypassMsg r12 = r12.adaptee
            r12.removeRelayListenerByCallback(r14, r0, r3, r1)
            goto L_0x00d8
        L_0x009e:
            java.lang.String r0 = "sendMessage"
            boolean r14 = r0.equals(r14)
            if (r14 == 0) goto L_0x00d9
            java.lang.String r14 = "deviceId"
            java.lang.String r6 = r13.getString(r14)
            java.lang.String r7 = r13.getString(r4)
            java.lang.String r8 = r13.getString(r3)
            java.lang.String r14 = "msgType"
            int r9 = r13.getInt(r14)
            java.lang.String r14 = "msg"
            android.os.Parcelable r14 = r13.getParcelable(r14)
            r10 = r14
            com.upuphone.runasone.ArrayData r10 = (com.upuphone.runasone.ArrayData) r10
            android.os.IBinder r13 = r13.getBinder(r2)
            com.upuphone.hub.Hub r13 = com.upuphone.hub.Hub.Stub.asInterface(r13)
            if (r13 == 0) goto L_0x00d2
            com.upuphone.runasone.relay.api.SendRelayMessageCallBackProxy r1 = new com.upuphone.runasone.relay.api.SendRelayMessageCallBackProxy
            r1.<init>(r13)
        L_0x00d2:
            r11 = r1
            com.upuphone.runasone.relay.api.ApiRelayBypassMsg r5 = r12.adaptee
            r5.sendMessage(r6, r7, r8, r9, r10, r11)
        L_0x00d8:
            return
        L_0x00d9:
            java.lang.UnsupportedOperationException r12 = new java.lang.UnsupportedOperationException
            java.lang.String r13 = "target method not found"
            r12.<init>(r13)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.runasone.relay.api.ApiRelayBypassMsgAdapter.adapt(android.os.Bundle, android.os.Bundle):void");
    }
}
