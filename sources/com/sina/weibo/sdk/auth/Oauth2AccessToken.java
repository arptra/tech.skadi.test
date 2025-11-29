package com.sina.weibo.sdk.auth;

import android.os.Bundle;
import android.text.TextUtils;
import com.sina.weibo.sdk.n;
import org.json.JSONObject;

public class Oauth2AccessToken {
    public static final String KEY_ACCESS_TOKEN = "access_token";
    public static final String KEY_EXPIRES_IN = "expires_in";
    public static final String KEY_REFRESH_TOKEN = "refresh_token";
    public static final String KEY_SCREEN_NAME = "userName";
    public static final String KEY_UID = "uid";
    private String mAccessToken;
    private long mExpiresTime;
    private String mRefreshToken;
    private String mScreenName;
    private String mUid;

    public static Oauth2AccessToken parseAccessToken(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        try {
            Oauth2AccessToken oauth2AccessToken = new Oauth2AccessToken();
            oauth2AccessToken.setUid(bundle.getString(KEY_UID));
            oauth2AccessToken.setScreenName(bundle.getString(KEY_SCREEN_NAME));
            oauth2AccessToken.setAccessToken(bundle.getString("access_token"));
            oauth2AccessToken.setRefreshToken(bundle.getString(KEY_REFRESH_TOKEN));
            try {
                oauth2AccessToken.setExpiresTime(Long.parseLong(bundle.getString(KEY_EXPIRES_IN)) * 1000);
            } catch (Exception e) {
                n.a(n.c, "Oauth2AccessToken expires parse error3: ", e);
            }
            return oauth2AccessToken;
        } catch (Exception e2) {
            n.a(n.c, "Oauth2AccessToken expires parse error4: ", e2);
            return null;
        }
    }

    public String getAccessToken() {
        return this.mAccessToken;
    }

    public long getExpiresTime() {
        return this.mExpiresTime;
    }

    public String getRefreshToken() {
        return this.mRefreshToken;
    }

    public String getScreenName() {
        return this.mScreenName;
    }

    public String getUid() {
        return this.mUid;
    }

    public boolean isSessionValid() {
        return !TextUtils.isEmpty(this.mAccessToken) && this.mExpiresTime > 0;
    }

    public void setAccessToken(String str) {
        this.mAccessToken = str;
    }

    public void setExpiresTime(long j) {
        this.mExpiresTime = j;
    }

    public void setRefreshToken(String str) {
        this.mRefreshToken = str;
    }

    public void setScreenName(String str) {
        this.mScreenName = str;
    }

    public void setUid(String str) {
        this.mUid = str;
    }

    public static Oauth2AccessToken parseAccessToken(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            Oauth2AccessToken oauth2AccessToken = new Oauth2AccessToken();
            oauth2AccessToken.setUid(jSONObject.optString(KEY_UID));
            oauth2AccessToken.setScreenName(jSONObject.optString(KEY_SCREEN_NAME));
            oauth2AccessToken.setAccessToken(jSONObject.optString("access_token"));
            try {
                oauth2AccessToken.setExpiresTime(Long.parseLong(jSONObject.getString(KEY_EXPIRES_IN)) * 1000);
            } catch (Exception e) {
                n.a(n.c, "Oauth2AccessToken expires parse error1: ", e);
            }
            oauth2AccessToken.setRefreshToken(jSONObject.optString(KEY_REFRESH_TOKEN));
            return oauth2AccessToken;
        } catch (Exception e2) {
            n.a(n.c, "Oauth2AccessToken expires parse error2: ", e2);
            return null;
        }
    }
}
