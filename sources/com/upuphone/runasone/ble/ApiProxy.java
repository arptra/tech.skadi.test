package com.upuphone.runasone.ble;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.gson.Gson;
import com.upuphone.hub.Hub;
import com.upuphone.hub.HubRemoteException;
import com.upuphone.hub.HubTargetException;
import com.upuphone.runasone.constant.Constants;
import com.upuphone.runasone.core.api.ApiConstant;
import java.util.ArrayList;

public final class ApiProxy implements Api {
    private final Gson gson = new Gson();
    private Hub hub;

    public void connect(String str, ConnectConfig connectConfig) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "connect");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", ApiConstant.ABILITY_BLE);
        bundle.putString(Constants.DEVICE_ID, str);
        bundle.putString("config", this.gson.toJson((Object) connectConfig));
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

    public void disconnect(String str) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "disconnect");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", ApiConstant.ABILITY_BLE);
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

    public ArrayList<BleRawDevice> getFoundDeviceList(String str) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "getFoundDeviceList");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", ApiConstant.ABILITY_BLE);
        bundle.putString("vid", str);
        try {
            this.hub.transfer(bundle, bundle2);
            bundle2.setClassLoader(ApiProxy.class.getClassLoader());
            return bundle2.getParcelableArrayList("result");
        } catch (RemoteException e) {
            throw new HubRemoteException(e);
        } catch (UnsupportedOperationException e2) {
            if ("target method not found".equals(e2.getMessage())) {
                throw new HubTargetException("target method not found");
            }
            throw e2;
        }
    }

    public void initSession(String str, SessionConfig sessionConfig, InitSessionCallback initSessionCallback) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "initSession");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", ApiConstant.ABILITY_BLE);
        bundle.putString(Constants.DEVICE_ID, str);
        bundle.putString("sessionConfig", this.gson.toJson((Object) sessionConfig));
        if (initSessionCallback != null) {
            bundle.putBinder("callback", new InitSessionCallbackAdapter(initSessionCallback));
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

    public void openNotify(String str, String str2, OpenNotifyCallback openNotifyCallback) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "openNotify");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", ApiConstant.ABILITY_BLE);
        bundle.putString(Constants.DEVICE_ID, str);
        bundle.putString("notifyUUID", str2);
        if (openNotifyCallback != null) {
            bundle.putBinder("callback", new OpenNotifyCallbackAdapter(openNotifyCallback));
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

    public void read(String str, String str2, ReadCallback readCallback) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "read");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", ApiConstant.ABILITY_BLE);
        bundle.putString(Constants.DEVICE_ID, str);
        bundle.putString("readUUID", str2);
        if (readCallback != null) {
            bundle.putBinder("callback", new ReadCallbackAdapter(readCallback));
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

    public void registerDeviceCallback(String str, DeviceCallback deviceCallback) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "registerDeviceCallback");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", ApiConstant.ABILITY_BLE);
        bundle.putString(Constants.DEVICE_ID, str);
        if (deviceCallback != null) {
            bundle.putBinder("callback", new DeviceCallbackAdapter(deviceCallback));
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

    public void registerSessionCallback(String str, SessionCallback sessionCallback) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "registerSessionCallback");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", ApiConstant.ABILITY_BLE);
        bundle.putString(Constants.DEVICE_ID, str);
        if (sessionCallback != null) {
            bundle.putBinder("callback", new SessionCallbackAdapter(sessionCallback));
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

    public void setHub(Hub hub2) {
        this.hub = hub2;
    }

    public void setMtu(String str, int i, MtuCallback mtuCallback) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "setMtu");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", ApiConstant.ABILITY_BLE);
        bundle.putString(Constants.DEVICE_ID, str);
        bundle.putInt("mtuSize", i);
        if (mtuCallback != null) {
            bundle.putBinder("callback", new MtuCallbackAdapter(mtuCallback));
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

    public void unregisterDeviceCallback(String str) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "unregisterDeviceCallback");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", ApiConstant.ABILITY_BLE);
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

    public void unregisterSessionCallback(String str) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "unregisterSessionCallback");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", ApiConstant.ABILITY_BLE);
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

    public void write(String str, String str2, byte[] bArr, WriteCallback writeCallback) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "write");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", ApiConstant.ABILITY_BLE);
        bundle.putString(Constants.DEVICE_ID, str);
        bundle.putString("writeUUID", str2);
        bundle.putByteArray("data", bArr);
        if (writeCallback != null) {
            bundle.putBinder("callback", new WriteCallbackAdapter(writeCallback));
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
}
