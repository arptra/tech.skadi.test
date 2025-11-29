package com.upuphone.runasone.uupcast.api;

import android.view.MotionEvent;
import android.view.Surface;
import com.upuphone.hub.annotation.Callback;
import com.upuphone.hub.annotation.Hub;
import com.upuphone.hub.annotation.Parcelable;
import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.runasone.uupcast.SinkDisplayConfig;
import com.upuphone.runasone.uupcast.SourceDisplayConfig;

@Hub
public interface IUupCast {
    int createCastSession(String str, String str2, int i, String str3);

    int displaySinkAddVirtualDisplay(int i, @Parcelable Surface surface, SinkDisplayConfig sinkDisplayConfig);

    int displaySinkPause(int i, String str, boolean z);

    int displaySinkReclaimAudioFocus(int i, int i2);

    int displaySinkRemoveVirtualDisplay(int i, String str);

    int displaySinkRemoveVirtualDisplayEx(int i, String str, byte[] bArr);

    int displaySinkResume(int i, String str);

    int displaySinkSetAudioListener(int i, @Callback ISinkAudioListener iSinkAudioListener);

    int displaySinkSetOutputSurface(int i, @Parcelable Surface surface, String str);

    int displaySinkStart(int i);

    int displaySinkStop(int i);

    int enableAudioPolicy(int i, int i2);

    int enableRecordPhoneCallRing(int i, boolean z);

    int getDisplayID(int i);

    int getDisplayState(int i);

    SinkDisplayConfig getSinkDisplayConfig(int i);

    int pauseSource(int i, String str, boolean z);

    int registerDisplayListener(int i, String str, @Callback IDisplayListener iDisplayListener);

    int registerSinkListener(int i, @Callback ISinkListener iSinkListener);

    int registerSyncCallbackCode(int i, int i2, int i3);

    int resumeSource(int i, String str);

    int setDisplaySinkConfig(int i, SinkDisplayConfig sinkDisplayConfig);

    int setDisplaySinkSurface(int i, @Parcelable Surface surface);

    int setUIBCChannel(int i, String str, int i2);

    int sinkCheckFeatureSupported(int i, String str);

    int sourceCheckFeatureSupported(StarryDevice starryDevice, String str);

    int startDisplay(int i, String str, StarryDevice starryDevice, SourceDisplayConfig sourceDisplayConfig);

    int stopDisplay(int i);

    int stopMultiDisplay(int i, StarryDevice starryDevice);

    int uibcCustomEvent(int i, String str);

    int uibcKeyEvent(int i, String str, int i2, int i3);

    int uibcTouchEvent(int i, String str, int i2, int i3, @Parcelable MotionEvent motionEvent);

    int unregisterDisplayListener(int i, String str, @Callback IDisplayListener iDisplayListener);

    int unregisterSinkListener(int i);
}
