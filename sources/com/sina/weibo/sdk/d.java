package com.sina.weibo.sdk;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.sina.weibo.sdk.auth.WbAuthListener;
import com.sina.weibo.sdk.share.ShareTransActivity;
import com.sina.weibo.sdk.web.WebActivity;

public abstract class d extends WebViewClient {

    /* renamed from: a  reason: collision with root package name */
    public f0 f9972a = f0.a();
    public Activity b;
    public l0 c;
    public e d;
    public WbAuthListener e;

    public d(Activity activity, l0 l0Var, e eVar) {
        this.b = activity;
        this.c = l0Var;
        this.d = eVar;
    }

    public boolean a() {
        return false;
    }

    public void b() {
    }

    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
    }

    @TargetApi(23)
    public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        l0 l0Var = this.c;
        if (l0Var != null) {
            webResourceError.getErrorCode();
            webResourceError.getDescription().toString();
            webResourceRequest.getUrl().toString();
            WebActivity webActivity = (WebActivity) l0Var;
            webActivity.f9998a.setVisibility(0);
            webActivity.d.setVisibility(8);
        }
    }

    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        return super.shouldOverrideUrlLoading(webView, webResourceRequest);
    }

    public final void a(int i, String str) {
        Bundle extras = this.b.getIntent().getExtras();
        if (extras != null) {
            Intent intent = new Intent(this.b, ShareTransActivity.class);
            intent.setAction("com.sina.weibo.sdk.action.ACTION_SDK_REQ_ACTIVITY");
            intent.putExtras(extras);
            intent.putExtra("_weibo_resp_errcode", i);
            intent.putExtra("_weibo_resp_errstr", str);
            this.b.setResult(-1, intent);
        }
    }
}
