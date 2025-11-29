package com.upuphone.starrynetsdk.ability.cast;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.upuphone.hub.Hub;
import com.upuphone.hub.HubRemoteException;
import com.upuphone.hub.HubTargetException;
import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.runasone.uupcast.AudioPolicy;
import com.upuphone.runasone.uupcast.CastErrorCode;
import com.upuphone.runasone.uupcast.CastFeature;
import com.upuphone.runasone.uupcast.SourceDisplayConfig;
import com.upuphone.starrynetsdk.api.ErrorCode;
import com.upuphone.starrynetsdk.api.SNSLog;
import com.upuphone.starrynetsdk.api.Util;

public final class CastSourceAbility extends CastAbility {
    private static final String TAG = "CastAbility";
    private final DisplayListenerManager listenerManager;
    private final String mAppCode;
    private final Context mContext;
    private volatile int mSessionId = -1;

    public CastSourceAbility(@NonNull Context context) {
        this.mContext = context;
        String appUniteCode = Util.getAppUniteCode(context);
        this.mAppCode = appUniteCode;
        if (!TextUtils.isEmpty(appUniteCode)) {
            this.listenerManager = DisplayListenerManager.getInstance();
            return;
        }
        throw new IllegalStateException("App unite code not configured in Manifest");
    }

    private int checkSupportFeature(@NonNull StarryDevice starryDevice, @CastFeature String str) {
        if (str == null || TextUtils.isEmpty(str)) {
            throw new NullPointerException("param feature is null or empty");
        } else if (!isEnable()) {
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        } else {
            try {
                return this.starryCast.sourceCheckFeatureSupported(starryDevice, str);
            } catch (HubRemoteException e) {
                SNSLog.e(TAG, "source checkSupportFeature failed:", e);
                return ErrorCode.CODE_SERVICE_UNAVAILABLE;
            } catch (HubTargetException e2) {
                SNSLog.e(TAG, "source checkSupportFeature failed:", e2);
                return CastErrorCode.SOURCE_NOT_SUPPORT_FEATURE;
            }
        }
    }

    @SuppressLint({"WrongConstant"})
    private SourceDisplayConfig rebuildConfig(@NonNull SourceDisplayConfig sourceDisplayConfig, boolean z) {
        int captureType = sourceDisplayConfig.getCaptureType();
        if ((32768 & captureType) == 0 || z) {
            return sourceDisplayConfig;
        }
        int i = -32769 & captureType;
        SNSLog.i(TAG, "convert config, originalCaptureType:" + captureType + ", finalCaptureType:" + i);
        return new SourceDisplayConfig.Builder(sourceDisplayConfig).setCaptureType(i).build();
    }

    public int enableAudioPolicy(@AudioPolicy int i) {
        if (this.mSessionId == -1) {
            throw new IllegalStateException("Cast session not initialized yet");
        } else if (!isEnable()) {
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        } else {
            try {
                return this.starryCast.enableAudioPolicy(this.mSessionId, i);
            } catch (HubRemoteException e) {
                SNSLog.e(TAG, "enableAudioPolicy failed:", e);
                return ErrorCode.CODE_SERVICE_UNAVAILABLE;
            } catch (HubTargetException e2) {
                SNSLog.e(TAG, "enableAudioPolicy failed:", e2);
                return ErrorCode.CODE_TARGET_UNAVAILABLE;
            }
        }
    }

    public int enableRecordPhoneCallRing(boolean z) {
        if (this.mSessionId == -1) {
            throw new IllegalStateException("Cast session not initialized yet");
        } else if (!isEnable()) {
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        } else {
            try {
                return this.starryCast.enableRecordPhoneCallRing(this.mSessionId, z);
            } catch (HubRemoteException e) {
                SNSLog.e(TAG, "enableRecordPhoneCallRing failed:", e);
                return ErrorCode.CODE_SERVICE_UNAVAILABLE;
            } catch (HubTargetException e2) {
                SNSLog.e(TAG, "enableRecordPhoneCallRing failed:", e2);
                return ErrorCode.CODE_TARGET_UNAVAILABLE;
            }
        }
    }

    public int getCastSessionId() {
        if (this.mSessionId != -1) {
            return this.mSessionId;
        }
        throw new IllegalStateException("Cast session not initialized yet");
    }

    public int getDisplayID() {
        if (this.mSessionId == -1) {
            throw new IllegalStateException("Cast session not initialized yet");
        } else if (!isEnable()) {
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        } else {
            try {
                return this.starryCast.getDisplayID(this.mSessionId);
            } catch (HubRemoteException e) {
                SNSLog.e(TAG, "getDisplayID failed:", e);
                return ErrorCode.CODE_SERVICE_UNAVAILABLE;
            } catch (HubTargetException e2) {
                SNSLog.e(TAG, "getDisplayID failed:", e2);
                return ErrorCode.CODE_TARGET_UNAVAILABLE;
            }
        }
    }

    public int getDisplayState() {
        if (this.mSessionId == -1) {
            throw new IllegalStateException("Cast session not initialized yet");
        } else if (!isEnable()) {
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        } else {
            try {
                return this.starryCast.getDisplayState(this.mSessionId);
            } catch (HubRemoteException e) {
                SNSLog.e(TAG, "source getDisplayState failed:", e);
                return ErrorCode.CODE_SERVICE_UNAVAILABLE;
            } catch (HubTargetException e2) {
                SNSLog.e(TAG, "source getDisplayState failed:", e2);
                return ErrorCode.CODE_TARGET_UNAVAILABLE;
            }
        }
    }

    public int initCastSession(String str) {
        if (str == null || TextUtils.isEmpty(str.trim())) {
            throw new NullPointerException("castSessionTag must not be null or empty");
        }
        this.sessionTag = str;
        String packageName = this.mContext.getPackageName();
        if (packageName == null || TextUtils.isEmpty(packageName.trim())) {
            throw new NullPointerException("package name is null or empty");
        }
        if (isEnable()) {
            try {
                this.mSessionId = this.starryCast.createCastSession(packageName, this.mAppCode, 1, str);
                if (this.mSessionId != Integer.MIN_VALUE) {
                    String str2 = this.sessionTag;
                    if (str2 != null && !str2.isEmpty()) {
                        return this.listenerManager.init(this.starryCast, this.mAppCode, this.mSessionId, this.sessionTag);
                    }
                    throw new IllegalArgumentException("sessionTag is null or empty");
                }
                throw new IllegalArgumentException("参数非法");
            } catch (HubRemoteException e) {
                SNSLog.e(TAG, "source initCastSession failed:", e);
            } catch (HubTargetException e2) {
                SNSLog.e(TAG, "source initCastSession failed:", e2);
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

    public int registerDisplayListener(DisplayListener displayListener) {
        if (displayListener == null) {
            throw new NullPointerException("DisplayListener is null");
        } else if (this.mSessionId != -1) {
            String str = this.sessionTag;
            if (str != null && !str.isEmpty()) {
                return this.listenerManager.registerDisplayListener(this.sessionTag, this.mSessionId, displayListener);
            }
            throw new IllegalStateException("Cast sessionTag error");
        } else {
            throw new IllegalStateException("Cast session not initialized yet");
        }
    }

    public int registerSyncCallbackCode(int i) {
        if (this.mSessionId == -1) {
            throw new IllegalStateException("Cast session not initialized yet");
        } else if (!isEnable()) {
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        } else {
            try {
                return this.starryCast.registerSyncCallbackCode(this.mSessionId, 1, i);
            } catch (HubRemoteException e) {
                SNSLog.e(TAG, "source registerSyncCallbackCode failed:", e);
                return ErrorCode.CODE_SERVICE_UNAVAILABLE;
            } catch (HubTargetException e2) {
                SNSLog.e(TAG, "source registerSyncCallbackCode failed:", e2);
                return ErrorCode.CODE_TARGET_UNAVAILABLE;
            }
        }
    }

    public int resume() {
        return resume(CastConst.DEFAULT_TAG);
    }

    public int setUibcChannel(int i) {
        if (this.mSessionId == -1) {
            throw new IllegalStateException("Cast session not initialized yet");
        } else if (!isEnable()) {
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        } else {
            try {
                int uIBCChannel = this.starryCast.setUIBCChannel(this.mSessionId, "default", i);
                if (uIBCChannel != Integer.MIN_VALUE) {
                    return uIBCChannel;
                }
                throw new IllegalArgumentException("通道tag为空");
            } catch (HubRemoteException e) {
                SNSLog.e(TAG, "setUibcChannel failed:", e);
                return ErrorCode.CODE_SERVICE_UNAVAILABLE;
            } catch (HubTargetException e2) {
                SNSLog.e(TAG, "setUibcChannel failed:", e2);
                return ErrorCode.CODE_TARGET_UNAVAILABLE;
            }
        }
    }

    public int startDisplay(@NonNull StarryDevice starryDevice, @Nullable SourceDisplayConfig sourceDisplayConfig) {
        if (this.mSessionId == -1) {
            throw new IllegalStateException("Cast session not initialized yet");
        } else if (!isEnable()) {
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        } else {
            if (sourceDisplayConfig != null) {
                int checkSupportFeature = checkSupportFeature(starryDevice, CastFeature.FEATURE_DIVIDE_AUDIO);
                if (checkSupportFeature == 0) {
                    sourceDisplayConfig = rebuildConfig(sourceDisplayConfig, true);
                } else if (checkSupportFeature != -514 && checkSupportFeature != -515 && checkSupportFeature != -516 && checkSupportFeature != -517) {
                    return checkSupportFeature;
                } else {
                    sourceDisplayConfig = rebuildConfig(sourceDisplayConfig, false);
                }
            }
            try {
                return this.starryCast.startDisplay(this.mSessionId, this.mAppCode, starryDevice, sourceDisplayConfig);
            } catch (HubRemoteException e) {
                SNSLog.e(TAG, "source startDisplay failed:", e);
                return ErrorCode.CODE_SERVICE_UNAVAILABLE;
            } catch (HubTargetException e2) {
                SNSLog.e(TAG, "source startDisplay failed:", e2);
                return ErrorCode.CODE_TARGET_UNAVAILABLE;
            }
        }
    }

    public int stopDisplay() {
        if (this.mSessionId == -1) {
            throw new IllegalStateException("Cast session not initialized yet");
        } else if (!isEnable()) {
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        } else {
            try {
                return this.starryCast.stopDisplay(this.mSessionId);
            } catch (HubRemoteException e) {
                SNSLog.e(TAG, "source stopDisplay failed:", e);
                return ErrorCode.CODE_SERVICE_UNAVAILABLE;
            } catch (HubTargetException e2) {
                SNSLog.e(TAG, "source stopDisplay failed:", e2);
                return ErrorCode.CODE_TARGET_UNAVAILABLE;
            }
        }
    }

    public int unregisterDisplayListener(DisplayListener displayListener) {
        if (displayListener == null) {
            throw new NullPointerException("DisplayListener is null");
        } else if (this.mSessionId != -1) {
            String str = this.sessionTag;
            if (str != null && !str.isEmpty()) {
                return this.listenerManager.unregisterDisplayListener(this.sessionTag, this.mSessionId, displayListener);
            }
            throw new IllegalStateException("Cast sessionTag error");
        } else {
            throw new IllegalStateException("Cast session not initialized yet");
        }
    }

    public int pause(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            throw new NullPointerException("tag is null");
        } else if (this.mSessionId == -1) {
            throw new IllegalStateException("Cast session not initialized yet");
        } else if (!isEnable()) {
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        } else {
            try {
                return this.starryCast.pauseSource(this.mSessionId, str, z);
            } catch (HubRemoteException e) {
                SNSLog.e(TAG, "source pause failed:", e);
                return ErrorCode.CODE_SERVICE_UNAVAILABLE;
            } catch (HubTargetException e2) {
                SNSLog.e(TAG, "source pause failed:", e2);
                return ErrorCode.CODE_TARGET_UNAVAILABLE;
            }
        }
    }

    public int resume(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new NullPointerException("tag is null");
        } else if (this.mSessionId == -1) {
            throw new IllegalStateException("Cast session not initialized yet");
        } else if (!isEnable()) {
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        } else {
            try {
                return this.starryCast.resumeSource(this.mSessionId, str);
            } catch (HubRemoteException e) {
                SNSLog.e(TAG, "source resume failed:", e);
                return ErrorCode.CODE_SERVICE_UNAVAILABLE;
            } catch (HubTargetException e2) {
                SNSLog.e(TAG, "source resume failed:", e2);
                return ErrorCode.CODE_TARGET_UNAVAILABLE;
            }
        }
    }

    public int stopDisplay(StarryDevice starryDevice) {
        if (this.mSessionId == -1) {
            throw new IllegalStateException("Cast session not initialized yet");
        } else if (!isEnable()) {
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        } else {
            try {
                return this.starryCast.stopMultiDisplay(this.mSessionId, starryDevice);
            } catch (HubRemoteException e) {
                SNSLog.e(TAG, "source stopDisplay failed:", e);
                return ErrorCode.CODE_SERVICE_UNAVAILABLE;
            } catch (HubTargetException e2) {
                SNSLog.e(TAG, "source stopDisplay failed:", e2);
                return ErrorCode.CODE_TARGET_UNAVAILABLE;
            }
        }
    }
}
