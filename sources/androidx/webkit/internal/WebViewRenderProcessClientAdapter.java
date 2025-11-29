package androidx.webkit.internal;

import android.webkit.WebView;
import androidx.webkit.WebViewRenderProcessClient;
import java.lang.reflect.InvocationHandler;
import java.util.concurrent.Executor;
import org.chromium.support_lib_boundary.WebViewRendererClientBoundaryInterface;

public class WebViewRenderProcessClientAdapter implements WebViewRendererClientBoundaryInterface {
    public static final String[] c = {"WEB_VIEW_RENDERER_CLIENT_BASIC_USAGE"};

    /* renamed from: a  reason: collision with root package name */
    public final Executor f1989a;
    public final WebViewRenderProcessClient b;

    public final String[] getSupportedFeatures() {
        return c;
    }

    public final void onRendererResponsive(final WebView webView, InvocationHandler invocationHandler) {
        final WebViewRenderProcessImpl b2 = WebViewRenderProcessImpl.b(invocationHandler);
        final WebViewRenderProcessClient webViewRenderProcessClient = this.b;
        Executor executor = this.f1989a;
        if (executor == null) {
            webViewRenderProcessClient.a(webView, b2);
        } else {
            executor.execute(new Runnable() {
                public void run() {
                    webViewRenderProcessClient.a(webView, b2);
                }
            });
        }
    }

    public final void onRendererUnresponsive(final WebView webView, InvocationHandler invocationHandler) {
        final WebViewRenderProcessImpl b2 = WebViewRenderProcessImpl.b(invocationHandler);
        final WebViewRenderProcessClient webViewRenderProcessClient = this.b;
        Executor executor = this.f1989a;
        if (executor == null) {
            webViewRenderProcessClient.b(webView, b2);
        } else {
            executor.execute(new Runnable() {
                public void run() {
                    webViewRenderProcessClient.b(webView, b2);
                }
            });
        }
    }
}
