package com.here.odnp.posclient.auth;

import com.here.odnp.posclient.ICloseableSession;
import com.here.posclient.Status;
import com.here.posclient.auth.AuthData;
import com.here.posclient.auth.AuthListener;

public interface IAuthSession extends ICloseableSession {
    Status setAuthData(AuthData authData);

    Status subscribe(AuthListener authListener);

    Status unsubscribe();
}
