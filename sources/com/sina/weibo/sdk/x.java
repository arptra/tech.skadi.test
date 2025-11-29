package com.sina.weibo.sdk;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import com.sina.weibo.sdk.web.WebActivity;
import com.upuphone.starrynet.payload.PayloadConstant;
import java.net.URI;
import java.net.URISyntaxException;

public final class x extends d {
    public x(Activity activity, l0 l0Var, e eVar) {
        super(activity, l0Var, eVar);
    }

    public final boolean a() {
        b();
        return true;
    }

    public final void b() {
        a(1, "cancel share!!!");
        l0 l0Var = this.c;
        if (l0Var != null) {
            ((WebActivity) l0Var).finish();
        }
    }

    public final void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
    }

    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        Bundle bundle;
        if (TextUtils.isEmpty(str) || !str.startsWith("sinaweibo://browser/close")) {
            return false;
        }
        char[] cArr = d0.f9973a;
        try {
            bundle = d0.a(new URI(str).getQuery());
        } catch (URISyntaxException e) {
            e.printStackTrace();
            bundle = null;
        }
        if (bundle != null) {
            String string = bundle.getString("code");
            String string2 = bundle.getString(PayloadConstant.PARAMS_KEY_CALLBACK_MSG);
            if ("0".equals(string)) {
                a(0, string2);
            } else {
                a(2, string2);
            }
        } else {
            a(2, "bundle is null!!!");
        }
        l0 l0Var = this.c;
        if (l0Var == null) {
            return true;
        }
        ((WebActivity) l0Var).finish();
        return true;
    }

    @TargetApi(21)
    public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        Bundle bundle;
        String uri = webResourceRequest.getUrl().toString();
        if (TextUtils.isEmpty(uri) || !uri.startsWith("sinaweibo://browser/close")) {
            return false;
        }
        char[] cArr = d0.f9973a;
        try {
            bundle = d0.a(new URI(uri).getQuery());
        } catch (URISyntaxException e) {
            e.printStackTrace();
            bundle = null;
        }
        if (bundle != null) {
            String string = bundle.getString("code");
            String string2 = bundle.getString(PayloadConstant.PARAMS_KEY_CALLBACK_MSG);
            if (TextUtils.isEmpty(string)) {
                a(1, "code is null!!!");
            } else if ("0".equals(string)) {
                a(0, string2);
            } else {
                a(2, string2);
            }
        } else {
            a(2, "bundle is null!!!");
        }
        l0 l0Var = this.c;
        if (l0Var != null) {
            ((WebActivity) l0Var).finish();
        }
        return true;
    }
}
