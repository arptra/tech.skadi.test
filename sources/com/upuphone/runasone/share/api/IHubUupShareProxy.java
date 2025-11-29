package com.upuphone.runasone.share.api;

import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.gson.Gson;
import com.upuphone.hub.Hub;
import com.upuphone.hub.HubRemoteException;
import com.upuphone.hub.HubTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import sdk.meizu.account.factor.authentication.sdk.constant.ConstantKt;

public final class IHubUupShareProxy implements IHubUupShare {
    private final Gson gson = new Gson();
    private Hub hub;

    public void cancel(String str, String str2) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "cancel");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", "abilityShare");
        bundle.putString(ConstantKt.FACTOR_PARAMS_PACKAGE_NAME, str);
        bundle.putString("id", str2);
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

    public void cancelReceive(String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "cancelReceive");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", "abilityShare");
        bundle.putString(ConstantKt.FACTOR_PARAMS_PACKAGE_NAME, str);
        bundle.putString("taskId", str2);
        bundle.putString("reason", str3);
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

    public void confirmReceive(String str, String str2) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "confirmReceive");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", "abilityShare");
        bundle.putString(ConstantKt.FACTOR_PARAMS_PACKAGE_NAME, str);
        bundle.putString("taskId", str2);
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

    public boolean isTransferring(String str) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "isTransferring");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", "abilityShare");
        bundle.putString("taskId", str);
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

    public String pull(String str, Uri[] uriArr) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "pull");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", "abilityShare");
        bundle.putString(ConstantKt.FACTOR_PARAMS_PACKAGE_NAME, str);
        bundle.putParcelableArrayList("uris", new ArrayList(Arrays.asList(uriArr)));
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

    public boolean reTry(String str, Uri[] uriArr, String str2, String str3, String str4) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "reTry");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", "abilityShare");
        bundle.putString(ConstantKt.FACTOR_PARAMS_PACKAGE_NAME, str);
        bundle.putParcelableArrayList("uris", new ArrayList(Arrays.asList(uriArr)));
        bundle.putString("taskId", str2);
        bundle.putString("id", str3);
        bundle.putString("extra", str4);
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

    public void registerReceiveCallBack(String str, IHubUupShareStatusCallback iHubUupShareStatusCallback) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "registerReceiveCallBack");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", "abilityShare");
        bundle.putString(ConstantKt.FACTOR_PARAMS_PACKAGE_NAME, str);
        if (iHubUupShareStatusCallback != null) {
            bundle.putBinder("callback", new IHubUupShareStatusCallbackAdapter(iHubUupShareStatusCallback));
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

    public void registerSendCallBack(String str, IHubUupShareStatusCallback iHubUupShareStatusCallback) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "registerSendCallBack");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", "abilityShare");
        bundle.putString(ConstantKt.FACTOR_PARAMS_PACKAGE_NAME, str);
        if (iHubUupShareStatusCallback != null) {
            bundle.putBinder("callback", new IHubUupShareStatusCallbackAdapter(iHubUupShareStatusCallback));
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

    public String sendFile(String str, Uri[] uriArr, String str2, String str3) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "sendFile");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", "abilityShare");
        bundle.putString(ConstantKt.FACTOR_PARAMS_PACKAGE_NAME, str);
        bundle.putParcelableArrayList("uris", new ArrayList(Arrays.asList(uriArr)));
        bundle.putString("id", str2);
        bundle.putString("extra", str3);
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

    public String sendFileByBle(String str, Uri uri, String str2, String str3) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "sendFileByBle");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", "abilityShare");
        bundle.putString(ConstantKt.FACTOR_PARAMS_PACKAGE_NAME, str);
        bundle.putParcelable("uri", uri);
        bundle.putString("id", str2);
        bundle.putString("extra", str3);
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

    public void setHub(Hub hub2) {
        this.hub = hub2;
    }

    public void setPath(String str, String str2) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "setPath");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", "abilityShare");
        bundle.putString(ConstantKt.FACTOR_PARAMS_PACKAGE_NAME, str);
        bundle.putString("path", str2);
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

    public void unRegisterReceiveCallBack(String str) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "unRegisterReceiveCallBack");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", "abilityShare");
        bundle.putString(ConstantKt.FACTOR_PARAMS_PACKAGE_NAME, str);
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

    public void unRegisterSendCallBack(String str) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "unRegisterSendCallBack");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", "abilityShare");
        bundle.putString(ConstantKt.FACTOR_PARAMS_PACKAGE_NAME, str);
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
