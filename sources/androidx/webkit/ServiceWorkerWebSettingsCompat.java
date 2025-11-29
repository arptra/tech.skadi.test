package androidx.webkit;

import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public abstract class ServiceWorkerWebSettingsCompat {

    @RestrictTo
    @Retention(RetentionPolicy.SOURCE)
    public @interface CacheMode {
    }
}
