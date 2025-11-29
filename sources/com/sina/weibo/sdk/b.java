package com.sina.weibo.sdk;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import com.meizu.common.widget.MzContactsContract;
import com.sina.weibo.sdk.auth.AccessTokenHelper;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WbAuthListener;
import com.sina.weibo.sdk.common.UiError;
import com.sina.weibo.sdk.web.WebActivity;
import java.net.MalformedURLException;
import java.net.URL;

public final class b extends d {
    public b(Activity activity, l0 l0Var, e eVar) {
        super(activity, l0Var, eVar);
    }

    public final boolean a() {
        b();
        return true;
    }

    public final void b() {
        WbAuthListener wbAuthListener;
        String str = this.d.f9974a.d;
        if (!TextUtils.isEmpty(str)) {
            f0 f0Var = this.f9972a;
            synchronized (f0Var) {
                if (TextUtils.isEmpty(str)) {
                    wbAuthListener = null;
                } else {
                    WbAuthListener wbAuthListener2 = (WbAuthListener) f0Var.f9977a.get(str);
                    wbAuthListener = wbAuthListener2;
                }
            }
            this.e = wbAuthListener;
            if (wbAuthListener != null) {
                wbAuthListener.onCancel();
            }
            f0 f0Var2 = this.f9972a;
            synchronized (f0Var2) {
                if (!TextUtils.isEmpty(str)) {
                    f0Var2.f9977a.remove(str);
                }
            }
        }
        l0 l0Var = this.c;
        if (l0Var != null) {
            ((WebActivity) l0Var).finish();
        }
    }

    public final void onPageFinished(WebView webView, String str) {
        Bundle bundle;
        WbAuthListener wbAuthListener;
        super.onPageFinished(webView, str);
        AuthInfo authInfo = this.d.f9974a.f9999a;
        if (authInfo != null && str.startsWith(authInfo.getRedirectUrl())) {
            String str2 = this.d.f9974a.d;
            if (!TextUtils.isEmpty(str2)) {
                f0 f0Var = this.f9972a;
                synchronized (f0Var) {
                    bundle = null;
                    wbAuthListener = TextUtils.isEmpty(str2) ? null : (WbAuthListener) f0Var.f9977a.get(str2);
                }
                this.e = wbAuthListener;
                if (wbAuthListener != null) {
                    char[] cArr = d0.f9973a;
                    try {
                        bundle = d0.a(new URL(str).getQuery());
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    if (bundle != null) {
                        String string = bundle.getString("error");
                        String string2 = bundle.getString(MzContactsContract.MzNetContacts.ERROR_CODE_KEY);
                        String string3 = bundle.getString("error_description");
                        if (!TextUtils.isEmpty(string) || !TextUtils.isEmpty(string2)) {
                            this.e.onError(new UiError(-1, string2, string3));
                        } else {
                            Oauth2AccessToken parseAccessToken = Oauth2AccessToken.parseAccessToken(bundle);
                            AccessTokenHelper.writeAccessToken(this.b, parseAccessToken);
                            this.e.onComplete(parseAccessToken);
                        }
                    } else {
                        this.e.onError(new UiError(-1, "bundle is null", "parse url error"));
                    }
                    f0 f0Var2 = this.f9972a;
                    synchronized (f0Var2) {
                        if (!TextUtils.isEmpty(str2)) {
                            f0Var2.f9977a.remove(str2);
                        }
                    }
                }
            }
            l0 l0Var = this.c;
            if (l0Var != null) {
                ((WebActivity) l0Var).finish();
            }
        }
    }

    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        Bundle bundle;
        String uri = webResourceRequest.getUrl().toString();
        AuthInfo authInfo = this.d.f9974a.f9999a;
        if (authInfo != null && uri.startsWith(authInfo.getRedirectUrl())) {
            char[] cArr = d0.f9973a;
            try {
                bundle = d0.a(new URL(uri).getQuery());
            } catch (MalformedURLException e) {
                e.printStackTrace();
                bundle = null;
            }
            if (bundle != null) {
                return !TextUtils.isEmpty(bundle.getString("access_token"));
            }
        }
        return false;
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        Bundle bundle;
        AuthInfo authInfo = this.d.f9974a.f9999a;
        if (authInfo != null && str.startsWith(authInfo.getRedirectUrl())) {
            char[] cArr = d0.f9973a;
            try {
                bundle = d0.a(new URL(str).getQuery());
            } catch (MalformedURLException e) {
                e.printStackTrace();
                bundle = null;
            }
            if (bundle != null) {
                return !TextUtils.isEmpty(bundle.getString("access_token"));
            }
        }
        return false;
    }
}
