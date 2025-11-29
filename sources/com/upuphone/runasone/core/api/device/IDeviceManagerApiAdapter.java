package com.upuphone.runasone.core.api.device;

import com.google.gson.Gson;

public final class IDeviceManagerApiAdapter {
    private final IDeviceManagerApi adaptee;
    private final Gson gson = new Gson();

    public IDeviceManagerApiAdapter(IDeviceManagerApi iDeviceManagerApi) {
        this.adaptee = iDeviceManagerApi;
    }

    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v1, types: [com.upuphone.runasone.core.api.device.IDeviceConnectCallback] */
    /* JADX WARNING: type inference failed for: r2v4, types: [com.upuphone.runasone.core.api.discovery.IDiscoveryCallback] */
    /* JADX WARNING: type inference failed for: r2v6 */
    /* JADX WARNING: type inference failed for: r2v7 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void adapt(android.os.Bundle r10, android.os.Bundle r11) {
        /*
            r9 = this;
            java.lang.String r0 = "method"
            java.lang.String r0 = r10.getString(r0)
            java.lang.String r1 = "startDiscovery"
            boolean r1 = r1.equals(r0)
            r2 = 0
            java.lang.String r3 = "callback"
            java.lang.String r4 = "filter"
            if (r1 == 0) goto L_0x0055
            com.upuphone.runasone.core.api.device.IDeviceManagerApiAdapter$1 r11 = new com.upuphone.runasone.core.api.device.IDeviceManagerApiAdapter$1
            r11.<init>()
            java.lang.reflect.Type r11 = r11.getType()
            java.lang.String r0 = r10.getString(r4)
            com.google.gson.Gson r1 = r9.gson
            java.lang.Object r11 = r1.fromJson((java.lang.String) r0, (java.lang.reflect.Type) r11)
            com.upuphone.starrynet.api.bean.DiscoveryFilter r11 = (com.upuphone.starrynet.api.bean.DiscoveryFilter) r11
            com.upuphone.runasone.core.api.device.IDeviceManagerApiAdapter$2 r0 = new com.upuphone.runasone.core.api.device.IDeviceManagerApiAdapter$2
            r0.<init>()
            java.lang.reflect.Type r0 = r0.getType()
            java.lang.String r1 = "settings"
            java.lang.String r1 = r10.getString(r1)
            com.google.gson.Gson r4 = r9.gson
            java.lang.Object r0 = r4.fromJson((java.lang.String) r1, (java.lang.reflect.Type) r0)
            com.upuphone.starrynet.api.bean.DiscoverySettings r0 = (com.upuphone.starrynet.api.bean.DiscoverySettings) r0
            android.os.IBinder r10 = r10.getBinder(r3)
            com.upuphone.hub.Hub r10 = com.upuphone.hub.Hub.Stub.asInterface(r10)
            if (r10 == 0) goto L_0x004e
            com.upuphone.runasone.core.api.discovery.IDiscoveryCallbackProxy r2 = new com.upuphone.runasone.core.api.discovery.IDiscoveryCallbackProxy
            r2.<init>(r10)
        L_0x004e:
            com.upuphone.runasone.core.api.device.IDeviceManagerApi r9 = r9.adaptee
            r9.startDiscovery(r11, r0, r2)
            goto L_0x03ea
        L_0x0055:
            java.lang.String r1 = "stopDiscovery"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0064
            com.upuphone.runasone.core.api.device.IDeviceManagerApi r9 = r9.adaptee
            r9.stopDiscovery()
            goto L_0x03ea
        L_0x0064:
            java.lang.String r1 = "removeBond"
            boolean r1 = r1.equals(r0)
            java.lang.String r5 = "deviceId"
            if (r1 == 0) goto L_0x0079
            java.lang.String r10 = r10.getString(r5)
            com.upuphone.runasone.core.api.device.IDeviceManagerApi r9 = r9.adaptee
            r9.removeBond(r10)
            goto L_0x03ea
        L_0x0079:
            java.lang.String r1 = "createBond"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x008c
            java.lang.String r10 = r10.getString(r5)
            com.upuphone.runasone.core.api.device.IDeviceManagerApi r9 = r9.adaptee
            r9.createBond(r10)
            goto L_0x03ea
        L_0x008c:
            java.lang.String r1 = "requestAuth"
            boolean r1 = r1.equals(r0)
            java.lang.String r6 = "data"
            if (r1 == 0) goto L_0x00a5
            java.lang.String r11 = r10.getString(r5)
            byte[] r10 = r10.getByteArray(r6)
            com.upuphone.runasone.core.api.device.IDeviceManagerApi r9 = r9.adaptee
            r9.requestAuth(r11, r10)
            goto L_0x03ea
        L_0x00a5:
            java.lang.String r1 = "enableFastConnect"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x00b4
            com.upuphone.runasone.core.api.device.IDeviceManagerApi r9 = r9.adaptee
            r9.enableFastConnect()
            goto L_0x03ea
        L_0x00b4:
            java.lang.String r1 = "disableFastConnect"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x00c3
            com.upuphone.runasone.core.api.device.IDeviceManagerApi r9 = r9.adaptee
            r9.disableFastConnect()
            goto L_0x03ea
        L_0x00c3:
            java.lang.String r1 = "setDiscoveryFilter"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x00e7
            com.upuphone.runasone.core.api.device.IDeviceManagerApiAdapter$3 r11 = new com.upuphone.runasone.core.api.device.IDeviceManagerApiAdapter$3
            r11.<init>()
            java.lang.reflect.Type r11 = r11.getType()
            java.lang.String r10 = r10.getString(r4)
            com.google.gson.Gson r0 = r9.gson
            java.lang.Object r10 = r0.fromJson((java.lang.String) r10, (java.lang.reflect.Type) r11)
            com.upuphone.starrynet.api.bean.DiscoveryFilter r10 = (com.upuphone.starrynet.api.bean.DiscoveryFilter) r10
            com.upuphone.runasone.core.api.device.IDeviceManagerApi r9 = r9.adaptee
            r9.setDiscoveryFilter(r10)
            goto L_0x03ea
        L_0x00e7:
            java.lang.String r1 = "requestConnect"
            boolean r1 = r1.equals(r0)
            java.lang.String r4 = "params"
            java.lang.String r7 = "result"
            if (r1 == 0) goto L_0x0102
            byte[] r10 = r10.getByteArray(r4)
            com.upuphone.runasone.core.api.device.IDeviceManagerApi r9 = r9.adaptee
            int r9 = r9.requestConnect(r10)
            r11.putInt(r7, r9)
            goto L_0x03ea
        L_0x0102:
            java.lang.String r1 = "requestConnectWithTime"
            boolean r1 = r1.equals(r0)
            java.lang.String r8 = "timeoutMillis"
            if (r1 == 0) goto L_0x011f
            byte[] r0 = r10.getByteArray(r4)
            long r1 = r10.getLong(r8)
            com.upuphone.runasone.core.api.device.IDeviceManagerApi r9 = r9.adaptee
            int r9 = r9.requestConnectWithTime(r0, r1)
            r11.putInt(r7, r9)
            goto L_0x03ea
        L_0x011f:
            java.lang.String r1 = "updateAdvParams"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0137
            byte[] r10 = r10.getByteArray(r6)
            com.upuphone.runasone.core.api.device.IDeviceManagerApi r9 = r9.adaptee
            int r9 = r9.updateAdvParams(r10)
            r11.putInt(r7, r9)
            goto L_0x03ea
        L_0x0137:
            java.lang.String r1 = "startMultiDeviceFound"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x014a
            com.upuphone.runasone.core.api.device.IDeviceManagerApi r9 = r9.adaptee
            int r9 = r9.startMultiDeviceFound()
            r11.putInt(r7, r9)
            goto L_0x03ea
        L_0x014a:
            java.lang.String r1 = "stopMultiDeviceFound"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0163
            java.lang.String r0 = "reAdv"
            boolean r10 = r10.getBoolean(r0)
            com.upuphone.runasone.core.api.device.IDeviceManagerApi r9 = r9.adaptee
            int r9 = r9.stopMultiDeviceFound(r10)
            r11.putInt(r7, r9)
            goto L_0x03ea
        L_0x0163:
            java.lang.String r1 = "cancelAuth"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x017a
            java.lang.String r10 = r10.getString(r5)
            com.upuphone.runasone.core.api.device.IDeviceManagerApi r9 = r9.adaptee
            int r9 = r9.cancelAuth(r10)
            r11.putInt(r7, r9)
            goto L_0x03ea
        L_0x017a:
            java.lang.String r1 = "enableFastConnectWithTimeOut"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0191
            long r0 = r10.getLong(r8)
            com.upuphone.runasone.core.api.device.IDeviceManagerApi r9 = r9.adaptee
            int r9 = r9.enableFastConnectWithTimeOut(r0)
            r11.putInt(r7, r9)
            goto L_0x03ea
        L_0x0191:
            java.lang.String r1 = "setFastConnectProcess"
            boolean r1 = r1.equals(r0)
            java.lang.String r4 = "type"
            if (r1 == 0) goto L_0x01ab
            int r10 = r10.getInt(r4)
            com.upuphone.runasone.core.api.device.IDeviceManagerApi r9 = r9.adaptee
            int r9 = r9.setFastConnectProcess(r10)
            r11.putInt(r7, r9)
            goto L_0x03ea
        L_0x01ab:
            java.lang.String r1 = "setAdvertiseEnableMode"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x01c4
            java.lang.String r0 = "mode"
            int r10 = r10.getInt(r0)
            com.upuphone.runasone.core.api.device.IDeviceManagerApi r9 = r9.adaptee
            int r9 = r9.setAdvertiseEnableMode(r10)
            r11.putInt(r7, r9)
            goto L_0x03ea
        L_0x01c4:
            java.lang.String r1 = "setReconnectEnable"
            boolean r1 = r1.equals(r0)
            java.lang.String r6 = "enable"
            if (r1 == 0) goto L_0x01dd
            boolean r10 = r10.getBoolean(r6)
            com.upuphone.runasone.core.api.device.IDeviceManagerApi r9 = r9.adaptee
            int r9 = r9.setReconnectEnable(r10)
            r11.putInt(r7, r9)
            goto L_0x03ea
        L_0x01dd:
            java.lang.String r1 = "connect"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x01f8
            java.lang.String r0 = r10.getString(r5)
            int r10 = r10.getInt(r4)
            com.upuphone.runasone.core.api.device.IDeviceManagerApi r9 = r9.adaptee
            int r9 = r9.connect(r0, r10)
            r11.putInt(r7, r9)
            goto L_0x03ea
        L_0x01f8:
            java.lang.String r1 = "disconnect"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0213
            java.lang.String r0 = r10.getString(r5)
            int r10 = r10.getInt(r4)
            com.upuphone.runasone.core.api.device.IDeviceManagerApi r9 = r9.adaptee
            int r9 = r9.disconnect(r0, r10)
            r11.putInt(r7, r9)
            goto L_0x03ea
        L_0x0213:
            java.lang.String r1 = "disconnectAll"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x022a
            java.lang.String r10 = r10.getString(r5)
            com.upuphone.runasone.core.api.device.IDeviceManagerApi r9 = r9.adaptee
            int r9 = r9.disconnectAll(r10)
            r11.putInt(r7, r9)
            goto L_0x03ea
        L_0x022a:
            java.lang.String r1 = "getBondedDevice"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0243
            com.upuphone.runasone.core.api.device.IDeviceManagerApi r10 = r9.adaptee
            java.util.List r10 = r10.getBondedDevice()
            com.google.gson.Gson r9 = r9.gson
            java.lang.String r9 = r9.toJson((java.lang.Object) r10)
            r11.putString(r7, r9)
            goto L_0x03ea
        L_0x0243:
            java.lang.String r1 = "getConnectedDevice"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x025c
            com.upuphone.runasone.core.api.device.IDeviceManagerApi r10 = r9.adaptee
            java.util.List r10 = r10.getConnectedDevice()
            com.google.gson.Gson r9 = r9.gson
            java.lang.String r9 = r9.toJson((java.lang.Object) r10)
            r11.putString(r7, r9)
            goto L_0x03ea
        L_0x025c:
            java.lang.String r1 = "getVirtualChannelStatus"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0273
            java.lang.String r10 = r10.getString(r5)
            com.upuphone.runasone.core.api.device.IDeviceManagerApi r9 = r9.adaptee
            int r9 = r9.getVirtualChannelStatus(r10)
            r11.putInt(r7, r9)
            goto L_0x03ea
        L_0x0273:
            java.lang.String r1 = "getSelfDevice"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x028c
            com.upuphone.runasone.core.api.device.IDeviceManagerApi r10 = r9.adaptee
            com.upuphone.runasone.device.StarryDevice r10 = r10.getSelfDevice()
            com.google.gson.Gson r9 = r9.gson
            java.lang.String r9 = r9.toJson((java.lang.Object) r10)
            r11.putString(r7, r9)
            goto L_0x03ea
        L_0x028c:
            java.lang.String r1 = "isBRConnect"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x02a3
            java.lang.String r10 = r10.getString(r5)
            com.upuphone.runasone.core.api.device.IDeviceManagerApi r9 = r9.adaptee
            boolean r9 = r9.isBRConnect(r10)
            r11.putBoolean(r7, r9)
            goto L_0x03ea
        L_0x02a3:
            java.lang.String r1 = "getPreDeviceState"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x02ba
            java.lang.String r10 = r10.getString(r5)
            com.upuphone.runasone.core.api.device.IDeviceManagerApi r9 = r9.adaptee
            int r9 = r9.getPreDeviceState(r10)
            r11.putInt(r7, r9)
            goto L_0x03ea
        L_0x02ba:
            java.lang.String r1 = "getCurDeviceState"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x02d1
            java.lang.String r10 = r10.getString(r5)
            com.upuphone.runasone.core.api.device.IDeviceManagerApi r9 = r9.adaptee
            int r9 = r9.getCurDeviceState(r10)
            r11.putInt(r7, r9)
            goto L_0x03ea
        L_0x02d1:
            java.lang.String r1 = "getDeviceConnectable"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x02e8
            java.lang.String r10 = r10.getString(r5)
            com.upuphone.runasone.core.api.device.IDeviceManagerApi r9 = r9.adaptee
            int r9 = r9.getDeviceConnectable(r10)
            r11.putInt(r7, r9)
            goto L_0x03ea
        L_0x02e8:
            java.lang.String r1 = "setDeviceConnectable"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x030b
            boolean r0 = r10.getBoolean(r6)
            java.lang.String r1 = "terminalType"
            int r1 = r10.getInt(r1)
            java.lang.String r2 = "modelID"
            java.lang.String r10 = r10.getString(r2)
            com.upuphone.runasone.core.api.device.IDeviceManagerApi r9 = r9.adaptee
            int r9 = r9.setDeviceConnectable(r0, r1, r10)
            r11.putInt(r7, r9)
            goto L_0x03ea
        L_0x030b:
            java.lang.String r1 = "balanceConnect"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0322
            java.lang.String r10 = r10.getString(r5)
            com.upuphone.runasone.core.api.device.IDeviceManagerApi r9 = r9.adaptee
            int r9 = r9.balanceConnect(r10)
            r11.putInt(r7, r9)
            goto L_0x03ea
        L_0x0322:
            java.lang.String r1 = "disBalanceConnect"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0339
            java.lang.String r10 = r10.getString(r5)
            com.upuphone.runasone.core.api.device.IDeviceManagerApi r9 = r9.adaptee
            int r9 = r9.disBalanceConnect(r10)
            r11.putInt(r7, r9)
            goto L_0x03ea
        L_0x0339:
            java.lang.String r1 = "isBalanceConnect"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0350
            java.lang.String r10 = r10.getString(r5)
            com.upuphone.runasone.core.api.device.IDeviceManagerApi r9 = r9.adaptee
            boolean r9 = r9.isBalanceConnect(r10)
            r11.putBoolean(r7, r9)
            goto L_0x03ea
        L_0x0350:
            java.lang.String r1 = "getWifiInfo"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0363
            com.upuphone.runasone.core.api.device.IDeviceManagerApi r9 = r9.adaptee
            java.lang.String[] r9 = r9.getWifiInfo()
            r11.putStringArray(r7, r9)
            goto L_0x03ea
        L_0x0363:
            java.lang.String r1 = "registerDeviceStatusListener"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0384
            java.lang.String r11 = r10.getString(r5)
            android.os.IBinder r10 = r10.getBinder(r3)
            com.upuphone.hub.Hub r10 = com.upuphone.hub.Hub.Stub.asInterface(r10)
            if (r10 == 0) goto L_0x037e
            com.upuphone.runasone.core.api.device.IDeviceConnectCallbackProxy r2 = new com.upuphone.runasone.core.api.device.IDeviceConnectCallbackProxy
            r2.<init>(r10)
        L_0x037e:
            com.upuphone.runasone.core.api.device.IDeviceManagerApi r9 = r9.adaptee
            r9.registerDeviceStatusListener(r11, r2)
            goto L_0x03ea
        L_0x0384:
            java.lang.String r1 = "unRegisterDeviceStatusListener"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0397
            java.lang.String r10 = r10.getString(r5)
            com.upuphone.runasone.core.api.device.IDeviceManagerApi r9 = r9.adaptee
            r9.unRegisterDeviceStatusListener(r10)
            goto L_0x03ea
        L_0x0397:
            java.lang.String r1 = "getDeviceDetailInfo"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x03b1
            java.lang.String r0 = r10.getString(r5)
            int r10 = r10.getInt(r4)
            com.upuphone.runasone.core.api.device.IDeviceManagerApi r9 = r9.adaptee
            java.lang.String r9 = r9.getDeviceDetailInfo(r0, r10)
            r11.putString(r7, r9)
            goto L_0x03ea
        L_0x03b1:
            java.lang.String r1 = "getSupportAbility"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x03cd
            java.lang.String r10 = r10.getString(r5)
            com.upuphone.runasone.core.api.device.IDeviceManagerApi r0 = r9.adaptee
            java.util.List r10 = r0.getSupportAbility(r10)
            com.google.gson.Gson r9 = r9.gson
            java.lang.String r9 = r9.toJson((java.lang.Object) r10)
            r11.putString(r7, r9)
            goto L_0x03ea
        L_0x03cd:
            java.lang.String r1 = "getConnectedDevices"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x03eb
            java.lang.String r0 = "linkType"
            int r10 = r10.getInt(r0)
            com.upuphone.runasone.core.api.device.IDeviceManagerApi r0 = r9.adaptee
            java.util.List r10 = r0.getConnectedDevices(r10)
            com.google.gson.Gson r9 = r9.gson
            java.lang.String r9 = r9.toJson((java.lang.Object) r10)
            r11.putString(r7, r9)
        L_0x03ea:
            return
        L_0x03eb:
            java.lang.UnsupportedOperationException r9 = new java.lang.UnsupportedOperationException
            java.lang.String r10 = "target method not found"
            r9.<init>(r10)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.runasone.core.api.device.IDeviceManagerApiAdapter.adapt(android.os.Bundle, android.os.Bundle):void");
    }
}
