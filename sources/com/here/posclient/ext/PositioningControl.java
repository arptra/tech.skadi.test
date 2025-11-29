package com.here.posclient.ext;

public class PositioningControl {
    private PositioningControl() {
    }

    public static native long availableFeatures();

    public static native void dumpCachedData();

    public static native long enabledFeatures();

    public static native int handleGlobalLocationSettingChanged(boolean z);

    public static native boolean isNetworkingEnabled();

    public static native boolean isWifiThrottleEnabled();

    public static native int setNetworkingEnabled(boolean z);

    public static native void setSubprocessorEndpointEnabled(boolean z);

    public static native void setWifiThrottleEnabled(boolean z);

    public static native void setWorkingRadioMapPath(String str);

    public static native int toggleFeature(long j, boolean z);
}
