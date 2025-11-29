package com.upuphone.starrynetsdk.ability.cast;

import androidx.annotation.NonNull;
import com.upuphone.hub.Hub;
import com.upuphone.hub.HubRemoteException;
import com.upuphone.hub.HubTargetException;
import com.upuphone.runasone.uupcast.CastAudioAttributes;
import com.upuphone.runasone.uupcast.api.ISinkAudioListener;
import com.upuphone.runasone.uupcast.api.IUupCast;
import com.upuphone.starrynetsdk.api.Camp;
import com.upuphone.starrynetsdk.api.ErrorCode;
import com.upuphone.starrynetsdk.api.ListenerManager;
import com.upuphone.starrynetsdk.api.SNSLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class SinkAudioListenerManager extends ListenerManager {
    private static final String TAG = "CastAbility";
    private final Map<String, ISinkAudioListenerImpl> mSinkAudioListenerImpls;

    public static class Holder {
        /* access modifiers changed from: private */
        public static final SinkAudioListenerManager INSTANCE = new SinkAudioListenerManager();

        private Holder() {
        }
    }

    public static class ISinkAudioListenerImpl implements ISinkAudioListener {
        private boolean isInternalListenerRegistered;
        /* access modifiers changed from: private */
        public final List<SinkAudioListener> mExternalListenerList;
        private int mSessionId;
        /* access modifiers changed from: private */
        public IUupCast mStarryCast;

        /* access modifiers changed from: private */
        public void addExternalListener(SinkAudioListener sinkAudioListener) {
            if (!this.mExternalListenerList.contains(sinkAudioListener)) {
                this.mExternalListenerList.add(sinkAudioListener);
            }
        }

        /* access modifiers changed from: private */
        public int registerInternalListener() {
            if (this.isInternalListenerRegistered) {
                return 0;
            }
            try {
                int displaySinkSetAudioListener = this.mStarryCast.displaySinkSetAudioListener(this.mSessionId, this);
                if (displaySinkSetAudioListener == 0) {
                    this.isInternalListenerRegistered = true;
                } else {
                    SNSLog.e(SinkAudioListenerManager.TAG, "registerInternalListener failed, error code:" + displaySinkSetAudioListener);
                }
                return displaySinkSetAudioListener;
            } catch (HubRemoteException e) {
                SNSLog.e(SinkAudioListenerManager.TAG, "registerInternalListener failed:", e);
                return ErrorCode.CODE_SERVICE_UNAVAILABLE;
            } catch (HubTargetException e2) {
                SNSLog.e(SinkAudioListenerManager.TAG, "registerInternalListener failed, force as success:", e2);
                return 0;
            }
        }

        /* access modifiers changed from: private */
        public void removeExternalListener(SinkAudioListener sinkAudioListener) {
            this.mExternalListenerList.remove(sinkAudioListener);
        }

        /* access modifiers changed from: private */
        public void reset(@NonNull IUupCast iUupCast, int i) {
            this.mStarryCast = iUupCast;
            this.mSessionId = i;
            this.isInternalListenerRegistered = false;
        }

        private int unregisterInternalListener() {
            if (!this.mExternalListenerList.isEmpty()) {
                return 0;
            }
            try {
                int displaySinkSetAudioListener = this.mStarryCast.displaySinkSetAudioListener(this.mSessionId, (ISinkAudioListener) null);
                this.isInternalListenerRegistered = false;
                return displaySinkSetAudioListener;
            } catch (HubRemoteException e) {
                SNSLog.e(SinkAudioListenerManager.TAG, "unregisterInternalListener failed:", e);
                return ErrorCode.CODE_SERVICE_UNAVAILABLE;
            } catch (HubTargetException e2) {
                SNSLog.e(SinkAudioListenerManager.TAG, "unregisterInternalListener failed:", e2);
                return ErrorCode.CODE_TARGET_UNAVAILABLE;
            }
        }

        @NonNull
        public CastAudioAttributes convertAudioAttributes(int i) {
            if (this.mExternalListenerList.isEmpty()) {
                SNSLog.e(SinkAudioListenerManager.TAG, "no SinkAudioListener registered, fatal error, use default audio attributes");
                return null;
            }
            CastAudioAttributes convertAudioAttributes = this.mExternalListenerList.get(0).convertAudioAttributes(i);
            if (convertAudioAttributes != null) {
                return convertAudioAttributes;
            }
            throw new NullPointerException("converted CastAudioAttributes is null");
        }

        public void onForceMuteStart(int i) {
            for (SinkAudioListener onForceMuteStart : this.mExternalListenerList) {
                onForceMuteStart.onForceMuteStart(i);
            }
        }

        public void onForceMuteStop(int i) {
            for (SinkAudioListener onForceMuteStop : this.mExternalListenerList) {
                onForceMuteStop.onForceMuteStop(i);
            }
        }

        private ISinkAudioListenerImpl(@NonNull IUupCast iUupCast, int i) {
            this.mExternalListenerList = new ArrayList();
            this.mStarryCast = iUupCast;
            this.mSessionId = i;
            this.isInternalListenerRegistered = false;
        }
    }

    public static SinkAudioListenerManager getInstance() {
        return Holder.INSTANCE;
    }

    public int init(@NonNull IUupCast iUupCast, int i, @NonNull String str) {
        ISinkAudioListenerImpl iSinkAudioListenerImpl;
        synchronized (this.mSinkAudioListenerImpls) {
            try {
                iSinkAudioListenerImpl = this.mSinkAudioListenerImpls.get(str);
                if (iSinkAudioListenerImpl == null) {
                    iSinkAudioListenerImpl = new ISinkAudioListenerImpl(iUupCast, i);
                    this.mSinkAudioListenerImpls.put(str, iSinkAudioListenerImpl);
                } else {
                    iSinkAudioListenerImpl.reset(iUupCast, i);
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        return iSinkAudioListenerImpl.registerInternalListener();
    }

    public boolean isSinkAudioListenerRegistered(int i, @NonNull String str) {
        synchronized (this.mSinkAudioListenerImpls) {
            try {
                ISinkAudioListenerImpl iSinkAudioListenerImpl = this.mSinkAudioListenerImpls.get(str);
                if (iSinkAudioListenerImpl == null) {
                    return false;
                }
                boolean z = !iSinkAudioListenerImpl.mExternalListenerList.isEmpty();
                return z;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void onInstalled(Hub hub) {
        super.onInstalled(hub);
    }

    public void onUninstalled() {
        super.onUninstalled();
    }

    public int registerSinkAudioListener(int i, @NonNull String str, @NonNull SinkAudioListener sinkAudioListener) {
        if (!isEnable()) {
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        }
        synchronized (this.mSinkAudioListenerImpls) {
            try {
                ISinkAudioListenerImpl iSinkAudioListenerImpl = this.mSinkAudioListenerImpls.get(str);
                if (iSinkAudioListenerImpl == null) {
                    throw new IllegalStateException("Not initialized for session ； " + i);
                } else if (iSinkAudioListenerImpl.mStarryCast == null) {
                    return ErrorCode.CODE_SERVICE_UNAVAILABLE;
                } else {
                    SNSLog.e(TAG, "registerSinkAudioListener, old listener = " + iSinkAudioListenerImpl.mExternalListenerList + ", new = [" + sinkAudioListener + "]");
                    iSinkAudioListenerImpl.addExternalListener(sinkAudioListener);
                    return 0;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public int unregisterSinkAudioListener(int i, @NonNull String str, @NonNull SinkAudioListener sinkAudioListener) {
        synchronized (this.mSinkAudioListenerImpls) {
            try {
                ISinkAudioListenerImpl iSinkAudioListenerImpl = this.mSinkAudioListenerImpls.get(str);
                if (iSinkAudioListenerImpl != null) {
                    SNSLog.e(TAG, "unregisterSinkAudioListener " + sinkAudioListener);
                    iSinkAudioListenerImpl.removeExternalListener(sinkAudioListener);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return 0;
    }

    private SinkAudioListenerManager() {
        this.mSinkAudioListenerImpls = new HashMap();
        Camp.getInstance().addSentry(this);
    }
}
