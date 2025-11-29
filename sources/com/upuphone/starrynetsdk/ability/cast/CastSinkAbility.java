package com.upuphone.starrynetsdk.ability.cast;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.upuphone.hub.Hub;
import com.upuphone.hub.HubRemoteException;
import com.upuphone.hub.HubTargetException;
import com.upuphone.runasone.uupcast.CastErrorCode;
import com.upuphone.runasone.uupcast.CastFeature;
import com.upuphone.runasone.uupcast.SinkDisplayConfig;
import com.upuphone.starrynetsdk.api.ErrorCode;
import com.upuphone.starrynetsdk.api.SNSLog;
import com.upuphone.starrynetsdk.api.Util;

public final class CastSinkAbility extends CastAbility {
    private static final String TAG = "CastAbility";
    private Context context;
    private final SinkListenerManager listenerManager;
    private final String mAppCode;
    private int sessionId = -1;

    public CastSinkAbility(@NonNull Context context2) {
        this.context = context2;
        String appUniteCode = Util.getAppUniteCode(context2);
        this.mAppCode = appUniteCode;
        if (!TextUtils.isEmpty(appUniteCode)) {
            this.listenerManager = SinkListenerManager.getInstance();
            return;
        }
        throw new IllegalStateException("App unite code not configured in Manifest");
    }

    private int checkSupportFeature(@CastFeature String str) {
        if (str == null || TextUtils.isEmpty(str)) {
            throw new NullPointerException("param feature is null or empty");
        } else if (this.sessionId == -1) {
            throw new IllegalStateException("Cast session not initialized yet");
        } else if (!isEnable()) {
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        } else {
            try {
                return this.starryCast.sinkCheckFeatureSupported(this.sessionId, str);
            } catch (HubRemoteException e) {
                SNSLog.e(TAG, "sink checkSupportFeature failed:", e);
                return ErrorCode.CODE_SERVICE_UNAVAILABLE;
            } catch (HubTargetException e2) {
                SNSLog.e(TAG, "sink checkSupportFeature failed:", e2);
                return CastErrorCode.SINK_NOT_SUPPORT_FEATURE;
            }
        }
    }

    @SuppressLint({"WrongConstant"})
    private SinkDisplayConfig rebuildConfig(@NonNull SinkDisplayConfig sinkDisplayConfig, boolean z) {
        if (z) {
            return sinkDisplayConfig;
        }
        int captureType = sinkDisplayConfig.getCaptureType();
        if ((32768 & captureType) == 0) {
            return sinkDisplayConfig;
        }
        int i = -32769 & captureType;
        SNSLog.i(TAG, "convert config, originalCaptureType:" + captureType + ", finalCaptureType:" + i);
        return new SinkDisplayConfig.Builder(sinkDisplayConfig).setCaptureType(i).build();
    }

    public int addVirtualDisplay(Surface surface, SinkDisplayConfig sinkDisplayConfig) {
        if (surface == null) {
            throw new NullPointerException("surface is null");
        } else if (sinkDisplayConfig == null) {
            throw new NullPointerException("config is null");
        } else if (TextUtils.isEmpty(sinkDisplayConfig.getTag())) {
            throw new IllegalArgumentException("tag is null or empty");
        } else if (this.sessionId == -1) {
            throw new IllegalStateException("Cast session not initialized yet");
        } else if (!isEnable()) {
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        } else {
            try {
                int displaySinkAddVirtualDisplay = this.starryCast.displaySinkAddVirtualDisplay(this.sessionId, surface, sinkDisplayConfig);
                if (displaySinkAddVirtualDisplay != Integer.MIN_VALUE) {
                    return displaySinkAddVirtualDisplay;
                }
                throw new IllegalArgumentException("参数非法");
            } catch (HubRemoteException e) {
                SNSLog.e(TAG, "addVirtualDisplay failed:", e);
                return ErrorCode.CODE_SERVICE_UNAVAILABLE;
            } catch (HubTargetException e2) {
                SNSLog.e(TAG, "addVirtualDisplay failed:", e2);
                return ErrorCode.CODE_TARGET_UNAVAILABLE;
            }
        }
    }

    public int getCastSessionId() {
        int i = this.sessionId;
        if (i != -1) {
            return i;
        }
        throw new IllegalStateException("Cast session not initialized yet");
    }

    @Nullable
    public SinkDisplayConfig getDisplayConfig() {
        if (this.sessionId == -1) {
            throw new IllegalStateException("Cast session not initialized yet");
        } else if (!isEnable()) {
            return null;
        } else {
            try {
                return this.starryCast.getSinkDisplayConfig(this.sessionId);
            } catch (HubRemoteException e) {
                SNSLog.e(TAG, "getDisplayConfig failed:", e);
                return null;
            } catch (HubTargetException e2) {
                SNSLog.e(TAG, "getDisplayConfig failed:", e2);
                return null;
            }
        }
    }

    public int initCastSession(String str) {
        if (str == null || TextUtils.isEmpty(str.trim())) {
            throw new NullPointerException("castSessionTag must not be null or empty");
        }
        this.sessionTag = str;
        String packageName = this.context.getPackageName();
        if (packageName == null || TextUtils.isEmpty(packageName.trim())) {
            throw new NullPointerException("package name is null or empty");
        }
        if (isEnable()) {
            try {
                int createCastSession = this.starryCast.createCastSession(packageName, this.mAppCode, 2, str);
                this.sessionId = createCastSession;
                if (createCastSession != Integer.MIN_VALUE) {
                    String str2 = this.sessionTag;
                    if (str2 == null || str2.isEmpty()) {
                        throw new IllegalArgumentException("sessionTag is null or empty");
                    }
                    int init = this.listenerManager.init(this.starryCast, this.sessionId, this.sessionTag);
                    return init != 0 ? init : SinkAudioListenerManager.getInstance().init(this.starryCast, this.sessionId, this.sessionTag);
                }
                throw new IllegalArgumentException("参数非法");
            } catch (HubRemoteException e) {
                SNSLog.e(TAG, "sink initCastSession failed:", e);
            } catch (HubTargetException e2) {
                SNSLog.e(TAG, "sink initCastSession failed:", e2);
                return ErrorCode.CODE_TARGET_UNAVAILABLE;
            }
        }
        return ErrorCode.CODE_SERVICE_UNAVAILABLE;
    }

    public /* bridge */ /* synthetic */ void onInstalled(Hub hub) {
        super.onInstalled(hub);
    }

    public /* bridge */ /* synthetic */ void onUninstalled() {
        super.onUninstalled();
    }

    public int pause(boolean z) {
        return pause(CastConst.DEFAULT_TAG, z);
    }

    public int reclaimAudioFocus() {
        if (this.sessionId == -1) {
            throw new IllegalStateException("Cast session not initialized yet");
        } else if (!isEnable()) {
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        } else {
            try {
                return this.starryCast.displaySinkReclaimAudioFocus(this.sessionId, 1);
            } catch (HubRemoteException e) {
                SNSLog.e(TAG, "reclaimAudioFocus failed:", e);
                return ErrorCode.CODE_SERVICE_UNAVAILABLE;
            } catch (HubTargetException e2) {
                SNSLog.e(TAG, "reclaimAudioFocus failed:", e2);
                return ErrorCode.CODE_TARGET_UNAVAILABLE;
            }
        }
    }

    public int registerSinkAudioListener(SinkAudioListener sinkAudioListener) {
        if (sinkAudioListener == null) {
            throw new NullPointerException("SinkAudioListener is null");
        } else if (this.sessionId != -1) {
            String str = this.sessionTag;
            if (str != null && !str.isEmpty()) {
                return SinkAudioListenerManager.getInstance().registerSinkAudioListener(this.sessionId, this.sessionTag, sinkAudioListener);
            }
            throw new IllegalStateException("sessionTag is null or empty");
        } else {
            throw new IllegalStateException("Cast session not initialized yet");
        }
    }

    public int registerSinkListener(SinkListener sinkListener) {
        if (sinkListener == null) {
            throw new NullPointerException("SinkListener is null");
        } else if (this.sessionId != -1) {
            String str = this.sessionTag;
            if (str != null && !str.isEmpty()) {
                return this.listenerManager.registerSinkListener(this.sessionTag, this.sessionId, sinkListener);
            }
            throw new IllegalArgumentException("sessionTag is null or empty");
        } else {
            throw new IllegalStateException("Cast session not initialized yet");
        }
    }

    public int registerSinkStartListener(SinkStartListener sinkStartListener) {
        if (sinkStartListener == null) {
            throw new NullPointerException("SinkStartListener is null");
        } else if (this.sessionId != -1) {
            return registerSinkListener(sinkStartListener);
        } else {
            throw new IllegalStateException("Cast session not initialized yet");
        }
    }

    public int registerSyncCallbackCode(int i) {
        if (this.sessionId == -1) {
            throw new IllegalStateException("Cast session not initialized yet");
        } else if (!isEnable()) {
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        } else {
            try {
                return this.starryCast.registerSyncCallbackCode(this.sessionId, 2, i);
            } catch (HubRemoteException e) {
                SNSLog.e(TAG, "sink registerSyncCallbackCode failed:", e);
                return ErrorCode.CODE_SERVICE_UNAVAILABLE;
            } catch (HubTargetException e2) {
                SNSLog.e(TAG, "sink registerSyncCallbackCode failed:", e2);
                return ErrorCode.CODE_TARGET_UNAVAILABLE;
            }
        }
    }

    public int removeVirtualDisplay(String str, byte[] bArr) {
        if (TextUtils.isEmpty(str)) {
            throw new NullPointerException("tag is null");
        } else if (this.sessionId == -1) {
            throw new IllegalStateException("Cast session not initialized yet");
        } else if (!isEnable()) {
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        } else {
            if (bArr == null) {
                return this.starryCast.displaySinkRemoveVirtualDisplay(this.sessionId, str);
            }
            try {
                return this.starryCast.displaySinkRemoveVirtualDisplayEx(this.sessionId, str, bArr);
            } catch (HubRemoteException e) {
                SNSLog.e(TAG, "removeVirtualDisplay failed:", e);
                return ErrorCode.CODE_SERVICE_UNAVAILABLE;
            } catch (HubTargetException e2) {
                SNSLog.e(TAG, "removeVirtualDisplay failed:", e2);
                return ErrorCode.CODE_TARGET_UNAVAILABLE;
            }
        }
    }

    public int resume() {
        return resume(CastConst.DEFAULT_TAG);
    }

    public int setOutputSurface(Surface surface, String str) {
        if (surface == null) {
            throw new NullPointerException("surface is null");
        } else if (TextUtils.isEmpty(str)) {
            throw new NullPointerException("tag is null");
        } else if (this.sessionId == -1) {
            throw new IllegalStateException("Cast session not initialized yet");
        } else if (!isEnable()) {
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        } else {
            try {
                return this.starryCast.displaySinkSetOutputSurface(this.sessionId, surface, str);
            } catch (HubRemoteException e) {
                SNSLog.e(TAG, "setOutputSurface failed:", e);
                return ErrorCode.CODE_SERVICE_UNAVAILABLE;
            } catch (HubTargetException e2) {
                SNSLog.e(TAG, "setOutputSurface failed:", e2);
                return ErrorCode.CODE_TARGET_UNAVAILABLE;
            }
        }
    }

    public int startDisplay(@Nullable Surface surface, @NonNull SinkDisplayConfig sinkDisplayConfig) {
        SinkDisplayConfig sinkDisplayConfig2;
        if (this.sessionId == -1) {
            throw new IllegalStateException("Cast session not initialized yet");
        } else if (sinkDisplayConfig == null) {
            throw new NullPointerException("config must not be null");
        } else if (sinkDisplayConfig.getWidth() <= 0 || sinkDisplayConfig.getHeight() <= 0) {
            throw new IllegalArgumentException("width or height must be positive");
        } else if (!isEnable()) {
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        } else {
            int checkSupportFeature = checkSupportFeature(CastFeature.FEATURE_DIVIDE_AUDIO);
            if (checkSupportFeature == 0) {
                sinkDisplayConfig2 = rebuildConfig(sinkDisplayConfig, true);
            } else if (checkSupportFeature != -514 && checkSupportFeature != -515 && checkSupportFeature != -516 && checkSupportFeature != -517) {
                return checkSupportFeature;
            } else {
                sinkDisplayConfig2 = rebuildConfig(sinkDisplayConfig, false);
            }
            if (surface != null) {
                try {
                    int displaySinkSurface = this.starryCast.setDisplaySinkSurface(this.sessionId, surface);
                    if (displaySinkSurface != 0) {
                        return displaySinkSurface;
                    }
                } catch (HubRemoteException e) {
                    SNSLog.e(TAG, "sink startDisplay failed:", e);
                    return ErrorCode.CODE_SERVICE_UNAVAILABLE;
                } catch (HubTargetException e2) {
                    SNSLog.e(TAG, "sink startDisplay failed:", e2);
                    return ErrorCode.CODE_TARGET_UNAVAILABLE;
                }
            }
            int displaySinkConfig = this.starryCast.setDisplaySinkConfig(this.sessionId, sinkDisplayConfig2);
            if (displaySinkConfig == Integer.MIN_VALUE) {
                throw new IllegalArgumentException("captureType or displayFlag is illegal");
            } else if (displaySinkConfig == -501 || displaySinkConfig != 0) {
                return displaySinkConfig;
            } else {
                SinkDisplayConfig sinkDisplayConfig3 = this.starryCast.getSinkDisplayConfig(this.sessionId);
                if (sinkDisplayConfig3 == null) {
                    SNSLog.e(TAG, "SinkDisplayConfig get from server side is null, should not happen");
                    return CastErrorCode.SESSION_STATE_ILLEGAL;
                }
                if ((sinkDisplayConfig3.getCaptureType() & 32768) != 0) {
                    if (!SinkAudioListenerManager.getInstance().isSinkAudioListenerRegistered(this.sessionId, this.sessionTag)) {
                        throw new IllegalStateException("capture type contains CAPTURE_TYPE_AUDIO_DIVIDED_WITHOUT_ENCODE, but SinkAudioListener not registered");
                    }
                }
                int displaySinkStart = this.starryCast.displaySinkStart(this.sessionId);
                if (displaySinkStart != Integer.MIN_VALUE) {
                    return displaySinkStart;
                }
                throw new IllegalArgumentException("config info not set successfully yet");
            }
        }
    }

    public int stopDisplay() {
        if (this.sessionId == -1) {
            throw new IllegalStateException("Cast session not initialized yet");
        } else if (!isEnable()) {
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        } else {
            try {
                return this.starryCast.displaySinkStop(this.sessionId);
            } catch (HubRemoteException e) {
                SNSLog.e(TAG, "sink stopDisplay failed:", e);
                return ErrorCode.CODE_SERVICE_UNAVAILABLE;
            } catch (HubTargetException e2) {
                SNSLog.e(TAG, "sink stopDisplay failed:", e2);
                return ErrorCode.CODE_TARGET_UNAVAILABLE;
            }
        }
    }

    public int uibcCustomEvent(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new NullPointerException("Custom event is null");
        } else if (this.sessionId == -1) {
            throw new IllegalStateException("Cast session not initialized yet");
        } else if (!isEnable()) {
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        } else {
            try {
                return this.starryCast.uibcCustomEvent(this.sessionId, str);
            } catch (HubRemoteException e) {
                SNSLog.e(TAG, "uibcCustomEvent failed:", e);
                return ErrorCode.CODE_SERVICE_UNAVAILABLE;
            } catch (HubTargetException e2) {
                SNSLog.e(TAG, "uibcCustomEvent failed:", e2);
                return ErrorCode.CODE_TARGET_UNAVAILABLE;
            }
        }
    }

    public int uibcKeyEvent(String str, int i, int i2) {
        if (TextUtils.isEmpty(str)) {
            throw new NullPointerException("tag is null");
        } else if (this.sessionId == -1) {
            throw new IllegalStateException("Cast session not initialized yet");
        } else if (!isEnable()) {
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        } else {
            try {
                return this.starryCast.uibcKeyEvent(this.sessionId, str, i, i2);
            } catch (HubRemoteException e) {
                SNSLog.e(TAG, "uibcKeyEvent failed:", e);
                return ErrorCode.CODE_SERVICE_UNAVAILABLE;
            } catch (HubTargetException e2) {
                SNSLog.e(TAG, "uibcKeyEvent failed:", e2);
                return ErrorCode.CODE_TARGET_UNAVAILABLE;
            }
        }
    }

    public int uibcTouchEvent(String str, int i, int i2, MotionEvent motionEvent) {
        if (TextUtils.isEmpty(str)) {
            throw new NullPointerException("tag is null");
        } else if (motionEvent == null) {
            throw new NullPointerException("MotionEvent is null");
        } else if (this.sessionId == -1) {
            throw new IllegalStateException("Cast session not initialized yet");
        } else if (!isEnable()) {
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        } else {
            try {
                return this.starryCast.uibcTouchEvent(this.sessionId, str, i, i2, motionEvent);
            } catch (HubRemoteException e) {
                SNSLog.e(TAG, "uibcTouchEvent failed:", e);
                return ErrorCode.CODE_SERVICE_UNAVAILABLE;
            } catch (HubTargetException e2) {
                SNSLog.e(TAG, "uibcTouchEvent failed:", e2);
                return ErrorCode.CODE_TARGET_UNAVAILABLE;
            }
        }
    }

    public int unregisterSinkAudioListener(SinkAudioListener sinkAudioListener) {
        if (sinkAudioListener == null) {
            throw new NullPointerException("SinkAudioListener is null");
        } else if (this.sessionId != -1) {
            String str = this.sessionTag;
            if (str != null && !str.isEmpty()) {
                return SinkAudioListenerManager.getInstance().unregisterSinkAudioListener(this.sessionId, this.sessionTag, sinkAudioListener);
            }
            throw new IllegalStateException("sessionTag is null or empty");
        } else {
            throw new IllegalStateException("Cast session not initialized yet");
        }
    }

    public int unregisterSinkListener(SinkListener sinkListener) {
        if (sinkListener == null) {
            throw new NullPointerException("SinkListener is null");
        } else if (this.sessionId != -1) {
            String str = this.sessionTag;
            if (str != null && !str.isEmpty()) {
                return this.listenerManager.unregisterSinkListener(this.sessionTag, this.sessionId, sinkListener);
            }
            throw new IllegalArgumentException("sessionTag is null or empty");
        } else {
            throw new IllegalStateException("Cast session not initialized yet");
        }
    }

    public int unregisterSinkStartListener(SinkStartListener sinkStartListener) {
        if (sinkStartListener == null) {
            throw new NullPointerException("SinkStartListener is null");
        } else if (this.sessionId != -1) {
            return unregisterSinkListener(sinkStartListener);
        } else {
            throw new IllegalStateException("Cast session not initialized yet");
        }
    }

    public int pause(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            throw new NullPointerException("tag is null");
        } else if (this.sessionId == -1) {
            throw new IllegalStateException("Cast session not initialized yet");
        } else if (!isEnable()) {
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        } else {
            try {
                return this.starryCast.displaySinkPause(this.sessionId, str, z);
            } catch (HubRemoteException e) {
                SNSLog.e(TAG, "sink pause failed:", e);
                return ErrorCode.CODE_SERVICE_UNAVAILABLE;
            } catch (HubTargetException e2) {
                SNSLog.e(TAG, "sink pause failed:", e2);
                return ErrorCode.CODE_TARGET_UNAVAILABLE;
            }
        }
    }

    public int resume(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new NullPointerException("tag is null");
        } else if (this.sessionId == -1) {
            throw new IllegalStateException("Cast session not initialized yet");
        } else if (!isEnable()) {
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        } else {
            try {
                return this.starryCast.displaySinkResume(this.sessionId, str);
            } catch (HubRemoteException e) {
                SNSLog.e(TAG, "sink resume failed:", e);
                return ErrorCode.CODE_SERVICE_UNAVAILABLE;
            } catch (HubTargetException e2) {
                SNSLog.e(TAG, "sink resume failed:", e2);
                return ErrorCode.CODE_TARGET_UNAVAILABLE;
            }
        }
    }

    public int removeVirtualDisplay(String str) {
        return removeVirtualDisplay(str, (byte[]) null);
    }
}
