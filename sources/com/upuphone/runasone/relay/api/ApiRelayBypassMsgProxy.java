package com.upuphone.runasone.relay.api;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.gson.Gson;
import com.upuphone.hub.Hub;
import com.upuphone.hub.HubRemoteException;
import com.upuphone.hub.HubTargetException;
import com.upuphone.runasone.ArrayData;
import com.upuphone.runasone.constant.Constants;
import com.upuphone.runasone.relay.util.RelayConst;
import com.upuphone.starrynet.api.StConstant;
import com.upuphone.starrynet.payload.PayloadConstant;

public final class ApiRelayBypassMsgProxy implements ApiRelayBypassMsg {
    private final Gson gson = new Gson();
    private Hub hub;

    public void removeRelayListener(String str, String str2) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "removeRelayListener");
        bundle.putString("component", RelayConst.RELAY_COMP);
        bundle.putString("ability", "abilityRelayBypass");
        bundle.putString("serviceUuid", str);
        bundle.putString("characterUuid", str2);
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

    public void removeRelayListenerByCallback(String str, String str2, String str3, BypassCallback bypassCallback) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "removeRelayListenerByCallback");
        bundle.putString("component", RelayConst.RELAY_COMP);
        bundle.putString("ability", "abilityRelayBypass");
        bundle.putString("serviceUuid", str);
        bundle.putString("characterUuid", str2);
        bundle.putString("callBackTag", str3);
        if (bypassCallback != null) {
            bundle.putBinder("callBack", new BypassCallbackAdapter(bypassCallback));
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

    public void sendMessage(String str, String str2, String str3, int i, ArrayData arrayData, SendRelayMessageCallBack sendRelayMessageCallBack) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "sendMessage");
        bundle.putString("component", RelayConst.RELAY_COMP);
        bundle.putString("ability", "abilityRelayBypass");
        bundle.putString(Constants.DEVICE_ID, str);
        bundle.putString("serviceUuid", str2);
        bundle.putString("characterUuid", str3);
        bundle.putInt(StConstant.STARRY_MESSAGE_KEY_MSG_TYPE, i);
        bundle.putParcelable(PayloadConstant.PARAMS_KEY_CALLBACK_MSG, arrayData);
        if (sendRelayMessageCallBack != null) {
            bundle.putBinder("callBack", new SendRelayMessageCallBackAdapter(sendRelayMessageCallBack));
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

    public void setRelayListener(String str, String str2, BypassCallback bypassCallback) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "setRelayListener");
        bundle.putString("component", RelayConst.RELAY_COMP);
        bundle.putString("ability", "abilityRelayBypass");
        bundle.putString("serviceUuid", str);
        bundle.putString("characterUuid", str2);
        if (bypassCallback != null) {
            bundle.putBinder("callBack", new BypassCallbackAdapter(bypassCallback));
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

    public void setRelayListenerByCallback(String str, String str2, String str3, BypassCallback bypassCallback) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "setRelayListenerByCallback");
        bundle.putString("component", RelayConst.RELAY_COMP);
        bundle.putString("ability", "abilityRelayBypass");
        bundle.putString("serviceUuid", str);
        bundle.putString("characterUuid", str2);
        bundle.putString("callBackTag", str3);
        if (bypassCallback != null) {
            bundle.putBinder("callBack", new BypassCallbackAdapter(bypassCallback));
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
