package com.here.posclient.ext;

import com.here.posclient.auth.AuthData;
import com.here.posclient.auth.AuthListener;

public class Auth {
    private Auth() {
    }

    public static native int setAuthData(AuthData authData);

    public static native int subscribe(AuthListener authListener);

    public static native int unsubscribe();
}
