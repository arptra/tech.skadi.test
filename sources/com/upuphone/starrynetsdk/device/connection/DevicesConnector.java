package com.upuphone.starrynetsdk.device.connection;

import com.upuphone.hub.HubRemoteException;
import com.upuphone.hub.HubTargetException;
import com.upuphone.runasone.ability.EnumAbility;
import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.starrynetsdk.api.ErrorCode;
import com.upuphone.starrynetsdk.api.SNSLog;
import com.upuphone.starrynetsdk.device.DeviceAbility;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class DevicesConnector extends DeviceAbility {
    public static final int STATE_AUTH = 1;
    public static final int STATE_AUTH_SUCCESS = 2;
    public static final int STATE_BONDED = 4;
    public static final int STATE_BONDING = 3;
    public static final int STATE_RESET = 5;
    public static final int STATE_UN_BOND = 0;
    private static final String TAG = "DevicesConnector";
    public static final int TYPE_BR_EDR_MAC = 8;
    public static final int TYPE_CATEGORY_ID = 3;
    public static final int TYPE_CATEGORY_NAME = 4;
    public static final int TYPE_COMPANY_ID = 1;
    public static final int TYPE_COMPANY_NAME = 2;
    public static final int TYPE_CONNECT_AP = 4;
    public static final int TYPE_CONNECT_BLE = 1;
    public static final int TYPE_CONNECT_BR = 8;
    public static final int TYPE_CONNECT_P2P = 2;
    public static final int TYPE_DEVICE_NAME = 0;
    public static final int TYPE_MODEL_ID = 5;
    public static final int TYPE_MODEL_NAME = 6;
    public static final int TYPE_WIFI_MAC = 7;
    private static DevicesConnector devicesConnector = new DevicesConnector();
    private final ConnectionListenerManager listenerManager = ConnectionListenerManager.getInstance();

    @Retention(RetentionPolicy.SOURCE)
    public @interface ConnectType {
    }

    public static DevicesConnector getInstance() {
        return devicesConnector;
    }

    public int balanceConnect(String str) {
        if (!isEnable()) {
            SNSLog.e(TAG, "Service unavailable,isBalanceConnect failed.");
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        }
        try {
            return this.api.balanceConnect(str);
        } catch (HubRemoteException e) {
            SNSLog.e(TAG, "disconnectDevice failed.", e);
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        } catch (HubTargetException e2) {
            SNSLog.e(TAG, "disconnectDevice failed.", e2);
            return ErrorCode.CODE_TARGET_UNAVAILABLE;
        }
    }

    public int cancelAuth(String str) {
        if (!isEnable()) {
            SNSLog.e(TAG, "Service unavailable,cancelAuth failed.");
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        }
        try {
            return this.api.cancelAuth(str);
        } catch (HubRemoteException e) {
            SNSLog.e(TAG, "cancelAuth failed.", e);
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        } catch (HubTargetException e2) {
            SNSLog.e(TAG, "cancelAuth failed.", e2);
            return ErrorCode.CODE_TARGET_UNAVAILABLE;
        }
    }

    public boolean checkConnectionState(int i, int i2) {
        return (i & i2) == i2;
    }

    public int connect(String str, int i) {
        StarryDevice connectedDevice;
        if (!isEnable()) {
            SNSLog.e(TAG, "Service unavailable,connect failed.");
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        }
        try {
            int connect = this.api.connect(str, i);
            if (connect == 202005 && (connectedDevice = getConnectedDevice(str)) != null) {
                SNSLog.d(TAG, str + " already connect with type " + i);
                this.listenerManager.postConnectedChanged(connectedDevice);
            }
            return connect;
        } catch (HubRemoteException e) {
            SNSLog.e(TAG, "connect failed.", e);
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        } catch (HubTargetException e2) {
            SNSLog.e(TAG, "connect failed.", e2);
            return ErrorCode.CODE_TARGET_UNAVAILABLE;
        }
    }

    public StarryDevice connectedDevice() {
        List<StarryDevice> connectedDevices = getConnectedDevices();
        if (connectedDevices == null || connectedDevices.isEmpty()) {
            return null;
        }
        return connectedDevices.get(0);
    }

    public int createBond(String str) {
        if (!isEnable()) {
            SNSLog.e(TAG, "Service unavailable,createBond failed.");
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        }
        try {
            this.api.createBond(str);
            return 0;
        } catch (HubRemoteException e) {
            SNSLog.e(TAG, "createBond failed.", e);
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        } catch (HubTargetException e2) {
            SNSLog.e(TAG, "createBond failed.", e2);
            return ErrorCode.CODE_TARGET_UNAVAILABLE;
        }
    }

    public int disBalanceConnect(String str) {
        if (!isEnable()) {
            SNSLog.e(TAG, "Service unavailable,isBalanceConnect failed.");
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        }
        try {
            return this.api.disBalanceConnect(str);
        } catch (HubRemoteException e) {
            SNSLog.e(TAG, "disconnectDevice failed.", e);
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        } catch (HubTargetException e2) {
            SNSLog.e(TAG, "disconnectDevice failed.", e2);
            return ErrorCode.CODE_TARGET_UNAVAILABLE;
        }
    }

    public int disconnect(String str, int i) {
        if (!isEnable()) {
            SNSLog.e(TAG, "Service unavailable,disconnect failed.");
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        }
        try {
            return this.api.disconnect(str, i);
        } catch (HubRemoteException e) {
            SNSLog.e(TAG, "disconnect failed.", e);
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        } catch (HubTargetException e2) {
            SNSLog.e(TAG, "disconnect failed.", e2);
            return ErrorCode.CODE_TARGET_UNAVAILABLE;
        }
    }

    public int disconnectDevice(String str) {
        if (!isEnable()) {
            SNSLog.e(TAG, "Service unavailable,disconnect failed.");
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        }
        try {
            return this.api.disconnectAll(str);
        } catch (HubRemoteException e) {
            SNSLog.e(TAG, "disconnectDevice failed.", e);
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        } catch (HubTargetException e2) {
            SNSLog.e(TAG, "disconnectDevice failed.", e2);
            return ErrorCode.CODE_TARGET_UNAVAILABLE;
        }
    }

    public List<StarryDevice> getBondedDevices() {
        if (!isEnable()) {
            SNSLog.e(TAG, "Service unavailable,getBondedDevices failed.");
            return null;
        }
        try {
            return this.api.getBondedDevice();
        } catch (HubRemoteException | HubTargetException e) {
            SNSLog.e(TAG, "getBondedDevices failed.", e);
            return null;
        }
    }

    public StarryDevice getConnectedDevice(String str) {
        List<StarryDevice> connectedDevices = getConnectedDevices();
        if (connectedDevices == null) {
            return null;
        }
        for (StarryDevice next : connectedDevices) {
            if (Objects.equals(str, next.getId())) {
                return next;
            }
        }
        return null;
    }

    public List<StarryDevice> getConnectedDevices() {
        if (!isEnable()) {
            SNSLog.e(TAG, "Service unavailable,getConnectedDevices failed.");
            return null;
        }
        try {
            return this.api.getConnectedDevice();
        } catch (HubRemoteException | HubTargetException e) {
            SNSLog.e(TAG, "getConnectedDevices failed.", e);
            return null;
        }
    }

    public int getConnectionState(String str) {
        if (!isEnable()) {
            SNSLog.e(TAG, "Service unavailable,getConnectionState failed.");
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        }
        try {
            return this.api.getVirtualChannelStatus(str);
        } catch (HubRemoteException e) {
            SNSLog.e(TAG, "getConnectionState failed.", e);
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        } catch (HubTargetException e2) {
            SNSLog.e(TAG, "getConnectionState failed.", e2);
            return ErrorCode.CODE_TARGET_UNAVAILABLE;
        }
    }

    public int getCurDeviceState(String str) {
        if (!isEnable()) {
            SNSLog.e(TAG, "Service unavailable,connect failed.");
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        }
        try {
            return this.api.getCurDeviceState(str);
        } catch (HubRemoteException e) {
            SNSLog.e(TAG, "getCurDeviceState failed.", e);
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        } catch (HubTargetException e2) {
            SNSLog.e(TAG, "getCurDeviceState failed.", e2);
            return ErrorCode.CODE_TARGET_UNAVAILABLE;
        }
    }

    public int getDeviceConnectable(String str) {
        if (!isEnable()) {
            SNSLog.e(TAG, "Service unavailable, getDeviceConnectable failed.");
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        }
        try {
            return this.api.getDeviceConnectable(str);
        } catch (HubRemoteException | HubTargetException e) {
            SNSLog.e(TAG, "getDeviceConnectable failed.", e);
            return ErrorCode.CODE_TARGET_UNAVAILABLE;
        }
    }

    public String getDeviceInfo(String str, int i) {
        if (!isEnable()) {
            SNSLog.e(TAG, "Service unavailable,getDeviceInfo failed.");
            return null;
        }
        try {
            return this.api.getDeviceDetailInfo(str, i);
        } catch (HubRemoteException | HubTargetException e) {
            SNSLog.e(TAG, "getDeviceInfo failed.", e);
            return null;
        }
    }

    public int getPreDeviceState(String str) {
        if (!isEnable()) {
            SNSLog.e(TAG, "Service unavailable,connect failed.");
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        }
        try {
            return this.api.getPreDeviceState(str);
        } catch (HubRemoteException e) {
            SNSLog.e(TAG, "getPreDeviceState failed.", e);
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        } catch (HubTargetException e2) {
            SNSLog.e(TAG, "getPreDeviceState failed.", e2);
            return ErrorCode.CODE_TARGET_UNAVAILABLE;
        }
    }

    public StarryDevice getSelfDevice() {
        if (!isEnable()) {
            SNSLog.e(TAG, "Service unavailable,getSelfDevice failed.");
            return null;
        }
        try {
            return this.api.getSelfDevice();
        } catch (HubRemoteException | HubTargetException e) {
            SNSLog.e(TAG, "getSelfDevice failed.", e);
            return null;
        }
    }

    public List<String> getSupportAbility(String str) {
        if (!isEnable()) {
            SNSLog.e(TAG, "Service unavailable,getSupportAbility failed.");
        }
        try {
            return this.api.getSupportAbility(str);
        } catch (Exception e) {
            SNSLog.e(TAG, "getSupportAbility failed.", e);
            return null;
        }
    }

    public List<StarryDevice> getSupportDevices(EnumAbility enumAbility) {
        List<StarryDevice> connectedDevices = getConnectedDevices();
        if (connectedDevices == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int size = connectedDevices.size();
        for (int i = 0; i < size; i++) {
            StarryDevice starryDevice = connectedDevices.get(i);
            if (starryDevice.getSupportAbility().contains(enumAbility)) {
                arrayList.add(starryDevice);
            }
        }
        return arrayList;
    }

    public String[] getWifiInfo() {
        if (!isEnable()) {
            SNSLog.e(TAG, "Service unavailable,getWifiInfo failed.");
            return null;
        }
        try {
            return this.api.getWifiInfo();
        } catch (HubRemoteException | HubTargetException e) {
            SNSLog.e(TAG, "getWifiInfo failed.", e);
            return null;
        }
    }

    public boolean isBRConnect(String str) {
        if (!isEnable()) {
            SNSLog.e(TAG, "Service unavailable");
            return false;
        }
        try {
            return this.api.isBRConnect(str);
        } catch (HubRemoteException | HubTargetException e) {
            SNSLog.e(TAG, "isBRConnect failed.", e);
            return false;
        }
    }

    public boolean isBalanceConnect(String str) {
        if (!isEnable()) {
            SNSLog.e(TAG, "Service unavailable,isBalanceConnect failed.");
            return false;
        }
        try {
            return this.api.isBalanceConnect(str);
        } catch (HubRemoteException | HubTargetException e) {
            SNSLog.e(TAG, "isBalanceConnect failed.", e);
            return false;
        }
    }

    public boolean isBonded(String str) {
        List<StarryDevice> bondedDevices = getBondedDevices();
        if (bondedDevices != null && !bondedDevices.isEmpty()) {
            for (StarryDevice id : bondedDevices) {
                if (Objects.equals(str, id.getId())) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isConnected(String str) {
        List<StarryDevice> connectedDevices = getConnectedDevices();
        if (connectedDevices != null && !connectedDevices.isEmpty()) {
            for (StarryDevice id : connectedDevices) {
                if (Objects.equals(str, id.getId())) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isEnhanceConnection(String str) {
        int connectionState = getConnectionState(str);
        return checkConnectionState(connectionState, 2) || checkConnectionState(connectionState, 4);
    }

    public int registerConnectionListener(ConnectionListener connectionListener) {
        return registerConnectionListener((String) null, connectionListener);
    }

    public int removeBond(String str) {
        if (!isEnable()) {
            SNSLog.e(TAG, "Service unavailable,removeBond failed.");
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        }
        try {
            this.api.removeBond(str);
            return 0;
        } catch (HubRemoteException e) {
            SNSLog.e(TAG, "removeBond failed.", e);
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        } catch (HubTargetException e2) {
            SNSLog.e(TAG, "removeBond failed.", e2);
            return ErrorCode.CODE_TARGET_UNAVAILABLE;
        }
    }

    public int requestAuth(String str, byte[] bArr) {
        if (!isEnable()) {
            SNSLog.e(TAG, "Service unavailable,requestAuth failed.");
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        }
        try {
            this.api.requestAuth(str, bArr);
            return 0;
        } catch (HubRemoteException e) {
            SNSLog.e(TAG, "requestAuth failed.", e);
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        } catch (HubTargetException e2) {
            SNSLog.e(TAG, "requestAuth failed.", e2);
            return ErrorCode.CODE_TARGET_UNAVAILABLE;
        }
    }

    public int setDeviceConnectable(boolean z, int i, String str) {
        if (!isEnable()) {
            SNSLog.e(TAG, "Service unavailable,setDeviceConnectable failed.");
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        }
        try {
            return this.api.setDeviceConnectable(z, i, str);
        } catch (HubRemoteException e) {
            SNSLog.e(TAG, "setDeviceConnectable failed.", e);
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        } catch (HubTargetException e2) {
            SNSLog.e(TAG, "setDeviceConnectable failed.", e2);
            return ErrorCode.CODE_TARGET_UNAVAILABLE;
        }
    }

    public int unRegisterConnectionListener(ConnectionListener connectionListener) {
        return unRegisterConnectionListener((String) null, connectionListener);
    }

    public int registerConnectionListener(String str, ConnectionListener connectionListener) {
        this.listenerManager.registerConnectionListener(str, connectionListener);
        return 0;
    }

    public int unRegisterConnectionListener(String str, ConnectionListener connectionListener) {
        this.listenerManager.unregisterConnectionListener(str, connectionListener);
        return 0;
    }
}
