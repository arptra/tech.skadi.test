package androidx.browser.trusted.sharing;

import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class ShareTarget {

    @RestrictTo
    @Retention(RetentionPolicy.SOURCE)
    public @interface EncodingType {
    }

    public static final class FileFormField {
    }

    public static class Params {
    }

    @RestrictTo
    @Retention(RetentionPolicy.SOURCE)
    public @interface RequestMethod {
    }
}
