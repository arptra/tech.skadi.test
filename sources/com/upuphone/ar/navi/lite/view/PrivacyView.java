package com.upuphone.ar.navi.lite.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.upuphone.ar.navi.lite.R;
import com.upuphone.ar.navi.lite.util.CSharedPreferences;

public class PrivacyView extends LinearLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public Context f5841a;
    public WebView b;
    public LinearLayout c;
    public OnPrivacySelectedListener d;

    public final class CWebViewClient extends WebViewClient {
        public CWebViewClient() {
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            if (str.contains("file:///android_asset/privacy_compliance.html")) {
                PrivacyView.this.c.setVisibility(0);
            } else {
                PrivacyView.this.c.setVisibility(8);
            }
        }
    }

    public interface OnPrivacySelectedListener {
        void a();

        void b();
    }

    public PrivacyView(Context context) {
        super(context);
        this.f5841a = context;
        d(context);
        f();
    }

    public boolean b() {
        return this.b.canGoBack();
    }

    public void c() {
        this.b.goBack();
    }

    public final void d(Context context) {
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.privacy_compliance_layout, this);
        this.b = (WebView) findViewById(R.id.webview);
        this.c = (LinearLayout) findViewById(R.id.privacy_btn_layout);
        ((Button) findViewById(R.id.disagree_privacy)).setOnClickListener(this);
        ((Button) findViewById(R.id.agree_privacy)).setOnClickListener(this);
    }

    public void e() {
        this.b.removeAllViews();
    }

    public final void f() {
        WebSettings settings = this.b.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setMixedContentMode(0);
        settings.setCacheMode(-1);
        settings.setCacheMode(1);
        settings.setDomStorageEnabled(true);
        settings.setAllowFileAccess(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        this.b.setWebChromeClient(new WebChromeClient());
        this.b.setWebViewClient(new CWebViewClient());
        this.b.loadUrl("file:///android_asset/privacy_compliance.html");
    }

    public void onClick(View view) {
        if (view.getId() == R.id.disagree_privacy) {
            CSharedPreferences.p(this.f5841a, "show_privacy_compliance", false);
            OnPrivacySelectedListener onPrivacySelectedListener = this.d;
            if (onPrivacySelectedListener != null) {
                onPrivacySelectedListener.b();
            }
        } else if (view.getId() == R.id.agree_privacy) {
            CSharedPreferences.p(this.f5841a, "show_privacy_compliance", true);
            OnPrivacySelectedListener onPrivacySelectedListener2 = this.d;
            if (onPrivacySelectedListener2 != null) {
                onPrivacySelectedListener2.a();
            }
        }
    }

    public void setOnPrivacySelectedListener(OnPrivacySelectedListener onPrivacySelectedListener) {
        this.d = onPrivacySelectedListener;
    }

    public PrivacyView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5841a = context;
        d(context);
        f();
    }
}
