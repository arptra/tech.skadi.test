package androidx.core.view.accessibility;

import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import com.here.posclient.PositionEstimate;
import com.upuphone.runasone.uupcast.CaptureType;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AccessibilityNodeInfoCompat {

    /* renamed from: a  reason: collision with root package name */
    public final AccessibilityNodeInfo f925a;
    public int b = -1;
    public int c = -1;

    public static class AccessibilityActionCompat {
        public static final AccessibilityActionCompat A = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN, 16908342, (CharSequence) null, (AccessibilityViewCommand) null, (Class) null);
        public static final AccessibilityActionCompat B = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION, 16908343, (CharSequence) null, (AccessibilityViewCommand) null, AccessibilityViewCommand.ScrollToPositionArguments.class);
        public static final AccessibilityActionCompat C = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP, 16908344, (CharSequence) null, (AccessibilityViewCommand) null, (Class) null);
        public static final AccessibilityActionCompat D = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT, 16908345, (CharSequence) null, (AccessibilityViewCommand) null, (Class) null);
        public static final AccessibilityActionCompat E = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN, 16908346, (CharSequence) null, (AccessibilityViewCommand) null, (Class) null);
        public static final AccessibilityActionCompat F = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT, 16908347, (CharSequence) null, (AccessibilityViewCommand) null, (Class) null);
        public static final AccessibilityActionCompat G = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP, 16908358, (CharSequence) null, (AccessibilityViewCommand) null, (Class) null);
        public static final AccessibilityActionCompat H = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN, 16908359, (CharSequence) null, (AccessibilityViewCommand) null, (Class) null);
        public static final AccessibilityActionCompat I = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT, 16908360, (CharSequence) null, (AccessibilityViewCommand) null, (Class) null);
        public static final AccessibilityActionCompat J = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT, 16908361, (CharSequence) null, (AccessibilityViewCommand) null, (Class) null);
        public static final AccessibilityActionCompat K = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK, 16908348, (CharSequence) null, (AccessibilityViewCommand) null, (Class) null);
        public static final AccessibilityActionCompat L = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS, 16908349, (CharSequence) null, (AccessibilityViewCommand) null, AccessibilityViewCommand.SetProgressArguments.class);
        public static final AccessibilityActionCompat M = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW, 16908354, (CharSequence) null, (AccessibilityViewCommand) null, AccessibilityViewCommand.MoveWindowArguments.class);
        public static final AccessibilityActionCompat N = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP, 16908356, (CharSequence) null, (AccessibilityViewCommand) null, (Class) null);
        public static final AccessibilityActionCompat O = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP, 16908357, (CharSequence) null, (AccessibilityViewCommand) null, (Class) null);
        public static final AccessibilityActionCompat P;
        public static final AccessibilityActionCompat Q;
        public static final AccessibilityActionCompat R;
        public static final AccessibilityActionCompat S;
        public static final AccessibilityActionCompat T;
        public static final AccessibilityActionCompat U;
        public static final AccessibilityActionCompat V;
        public static final AccessibilityActionCompat e = new AccessibilityActionCompat(1, (CharSequence) null);
        public static final AccessibilityActionCompat f = new AccessibilityActionCompat(2, (CharSequence) null);
        public static final AccessibilityActionCompat g = new AccessibilityActionCompat(4, (CharSequence) null);
        public static final AccessibilityActionCompat h = new AccessibilityActionCompat(8, (CharSequence) null);
        public static final AccessibilityActionCompat i = new AccessibilityActionCompat(16, (CharSequence) null);
        public static final AccessibilityActionCompat j = new AccessibilityActionCompat(32, (CharSequence) null);
        public static final AccessibilityActionCompat k = new AccessibilityActionCompat(64, (CharSequence) null);
        public static final AccessibilityActionCompat l = new AccessibilityActionCompat(128, (CharSequence) null);
        public static final AccessibilityActionCompat m;
        public static final AccessibilityActionCompat n;
        public static final AccessibilityActionCompat o;
        public static final AccessibilityActionCompat p;
        public static final AccessibilityActionCompat q = new AccessibilityActionCompat(4096, (CharSequence) null);
        public static final AccessibilityActionCompat r = new AccessibilityActionCompat(8192, (CharSequence) null);
        public static final AccessibilityActionCompat s = new AccessibilityActionCompat(16384, (CharSequence) null);
        public static final AccessibilityActionCompat t = new AccessibilityActionCompat(32768, (CharSequence) null);
        public static final AccessibilityActionCompat u = new AccessibilityActionCompat(65536, (CharSequence) null);
        public static final AccessibilityActionCompat v = new AccessibilityActionCompat(131072, (CharSequence) null, AccessibilityViewCommand.SetSelectionArguments.class);
        public static final AccessibilityActionCompat w = new AccessibilityActionCompat(PositionEstimate.Value.BUILDING_NAME, (CharSequence) null);
        public static final AccessibilityActionCompat x = new AccessibilityActionCompat(PositionEstimate.Value.TIME_SINCE_BOOT, (CharSequence) null);
        public static final AccessibilityActionCompat y = new AccessibilityActionCompat(PositionEstimate.Value.SITUATION, (CharSequence) null);
        public static final AccessibilityActionCompat z = new AccessibilityActionCompat((int) PositionEstimate.Value.WLAN_AP_COUNT, (CharSequence) null, AccessibilityViewCommand.SetTextArguments.class);

        /* renamed from: a  reason: collision with root package name */
        public final Object f926a;
        public final int b;
        public final Class c;
        public final AccessibilityViewCommand d;

        static {
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction = null;
            Class<AccessibilityViewCommand.MoveAtGranularityArguments> cls = AccessibilityViewCommand.MoveAtGranularityArguments.class;
            m = new AccessibilityActionCompat(256, (CharSequence) null, (Class) cls);
            n = new AccessibilityActionCompat(512, (CharSequence) null, (Class) cls);
            Class<AccessibilityViewCommand.MoveHtmlArguments> cls2 = AccessibilityViewCommand.MoveHtmlArguments.class;
            o = new AccessibilityActionCompat(1024, (CharSequence) null, (Class) cls2);
            p = new AccessibilityActionCompat(2048, (CharSequence) null, (Class) cls2);
            int i2 = Build.VERSION.SDK_INT;
            P = new AccessibilityActionCompat(i2 >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD : null, 16908362, (CharSequence) null, (AccessibilityViewCommand) null, (Class) null);
            Q = new AccessibilityActionCompat(i2 >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER : null, 16908372, (CharSequence) null, (AccessibilityViewCommand) null, (Class) null);
            R = new AccessibilityActionCompat(i2 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_START : null, 16908373, (CharSequence) null, (AccessibilityViewCommand) null, (Class) null);
            S = new AccessibilityActionCompat(i2 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_DROP : null, 16908374, (CharSequence) null, (AccessibilityViewCommand) null, (Class) null);
            T = new AccessibilityActionCompat(i2 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_CANCEL : null, 16908375, (CharSequence) null, (AccessibilityViewCommand) null, (Class) null);
            U = new AccessibilityActionCompat(i2 >= 33 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TEXT_SUGGESTIONS : null, 16908376, (CharSequence) null, (AccessibilityViewCommand) null, (Class) null);
            if (i2 >= 34) {
                accessibilityAction = Api34Impl.a();
            }
            V = new AccessibilityActionCompat(accessibilityAction, 16908382, (CharSequence) null, (AccessibilityViewCommand) null, (Class) null);
        }

        public AccessibilityActionCompat(int i2, CharSequence charSequence) {
            this((Object) null, i2, charSequence, (AccessibilityViewCommand) null, (Class) null);
        }

        public AccessibilityActionCompat a(CharSequence charSequence, AccessibilityViewCommand accessibilityViewCommand) {
            return new AccessibilityActionCompat((Object) null, this.b, charSequence, accessibilityViewCommand, this.c);
        }

        public int b() {
            return ((AccessibilityNodeInfo.AccessibilityAction) this.f926a).getId();
        }

        public CharSequence c() {
            return ((AccessibilityNodeInfo.AccessibilityAction) this.f926a).getLabel();
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x0020  */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x0023  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean d(android.view.View r5, android.os.Bundle r6) {
            /*
                r4 = this;
                androidx.core.view.accessibility.AccessibilityViewCommand r0 = r4.d
                if (r0 == 0) goto L_0x0044
                java.lang.Class r0 = r4.c
                r1 = 0
                if (r0 == 0) goto L_0x003d
                java.lang.reflect.Constructor r0 = r0.getDeclaredConstructor(r1)     // Catch:{ Exception -> 0x001b }
                java.lang.Object r0 = r0.newInstance(r1)     // Catch:{ Exception -> 0x001b }
                androidx.core.view.accessibility.AccessibilityViewCommand$CommandArguments r0 = (androidx.core.view.accessibility.AccessibilityViewCommand.CommandArguments) r0     // Catch:{ Exception -> 0x001b }
                r0.a(r6)     // Catch:{ Exception -> 0x0018 }
                r1 = r0
                goto L_0x003d
            L_0x0018:
                r6 = move-exception
                r1 = r0
                goto L_0x001c
            L_0x001b:
                r6 = move-exception
            L_0x001c:
                java.lang.Class r0 = r4.c
                if (r0 != 0) goto L_0x0023
                java.lang.String r0 = "null"
                goto L_0x0027
            L_0x0023:
                java.lang.String r0 = r0.getName()
            L_0x0027:
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "Failed to execute command with argument class ViewCommandArgument: "
                r2.append(r3)
                r2.append(r0)
                java.lang.String r0 = r2.toString()
                java.lang.String r2 = "A11yActionCompat"
                android.util.Log.e(r2, r0, r6)
            L_0x003d:
                androidx.core.view.accessibility.AccessibilityViewCommand r4 = r4.d
                boolean r4 = r4.perform(r5, r1)
                return r4
            L_0x0044:
                r4 = 0
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat.d(android.view.View, android.os.Bundle):boolean");
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof AccessibilityActionCompat)) {
                return false;
            }
            AccessibilityActionCompat accessibilityActionCompat = (AccessibilityActionCompat) obj;
            Object obj2 = this.f926a;
            return obj2 == null ? accessibilityActionCompat.f926a == null : obj2.equals(accessibilityActionCompat.f926a);
        }

        public int hashCode() {
            Object obj = this.f926a;
            if (obj != null) {
                return obj.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("AccessibilityActionCompat: ");
            String h2 = AccessibilityNodeInfoCompat.h(this.b);
            if (h2.equals("ACTION_UNKNOWN") && c() != null) {
                h2 = c().toString();
            }
            sb.append(h2);
            return sb.toString();
        }

        public AccessibilityActionCompat(int i2, CharSequence charSequence, AccessibilityViewCommand accessibilityViewCommand) {
            this((Object) null, i2, charSequence, accessibilityViewCommand, (Class) null);
        }

        public AccessibilityActionCompat(Object obj) {
            this(obj, 0, (CharSequence) null, (AccessibilityViewCommand) null, (Class) null);
        }

        public AccessibilityActionCompat(int i2, CharSequence charSequence, Class cls) {
            this((Object) null, i2, charSequence, (AccessibilityViewCommand) null, cls);
        }

        public AccessibilityActionCompat(Object obj, int i2, CharSequence charSequence, AccessibilityViewCommand accessibilityViewCommand, Class cls) {
            this.b = i2;
            this.d = accessibilityViewCommand;
            if (obj == null) {
                this.f926a = new AccessibilityNodeInfo.AccessibilityAction(i2, charSequence);
            } else {
                this.f926a = obj;
            }
            this.c = cls;
        }
    }

    @RequiresApi
    public static class Api21Impl {
        @DoNotInline
        public static CollectionItemInfoCompat a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            return new CollectionItemInfoCompat(AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i2, i3, i4, z, z2));
        }
    }

    @RequiresApi
    public static class Api30Impl {
        @DoNotInline
        public static Object a(int i, float f, float f2, float f3) {
            return new AccessibilityNodeInfo.RangeInfo(i, f, f2, f3);
        }

        @DoNotInline
        public static CharSequence b(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getStateDescription();
        }

        @DoNotInline
        public static void c(AccessibilityNodeInfo accessibilityNodeInfo, CharSequence charSequence) {
            accessibilityNodeInfo.setStateDescription(charSequence);
        }
    }

    @RequiresApi
    public static class Api33Impl {
        @DoNotInline
        public static CollectionItemInfoCompat a(boolean z, int i, int i2, int i3, int i4, boolean z2, String str, String str2) {
            return new CollectionItemInfoCompat(new AccessibilityNodeInfo.CollectionItemInfo.Builder().setHeading(z).setColumnIndex(i).setRowIndex(i2).setColumnSpan(i3).setRowSpan(i4).setSelected(z2).setRowTitle(str).setColumnTitle(str2).build());
        }

        @DoNotInline
        public static AccessibilityNodeInfoCompat b(AccessibilityNodeInfo accessibilityNodeInfo, int i, int i2) {
            return AccessibilityNodeInfoCompat.Q0(accessibilityNodeInfo.getChild(i, i2));
        }

        @DoNotInline
        public static String c(Object obj) {
            return ((AccessibilityNodeInfo.CollectionItemInfo) obj).getColumnTitle();
        }

        @DoNotInline
        public static String d(Object obj) {
            return ((AccessibilityNodeInfo.CollectionItemInfo) obj).getRowTitle();
        }

        @DoNotInline
        public static AccessibilityNodeInfo.ExtraRenderingInfo e(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getExtraRenderingInfo();
        }

        @DoNotInline
        public static AccessibilityNodeInfoCompat f(AccessibilityNodeInfo accessibilityNodeInfo, int i) {
            return AccessibilityNodeInfoCompat.Q0(accessibilityNodeInfo.getParent(i));
        }

        @DoNotInline
        public static String g(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getUniqueId();
        }

        @DoNotInline
        public static boolean h(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.isTextSelectable();
        }

        @DoNotInline
        public static void i(AccessibilityNodeInfo accessibilityNodeInfo, boolean z) {
            accessibilityNodeInfo.setTextSelectable(z);
        }

        @DoNotInline
        public static void j(AccessibilityNodeInfo accessibilityNodeInfo, String str) {
            accessibilityNodeInfo.setUniqueId(str);
        }
    }

    @RequiresApi
    public static class Api34Impl {
        @DoNotInline
        public static AccessibilityNodeInfo.AccessibilityAction a() {
            return AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_IN_DIRECTION;
        }

        @DoNotInline
        public static void b(AccessibilityNodeInfo accessibilityNodeInfo, Rect rect) {
            accessibilityNodeInfo.getBoundsInWindow(rect);
        }

        @DoNotInline
        public static CharSequence c(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getContainerTitle();
        }

        @DoNotInline
        public static long d(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getMinDurationBetweenContentChanges().toMillis();
        }

        @DoNotInline
        public static boolean e(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.hasRequestInitialAccessibilityFocus();
        }

        @DoNotInline
        public static boolean f(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.isAccessibilityDataSensitive();
        }

        @DoNotInline
        public static void g(AccessibilityNodeInfo accessibilityNodeInfo, boolean z) {
            accessibilityNodeInfo.setAccessibilityDataSensitive(z);
        }

        @DoNotInline
        public static void h(AccessibilityNodeInfo accessibilityNodeInfo, Rect rect) {
            accessibilityNodeInfo.setBoundsInWindow(rect);
        }

        @DoNotInline
        public static void i(AccessibilityNodeInfo accessibilityNodeInfo, CharSequence charSequence) {
            accessibilityNodeInfo.setContainerTitle(charSequence);
        }

        @DoNotInline
        public static void j(AccessibilityNodeInfo accessibilityNodeInfo, long j) {
            accessibilityNodeInfo.setMinDurationBetweenContentChanges(Duration.ofMillis(j));
        }

        @DoNotInline
        public static void k(AccessibilityNodeInfo accessibilityNodeInfo, View view, boolean z) {
            accessibilityNodeInfo.setQueryFromAppProcessEnabled(view, z);
        }

        @DoNotInline
        public static void l(AccessibilityNodeInfo accessibilityNodeInfo, boolean z) {
            accessibilityNodeInfo.setRequestInitialAccessibilityFocus(z);
        }
    }

    public static class CollectionInfoCompat {

        /* renamed from: a  reason: collision with root package name */
        public final Object f927a;

        public CollectionInfoCompat(Object obj) {
            this.f927a = obj;
        }

        public static CollectionInfoCompat a(int i, int i2, boolean z) {
            return new CollectionInfoCompat(AccessibilityNodeInfo.CollectionInfo.obtain(i, i2, z));
        }

        public static CollectionInfoCompat b(int i, int i2, boolean z, int i3) {
            return new CollectionInfoCompat(AccessibilityNodeInfo.CollectionInfo.obtain(i, i2, z, i3));
        }
    }

    public static class CollectionItemInfoCompat {

        /* renamed from: a  reason: collision with root package name */
        public final Object f928a;

        public static final class Builder {
        }

        public CollectionItemInfoCompat(Object obj) {
            this.f928a = obj;
        }

        public static CollectionItemInfoCompat a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            return new CollectionItemInfoCompat(AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i2, i3, i4, z, z2));
        }
    }

    public static class RangeInfoCompat {

        /* renamed from: a  reason: collision with root package name */
        public final Object f929a;

        public RangeInfoCompat(Object obj) {
            this.f929a = obj;
        }

        public static RangeInfoCompat a(int i, float f, float f2, float f3) {
            return new RangeInfoCompat(AccessibilityNodeInfo.RangeInfo.obtain(i, f, f2, f3));
        }
    }

    public static final class TouchDelegateInfoCompat {
    }

    public AccessibilityNodeInfoCompat(Object obj) {
        this.f925a = (AccessibilityNodeInfo) obj;
    }

    public static AccessibilityNodeInfoCompat P0(AccessibilityNodeInfo accessibilityNodeInfo) {
        return new AccessibilityNodeInfoCompat(accessibilityNodeInfo);
    }

    public static AccessibilityNodeInfoCompat Q0(Object obj) {
        if (obj != null) {
            return new AccessibilityNodeInfoCompat(obj);
        }
        return null;
    }

    public static AccessibilityNodeInfoCompat V() {
        return P0(AccessibilityNodeInfo.obtain());
    }

    public static AccessibilityNodeInfoCompat W(View view) {
        return P0(AccessibilityNodeInfo.obtain(view));
    }

    public static AccessibilityNodeInfoCompat X(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        return P0(AccessibilityNodeInfo.obtain(accessibilityNodeInfoCompat.f925a));
    }

    public static String h(int i) {
        if (i == 1) {
            return "ACTION_FOCUS";
        }
        if (i == 2) {
            return "ACTION_CLEAR_FOCUS";
        }
        switch (i) {
            case 4:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case 16:
                return "ACTION_CLICK";
            case 32:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case 128:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case 256:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case 4096:
                return "ACTION_SCROLL_FORWARD";
            case 8192:
                return "ACTION_SCROLL_BACKWARD";
            case 16384:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case 65536:
                return "ACTION_CUT";
            case 131072:
                return "ACTION_SET_SELECTION";
            case PositionEstimate.Value.BUILDING_NAME /*262144*/:
                return "ACTION_EXPAND";
            case PositionEstimate.Value.TIME_SINCE_BOOT /*524288*/:
                return "ACTION_COLLAPSE";
            case PositionEstimate.Value.WLAN_AP_COUNT /*2097152*/:
                return "ACTION_SET_TEXT";
            case 16908354:
                return "ACTION_MOVE_WINDOW";
            case 16908382:
                return "ACTION_SCROLL_IN_DIRECTION";
            default:
                switch (i) {
                    case 16908342:
                        return "ACTION_SHOW_ON_SCREEN";
                    case 16908343:
                        return "ACTION_SCROLL_TO_POSITION";
                    case 16908344:
                        return "ACTION_SCROLL_UP";
                    case 16908345:
                        return "ACTION_SCROLL_LEFT";
                    case 16908346:
                        return "ACTION_SCROLL_DOWN";
                    case 16908347:
                        return "ACTION_SCROLL_RIGHT";
                    case 16908348:
                        return "ACTION_CONTEXT_CLICK";
                    case 16908349:
                        return "ACTION_SET_PROGRESS";
                    default:
                        switch (i) {
                            case 16908356:
                                return "ACTION_SHOW_TOOLTIP";
                            case 16908357:
                                return "ACTION_HIDE_TOOLTIP";
                            case 16908358:
                                return "ACTION_PAGE_UP";
                            case 16908359:
                                return "ACTION_PAGE_DOWN";
                            case 16908360:
                                return "ACTION_PAGE_LEFT";
                            case 16908361:
                                return "ACTION_PAGE_RIGHT";
                            case 16908362:
                                return "ACTION_PRESS_AND_HOLD";
                            default:
                                switch (i) {
                                    case 16908372:
                                        return "ACTION_IME_ENTER";
                                    case 16908373:
                                        return "ACTION_DRAG_START";
                                    case 16908374:
                                        return "ACTION_DRAG_DROP";
                                    case 16908375:
                                        return "ACTION_DRAG_CANCEL";
                                    default:
                                        return "ACTION_UNKNOWN";
                                }
                        }
                }
        }
    }

    public static ClickableSpan[] p(CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            return (ClickableSpan[]) ((Spanned) charSequence).getSpans(0, charSequence.length(), ClickableSpan.class);
        }
        return null;
    }

    public String A() {
        return Build.VERSION.SDK_INT >= 33 ? Api33Impl.g(this.f925a) : this.f925a.getExtras().getString("androidx.view.accessibility.AccessibilityNodeInfoCompat.UNIQUE_ID_KEY");
    }

    public void A0(View view) {
        this.b = -1;
        this.f925a.setParent(view);
    }

    public String B() {
        return this.f925a.getViewIdResourceName();
    }

    public void B0(View view, int i) {
        this.b = i;
        this.f925a.setParent(view, i);
    }

    public final boolean C() {
        return !f("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").isEmpty();
    }

    public void C0(RangeInfoCompat rangeInfoCompat) {
        this.f925a.setRangeInfo((AccessibilityNodeInfo.RangeInfo) rangeInfoCompat.f929a);
    }

    public boolean D() {
        return Build.VERSION.SDK_INT >= 34 ? Api34Impl.f(this.f925a) : j(64);
    }

    public void D0(CharSequence charSequence) {
        this.f925a.getExtras().putCharSequence("AccessibilityNodeInfo.roleDescription", charSequence);
    }

    public boolean E() {
        return this.f925a.isAccessibilityFocused();
    }

    public void E0(boolean z) {
        this.f925a.setScreenReaderFocusable(z);
    }

    public boolean F() {
        return this.f925a.isCheckable();
    }

    public void F0(boolean z) {
        this.f925a.setScrollable(z);
    }

    public boolean G() {
        return this.f925a.isChecked();
    }

    public void G0(boolean z) {
        this.f925a.setSelected(z);
    }

    public boolean H() {
        return this.f925a.isClickable();
    }

    public void H0(boolean z) {
        this.f925a.setShowingHintText(z);
    }

    public boolean I() {
        return this.f925a.isContextClickable();
    }

    public void I0(View view) {
        this.c = -1;
        this.f925a.setSource(view);
    }

    public boolean J() {
        return this.f925a.isEnabled();
    }

    public void J0(View view, int i) {
        this.c = i;
        this.f925a.setSource(view, i);
    }

    public boolean K() {
        return this.f925a.isFocusable();
    }

    public void K0(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 30) {
            Api30Impl.c(this.f925a, charSequence);
        } else {
            this.f925a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY", charSequence);
        }
    }

    public boolean L() {
        return this.f925a.isFocused();
    }

    public void L0(CharSequence charSequence) {
        this.f925a.setText(charSequence);
    }

    public boolean M() {
        return j(CaptureType.CAPTURE_TYPE_ICCOA);
    }

    public void M0(View view) {
        this.f925a.setTraversalAfter(view);
    }

    public boolean N() {
        return this.f925a.isImportantForAccessibility();
    }

    public void N0(boolean z) {
        this.f925a.setVisibleToUser(z);
    }

    public boolean O() {
        return this.f925a.isLongClickable();
    }

    public AccessibilityNodeInfo O0() {
        return this.f925a;
    }

    public boolean P() {
        return this.f925a.isPassword();
    }

    public boolean Q() {
        return this.f925a.isScrollable();
    }

    public boolean R() {
        return this.f925a.isSelected();
    }

    public boolean S() {
        return this.f925a.isShowingHintText();
    }

    public boolean T() {
        return Build.VERSION.SDK_INT >= 33 ? Api33Impl.h(this.f925a) : j(PositionEstimate.Value.ACTIVITY);
    }

    public boolean U() {
        return this.f925a.isVisibleToUser();
    }

    public boolean Y(int i, Bundle bundle) {
        return this.f925a.performAction(i, bundle);
    }

    public void Z() {
    }

    public void a(int i) {
        this.f925a.addAction(i);
    }

    public boolean a0(AccessibilityActionCompat accessibilityActionCompat) {
        return this.f925a.removeAction((AccessibilityNodeInfo.AccessibilityAction) accessibilityActionCompat.f926a);
    }

    public void b(AccessibilityActionCompat accessibilityActionCompat) {
        this.f925a.addAction((AccessibilityNodeInfo.AccessibilityAction) accessibilityActionCompat.f926a);
    }

    public void b0(boolean z) {
        this.f925a.setAccessibilityFocused(z);
    }

    public void c(View view) {
        this.f925a.addChild(view);
    }

    public void c0(Rect rect) {
        this.f925a.setBoundsInParent(rect);
    }

    public void d(View view, int i) {
        this.f925a.addChild(view, i);
    }

    public void d0(Rect rect) {
        this.f925a.setBoundsInScreen(rect);
    }

    public void e(CharSequence charSequence, View view) {
    }

    public void e0(boolean z) {
        this.f925a.setCanOpenPopup(z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AccessibilityNodeInfoCompat)) {
            return false;
        }
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = (AccessibilityNodeInfoCompat) obj;
        AccessibilityNodeInfo accessibilityNodeInfo = this.f925a;
        if (accessibilityNodeInfo == null) {
            if (accessibilityNodeInfoCompat.f925a != null) {
                return false;
            }
        } else if (!accessibilityNodeInfo.equals(accessibilityNodeInfoCompat.f925a)) {
            return false;
        }
        return this.c == accessibilityNodeInfoCompat.c && this.b == accessibilityNodeInfoCompat.b;
    }

    public final List f(String str) {
        ArrayList<Integer> integerArrayList = this.f925a.getExtras().getIntegerArrayList(str);
        if (integerArrayList != null) {
            return integerArrayList;
        }
        ArrayList arrayList = new ArrayList();
        this.f925a.getExtras().putIntegerArrayList(str, arrayList);
        return arrayList;
    }

    public void f0(boolean z) {
        this.f925a.setCheckable(z);
    }

    public List g() {
        List<AccessibilityNodeInfo.AccessibilityAction> actionList = this.f925a.getActionList();
        if (actionList == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        int size = actionList.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(new AccessibilityActionCompat(actionList.get(i)));
        }
        return arrayList;
    }

    public void g0(boolean z) {
        this.f925a.setChecked(z);
    }

    public void h0(CharSequence charSequence) {
        this.f925a.setClassName(charSequence);
    }

    public int hashCode() {
        AccessibilityNodeInfo accessibilityNodeInfo = this.f925a;
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        return accessibilityNodeInfo.hashCode();
    }

    public int i() {
        return this.f925a.getActions();
    }

    public void i0(boolean z) {
        this.f925a.setClickable(z);
    }

    public final boolean j(int i) {
        Bundle t = t();
        return t != null && (t.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & i) == i;
    }

    public void j0(Object obj) {
        this.f925a.setCollectionInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionInfo) ((CollectionInfoCompat) obj).f927a);
    }

    public void k(Rect rect) {
        this.f925a.getBoundsInParent(rect);
    }

    public void k0(Object obj) {
        this.f925a.setCollectionItemInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionItemInfo) ((CollectionItemInfoCompat) obj).f928a);
    }

    public void l(Rect rect) {
        this.f925a.getBoundsInScreen(rect);
    }

    public void l0(CharSequence charSequence) {
        this.f925a.setContentDescription(charSequence);
    }

    public void m(Rect rect) {
        if (Build.VERSION.SDK_INT >= 34) {
            Api34Impl.b(this.f925a, rect);
            return;
        }
        Rect rect2 = (Rect) this.f925a.getExtras().getParcelable("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOUNDS_IN_WINDOW_KEY");
        if (rect2 != null) {
            rect.set(rect2.left, rect2.top, rect2.right, rect2.bottom);
        }
    }

    public void m0(boolean z) {
        this.f925a.setContentInvalid(z);
    }

    public int n() {
        return this.f925a.getChildCount();
    }

    public void n0(boolean z) {
        this.f925a.setDismissable(z);
    }

    public CharSequence o() {
        return this.f925a.getClassName();
    }

    public void o0(boolean z) {
        this.f925a.setEnabled(z);
    }

    public void p0(CharSequence charSequence) {
        this.f925a.setError(charSequence);
    }

    public CharSequence q() {
        return Build.VERSION.SDK_INT >= 34 ? Api34Impl.c(this.f925a) : this.f925a.getExtras().getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.CONTAINER_TITLE_KEY");
    }

    public void q0(boolean z) {
        this.f925a.setFocusable(z);
    }

    public CharSequence r() {
        return this.f925a.getContentDescription();
    }

    public void r0(boolean z) {
        this.f925a.setFocused(z);
    }

    public CharSequence s() {
        return this.f925a.getError();
    }

    public void s0(boolean z) {
        this.f925a.setHeading(z);
    }

    public Bundle t() {
        return this.f925a.getExtras();
    }

    public void t0(CharSequence charSequence) {
        this.f925a.setHintText(charSequence);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        Rect rect = new Rect();
        k(rect);
        sb.append("; boundsInParent: " + rect);
        l(rect);
        sb.append("; boundsInScreen: " + rect);
        m(rect);
        sb.append("; boundsInWindow: " + rect);
        sb.append("; packageName: ");
        sb.append(w());
        sb.append("; className: ");
        sb.append(o());
        sb.append("; text: ");
        sb.append(y());
        sb.append("; error: ");
        sb.append(s());
        sb.append("; maxTextLength: ");
        sb.append(u());
        sb.append("; stateDescription: ");
        sb.append(x());
        sb.append("; contentDescription: ");
        sb.append(r());
        sb.append("; tooltipText: ");
        sb.append(z());
        sb.append("; viewIdResName: ");
        sb.append(B());
        sb.append("; uniqueId: ");
        sb.append(A());
        sb.append("; checkable: ");
        sb.append(F());
        sb.append("; checked: ");
        sb.append(G());
        sb.append("; focusable: ");
        sb.append(K());
        sb.append("; focused: ");
        sb.append(L());
        sb.append("; selected: ");
        sb.append(R());
        sb.append("; clickable: ");
        sb.append(H());
        sb.append("; longClickable: ");
        sb.append(O());
        sb.append("; contextClickable: ");
        sb.append(I());
        sb.append("; enabled: ");
        sb.append(J());
        sb.append("; password: ");
        sb.append(P());
        sb.append("; scrollable: " + Q());
        sb.append("; containerTitle: ");
        sb.append(q());
        sb.append("; granularScrollingSupported: ");
        sb.append(M());
        sb.append("; importantForAccessibility: ");
        sb.append(N());
        sb.append("; visible: ");
        sb.append(U());
        sb.append("; isTextSelectable: ");
        sb.append(T());
        sb.append("; accessibilityDataSensitive: ");
        sb.append(D());
        sb.append("; [");
        List g = g();
        for (int i = 0; i < g.size(); i++) {
            AccessibilityActionCompat accessibilityActionCompat = (AccessibilityActionCompat) g.get(i);
            String h = h(accessibilityActionCompat.b());
            if (h.equals("ACTION_UNKNOWN") && accessibilityActionCompat.c() != null) {
                h = accessibilityActionCompat.c().toString();
            }
            sb.append(h);
            if (i != g.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public int u() {
        return this.f925a.getMaxTextLength();
    }

    public void u0(View view) {
        this.f925a.setLabelFor(view);
    }

    public int v() {
        return this.f925a.getMovementGranularities();
    }

    public void v0(boolean z) {
        this.f925a.setLongClickable(z);
    }

    public CharSequence w() {
        return this.f925a.getPackageName();
    }

    public void w0(int i) {
        this.f925a.setMaxTextLength(i);
    }

    public CharSequence x() {
        return Build.VERSION.SDK_INT >= 30 ? Api30Impl.b(this.f925a) : this.f925a.getExtras().getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY");
    }

    public void x0(int i) {
        this.f925a.setMovementGranularities(i);
    }

    public CharSequence y() {
        if (!C()) {
            return this.f925a.getText();
        }
        List f = f("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
        List f2 = f("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
        List f3 = f("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
        List f4 = f("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
        SpannableString spannableString = new SpannableString(TextUtils.substring(this.f925a.getText(), 0, this.f925a.getText().length()));
        for (int i = 0; i < f.size(); i++) {
            spannableString.setSpan(new AccessibilityClickableSpanCompat(((Integer) f4.get(i)).intValue(), this, t().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY")), ((Integer) f.get(i)).intValue(), ((Integer) f2.get(i)).intValue(), ((Integer) f3.get(i)).intValue());
        }
        return spannableString;
    }

    public void y0(CharSequence charSequence) {
        this.f925a.setPackageName(charSequence);
    }

    public CharSequence z() {
        return this.f925a.getTooltipText();
    }

    public void z0(CharSequence charSequence) {
        this.f925a.setPaneTitle(charSequence);
    }

    public AccessibilityNodeInfoCompat(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.f925a = accessibilityNodeInfo;
    }
}
