package com.upuphone.runasone.device;

import android.os.Binder;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.honey.account.c6.a;
import com.upuphone.runasone.channel.ChannelManagerImpl;
import com.upuphone.runasone.channel.IChannel;
import com.upuphone.runasone.channel.IChannelManager;
import com.upuphone.runasone.connection.ConnectionManagerImpl;
import com.upuphone.runasone.core.api.device.IDeviceConnectCallback;
import com.upuphone.runasone.core.api.device.IDeviceManagerApi;
import com.upuphone.runasone.core.api.discovery.IDiscoveryCallback;
import com.upuphone.runasone.discovery.DiscoveryManagerImpl;
import com.upuphone.runasone.error.ConnectErrorCode;
import com.upuphone.runasone.host.core.api.EnumLinkStrategy;
import com.upuphone.runasone.service.StarrynetApiImpl;
import com.upuphone.runasone.utils.CommonThreadPool;
import com.upuphone.runasone.utils.LogUtil;
import com.upuphone.runasone.utils.Utils;
import com.upuphone.starrynet.api.bean.DiscoveryFilter;
import com.upuphone.starrynet.api.bean.DiscoverySettings;
import com.upuphone.starrynet.api.bean.StDevice;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class DeviceManagerImpl implements IDeviceManagerApi {
    private static final int EVENT_P2P_STATUS_CHECK = 1;
    private static final int THRESHOLD_P2P_STATUS_CHECK = 1000;
    private static DeviceManagerImpl deviceManager = new DeviceManagerImpl();
    /* access modifiers changed from: private */
    public ConnectionManagerImpl connectionManager = new ConnectionManagerImpl();
    /* access modifiers changed from: private */
    public DeviceListenerImpl deviceListener = new DeviceListenerImpl(this);
    private DiscoveryManagerImpl discoveryManager = new DiscoveryManagerImpl();
    /* access modifiers changed from: private */
    public Handler mDeviceManagerHandler;

    private DeviceManagerImpl() {
        init();
    }

    private void dumpConnectDevice(Map<String, StarryDevice> map) {
        LogUtil.d(" --------------- ConnectDevice  --------------- ");
        for (Map.Entry<String, StarryDevice> value : map.entrySet()) {
            LogUtil.d(" -> " + value.getValue());
        }
    }

    private StarryDevice findStarryDevice(String str) {
        StarryDevice starryDevice = this.connectionManager.getConnectDevice().get(str);
        return starryDevice == null ? this.discoveryManager.getFoundDeviceById(str) : starryDevice;
    }

    public static DeviceManagerImpl getInstance() {
        return deviceManager;
    }

    private void init() {
        this.connectionManager.registerDeviceListener(this.deviceListener);
        startDeviceManagerLooper();
        ChannelManagerImpl.getInstance().install();
        ChannelManagerImpl.getInstance().setChannelObserver(new IChannelManager.ChannelObserver() {
            public void onChannelError(StarryDevice starryDevice, EnumLinkStrategy enumLinkStrategy, int i) {
                LogUtil.d("onChannelError " + starryDevice.getName() + " errorCode:" + i);
                if (DeviceManagerImpl.this.connectionManager.checkConnectState(starryDevice, 2) && starryDevice.getStarryDevice() != null && enumLinkStrategy == EnumLinkStrategy.STRATEGY_HIGH_PERFORMANCE) {
                    LogUtil.d("need check p2p status after delay");
                    Message message = new Message();
                    message.what = 1;
                    message.obj = starryDevice;
                    DeviceManagerImpl.this.mDeviceManagerHandler.sendMessageDelayed(message, 1000);
                }
                DeviceManagerImpl.this.deviceListener.disconnectByStrategy(starryDevice.getId(), enumLinkStrategy);
            }

            public void onChannelLinkDown(StarryDevice starryDevice, EnumLinkStrategy enumLinkStrategy) {
                LogUtil.d("onChannelLinkDown " + starryDevice.getName());
                DeviceManagerImpl.this.deviceListener.disconnectByStrategy(starryDevice.getId(), enumLinkStrategy);
            }

            public void onChannelLinkUp(StarryDevice starryDevice, EnumLinkStrategy enumLinkStrategy) {
                LogUtil.d("onChannelLinkUp " + starryDevice.getName() + ", " + enumLinkStrategy.name());
                DeviceManagerImpl.this.mDeviceManagerHandler.removeMessages(1);
                DeviceManagerImpl.this.deviceListener.bindChannel(starryDevice.getId(), enumLinkStrategy);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$startDeviceManagerLooper$0() {
        Looper.prepare();
        LogUtil.d("mDeviceManagerHandler is start");
        this.mDeviceManagerHandler = new Handler() {
            public void handleMessage(Message message) {
                if (message.what != 1) {
                    LogUtil.e("mDeviceManagerHandler un-catch " + message.what);
                    return;
                }
                LogUtil.d("EVENT_P2P_STATUS_CHECK");
                StarryDevice starryDevice = (StarryDevice) message.obj;
                if (starryDevice == null || starryDevice.getStarryDevice() == null) {
                    LogUtil.e("device is null");
                } else if (DeviceManagerImpl.this.connectionManager.checkConnectState(starryDevice, 2)) {
                    LogUtil.e("通道已关闭，需移除p2p，channel is already un-valid, need disconnectP2p");
                    if (!starryDevice.isConnectByMdns()) {
                        StarrynetApiImpl.getInstance().disconnectP2p(starryDevice.getStarryDevice());
                    }
                } else if (DeviceManagerImpl.this.connectionManager.checkConnectState(starryDevice, 4)) {
                    LogUtil.e("通道已关闭，需移除ap，channel is already un-valid, need disconnectP2p");
                    StarrynetApiImpl.getInstance().disConnectWifiAp(starryDevice.getStarryDevice());
                }
            }
        };
        Looper.loop();
        LogUtil.d("mDeviceManagerHandler is end");
    }

    private void startDeviceManagerLooper() {
        if (this.mDeviceManagerHandler == null) {
            CommonThreadPool.execute(new a(this));
        } else {
            LogUtil.e("mDeviceManagerHandler is already init");
        }
    }

    private void stopServerLooper() {
        Handler handler = this.mDeviceManagerHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
            this.mDeviceManagerHandler.getLooper().quitSafely();
            this.mDeviceManagerHandler = null;
        }
    }

    public int balanceConnect(String str) {
        return connect(str, 32);
    }

    public int cancelAuth(String str) {
        if (!TextUtils.isEmpty(str)) {
            return this.discoveryManager.cancelAuth(str);
        }
        LogUtil.e("cancelAuth deviceId = null");
        return -1;
    }

    public int connect(StarryDevice starryDevice, int i) {
        return this.connectionManager.connect(starryDevice, i);
    }

    public void createBond(String str) {
        if (TextUtils.isEmpty(str)) {
            LogUtil.e("createBond deviceId = null");
        } else {
            this.discoveryManager.createBond(str);
        }
    }

    public int disBalanceConnect(String str) {
        return disconnect(str, 32);
    }

    public void disableFastConnect() {
        this.discoveryManager.disableFastConnect();
    }

    public int disconnect(String str, int i) {
        LogUtil.i("disconnect: " + str + " callPid: " + Binder.getCallingPid());
        return TextUtils.isEmpty(str) ? ConnectErrorCode.CONNECT_NOT_FOUND_DEVICEID : this.connectionManager.disconnect(str, i);
    }

    public int disconnectAll(String str) {
        return this.connectionManager.disconnectAll(str);
    }

    public void enableFastConnect() {
        this.discoveryManager.enableFastConnect();
    }

    public int enableFastConnectWithTimeOut(long j) {
        return this.discoveryManager.enableFastConnectWithTimeOut(j);
    }

    public StarryDevice findConnectDevice(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.connectionManager.findConnectDevice(str);
    }

    public List<StarryDevice> getBondedDevice() {
        return this.connectionManager.getBondedDevice();
    }

    public List<StarryDevice> getConnectedDevice() {
        return this.connectionManager.getConnectedDevice();
    }

    public List<StarryDevice> getConnectedDevices(int i) {
        List<StDevice> connectedDevices = StarrynetApiImpl.getInstance().getConnectedDevices(i);
        if (connectedDevices == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < connectedDevices.size(); i2++) {
            arrayList.add(Utils.convert(connectedDevices.get(i2)));
        }
        return arrayList;
    }

    public ConnectionManagerImpl getConnectionManager() {
        return this.connectionManager;
    }

    public int getCurDeviceState(String str) {
        return this.connectionManager.getCurDeviceState(str);
    }

    public int getDeviceConnectable(String str) {
        return this.connectionManager.getDeviceConnectable(str);
    }

    public String getDeviceDetailInfo(String str, int i) {
        return StarrynetApiImpl.getInstance().getDeviceDetailInfo(Utils.hexString2Bytes(str), i);
    }

    public int getPreDeviceState(String str) {
        return this.connectionManager.getPreDeviceState(str);
    }

    public StarryDevice getSelfDevice() {
        return this.connectionManager.getSelfDevice();
    }

    public List<String> getSupportAbility(String str) {
        IChannel findChannelById = ChannelManagerImpl.getInstance().findChannelById(str);
        if (findChannelById != null) {
            return findChannelById.getActiveAbilityList();
        }
        return null;
    }

    public int getVirtualChannelStatus(String str) {
        return this.connectionManager.getVirtualChannelStatus(str);
    }

    public String[] getWifiInfo() {
        return Utils.getWlanSSID(Utils.getContext());
    }

    public boolean isBRConnect(String str) {
        return this.connectionManager.isBRConnect(str);
    }

    public boolean isBalanceConnect(String str) {
        return this.connectionManager.isBalanceConnect(str);
    }

    public void registerDeviceStatusListener(String str, IDeviceConnectCallback iDeviceConnectCallback) {
        this.deviceListener.registerDeviceStatusListener(String.valueOf(Binder.getCallingPid()), str, iDeviceConnectCallback);
    }

    public void removeBond(String str) {
        if (TextUtils.isEmpty(str)) {
            LogUtil.e("removeBond deviceId = null");
        } else {
            this.discoveryManager.removeBond(str);
        }
    }

    public void requestAuth(String str, byte[] bArr) {
        if (TextUtils.isEmpty(str)) {
            LogUtil.e("requestAuth deviceId = null");
        } else {
            this.discoveryManager.requestAuth(str, bArr);
        }
    }

    public int requestConnect(byte[] bArr) {
        return this.discoveryManager.requestConnect(bArr);
    }

    public int requestConnectWithTime(byte[] bArr, long j) {
        return this.discoveryManager.requestConnectWithTime(bArr, j);
    }

    public int setAdvertiseEnableMode(int i) {
        return this.discoveryManager.setAdvertiseEnableMode(i);
    }

    public int setDeviceConnectable(boolean z, int i, String str) {
        return this.connectionManager.setDeviceConnectable(z, i, str);
    }

    public void setDiscoveryFilter(DiscoveryFilter discoveryFilter) {
        this.discoveryManager.setDiscoveryFilter(discoveryFilter);
    }

    public int setFastConnectProcess(int i) {
        return this.discoveryManager.setFastConnectProcess(i);
    }

    public int setReconnectEnable(boolean z) {
        return this.discoveryManager.setReconnectEnable(z);
    }

    public void startDiscovery(DiscoveryFilter discoveryFilter, DiscoverySettings discoverySettings, IDiscoveryCallback iDiscoveryCallback) {
        this.discoveryManager.startDiscovery(discoveryFilter, discoverySettings, iDiscoveryCallback);
    }

    public int startMultiDeviceFound() {
        return this.discoveryManager.startMultiDeviceFound();
    }

    public void stopDiscovery() {
        this.discoveryManager.stopDiscovery();
    }

    public int stopMultiDeviceFound(boolean z) {
        return this.discoveryManager.stopMultiDeviceFound(z);
    }

    public void unRegisterDeviceStatusListener(String str) {
        this.deviceListener.unRegisterDeviceStatusListener(String.valueOf(Binder.getCallingPid()), str, false);
    }

    public int updateAdvParams(byte[] bArr) {
        return this.discoveryManager.updateAdvParams(bArr);
    }

    public int connect(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return ConnectErrorCode.CONNECT_NOT_FOUND_DEVICEID;
        }
        dumpConnectDevice(this.connectionManager.getConnectDevice());
        StarryDevice findStarryDevice = findStarryDevice(str);
        if (findStarryDevice != null) {
            return this.connectionManager.connect(findStarryDevice, i);
        }
        LogUtil.e("CONNECT_NOT_FOUND_DEVICEID : " + str);
        return ConnectErrorCode.CONNECT_NOT_FOUND_DEVICEID;
    }

    public void stopDiscovery(String str) {
        this.discoveryManager.stopDiscovery(str);
    }

    public void unRegisterDeviceStatusListener(int i, String str, boolean z) {
        this.deviceListener.unRegisterDeviceStatusListener(String.valueOf(i), str, z);
    }
}
