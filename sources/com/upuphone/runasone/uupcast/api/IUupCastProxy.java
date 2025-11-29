package com.upuphone.runasone.uupcast.api;

import android.os.Bundle;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.Surface;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.honey.account.view.web.WebJs;
import com.meizu.common.datetimepicker.date.MonthView;
import com.upuphone.hub.Hub;
import com.upuphone.hub.HubRemoteException;
import com.upuphone.hub.HubTargetException;
import com.upuphone.runasone.constant.Constants;
import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.runasone.uupcast.ApiConstant;
import com.upuphone.runasone.uupcast.SinkDisplayConfig;
import com.upuphone.runasone.uupcast.SourceDisplayConfig;
import com.upuphone.starrynetsdk.ability.cast.CastConst;
import com.xjsd.ai.assistant.protocol.AssistantConstants;
import java.lang.reflect.Type;
import sdk.meizu.account.factor.authentication.sdk.constant.ConstantKt;

public final class IUupCastProxy implements IUupCast {
    private final Gson gson = new Gson();
    private Hub hub;

    public int createCastSession(String str, String str2, int i, String str3) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "createCastSession");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", "abilityCast");
        bundle.putString("ownerApp", str);
        bundle.putString("appUniteCode", str2);
        bundle.putInt("role", i);
        bundle.putString("tag", str3);
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

    public int displaySinkAddVirtualDisplay(int i, Surface surface, SinkDisplayConfig sinkDisplayConfig) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "displaySinkAddVirtualDisplay");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", "abilityCast");
        bundle.putInt("id", i);
        bundle.putParcelable("surface", surface);
        bundle.putString("config", this.gson.toJson((Object) sinkDisplayConfig));
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

    public int displaySinkPause(int i, String str, boolean z) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "displaySinkPause");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", "abilityCast");
        bundle.putInt("id", i);
        bundle.putString("tag", str);
        bundle.putBoolean("withAudio", z);
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

    public int displaySinkReclaimAudioFocus(int i, int i2) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "displaySinkReclaimAudioFocus");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", "abilityCast");
        bundle.putInt("id", i);
        bundle.putInt("audioTypeMask", i2);
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

    public int displaySinkRemoveVirtualDisplay(int i, String str) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "displaySinkRemoveVirtualDisplay");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", "abilityCast");
        bundle.putInt("id", i);
        bundle.putString("tag", str);
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

    public int displaySinkRemoveVirtualDisplayEx(int i, String str, byte[] bArr) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "displaySinkRemoveVirtualDisplayEx");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", "abilityCast");
        bundle.putInt("id", i);
        bundle.putString("tag", str);
        bundle.putByteArray("exdata", bArr);
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

    public int displaySinkResume(int i, String str) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "displaySinkResume");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", "abilityCast");
        bundle.putInt("id", i);
        bundle.putString("tag", str);
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

    public int displaySinkSetAudioListener(int i, ISinkAudioListener iSinkAudioListener) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "displaySinkSetAudioListener");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", "abilityCast");
        bundle.putInt("id", i);
        if (iSinkAudioListener != null) {
            bundle.putBinder(ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, new ISinkAudioListenerAdapter(iSinkAudioListener));
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

    public int displaySinkSetOutputSurface(int i, Surface surface, String str) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "displaySinkSetOutputSurface");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", "abilityCast");
        bundle.putInt("id", i);
        bundle.putParcelable("surface", surface);
        bundle.putString("tag", str);
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

    public int displaySinkStart(int i) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "displaySinkStart");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", "abilityCast");
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

    public int displaySinkStop(int i) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "displaySinkStop");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", "abilityCast");
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

    public int enableAudioPolicy(int i, int i2) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "enableAudioPolicy");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", "abilityCast");
        bundle.putInt(AssistantConstants.Key.SESSION_ID, i);
        bundle.putInt("audioPolicy", i2);
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

    public int enableRecordPhoneCallRing(int i, boolean z) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "enableRecordPhoneCallRing");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", "abilityCast");
        bundle.putInt(AssistantConstants.Key.SESSION_ID, i);
        bundle.putBoolean("enable", z);
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

    public int getDisplayID(int i) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "getDisplayID");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", "abilityCast");
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

    public int getDisplayState(int i) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "getDisplayState");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", "abilityCast");
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

    public SinkDisplayConfig getSinkDisplayConfig(int i) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "getSinkDisplayConfig");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", "abilityCast");
        bundle.putInt("id", i);
        try {
            this.hub.transfer(bundle, bundle2);
            Type type = new TypeToken<SinkDisplayConfig>() {
            }.getType();
            return (SinkDisplayConfig) this.gson.fromJson(bundle2.getString("result"), type);
        } catch (RemoteException e) {
            throw new HubRemoteException(e);
        } catch (UnsupportedOperationException e2) {
            if ("target method not found".equals(e2.getMessage())) {
                throw new HubTargetException("target method not found");
            }
            throw e2;
        }
    }

    public int pauseSource(int i, String str, boolean z) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "pauseSource");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", "abilityCast");
        bundle.putInt(AssistantConstants.Key.SESSION_ID, i);
        bundle.putString("tag", str);
        bundle.putBoolean("withAudio", z);
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

    public int registerDisplayListener(int i, String str, IDisplayListener iDisplayListener) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "registerDisplayListener");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", "abilityCast");
        bundle.putInt("id", i);
        bundle.putString(ConstantKt.FACTOR_PARAMS_PACKAGE_NAME, str);
        if (iDisplayListener != null) {
            bundle.putBinder(ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, new IDisplayListenerAdapter(iDisplayListener));
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

    public int registerSinkListener(int i, ISinkListener iSinkListener) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "registerSinkListener");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", "abilityCast");
        bundle.putInt("id", i);
        if (iSinkListener != null) {
            bundle.putBinder(ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, new ISinkListenerAdapter(iSinkListener));
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

    public int registerSyncCallbackCode(int i, int i2, int i3) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "registerSyncCallbackCode");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", "abilityCast");
        bundle.putInt(AssistantConstants.Key.SESSION_ID, i);
        bundle.putInt("role", i2);
        bundle.putInt("syncCallbackCode", i3);
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

    public int resumeSource(int i, String str) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "resumeSource");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", "abilityCast");
        bundle.putInt(AssistantConstants.Key.SESSION_ID, i);
        bundle.putString("tag", str);
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

    public int setDisplaySinkConfig(int i, SinkDisplayConfig sinkDisplayConfig) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "setDisplaySinkConfig");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", "abilityCast");
        bundle.putInt("id", i);
        bundle.putString("config", this.gson.toJson((Object) sinkDisplayConfig));
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

    public int setDisplaySinkSurface(int i, Surface surface) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "setDisplaySinkSurface");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", "abilityCast");
        bundle.putInt("id", i);
        bundle.putParcelable("surface", surface);
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

    public int setUIBCChannel(int i, String str, int i2) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "setUIBCChannel");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", "abilityCast");
        bundle.putInt("id", i);
        bundle.putString("eventTag", str);
        bundle.putInt(CastConst.DISPLAYID, i2);
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

    public int sinkCheckFeatureSupported(int i, String str) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "sinkCheckFeatureSupported");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", "abilityCast");
        bundle.putInt("id", i);
        bundle.putString("feature", str);
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

    public int sourceCheckFeatureSupported(StarryDevice starryDevice, String str) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "sourceCheckFeatureSupported");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", "abilityCast");
        bundle.putString(Constants.DEVICE_ID, this.gson.toJson((Object) starryDevice));
        bundle.putString("feature", str);
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

    public int startDisplay(int i, String str, StarryDevice starryDevice, SourceDisplayConfig sourceDisplayConfig) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "startDisplay");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", "abilityCast");
        bundle.putInt("id", i);
        bundle.putString(ConstantKt.FACTOR_PARAMS_PACKAGE_NAME, str);
        bundle.putString("deviceid", this.gson.toJson((Object) starryDevice));
        bundle.putString("config", this.gson.toJson((Object) sourceDisplayConfig));
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

    public int stopDisplay(int i) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "stopDisplay");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", "abilityCast");
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

    public int stopMultiDisplay(int i, StarryDevice starryDevice) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "stopMultiDisplay");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", "abilityCast");
        bundle.putInt("id", i);
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

    public int uibcCustomEvent(int i, String str) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "uibcCustomEvent");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", "abilityCast");
        bundle.putInt("id", i);
        bundle.putString("message", str);
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

    public int uibcKeyEvent(int i, String str, int i2, int i3) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "uibcKeyEvent");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", "abilityCast");
        bundle.putInt("id", i);
        bundle.putString("tag", str);
        bundle.putInt(WebJs.ACTION, i2);
        bundle.putInt("keycode", i3);
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

    public int uibcTouchEvent(int i, String str, int i2, int i3, MotionEvent motionEvent) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "uibcTouchEvent");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", "abilityCast");
        bundle.putInt("id", i);
        bundle.putString("tag", str);
        bundle.putInt(MonthView.VIEW_PARAMS_WIDTH, i2);
        bundle.putInt("high", i3);
        bundle.putParcelable("event", motionEvent);
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

    public int unregisterDisplayListener(int i, String str, IDisplayListener iDisplayListener) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "unregisterDisplayListener");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", "abilityCast");
        bundle.putInt("id", i);
        bundle.putString(ConstantKt.FACTOR_PARAMS_PACKAGE_NAME, str);
        if (iDisplayListener != null) {
            bundle.putBinder(ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, new IDisplayListenerAdapter(iDisplayListener));
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

    public int unregisterSinkListener(int i) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "unregisterSinkListener");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", "abilityCast");
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
}
