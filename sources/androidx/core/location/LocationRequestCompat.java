package androidx.core.location;

import android.location.LocationRequest;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.util.TimeUtils;
import com.honey.account.n.b;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import kotlin.jvm.internal.LongCompanionObject;

public final class LocationRequestCompat {

    /* renamed from: a  reason: collision with root package name */
    public final int f748a;
    public final long b;
    public final long c;
    public final long d;
    public final int e;
    public final float f;
    public final long g;

    public static class Api19Impl {

        /* renamed from: a  reason: collision with root package name */
        public static Class f749a;
        public static Method b;
        public static Method c;
        public static Method d;
        public static Method e;
        public static Method f;

        public static Object a(LocationRequestCompat locationRequestCompat, String str) {
            try {
                if (f749a == null) {
                    f749a = Class.forName("android.location.LocationRequest");
                }
                if (b == null) {
                    Method declaredMethod = f749a.getDeclaredMethod("createFromDeprecatedProvider", new Class[]{String.class, Long.TYPE, Float.TYPE, Boolean.TYPE});
                    b = declaredMethod;
                    declaredMethod.setAccessible(true);
                }
                Object invoke = b.invoke((Object) null, new Object[]{str, Long.valueOf(locationRequestCompat.b()), Float.valueOf(locationRequestCompat.e()), Boolean.FALSE});
                if (invoke == null) {
                    return null;
                }
                if (c == null) {
                    Method declaredMethod2 = f749a.getDeclaredMethod("setQuality", new Class[]{Integer.TYPE});
                    c = declaredMethod2;
                    declaredMethod2.setAccessible(true);
                }
                c.invoke(invoke, new Object[]{Integer.valueOf(locationRequestCompat.g())});
                if (d == null) {
                    Method declaredMethod3 = f749a.getDeclaredMethod("setFastestInterval", new Class[]{Long.TYPE});
                    d = declaredMethod3;
                    declaredMethod3.setAccessible(true);
                }
                d.invoke(invoke, new Object[]{Long.valueOf(locationRequestCompat.f())});
                if (locationRequestCompat.d() < Integer.MAX_VALUE) {
                    if (e == null) {
                        Method declaredMethod4 = f749a.getDeclaredMethod("setNumUpdates", new Class[]{Integer.TYPE});
                        e = declaredMethod4;
                        declaredMethod4.setAccessible(true);
                    }
                    e.invoke(invoke, new Object[]{Integer.valueOf(locationRequestCompat.d())});
                }
                if (locationRequestCompat.a() < LongCompanionObject.MAX_VALUE) {
                    if (f == null) {
                        Method declaredMethod5 = f749a.getDeclaredMethod("setExpireIn", new Class[]{Long.TYPE});
                        f = declaredMethod5;
                        declaredMethod5.setAccessible(true);
                    }
                    f.invoke(invoke, new Object[]{Long.valueOf(locationRequestCompat.a())});
                }
                return invoke;
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                return null;
            }
        }
    }

    @RequiresApi
    public static class Api31Impl {
        @DoNotInline
        public static LocationRequest a(LocationRequestCompat locationRequestCompat) {
            return new LocationRequest.Builder(locationRequestCompat.b()).setQuality(locationRequestCompat.g()).setMinUpdateIntervalMillis(locationRequestCompat.f()).setDurationMillis(locationRequestCompat.a()).setMaxUpdates(locationRequestCompat.d()).setMinUpdateDistanceMeters(locationRequestCompat.e()).setMaxUpdateDelayMillis(locationRequestCompat.c()).build();
        }
    }

    public static final class Builder {
    }

    @RestrictTo
    @Retention(RetentionPolicy.SOURCE)
    public @interface Quality {
    }

    public long a() {
        return this.d;
    }

    public long b() {
        return this.b;
    }

    public long c() {
        return this.g;
    }

    public int d() {
        return this.e;
    }

    public float e() {
        return this.f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocationRequestCompat)) {
            return false;
        }
        LocationRequestCompat locationRequestCompat = (LocationRequestCompat) obj;
        return this.f748a == locationRequestCompat.f748a && this.b == locationRequestCompat.b && this.c == locationRequestCompat.c && this.d == locationRequestCompat.d && this.e == locationRequestCompat.e && Float.compare(locationRequestCompat.f, this.f) == 0 && this.g == locationRequestCompat.g;
    }

    public long f() {
        long j = this.c;
        return j == -1 ? this.b : j;
    }

    public int g() {
        return this.f748a;
    }

    public LocationRequest h() {
        return Api31Impl.a(this);
    }

    public int hashCode() {
        long j = this.b;
        long j2 = this.c;
        return (((this.f748a * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) (j2 ^ (j2 >>> 32)));
    }

    public LocationRequest i(String str) {
        return Build.VERSION.SDK_INT >= 31 ? h() : b.a(Api19Impl.a(this, str));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request[");
        if (this.b != LongCompanionObject.MAX_VALUE) {
            sb.append("@");
            TimeUtils.e(this.b, sb);
            int i = this.f748a;
            if (i == 100) {
                sb.append(" HIGH_ACCURACY");
            } else if (i == 102) {
                sb.append(" BALANCED");
            } else if (i == 104) {
                sb.append(" LOW_POWER");
            }
        } else {
            sb.append("PASSIVE");
        }
        if (this.d != LongCompanionObject.MAX_VALUE) {
            sb.append(", duration=");
            TimeUtils.e(this.d, sb);
        }
        if (this.e != Integer.MAX_VALUE) {
            sb.append(", maxUpdates=");
            sb.append(this.e);
        }
        long j = this.c;
        if (j != -1 && j < this.b) {
            sb.append(", minUpdateInterval=");
            TimeUtils.e(this.c, sb);
        }
        if (((double) this.f) > 0.0d) {
            sb.append(", minUpdateDistance=");
            sb.append(this.f);
        }
        if (this.g / 2 > this.b) {
            sb.append(", maxUpdateDelay=");
            TimeUtils.e(this.g, sb);
        }
        sb.append(']');
        return sb.toString();
    }
}
