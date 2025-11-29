package com.upuphone.runasone.core.api.sys;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.honey.account.view.web.WebJs;
import com.upuphone.hub.Hub;
import com.upuphone.hub.HubRemoteException;
import com.upuphone.hub.HubTargetException;
import com.upuphone.runasone.core.api.ApiConstant;
import com.upuphone.runasone.device.StarryDevice;
import java.lang.reflect.Type;
import java.util.List;

public final class ApiSystemProxy implements ApiSystem {
    private final Gson gson = new Gson();
    private Hub hub;

    public void dial(String str) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "dial");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", "systemApi");
        bundle.putString("number", str);
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

    public StarryDevice getAudioPlayDevice() {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "getAudioPlayDevice");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", "systemApi");
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

    public int getCallState() {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "getCallState");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", "systemApi");
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

    public List<StarryDevice> getListBrDevice() {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "getListBrDevice");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", "systemApi");
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

    public void operateAction(int i, int i2) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "operateAction");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", "systemApi");
        bundle.putInt("type", i);
        bundle.putInt(WebJs.ACTION, i2);
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

    public void registerCallBack(SystemCallBack systemCallBack) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "registerCallBack");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", "systemApi");
        if (systemCallBack != null) {
            bundle.putBinder("callBack", new SystemCallBackAdapter(systemCallBack));
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

    public int switchAudioPlayDevice(StarryDevice starryDevice) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "switchAudioPlayDevice");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", "systemApi");
        bundle.putString("device", this.gson.toJson((Object) starryDevice));
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

    public void unRegisterCallBack(SystemCallBack systemCallBack) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "unRegisterCallBack");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", "systemApi");
        bundle.putString("callBack", this.gson.toJson((Object) systemCallBack));
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
