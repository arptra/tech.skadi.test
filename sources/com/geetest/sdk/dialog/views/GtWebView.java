package com.geetest.sdk.dialog.views;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Handler;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.geetest.sdk.aa;
import com.geetest.sdk.utils.d;
import com.geetest.sdk.utils.g;
import com.geetest.sdk.utils.l;
import com.upuphone.runasone.uupcast.CaptureType;
import java.util.HashMap;
import java.util.List;
import org.eclipse.jetty.util.URIUtil;

public class GtWebView extends WebView {
    public static final String n = "GtWebView";

    /* renamed from: a  reason: collision with root package name */
    public Context f2915a;
    public aa b;
    public boolean c = false;
    public String d;
    public com.geetest.sdk.model.beans.b e;
    public Runnable f;
    public Handler g = null;
    public int h;
    public int i;
    public int j;
    public Paint k;
    public Path l;
    public RectF m;

    public class b extends WebChromeClient {
        public b(GtWebView gtWebView) {
        }

        public final void onProgressChanged(WebView webView, int i) {
            String h = GtWebView.n;
            l.e(h, "onProgressChanged-->newProgress: " + i);
            super.onProgressChanged(webView, i);
        }
    }

    public class c extends WebViewClient {

        /* renamed from: a  reason: collision with root package name */
        public GtWebView f2916a;

        public c(GtWebView gtWebView) {
            this.f2916a = gtWebView;
        }

        public void onLoadResource(WebView webView, String str) {
            String h = GtWebView.n;
            l.c(h, "onLoadResource-->url: " + str);
            super.onLoadResource(webView, str);
        }

        public void onPageFinished(WebView webView, String str) {
            String h = GtWebView.n;
            l.c(h, "Webview-->onPageFinished-->url: " + str);
            super.onPageFinished(webView, str);
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            String h = GtWebView.n;
            l.c(h, "Webview-->onPageStarted-->url: " + str);
            super.onPageStarted(webView, str, bitmap);
        }

        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            if (GtWebView.this.b != null) {
                String str = null;
                try {
                    String str2 = "onReceivedError-->url: " + webResourceRequest.getUrl();
                    l.c(GtWebView.n, "onReceivedError-->url: " + webResourceRequest.getUrl());
                    str = "onReceivedError-->Description: " + webResourceError.getDescription() + "-->onReceivedError-->ErrorCode: " + webResourceError.getErrorCode();
                    l.c(GtWebView.n, "onReceivedError-->Description: " + webResourceError.getDescription());
                    l.c(GtWebView.n, "onReceivedError-->ErrorCode: " + webResourceError.getErrorCode());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    if (webResourceRequest.getUrl().toString().endsWith(".mp3") && webResourceError.getErrorCode() == -1) {
                        super.onReceivedError(webView, webResourceRequest, webResourceError);
                        return;
                    }
                } catch (Exception unused) {
                }
                l.c(GtWebView.n, "webview加载出错 错误码：204_1 中间页地址有误或加载失败");
                aa d = GtWebView.this.b;
                if (TextUtils.isEmpty(str)) {
                    str = "Webview-->onReceivedError: webview load error !";
                }
                d.c("204_1", str);
            }
            if (GtWebView.this.g != null) {
                try {
                    GtWebView.this.g.removeCallbacks(GtWebView.this.f);
                    GtWebView.this.g.removeMessages(1);
                } catch (Exception unused2) {
                }
            }
            super.onReceivedError(webView, webResourceRequest, webResourceError);
        }

        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            List h;
            try {
                String uri = webResourceRequest.getUrl().toString();
                String substring = uri.substring(0, uri.indexOf("?"));
                String h2 = GtWebView.n;
                l.c(h2, "onReceivedHttpError-->getStatusCode: " + webResourceResponse.getStatusCode());
                String h3 = GtWebView.n;
                l.c(h3, "onReceivedHttpError-->url: " + uri);
                if (!TextUtils.isEmpty(GtWebView.this.d) && TextUtils.equals(substring, GtWebView.this.d.substring(0, GtWebView.this.d.indexOf("?"))) && (h = GtWebView.this.e.D().h()) != null && h.size() > 1) {
                    GtWebView gtWebView = this.f2916a;
                    StringBuilder sb = new StringBuilder();
                    sb.append(d.f2960a);
                    sb.append(String.format("%s/static/appweb/app3-index.html", new Object[]{h.get(1)}));
                    sb.append(uri.substring(uri.indexOf("?")));
                    gtWebView.loadUrl(sb.toString());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        }

        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
            if (GtWebView.this.b != null) {
                String h = GtWebView.n;
                l.c(h, "onReceivedSslError-->webview加载出错 错误码：204_2 网络证书有误, " + sslError.toString());
                aa d = GtWebView.this.b;
                d.c("204_2", "Webview-->onReceivedSslError: " + sslError.toString());
            }
            if (GtWebView.this.g != null) {
                try {
                    GtWebView.this.g.removeCallbacks(GtWebView.this.f);
                    GtWebView.this.g.removeMessages(1);
                } catch (Exception unused) {
                }
            }
        }

        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            try {
                if (webResourceRequest.getUrl().getScheme().equals(URIUtil.HTTP)) {
                    webView.removeJavascriptInterface("jsinterface");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (!(webView == null || str == null || GtWebView.this.f2915a == null)) {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.addFlags(CaptureType.CAPTURE_VIRTUAL_DISPLAY_WHEN_SCREEN_LOCKED);
                    intent.setData(Uri.parse(str));
                    GtWebView.this.f2915a.startActivity(intent);
                } catch (Exception unused) {
                }
            }
            String h = GtWebView.n;
            l.e(h, "shouldOverrideUrlLoading-->url: " + str);
            return true;
        }
    }

    public GtWebView(Context context) {
        super(context);
        new HashMap();
        c(context);
    }

    public void b() {
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setLoadWithOverviewMode(true);
        settings.setDomStorageEnabled(true);
        settings.setUseWideViewPort(true);
        settings.setCacheMode(1);
        settings.setTextZoom(100);
        settings.setSavePassword(false);
        settings.setAllowFileAccess(false);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        settings.setGeolocationEnabled(false);
        settings.setAllowContentAccess(false);
        removeJavascriptInterface("searchBoxJavaBridge_");
        removeJavascriptInterface("accessibility");
        removeJavascriptInterface("accessibilityTraversal");
        setOverScrollMode(2);
        setScrollContainer(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        onResume();
        super.setWebChromeClient(new b());
        super.setWebViewClient(new c(this));
    }

    public final void c(Context context) {
        this.f2915a = context;
        e(context);
    }

    public void destroy() {
        l.c(n, "GT3GtWebView-->destroy");
        this.f2915a = null;
        this.b = null;
        super.destroy();
    }

    public final void e(Context context) {
        Paint paint = new Paint();
        this.k = paint;
        paint.setColor(0);
        this.k.setStyle(Paint.Style.FILL);
        this.k.setAntiAlias(true);
        this.k.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    }

    public boolean f() {
        return this.c;
    }

    public Handler getMyHandler() {
        return this.g;
    }

    public Runnable getRunnable() {
        return this.f;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.c) {
            loadUrl(" ");
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        try {
            canvas.drawPath(this.l, this.k);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        String str = n;
        l.e(str, "webView硬件加速是否开启：" + canvas.isHardwareAccelerated());
    }

    public void onPause() {
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        resumeTimers();
    }

    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.h = i2;
        this.i = i3;
        String str = n;
        l.c(str, "onSizeChanged-->newWidth-->" + i2 + "-->newHeight" + i3 + "-->oldWidth" + i4 + "-->oldHeight" + i5);
        if (this.e != null) {
            this.j = g.b(getContext(), (float) this.e.s());
        }
        this.m = new RectF(0.0f, 0.0f, (float) this.h, (float) this.i);
        Path path = new Path();
        this.l = path;
        path.setFillType(Path.FillType.INVERSE_WINDING);
        Path path2 = this.l;
        RectF rectF = this.m;
        float f2 = (float) this.j;
        path2.addRoundRect(rectF, f2, f2, Path.Direction.CW);
    }

    public void setDataBean(com.geetest.sdk.model.beans.b bVar) {
        this.e = bVar;
    }

    public void setMyHandler(Handler handler) {
        this.g = handler;
    }

    public void setObservable(aa aaVar) {
        this.b = aaVar;
    }

    public void setRunnable(Runnable runnable) {
        this.f = runnable;
    }

    public void setStaticUrl(String str) {
        this.d = str;
    }

    public void setTimeout(int i2) {
    }

    public void setVoice(boolean z) {
        this.c = z;
    }
}
