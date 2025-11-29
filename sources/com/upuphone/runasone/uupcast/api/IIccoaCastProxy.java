package com.upuphone.runasone.uupcast.api;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.gson.Gson;
import com.upuphone.hub.Hub;
import com.upuphone.hub.HubRemoteException;
import com.upuphone.hub.HubTargetException;
import com.upuphone.runasone.uupcast.ApiConstant;
import com.upuphone.runasone.uupcast.SinkDisplayConfig;
import com.upuphone.starryiccoaproto.UCarMessage;
import io.netty.handler.codec.rtsp.RtspHeaders;

public final class IIccoaCastProxy implements IIccoaCast {
    private final Gson gson = new Gson();
    private Hub hub;

    public void buildVirtualAfterBleConnected() {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "buildVirtualAfterBleConnected");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", "abilityIccoa");
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

    public void destroyVirtualDisplayWhenConnectFail() {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "destroyVirtualDisplayWhenConnectFail");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", "abilityIccoa");
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

    public void initPhoneState() {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "initPhoneState");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", "abilityIccoa");
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

    public void initSession(SinkDisplayConfig sinkDisplayConfig) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "initSession");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", "abilityIccoa");
        bundle.putString("config", this.gson.toJson((Object) sinkDisplayConfig));
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

    public boolean isCarInCache(byte[] bArr) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "isCarInCache");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", "abilityIccoa");
        bundle.putByteArray("id", bArr);
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

    public void reAuth(boolean z) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "reAuth");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", "abilityIccoa");
        bundle.putBoolean("confirm", z);
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

    public void removeCarCache() {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "removeCarCache");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", "abilityIccoa");
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

    public void sendCarMessage(UCarMessage uCarMessage) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "sendCarMessage");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", "abilityIccoa");
        bundle.putParcelable("uCarMessage", uCarMessage);
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

    public void sendCastMessage(int i, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = new Bundle();
        bundle2.putString("method", "sendCastMessage");
        bundle2.putString("component", ApiConstant.COMPONENT);
        bundle2.putString("ability", "abilityIccoa");
        bundle2.putInt("what", i);
        bundle2.putParcelable("data", bundle);
        try {
            this.hub.transfer(bundle2, bundle3);
        } catch (RemoteException e) {
            throw new HubRemoteException(e);
        } catch (UnsupportedOperationException e2) {
            if ("target method not found".equals(e2.getMessage())) {
                throw new HubTargetException("target method not found");
            }
            throw e2;
        }
    }

    public void sendMessage(int i) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "sendMessage");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", "abilityIccoa");
        bundle.putInt("what", i);
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

    public void setIHandleReceiverCarMessageListener(IHandleReceiverCarMessageListener iHandleReceiverCarMessageListener) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "setIHandleReceiverCarMessageListener");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", "abilityIccoa");
        if (iHandleReceiverCarMessageListener != null) {
            bundle.putBinder(ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, new IHandleReceiverCarMessageListenerAdapter(iHandleReceiverCarMessageListener));
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

    public void setIccoaConnectListener(IccoaConnectListener iccoaConnectListener) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "setIccoaConnectListener");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", "abilityIccoa");
        if (iccoaConnectListener != null) {
            bundle.putBinder("iccoaConnectListener", new IccoaConnectListenerAdapter(iccoaConnectListener));
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

    public void setUibcDisplayId(int i) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "setUibcDisplayId");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", "abilityIccoa");
        bundle.putInt("displayId", i);
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

    public void startCast(int i, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = new Bundle();
        bundle2.putString("method", "startCast");
        bundle2.putString("component", ApiConstant.COMPONENT);
        bundle2.putString("ability", "abilityIccoa");
        bundle2.putInt(RtspHeaders.Values.MODE, i);
        bundle2.putParcelable("data", bundle);
        try {
            this.hub.transfer(bundle2, bundle3);
        } catch (RemoteException e) {
            throw new HubRemoteException(e);
        } catch (UnsupportedOperationException e2) {
            if ("target method not found".equals(e2.getMessage())) {
                throw new HubTargetException("target method not found");
            }
            throw e2;
        }
    }

    public void stopPlay() {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "stopPlay");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", "abilityIccoa");
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

    public void updatePincode(String str) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "updatePincode");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", "abilityIccoa");
        bundle.putString("pinCode", str);
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

    public void removeCarCache(byte[] bArr) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "removeCarCache");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", "abilityIccoa");
        bundle.putByteArray("id", bArr);
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
