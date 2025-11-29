package com.here.odnp.posclient.hd;

import com.here.odnp.posclient.ICloseableSession;
import com.here.posclient.crowdsource.hd.ControlEvent;
import com.here.posclient.crowdsource.hd.IActivityEventDispatcher;

public interface IHdCrowdsourceSession extends ICloseableSession {
    boolean sendEvent(ControlEvent controlEvent);

    boolean setWifiIntervals(int i, int i2);

    boolean startActivityEventListening(IActivityEventDispatcher iActivityEventDispatcher);

    void stopActivityEventListening(IActivityEventDispatcher iActivityEventDispatcher);
}
