package com.here.posclient.ext;

import com.here.posclient.crowdsource.hd.IActivityEventDispatcher;

public class HdWifiControl {
    private HdWifiControl() {
    }

    public static native int sendEvent(int i);

    public static native int setWifiIntervals(int i, int i2);

    public static native int startActivityEventListening(IActivityEventDispatcher iActivityEventDispatcher);

    public static native void stopActivityEventListening(IActivityEventDispatcher iActivityEventDispatcher);
}
