package com.upuphone.starrynetsdk.ability.cast;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.upuphone.hub.HubRemoteException;
import com.upuphone.hub.HubTargetException;
import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.runasone.uupcast.api.IVirtualDeviceEventListener;
import com.upuphone.starrynetsdk.api.ErrorCode;
import com.upuphone.starrynetsdk.api.SNSLog;
import com.upuphone.starrynetsdk.api.Util;

public class CastSinkVirtualDeviceAbility extends CastVirtualDeviceAbility {
    private static final String TAG = "VDAbility";
    private final String mAppCode;
    private Context mContext;
    private SinkVirtualDeviceEventListener mSourceVirtualDeviceEventListener = new SinkVirtualDeviceEventListener(this);
    /* access modifiers changed from: private */
    public VirtualDeviceEventListener mVirtualDeviceEventListener;

    public static final class SinkVirtualDeviceEventListener implements IVirtualDeviceEventListener {
        private CastSinkVirtualDeviceAbility mSinkAbility;

        public SinkVirtualDeviceEventListener(CastSinkVirtualDeviceAbility castSinkVirtualDeviceAbility) {
            this.mSinkAbility = castSinkVirtualDeviceAbility;
        }

        public void onError(int i, String str) {
            Log.d(CastSinkVirtualDeviceAbility.TAG, "SinkVirtualDeviceEventListener" + i);
            CastSinkVirtualDeviceAbility castSinkVirtualDeviceAbility = this.mSinkAbility;
            if (castSinkVirtualDeviceAbility != null && castSinkVirtualDeviceAbility.mVirtualDeviceEventListener != null) {
                this.mSinkAbility.mVirtualDeviceEventListener.onError(i, str);
            }
        }

        public void onEvent(int i, Bundle bundle) {
            Log.d(CastSinkVirtualDeviceAbility.TAG, "SinkVirtualDeviceEventListener" + i);
            CastSinkVirtualDeviceAbility castSinkVirtualDeviceAbility = this.mSinkAbility;
            if (castSinkVirtualDeviceAbility != null && castSinkVirtualDeviceAbility.mVirtualDeviceEventListener != null) {
                this.mSinkAbility.mVirtualDeviceEventListener.onEvent(i, bundle);
            }
        }
    }

    public CastSinkVirtualDeviceAbility(Context context) {
        this.mContext = context;
        String appUniteCode = Util.getAppUniteCode(context);
        this.mAppCode = appUniteCode;
        if (TextUtils.isEmpty(appUniteCode)) {
            throw new IllegalStateException("App unite code not configured in Manifest");
        }
    }

    public int setEventCallback(VirtualDeviceEventListener virtualDeviceEventListener) {
        if (!isEnable()) {
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        }
        this.mVirtualDeviceEventListener = virtualDeviceEventListener;
        try {
            return this.vdCast.setSinkEventCallback(this.mSourceVirtualDeviceEventListener);
        } catch (HubRemoteException e) {
            SNSLog.e(TAG, "setEventCallback failed:", e);
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        } catch (HubTargetException e2) {
            SNSLog.e(TAG, "setEventCallback failed:", e2);
            return ErrorCode.CODE_TARGET_UNAVAILABLE;
        }
    }

    public int startVirtualDeviceSink(StarryDevice starryDevice) {
        if (!isEnable()) {
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        }
        try {
            return this.vdCast.startSinkServer(starryDevice);
        } catch (HubRemoteException e) {
            SNSLog.e(TAG, "startVirtualDeviceSink failed:", e);
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        } catch (HubTargetException e2) {
            SNSLog.e(TAG, "startVirtualDeviceSink failed:", e2);
            return ErrorCode.CODE_TARGET_UNAVAILABLE;
        }
    }

    public int stopVirtualDeviceSink() {
        if (!isEnable()) {
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        }
        try {
            return this.vdCast.stopSinkServer();
        } catch (HubRemoteException e) {
            SNSLog.e(TAG, "stopVirtualDeviceSink failed:", e);
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        } catch (HubTargetException e2) {
            SNSLog.e(TAG, "stopVirtualDeviceSink failed:", e2);
            return ErrorCode.CODE_TARGET_UNAVAILABLE;
        }
    }

    public int unsetEventCallback() {
        if (!isEnable()) {
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        }
        try {
            return this.vdCast.unsetSinkEventCallback();
        } catch (HubRemoteException e) {
            SNSLog.e(TAG, "setEventCallback failed:", e);
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        } catch (HubTargetException e2) {
            SNSLog.e(TAG, "setEventCallback failed:", e2);
            return ErrorCode.CODE_TARGET_UNAVAILABLE;
        }
    }
}
