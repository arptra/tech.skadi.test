package com.sina.weibo.sdk.web;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.honey.account.constant.AccountConstantKt;
import com.meizu.common.util.LunarCalendar;
import com.sina.weibo.sdk.b;
import com.sina.weibo.sdk.c;
import com.sina.weibo.sdk.d;
import com.sina.weibo.sdk.d0;
import com.sina.weibo.sdk.e;
import com.sina.weibo.sdk.h;
import com.sina.weibo.sdk.i;
import com.sina.weibo.sdk.i0;
import com.sina.weibo.sdk.j0;
import com.sina.weibo.sdk.k0;
import com.sina.weibo.sdk.l0;
import com.sina.weibo.sdk.x;
import com.sina.weibo.sdk.y;

public class WebActivity extends Activity implements l0 {

    /* renamed from: a  reason: collision with root package name */
    public LinearLayout f9998a;
    public TextView b;
    public TextView c;
    public WebView d;
    public ProgressBar e;
    public e f;
    public d g;
    public String h;

    public final void onCreate(Bundle bundle) {
        Class<String> cls = String.class;
        Class<WebView> cls2 = WebView.class;
        super.onCreate(bundle);
        getWindow().getDecorView().setSystemUiVisibility(8192);
        RelativeLayout relativeLayout = new RelativeLayout(this);
        relativeLayout.setBackgroundColor(-1);
        RelativeLayout relativeLayout2 = new RelativeLayout(this);
        TextView textView = new TextView(this);
        this.b = textView;
        textView.setText("关闭");
        this.b.setTextSize(17.0f);
        this.b.setTextColor(-32256);
        this.b.setOnClickListener(new i0(this));
        TextView textView2 = new TextView(this);
        this.c = textView2;
        textView2.setTextSize(18.0f);
        this.c.setTextColor(-11382190);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        this.b.setPadding(d0.a(10, (Context) this), 0, d0.a(10, (Context) this), 0);
        layoutParams2.addRule(13);
        relativeLayout2.addView(this.b, layoutParams);
        relativeLayout2.addView(this.c, layoutParams2);
        relativeLayout.addView(relativeLayout2, new RelativeLayout.LayoutParams(-1, d0.a(55, (Context) this)));
        this.d = new WebView(getApplicationContext());
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams3.topMargin = d0.a(55, (Context) this);
        relativeLayout.addView(this.d, layoutParams3);
        this.e = new ProgressBar(this);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, d0.a(3, (Context) this));
        layoutParams4.topMargin = d0.a(55, (Context) this);
        relativeLayout.addView(this.e, layoutParams4);
        View view = new View(this);
        view.setBackgroundResource(getResources().getIdentifier("weibosdk_common_shadow_top", "drawable", getPackageName()));
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, d0.a(3, (Context) this));
        layoutParams5.topMargin = d0.a(55, (Context) this);
        relativeLayout.addView(view, layoutParams5);
        LinearLayout linearLayout = new LinearLayout(this);
        this.f9998a = linearLayout;
        linearLayout.setOrientation(1);
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(getResources().getIdentifier("weibosdk_empty_failed", "drawable", getPackageName()));
        this.f9998a.addView(imageView);
        TextView textView3 = new TextView(this);
        textView3.setTextSize(14.0f);
        textView3.setTextColor(-4342339);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams6.topMargin = d0.a(18, (Context) this);
        layoutParams6.bottomMargin = d0.a(20, (Context) this);
        this.f9998a.addView(textView3, layoutParams6);
        textView3.setText("网络出错啦，请点击按钮重新加载");
        Button button = new Button(this);
        button.setTextSize(16.0f);
        button.setTextColor(-8882056);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(d0.a(142, (Context) this), d0.a(46, (Context) this));
        layoutParams7.gravity = 17;
        this.f9998a.addView(button, layoutParams7);
        button.setBackgroundResource(getResources().getIdentifier("retry_btn_selector", "drawable", getPackageName()));
        button.setText("重新加载");
        button.setOnClickListener(new j0(this));
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams8.addRule(13);
        relativeLayout.addView(this.f9998a, layoutParams8);
        this.f9998a.setVisibility(8);
        this.d.setWebChromeClient(new k0(this));
        setContentView(relativeLayout);
        Intent intent = getIntent();
        if (intent == null) {
            finish();
            return;
        }
        Bundle extras = intent.getExtras();
        if (extras == null) {
            finish();
            return;
        }
        int intExtra = intent.getIntExtra("web_type", -1);
        if (intExtra == -1) {
            finish();
            return;
        }
        if (intExtra == 1) {
            this.h = "微博分享";
            this.f = new y(0);
            this.g = new x(this, this, this.f);
        } else if (intExtra == 2) {
            this.h = "微博登录";
            this.f = new c();
            this.g = new b(this, this, this.f);
        } else if (intExtra == 3) {
            this.f = new i();
            this.g = new h(this, this.f);
        }
        this.d.setWebViewClient(this.g);
        e eVar = this.f;
        eVar.getClass();
        eVar.f9974a = (WebData) extras.getParcelable("web_data");
        extras.getString("_weibo_transaction");
        eVar.a(extras);
        WebSettings settings = this.d.getSettings();
        settings.setSavePassword(false);
        settings.setAllowContentAccess(false);
        settings.setUserAgentString(Build.MANUFACTURER + LunarCalendar.DATE_SEPARATOR + Build.MODEL + AccountConstantKt.DEFAULT_SEGMENT + Build.VERSION.RELEASE + AccountConstantKt.DEFAULT_SEGMENT + "weibosdk" + AccountConstantKt.DEFAULT_SEGMENT + "0041005000" + "_android");
        settings.setAllowFileAccess(false);
        settings.setJavaScriptEnabled(true);
        settings.setGeolocationEnabled(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        this.d.requestFocus();
        this.d.setScrollBarStyle(0);
        try {
            cls2.getDeclaredMethod("removeJavascriptInterface", new Class[]{cls}).invoke(this.d, new Object[]{"searchBoxJavaBridge_"});
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            cls2.getDeclaredMethod("removeJavascriptInterface", new Class[]{cls}).invoke(this.d, new Object[]{"accessibility"});
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        try {
            cls2.getDeclaredMethod("removeJavascriptInterface", new Class[]{cls}).invoke(this.d, new Object[]{"accessibilityTraversal"});
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        settings.setMixedContentMode(1);
        String a2 = this.f.a();
        if (!TextUtils.isEmpty(a2) && !TextUtils.isEmpty(a2) && (a2.startsWith("https://service.weibo.com/share/mobilesdk.php") || a2.startsWith("https://open.weibo.cn/oauth2/authorize?"))) {
            this.d.loadUrl(a2);
        }
        TextView textView4 = this.c;
        if (textView4 != null) {
            textView4.setText(this.h);
        }
    }

    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.g.a()) {
                return true;
            }
            if (this.d.canGoBack()) {
                this.d.goBack();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }
}
