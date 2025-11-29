package androidx.core.os;

import android.os.Build;
import android.os.ext.SdkExtensions;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import java.lang.annotation.RetentionPolicy;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.RequiresOptIn;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.Retention;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.DurationKt;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0015\u0016B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\f\u0010\u000bJ\u000f\u0010\r\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\r\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\u000e8\u0006X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u000e8\u0006X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u000e8\u0006X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u000e8\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u000f¨\u0006\u0017"}, d2 = {"Landroidx/core/os/BuildCompat;", "", "<init>", "()V", "", "codename", "buildCodename", "", "a", "(Ljava/lang/String;Ljava/lang/String;)Z", "b", "()Z", "c", "d", "", "I", "R_EXTENSION_INT", "S_EXTENSION_INT", "T_EXTENSION_INT", "e", "AD_SERVICES_EXTENSION_INT", "Api30Impl", "PrereleaseSdkCheck", "core_release"}, k = 1, mv = {1, 8, 0})
public final class BuildCompat {

    /* renamed from: a  reason: collision with root package name */
    public static final BuildCompat f768a = new BuildCompat();
    public static final int b;
    public static final int c;
    public static final int d;
    public static final int e;

    @RequiresApi
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/core/os/BuildCompat$Api30Impl;", "", "<init>", "()V", "", "extension", "a", "(I)I", "core_release"}, k = 1, mv = {1, 8, 0})
    public static final class Api30Impl {

        /* renamed from: a  reason: collision with root package name */
        public static final Api30Impl f769a = new Api30Impl();

        @DoNotInline
        public final int a(int i) {
            return SdkExtensions.getExtensionVersion(i);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Landroidx/core/os/BuildCompat$PrereleaseSdkCheck;", "", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @RequiresOptIn
    @Retention(AnnotationRetention.BINARY)
    @java.lang.annotation.Retention(RetentionPolicy.CLASS)
    public @interface PrereleaseSdkCheck {
    }

    static {
        int i = Build.VERSION.SDK_INT;
        int i2 = 0;
        b = i >= 30 ? Api30Impl.f769a.a(30) : 0;
        c = i >= 30 ? Api30Impl.f769a.a(31) : 0;
        d = i >= 30 ? Api30Impl.f769a.a(33) : 0;
        if (i >= 30) {
            i2 = Api30Impl.f769a.a(DurationKt.NANOS_IN_MILLIS);
        }
        e = i2;
    }

    public static final boolean a(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "codename");
        Intrinsics.checkNotNullParameter(str2, "buildCodename");
        if (Intrinsics.areEqual((Object) "REL", (Object) str2)) {
            return false;
        }
        Locale locale = Locale.ROOT;
        String upperCase = str2.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        String upperCase2 = str.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(upperCase2, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        return upperCase.compareTo(upperCase2) >= 0;
    }

    public static final boolean b() {
        int i = Build.VERSION.SDK_INT;
        if (i < 33) {
            if (i >= 32) {
                String str = Build.VERSION.CODENAME;
                Intrinsics.checkNotNullExpressionValue(str, "CODENAME");
                if (a("Tiramisu", str)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public static final boolean c() {
        int i = Build.VERSION.SDK_INT;
        if (i < 34) {
            if (i >= 33) {
                String str = Build.VERSION.CODENAME;
                Intrinsics.checkNotNullExpressionValue(str, "CODENAME");
                if (a("UpsideDownCake", str)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public static final boolean d() {
        if (Build.VERSION.SDK_INT >= 34) {
            String str = Build.VERSION.CODENAME;
            Intrinsics.checkNotNullExpressionValue(str, "CODENAME");
            if (a("VanillaIceCream", str)) {
                return true;
            }
        }
        return false;
    }
}
