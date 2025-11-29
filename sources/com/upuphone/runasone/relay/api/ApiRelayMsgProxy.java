package com.upuphone.runasone.relay.api;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.upuphone.hub.Hub;
import com.upuphone.hub.HubRemoteException;
import com.upuphone.hub.HubTargetException;
import com.upuphone.runasone.ArrayData;
import com.upuphone.runasone.api.ApiConstant;
import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.runasone.relay.StarryParam;
import com.upuphone.runasone.relay.StarryTag;
import com.upuphone.runasone.relay.util.RelayConst;
import com.upuphone.starrynet.payload.PayloadConstant;
import java.lang.reflect.Type;
import java.util.List;

public final class ApiRelayMsgProxy implements ApiRelayMsg {
    private final Gson gson = new Gson();
    private Hub hub;

    public List<StarryDevice> getRelayDeviceList(String str) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "getRelayDeviceList");
        bundle.putString("component", RelayConst.RELAY_COMP);
        bundle.putString("ability", "abilityRelay");
        bundle.putString("appUniteCode", str);
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

    public void removeRelayListener(String str, String str2) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "removeRelayListener");
        bundle.putString("component", RelayConst.RELAY_COMP);
        bundle.putString("ability", "abilityRelay");
        bundle.putString("sendUniteCode", str);
        bundle.putString("receiveUniteCode", str2);
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

    public void sendMessageQos(StarryTag starryTag, ArrayData arrayData, int i, StarryParam starryParam, SendRelayMessageCallBack sendRelayMessageCallBack) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "sendMessageQos");
        bundle.putString("component", RelayConst.RELAY_COMP);
        bundle.putString("ability", "abilityRelay");
        bundle.putParcelable("starryTag", starryTag);
        bundle.putParcelable(PayloadConstant.PARAMS_KEY_CALLBACK_MSG, arrayData);
        bundle.putInt("qos", i);
        bundle.putString("param", this.gson.toJson((Object) starryParam));
        if (sendRelayMessageCallBack != null) {
            bundle.putBinder("callback", new SendRelayMessageCallBackAdapter(sendRelayMessageCallBack));
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

    public void setRelayListener(String str, String str2, RelayCallback relayCallback) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "setRelayListener");
        bundle.putString("component", RelayConst.RELAY_COMP);
        bundle.putString("ability", "abilityRelay");
        bundle.putString("sendUniteCode", str);
        bundle.putString("receiveUniteCode", str2);
        if (relayCallback != null) {
            bundle.putBinder(ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, new RelayCallbackAdapter(relayCallback));
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

    public void startRemote(StarryTag starryTag, String str, ArrayData arrayData, int i, StarryParam starryParam) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "startRemote");
        bundle.putString("component", RelayConst.RELAY_COMP);
        bundle.putString("ability", "abilityRelay");
        bundle.putParcelable("starryTag", starryTag);
        bundle.putString(ApiConstant.VALUE_HOST, str);
        bundle.putParcelable("message", arrayData);
        bundle.putInt("type", i);
        bundle.putString("param", this.gson.toJson((Object) starryParam));
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

    public void stopRemote(StarryTag starryTag, StarryParam starryParam) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "stopRemote");
        bundle.putString("component", RelayConst.RELAY_COMP);
        bundle.putString("ability", "abilityRelay");
        bundle.putParcelable("starryTag", starryTag);
        bundle.putString("param", this.gson.toJson((Object) starryParam));
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
