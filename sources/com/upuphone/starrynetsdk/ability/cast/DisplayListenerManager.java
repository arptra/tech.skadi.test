package com.upuphone.starrynetsdk.ability.cast;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.upuphone.hub.Hub;
import com.upuphone.hub.HubRemoteException;
import com.upuphone.hub.HubTargetException;
import com.upuphone.runasone.uupcast.api.IDisplayListener;
import com.upuphone.runasone.uupcast.api.IUupCast;
import com.upuphone.starrynetsdk.api.Camp;
import com.upuphone.starrynetsdk.api.ErrorCode;
import com.upuphone.starrynetsdk.api.ListenerManager;
import com.upuphone.starrynetsdk.api.SNSLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class DisplayListenerManager extends ListenerManager {
    private static final String TAG = "CastAbility";
    private final ListenerInfoMap listenerInfoMap;
    private final Map<String, ListenerInfo> listenerMap;

    public static class Holder {
        /* access modifiers changed from: private */
        public static final DisplayListenerManager INSTANCE = new DisplayListenerManager();

        private Holder() {
        }
    }

    public static final class ListenerInfo implements IDisplayListener {
        private String appCode;
        private boolean isCallbackRegistered;
        /* access modifiers changed from: private */
        public final List<DisplayListener> listeners;
        private int sessionId;
        /* access modifiers changed from: private */
        public IUupCast starryCast;

        /* access modifiers changed from: private */
        public int registerCallback() {
            if (this.isCallbackRegistered) {
                return 0;
            }
            try {
                int registerDisplayListener = this.starryCast.registerDisplayListener(this.sessionId, this.appCode, this);
                if (registerDisplayListener == 0) {
                    this.isCallbackRegistered = true;
                }
                return registerDisplayListener;
            } catch (HubRemoteException e) {
                SNSLog.e(DisplayListenerManager.TAG, "registerDisplayListener failed:", e);
                return ErrorCode.CODE_SERVICE_UNAVAILABLE;
            } catch (HubTargetException e2) {
                SNSLog.e(DisplayListenerManager.TAG, "registerDisplayListener failed:", e2);
                return ErrorCode.CODE_TARGET_UNAVAILABLE;
            }
        }

        /* access modifiers changed from: private */
        public int resetListenerInfo(int i, IUupCast iUupCast, String str) {
            this.sessionId = i;
            this.starryCast = iUupCast;
            this.appCode = str;
            this.isCallbackRegistered = false;
            return registerCallback();
        }

        /* access modifiers changed from: private */
        public int unregisterCallback() {
            if (!this.listeners.isEmpty()) {
                return 0;
            }
            try {
                int unregisterDisplayListener = this.starryCast.unregisterDisplayListener(this.sessionId, this.appCode, this);
                this.isCallbackRegistered = false;
                return unregisterDisplayListener;
            } catch (HubRemoteException e) {
                SNSLog.e(DisplayListenerManager.TAG, "unregisterDisplayListener failed:", e);
                return ErrorCode.CODE_SERVICE_UNAVAILABLE;
            } catch (HubTargetException e2) {
                SNSLog.e(DisplayListenerManager.TAG, "unregisterDisplayListener failed:", e2);
                return ErrorCode.CODE_TARGET_UNAVAILABLE;
            }
        }

        public void onDisplayConnected() {
            for (int i = 0; i < this.listeners.size(); i++) {
                this.listeners.get(i).onDisplayConnected();
            }
        }

        public void onDisplayDisconnected() {
            for (int i = 0; i < this.listeners.size(); i++) {
                this.listeners.get(i).onDisplayDisconnected();
            }
        }

        public void onDisplayError(int i, String str) {
            for (int i2 = 0; i2 < this.listeners.size(); i2++) {
                this.listeners.get(i2).onDisplayError(i);
            }
        }

        public void onDisplayEvent(int i, Bundle bundle) {
            for (int i2 = 0; i2 < this.listeners.size(); i2++) {
                this.listeners.get(i2).onDisplayEvent(i, bundle);
            }
        }

        public void onDisplaySyncError(int i, String str) {
            for (int i2 = 0; i2 < this.listeners.size(); i2++) {
                this.listeners.get(i2).onSyncDisplayError(i);
            }
        }

        public void onDisplaySyncEvent(int i, Bundle bundle) {
            for (int i2 = 0; i2 < this.listeners.size(); i2++) {
                this.listeners.get(i2).onSyncDisplayEvent(i, bundle);
            }
        }

        public void onUibcCustomEvent(String str) {
            for (int i = 0; i < this.listeners.size(); i++) {
                this.listeners.get(i).onUibcCustomEvent(str);
            }
        }

        private ListenerInfo(int i, IUupCast iUupCast, String str) {
            this.isCallbackRegistered = false;
            this.listeners = new ArrayList();
            this.sessionId = i;
            this.starryCast = iUupCast;
            this.appCode = str;
        }
    }

    public static final class ListenerInfoMap {
        private String mAppCode;
        private final Map<String, ListenerInfo> mListenerMap;

        /* access modifiers changed from: private */
        public int initListenerMap(IUupCast iUupCast, int i, String str, String str2) {
            this.mAppCode = str;
            synchronized (this) {
                try {
                    ListenerInfo listenerInfo = this.mListenerMap.get(str2);
                    if (listenerInfo == null) {
                        this.mListenerMap.put(str2, new ListenerInfo(i, iUupCast, this.mAppCode));
                        return 0;
                    }
                    int access$800 = listenerInfo.resetListenerInfo(i, iUupCast, this.mAppCode);
                    return access$800;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        /* access modifiers changed from: private */
        public synchronized int registerDisplayListener(String str, int i, @NonNull DisplayListener displayListener) {
            try {
                ListenerInfo listenerInfo = this.mListenerMap.get(str);
                if (listenerInfo == null) {
                    throw new IllegalStateException("Not initialized for session ； " + i);
                } else if (listenerInfo.starryCast == null) {
                    return ErrorCode.CODE_SERVICE_UNAVAILABLE;
                } else {
                    SNSLog.e("registerDisplayListener", "listeners = " + listenerInfo.listeners + "\nadd = [" + displayListener + "]");
                    if (!listenerInfo.listeners.contains(displayListener)) {
                        listenerInfo.listeners.add(displayListener);
                    }
                    return listenerInfo.registerCallback();
                }
            } catch (Throwable th) {
                throw th;
            }
        }

        /* access modifiers changed from: private */
        public synchronized int removeCacheDisplayListener(String str, int i, @NonNull DisplayListener displayListener) {
            ListenerInfo listenerInfo = this.mListenerMap.get(str);
            if (listenerInfo == null) {
                throw new IllegalStateException("Not initialized for session ; " + i);
            } else if (listenerInfo.starryCast == null) {
                return ErrorCode.CODE_SERVICE_UNAVAILABLE;
            } else {
                SNSLog.e("registerDisplayListener", "listeners = " + listenerInfo.listeners + "\nremove = [" + displayListener + "]");
                if (listenerInfo.listeners.remove(displayListener)) {
                    return 0;
                }
                return ErrorCode.CODE_SERVICE_UNAVAILABLE;
            }
        }

        /* access modifiers changed from: private */
        public synchronized int unregisterDisplayListener(String str, int i) {
            ListenerInfo listenerInfo = this.mListenerMap.get(str);
            if (listenerInfo == null) {
                throw new IllegalStateException("Not initialized for session ； " + i);
            } else if (listenerInfo.starryCast == null) {
                return ErrorCode.CODE_SERVICE_UNAVAILABLE;
            } else {
                return listenerInfo.unregisterCallback();
            }
        }

        private ListenerInfoMap(Map<String, ListenerInfo> map) {
            this.mListenerMap = map;
        }
    }

    public static DisplayListenerManager getInstance() {
        return Holder.INSTANCE;
    }

    public int init(IUupCast iUupCast, String str, int i, String str2) {
        return this.listenerInfoMap.initListenerMap(iUupCast, i, str, str2);
    }

    public void onInstalled(Hub hub) {
        super.onInstalled(hub);
    }

    public void onUninstalled() {
        super.onUninstalled();
    }

    public synchronized int registerDisplayListener(String str, int i, @NonNull DisplayListener displayListener) {
        if (!isEnable()) {
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        }
        return this.listenerInfoMap.registerDisplayListener(str, i, displayListener);
    }

    public synchronized int unregisterDisplayListener(String str, int i, @NonNull DisplayListener displayListener) {
        int unused = this.listenerInfoMap.removeCacheDisplayListener(str, i, displayListener);
        if (!isEnable()) {
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        }
        return this.listenerInfoMap.unregisterDisplayListener(str, i);
    }

    private DisplayListenerManager() {
        HashMap hashMap = new HashMap();
        this.listenerMap = hashMap;
        this.listenerInfoMap = new ListenerInfoMap(hashMap);
        Camp.getInstance().addSentry(this);
    }
}
