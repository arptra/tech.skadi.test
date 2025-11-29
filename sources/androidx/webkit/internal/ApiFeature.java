package androidx.webkit.internal;

import android.os.Build;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;

public abstract class ApiFeature implements ConditionallySupportedFeature {
    public static final Set c = new HashSet();

    /* renamed from: a  reason: collision with root package name */
    public final String f1962a;
    public final String b;

    public static class LAZY_HOLDER {

        /* renamed from: a  reason: collision with root package name */
        public static final Set f1963a = new HashSet(Arrays.asList(WebViewGlueCommunicator.d().a()));
    }

    public static class M extends ApiFeature {
        public M(String str, String str2) {
            super(str, str2);
        }

        public final boolean b() {
            return true;
        }
    }

    public static class N extends ApiFeature {
        public N(String str, String str2) {
            super(str, str2);
        }

        public final boolean b() {
            return true;
        }
    }

    public static class NoFramework extends ApiFeature {
        public NoFramework(String str, String str2) {
            super(str, str2);
        }

        public final boolean b() {
            return false;
        }
    }

    public static class O extends ApiFeature {
        public O(String str, String str2) {
            super(str, str2);
        }

        public final boolean b() {
            return true;
        }
    }

    public static class O_MR1 extends ApiFeature {
        public O_MR1(String str, String str2) {
            super(str, str2);
        }

        public final boolean b() {
            return true;
        }
    }

    public static class P extends ApiFeature {
        public P(String str, String str2) {
            super(str, str2);
        }

        public final boolean b() {
            return true;
        }
    }

    public static class Q extends ApiFeature {
        public Q(String str, String str2) {
            super(str, str2);
        }

        public final boolean b() {
            return true;
        }
    }

    public static class T extends ApiFeature {
        public T(String str, String str2) {
            super(str, str2);
        }

        public final boolean b() {
            return Build.VERSION.SDK_INT >= 33;
        }
    }

    public ApiFeature(String str, String str2) {
        this.f1962a = str;
        this.b = str2;
        c.add(this);
    }

    public static Set d() {
        return Collections.unmodifiableSet(c);
    }

    public String a() {
        return this.f1962a;
    }

    public abstract boolean b();

    public boolean c() {
        return BoundaryInterfaceReflectionUtil.b(LAZY_HOLDER.f1963a, this.b);
    }

    public boolean isSupported() {
        return b() || c();
    }
}
