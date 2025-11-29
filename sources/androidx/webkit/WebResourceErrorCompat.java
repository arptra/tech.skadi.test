package androidx.webkit;

import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public abstract class WebResourceErrorCompat {

    @RestrictTo
    @Retention(RetentionPolicy.SOURCE)
    public @interface NetErrorCode {
    }

    public abstract CharSequence a();

    public abstract int b();
}
