package com.sina.weibo.sdk.auth;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.sina.weibo.sdk.g;
import com.sina.weibo.sdk.k;
import com.sina.weibo.sdk.q;
import com.sina.weibo.sdk.s;
import java.util.concurrent.ThreadPoolExecutor;

public class AccessTokenHelper {
    private static final String PREFERENCES_NAME = "com_weibo_sdk_android";

    public class a implements s<String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f9969a;

        public a(Context context) {
            this.f9969a = context;
        }
    }

    public static void clearAccessToken(Context context) {
        if (context != null) {
            SharedPreferences.Editor edit = context.getSharedPreferences(PREFERENCES_NAME, 0).edit();
            edit.clear();
            edit.apply();
        }
    }

    public static Oauth2AccessToken readAccessToken(Context context) {
        if (context == null) {
            return null;
        }
        Oauth2AccessToken oauth2AccessToken = new Oauth2AccessToken();
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFERENCES_NAME, 0);
        oauth2AccessToken.setUid(sharedPreferences.getString(Oauth2AccessToken.KEY_UID, ""));
        oauth2AccessToken.setScreenName(sharedPreferences.getString(Oauth2AccessToken.KEY_SCREEN_NAME, ""));
        oauth2AccessToken.setAccessToken(sharedPreferences.getString("access_token", ""));
        oauth2AccessToken.setRefreshToken(sharedPreferences.getString(Oauth2AccessToken.KEY_REFRESH_TOKEN, ""));
        oauth2AccessToken.setExpiresTime(sharedPreferences.getLong(Oauth2AccessToken.KEY_EXPIRES_IN, 0));
        return oauth2AccessToken;
    }

    public static void refreshAccessToken(Context context, String str) {
        Oauth2AccessToken readAccessToken = readAccessToken(context);
        if (readAccessToken != null) {
            q qVar = new q(str, readAccessToken, new a(context));
            ThreadPoolExecutor threadPoolExecutor = g.a.f9980a.f9979a.f9976a;
            if (qVar.f9984a != 1) {
                int a2 = k.a(qVar.f9984a);
                if (a2 == 1) {
                    throw new IllegalStateException("Cannot execute task: the task is already running.");
                } else if (a2 == 2) {
                    throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
                }
            }
            qVar.f9984a = 2;
            qVar.b.getClass();
            qVar.b.getClass();
            threadPoolExecutor.execute(qVar.c);
        }
    }

    public static void writeAccessToken(Context context, Oauth2AccessToken oauth2AccessToken) {
        if (context != null && oauth2AccessToken != null && !TextUtils.isEmpty(oauth2AccessToken.getAccessToken())) {
            SharedPreferences.Editor edit = context.getSharedPreferences(PREFERENCES_NAME, 0).edit();
            edit.putString(Oauth2AccessToken.KEY_UID, oauth2AccessToken.getUid());
            edit.putString(Oauth2AccessToken.KEY_SCREEN_NAME, oauth2AccessToken.getScreenName());
            edit.putString("access_token", oauth2AccessToken.getAccessToken());
            edit.putString(Oauth2AccessToken.KEY_REFRESH_TOKEN, oauth2AccessToken.getRefreshToken());
            edit.putLong(Oauth2AccessToken.KEY_EXPIRES_IN, oauth2AccessToken.getExpiresTime());
            edit.apply();
        }
    }
}
