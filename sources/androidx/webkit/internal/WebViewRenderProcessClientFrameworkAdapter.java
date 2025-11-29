package androidx.webkit.internal;

import android.webkit.WebView;
import android.webkit.WebViewRenderProcess;
import android.webkit.WebViewRenderProcessClient;
import androidx.annotation.RequiresApi;

@RequiresApi
public class WebViewRenderProcessClientFrameworkAdapter extends WebViewRenderProcessClient {

    /* renamed from: a  reason: collision with root package name */
    public androidx.webkit.WebViewRenderProcessClient f1992a;

    public WebViewRenderProcessClientFrameworkAdapter(androidx.webkit.WebViewRenderProcessClient webViewRenderProcessClient) {
        this.f1992a = webViewRenderProcessClient;
    }

    public void onRenderProcessResponsive(WebView webView, WebViewRenderProcess webViewRenderProcess) {
        this.f1992a.a(webView, WebViewRenderProcessImpl.a(webViewRenderProcess));
    }

    public void onRenderProcessUnresponsive(WebView webView, WebViewRenderProcess webViewRenderProcess) {
        this.f1992a.b(webView, WebViewRenderProcessImpl.a(webViewRenderProcess));
    }
}
