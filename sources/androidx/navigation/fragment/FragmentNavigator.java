package androidx.navigation.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavDestination;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\b\b\u0017\u0018\u0000 .2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003/01B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ+\u0010\u0012\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ1\u0010\u001d\u001a\u00020\u00112\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0011\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016¢\u0006\u0004\b \u0010!J\u0017\u0010\"\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u001fH\u0016¢\u0006\u0004\b\"\u0010#R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010(R\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00020*0)8\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,¨\u00062"}, d2 = {"Landroidx/navigation/fragment/FragmentNavigator;", "Landroidx/navigation/Navigator;", "Landroidx/navigation/fragment/FragmentNavigator$Destination;", "Landroid/content/Context;", "context", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", "containerId", "<init>", "(Landroid/content/Context;Landroidx/fragment/app/FragmentManager;I)V", "Landroidx/navigation/NavBackStackEntry;", "entry", "Landroidx/navigation/NavOptions;", "navOptions", "Landroidx/navigation/Navigator$Extras;", "navigatorExtras", "", "m", "(Landroidx/navigation/NavBackStackEntry;Landroidx/navigation/NavOptions;Landroidx/navigation/Navigator$Extras;)V", "popUpTo", "", "savedState", "j", "(Landroidx/navigation/NavBackStackEntry;Z)V", "l", "()Landroidx/navigation/fragment/FragmentNavigator$Destination;", "", "entries", "e", "(Ljava/util/List;Landroidx/navigation/NavOptions;Landroidx/navigation/Navigator$Extras;)V", "Landroid/os/Bundle;", "i", "()Landroid/os/Bundle;", "h", "(Landroid/os/Bundle;)V", "c", "Landroid/content/Context;", "d", "Landroidx/fragment/app/FragmentManager;", "I", "", "", "f", "Ljava/util/Set;", "savedIds", "g", "Companion", "Destination", "Extras", "navigation-fragment_release"}, k = 1, mv = {1, 6, 0})
@Navigator.Name("fragment")
public class FragmentNavigator extends Navigator<Destination> {
    public static final Companion g = new Companion((DefaultConstructorMarker) null);
    public final Context c;
    public final FragmentManager d;
    public final int e;
    public final Set f = new LinkedHashSet();

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Landroidx/navigation/fragment/FragmentNavigator$Companion;", "", "()V", "KEY_SAVED_IDS", "", "TAG", "navigation-fragment_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0017\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00000\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0017¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0011\u0010\u000e\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0012¨\u0006\u001f"}, d2 = {"Landroidx/navigation/fragment/FragmentNavigator$Destination;", "Landroidx/navigation/NavDestination;", "Landroidx/navigation/Navigator;", "fragmentNavigator", "<init>", "(Landroidx/navigation/Navigator;)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "q", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "className", "y", "(Ljava/lang/String;)Landroidx/navigation/fragment/FragmentNavigator$Destination;", "toString", "()Ljava/lang/String;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "l", "Ljava/lang/String;", "_className", "x", "navigation-fragment_release"}, k = 1, mv = {1, 6, 0})
    @NavDestination.ClassType
    public static class Destination extends NavDestination {
        public String l;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Destination(Navigator navigator) {
            super(navigator);
            Intrinsics.checkNotNullParameter(navigator, "fragmentNavigator");
        }

        public boolean equals(Object obj) {
            return obj != null && (obj instanceof Destination) && super.equals(obj) && Intrinsics.areEqual((Object) this.l, (Object) ((Destination) obj).l);
        }

        public int hashCode() {
            int hashCode = super.hashCode() * 31;
            String str = this.l;
            return hashCode + (str == null ? 0 : str.hashCode());
        }

        public void q(Context context, AttributeSet attributeSet) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(attributeSet, "attrs");
            super.q(context, attributeSet);
            TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, R.styleable.FragmentNavigator);
            Intrinsics.checkNotNullExpressionValue(obtainAttributes, "context.resources.obtain…leable.FragmentNavigator)");
            String string = obtainAttributes.getString(R.styleable.FragmentNavigator_android_name);
            if (string != null) {
                y(string);
            }
            Unit unit = Unit.INSTANCE;
            obtainAttributes.recycle();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(super.toString());
            sb.append(" class=");
            String str = this.l;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "sb.toString()");
            return sb2;
        }

        public final String x() {
            String str = this.l;
            if (str == null) {
                throw new IllegalStateException("Fragment class was not set".toString());
            } else if (str != null) {
                return str;
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
        }

        public final Destination y(String str) {
            Intrinsics.checkNotNullParameter(str, "className");
            this.l = str;
            return this;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\fR0\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u001d\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\t8F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\n¨\u0006\r"}, d2 = {"Landroidx/navigation/fragment/FragmentNavigator$Extras;", "Landroidx/navigation/Navigator$Extras;", "Ljava/util/LinkedHashMap;", "Landroid/view/View;", "", "Lkotlin/collections/LinkedHashMap;", "a", "Ljava/util/LinkedHashMap;", "_sharedElements", "", "()Ljava/util/Map;", "sharedElements", "Builder", "navigation-fragment_release"}, k = 1, mv = {1, 6, 0})
    public static final class Extras implements Navigator.Extras {

        /* renamed from: a  reason: collision with root package name */
        public final LinkedHashMap f1501a;

        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Landroidx/navigation/fragment/FragmentNavigator$Extras$Builder;", "", "navigation-fragment_release"}, k = 1, mv = {1, 6, 0})
        public static final class Builder {
        }

        public final Map a() {
            return MapsKt.toMap(this.f1501a);
        }
    }

    public FragmentNavigator(Context context, FragmentManager fragmentManager, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        this.c = context;
        this.d = fragmentManager;
        this.e = i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:56:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x013e  */
    /* JADX WARNING: Removed duplicated region for block: B:65:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m(androidx.navigation.NavBackStackEntry r12, androidx.navigation.NavOptions r13, androidx.navigation.Navigator.Extras r14) {
        /*
            r11 = this;
            androidx.navigation.NavigatorState r0 = r11.b()
            kotlinx.coroutines.flow.StateFlow r0 = r0.b()
            java.lang.Object r0 = r0.getValue()
            java.util.List r0 = (java.util.List) r0
            boolean r1 = r0.isEmpty()
            if (r13 == 0) goto L_0x0039
            if (r1 != 0) goto L_0x0039
            boolean r2 = r13.i()
            if (r2 == 0) goto L_0x0039
            java.util.Set r2 = r11.f
            java.lang.String r3 = r12.g()
            boolean r2 = r2.remove(r3)
            if (r2 == 0) goto L_0x0039
            androidx.fragment.app.FragmentManager r13 = r11.d
            java.lang.String r14 = r12.g()
            r13.E1(r14)
            androidx.navigation.NavigatorState r11 = r11.b()
            r11.h(r12)
            return
        L_0x0039:
            androidx.navigation.NavDestination r2 = r12.f()
            androidx.navigation.fragment.FragmentNavigator$Destination r2 = (androidx.navigation.fragment.FragmentNavigator.Destination) r2
            android.os.Bundle r3 = r12.d()
            java.lang.String r4 = r2.x()
            r5 = 0
            char r6 = r4.charAt(r5)
            r7 = 46
            if (r6 != r7) goto L_0x005a
            android.content.Context r6 = r11.c
            java.lang.String r6 = r6.getPackageName()
            java.lang.String r4 = kotlin.jvm.internal.Intrinsics.stringPlus(r6, r4)
        L_0x005a:
            androidx.fragment.app.FragmentManager r6 = r11.d
            androidx.fragment.app.FragmentFactory r6 = r6.D0()
            android.content.Context r7 = r11.c
            java.lang.ClassLoader r7 = r7.getClassLoader()
            androidx.fragment.app.Fragment r4 = r6.a(r7, r4)
            java.lang.String r6 = "fragmentManager.fragment…t.classLoader, className)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r6)
            r4.setArguments(r3)
            androidx.fragment.app.FragmentManager r3 = r11.d
            androidx.fragment.app.FragmentTransaction r3 = r3.s()
            java.lang.String r6 = "fragmentManager.beginTransaction()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r6)
            r6 = -1
            if (r13 != 0) goto L_0x0082
            r7 = r6
            goto L_0x0086
        L_0x0082:
            int r7 = r13.a()
        L_0x0086:
            if (r13 != 0) goto L_0x008a
            r8 = r6
            goto L_0x008e
        L_0x008a:
            int r8 = r13.b()
        L_0x008e:
            if (r13 != 0) goto L_0x0092
            r9 = r6
            goto L_0x0096
        L_0x0092:
            int r9 = r13.c()
        L_0x0096:
            if (r13 != 0) goto L_0x009a
            r10 = r6
            goto L_0x009e
        L_0x009a:
            int r10 = r13.d()
        L_0x009e:
            if (r7 != r6) goto L_0x00a6
            if (r8 != r6) goto L_0x00a6
            if (r9 != r6) goto L_0x00a6
            if (r10 == r6) goto L_0x00b9
        L_0x00a6:
            if (r7 == r6) goto L_0x00a9
            goto L_0x00aa
        L_0x00a9:
            r7 = r5
        L_0x00aa:
            if (r8 == r6) goto L_0x00ad
            goto L_0x00ae
        L_0x00ad:
            r8 = r5
        L_0x00ae:
            if (r9 == r6) goto L_0x00b1
            goto L_0x00b2
        L_0x00b1:
            r9 = r5
        L_0x00b2:
            if (r10 == r6) goto L_0x00b5
            goto L_0x00b6
        L_0x00b5:
            r10 = r5
        L_0x00b6:
            r3.w(r7, r8, r9, r10)
        L_0x00b9:
            int r6 = r11.e
            r3.t(r6, r4)
            r3.y(r4)
            int r2 = r2.k()
            r4 = 1
            if (r13 == 0) goto L_0x00e2
            if (r1 != 0) goto L_0x00e2
            boolean r13 = r13.g()
            if (r13 == 0) goto L_0x00e2
            java.lang.Object r13 = kotlin.collections.CollectionsKt.last(r0)
            androidx.navigation.NavBackStackEntry r13 = (androidx.navigation.NavBackStackEntry) r13
            androidx.navigation.NavDestination r13 = r13.f()
            int r13 = r13.k()
            if (r13 != r2) goto L_0x00e2
            r13 = r4
            goto L_0x00e3
        L_0x00e2:
            r13 = r5
        L_0x00e3:
            if (r1 == 0) goto L_0x00e7
        L_0x00e5:
            r5 = r4
            goto L_0x0108
        L_0x00e7:
            if (r13 == 0) goto L_0x0100
            int r13 = r0.size()
            if (r13 <= r4) goto L_0x0108
            androidx.fragment.app.FragmentManager r13 = r11.d
            java.lang.String r0 = r12.g()
            r13.r1(r0, r4)
            java.lang.String r13 = r12.g()
            r3.h(r13)
            goto L_0x0108
        L_0x0100:
            java.lang.String r13 = r12.g()
            r3.h(r13)
            goto L_0x00e5
        L_0x0108:
            boolean r13 = r14 instanceof androidx.navigation.fragment.FragmentNavigator.Extras
            if (r13 == 0) goto L_0x0136
            androidx.navigation.fragment.FragmentNavigator$Extras r14 = (androidx.navigation.fragment.FragmentNavigator.Extras) r14
            java.util.Map r13 = r14.a()
            java.util.Set r13 = r13.entrySet()
            java.util.Iterator r13 = r13.iterator()
        L_0x011a:
            boolean r14 = r13.hasNext()
            if (r14 == 0) goto L_0x0136
            java.lang.Object r14 = r13.next()
            java.util.Map$Entry r14 = (java.util.Map.Entry) r14
            java.lang.Object r0 = r14.getKey()
            android.view.View r0 = (android.view.View) r0
            java.lang.Object r14 = r14.getValue()
            java.lang.String r14 = (java.lang.String) r14
            r3.g(r0, r14)
            goto L_0x011a
        L_0x0136:
            r3.z(r4)
            r3.j()
            if (r5 == 0) goto L_0x0145
            androidx.navigation.NavigatorState r11 = r11.b()
            r11.h(r12)
        L_0x0145:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.fragment.FragmentNavigator.m(androidx.navigation.NavBackStackEntry, androidx.navigation.NavOptions, androidx.navigation.Navigator$Extras):void");
    }

    public void e(List list, NavOptions navOptions, Navigator.Extras extras) {
        Intrinsics.checkNotNullParameter(list, "entries");
        if (this.d.a1()) {
            Log.i("FragmentNavigator", "Ignoring navigate() call: FragmentManager has already saved its state");
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            m((NavBackStackEntry) it.next(), navOptions, extras);
        }
    }

    public void h(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "savedState");
        ArrayList<String> stringArrayList = bundle.getStringArrayList("androidx-nav-fragment:navigator:savedIds");
        if (stringArrayList != null) {
            this.f.clear();
            CollectionsKt.addAll(this.f, stringArrayList);
        }
    }

    public Bundle i() {
        if (this.f.isEmpty()) {
            return null;
        }
        return BundleKt.a(TuplesKt.to("androidx-nav-fragment:navigator:savedIds", new ArrayList(this.f)));
    }

    public void j(NavBackStackEntry navBackStackEntry, boolean z) {
        Intrinsics.checkNotNullParameter(navBackStackEntry, "popUpTo");
        if (this.d.a1()) {
            Log.i("FragmentNavigator", "Ignoring popBackStack() call: FragmentManager has already saved its state");
            return;
        }
        if (z) {
            List list = (List) b().b().getValue();
            NavBackStackEntry navBackStackEntry2 = (NavBackStackEntry) CollectionsKt.first(list);
            for (NavBackStackEntry navBackStackEntry3 : CollectionsKt.reversed(list.subList(list.indexOf(navBackStackEntry), list.size()))) {
                if (Intrinsics.areEqual((Object) navBackStackEntry3, (Object) navBackStackEntry2)) {
                    Log.i("FragmentNavigator", Intrinsics.stringPlus("FragmentManager cannot save the state of the initial destination ", navBackStackEntry3));
                } else {
                    this.d.J1(navBackStackEntry3.g());
                    this.f.add(navBackStackEntry3.g());
                }
            }
        } else {
            this.d.r1(navBackStackEntry.g(), 1);
        }
        b().g(navBackStackEntry, z);
    }

    /* renamed from: l */
    public Destination a() {
        return new Destination(this);
    }
}
