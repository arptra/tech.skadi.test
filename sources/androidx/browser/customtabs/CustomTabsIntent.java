package androidx.browser.customtabs;

import android.app.ActivityOptions;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.LocaleList;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.browser.customtabs.CustomTabColorSchemeParams;
import androidx.core.content.ContextCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Locale;

public final class CustomTabsIntent {

    /* renamed from: a  reason: collision with root package name */
    public final Intent f418a;
    public final Bundle b;

    @RestrictTo
    @Retention(RetentionPolicy.SOURCE)
    public @interface ActivityHeightResizeBehavior {
    }

    @RestrictTo
    @Retention(RetentionPolicy.SOURCE)
    public @interface ActivitySideSheetDecorationType {
    }

    @RestrictTo
    @Retention(RetentionPolicy.SOURCE)
    public @interface ActivitySideSheetPosition {
    }

    @RestrictTo
    @Retention(RetentionPolicy.SOURCE)
    public @interface ActivitySideSheetRoundedCornersPosition {
    }

    @RequiresApi
    public static class Api21Impl {
        @DoNotInline
        @Nullable
        public static Locale a(Intent intent) {
            String stringExtra = intent.getStringExtra("androidx.browser.customtabs.extra.TRANSLATE_LANGUAGE_TAG");
            if (stringExtra != null) {
                return Locale.forLanguageTag(stringExtra);
            }
            return null;
        }

        @DoNotInline
        public static void b(Intent intent, Locale locale) {
            intent.putExtra("androidx.browser.customtabs.extra.TRANSLATE_LANGUAGE_TAG", locale.toLanguageTag());
        }
    }

    @RequiresApi
    public static class Api23Impl {
        @DoNotInline
        public static ActivityOptions a() {
            return ActivityOptions.makeBasic();
        }
    }

    @RequiresApi
    public static class Api24Impl {
        @DoNotInline
        @Nullable
        public static String a() {
            LocaleList adjustedDefault = LocaleList.getAdjustedDefault();
            if (adjustedDefault.size() > 0) {
                return adjustedDefault.get(0).toLanguageTag();
            }
            return null;
        }
    }

    @RequiresApi
    public static class Api34Impl {
        @DoNotInline
        public static void a(ActivityOptions activityOptions, boolean z) {
            activityOptions.setShareIdentityEnabled(z);
        }
    }

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        public final Intent f419a = new Intent("android.intent.action.VIEW");
        public final CustomTabColorSchemeParams.Builder b = new CustomTabColorSchemeParams.Builder();
        public ArrayList c;
        public ActivityOptions d;
        public ArrayList e;
        public SparseArray f;
        public Bundle g;
        public int h = 0;
        public boolean i = true;
        public boolean j;

        public CustomTabsIntent a() {
            Bundle bundle = null;
            if (!this.f419a.hasExtra("android.support.customtabs.extra.SESSION")) {
                c((IBinder) null, (PendingIntent) null);
            }
            ArrayList arrayList = this.c;
            if (arrayList != null) {
                this.f419a.putParcelableArrayListExtra("android.support.customtabs.extra.MENU_ITEMS", arrayList);
            }
            ArrayList arrayList2 = this.e;
            if (arrayList2 != null) {
                this.f419a.putParcelableArrayListExtra("android.support.customtabs.extra.TOOLBAR_ITEMS", arrayList2);
            }
            this.f419a.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", this.i);
            this.f419a.putExtras(this.b.a().a());
            Bundle bundle2 = this.g;
            if (bundle2 != null) {
                this.f419a.putExtras(bundle2);
            }
            if (this.f != null) {
                Bundle bundle3 = new Bundle();
                bundle3.putSparseParcelableArray("androidx.browser.customtabs.extra.COLOR_SCHEME_PARAMS", this.f);
                this.f419a.putExtras(bundle3);
            }
            this.f419a.putExtra("androidx.browser.customtabs.extra.SHARE_STATE", this.h);
            int i2 = Build.VERSION.SDK_INT;
            b();
            if (i2 >= 34) {
                d();
            }
            ActivityOptions activityOptions = this.d;
            if (activityOptions != null) {
                bundle = activityOptions.toBundle();
            }
            return new CustomTabsIntent(this.f419a, bundle);
        }

        public final void b() {
            String a2 = Api24Impl.a();
            if (!TextUtils.isEmpty(a2)) {
                Bundle bundleExtra = this.f419a.hasExtra("com.android.browser.headers") ? this.f419a.getBundleExtra("com.android.browser.headers") : new Bundle();
                if (!bundleExtra.containsKey("Accept-Language")) {
                    bundleExtra.putString("Accept-Language", a2);
                    this.f419a.putExtra("com.android.browser.headers", bundleExtra);
                }
            }
        }

        public final void c(IBinder iBinder, PendingIntent pendingIntent) {
            Bundle bundle = new Bundle();
            bundle.putBinder("android.support.customtabs.extra.SESSION", iBinder);
            if (pendingIntent != null) {
                bundle.putParcelable("android.support.customtabs.extra.SESSION_ID", pendingIntent);
            }
            this.f419a.putExtras(bundle);
        }

        public final void d() {
            if (this.d == null) {
                this.d = Api23Impl.a();
            }
            Api34Impl.a(this.d, this.j);
        }

        public Builder e(boolean z) {
            this.f419a.putExtra("android.support.customtabs.extra.TITLE_VISIBILITY", z ? 1 : 0);
            return this;
        }
    }

    @RestrictTo
    @Retention(RetentionPolicy.SOURCE)
    public @interface CloseButtonPosition {
    }

    @RestrictTo
    @Retention(RetentionPolicy.SOURCE)
    public @interface ColorScheme {
    }

    @RestrictTo
    @Retention(RetentionPolicy.SOURCE)
    public @interface ShareState {
    }

    public CustomTabsIntent(Intent intent, Bundle bundle) {
        this.f418a = intent;
        this.b = bundle;
    }

    public void a(Context context, Uri uri) {
        this.f418a.setData(uri);
        ContextCompat.startActivity(context, this.f418a, this.b);
    }
}
