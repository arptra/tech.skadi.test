package androidx.webkit.internal;

import android.content.pm.PackageInfo;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

@RequiresApi
public class ApiHelperForO {
    @DoNotInline
    @NonNull
    public static PackageInfo a() {
        return WebView.getCurrentWebViewPackage();
    }

    @DoNotInline
    public static boolean b(@NonNull WebSettings webSettings) {
        return webSettings.getSafeBrowsingEnabled();
    }

    @DoNotInline
    @Nullable
    public static WebChromeClient c(@NonNull WebView webView) {
        return webView.getWebChromeClient();
    }

    @DoNotInline
    @Nullable
    public static WebViewClient d(@NonNull WebView webView) {
        return webView.getWebViewClient();
    }

    @DoNotInline
    public static void e(@NonNull WebSettings webSettings, boolean z) {
        webSettings.setSafeBrowsingEnabled(z);
    }
}
