package com.here.services.crowdsource.hd;

import com.here.posclient.crowdsource.hd.ControlEvent;
import com.here.posclient.crowdsource.hd.IActivityEventDispatcher;
import com.here.services.HereLocationApiClient;
import com.here.services.common.UnsupportedMethodException;

public interface HdWifiCollectionApi {
    boolean sendEvent(HereLocationApiClient hereLocationApiClient, ControlEvent controlEvent) throws UnsupportedMethodException;

    boolean setWifiIntervals(HereLocationApiClient hereLocationApiClient, int i, int i2) throws UnsupportedMethodException;

    boolean startActivityEventListenening(HereLocationApiClient hereLocationApiClient, IActivityEventDispatcher iActivityEventDispatcher) throws UnsupportedMethodException;

    void stopActivityEventListenening(HereLocationApiClient hereLocationApiClient, IActivityEventDispatcher iActivityEventDispatcher) throws UnsupportedMethodException;
}
