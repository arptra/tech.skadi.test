package com.upuphone.starrynet.strategy.discovery.fastpair.localfastpair;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;
import com.upuphone.runasone.uupcast.CaptureType;
import com.upuphone.starrynet.R;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.strategy.discovery.fastpair.localfastpair.event.FastPairEventBus;
import com.upuphone.starrynet.strategy.discovery.fastpair.localfastpair.event.FastPairPolicyEvent;

public class FastPairPolicyActivity extends Activity {
    public static final String INTENT_KEY_TITLE = "title";
    public static final String INTENT_KEY_URL = "url";
    private static final String TAG = "FastPairPolicyActivity";
    private String mTitle;
    private String mUrl;
    /* access modifiers changed from: private */
    public WebView mWvPrivacy;

    private void exit() {
        setFastPairStartPageVisible(false);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            public void run() {
                FastPairPolicyActivity.this.finishAndRemoveTask();
            }
        }, 100);
    }

    private void init() {
        StLog.d(TAG, "init");
        this.mWvPrivacy = (WebView) findViewById(R.id.layout_web_view);
        ((TextView) findViewById(R.id.tv_title)).setText(this.mTitle);
        ((ImageView) findViewById(R.id.tv_back)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FastPairPolicyActivity.this.setFastPairStartPageVisible(true);
                FastPairPolicyActivity.this.finish();
            }
        });
        this.mWvPrivacy.setBackgroundColor(0);
        WebSettings settings = this.mWvPrivacy.getSettings();
        settings.setSupportZoom(false);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setJavaScriptEnabled(true);
        this.mWvPrivacy.setWebViewClient(new WebViewClient() {
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                FastPairPolicyActivity fastPairPolicyActivity = FastPairPolicyActivity.this;
                fastPairPolicyActivity.injectCSS(fastPairPolicyActivity.mWvPrivacy);
            }

            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
                FastPairPolicyActivity fastPairPolicyActivity = FastPairPolicyActivity.this;
                fastPairPolicyActivity.injectCSS(fastPairPolicyActivity.mWvPrivacy);
            }

            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                StLog.v(FastPairPolicyActivity.TAG, "onReceivedError, " + webResourceRequest.getUrl() + " code = " + webResourceError.getErrorCode());
            }

            public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
                StLog.v(FastPairPolicyActivity.TAG, "onReceivedHttpError " + webResourceRequest.getUrl() + " code = " + webResourceResponse.getStatusCode());
            }

            public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                super.onReceivedSslError(webView, sslErrorHandler, sslError);
                String url = sslError.getUrl();
                int primaryError = sslError.getPrimaryError();
                StLog.v(FastPairPolicyActivity.TAG, "onReceivedError, " + url + " code = " + primaryError);
                if (primaryError == 3) {
                    FastPairPolicyActivity.this.startWeb(url);
                }
            }
        });
        this.mWvPrivacy.loadUrl(this.mUrl);
    }

    /* access modifiers changed from: private */
    public void injectCSS(WebView webView) {
        if (isUiModeNight(getResources().getConfiguration())) {
            webView.evaluateJavascript("javascript: (function() {let node = document.getElementsByTagName('body')[0];node.style.background='#121212';node.style.webkitTextFillColor='#eeeeee';})();", (ValueCallback) null);
        }
    }

    private boolean isUiModeNight(Configuration configuration) {
        return (configuration.uiMode & 48) == 32;
    }

    /* access modifiers changed from: private */
    public void setFastPairStartPageVisible(boolean z) {
        FastPairPolicyEvent fastPairPolicyEvent = new FastPairPolicyEvent();
        fastPairPolicyEvent.setVisible(z);
        FastPairEventBus.get().post(fastPairPolicyEvent);
    }

    /* access modifiers changed from: private */
    public void startWeb(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(Uri.parse(str), "text/html");
        intent.addCategory("android.intent.category.BROWSABLE");
        intent.setFlags(CaptureType.CAPTURE_VIRTUAL_DISPLAY_WHEN_SCREEN_LOCKED);
        startActivity(intent);
        super.finish();
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        StLog.i(TAG, "dispatchKeyEvent = " + keyEvent);
        int keyCode = keyEvent.getKeyCode();
        if (keyCode != 3 && keyCode != 82) {
            return super.dispatchKeyEvent(keyEvent);
        }
        exit();
        return true;
    }

    public void finish() {
        WebView webView = this.mWvPrivacy;
        if (webView == null || !webView.canGoBack()) {
            super.finish();
        } else {
            this.mWvPrivacy.goBack();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setDefaultDisplay();
        getWindow().addFlags(Integer.MIN_VALUE);
        getWindow().setStatusBarColor(getApplicationContext().getColor(R.color.white));
        getWindow().setNavigationBarColor(getApplicationContext().getColor(R.color.white));
        setContentView(R.layout.activity_fast_pair_policy);
        Intent intent = getIntent();
        this.mUrl = intent.getStringExtra("url");
        this.mTitle = intent.getStringExtra("title");
        StLog.d(TAG, "title = " + this.mTitle + ", url = " + this.mUrl);
        init();
    }

    public void onDestroy() {
        super.onDestroy();
        WebView webView = this.mWvPrivacy;
        if (webView != null) {
            webView.destroy();
            this.mWvPrivacy = null;
        }
    }

    public void setDefaultDisplay() {
        Resources resources = getResources();
        Configuration configuration = resources.getConfiguration();
        int i = resources.getDisplayMetrics().densityDpi;
        int i2 = DisplayMetrics.DENSITY_DEVICE_STABLE;
        if (i != i2) {
            configuration.densityDpi = i2;
            resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        }
    }
}
