package com.upuphone.runasone.uupcast.api;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.gson.Gson;
import com.upuphone.hub.Hub;
import com.upuphone.hub.HubRemoteException;
import com.upuphone.hub.HubTargetException;
import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.runasone.uupcast.ApiConstant;

public final class IVirtualDeviceUupCastProxy implements IVirtualDeviceUupCast {
    private final Gson gson = new Gson();
    private Hub hub;

    public int enableCameraByType(int i) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "enableCameraByType");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", "virtualDevice");
        bundle.putInt("cameraType", i);
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

    public int enableMicByType(int i) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "enableMicByType");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", "virtualDevice");
        bundle.putInt("micType", i);
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

    public int registerVirtualCamera(int i) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "registerVirtualCamera");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", "virtualDevice");
        bundle.putInt("id", i);
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

    public int registerVirtualMic(int i) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "registerVirtualMic");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", "virtualDevice");
        bundle.putInt("id", i);
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

    public int registerVirtualModem(int i) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "registerVirtualModem");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", "virtualDevice");
        bundle.putInt("id", i);
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

    public int setSinkEventCallback(IVirtualDeviceEventListener iVirtualDeviceEventListener) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "setSinkEventCallback");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", "virtualDevice");
        if (iVirtualDeviceEventListener != null) {
            bundle.putBinder(ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, new IVirtualDeviceEventListenerAdapter(iVirtualDeviceEventListener));
        }
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

    public int setSourceEventCallback(IVirtualDeviceEventListener iVirtualDeviceEventListener) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "setSourceEventCallback");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", "virtualDevice");
        if (iVirtualDeviceEventListener != null) {
            bundle.putBinder(ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, new IVirtualDeviceEventListenerAdapter(iVirtualDeviceEventListener));
        }
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

    public int startSinkServer(StarryDevice starryDevice) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "startSinkServer");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", "virtualDevice");
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

    public int startSourceClient() {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "startSourceClient");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", "virtualDevice");
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

    public int stopSinkServer() {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "stopSinkServer");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", "virtualDevice");
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

    public int stopSourceClient() {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "stopSourceClient");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", "virtualDevice");
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

    public int unregisterVirtualCamera(int i) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "unregisterVirtualCamera");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", "virtualDevice");
        bundle.putInt("id", i);
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

    public int unregisterVirtualMic(int i) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "unregisterVirtualMic");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", "virtualDevice");
        bundle.putInt("id", i);
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

    public int unregisterVirtualModem(int i) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "unregisterVirtualModem");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", "virtualDevice");
        bundle.putInt("id", i);
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

    public int unsetSinkEventCallback() {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "unsetSinkEventCallback");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", "virtualDevice");
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

    public int unsetSourceEventCallback() {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "unsetSourceEventCallback");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", "virtualDevice");
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
