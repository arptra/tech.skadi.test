package com.sina.weibo.sdk;

import com.sina.weibo.sdk.auth.AccessTokenHelper;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;

public final class q extends j<Void, Void, String> {
    public s<String> e;
    public Throwable f;
    public String g;
    public Oauth2AccessToken h;

    public q(String str, Oauth2AccessToken oauth2AccessToken, AccessTokenHelper.a aVar) {
        this.g = str;
        this.h = oauth2AccessToken;
        this.e = aVar;
    }
}
