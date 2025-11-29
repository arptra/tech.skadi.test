package com.here.posclient.auth;

import android.os.Bundle;
import com.here.odnp.util.Log;

public class AuthUtils {
    private static final String KEY_AUTH_DATA_ACCESS_KEY_ID = "auth.data.access.key.id";
    private static final String KEY_AUTH_DATA_ACCESS_KEY_SECRET = "auth.data.access.key.secret";
    private static final String KEY_AUTH_DATA_EXPIRY_TIME = "auth.data.expiry.time";
    private static final String KEY_AUTH_DATA_TOKEN = "auth.data.token";
    private static final String TAG = "AuthUtils";

    public static AuthData authDataFromBundle(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        AuthData authData = (!bundle.containsKey(KEY_AUTH_DATA_TOKEN) || !bundle.containsKey(KEY_AUTH_DATA_EXPIRY_TIME)) ? (!bundle.containsKey(KEY_AUTH_DATA_ACCESS_KEY_ID) || !bundle.containsKey(KEY_AUTH_DATA_ACCESS_KEY_SECRET)) ? new AuthData() : new AuthData(bundle.getString(KEY_AUTH_DATA_ACCESS_KEY_ID), bundle.getString(KEY_AUTH_DATA_ACCESS_KEY_SECRET)) : new AuthData(bundle.getString(KEY_AUTH_DATA_TOKEN), bundle.getLong(KEY_AUTH_DATA_EXPIRY_TIME));
        String str = TAG;
        Log.v(str, "authDataFromBundle: auth data:" + authData.toString(), new Object[0]);
        return authData;
    }

    public static void authDataToBundle(Bundle bundle, AuthData authData) {
        if (authData != null) {
            String str = TAG;
            Log.v(str, "authDataToBundle: auth data:" + authData.toString(), new Object[0]);
            String str2 = authData.accessToken;
            if (str2 != null) {
                bundle.putString(KEY_AUTH_DATA_TOKEN, str2);
                bundle.putLong(KEY_AUTH_DATA_EXPIRY_TIME, authData.expiryTime);
            }
            String str3 = authData.accessKeyId;
            if (str3 != null && authData.accessKeySecret != null) {
                bundle.putString(KEY_AUTH_DATA_ACCESS_KEY_ID, str3);
                bundle.putString(KEY_AUTH_DATA_ACCESS_KEY_SECRET, authData.accessKeySecret);
            }
        }
    }
}
