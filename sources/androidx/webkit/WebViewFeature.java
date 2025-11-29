package androidx.webkit;

import androidx.annotation.RestrictTo;
import androidx.webkit.internal.WebViewFeatureInternal;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class WebViewFeature {

    @Target({ElementType.PARAMETER, ElementType.METHOD})
    @RestrictTo
    @Retention(RetentionPolicy.SOURCE)
    public @interface WebViewStartupFeature {
    }

    @Target({ElementType.PARAMETER, ElementType.METHOD})
    @RestrictTo
    @Retention(RetentionPolicy.SOURCE)
    public @interface WebViewSupportFeature {
    }

    public static boolean a(String str) {
        return WebViewFeatureInternal.b(str);
    }
}
