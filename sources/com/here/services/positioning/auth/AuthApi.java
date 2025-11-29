package com.here.services.positioning.auth;

import com.here.posclient.Status;
import com.here.posclient.auth.AuthData;
import com.here.services.HereLocationApiClient;

public interface AuthApi {

    public interface Listener {
        void onAuthDataRequested();
    }

    Status setAuthData(HereLocationApiClient hereLocationApiClient, AuthData authData);

    Status subscribe(HereLocationApiClient hereLocationApiClient, Listener listener);
}
