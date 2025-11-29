package androidx.core.view.accessibility;

import android.graphics.Rect;
import android.graphics.Region;
import android.os.Build;
import android.os.LocaleList;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityWindowInfo;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.core.os.LocaleListCompat;

public class AccessibilityWindowInfoCompat {

    /* renamed from: a  reason: collision with root package name */
    public final Object f934a;

    @RequiresApi
    public static class Api21Impl {
        @DoNotInline
        public static void a(AccessibilityWindowInfo accessibilityWindowInfo, Rect rect) {
            accessibilityWindowInfo.getBoundsInScreen(rect);
        }

        @DoNotInline
        public static AccessibilityWindowInfo b(AccessibilityWindowInfo accessibilityWindowInfo, int i) {
            return accessibilityWindowInfo.getChild(i);
        }

        @DoNotInline
        public static int c(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getChildCount();
        }

        @DoNotInline
        public static int d(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getId();
        }

        @DoNotInline
        public static int e(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getLayer();
        }

        @DoNotInline
        public static AccessibilityWindowInfo f(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getParent();
        }

        @DoNotInline
        public static AccessibilityNodeInfo g(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getRoot();
        }

        @DoNotInline
        public static int h(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getType();
        }

        @DoNotInline
        public static boolean i(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.isAccessibilityFocused();
        }

        @DoNotInline
        public static boolean j(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.isActive();
        }

        @DoNotInline
        public static boolean k(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.isFocused();
        }

        @DoNotInline
        public static AccessibilityWindowInfo l() {
            return AccessibilityWindowInfo.obtain();
        }

        @DoNotInline
        public static AccessibilityWindowInfo m(AccessibilityWindowInfo accessibilityWindowInfo) {
            return AccessibilityWindowInfo.obtain(accessibilityWindowInfo);
        }
    }

    @RequiresApi
    public static class Api24Impl {
        @DoNotInline
        public static AccessibilityNodeInfo a(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getAnchor();
        }

        @DoNotInline
        public static CharSequence b(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getTitle();
        }
    }

    @RequiresApi
    public static class Api26Impl {
        @DoNotInline
        public static boolean a(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.isInPictureInPictureMode();
        }
    }

    @RequiresApi
    public static class Api30Impl {
        @DoNotInline
        public static AccessibilityWindowInfo a() {
            return new AccessibilityWindowInfo();
        }
    }

    @RequiresApi
    public static class Api33Impl {
        @DoNotInline
        public static int a(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getDisplayId();
        }

        @DoNotInline
        public static void b(AccessibilityWindowInfo accessibilityWindowInfo, Region region) {
            accessibilityWindowInfo.getRegionInScreen(region);
        }

        @DoNotInline
        public static AccessibilityNodeInfoCompat c(Object obj, int i) {
            return AccessibilityNodeInfoCompat.Q0(((AccessibilityWindowInfo) obj).getRoot(i));
        }
    }

    @RequiresApi
    public static class Api34Impl {
        @DoNotInline
        public static LocaleList a(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getLocales();
        }

        @DoNotInline
        public static long b(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getTransitionTimeMillis();
        }
    }

    public AccessibilityWindowInfoCompat(Object obj) {
        this.f934a = obj;
    }

    public static String k(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? "<UNKNOWN>" : "TYPE_ACCESSIBILITY_OVERLAY" : "TYPE_SYSTEM" : "TYPE_INPUT_METHOD" : "TYPE_APPLICATION";
    }

    public static AccessibilityWindowInfoCompat l(Object obj) {
        if (obj != null) {
            return new AccessibilityWindowInfoCompat(obj);
        }
        return null;
    }

    public void a(Rect rect) {
        Api21Impl.a((AccessibilityWindowInfo) this.f934a, rect);
    }

    public int b() {
        return Api21Impl.c((AccessibilityWindowInfo) this.f934a);
    }

    public int c() {
        return Api21Impl.d((AccessibilityWindowInfo) this.f934a);
    }

    public int d() {
        return Api21Impl.e((AccessibilityWindowInfo) this.f934a);
    }

    public LocaleListCompat e() {
        return Build.VERSION.SDK_INT >= 34 ? LocaleListCompat.j(Api34Impl.a((AccessibilityWindowInfo) this.f934a)) : LocaleListCompat.e();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AccessibilityWindowInfoCompat)) {
            return false;
        }
        AccessibilityWindowInfoCompat accessibilityWindowInfoCompat = (AccessibilityWindowInfoCompat) obj;
        Object obj2 = this.f934a;
        return obj2 == null ? accessibilityWindowInfoCompat.f934a == null : obj2.equals(accessibilityWindowInfoCompat.f934a);
    }

    public AccessibilityWindowInfoCompat f() {
        return l(Api21Impl.f((AccessibilityWindowInfo) this.f934a));
    }

    public long g() {
        if (Build.VERSION.SDK_INT >= 34) {
            return Api34Impl.b((AccessibilityWindowInfo) this.f934a);
        }
        return 0;
    }

    public int h() {
        return Api21Impl.h((AccessibilityWindowInfo) this.f934a);
    }

    public int hashCode() {
        Object obj = this.f934a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public boolean i() {
        return Api21Impl.j((AccessibilityWindowInfo) this.f934a);
    }

    public boolean j() {
        return Api21Impl.k((AccessibilityWindowInfo) this.f934a);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Rect rect = new Rect();
        a(rect);
        sb.append("AccessibilityWindowInfo[");
        sb.append("id=");
        sb.append(c());
        sb.append(", type=");
        sb.append(k(h()));
        sb.append(", layer=");
        sb.append(d());
        sb.append(", bounds=");
        sb.append(rect);
        sb.append(", focused=");
        sb.append(j());
        sb.append(", active=");
        sb.append(i());
        sb.append(", hasParent=");
        boolean z = false;
        sb.append(f() != null);
        sb.append(", hasChildren=");
        if (b() > 0) {
            z = true;
        }
        sb.append(z);
        sb.append(", transitionTime=");
        sb.append(g());
        sb.append(", locales=");
        sb.append(e());
        sb.append(']');
        return sb.toString();
    }
}
