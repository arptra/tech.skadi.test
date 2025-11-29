package androidx.webkit;

import android.webkit.WebSettings;
import androidx.annotation.RestrictTo;
import androidx.webkit.internal.WebSettingsAdapter;
import androidx.webkit.internal.WebViewFeatureInternal;
import androidx.webkit.internal.WebViewGlueCommunicator;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class WebSettingsCompat {

    @Target({ElementType.PARAMETER, ElementType.METHOD})
    @RestrictTo
    @Retention(RetentionPolicy.SOURCE)
    public @interface ForceDark {
    }

    @Target({ElementType.PARAMETER, ElementType.METHOD})
    @RestrictTo
    @Retention(RetentionPolicy.SOURCE)
    public @interface ForceDarkStrategy {
    }

    @Target({ElementType.PARAMETER, ElementType.METHOD})
    @RestrictTo
    @Retention(RetentionPolicy.SOURCE)
    public @interface MenuItemFlags {
    }

    public static WebSettingsAdapter a(WebSettings webSettings) {
        return WebViewGlueCommunicator.c().c(webSettings);
    }

    public static void b(WebSettings webSettings, boolean z) {
        if (WebViewFeatureInternal.P.c()) {
            a(webSettings).a(z);
            return;
        }
        throw WebViewFeatureInternal.a();
    }
}
