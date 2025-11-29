package com.here.services.crowdsource.hd.internal;

import com.here.posclient.crowdsource.hd.ControlEvent;
import com.here.posclient.crowdsource.hd.IActivityEventDispatcher;
import com.here.services.internal.Manager;

public interface IHdWifiCollection extends Manager {
    boolean sendEvent(ControlEvent controlEvent);

    boolean setWifiIntervals(int i, int i2);

    boolean startActivityEventListening(IActivityEventDispatcher iActivityEventDispatcher);

    void stopActivityEventListening(IActivityEventDispatcher iActivityEventDispatcher);
}
