package com.upuphone.ar.navi.lite;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.honey.account.d4.u0;
import com.honey.account.d4.v0;
import com.honey.account.d4.w0;
import com.upuphone.ar.navi.lite.util.CSharedPreferences;

public class NaviProtocoActivity extends BaseActivity {
    public ImageView h;
    public TextView i;
    public WebView j;
    public int k = 0;

    public final class CWebViewClient extends WebViewClient {
        public CWebViewClient() {
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
        }
    }

    public interface OnPrivacySelectedListener {
    }

    public void V0() {
        finish();
    }

    public void W0() {
        finish();
    }

    public void X0() {
        f1(true);
        finish();
    }

    public final void Y0() {
        Intent intent = getIntent();
        if (intent != null) {
            this.k = intent.getIntExtra("html_page_mode_key", this.k);
        }
    }

    public final String Z0() {
        int i2 = this.k;
        return i2 == 0 ? "file:///android_asset/protocol_drive.html" : i2 == 1 ? "file:///android_asset/protocol_ride.html" : "file:///android_asset/protocol_walk.html";
    }

    public final void a1() {
        ImageView imageView = (ImageView) findViewById(R.id.viewBack);
        this.h = imageView;
        imageView.setOnClickListener(new u0(this));
        this.i = (TextView) findViewById(R.id.viewTitle);
        WebView webView = (WebView) findViewById(R.id.webview);
        this.j = webView;
        webView.setBackgroundColor(0);
        ((Button) findViewById(R.id.cancel_btn)).setOnClickListener(new v0(this));
        ((Button) findViewById(R.id.agree_btn)).setOnClickListener(new w0(this));
    }

    public final /* synthetic */ void b1(View view) {
        V0();
    }

    public final /* synthetic */ void c1(View view) {
        W0();
    }

    public final /* synthetic */ void d1(View view) {
        X0();
    }

    public final void e1() {
        WebSettings settings = this.j.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setMixedContentMode(0);
        settings.setCacheMode(-1);
        settings.setCacheMode(1);
        settings.setDomStorageEnabled(true);
        settings.setAllowFileAccess(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        this.j.setWebChromeClient(new WebChromeClient());
        this.j.setWebViewClient(new CWebViewClient());
        this.j.loadUrl(Z0());
    }

    public final void f1(boolean z) {
        int i2 = this.k;
        if (i2 == 2) {
            CSharedPreferences.p(this, "navi_protocol_walk", z);
            setResult(1501);
        } else if (i2 == 1) {
            CSharedPreferences.p(this, "navi_protocol_ride", z);
            setResult(1502);
        } else if (i2 == 0) {
            CSharedPreferences.p(this, "navi_protocol_drive", z);
            setResult(1503);
        }
    }

    public final void g1() {
        int i2 = this.k;
        if (i2 == 2) {
            this.i.setText(R.string.walk_protoco_title);
        } else if (i2 == 1) {
            this.i.setText(R.string.ride_protoco_title);
        } else if (i2 == 0) {
            this.i.setText(R.string.drive_protoco_title);
        }
    }

    public void initViewModel() {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_navi_protocol);
        a1();
        Y0();
        g1();
        e1();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onPause() {
        super.onPause();
    }

    public void onResume() {
        super.onResume();
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }
}
