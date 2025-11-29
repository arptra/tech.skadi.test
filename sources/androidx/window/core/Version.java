package androidx.window.core;

import com.meizu.common.util.LunarCalendar;
import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001%B)\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\f\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0014R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0016\u001a\u0004\b\u0019\u0010\u0014R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0016\u001a\u0004\b\u001b\u0010\u0014R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u000bR\u001b\u0010$\u001a\u00020\u001f8BX\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#¨\u0006&"}, d2 = {"Landroidx/window/core/Version;", "", "", "major", "minor", "patch", "", "description", "<init>", "(IIILjava/lang/String;)V", "toString", "()Ljava/lang/String;", "other", "f", "(Landroidx/window/core/Version;)I", "", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "a", "I", "h", "b", "i", "c", "j", "d", "Ljava/lang/String;", "getDescription", "Ljava/math/BigInteger;", "e", "Lkotlin/Lazy;", "g", "()Ljava/math/BigInteger;", "bigInteger", "Companion", "window_release"}, k = 1, mv = {1, 6, 0})
public final class Version implements Comparable<Version> {
    public static final Companion f = new Companion((DefaultConstructorMarker) null);
    public static final Version g = new Version(0, 0, 0, "");
    public static final Version h = new Version(0, 1, 0, "");
    public static final Version i;
    public static final Version j;

    /* renamed from: a  reason: collision with root package name */
    public final int f2000a;
    public final int b;
    public final int c;
    public final String d;
    public final Lazy e;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00048\u0002XT¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Landroidx/window/core/Version$Companion;", "", "<init>", "()V", "", "versionString", "Landroidx/window/core/Version;", "b", "(Ljava/lang/String;)Landroidx/window/core/Version;", "VERSION_0_1", "Landroidx/window/core/Version;", "a", "()Landroidx/window/core/Version;", "VERSION_PATTERN_STRING", "Ljava/lang/String;", "window_release"}, k = 1, mv = {1, 6, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Version a() {
            return Version.h;
        }

        public final Version b(String str) {
            if (str == null || StringsKt.isBlank(str)) {
                return null;
            }
            Matcher matcher = Pattern.compile("(\\d+)(?:\\.(\\d+))(?:\\.(\\d+))(?:-(.+))?").matcher(str);
            if (!matcher.matches()) {
                return null;
            }
            String group = matcher.group(1);
            Integer valueOf = group == null ? null : Integer.valueOf(Integer.parseInt(group));
            if (valueOf == null) {
                return null;
            }
            int intValue = valueOf.intValue();
            String group2 = matcher.group(2);
            Integer valueOf2 = group2 == null ? null : Integer.valueOf(Integer.parseInt(group2));
            if (valueOf2 == null) {
                return null;
            }
            int intValue2 = valueOf2.intValue();
            String group3 = matcher.group(3);
            Integer valueOf3 = group3 == null ? null : Integer.valueOf(Integer.parseInt(group3));
            if (valueOf3 == null) {
                return null;
            }
            int intValue3 = valueOf3.intValue();
            String group4 = matcher.group(4) != null ? matcher.group(4) : "";
            Intrinsics.checkNotNullExpressionValue(group4, "description");
            return new Version(intValue, intValue2, intValue3, group4, (DefaultConstructorMarker) null);
        }

        public Companion() {
        }
    }

    static {
        Version version = new Version(1, 0, 0, "");
        i = version;
        j = version;
    }

    public /* synthetic */ Version(int i2, int i3, int i4, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(i2, i3, i4, str);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Version)) {
            return false;
        }
        Version version = (Version) obj;
        return this.f2000a == version.f2000a && this.b == version.b && this.c == version.c;
    }

    /* renamed from: f */
    public int compareTo(Version version) {
        Intrinsics.checkNotNullParameter(version, "other");
        return g().compareTo(version.g());
    }

    public final BigInteger g() {
        Object value = this.e.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-bigInteger>(...)");
        return (BigInteger) value;
    }

    public final int h() {
        return this.f2000a;
    }

    public int hashCode() {
        return ((((527 + this.f2000a) * 31) + this.b) * 31) + this.c;
    }

    public final int i() {
        return this.b;
    }

    public final int j() {
        return this.c;
    }

    public String toString() {
        String stringPlus = StringsKt.isBlank(this.d) ^ true ? Intrinsics.stringPlus(LunarCalendar.DATE_SEPARATOR, this.d) : "";
        return this.f2000a + '.' + this.b + '.' + this.c + stringPlus;
    }

    public Version(int i2, int i3, int i4, String str) {
        this.f2000a = i2;
        this.b = i3;
        this.c = i4;
        this.d = str;
        this.e = LazyKt.lazy(new Version$bigInteger$2(this));
    }
}
