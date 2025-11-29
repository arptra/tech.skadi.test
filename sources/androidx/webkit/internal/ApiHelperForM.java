package androidx.webkit.internal;

import android.net.Uri;
import android.os.Handler;
import android.webkit.WebMessage;
import android.webkit.WebMessagePort;
import android.webkit.WebResourceError;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.webkit.WebMessageCompat;
import androidx.webkit.WebMessagePortCompat;
import androidx.webkit.WebViewCompat;

@RequiresApi
public class ApiHelperForM {
    @DoNotInline
    public static void a(@NonNull WebMessagePort webMessagePort) {
        webMessagePort.close();
    }

    @DoNotInline
    @NonNull
    public static WebMessage b(@NonNull WebMessageCompat webMessageCompat) {
        return new WebMessage(webMessageCompat.c(), WebMessagePortImpl.c(webMessageCompat.d()));
    }

    @DoNotInline
    @NonNull
    public static WebMessagePort[] c(@NonNull WebView webView) {
        return webView.createWebMessageChannel();
    }

    @DoNotInline
    @NonNull
    public static WebMessageCompat d(@NonNull WebMessage webMessage) {
        return new WebMessageCompat(webMessage.getData(), WebMessagePortImpl.g(webMessage.getPorts()));
    }

    @DoNotInline
    @NonNull
    public static CharSequence e(@NonNull WebResourceError webResourceError) {
        return webResourceError.getDescription();
    }

    @DoNotInline
    public static int f(@NonNull WebResourceError webResourceError) {
        return webResourceError.getErrorCode();
    }

    @DoNotInline
    public static boolean g(@NonNull WebSettings webSettings) {
        return webSettings.getOffscreenPreRaster();
    }

    @DoNotInline
    public static void h(@NonNull WebMessagePort webMessagePort, @NonNull WebMessage webMessage) {
        webMessagePort.postMessage(webMessage);
    }

    @DoNotInline
    public static void i(@NonNull WebView webView, long j, @NonNull final WebViewCompat.VisualStateCallback visualStateCallback) {
        webView.postVisualStateCallback(j, new WebView.VisualStateCallback() {
            public void onComplete(long j) {
                WebViewCompat.VisualStateCallback.this.onComplete(j);
            }
        });
    }

    @DoNotInline
    public static void j(@NonNull WebView webView, @NonNull WebMessage webMessage, @NonNull Uri uri) {
        webView.postWebMessage(webMessage, uri);
    }

    @DoNotInline
    public static void k(@NonNull WebSettings webSettings, boolean z) {
        webSettings.setOffscreenPreRaster(z);
    }

    @DoNotInline
    public static void l(@NonNull WebMessagePort webMessagePort, @NonNull final WebMessagePortCompat.WebMessageCallbackCompat webMessageCallbackCompat) {
        webMessagePort.setWebMessageCallback(new WebMessagePort.WebMessageCallback() {
            public void onMessage(WebMessagePort webMessagePort, WebMessage webMessage) {
                WebMessagePortCompat.WebMessageCallbackCompat.this.a(new WebMessagePortImpl(webMessagePort), WebMessagePortImpl.d(webMessage));
            }
        });
    }

    @DoNotInline
    public static void m(@NonNull WebMessagePort webMessagePort, @NonNull final WebMessagePortCompat.WebMessageCallbackCompat webMessageCallbackCompat, @Nullable Handler handler) {
        webMessagePort.setWebMessageCallback(new WebMessagePort.WebMessageCallback() {
            public void onMessage(WebMessagePort webMessagePort, WebMessage webMessage) {
                WebMessagePortCompat.WebMessageCallbackCompat.this.a(new WebMessagePortImpl(webMessagePort), WebMessagePortImpl.d(webMessage));
            }
        }, handler);
    }
}
