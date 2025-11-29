package com.upuphone.starrynetsdk.ability.share;

import android.net.Uri;
import com.upuphone.hub.Hub;
import com.upuphone.hub.HubRemoteException;
import com.upuphone.hub.HubTargetException;
import com.upuphone.runasone.share.api.IHubUupShareProxy;
import com.upuphone.runasone.share.api.IHubUupShareStatusCallback;
import com.upuphone.starrynetsdk.api.Camp;
import com.upuphone.starrynetsdk.api.ListenerManager;
import com.upuphone.starrynetsdk.api.SNSLog;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public final class ShareListenerManager extends ListenerManager {
    private static final String TAG = "ShareListenerManager";
    private final IHubUupShareProxy api;
    private volatile boolean isInit;
    private boolean isReceiveCallbackRegistered;
    private boolean isSendCallbackRegistered;
    private String packageName;
    private final ShareCallback receiveCallback;
    private final Set<ShareListener> receiveListeners;
    private final ShareCallback sendCallback;
    private final Set<ShareListener> sendListeners;

    public static class Holder {
        /* access modifiers changed from: private */
        public static final ShareListenerManager INSTANCE = new ShareListenerManager();

        private Holder() {
        }
    }

    public static final class ShareCallback implements IHubUupShareStatusCallback {
        private final boolean isSendCallback;
        private final Set<ShareListener> listeners;

        public void onFailure(String str, boolean z, int i) {
            if (this.isSendCallback) {
                SNSLog.d(ShareListenerManager.TAG, "send failed: " + str + " >>> " + i);
            } else {
                SNSLog.d(ShareListenerManager.TAG, "receive failed: " + str + " >>> " + i);
            }
            for (ShareListener onError : this.listeners) {
                onError.onError(str, i);
            }
        }

        public void onFinish(String str, Uri uri, Uri uri2) {
            for (ShareListener onSuccess : this.listeners) {
                onSuccess.onSuccess(str, uri, uri2);
            }
        }

        public void onProgressChanged(String str, int i, Uri uri) {
            for (ShareListener onProgress : this.listeners) {
                onProgress.onProgress(str, uri, i);
            }
        }

        public void onStart(String str, String str2) {
            if (this.isSendCallback) {
                SNSLog.d(ShareListenerManager.TAG, "send start: " + str);
            } else {
                SNSLog.d(ShareListenerManager.TAG, "receive start: " + str);
            }
            for (ShareListener onStart : this.listeners) {
                onStart.onStart(str);
            }
        }

        public void onSuccess(String str) {
            if (this.isSendCallback) {
                SNSLog.d(ShareListenerManager.TAG, "send finish: " + str);
            } else {
                SNSLog.d(ShareListenerManager.TAG, "receive finish: " + str);
            }
            for (ShareListener onFinish : this.listeners) {
                onFinish.onFinish(str);
            }
        }

        private ShareCallback(boolean z, Set<ShareListener> set) {
            this.isSendCallback = z;
            this.listeners = set;
        }
    }

    private void doRegisterReceiveCallBack(boolean z) {
        SNSLog.d(TAG, "doRegisterReceiveCallBack from restore: " + z);
        if (this.isReceiveCallbackRegistered) {
            SNSLog.e(TAG, "ReceiveCallBack already registered , unnecessary doRegisterReceiveCallBack");
        } else if (this.receiveListeners.isEmpty()) {
            SNSLog.e(TAG, "ReceiveListeners isEmpty , unnecessary doRegisterReceiveCallBack.");
        } else if (!isEnable()) {
            SNSLog.e(TAG, "Service unavailable , doRegisterReceiveCallBack failed.");
        } else {
            try {
                this.api.registerReceiveCallBack(this.packageName, this.receiveCallback);
                this.isReceiveCallbackRegistered = true;
            } catch (HubRemoteException | HubTargetException e) {
                SNSLog.e(TAG, "doRegisterReceiveCallBack failed.", e);
            }
        }
    }

    private void doRegisterSendCallBack(boolean z) {
        SNSLog.d(TAG, "doRegisterSendCallBack from restore: " + z);
        if (this.isSendCallbackRegistered) {
            SNSLog.e(TAG, "SendCallBack already registered , unnecessary doRegisterSendCallBack");
        } else if (this.sendListeners.isEmpty()) {
            SNSLog.e(TAG, "SendListeners isEmpty , unnecessary doRegisterSendCallBack");
        } else if (!isEnable()) {
            SNSLog.e(TAG, "Service unavailable , doRegisterSendCallBack failed.");
        } else {
            try {
                this.api.registerSendCallBack(this.packageName, this.sendCallback);
                this.isSendCallbackRegistered = true;
            } catch (HubRemoteException | HubTargetException e) {
                SNSLog.e(TAG, "doRegisterSendCallBack failed.", e);
            }
        }
    }

    private void doUnregisterReceiveCallBack() {
        SNSLog.d(TAG, "doUnregisterReceiveCallBack");
        if (!this.receiveListeners.isEmpty()) {
            SNSLog.e(TAG, "ReceiveListeners not empty , unnecessary doUnregisterReceiveCallBack.");
        } else if (!isEnable()) {
            SNSLog.e(TAG, "Service unavailable , doUnregisterReceiveCallBack failed.");
        } else {
            try {
                this.api.unRegisterReceiveCallBack(this.packageName);
                this.isReceiveCallbackRegistered = false;
            } catch (HubRemoteException | HubTargetException e) {
                SNSLog.e(TAG, "Do doUnregisterReceiveCallBack failed.", e);
            }
        }
    }

    private void doUnregisterSendCallBack() {
        SNSLog.d(TAG, "doUnregisterSendCallBack");
        if (!this.sendListeners.isEmpty()) {
            SNSLog.e(TAG, "SendListeners not empty , unnecessary doUnregisterSendCallBack.");
        } else if (!isEnable()) {
            SNSLog.e(TAG, "Service unavailable , doUnregisterSendCallBack failed.");
        } else {
            try {
                this.api.unRegisterSendCallBack(this.packageName);
                this.isSendCallbackRegistered = false;
            } catch (HubRemoteException | HubTargetException e) {
                SNSLog.e(TAG, "doUnregisterSendCallBack failed.", e);
            }
        }
    }

    public static ShareListenerManager getInstance() {
        return Holder.INSTANCE;
    }

    public void init(String str) {
        if (!this.isInit) {
            this.isInit = true;
            this.packageName = str;
            Camp.getInstance().addSentry(this);
        }
    }

    public void onInstalled(Hub hub) {
        super.onInstalled(hub);
        this.api.setHub(hub);
        doRegisterSendCallBack(true);
        doRegisterReceiveCallBack(true);
    }

    public void onUninstalled() {
        super.onUninstalled();
        this.isSendCallbackRegistered = false;
        this.isReceiveCallbackRegistered = false;
    }

    public void registerReceiveListener(ShareListener shareListener) {
        this.receiveListeners.add(shareListener);
        doRegisterReceiveCallBack(false);
    }

    public void registerSendListener(ShareListener shareListener) {
        this.sendListeners.add(shareListener);
        doRegisterSendCallBack(false);
    }

    public void unregisterReceiveListener(ShareListener shareListener) {
        this.receiveListeners.remove(shareListener);
        doUnregisterReceiveCallBack();
    }

    public void unregisterSendListener(ShareListener shareListener) {
        this.sendListeners.remove(shareListener);
        doUnregisterSendCallBack();
    }

    private ShareListenerManager() {
        this.api = new IHubUupShareProxy();
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
        this.sendListeners = copyOnWriteArraySet;
        CopyOnWriteArraySet copyOnWriteArraySet2 = new CopyOnWriteArraySet();
        this.receiveListeners = copyOnWriteArraySet2;
        this.sendCallback = new ShareCallback(true, copyOnWriteArraySet);
        this.receiveCallback = new ShareCallback(true, copyOnWriteArraySet2);
    }
}
