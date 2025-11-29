package androidx.core.content;

import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class PackageManagerCompat {

    @RequiresApi
    public static class Api30Impl {
    }

    @RestrictTo
    @Retention(RetentionPolicy.SOURCE)
    public @interface UnusedAppRestrictionsStatus {
    }
}
