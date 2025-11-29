package com.upuphone.starrynetsdk.ability.cast;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.upuphone.hub.HubRemoteException;
import com.upuphone.hub.HubTargetException;
import com.upuphone.runasone.uupcast.CameraType;
import com.upuphone.runasone.uupcast.MicType;
import com.upuphone.runasone.uupcast.api.IVirtualDeviceEventListener;
import com.upuphone.starrynetsdk.api.ErrorCode;
import com.upuphone.starrynetsdk.api.SNSLog;
import com.upuphone.starrynetsdk.api.Util;

public class CastSourceVirtualDeviceAbility extends CastVirtualDeviceAbility {
    private static final String TAG = "VDAbility";
    private final String mAppCode;
    private final Context mContext;
    private volatile int mSessionId = -1;
    private SourceVirtualDeviceEventListener mSourceVirtualDeviceEventListener = new SourceVirtualDeviceEventListener(this);
    /* access modifiers changed from: private */
    public VirtualDeviceEventListener mVirtualDeviceEventListener;

    public static final class SourceVirtualDeviceEventListener implements IVirtualDeviceEventListener {
        private CastSourceVirtualDeviceAbility mSourceAbility;

        public SourceVirtualDeviceEventListener(CastSourceVirtualDeviceAbility castSourceVirtualDeviceAbility) {
            this.mSourceAbility = castSourceVirtualDeviceAbility;
        }

        public void onError(int i, String str) {
            Log.d(CastSourceVirtualDeviceAbility.TAG, "SinkVirtualDeviceEventListener" + i);
            CastSourceVirtualDeviceAbility castSourceVirtualDeviceAbility = this.mSourceAbility;
            if (castSourceVirtualDeviceAbility != null && castSourceVirtualDeviceAbility.mVirtualDeviceEventListener != null) {
                this.mSourceAbility.mVirtualDeviceEventListener.onError(i, str);
            }
        }

        public void onEvent(int i, Bundle bundle) {
            Log.d(CastSourceVirtualDeviceAbility.TAG, "SourceVirtualDeviceEventListener" + i);
            CastSourceVirtualDeviceAbility castSourceVirtualDeviceAbility = this.mSourceAbility;
            if (castSourceVirtualDeviceAbility != null && castSourceVirtualDeviceAbility.mVirtualDeviceEventListener != null) {
                this.mSourceAbility.mVirtualDeviceEventListener.onEvent(i, bundle);
            }
        }
    }

    public CastSourceVirtualDeviceAbility(@NonNull Context context) {
        this.mContext = context;
        String appUniteCode = Util.getAppUniteCode(context);
        this.mAppCode = appUniteCode;
        if (TextUtils.isEmpty(appUniteCode)) {
            throw new IllegalStateException("App unite code not configured in Manifest");
        }
    }

    public int enableCameraByType(@CameraType int i) {
        if (!isEnable()) {
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        }
        try {
            return this.vdCast.enableCameraByType(i);
        } catch (HubRemoteException e) {
            SNSLog.e(TAG, "enableCameraByType failed:", e);
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        } catch (HubTargetException e2) {
            SNSLog.e(TAG, "enableCameraByType failed:", e2);
            return ErrorCode.CODE_TARGET_UNAVAILABLE;
        }
    }

    public int enableMicByType(@MicType int i) {
        if (!isEnable()) {
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        }
        try {
            return this.vdCast.enableMicByType(i);
        } catch (HubRemoteException e) {
            SNSLog.e(TAG, "enableMicByType failed:", e);
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        } catch (HubTargetException e2) {
            SNSLog.e(TAG, "enableMicByType failed:", e2);
            return ErrorCode.CODE_TARGET_UNAVAILABLE;
        }
    }

    public int registerVirtualCamera() {
        if (!isEnable()) {
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        }
        try {
            return this.vdCast.registerVirtualCamera(this.mSessionId);
        } catch (HubRemoteException e) {
            SNSLog.e(TAG, "registerVirtualCamera failed:", e);
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        } catch (HubTargetException e2) {
            SNSLog.e(TAG, "registerVirtualCamera failed:", e2);
            return ErrorCode.CODE_TARGET_UNAVAILABLE;
        }
    }

    @Deprecated
    public int registerVirtualMic() {
        if (!isEnable()) {
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        }
        try {
            return this.vdCast.registerVirtualMic(this.mSessionId);
        } catch (HubRemoteException e) {
            SNSLog.e(TAG, "registerVirtualMic failed:", e);
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        } catch (HubTargetException e2) {
            SNSLog.e(TAG, "registerVirtualMic failed:", e2);
            return ErrorCode.CODE_TARGET_UNAVAILABLE;
        }
    }

    public int registerVirtualModem() {
        if (!isEnable()) {
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        }
        try {
            return this.vdCast.registerVirtualModem(this.mSessionId);
        } catch (HubRemoteException e) {
            SNSLog.e(TAG, "registerVirtualModem failed:", e);
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        } catch (HubTargetException e2) {
            SNSLog.e(TAG, "registerVirtualModem failed:", e2);
            return ErrorCode.CODE_TARGET_UNAVAILABLE;
        }
    }

    public int setEventCallback(VirtualDeviceEventListener virtualDeviceEventListener) {
        if (!isEnable()) {
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        }
        this.mVirtualDeviceEventListener = virtualDeviceEventListener;
        try {
            return this.vdCast.setSourceEventCallback(this.mSourceVirtualDeviceEventListener);
        } catch (HubRemoteException e) {
            SNSLog.e(TAG, "setEventCallback failed:", e);
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        } catch (HubTargetException e2) {
            SNSLog.e(TAG, "setEventCallback failed:", e2);
            return ErrorCode.CODE_TARGET_UNAVAILABLE;
        }
    }

    public int startVirtualDeviceSource() {
        if (!isEnable()) {
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        }
        try {
            return this.vdCast.startSourceClient();
        } catch (HubRemoteException e) {
            SNSLog.e(TAG, "startVirtualDeviceSource failed:", e);
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        } catch (HubTargetException e2) {
            SNSLog.e(TAG, "startVirtualDeviceSource failed:", e2);
            return ErrorCode.CODE_TARGET_UNAVAILABLE;
        }
    }

    public int stopVirtualDeviceSource() {
        if (!isEnable()) {
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        }
        try {
            return this.vdCast.stopSourceClient();
        } catch (HubRemoteException e) {
            SNSLog.e(TAG, "stopVirtualDeviceSource failed:", e);
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        } catch (HubTargetException e2) {
            SNSLog.e(TAG, "stopVirtualDeviceSource failed:", e2);
            return ErrorCode.CODE_TARGET_UNAVAILABLE;
        }
    }

    public int unregisterVirtualCamera() {
        if (!isEnable()) {
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        }
        try {
            return this.vdCast.unregisterVirtualCamera(this.mSessionId);
        } catch (HubRemoteException e) {
            SNSLog.e(TAG, "unregisterVirtualCamera failed:", e);
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        } catch (HubTargetException e2) {
            SNSLog.e(TAG, "unregisterVirtualCamera failed:", e2);
            return ErrorCode.CODE_TARGET_UNAVAILABLE;
        }
    }

    @Deprecated
    public int unregisterVirtualMic() {
        if (!isEnable()) {
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        }
        try {
            return this.vdCast.unregisterVirtualMic(this.mSessionId);
        } catch (HubRemoteException e) {
            SNSLog.e(TAG, "unregisterVirtualMic failed:", e);
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        } catch (HubTargetException e2) {
            SNSLog.e(TAG, "unregisterVirtualMic failed:", e2);
            return ErrorCode.CODE_TARGET_UNAVAILABLE;
        }
    }

    public int unregisterVirtualModem() {
        if (!isEnable()) {
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        }
        try {
            return this.vdCast.unregisterVirtualModem(this.mSessionId);
        } catch (HubRemoteException e) {
            SNSLog.e(TAG, "unregisterVirtualModem failed:", e);
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        } catch (HubTargetException e2) {
            SNSLog.e(TAG, "unregisterVirtualModem failed:", e2);
            return ErrorCode.CODE_TARGET_UNAVAILABLE;
        }
    }

    public int unsetEventCallback() {
        if (!isEnable()) {
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        }
        try {
            return this.vdCast.unsetSourceEventCallback();
        } catch (HubRemoteException e) {
            SNSLog.e(TAG, "setEventCallback failed:", e);
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        } catch (HubTargetException e2) {
            SNSLog.e(TAG, "setEventCallback failed:", e2);
            return ErrorCode.CODE_TARGET_UNAVAILABLE;
        }
    }
}
