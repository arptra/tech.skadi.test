package androidx.webkit;

import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

public class TracingConfig {

    /* renamed from: a  reason: collision with root package name */
    public int f1954a;
    public final List b;
    public int c;

    public static class Builder {
    }

    @RestrictTo
    @Retention(RetentionPolicy.SOURCE)
    public @interface PredefinedCategories {
    }

    @RestrictTo
    @Retention(RetentionPolicy.SOURCE)
    public @interface TracingMode {
    }

    public List a() {
        return this.b;
    }

    public int b() {
        return this.f1954a;
    }

    public int c() {
        return this.c;
    }
}
