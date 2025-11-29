package androidx.browser.browseractions;

import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Deprecated
public class BrowserActionsIntent {

    @RestrictTo
    @VisibleForTesting
    public interface BrowserActionsFallDialogListener {
    }

    @RestrictTo
    @Retention(RetentionPolicy.SOURCE)
    public @interface BrowserActionsItemId {
    }

    @RestrictTo
    @Retention(RetentionPolicy.SOURCE)
    public @interface BrowserActionsUrlType {
    }

    public static final class Builder {
    }
}
