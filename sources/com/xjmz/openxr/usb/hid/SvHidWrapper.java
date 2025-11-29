package com.xjmz.openxr.usb.hid;

import android.util.Log;
import androidx.annotation.Keep;
import com.meizu.common.widget.MzContactsContract;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@Keep
class SvHidWrapper {
    private static final boolean DEBUG = Log.isLoggable(TAG, 3);
    private static final String TAG = "SvHidWrapper";
    private final Queue<IEventCallback> mEventCallbacks = new ConcurrentLinkedQueue();

    static {
        System.loadLibrary("sv_hid_wrapper");
    }

    public SvHidWrapper() {
        init();
    }

    public native void init();

    public void notifyChannelConnectionStatusChanged(int i) {
        for (IEventCallback next : this.mEventCallbacks) {
            if (next != null) {
                next.onHidChannelConnectionStatusChanged(i);
            }
        }
    }

    public void on7911StatusChanged(int i, int i2, int i3) {
        for (IEventCallback next : this.mEventCallbacks) {
            if (next != null) {
                next.on7911StatusChanged(i, i2, i3);
            }
        }
    }

    public void onBrightnessChanged(int i) {
        for (IEventCallback next : this.mEventCallbacks) {
            if (next != null) {
                next.onBrightnessChanged(i);
            }
        }
    }

    public void onHidExit() {
        for (IEventCallback next : this.mEventCallbacks) {
            if (next != null) {
                next.a();
            }
        }
    }

    public void onKeyEvent(int i, int i2) {
        for (IEventCallback next : this.mEventCallbacks) {
            if (next != null) {
                next.onKeyEvent(i, i2);
            }
        }
    }

    public void onLog(String str) {
        Log.d(TAG, "[Glasses] log:" + str);
        for (IEventCallback next : this.mEventCallbacks) {
            if (next != null) {
                next.onLog(str);
            }
        }
    }

    public void onUpgradeProgressChanged(int i, int i2, int i3, int i4) {
        if (DEBUG) {
            Log.d(TAG, "onUpgradeProgressChanged:" + i + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA + i2 + ", type" + i3 + ", state:" + i4 + " -- " + this.mEventCallbacks.size());
        }
        for (IEventCallback next : this.mEventCallbacks) {
            if (next != null) {
                next.onUpgradeProgressChanged(i, i2, i3, i4);
            }
        }
    }

    public void onWearingStatusChanged(boolean z) {
        for (IEventCallback next : this.mEventCallbacks) {
            if (next != null) {
                next.onWearingStatusChanged(z);
            }
        }
    }

    public void registerEventCallback(IEventCallback iEventCallback) {
        this.mEventCallbacks.add(iEventCallback);
    }

    public native int svHidDestroy(int i);

    public native int svHidEraseData();

    public native int svHidGet2D3DState();

    public native int svHidGet7911CurrentResolution();

    public native int svHidGet7911Status(int[] iArr);

    public native String svHidGetAIDspVersion();

    public native int svHidGetActivateState();

    public native int svHidGetBrightnessLevel();

    public native String svHidGetCalibrationData();

    public native String svHidGetDeviceName();

    public native String svHidGetDisplayChipVersion();

    public native int svHidGetDisplayStyleMode();

    public native int svHidGetDuty();

    public native int svHidGetImuFrequency();

    public native String svHidGetMCUAPPVersion();

    public native String svHidGetMCUBootVersion();

    public native String svHidGetModel();

    public native int svHidGetShallowSleepTime();

    public native int svHidGetSleepTime();

    public native int svHidGetSleepType();

    public native String svHidGetSn();

    public native int svHidGetWearGlassesInfo();

    public native int svHidInit(int i);

    public native int svHidInit(int i, boolean z);

    public native int svHidLongPressReact(int i);

    public native int svHidLongPressWakeUpVoiceAssistant(int i);

    public native int svHidOpenHidData(int i);

    public native int svHidRestartUpgrade();

    public native int svHidSendCalibrationDataToImu(String str);

    public native int svHidSet2D3DState(int i);

    public native int svHidSetBrightness(int i);

    public native int svHidSetDeviceName(String str);

    public native int svHidSetDuty(int i);

    public native int svHidSetFirmwareFilepath(String str, int i);

    public native int svHidSetImu(int i);

    public native int svHidSetImuConfig(int i);

    public native int svHidSetImuFrequency(int i);

    public native int svHidSetLogTrigger(int i);

    public native int svHidSetMagSensor(int i);

    public native int svHidSetShallowSleepTime(int i);

    public native int svHidSetSleepTime(int i);

    public native int svHidSetSleepType(int i);

    public native int svHidStart();

    public native int svHidSwitchDisplayStyleMode(int i);

    public void unregisterEventCallback(IEventCallback iEventCallback) {
        this.mEventCallbacks.remove(iEventCallback);
    }
}
