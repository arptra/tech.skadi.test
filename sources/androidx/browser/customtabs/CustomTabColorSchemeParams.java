package androidx.browser.customtabs;

import android.os.Bundle;

public final class CustomTabColorSchemeParams {

    /* renamed from: a  reason: collision with root package name */
    public final Integer f405a;
    public final Integer b;
    public final Integer c;
    public final Integer d;

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        public Integer f406a;
        public Integer b;
        public Integer c;
        public Integer d;

        public CustomTabColorSchemeParams a() {
            return new CustomTabColorSchemeParams(this.f406a, this.b, this.c, this.d);
        }
    }

    public CustomTabColorSchemeParams(Integer num, Integer num2, Integer num3, Integer num4) {
        this.f405a = num;
        this.b = num2;
        this.c = num3;
        this.d = num4;
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        Integer num = this.f405a;
        if (num != null) {
            bundle.putInt("android.support.customtabs.extra.TOOLBAR_COLOR", num.intValue());
        }
        Integer num2 = this.b;
        if (num2 != null) {
            bundle.putInt("android.support.customtabs.extra.SECONDARY_TOOLBAR_COLOR", num2.intValue());
        }
        Integer num3 = this.c;
        if (num3 != null) {
            bundle.putInt("androidx.browser.customtabs.extra.NAVIGATION_BAR_COLOR", num3.intValue());
        }
        Integer num4 = this.d;
        if (num4 != null) {
            bundle.putInt("androidx.browser.customtabs.extra.NAVIGATION_BAR_DIVIDER_COLOR", num4.intValue());
        }
        return bundle;
    }
}
