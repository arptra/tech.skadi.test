package com.upuphone.runasone.device;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.meizu.common.widget.MzContactsContract;
import com.upuphone.runasone.ability.AbilityRouterImpl;
import com.upuphone.runasone.channel.ChannelManagerImpl;
import com.upuphone.runasone.channel.IChannel;
import com.upuphone.runasone.channel.linker.bt.BtServer;
import com.upuphone.runasone.channel.linker.starrystack.XdpNetStackManager;
import com.upuphone.runasone.constant.Constants;
import com.upuphone.runasone.core.api.device.IDeviceConnectCallback;
import com.upuphone.runasone.host.core.api.EnumLinkStrategy;
import com.upuphone.runasone.service.StarrynetApiImpl;
import com.upuphone.runasone.utils.LogUtil;
import com.upuphone.runasone.utils.Utils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DeviceListenerImpl implements IDeviceListenerInner {
    private Map<String, StarryDevice> connectDevice;
    private DeviceManagerImpl deviceManager;
    private Handler handler;
    private Map<String, Map<String, IDeviceConnectCallback>> registerConnectListener = new ConcurrentHashMap();

    public DeviceListenerImpl(DeviceManagerImpl deviceManagerImpl) {
        this.deviceManager = deviceManagerImpl;
        this.connectDevice = deviceManagerImpl.getConnectionManager().getConnectDevice();
        this.handler = new Handler(Looper.getMainLooper()) {
            public void handleMessage(@NonNull Message message) {
                super.handleMessage(message);
                Object obj = message.obj;
                if (obj != null) {
                    DeviceListenerImpl.this.sendConnectedChangedBR((String) obj);
                }
            }
        };
    }

    private void brConnectedChanged(String str) {
        if (TextUtils.isEmpty(str)) {
            LogUtil.e("brConnectedChanged deviceId = null");
            return;
        }
        StarryDevice starryDevice = this.connectDevice.get(str);
        if (starryDevice == null) {
            LogUtil.e("peerDevice = null");
            return;
        }
        StarryDevice clone = starryDevice.clone();
        synchronized (this.registerConnectListener) {
            try {
                for (Map.Entry next : this.registerConnectListener.entrySet()) {
                    boolean checkStatus = clone.checkStatus(2048);
                    if (clone.getStarryDevice().getDeviceType() != 3) {
                        clone.setStatus(starryDevice.getVirtualChannelStatus());
                    }
                    IDeviceConnectCallback iDeviceConnectCallback = (IDeviceConnectCallback) ((Map) next.getValue()).get(clone.getId());
                    if (iDeviceConnectCallback != null) {
                        iDeviceConnectCallback.onBrConnectedChanged(clone, checkStatus);
                    }
                    IDeviceConnectCallback iDeviceConnectCallback2 = (IDeviceConnectCallback) ((Map) next.getValue()).get((Object) null);
                    if (iDeviceConnectCallback2 != null) {
                        iDeviceConnectCallback2.onBrConnectedChanged(clone, checkStatus);
                    }
                }
            } finally {
            }
        }
    }

    private boolean checkConnectState(String str, int i) {
        StarryDevice starryDevice;
        if (str == null || (starryDevice = this.connectDevice.get(str)) == null) {
            return false;
        }
        return starryDevice.checkStatus(i);
    }

    private void connectByBalanceStrategy(String str, boolean z) {
        connectByStrategy(str, EnumLinkStrategy.STRATEGY_BALANCE, z);
    }

    private void connectByDefaultStrategy(String str, boolean z) {
        connectByStrategy(str, EnumLinkStrategy.STRATEGY_DEFAULT, z);
    }

    private void connectByHighStrategy(String str, boolean z) {
        connectByStrategy(str, EnumLinkStrategy.STRATEGY_HIGH_PERFORMANCE, z);
    }

    private void connectBySimplifiedStrategy(String str) {
        connectByStrategy(str, EnumLinkStrategy.STRATEGY_SIMPLIFIED, true);
    }

    private void connectByStrategy(String str, EnumLinkStrategy enumLinkStrategy, boolean z) {
        LogUtil.i("connectStrategy: " + str + " strategy:" + enumLinkStrategy + " bServer:" + z);
        StarryDevice findConnectDevice = this.deviceManager.findConnectDevice(str);
        if (findConnectDevice != null) {
            linkerConnect(findConnectDevice, enumLinkStrategy, z);
        }
    }

    private void connectedChanged(String str) {
        if (TextUtils.isEmpty(str)) {
            LogUtil.e("connectedChanged deviceId = null");
            return;
        }
        StarryDevice starryDevice = this.connectDevice.get(str);
        if (starryDevice == null) {
            LogUtil.e("peerDevice = null");
            return;
        }
        LogUtil.d("connectedChanged connect-status: " + Integer.toBinaryString(starryDevice.getStatus()));
        StarryDevice clone = starryDevice.clone();
        synchronized (this.registerConnectListener) {
            try {
                for (Map.Entry next : this.registerConnectListener.entrySet()) {
                    if (clone.getStarryDevice().getDeviceType() != 3) {
                        clone.setStatus(starryDevice.getVirtualChannelStatus());
                    }
                    IDeviceConnectCallback iDeviceConnectCallback = (IDeviceConnectCallback) ((Map) next.getValue()).get(clone.getId());
                    if (iDeviceConnectCallback != null) {
                        iDeviceConnectCallback.onConnectedChanged(clone, this.deviceManager.getPreDeviceState(str), this.deviceManager.getCurDeviceState(str));
                    }
                    IDeviceConnectCallback iDeviceConnectCallback2 = (IDeviceConnectCallback) ((Map) next.getValue()).get((Object) null);
                    if (iDeviceConnectCallback2 != null) {
                        iDeviceConnectCallback2.onConnectedChanged(clone, this.deviceManager.getPreDeviceState(str), this.deviceManager.getCurDeviceState(str));
                    }
                }
            } finally {
                while (true) {
                }
            }
        }
        if (StarrynetApiImpl.getInstance().getOwnDevice().getTerminalType() == 3) {
            this.handler.removeMessages(str.hashCode());
            Handler handler2 = this.handler;
            handler2.sendMessageDelayed(handler2.obtainMessage(str.hashCode(), str), 1000);
        }
    }

    private void deleteDevice() {
        Iterator<Map.Entry<String, StarryDevice>> it = this.connectDevice.entrySet().iterator();
        while (it.hasNext()) {
            StarryDevice starryDevice = (StarryDevice) it.next().getValue();
            if (starryDevice != null && ChannelManagerImpl.getInstance().isAuthTransition(starryDevice.getId())) {
                LogUtil.e("isAuthTransition true, device : " + starryDevice.getId() + " cant release !!!");
            } else if (starryDevice == null || starryDevice.getStatus() == 0) {
                LogUtil.d("delete device : " + starryDevice);
                it.remove();
                if (starryDevice != null) {
                    ChannelManagerImpl.getInstance().releaseChannel(starryDevice.getId());
                }
            } else if (!starryDevice.checkStatus(256) && !starryDevice.checkStatus(512) && !starryDevice.checkStatus(1024) && !starryDevice.checkStatus(4096)) {
                ChannelManagerImpl.getInstance().releaseChannel(starryDevice.getId());
            }
        }
    }

    private void disconnectByBalanceStrategy(String str) {
        disconnectByStrategy(str, EnumLinkStrategy.STRATEGY_BALANCE);
    }

    private void disconnectByDefaultStrategy(String str) {
        disconnectByStrategy(str, EnumLinkStrategy.STRATEGY_DEFAULT);
    }

    private void disconnectByHighStrategy(String str) {
        disconnectByStrategy(str, EnumLinkStrategy.STRATEGY_HIGH_PERFORMANCE);
    }

    private void linkerConnect(StarryDevice starryDevice, EnumLinkStrategy enumLinkStrategy, boolean z) {
        IChannel findChannelById = ChannelManagerImpl.getInstance().findChannelById(starryDevice.getId());
        if (findChannelById == null) {
            findChannelById = ChannelManagerImpl.getInstance().allocChannel(starryDevice, enumLinkStrategy);
        }
        findChannelById.link(enumLinkStrategy, z);
    }

    /* access modifiers changed from: private */
    public void sendConnectedChangedBR(String str) {
        LogUtil.d("sendConnectedChangedBR : " + str);
        Intent intent = new Intent(Constants.DEVICE_CONNECT_CHANGEDBR);
        intent.putExtra(Constants.DEVICE_ID, str);
        Utils.getContext().sendBroadcast(intent);
    }

    private void sppConnectedChanged(String str) {
        StarryDevice starryDevice = this.connectDevice.get(str);
        if (starryDevice == null) {
            LogUtil.e("peerDevice = null");
            return;
        }
        LogUtil.d("registerConnectListener map : " + this.registerConnectListener.toString());
        LogUtil.d("sppConnectedChanged connect-status: " + Integer.toBinaryString(starryDevice.getStatus()));
        StarryDevice clone = starryDevice.clone();
        synchronized (this.registerConnectListener) {
            try {
                for (Map.Entry next : this.registerConnectListener.entrySet()) {
                    boolean checkStatus = clone.checkStatus(4096);
                    if (clone.getStarryDevice().getDeviceType() != 3) {
                        clone.setStatus(starryDevice.getVirtualChannelStatus());
                    }
                    IDeviceConnectCallback iDeviceConnectCallback = (IDeviceConnectCallback) ((Map) next.getValue()).get(clone.getId());
                    if (iDeviceConnectCallback != null) {
                        iDeviceConnectCallback.onBalanceConnectedChanged(clone, checkStatus);
                    }
                    IDeviceConnectCallback iDeviceConnectCallback2 = (IDeviceConnectCallback) ((Map) next.getValue()).get((Object) null);
                    if (iDeviceConnectCallback2 != null) {
                        iDeviceConnectCallback2.onBalanceConnectedChanged(clone, checkStatus);
                    }
                }
            } finally {
            }
        }
    }

    private synchronized void unbindChannel(String str, IChannel iChannel, EnumLinkStrategy enumLinkStrategy) {
        StarryDevice starryDevice = this.connectDevice.get(str);
        if (starryDevice == null) {
            LogUtil.i("onUnbindChannel : " + str + " is null");
            return;
        }
        starryDevice.recordPreState();
        AbilityRouterImpl.getInstance().unbindChannel(iChannel, enumLinkStrategy);
        if (EnumLinkStrategy.STRATEGY_HIGH_PERFORMANCE == enumLinkStrategy) {
            starryDevice.removeStatus(512);
            starryDevice.removeStatus(1024);
        } else {
            if (EnumLinkStrategy.STRATEGY_DEFAULT != enumLinkStrategy) {
                if (EnumLinkStrategy.STRATEGY_SIMPLIFIED != enumLinkStrategy) {
                    if (EnumLinkStrategy.STRATEGY_BALANCE == enumLinkStrategy) {
                        starryDevice.removeStatus(4096);
                        sppConnectedChanged(str);
                        deleteDevice();
                        return;
                    }
                }
            }
            starryDevice.removeStatus(256);
        }
        connectedChanged(str);
        deleteDevice();
    }

    public synchronized void bindChannel(String str, EnumLinkStrategy enumLinkStrategy) {
        LogUtil.i("onBindChannel : " + str);
        StarryDevice starryDevice = this.connectDevice.get(str);
        if (starryDevice == null) {
            LogUtil.i("onBindChannel : " + str + " is null");
            return;
        }
        IChannel findChannelById = ChannelManagerImpl.getInstance().findChannelById(str);
        if (findChannelById == null) {
            LogUtil.i("onBindChannel : channel <" + str + "> is null");
            return;
        }
        AbilityRouterImpl.getInstance().bindChannel(findChannelById, enumLinkStrategy);
        starryDevice.recordPreState();
        if (EnumLinkStrategy.STRATEGY_HIGH_PERFORMANCE == enumLinkStrategy) {
            if (checkConnectState(str, 2)) {
                starryDevice.addStatus(512);
            } else if (checkConnectState(str, 4)) {
                starryDevice.addStatus(1024);
            }
        } else if ((EnumLinkStrategy.STRATEGY_DEFAULT == enumLinkStrategy || EnumLinkStrategy.STRATEGY_SIMPLIFIED == enumLinkStrategy) && checkConnectState(str, 1)) {
            starryDevice.addStatus(256);
        } else if (EnumLinkStrategy.STRATEGY_BALANCE == enumLinkStrategy) {
            starryDevice.addStatus(4096);
            sppConnectedChanged(str);
            return;
        }
        connectedChanged(str);
    }

    public void disconnectByStrategy(String str, EnumLinkStrategy enumLinkStrategy) {
        LogUtil.i("disconnectByStrategy <" + str + "> strategy:" + enumLinkStrategy);
        IChannel findChannelById = ChannelManagerImpl.getInstance().findChannelById(str);
        if (findChannelById == null) {
            LogUtil.i("disconnectByStrategy channel <" + str + "> is null!");
            return;
        }
        if (findChannelById.isLinkUp(enumLinkStrategy)) {
            findChannelById.unlink(enumLinkStrategy);
            unbindChannel(str, findChannelById, enumLinkStrategy);
        } else {
            LogUtil.e("channel <" + str + "> strategy:" + enumLinkStrategy + " is already unlink，do nothing");
        }
        if (enumLinkStrategy == EnumLinkStrategy.STRATEGY_DEFAULT) {
            BtServer.getBtServer().removeAuthTransition(str);
        }
        if (enumLinkStrategy == EnumLinkStrategy.STRATEGY_BALANCE) {
            BtServer.getSppServer().removeAuthTransition(str);
        }
        if (!findChannelById.isLinkUp()) {
            LogUtil.e("channel <" + str + "> is un-valid, so need release ");
        }
    }

    public boolean isLanConnected(String str) {
        StarryDevice findConnectDevice = this.deviceManager.findConnectDevice(str);
        return findConnectDevice != null && findConnectDevice.isConnectByMdns() && findConnectDevice.checkStatus(2);
    }

    public void onApConnectedChanged(String str, boolean z) {
        StarryDevice findConnectDevice = this.deviceManager.findConnectDevice(str);
        if (findConnectDevice == null) {
            disconnectByHighStrategy(str);
            return;
        }
        LogUtil.d("onApConnectedChanged " + findConnectDevice.getName() + ", " + findConnectDevice.getStatus());
        if (findConnectDevice.getStarryDevice().getDeviceType() == 3) {
            connectedChanged(str);
        } else if (findConnectDevice.checkStatus(4)) {
            connectByHighStrategy(str, z);
        } else {
            disconnectByHighStrategy(str);
        }
    }

    public void onApCreated(int i) {
        LogUtil.i("onApCreated : " + i);
        ChannelManagerImpl.getInstance().initServer(i);
    }

    public void onApRemoved() {
        LogUtil.i("onApRemoved");
        for (Map.Entry next : this.connectDevice.entrySet()) {
            if (!((StarryDevice) next.getValue()).checkStatus(4) && !((StarryDevice) next.getValue()).checkStatus(2)) {
                disconnectByHighStrategy(((StarryDevice) next.getValue()).getId());
            }
        }
    }

    public void onAuth(StarryDevice starryDevice) {
        for (Map.Entry next : this.registerConnectListener.entrySet()) {
            IDeviceConnectCallback iDeviceConnectCallback = (IDeviceConnectCallback) ((Map) next.getValue()).get(starryDevice.getId());
            if (iDeviceConnectCallback != null) {
                iDeviceConnectCallback.onAuth(starryDevice);
            }
            IDeviceConnectCallback iDeviceConnectCallback2 = (IDeviceConnectCallback) ((Map) next.getValue()).get((Object) null);
            if (iDeviceConnectCallback2 != null) {
                iDeviceConnectCallback2.onAuth(starryDevice);
            }
        }
    }

    public void onAuthMessage(StarryDevice starryDevice, byte[] bArr, int i) {
        for (Map.Entry next : this.registerConnectListener.entrySet()) {
            IDeviceConnectCallback iDeviceConnectCallback = (IDeviceConnectCallback) ((Map) next.getValue()).get(starryDevice.getId());
            if (iDeviceConnectCallback != null) {
                iDeviceConnectCallback.onAuthMessage(starryDevice, bArr, i);
            }
            IDeviceConnectCallback iDeviceConnectCallback2 = (IDeviceConnectCallback) ((Map) next.getValue()).get((Object) null);
            if (iDeviceConnectCallback2 != null) {
                iDeviceConnectCallback2.onAuthMessage(starryDevice, bArr, i);
            }
        }
    }

    public void onBRConnectedChanged(int i, String str) {
        if (i == 512) {
            brConnectedChanged(str);
            connectedChanged(str);
            if (!checkConnectState(str, 2048)) {
                deleteDevice();
            }
        } else if (i == 16) {
            connectedChanged(str);
        }
    }

    public void onBleConnectedChanged(String str, boolean z) {
        StarryDevice findConnectDevice = this.deviceManager.findConnectDevice(str);
        if (findConnectDevice == null) {
            disconnectByDefaultStrategy(str);
            return;
        }
        LogUtil.d("onBleConnectedChanged " + findConnectDevice.getName() + ", " + findConnectDevice.getStatus());
        if (findConnectDevice.getStarryDevice().getDeviceType() == 3) {
            connectedChanged(str);
        } else if (!findConnectDevice.checkStatus(1)) {
            disconnectByDefaultStrategy(str);
        } else if (findConnectDevice.getStarryDevice().getTerminalType() == 5) {
            connectBySimplifiedStrategy(findConnectDevice.getId());
        } else {
            connectByDefaultStrategy(findConnectDevice.getId(), z);
        }
    }

    public void onBondStateChanged(int i, int i2, StarryDevice starryDevice) {
        for (Map.Entry<String, Map<String, IDeviceConnectCallback>> value : this.registerConnectListener.entrySet()) {
            Map map = (Map) value.getValue();
            synchronized (this.registerConnectListener) {
                try {
                    for (Map.Entry value2 : map.entrySet()) {
                        ((IDeviceConnectCallback) value2.getValue()).onBondStateChanged(i, i2, starryDevice);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public void onConnectFail(int i, StarryDevice starryDevice, int i2) {
        for (Map.Entry next : this.registerConnectListener.entrySet()) {
            IDeviceConnectCallback iDeviceConnectCallback = (IDeviceConnectCallback) ((Map) next.getValue()).get(starryDevice.getId());
            if (iDeviceConnectCallback != null) {
                iDeviceConnectCallback.onConnectFail(i, starryDevice, i2);
            }
            IDeviceConnectCallback iDeviceConnectCallback2 = (IDeviceConnectCallback) ((Map) next.getValue()).get((Object) null);
            if (iDeviceConnectCallback2 != null) {
                iDeviceConnectCallback2.onConnectFail(i, starryDevice, i2);
            }
        }
    }

    public void onLanConnected(String str, boolean z) {
        StarryDevice findConnectDevice = this.deviceManager.findConnectDevice(str);
        if (findConnectDevice == null) {
            disconnectByHighStrategy(str);
            return;
        }
        LogUtil.d("onLanConnected " + findConnectDevice.getName() + ", " + findConnectDevice.getStatus());
        connectByHighStrategy(str, z);
    }

    public void onLanDisConnected(String str) {
        disconnectByHighStrategy(str);
    }

    public void onP2PConnectedChanged(String str, boolean z) {
        StarryDevice findConnectDevice = this.deviceManager.findConnectDevice(str);
        if (findConnectDevice == null) {
            disconnectByHighStrategy(str);
            return;
        }
        LogUtil.d("onP2PConnectedChanged " + findConnectDevice.getName() + ", " + findConnectDevice.getStatus());
        if (findConnectDevice.getStarryDevice().getDeviceType() == 3) {
            connectedChanged(str);
        } else if (findConnectDevice.checkStatus(2)) {
            connectByHighStrategy(str, z);
        } else {
            disconnectByHighStrategy(str);
        }
    }

    public void onP2pGoCreated(int i) {
        LogUtil.i("onP2pGoCreated : " + i);
        if (XdpNetStackManager.getInstance().isXdpAvailable(XdpNetStackManager.SOURCE_WS_SERVER_INIT, (byte) 1)) {
            XdpNetStackManager.getInstance().init(XdpNetStackManager.SOURCE_WS_SERVER_INIT);
        }
        ChannelManagerImpl.getInstance().initServer(i);
    }

    public void onP2pGoRemoved() {
        LogUtil.i("onP2pGoRemoved");
        for (Map.Entry next : this.connectDevice.entrySet()) {
            if (!((StarryDevice) next.getValue()).checkStatus(4) && !((StarryDevice) next.getValue()).checkStatus(2) && ((StarryDevice) next.getValue()).getTerminalType() != 7 && ((StarryDevice) next.getValue()).getTerminalType() != 10) {
                disconnectByHighStrategy(((StarryDevice) next.getValue()).getId());
            }
        }
        if (XdpNetStackManager.getInstance().isXdpAvailableForUnload()) {
            XdpNetStackManager.getInstance().unloadP2p0(XdpNetStackManager.SOURCE_WS_SERVER_CLOSE);
        }
    }

    public void onSPPConnectedChanged(String str, boolean z) {
        StarryDevice findConnectDevice = this.deviceManager.findConnectDevice(str);
        if (findConnectDevice != null) {
            if (findConnectDevice.checkStatus(32)) {
                connectByBalanceStrategy(findConnectDevice.getId(), z);
            } else {
                disconnectByBalanceStrategy(str);
            }
        }
    }

    public void onStarrynetServiceError() {
        ChannelManagerImpl.getInstance().uninstall();
        this.deviceManager.getConnectionManager().removeConnectDevice();
    }

    public void registerDeviceStatusListener(String str, String str2, IDeviceConnectCallback iDeviceConnectCallback) {
        LogUtil.d(str + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA + str2 + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA + iDeviceConnectCallback);
        synchronized (this.registerConnectListener) {
            try {
                Map map = this.registerConnectListener.get(str);
                if (map == null) {
                    map = new HashMap();
                }
                map.put(str2, iDeviceConnectCallback);
                this.registerConnectListener.put(str, map);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0063, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void unRegisterDeviceStatusListener(java.lang.String r3, java.lang.String r4, boolean r5) {
        /*
            r2 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r3)
            java.lang.String r1 = ","
            r0.append(r1)
            r0.append(r4)
            java.lang.String r1 = ", "
            r0.append(r1)
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            com.upuphone.runasone.utils.LogUtil.d(r0)
            java.util.Map<java.lang.String, java.util.Map<java.lang.String, com.upuphone.runasone.core.api.device.IDeviceConnectCallback>> r0 = r2.registerConnectListener
            monitor-enter(r0)
            if (r5 == 0) goto L_0x002d
            java.util.Map<java.lang.String, java.util.Map<java.lang.String, com.upuphone.runasone.core.api.device.IDeviceConnectCallback>> r2 = r2.registerConnectListener     // Catch:{ all -> 0x002b }
            r2.remove(r3)     // Catch:{ all -> 0x002b }
            monitor-exit(r0)     // Catch:{ all -> 0x002b }
            return
        L_0x002b:
            r2 = move-exception
            goto L_0x0064
        L_0x002d:
            java.util.Map<java.lang.String, java.util.Map<java.lang.String, com.upuphone.runasone.core.api.device.IDeviceConnectCallback>> r5 = r2.registerConnectListener     // Catch:{ all -> 0x002b }
            java.lang.Object r5 = r5.get(r3)     // Catch:{ all -> 0x002b }
            java.util.Map r5 = (java.util.Map) r5     // Catch:{ all -> 0x002b }
            if (r5 != 0) goto L_0x0039
            monitor-exit(r0)     // Catch:{ all -> 0x002b }
            return
        L_0x0039:
            r5.remove(r4)     // Catch:{ all -> 0x002b }
            int r4 = r5.size()     // Catch:{ all -> 0x002b }
            if (r4 != 0) goto L_0x0062
            java.util.Map<java.lang.String, java.util.Map<java.lang.String, com.upuphone.runasone.core.api.device.IDeviceConnectCallback>> r4 = r2.registerConnectListener     // Catch:{ all -> 0x002b }
            r4.remove(r3)     // Catch:{ all -> 0x002b }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x002b }
            r3.<init>()     // Catch:{ all -> 0x002b }
            java.lang.String r4 = "unRegisterDeviceStatusListener2 registerConnectListener changed - remove:  "
            r3.append(r4)     // Catch:{ all -> 0x002b }
            java.util.Map<java.lang.String, java.util.Map<java.lang.String, com.upuphone.runasone.core.api.device.IDeviceConnectCallback>> r2 = r2.registerConnectListener     // Catch:{ all -> 0x002b }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x002b }
            r3.append(r2)     // Catch:{ all -> 0x002b }
            java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x002b }
            com.upuphone.runasone.utils.LogUtil.d(r2)     // Catch:{ all -> 0x002b }
        L_0x0062:
            monitor-exit(r0)     // Catch:{ all -> 0x002b }
            return
        L_0x0064:
            monitor-exit(r0)     // Catch:{ all -> 0x002b }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.runasone.device.DeviceListenerImpl.unRegisterDeviceStatusListener(java.lang.String, java.lang.String, boolean):void");
    }
}
