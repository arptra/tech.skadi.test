package com.here.services.test.fingerprint;

import com.here.services.HereLocationApiClient;
import org.json.JSONObject;

public interface HdWifiCollectionTestApi {

    public interface StateListener {
        void onHdWifiStateUpdate(JSONObject jSONObject);
    }

    void overrideConfiguration(HereLocationApiClient hereLocationApiClient, String str);

    boolean registerStateListener(HereLocationApiClient hereLocationApiClient, StateListener stateListener);

    void setUsername(HereLocationApiClient hereLocationApiClient, String str);

    void unregisterStateListener(HereLocationApiClient hereLocationApiClient, StateListener stateListener);
}
