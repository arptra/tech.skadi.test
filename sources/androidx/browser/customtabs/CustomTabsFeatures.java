package androidx.browser.customtabs;

import androidx.annotation.RestrictTo;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@RestrictTo
public class CustomTabsFeatures {

    @Target({ElementType.PARAMETER, ElementType.METHOD})
    @RestrictTo
    @Retention(RetentionPolicy.SOURCE)
    public @interface CustomTabsFeature {
    }
}
