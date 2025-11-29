package com.upuphone.runasone.connection;

import android.os.Binder;
import android.text.TextUtils;
import com.meizu.common.widget.MzContactsContract;
import com.upuphone.runasone.channel.ChannelManagerImpl;
import com.upuphone.runasone.channel.IChannel;
import com.upuphone.runasone.connection.gateway.ConnectGateWay;
import com.upuphone.runasone.core.api.connection.IConnectionManager;
import com.upuphone.runasone.device.IDeviceListenerInner;
import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.runasone.error.ConnectErrorCode;
import com.upuphone.runasone.host.core.api.EnumLinkStrategy;
import com.upuphone.runasone.service.StarrynetApiImpl;
import com.upuphone.runasone.utils.LogUtil;
import com.upuphone.runasone.utils.Utils;
import com.upuphone.starrynet.api.bean.StDevice;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConnectionManagerImpl implements IConnectionManager {
    private static Map<String, StarryDevice> connectDevice = new ConcurrentHashMap();
    private ConnectGateWay gateWay = new ConnectGateWay();
    private GateWayStateChangedImpl onGateWayStateChanged;
    private String[] whiteList = {"com.flyme.linkUnion", "android.uid.system:1000"};

    public ConnectionManagerImpl() {
        GateWayStateChangedImpl gateWayStateChangedImpl = new GateWayStateChangedImpl(connectDevice);
        this.onGateWayStateChanged = gateWayStateChangedImpl;
        this.gateWay.setOnGateWayStateChanged(gateWayStateChangedImpl);
    }

    private int getConnectCount(String str, int i) {
        StarryDevice starryDevice = connectDevice.get(str);
        if (starryDevice == null) {
            return 0;
        }
        return starryDevice.getConnectCount(Integer.valueOf(i));
    }

    private void preDisConnect(StarryDevice starryDevice) {
        IChannel findChannelById;
        if ((starryDevice.checkStatus(2) || starryDevice.checkStatus(4)) && (findChannelById = ChannelManagerImpl.getInstance().findChannelById(starryDevice.getId())) != null) {
            findChannelById.teardown(EnumLinkStrategy.STRATEGY_HIGH_PERFORMANCE);
        }
    }

    public int balanceConnect(String str) {
        throw new RuntimeException("Invalid method");
    }

    public boolean checkConnectState(StarryDevice starryDevice, int i) {
        StarryDevice starryDevice2;
        if (starryDevice == null || (starryDevice2 = connectDevice.get(starryDevice.getId())) == null) {
            return false;
        }
        return starryDevice2.checkStatus(i);
    }

    public int connect(StarryDevice starryDevice, int i) {
        LogUtil.i(starryDevice.getId() + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA + i + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA + starryDevice.getStarryDevice().getCategoryName());
        if (i == 8) {
            if (checkConnectState(starryDevice, 2048)) {
                return ConnectErrorCode.CONNECT_ALREADY_CONNECTED_STDEVICE;
            }
            return this.gateWay.connect(starryDevice, i);
        } else if (i == 1) {
            if (checkConnectState(starryDevice, 256)) {
                return ConnectErrorCode.CONNECT_ALREADY_CONNECTED_STDEVICE;
            }
            return this.gateWay.connect(starryDevice, i);
        } else if (i == 2) {
            if (checkConnectState(starryDevice, 512)) {
                starryDevice.increment(Utils.getCallingPid(), i);
                return ConnectErrorCode.CONNECT_ALREADY_CONNECTED_STDEVICE;
            } else if (checkConnectState(starryDevice, 256)) {
                starryDevice.increment(Utils.getCallingPid(), 0);
                return this.gateWay.connect(starryDevice, i);
            } else {
                LogUtil.e("ble no connection");
                return ConnectErrorCode.CONNECT_TYPE_ERROR;
            }
        } else if (i == 4) {
            if (checkConnectState(starryDevice, 1024)) {
                starryDevice.increment(Utils.getCallingPid(), i);
                return ConnectErrorCode.CONNECT_ALREADY_CONNECTED_STDEVICE;
            } else if (checkConnectState(starryDevice, 256)) {
                starryDevice.increment(Utils.getCallingPid(), 0);
                return this.gateWay.connect(starryDevice, i);
            } else {
                LogUtil.e("ble no connection");
                return ConnectErrorCode.CONNECT_TYPE_ERROR;
            }
        } else if (i == 32) {
            if (!checkConnectState(starryDevice, 4096)) {
                return this.gateWay.connect(starryDevice, i);
            }
            starryDevice.increment(Utils.getCallingPid(), i);
            return ConnectErrorCode.CONNECT_ALREADY_CONNECTED_STDEVICE;
        } else if (i != 16) {
            return ConnectErrorCode.CONNECT_TYPE_ERROR;
        } else {
            if (!checkConnectState(starryDevice, 16)) {
                return this.gateWay.connect(starryDevice, i);
            }
            starryDevice.increment(Utils.getCallingPid(), i);
            return ConnectErrorCode.CONNECT_ALREADY_CONNECTED_STDEVICE;
        }
    }

    public int disBalanceConnect(String str) {
        throw new RuntimeException("Invalid method");
    }

    public int disconnect(String str, int i) {
        StarryDevice starryDevice = connectDevice.get(str);
        if (starryDevice == null) {
            LogUtil.i("device == null, deviceId = " + str);
            return ConnectErrorCode.CONNECT_NOT_FOUND_DEVICEID;
        }
        LogUtil.i(starryDevice.getId() + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA + i + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA + starryDevice.getStarryDevice().getCategoryName());
        starryDevice.decrement(Utils.getCallingPid(), Integer.valueOf(i));
        if (i != 2 && i != 4 && i != 16 && ((i != 1 || starryDevice.getTerminalType() != 2) && i != 32)) {
            return ConnectErrorCode.CONNECT_TYPE_ERROR;
        }
        int connectCount = getConnectCount(starryDevice.getId(), i);
        LogUtil.i("deviceId: " + str + " , ConnectCount: " + connectCount);
        if (connectCount >= 1) {
            return ConnectErrorCode.CONNECT_DISCONNECTED_STDEVICE;
        }
        preDisConnect(starryDevice);
        starryDevice.removeStatus(i);
        return this.gateWay.disconnect(starryDevice, i);
    }

    public int disconnectAll(String str) {
        StarryDevice starryDevice = connectDevice.get(str);
        if (starryDevice == null) {
            LogUtil.i("device == null, deviceId = " + str);
            return ConnectErrorCode.CONNECT_NOT_FOUND_DEVICEID;
        } else if (Utils.isSystemApp(Utils.getContext(), Binder.getCallingPid()) || Arrays.asList(this.whiteList).contains(Utils.getCallingPkgName())) {
            int disconnect = this.gateWay.disconnect(starryDevice, -1);
            LogUtil.d("disconnect all : " + disconnect);
            return ConnectErrorCode.CONNECT_NORMAL;
        } else {
            LogUtil.i("permission denial");
            return ConnectErrorCode.PERMISSION_DENIAL;
        }
    }

    public StarryDevice findConnectDevice(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return connectDevice.get(str);
    }

    public List<StarryDevice> getBondedDevice() {
        List<StDevice> bondedDevices = StarrynetApiImpl.getInstance().getBondedDevices();
        if (bondedDevices == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < bondedDevices.size(); i++) {
            arrayList.add(Utils.convert(bondedDevices.get(i)));
        }
        return arrayList;
    }

    public Map<String, StarryDevice> getConnectDevice() {
        return connectDevice;
    }

    public List<StarryDevice> getConnectedDevice() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry next : connectDevice.entrySet()) {
            if (((StarryDevice) next.getValue()).getVirtualChannelStatus() != 0) {
                StarryDevice clone = ((StarryDevice) next.getValue()).clone();
                clone.setStatus(clone.getVirtualChannelStatus());
                arrayList.add(clone);
            }
        }
        return arrayList;
    }

    public int getCurDeviceState(String str) {
        StarryDevice findConnectDevice = findConnectDevice(str);
        return findConnectDevice != null ? (findConnectDevice.checkStatus(1024) || findConnectDevice.checkStatus(512)) ? findConnectDevice.checkStatus(256) ? 3 : 2 : findConnectDevice.checkStatus(256) ? 1 : 0 : ConnectErrorCode.CONNECT_NOT_FOUND_DEVICEID;
    }

    public int getDeviceConnectable(String str) {
        return StarrynetApiImpl.getInstance().getDeviceConnectable(Utils.hexString2Bytes(str));
    }

    public int getPreDeviceState(String str) {
        StarryDevice findConnectDevice = findConnectDevice(str);
        return findConnectDevice != null ? findConnectDevice.getPreState() : ConnectErrorCode.CONNECT_NOT_FOUND_DEVICEID;
    }

    public StarryDevice getSelfDevice() {
        StDevice ownDevice = StarrynetApiImpl.getInstance().getOwnDevice();
        if (ownDevice != null) {
            return Utils.convert(ownDevice);
        }
        return null;
    }

    public int getVirtualChannelStatus(String str) {
        StarryDevice findConnectDevice = findConnectDevice(str);
        if (findConnectDevice == null) {
            return 0;
        }
        return findConnectDevice.getVirtualChannelStatus();
    }

    public boolean isBRConnect(String str) {
        StarryDevice starryDevice = connectDevice.get(str);
        if (starryDevice == null) {
            return false;
        }
        return starryDevice.checkStatus(2048);
    }

    public boolean isBalanceConnect(String str) {
        StarryDevice starryDevice = connectDevice.get(str);
        if (starryDevice == null) {
            return false;
        }
        return starryDevice.checkStatus(4096);
    }

    public void registerDeviceListener(IDeviceListenerInner iDeviceListenerInner) {
        StarrynetApiImpl.getInstance().registerDeviceListener(iDeviceListenerInner);
    }

    public void removeConnectDevice() {
        LogUtil.d("removeConnectDevice : " + connectDevice);
        connectDevice.clear();
    }

    public int setDeviceConnectable(boolean z, int i, String str) {
        return StarrynetApiImpl.getInstance().setDeviceConnectable(z, i, str);
    }

    @Deprecated
    public int connect(String str, int i) {
        LogUtil.d("无效方法");
        return 0;
    }
}
