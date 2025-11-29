package androidx.webkit;

import android.net.Uri;
import android.webkit.WebView;
import androidx.webkit.internal.WebViewFeatureInternal;
import androidx.webkit.internal.WebViewGlueCommunicator;
import androidx.webkit.internal.WebViewProviderFactory;

public class WebViewCompat {

    /* renamed from: a  reason: collision with root package name */
    public static final Uri f1961a = Uri.parse("*");
    public static final Uri b = Uri.parse("");

    public interface VisualStateCallback {
        void onComplete(long j);
    }

    public interface WebMessageListener {
        void a(WebView webView, WebMessageCompat webMessageCompat, Uri uri, boolean z, JavaScriptReplyProxy javaScriptReplyProxy);
    }

    public static WebViewProviderFactory a() {
        return WebViewGlueCommunicator.d();
    }

    public static boolean b() {
        if (WebViewFeatureInternal.R.c()) {
            return a().getStatics().isMultiProcessEnabled();
        }
        throw WebViewFeatureInternal.a();
    }
}
