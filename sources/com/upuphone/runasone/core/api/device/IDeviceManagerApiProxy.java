package com.upuphone.runasone.core.api.device;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.upuphone.hub.Hub;
import com.upuphone.hub.HubRemoteException;
import com.upuphone.hub.HubTargetException;
import com.upuphone.runasone.constant.Constants;
import com.upuphone.runasone.core.api.ApiConstant;
import com.upuphone.runasone.core.api.discovery.IDiscoveryCallback;
import com.upuphone.runasone.core.api.discovery.IDiscoveryCallbackAdapter;
import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.starrynet.api.bean.DiscoveryFilter;
import com.upuphone.starrynet.api.bean.DiscoverySettings;
import com.upuphone.starrynet.payload.PayloadConstant;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.lang.reflect.Type;
import java.util.List;

public final class IDeviceManagerApiProxy implements IDeviceManagerApi {
    private final Gson gson = new Gson();
    private Hub hub;

    public int balanceConnect(String str) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "balanceConnect");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", ApiConstant.ABILITY_DEVICES);
        bundle.putString(Constants.DEVICE_ID, str);
        try {
            this.hub.transfer(bundle, bundle2);
            return bundle2.getInt("result");
        } catch (RemoteException e) {
            throw new HubRemoteException(e);
        } catch (UnsupportedOperationException e2) {
            if ("target method not found".equals(e2.getMessage())) {
                throw new HubTargetException("target method not found");
            }
            throw e2;
        }
    }

    public int cancelAuth(String str) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "cancelAuth");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", ApiConstant.ABILITY_DEVICES);
        bundle.putString(Constants.DEVICE_ID, str);
        try {
            this.hub.transfer(bundle, bundle2);
            return bundle2.getInt("result");
        } catch (RemoteException e) {
            throw new HubRemoteException(e);
        } catch (UnsupportedOperationException e2) {
            if ("target method not found".equals(e2.getMessage())) {
                throw new HubTargetException("target method not found");
            }
            throw e2;
        }
    }

    public int connect(String str, int i) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "connect");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", ApiConstant.ABILITY_DEVICES);
        bundle.putString(Constants.DEVICE_ID, str);
        bundle.putInt("type", i);
        try {
            this.hub.transfer(bundle, bundle2);
            return bundle2.getInt("result");
        } catch (RemoteException e) {
            throw new HubRemoteException(e);
        } catch (UnsupportedOperationException e2) {
            if ("target method not found".equals(e2.getMessage())) {
                throw new HubTargetException("target method not found");
            }
            throw e2;
        }
    }

    public void createBond(String str) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "createBond");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", ApiConstant.ABILITY_DEVICES);
        bundle.putString(Constants.DEVICE_ID, str);
        try {
            this.hub.transfer(bundle, bundle2);
        } catch (RemoteException e) {
            throw new HubRemoteException(e);
        } catch (UnsupportedOperationException e2) {
            if ("target method not found".equals(e2.getMessage())) {
                throw new HubTargetException("target method not found");
            }
            throw e2;
        }
    }

    public int disBalanceConnect(String str) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "disBalanceConnect");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", ApiConstant.ABILITY_DEVICES);
        bundle.putString(Constants.DEVICE_ID, str);
        try {
            this.hub.transfer(bundle, bundle2);
            return bundle2.getInt("result");
        } catch (RemoteException e) {
            throw new HubRemoteException(e);
        } catch (UnsupportedOperationException e2) {
            if ("target method not found".equals(e2.getMessage())) {
                throw new HubTargetException("target method not found");
            }
            throw e2;
        }
    }

    public void disableFastConnect() {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "disableFastConnect");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", ApiConstant.ABILITY_DEVICES);
        try {
            this.hub.transfer(bundle, bundle2);
        } catch (RemoteException e) {
            throw new HubRemoteException(e);
        } catch (UnsupportedOperationException e2) {
            if ("target method not found".equals(e2.getMessage())) {
                throw new HubTargetException("target method not found");
            }
            throw e2;
        }
    }

    public int disconnect(String str, int i) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "disconnect");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", ApiConstant.ABILITY_DEVICES);
        bundle.putString(Constants.DEVICE_ID, str);
        bundle.putInt("type", i);
        try {
            this.hub.transfer(bundle, bundle2);
            return bundle2.getInt("result");
        } catch (RemoteException e) {
            throw new HubRemoteException(e);
        } catch (UnsupportedOperationException e2) {
            if ("target method not found".equals(e2.getMessage())) {
                throw new HubTargetException("target method not found");
            }
            throw e2;
        }
    }

    public int disconnectAll(String str) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "disconnectAll");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", ApiConstant.ABILITY_DEVICES);
        bundle.putString(Constants.DEVICE_ID, str);
        try {
            this.hub.transfer(bundle, bundle2);
            return bundle2.getInt("result");
        } catch (RemoteException e) {
            throw new HubRemoteException(e);
        } catch (UnsupportedOperationException e2) {
            if ("target method not found".equals(e2.getMessage())) {
                throw new HubTargetException("target method not found");
            }
            throw e2;
        }
    }

    public void enableFastConnect() {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "enableFastConnect");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", ApiConstant.ABILITY_DEVICES);
        try {
            this.hub.transfer(bundle, bundle2);
        } catch (RemoteException e) {
            throw new HubRemoteException(e);
        } catch (UnsupportedOperationException e2) {
            if ("target method not found".equals(e2.getMessage())) {
                throw new HubTargetException("target method not found");
            }
            throw e2;
        }
    }

    public int enableFastConnectWithTimeOut(long j) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "enableFastConnectWithTimeOut");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", ApiConstant.ABILITY_DEVICES);
        bundle.putLong("timeoutMillis", j);
        try {
            this.hub.transfer(bundle, bundle2);
            return bundle2.getInt("result");
        } catch (RemoteException e) {
            throw new HubRemoteException(e);
        } catch (UnsupportedOperationException e2) {
            if ("target method not found".equals(e2.getMessage())) {
                throw new HubTargetException("target method not found");
            }
            throw e2;
        }
    }

    public List<StarryDevice> getBondedDevice() {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "getBondedDevice");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", ApiConstant.ABILITY_DEVICES);
        try {
            this.hub.transfer(bundle, bundle2);
            Type type = new TypeToken<List<StarryDevice>>() {
            }.getType();
            return (List) this.gson.fromJson(bundle2.getString("result"), type);
        } catch (RemoteException e) {
            throw new HubRemoteException(e);
        } catch (UnsupportedOperationException e2) {
            if ("target method not found".equals(e2.getMessage())) {
                throw new HubTargetException("target method not found");
            }
            throw e2;
        }
    }

    public List<StarryDevice> getConnectedDevice() {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "getConnectedDevice");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", ApiConstant.ABILITY_DEVICES);
        try {
            this.hub.transfer(bundle, bundle2);
            Type type = new TypeToken<List<StarryDevice>>() {
            }.getType();
            return (List) this.gson.fromJson(bundle2.getString("result"), type);
        } catch (RemoteException e) {
            throw new HubRemoteException(e);
        } catch (UnsupportedOperationException e2) {
            if ("target method not found".equals(e2.getMessage())) {
                throw new HubTargetException("target method not found");
            }
            throw e2;
        }
    }

    public List<StarryDevice> getConnectedDevices(int i) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "getConnectedDevices");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", ApiConstant.ABILITY_DEVICES);
        bundle.putInt("linkType", i);
        try {
            this.hub.transfer(bundle, bundle2);
            Type type = new TypeToken<List<StarryDevice>>() {
            }.getType();
            return (List) this.gson.fromJson(bundle2.getString("result"), type);
        } catch (RemoteException e) {
            throw new HubRemoteException(e);
        } catch (UnsupportedOperationException e2) {
            if ("target method not found".equals(e2.getMessage())) {
                throw new HubTargetException("target method not found");
            }
            throw e2;
        }
    }

    public int getCurDeviceState(String str) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "getCurDeviceState");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", ApiConstant.ABILITY_DEVICES);
        bundle.putString(Constants.DEVICE_ID, str);
        try {
            this.hub.transfer(bundle, bundle2);
            return bundle2.getInt("result");
        } catch (RemoteException e) {
            throw new HubRemoteException(e);
        } catch (UnsupportedOperationException e2) {
            if ("target method not found".equals(e2.getMessage())) {
                throw new HubTargetException("target method not found");
            }
            throw e2;
        }
    }

    public int getDeviceConnectable(String str) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "getDeviceConnectable");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", ApiConstant.ABILITY_DEVICES);
        bundle.putString(Constants.DEVICE_ID, str);
        try {
            this.hub.transfer(bundle, bundle2);
            return bundle2.getInt("result");
        } catch (RemoteException e) {
            throw new HubRemoteException(e);
        } catch (UnsupportedOperationException e2) {
            if ("target method not found".equals(e2.getMessage())) {
                throw new HubTargetException("target method not found");
            }
            throw e2;
        }
    }

    public String getDeviceDetailInfo(String str, int i) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "getDeviceDetailInfo");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", ApiConstant.ABILITY_DEVICES);
        bundle.putString(Constants.DEVICE_ID, str);
        bundle.putInt("type", i);
        try {
            this.hub.transfer(bundle, bundle2);
            return bundle2.getString("result");
        } catch (RemoteException e) {
            throw new HubRemoteException(e);
        } catch (UnsupportedOperationException e2) {
            if ("target method not found".equals(e2.getMessage())) {
                throw new HubTargetException("target method not found");
            }
            throw e2;
        }
    }

    public int getPreDeviceState(String str) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "getPreDeviceState");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", ApiConstant.ABILITY_DEVICES);
        bundle.putString(Constants.DEVICE_ID, str);
        try {
            this.hub.transfer(bundle, bundle2);
            return bundle2.getInt("result");
        } catch (RemoteException e) {
            throw new HubRemoteException(e);
        } catch (UnsupportedOperationException e2) {
            if ("target method not found".equals(e2.getMessage())) {
                throw new HubTargetException("target method not found");
            }
            throw e2;
        }
    }

    public StarryDevice getSelfDevice() {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "getSelfDevice");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", ApiConstant.ABILITY_DEVICES);
        try {
            this.hub.transfer(bundle, bundle2);
            Type type = new TypeToken<StarryDevice>() {
            }.getType();
            return (StarryDevice) this.gson.fromJson(bundle2.getString("result"), type);
        } catch (RemoteException e) {
            throw new HubRemoteException(e);
        } catch (UnsupportedOperationException e2) {
            if ("target method not found".equals(e2.getMessage())) {
                throw new HubTargetException("target method not found");
            }
            throw e2;
        }
    }

    public List<String> getSupportAbility(String str) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "getSupportAbility");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", ApiConstant.ABILITY_DEVICES);
        bundle.putString(Constants.DEVICE_ID, str);
        try {
            this.hub.transfer(bundle, bundle2);
            Type type = new TypeToken<List<String>>() {
            }.getType();
            return (List) this.gson.fromJson(bundle2.getString("result"), type);
        } catch (RemoteException e) {
            throw new HubRemoteException(e);
        } catch (UnsupportedOperationException e2) {
            if ("target method not found".equals(e2.getMessage())) {
                throw new HubTargetException("target method not found");
            }
            throw e2;
        }
    }

    public int getVirtualChannelStatus(String str) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "getVirtualChannelStatus");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", ApiConstant.ABILITY_DEVICES);
        bundle.putString(Constants.DEVICE_ID, str);
        try {
            this.hub.transfer(bundle, bundle2);
            return bundle2.getInt("result");
        } catch (RemoteException e) {
            throw new HubRemoteException(e);
        } catch (UnsupportedOperationException e2) {
            if ("target method not found".equals(e2.getMessage())) {
                throw new HubTargetException("target method not found");
            }
            throw e2;
        }
    }

    public String[] getWifiInfo() {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "getWifiInfo");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", ApiConstant.ABILITY_DEVICES);
        try {
            this.hub.transfer(bundle, bundle2);
            return bundle2.getStringArray("result");
        } catch (RemoteException e) {
            throw new HubRemoteException(e);
        } catch (UnsupportedOperationException e2) {
            if ("target method not found".equals(e2.getMessage())) {
                throw new HubTargetException("target method not found");
            }
            throw e2;
        }
    }

    public boolean isBRConnect(String str) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "isBRConnect");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", ApiConstant.ABILITY_DEVICES);
        bundle.putString(Constants.DEVICE_ID, str);
        try {
            this.hub.transfer(bundle, bundle2);
            return bundle2.getBoolean("result");
        } catch (RemoteException e) {
            throw new HubRemoteException(e);
        } catch (UnsupportedOperationException e2) {
            if ("target method not found".equals(e2.getMessage())) {
                throw new HubTargetException("target method not found");
            }
            throw e2;
        }
    }

    public boolean isBalanceConnect(String str) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "isBalanceConnect");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", ApiConstant.ABILITY_DEVICES);
        bundle.putString(Constants.DEVICE_ID, str);
        try {
            this.hub.transfer(bundle, bundle2);
            return bundle2.getBoolean("result");
        } catch (RemoteException e) {
            throw new HubRemoteException(e);
        } catch (UnsupportedOperationException e2) {
            if ("target method not found".equals(e2.getMessage())) {
                throw new HubTargetException("target method not found");
            }
            throw e2;
        }
    }

    public void registerDeviceStatusListener(String str, IDeviceConnectCallback iDeviceConnectCallback) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "registerDeviceStatusListener");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", ApiConstant.ABILITY_DEVICES);
        bundle.putString(Constants.DEVICE_ID, str);
        if (iDeviceConnectCallback != null) {
            bundle.putBinder("callback", new IDeviceConnectCallbackAdapter(iDeviceConnectCallback));
        }
        try {
            this.hub.transfer(bundle, bundle2);
        } catch (RemoteException e) {
            throw new HubRemoteException(e);
        } catch (UnsupportedOperationException e2) {
            if ("target method not found".equals(e2.getMessage())) {
                throw new HubTargetException("target method not found");
            }
            throw e2;
        }
    }

    public void removeBond(String str) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "removeBond");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", ApiConstant.ABILITY_DEVICES);
        bundle.putString(Constants.DEVICE_ID, str);
        try {
            this.hub.transfer(bundle, bundle2);
        } catch (RemoteException e) {
            throw new HubRemoteException(e);
        } catch (UnsupportedOperationException e2) {
            if ("target method not found".equals(e2.getMessage())) {
                throw new HubTargetException("target method not found");
            }
            throw e2;
        }
    }

    public void requestAuth(String str, byte[] bArr) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "requestAuth");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", ApiConstant.ABILITY_DEVICES);
        bundle.putString(Constants.DEVICE_ID, str);
        bundle.putByteArray("data", bArr);
        try {
            this.hub.transfer(bundle, bundle2);
        } catch (RemoteException e) {
            throw new HubRemoteException(e);
        } catch (UnsupportedOperationException e2) {
            if ("target method not found".equals(e2.getMessage())) {
                throw new HubTargetException("target method not found");
            }
            throw e2;
        }
    }

    public int requestConnect(byte[] bArr) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "requestConnect");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", ApiConstant.ABILITY_DEVICES);
        bundle.putByteArray(PayloadConstant.KEY_PARAMS, bArr);
        try {
            this.hub.transfer(bundle, bundle2);
            return bundle2.getInt("result");
        } catch (RemoteException e) {
            throw new HubRemoteException(e);
        } catch (UnsupportedOperationException e2) {
            if ("target method not found".equals(e2.getMessage())) {
                throw new HubTargetException("target method not found");
            }
            throw e2;
        }
    }

    public int requestConnectWithTime(byte[] bArr, long j) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "requestConnectWithTime");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", ApiConstant.ABILITY_DEVICES);
        bundle.putByteArray(PayloadConstant.KEY_PARAMS, bArr);
        bundle.putLong("timeoutMillis", j);
        try {
            this.hub.transfer(bundle, bundle2);
            return bundle2.getInt("result");
        } catch (RemoteException e) {
            throw new HubRemoteException(e);
        } catch (UnsupportedOperationException e2) {
            if ("target method not found".equals(e2.getMessage())) {
                throw new HubTargetException("target method not found");
            }
            throw e2;
        }
    }

    public int setAdvertiseEnableMode(int i) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "setAdvertiseEnableMode");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", ApiConstant.ABILITY_DEVICES);
        bundle.putInt(RtspHeaders.Values.MODE, i);
        try {
            this.hub.transfer(bundle, bundle2);
            return bundle2.getInt("result");
        } catch (RemoteException e) {
            throw new HubRemoteException(e);
        } catch (UnsupportedOperationException e2) {
            if ("target method not found".equals(e2.getMessage())) {
                throw new HubTargetException("target method not found");
            }
            throw e2;
        }
    }

    public int setDeviceConnectable(boolean z, int i, String str) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "setDeviceConnectable");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", ApiConstant.ABILITY_DEVICES);
        bundle.putBoolean("enable", z);
        bundle.putInt("terminalType", i);
        bundle.putString("modelID", str);
        try {
            this.hub.transfer(bundle, bundle2);
            return bundle2.getInt("result");
        } catch (RemoteException e) {
            throw new HubRemoteException(e);
        } catch (UnsupportedOperationException e2) {
            if ("target method not found".equals(e2.getMessage())) {
                throw new HubTargetException("target method not found");
            }
            throw e2;
        }
    }

    public void setDiscoveryFilter(DiscoveryFilter discoveryFilter) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "setDiscoveryFilter");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", ApiConstant.ABILITY_DEVICES);
        bundle.putString("filter", this.gson.toJson((Object) discoveryFilter));
        try {
            this.hub.transfer(bundle, bundle2);
        } catch (RemoteException e) {
            throw new HubRemoteException(e);
        } catch (UnsupportedOperationException e2) {
            if ("target method not found".equals(e2.getMessage())) {
                throw new HubTargetException("target method not found");
            }
            throw e2;
        }
    }

    public int setFastConnectProcess(int i) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "setFastConnectProcess");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", ApiConstant.ABILITY_DEVICES);
        bundle.putInt("type", i);
        try {
            this.hub.transfer(bundle, bundle2);
            return bundle2.getInt("result");
        } catch (RemoteException e) {
            throw new HubRemoteException(e);
        } catch (UnsupportedOperationException e2) {
            if ("target method not found".equals(e2.getMessage())) {
                throw new HubTargetException("target method not found");
            }
            throw e2;
        }
    }

    public void setHub(Hub hub2) {
        this.hub = hub2;
    }

    public int setReconnectEnable(boolean z) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "setReconnectEnable");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", ApiConstant.ABILITY_DEVICES);
        bundle.putBoolean("enable", z);
        try {
            this.hub.transfer(bundle, bundle2);
            return bundle2.getInt("result");
        } catch (RemoteException e) {
            throw new HubRemoteException(e);
        } catch (UnsupportedOperationException e2) {
            if ("target method not found".equals(e2.getMessage())) {
                throw new HubTargetException("target method not found");
            }
            throw e2;
        }
    }

    public void startDiscovery(DiscoveryFilter discoveryFilter, DiscoverySettings discoverySettings, IDiscoveryCallback iDiscoveryCallback) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "startDiscovery");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", ApiConstant.ABILITY_DEVICES);
        bundle.putString("filter", this.gson.toJson((Object) discoveryFilter));
        bundle.putString("settings", this.gson.toJson((Object) discoverySettings));
        if (iDiscoveryCallback != null) {
            bundle.putBinder("callback", new IDiscoveryCallbackAdapter(iDiscoveryCallback));
        }
        try {
            this.hub.transfer(bundle, bundle2);
        } catch (RemoteException e) {
            throw new HubRemoteException(e);
        } catch (UnsupportedOperationException e2) {
            if ("target method not found".equals(e2.getMessage())) {
                throw new HubTargetException("target method not found");
            }
            throw e2;
        }
    }

    public int startMultiDeviceFound() {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "startMultiDeviceFound");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", ApiConstant.ABILITY_DEVICES);
        try {
            this.hub.transfer(bundle, bundle2);
            return bundle2.getInt("result");
        } catch (RemoteException e) {
            throw new HubRemoteException(e);
        } catch (UnsupportedOperationException e2) {
            if ("target method not found".equals(e2.getMessage())) {
                throw new HubTargetException("target method not found");
            }
            throw e2;
        }
    }

    public void stopDiscovery() {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "stopDiscovery");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", ApiConstant.ABILITY_DEVICES);
        try {
            this.hub.transfer(bundle, bundle2);
        } catch (RemoteException e) {
            throw new HubRemoteException(e);
        } catch (UnsupportedOperationException e2) {
            if ("target method not found".equals(e2.getMessage())) {
                throw new HubTargetException("target method not found");
            }
            throw e2;
        }
    }

    public int stopMultiDeviceFound(boolean z) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "stopMultiDeviceFound");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", ApiConstant.ABILITY_DEVICES);
        bundle.putBoolean("reAdv", z);
        try {
            this.hub.transfer(bundle, bundle2);
            return bundle2.getInt("result");
        } catch (RemoteException e) {
            throw new HubRemoteException(e);
        } catch (UnsupportedOperationException e2) {
            if ("target method not found".equals(e2.getMessage())) {
                throw new HubTargetException("target method not found");
            }
            throw e2;
        }
    }

    public void unRegisterDeviceStatusListener(String str) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "unRegisterDeviceStatusListener");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", ApiConstant.ABILITY_DEVICES);
        bundle.putString(Constants.DEVICE_ID, str);
        try {
            this.hub.transfer(bundle, bundle2);
        } catch (RemoteException e) {
            throw new HubRemoteException(e);
        } catch (UnsupportedOperationException e2) {
            if ("target method not found".equals(e2.getMessage())) {
                throw new HubTargetException("target method not found");
            }
            throw e2;
        }
    }

    public int updateAdvParams(byte[] bArr) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "updateAdvParams");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", ApiConstant.ABILITY_DEVICES);
        bundle.putByteArray("data", bArr);
        try {
            this.hub.transfer(bundle, bundle2);
            return bundle2.getInt("result");
        } catch (RemoteException e) {
            throw new HubRemoteException(e);
        } catch (UnsupportedOperationException e2) {
            if ("target method not found".equals(e2.getMessage())) {
                throw new HubTargetException("target method not found");
            }
            throw e2;
        }
    }
}
