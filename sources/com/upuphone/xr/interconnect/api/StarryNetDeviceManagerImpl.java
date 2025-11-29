package com.upuphone.xr.interconnect.api;

import android.bluetooth.BluetoothDevice;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.RemoteException;
import androidx.core.content.ContextCompat;
import com.honey.account.s7.g;
import com.honey.account.s7.h;
import com.honey.account.s7.i;
import com.honey.account.s7.j;
import com.honey.account.s7.k;
import com.honey.account.s7.l;
import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.starrynet.api.bean.DiscoveryFilter;
import com.upuphone.starrynetsdk.device.connection.DevicesConnector;
import com.upuphone.starrynetsdk.device.discovery.DevicesDiscoverer;
import com.upuphone.starrynetsdk.device.discovery.DiscoverListener;
import com.upuphone.xr.interconnect.Constants;
import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.interconnect.bluetooth.BluetoothEventMonitor;
import com.upuphone.xr.interconnect.bluetooth.OnBluetoothStateListener;
import com.upuphone.xr.interconnect.business.connect.ConnectManager;
import com.upuphone.xr.interconnect.business.connect.DeviceNameChangeBroadcastReceiver;
import com.upuphone.xr.interconnect.business.discover.DefaultDiscoverListener;
import com.upuphone.xr.interconnect.business.discover.WrapperDiscoverListener;
import com.upuphone.xr.interconnect.common.IDeviceBondStateListener;
import com.upuphone.xr.interconnect.common.IDeviceConnectionListener;
import com.upuphone.xr.interconnect.common.IP2pAcquireCallback;
import com.upuphone.xr.interconnect.common.IP2pStateListener;
import com.upuphone.xr.interconnect.common.IRequestCallback;
import com.upuphone.xr.interconnect.entity.StarryDeviceExt;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.interconnect.main.DiscoveryState;
import com.upuphone.xr.interconnect.main.StarryNetAbilityManager;
import com.upuphone.xr.interconnect.util.DeDuplicateCopyOnWriteArrayList;
import com.upuphone.xr.interconnect.util.XrSdkBondDeviceUtil;
import com.upuphone.xr.interconnect.util.log.ILog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;

public class StarryNetDeviceManagerImpl implements StarryNetDeviceManager {
    private static final String ACTION_STARRY_NET_DEVICE_NAME_CHANGED = "com.upuphone.starrynet.action.DEVICE_NAME_CHANGED";
    public static final String PREF_FILE_BIND_DEVICE_INFO_KEY = "Bind_Device_Info";
    public static final String PREF_FILE_BIND_GLASS_DEVICE_INFO_KEY = "Bind_Glass_Device_Info";
    public static final String PREF_FILE_BIND_RING_DEVICE_INFO_KEY = "Bind_Ring_Device_Info";
    private static final String PREF_FILE_DEVICE_TYPE_KEY = "DeviceType";
    public static final String PREF_FILE_DEVICE_TYPE_NAME = "StarryNetDeviceType_Prefs";
    public static final String TAG = "StarryNetDeviceManagerImpl";
    private static final long TIMEOUT_BLE_ADVERTISE_DEFAULT = 60000;
    public final ConnectManager connectManager = new ConnectManager();
    private final DiscoverListener mDiscoverListener;
    @DiscoveryState
    private int mDiscoveryState = 0;
    private final Map<String, StarryNetDevice> mFoundDeviceMap;
    private final List<StarryNetDeviceDiscoverListener> mStarryNetDeviceDiscoverListenerList;

    public StarryNetDeviceManagerImpl() {
        DeDuplicateCopyOnWriteArrayList deDuplicateCopyOnWriteArrayList = new DeDuplicateCopyOnWriteArrayList();
        this.mStarryNetDeviceDiscoverListenerList = deDuplicateCopyOnWriteArrayList;
        HashMap hashMap = new HashMap();
        this.mFoundDeviceMap = hashMap;
        this.mDiscoverListener = new DefaultDiscoverListener(hashMap, deDuplicateCopyOnWriteArrayList);
    }

    private DevicesConnector getDevicesConnector() {
        return StarryNetAbilityManager.getInstance().getDevicesConnector();
    }

    private DevicesDiscoverer getDevicesDiscoverer() {
        return StarryNetAbilityManager.getInstance().getDevicesDiscoverer();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Unit lambda$acquireBalanceConnection$4(IRequestCallback iRequestCallback) {
        try {
            iRequestCallback.onFail(3, (String) null);
        } catch (RemoteException unused) {
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Unit lambda$acquireEnhanceConnection$1(IRequestCallback iRequestCallback) {
        try {
            iRequestCallback.onFail(3, (String) null);
        } catch (RemoteException unused) {
        }
        return Unit.INSTANCE;
    }

    public void acquireBalanceConnection(String str, String str2, IRequestCallback iRequestCallback) {
        this.connectManager.manageDeviceConnectionLevel(str2, new j(str, iRequestCallback), new k(iRequestCallback));
    }

    public void acquireEnhanceConnection(String str, String str2, IRequestCallback iRequestCallback) {
        this.connectManager.manageDeviceConnectionLevel(str2, new h(str, iRequestCallback), new i(iRequestCallback));
    }

    public void activeQueryConnectedDevice() {
    }

    public boolean bondDevice(String str) {
        DevicesConnector devicesConnector = getDevicesConnector();
        if (devicesConnector == null) {
            ILog.d(TAG, "绑定设备--" + str + "失败--DevicesConnector为空");
            return false;
        }
        int createBond = devicesConnector.createBond(str);
        ILog.d(TAG, "DevicesConnector createBond返回code--" + createBond);
        return createBond == 0;
    }

    public int connectDevice(String str) {
        DevicesConnector devicesConnector = getDevicesConnector();
        if (devicesConnector == null) {
            ILog.d(TAG, "连接设备--" + str + "失败--DevicesConnector为空");
            return -1;
        }
        int connect = devicesConnector.connect(str, 1);
        ILog.d(TAG, "DevicesConnector connect ble返回code--" + connect);
        return connect;
    }

    public boolean disconnectDevice(String str) {
        DevicesConnector devicesConnector = getDevicesConnector();
        if (devicesConnector == null) {
            ILog.d(TAG, "断开连接设备--" + str + "失败--DevicesConnector为空");
            return false;
        }
        int disconnect = devicesConnector.disconnect(str, 1);
        ILog.d(TAG, "DevicesConnector disconnect ble返回code--" + disconnect);
        return disconnect == 0;
    }

    public StarryNetDevice getBondedDevice() {
        return XrSdkBondDeviceUtil.INSTANCE.getBondedDevice(InterconnectManager.getInstance().getContext());
    }

    public List<StarryNetDevice> getBondedDevices() {
        return this.connectManager.getBondStateManager().getBoundDeviceList();
    }

    public StarryNetDevice getBondedGlassStarryNetDevice() {
        return XrSdkBondDeviceUtil.INSTANCE.getBondedGlassDevice(InterconnectManager.getInstance().getContext());
    }

    public StarryNetDevice getBondedRingStarryNetDevice() {
        return XrSdkBondDeviceUtil.INSTANCE.getBondedRingDevice(InterconnectManager.getInstance().getContext());
    }

    public List<StarryNetDevice> getBondedStarryNetDeviceList() {
        return XrSdkBondDeviceUtil.INSTANCE.getBondedDeviceList(InterconnectManager.getInstance().getContext());
    }

    public StarryDevice getConnectedDevice() {
        return this.connectManager.getConnectionStateManager().getConnectedPrimaryGlassStarryDevice();
    }

    public String getConnectedDeviceType() {
        StarryDevice connectedDevice = getConnectedDevice();
        if (connectedDevice == null) {
            ILog.w(TAG, "getConnectedDeviceType getConnectedDevice is null getBleConnectedPrimaryStarryDevice");
            connectedDevice = this.connectManager.getConnectionStateManager().getBleConnectedPrimaryStarryDevice();
        }
        if (connectedDevice == null) {
            ILog.w(TAG, "getConnectedDeviceType getBleConnectedPrimaryStarryDevice is null");
            return getDeviceTypeFromSp();
        }
        String deviceInfo = getDeviceInfo(connectedDevice.getId(), 6);
        String deviceInfo2 = getDeviceInfo(connectedDevice.getId(), 5);
        ILog.w(TAG, "getConnectedDeviceType  modelName = " + deviceInfo + ",modelId = " + deviceInfo2);
        return getDevicesTypeByModelId(deviceInfo2);
    }

    public StarryNetDevice getConnectedDeviceWrapper() {
        return this.connectManager.getConnectionStateManager().getConnectedPrimaryGlassStarryNetDevice();
    }

    public StarryNetDevice getConnectedGlassStarryNetDevice() {
        return this.connectManager.getConnectionStateManager().getConnectedPrimaryGlassStarryNetDevice();
    }

    public StarryNetDevice getConnectedRingStarryNetDevice() {
        return this.connectManager.getConnectionStateManager().getConnectedPrimaryRingStarryNetDevice();
    }

    public List<StarryNetDevice> getConnectedStarryNetDeviceList() {
        ArrayList arrayList = new ArrayList();
        StarryNetDevice connectedPrimaryGlassStarryNetDevice = this.connectManager.getConnectionStateManager().getConnectedPrimaryGlassStarryNetDevice();
        StarryNetDevice connectedPrimaryRingStarryNetDevice = this.connectManager.getConnectionStateManager().getConnectedPrimaryRingStarryNetDevice();
        if (connectedPrimaryGlassStarryNetDevice != null) {
            arrayList.add(connectedPrimaryGlassStarryNetDevice);
        }
        if (connectedPrimaryRingStarryNetDevice != null) {
            arrayList.add(connectedPrimaryRingStarryNetDevice);
        }
        return arrayList;
    }

    public long getDefaultAdvertiseTimeout() {
        return 60000;
    }

    public int getDeviceBondState(String str) {
        return this.connectManager.getBondStateManager().getBoundGlassDeviceMap().containsKey(str) ? 2 : 0;
    }

    public String getDeviceInfo(String str, int i) {
        DevicesConnector devicesConnector = getDevicesConnector();
        if (devicesConnector != null) {
            return devicesConnector.getDeviceInfo(str, i);
        }
        return null;
    }

    public String getDeviceTypeFromSp() {
        try {
            String string = InterconnectManager.getInstance().getContext().getSharedPreferences(PREF_FILE_DEVICE_TYPE_NAME, 0).getString(PREF_FILE_DEVICE_TYPE_KEY, "");
            ILog.w(TAG, "getDeviceTypeFromSp cache type = " + string);
            return string;
        } catch (Exception e) {
            ILog.e(TAG, "getDeviceTypeToFrom error info = " + e.getMessage());
            return "";
        }
    }

    public String getDevicesTypeByModelId(String str) {
        String str2 = "";
        if (str == null) {
            ILog.w(TAG, "getDevicesTypeByModelId modelId is null");
            return str2;
        }
        char c = 65535;
        switch (str.hashCode()) {
            case 1507424:
                if (str.equals("1001")) {
                    c = 0;
                    break;
                }
                break;
            case 1507425:
                if (str.equals("1002")) {
                    c = 1;
                    break;
                }
                break;
            case 1507426:
                if (str.equals("1003")) {
                    c = 2;
                    break;
                }
                break;
            case 1507427:
                if (str.equals("1004")) {
                    c = 3;
                    break;
                }
                break;
            case 1626588:
                if (str.equals("5001")) {
                    c = 4;
                    break;
                }
                break;
            case 1626589:
                if (str.equals("5002")) {
                    c = 5;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                str2 = Constants.GLASS_DEVICE_CONCEPT;
                break;
            case 1:
                str2 = Constants.GLASS_DEVICE_STAR;
                break;
            case 2:
            case 4:
                str2 = Constants.GLASS_DEVICE_ARI;
                break;
            case 3:
            case 5:
                str2 = Constants.GLASS_DEVICE_ARI_PRO;
                break;
            default:
                ILog.w(TAG, "getDevicesTypeByModelId unkown model id");
                break;
        }
        ILog.w(TAG, "getDevicesTypeByModelId modelId is " + str2);
        saveDeviceTypeToSp(str2);
        return str2;
    }

    public int getDiscoveryState() {
        return this.mDiscoveryState;
    }

    public List<StarryNetDevice> getFoundDevices() {
        return new ArrayList(this.mFoundDeviceMap.values());
    }

    public int getP2pState() {
        return this.connectManager.getP2pConnectionManager().getState();
    }

    public StarryNetDevice getSelfDevice() {
        DevicesConnector devicesConnector = getDevicesConnector();
        if (devicesConnector == null) {
            ILog.d(TAG, "获取本地设备信息失败--DevicesConnector为空");
            return null;
        }
        StarryDevice selfDevice = devicesConnector.getSelfDevice();
        if (selfDevice != null && selfDevice.getStarryDevice() != null) {
            return StarryDeviceExt.wrapForSelf(selfDevice);
        }
        ILog.d(TAG, "获取本地设备信息失败--DevicesConnector查询的设备为空");
        return null;
    }

    public String[] getWifiInfo() {
        DevicesConnector devicesConnector = getDevicesConnector();
        if (devicesConnector != null) {
            return devicesConnector.getWifiInfo();
        }
        ILog.d(TAG, "DevicesConnector为空，不能获取wifi信息");
        return null;
    }

    public void init() {
        BluetoothEventMonitor instance = BluetoothEventMonitor.getInstance();
        instance.registerBluetoothStateListener(new OnBluetoothStateListener() {
            public boolean onReceivePairRequest(BluetoothDevice bluetoothDevice, int i, int i2) {
                String str;
                if (ContextCompat.checkSelfPermission(InterconnectManager.getInstance().getContext(), "android.permission.BLUETOOTH_CONNECT") == 0) {
                    str = bluetoothDevice.getName();
                } else {
                    ILog.e(StarryNetDeviceManagerImpl.TAG, "应用没有蓝牙连接权限，不能获取蓝牙名称");
                    str = null;
                }
                ILog.e(StarryNetDeviceManagerImpl.TAG, "onPairingKeyReceived key = " + i2);
                XrSdkBondDeviceUtil.INSTANCE.cancelTimeOutJob("onPairingKeyReceived");
                StarryNetDeviceManagerImpl.this.connectManager.onPairingKeyReceived(str, i2);
                return super.onReceivePairRequest(bluetoothDevice, i, i2);
            }
        });
        instance.start();
        IntentFilter intentFilter = new IntentFilter("com.upuphone.starrynet.action.DEVICE_NAME_CHANGED");
        if (Build.VERSION.SDK_INT >= 33) {
            InterconnectManager.getInstance().getContext().registerReceiver(new DeviceNameChangeBroadcastReceiver(this.connectManager), intentFilter, 4);
        } else {
            InterconnectManager.getInstance().getContext().registerReceiver(new DeviceNameChangeBroadcastReceiver(this.connectManager), intentFilter);
        }
    }

    public void interceptConnectProcess(boolean z) {
        this.connectManager.interceptConnectProcess(z);
    }

    public boolean isAir() {
        return Constants.GLASS_DEVICE_ARI.equals(getConnectedDeviceType());
    }

    public boolean isAirPro() {
        return Constants.GLASS_DEVICE_ARI_PRO.equals(getConnectedDeviceType());
    }

    public boolean isIntlAir() {
        StarryDevice connectedDevice = getConnectedDevice();
        if (connectedDevice == null) {
            ILog.w(TAG, "isIntlAir getConnectedDevice is null getBleConnectedPrimaryStarryDevice");
            connectedDevice = this.connectManager.getConnectionStateManager().getBleConnectedPrimaryStarryDevice();
        }
        if (connectedDevice == null) {
            ILog.w(TAG, "isIntlAir getBleConnectedPrimaryStarryDevice is null");
            return false;
        }
        String deviceInfo = getDeviceInfo(connectedDevice.getId(), 6);
        String deviceInfo2 = getDeviceInfo(connectedDevice.getId(), 5);
        ILog.w(TAG, "isIntlAir  modelName = " + deviceInfo + ",modelId = " + deviceInfo2);
        boolean equals = "5001".equals(deviceInfo2);
        StringBuilder sb = new StringBuilder();
        sb.append("isIntlAir isIntlAir = ");
        sb.append(equals);
        ILog.e(TAG, sb.toString());
        return equals;
    }

    public boolean isIntlAirPro() {
        StarryDevice connectedDevice = getConnectedDevice();
        if (connectedDevice == null) {
            ILog.w(TAG, "isIntlAirPro getConnectedDevice is null getBleConnectedPrimaryStarryDevice");
            connectedDevice = this.connectManager.getConnectionStateManager().getBleConnectedPrimaryStarryDevice();
        }
        if (connectedDevice == null) {
            ILog.w(TAG, "isIntlAirPro getBleConnectedPrimaryStarryDevice is null");
            return false;
        }
        String deviceInfo = getDeviceInfo(connectedDevice.getId(), 6);
        String deviceInfo2 = getDeviceInfo(connectedDevice.getId(), 5);
        ILog.w(TAG, "isIntlAirPro  modelName = " + deviceInfo + ",modelId = " + deviceInfo2);
        boolean equals = "5002".equals(deviceInfo2);
        StringBuilder sb = new StringBuilder();
        sb.append("isIntlAirPro isIntlAirPro = ");
        sb.append(equals);
        ILog.e(TAG, sb.toString());
        return equals;
    }

    public void registerConnectionListener(ConnectionListener connectionListener, boolean z) {
        this.connectManager.getConnectionListenerManager().registerConnectionListener(connectionListener, z);
    }

    public void registerDeviceBondStateListener(IDeviceBondStateListener iDeviceBondStateListener) {
        this.connectManager.getConnectionListenerManager().registerDeviceBondStateListener(iDeviceBondStateListener);
    }

    public void registerDeviceConnectionListener(IDeviceConnectionListener iDeviceConnectionListener) {
        this.connectManager.getConnectionListenerManager().registerDeviceConnectionListener(iDeviceConnectionListener);
    }

    public void registerDeviceConnectionPriorityListener(IDeviceConnectionListener iDeviceConnectionListener) {
        this.connectManager.getConnectionListenerManager().registerDeviceConnectionPriorityListener(iDeviceConnectionListener);
    }

    public void registerDeviceDiscoverListener(StarryNetDeviceDiscoverListener starryNetDeviceDiscoverListener) {
        if (starryNetDeviceDiscoverListener != null) {
            this.mStarryNetDeviceDiscoverListenerList.add(starryNetDeviceDiscoverListener);
        }
    }

    public void registerDeviceStateChangeListener(StarryNetDeviceStateChangeListener starryNetDeviceStateChangeListener) {
        this.connectManager.getConnectionListenerManager().registerDeviceStateChangeListener(starryNetDeviceStateChangeListener);
    }

    public void registerP2pStateListener(IP2pStateListener iP2pStateListener) {
        this.connectManager.getP2pConnectionManager().registerStateListener(iP2pStateListener);
    }

    public void releaseBalanceConnection(String str, String str2) {
        this.connectManager.manageDeviceConnectionLevel(str2, new l(str));
    }

    public void releaseEnhanceConnection(String str, String str2) {
        this.connectManager.manageDeviceConnectionLevel(str2, new g(str));
    }

    public void saveDeviceTypeToSp(String str) {
        try {
            SharedPreferences.Editor edit = InterconnectManager.getInstance().getContext().getSharedPreferences(PREF_FILE_DEVICE_TYPE_NAME, 0).edit();
            edit.putString(PREF_FILE_DEVICE_TYPE_KEY, str);
            edit.apply();
        } catch (Exception e) {
            ILog.e(TAG, "saveDeviceTypeToSp error info = " + e.getMessage());
        }
    }

    public void setAllDeviceDisConnectionStatus() {
        this.connectManager.getConnectionStateManager().onSetAllConnectionDisconnected();
    }

    public void setMainDeviceConnectListener(IDeviceConnectionListener iDeviceConnectionListener) {
        this.connectManager.getConnectionListenerManager().setMainDeviceConnectionListener(iDeviceConnectionListener);
    }

    public void startAdvertise() {
        DevicesDiscoverer devicesDiscoverer = getDevicesDiscoverer();
        if (devicesDiscoverer == null) {
            ILog.d(TAG, "开启BLE广播失败--DevicesDiscoverer为空");
            return;
        }
        int startAdvertise = devicesDiscoverer.startAdvertise(60000);
        ILog.d(TAG, "开启BLE广播返回code--" + startAdvertise);
    }

    public void startAdvertiseWithTimeout(long j) {
        if (j <= 0) {
            ILog.d(TAG, "开启BLE广播失败--参数timeout小于等于0");
            return;
        }
        DevicesDiscoverer devicesDiscoverer = getDevicesDiscoverer();
        if (devicesDiscoverer == null) {
            ILog.d(TAG, "开启BLE广播失败--DevicesDiscoverer为空");
            return;
        }
        int startAdvertise = devicesDiscoverer.startAdvertise(j);
        ILog.d(TAG, "开启BLE广播，超时时间--" + j + "返回code--" + startAdvertise);
    }

    public void startDiscovery() {
        DevicesDiscoverer devicesDiscoverer = getDevicesDiscoverer();
        if (devicesDiscoverer == null) {
            ILog.d(TAG, "DevicesDiscoverer为空，不能进行扫描--原因是绑定互联服务还未返回成功");
            return;
        }
        int startDiscovery = devicesDiscoverer.startDiscovery(new DiscoveryFilter.Builder().setDeviceType(1).build(), this.mDiscoverListener);
        ILog.d(TAG, "DevicesDiscoverer startDiscovery返回code--" + startDiscovery);
    }

    public void stopAdvertise() {
        DevicesDiscoverer devicesDiscoverer = getDevicesDiscoverer();
        if (devicesDiscoverer == null) {
            ILog.d(TAG, "开启BLE广播失败--DevicesDiscoverer为空");
            return;
        }
        int stopAdvertise = devicesDiscoverer.stopAdvertise();
        ILog.d(TAG, "停止BLE广播返回code--" + stopAdvertise);
    }

    public void stopDiscovery() {
        DevicesDiscoverer devicesDiscoverer = getDevicesDiscoverer();
        if (devicesDiscoverer == null) {
            ILog.d(TAG, "DevicesDiscoverer为空，不能进行操作--原因是绑定互联服务还未返回成功");
            return;
        }
        int stopDiscover = devicesDiscoverer.stopDiscover();
        ILog.d(TAG, "DevicesDiscoverer stopDiscover返回code--" + stopDiscover);
    }

    public void tryAcquireP2p(String str, IP2pAcquireCallback iP2pAcquireCallback) {
        this.connectManager.acquireP2p(str, iP2pAcquireCallback);
    }

    public void tryReleaseP2p(String str) {
        this.connectManager.releaseP2p(str);
    }

    public boolean unBondDevice(String str) {
        this.connectManager.unbindDevice(str);
        return true;
    }

    public void unregisterConnectionListener(ConnectionListener connectionListener) {
        this.connectManager.getConnectionListenerManager().unregisterConnectionListener(connectionListener);
    }

    public void unregisterDeviceBondStateListener(IDeviceBondStateListener iDeviceBondStateListener) {
        this.connectManager.getConnectionListenerManager().unregisterDeviceBondStateListener(iDeviceBondStateListener);
    }

    public void unregisterDeviceConnectionListener(IDeviceConnectionListener iDeviceConnectionListener) {
        this.connectManager.getConnectionListenerManager().unregisterDeviceConnectionListener(iDeviceConnectionListener);
    }

    public void unregisterDeviceConnectionPriorityListener(IDeviceConnectionListener iDeviceConnectionListener) {
        this.connectManager.getConnectionListenerManager().unregisterDeviceConnectionPriorityListener(iDeviceConnectionListener);
    }

    public void unregisterDeviceDiscoverListener(StarryNetDeviceDiscoverListener starryNetDeviceDiscoverListener) {
        if (starryNetDeviceDiscoverListener != null) {
            this.mStarryNetDeviceDiscoverListenerList.remove(starryNetDeviceDiscoverListener);
        }
    }

    public void unregisterDeviceStateChangeListener(StarryNetDeviceStateChangeListener starryNetDeviceStateChangeListener) {
        this.connectManager.getConnectionListenerManager().unregisterDeviceStateChangeListener(starryNetDeviceStateChangeListener);
    }

    public void unregisterP2pSateListener(IP2pStateListener iP2pStateListener) {
        this.connectManager.getP2pConnectionManager().unregisterStateListener(iP2pStateListener);
    }

    public StarryNetDevice getConnectedDevice(int i) {
        return this.connectManager.getConnectionStateManager().getConnectedDevice((byte) i);
    }

    public void startDiscovery(DiscoveryFilter discoveryFilter, StarryNetDeviceDiscoverListener starryNetDeviceDiscoverListener) {
        DevicesDiscoverer devicesDiscoverer = getDevicesDiscoverer();
        if (devicesDiscoverer == null) {
            ILog.d(TAG, "DevicesDiscoverer为空，不能进行扫描--原因是绑定互联服务还未返回成功");
            return;
        }
        int startDiscovery = devicesDiscoverer.startDiscovery(discoveryFilter, new WrapperDiscoverListener(starryNetDeviceDiscoverListener));
        ILog.d(TAG, "DevicesDiscoverer startDiscovery with filter返回code--" + startDiscovery);
    }

    public String getConnectedDeviceType(String str) {
        String deviceInfo = getDeviceInfo(str, 6);
        String deviceInfo2 = getDeviceInfo(str, 5);
        ILog.w(TAG, "getConnectedDeviceType by deviceId  modelName = " + deviceInfo + ",modelId = " + deviceInfo2);
        return getDevicesTypeByModelId(deviceInfo2);
    }
}
