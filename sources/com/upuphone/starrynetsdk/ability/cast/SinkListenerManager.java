package com.upuphone.starrynetsdk.ability.cast;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.upuphone.hub.Hub;
import com.upuphone.hub.HubRemoteException;
import com.upuphone.hub.HubTargetException;
import com.upuphone.runasone.uupcast.SourceDisplayConfig;
import com.upuphone.runasone.uupcast.api.ISinkListener;
import com.upuphone.runasone.uupcast.api.IUupCast;
import com.upuphone.starrynetsdk.api.Camp;
import com.upuphone.starrynetsdk.api.ErrorCode;
import com.upuphone.starrynetsdk.api.ListenerManager;
import com.upuphone.starrynetsdk.api.SNSLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class SinkListenerManager extends ListenerManager {
    private static final String TAG = "CastAbility";
    private final ListenerInfoMap listenerInfoMap;
    private final Map<String, ListenerInfo> listenerMap;

    public static class Holder {
        /* access modifiers changed from: private */
        public static final SinkListenerManager INSTANCE = new SinkListenerManager();

        private Holder() {
        }
    }

    public static final class ListenerInfo implements ISinkListener {
        private boolean isCallbackRegistered;
        /* access modifiers changed from: private */
        public final List<SinkListener> listeners;
        private int sessionId;
        /* access modifiers changed from: private */
        public IUupCast starryCast;

        /* access modifiers changed from: private */
        public int registerCallback() {
            if (this.isCallbackRegistered) {
                return 0;
            }
            try {
                int registerSinkListener = this.starryCast.registerSinkListener(this.sessionId, this);
                if (registerSinkListener == 0) {
                    this.isCallbackRegistered = true;
                }
                return registerSinkListener;
            } catch (HubRemoteException e) {
                SNSLog.e(SinkListenerManager.TAG, "registerSinkListener failed:", e);
                return ErrorCode.CODE_SERVICE_UNAVAILABLE;
            } catch (HubTargetException e2) {
                SNSLog.e(SinkListenerManager.TAG, "registerSinkListener failed:", e2);
                return ErrorCode.CODE_TARGET_UNAVAILABLE;
            }
        }

        /* access modifiers changed from: private */
        public int resetListenerInfo(int i, IUupCast iUupCast) {
            this.sessionId = i;
            this.starryCast = iUupCast;
            this.isCallbackRegistered = false;
            return registerCallback();
        }

        /* access modifiers changed from: private */
        public int unregisterCallback() {
            if (!this.listeners.isEmpty()) {
                return 0;
            }
            try {
                int unregisterSinkListener = this.starryCast.unregisterSinkListener(this.sessionId);
                this.isCallbackRegistered = false;
                return unregisterSinkListener;
            } catch (HubRemoteException e) {
                SNSLog.e(SinkListenerManager.TAG, "unregisterSinkListener failed:", e);
                return ErrorCode.CODE_SERVICE_UNAVAILABLE;
            } catch (HubTargetException e2) {
                SNSLog.e(SinkListenerManager.TAG, "unregisterSinkListener failed:", e2);
                return ErrorCode.CODE_TARGET_UNAVAILABLE;
            }
        }

        public void onSinkConnected() {
            for (int i = 0; i < this.listeners.size(); i++) {
                this.listeners.get(i).onSinkConnected();
            }
        }

        public void onSinkDisconnected() {
            for (int i = 0; i < this.listeners.size(); i++) {
                this.listeners.get(i).onSinkDisconnected();
            }
        }

        public void onSinkError(int i, String str) {
            for (int i2 = 0; i2 < this.listeners.size(); i2++) {
                this.listeners.get(i2).onSinkError(i);
            }
        }

        public void onSinkEvent(int i, Bundle bundle) {
            for (int i2 = 0; i2 < this.listeners.size(); i2++) {
                this.listeners.get(i2).onSinkEvent(i, bundle);
            }
        }

        public void onSinkStart() {
            for (int i = 0; i < this.listeners.size(); i++) {
                this.listeners.get(i).onSinkStart();
            }
        }

        public void onSinkStartWithConfig(SourceDisplayConfig sourceDisplayConfig) {
            for (int i = 0; i < this.listeners.size(); i++) {
                this.listeners.get(i).onSinkStart(sourceDisplayConfig);
            }
        }

        public void onSinkSyncError(int i, String str) {
            for (int i2 = 0; i2 < this.listeners.size(); i2++) {
                this.listeners.get(i2).onSyncSinkError(i);
            }
        }

        public void onSinkSyncEvent(int i, Bundle bundle) {
            for (int i2 = 0; i2 < this.listeners.size(); i2++) {
                this.listeners.get(i2).onSyncSinkEvent(i, bundle);
            }
        }

        private ListenerInfo(int i, IUupCast iUupCast) {
            this.listeners = new ArrayList();
            this.sessionId = i;
            this.starryCast = iUupCast;
            this.isCallbackRegistered = false;
        }
    }

    public static final class ListenerInfoMap {
        private final Map<String, ListenerInfo> mListenerMap;

        /* access modifiers changed from: private */
        public int initListenerMap(IUupCast iUupCast, int i, String str) {
            synchronized (this) {
                try {
                    ListenerInfo listenerInfo = this.mListenerMap.get(str);
                    if (listenerInfo == null) {
                        this.mListenerMap.put(str, new ListenerInfo(i, iUupCast));
                        return 0;
                    }
                    int access$800 = listenerInfo.resetListenerInfo(i, iUupCast);
                    return access$800;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        /* access modifiers changed from: private */
        public synchronized int registerSinkListener(String str, int i, @NonNull SinkListener sinkListener) {
            try {
                ListenerInfo listenerInfo = this.mListenerMap.get(str);
                if (listenerInfo == null) {
                    throw new IllegalStateException("Not initialized for session ； " + i);
                } else if (listenerInfo.starryCast == null) {
                    return ErrorCode.CODE_SERVICE_UNAVAILABLE;
                } else {
                    SNSLog.e("registerSinkListener", "listeners = " + listenerInfo.listeners + "\nadd = [" + sinkListener + "]");
                    if (!listenerInfo.listeners.contains(sinkListener)) {
                        listenerInfo.listeners.add(sinkListener);
                    }
                    return listenerInfo.registerCallback();
                }
            } catch (Throwable th) {
                throw th;
            }
        }

        /* access modifiers changed from: private */
        public synchronized int removeCacheSinkListener(String str, int i, @NonNull SinkListener sinkListener) {
            ListenerInfo listenerInfo = this.mListenerMap.get(str);
            if (listenerInfo == null) {
                throw new IllegalStateException("Not initialized for session ; " + i);
            } else if (listenerInfo.starryCast == null) {
                return ErrorCode.CODE_SERVICE_UNAVAILABLE;
            } else {
                SNSLog.e("registerSinkListener", "listeners = " + listenerInfo.listeners + "\nremove = [" + sinkListener + "]");
                if (listenerInfo.listeners.remove(sinkListener)) {
                    return 0;
                }
                return ErrorCode.CODE_SERVICE_UNAVAILABLE;
            }
        }

        /* access modifiers changed from: private */
        public synchronized int unregisterSinkListener(String str, int i) {
            ListenerInfo listenerInfo = this.mListenerMap.get(str);
            if (listenerInfo == null) {
                throw new IllegalStateException("Not initialized for session ; " + i);
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

    public static SinkListenerManager getInstance() {
        return Holder.INSTANCE;
    }

    public int init(IUupCast iUupCast, int i, String str) {
        return this.listenerInfoMap.initListenerMap(iUupCast, i, str);
    }

    public void onInstalled(Hub hub) {
        super.onInstalled(hub);
    }

    public void onUninstalled() {
        super.onUninstalled();
    }

    public int registerSinkListener(String str, int i, @NonNull SinkListener sinkListener) {
        return isEnable() ? this.listenerInfoMap.registerSinkListener(str, i, sinkListener) : ErrorCode.CODE_SERVICE_UNAVAILABLE;
    }

    public int unregisterSinkListener(String str, int i, @NonNull SinkListener sinkListener) {
        int unused = this.listenerInfoMap.removeCacheSinkListener(str, i, sinkListener);
        return isEnable() ? this.listenerInfoMap.unregisterSinkListener(str, i) : ErrorCode.CODE_SERVICE_UNAVAILABLE;
    }

    private SinkListenerManager() {
        HashMap hashMap = new HashMap();
        this.listenerMap = hashMap;
        this.listenerInfoMap = new ListenerInfoMap(hashMap);
        Camp.getInstance().addSentry(this);
    }
}
