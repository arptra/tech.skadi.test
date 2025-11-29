package com.sina.weibo.sdk;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.android.dingtalk.openauth.web.AuthWebviewActivity;
import com.sina.weibo.sdk.a;
import com.sina.weibo.sdk.auth.AccessTokenHelper;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WbAuthListener;
import com.sina.weibo.sdk.common.UiError;
import com.sina.weibo.sdk.f0;
import com.sina.weibo.sdk.web.WebActivity;
import com.sina.weibo.sdk.web.WebData;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;

public final class z {

    /* renamed from: a  reason: collision with root package name */
    public WbAuthListener f10000a;

    public final void a(Activity activity) {
        String str = n.f9990a;
        n.a(str, "startClientAuth()");
        try {
            a.C0037a a2 = a.a(activity);
            Intent intent = new Intent();
            if (a2 == null) {
                intent.setClassName("com.sina.weibo", "com.sina.weibo.SSOActivity");
            } else {
                intent.setClassName(a2.f9968a, "com.sina.weibo.SSOActivity");
            }
            if (g0.f9981a) {
                AuthInfo authInfo = g0.b;
                intent.putExtra("appKey", authInfo.getAppKey());
                intent.putExtra("redirectUri", authInfo.getRedirectUrl());
                intent.putExtra("scope", authInfo.getScope());
                intent.putExtra("packagename", authInfo.getPackageName());
                intent.putExtra("key_hash", authInfo.getHash());
                intent.putExtra("_weibo_command_type", 3);
                intent.putExtra("_weibo_transaction", System.currentTimeMillis() + "");
                if (activity == null) {
                    this.f10000a.onError(new UiError(-1, "activity is null", ""));
                } else if (a.a(activity, intent)) {
                    activity.startActivityForResult(intent, 32973);
                    n.a(str, "start SsoActivity ");
                } else {
                    this.f10000a.onError(new UiError(-2, "your app is illegal", ""));
                }
            } else {
                throw new RuntimeException("please init sdk before use it. Wb.install()");
            }
        } catch (Exception e) {
            n.a(n.f9990a, "", e);
            this.f10000a.onError(new UiError(-3, "occur exception", e.getMessage()));
        }
    }

    public final void b(Activity activity) {
        f0 f0Var;
        HashMap hashMap = new HashMap();
        if (g0.f9981a) {
            AuthInfo authInfo = g0.b;
            if (authInfo != null) {
                hashMap.put("client_id", authInfo.getAppKey());
                hashMap.put(AuthWebviewActivity.f, authInfo.getRedirectUrl());
                hashMap.put("scope", authInfo.getScope());
                hashMap.put("packagename", authInfo.getPackageName());
                hashMap.put("key_hash", authInfo.getHash());
                hashMap.put(AuthWebviewActivity.g, "code");
                hashMap.put("version", "0041005000");
                hashMap.put("luicode", "10000360");
                hashMap.put("lfid", "OP_" + authInfo.getAppKey());
                Oauth2AccessToken readAccessToken = AccessTokenHelper.readAccessToken(activity);
                if (readAccessToken != null) {
                    String accessToken = readAccessToken.getAccessToken();
                    if (!TextUtils.isEmpty(readAccessToken.getAccessToken())) {
                        hashMap.put("trans_token", accessToken);
                        hashMap.put("trans_access_token", accessToken);
                    }
                }
                StringBuilder sb = new StringBuilder();
                sb.append("https://open.weibo.cn/oauth2/authorize?");
                StringBuilder sb2 = new StringBuilder();
                boolean z = true;
                for (String str : hashMap.keySet()) {
                    if (z) {
                        z = false;
                    } else {
                        sb2.append("&");
                    }
                    String str2 = (String) hashMap.get(str);
                    if (!TextUtils.isEmpty(str2)) {
                        try {
                            sb2.append(URLEncoder.encode(str, "UTF-8"));
                            sb2.append("=");
                            sb2.append(URLEncoder.encode(str2, "UTF-8"));
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }
                    }
                }
                sb.append(sb2.toString());
                String sb3 = sb.toString();
                if (this.f10000a != null) {
                    synchronized (f0.class) {
                        f0Var = f0.a.f9978a;
                    }
                    f0Var.getClass();
                    String str3 = System.currentTimeMillis() + "";
                    WbAuthListener wbAuthListener = this.f10000a;
                    synchronized (f0Var) {
                        if (!TextUtils.isEmpty(str3)) {
                            if (wbAuthListener != null) {
                                f0Var.f9977a.put(str3, wbAuthListener);
                            }
                        }
                    }
                    Intent intent = new Intent(activity, WebActivity.class);
                    WebData webData = new WebData(authInfo, 2, sb3, str3);
                    String str4 = System.currentTimeMillis() + "";
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("web_data", webData);
                    int i = webData.b;
                    if (i == 1) {
                        bundle.putInt("web_type", 1);
                    } else if (i == 2) {
                        bundle.putInt("web_type", 2);
                    } else if (i == 3) {
                        bundle.putInt("web_type", 3);
                    }
                    bundle.putString("_weibo_transaction", str4);
                    intent.putExtras(bundle);
                    activity.startActivity(intent);
                    return;
                }
                return;
            }
            return;
        }
        throw new RuntimeException("please init sdk before use it. Wb.install()");
    }
}
