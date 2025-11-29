package androidx.navigation;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.collection.SparseArrayCompat;
import androidx.collection.SparseArrayKt;
import androidx.navigation.NavDestination;
import androidx.navigation.common.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010)\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001b\b\u0016\u0018\u0000 \u00112\u00020\u00012\b\u0012\u0004\u0012\u00020\u00010\u0002:\u0001IB\u0017\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00000\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0017¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00012\b\b\u0001\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u00012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ#\u0010 \u001a\u0004\u0018\u00010\u00012\b\b\u0001\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u001eH\u0007¢\u0006\u0004\b \u0010!J!\u0010\"\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u001eH\u0007¢\u0006\u0004\b\"\u0010#J\u0016\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00010$H\u0002¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\u001aH\u0016¢\u0006\u0004\b'\u0010(J\u001a\u0010+\u001a\u00020\u001e2\b\u0010*\u001a\u0004\u0018\u00010)H\u0002¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\u0016H\u0016¢\u0006\u0004\b-\u0010.R\u001d\u00104\u001a\b\u0012\u0004\u0012\u00020\u00010/8G¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u0016\u00107\u001a\u00020\u00168\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010:\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b8\u00109R.\u0010@\u001a\u0004\u0018\u00010\u001a2\b\u0010;\u001a\u0004\u0018\u00010\u001a8\u0006@BX\u000e¢\u0006\u0012\n\u0004\b<\u00109\u001a\u0004\b=\u0010(\"\u0004\b>\u0010?R\u0014\u0010B\u001a\u00020\u001a8WX\u0004¢\u0006\u0006\u001a\u0004\bA\u0010(R$\u0010F\u001a\u00020\u00162\u0006\u00107\u001a\u00020\u00168G@BX\u000e¢\u0006\f\u001a\u0004\bC\u0010.\"\u0004\bD\u0010ER\u0011\u0010H\u001a\u00020\u001a8G¢\u0006\u0006\u001a\u0004\bG\u0010(¨\u0006J"}, d2 = {"Landroidx/navigation/NavGraph;", "Landroidx/navigation/NavDestination;", "", "Landroidx/navigation/Navigator;", "navGraphNavigator", "<init>", "(Landroidx/navigation/Navigator;)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "q", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Landroidx/navigation/NavDeepLinkRequest;", "navDeepLinkRequest", "Landroidx/navigation/NavDestination$DeepLinkMatch;", "p", "(Landroidx/navigation/NavDeepLinkRequest;)Landroidx/navigation/NavDestination$DeepLinkMatch;", "node", "x", "(Landroidx/navigation/NavDestination;)V", "", "resId", "y", "(I)Landroidx/navigation/NavDestination;", "", "route", "A", "(Ljava/lang/String;)Landroidx/navigation/NavDestination;", "", "searchParents", "z", "(IZ)Landroidx/navigation/NavDestination;", "B", "(Ljava/lang/String;Z)Landroidx/navigation/NavDestination;", "", "iterator", "()Ljava/util/Iterator;", "toString", "()Ljava/lang/String;", "", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "Landroidx/collection/SparseArrayCompat;", "l", "Landroidx/collection/SparseArrayCompat;", "C", "()Landroidx/collection/SparseArrayCompat;", "nodes", "m", "I", "startDestId", "n", "Ljava/lang/String;", "startDestIdName", "startDestRoute", "o", "F", "H", "(Ljava/lang/String;)V", "startDestinationRoute", "j", "displayName", "E", "G", "(I)V", "startDestinationId", "D", "startDestDisplayName", "Companion", "navigation-common_release"}, k = 1, mv = {1, 6, 0})
public class NavGraph extends NavDestination implements Iterable<NavDestination>, KMappedMarker {
    public static final Companion p = new Companion((DefaultConstructorMarker) null);
    public final SparseArrayCompat l = new SparseArrayCompat();
    public int m;
    public String n;
    public String o;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\u00020\u0005*\u00020\u0004H\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/navigation/NavGraph$Companion;", "", "<init>", "()V", "Landroidx/navigation/NavGraph;", "Landroidx/navigation/NavDestination;", "a", "(Landroidx/navigation/NavGraph;)Landroidx/navigation/NavDestination;", "navigation-common_release"}, k = 1, mv = {1, 6, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final NavDestination a(NavGraph navGraph) {
            Intrinsics.checkNotNullParameter(navGraph, "<this>");
            return (NavDestination) SequencesKt.last(SequencesKt.generateSequence(navGraph.y(navGraph.E()), NavGraph$Companion$findStartDestination$1.INSTANCE));
        }

        public Companion() {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavGraph(Navigator navigator) {
        super(navigator);
        Intrinsics.checkNotNullParameter(navigator, "navGraphNavigator");
    }

    public final NavDestination A(String str) {
        if (str == null || StringsKt.isBlank(str)) {
            return null;
        }
        return B(str, true);
    }

    public final NavDestination B(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "route");
        NavDestination navDestination = (NavDestination) this.l.g(NavDestination.j.a(str).hashCode());
        if (navDestination != null) {
            return navDestination;
        }
        if (!z || n() == null) {
            return null;
        }
        NavGraph n2 = n();
        Intrinsics.checkNotNull(n2);
        return n2.A(str);
    }

    public final SparseArrayCompat C() {
        return this.l;
    }

    public final String D() {
        if (this.n == null) {
            String str = this.o;
            if (str == null) {
                str = String.valueOf(this.m);
            }
            this.n = str;
        }
        String str2 = this.n;
        Intrinsics.checkNotNull(str2);
        return str2;
    }

    public final int E() {
        return this.m;
    }

    public final String F() {
        return this.o;
    }

    public final void G(int i) {
        if (i != k()) {
            if (this.o != null) {
                H((String) null);
            }
            this.m = i;
            this.n = null;
            return;
        }
        throw new IllegalArgumentException(("Start destination " + i + " cannot use the same id as the graph " + this).toString());
    }

    public final void H(String str) {
        int i;
        if (str == null) {
            i = 0;
        } else if (!(!Intrinsics.areEqual((Object) str, (Object) o()))) {
            throw new IllegalArgumentException(("Start destination " + str + " cannot use the same route as the graph " + this).toString());
        } else if (!StringsKt.isBlank(str)) {
            i = NavDestination.j.a(str).hashCode();
        } else {
            throw new IllegalArgumentException("Cannot have an empty start destination route".toString());
        }
        this.m = i;
        this.o = str;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof NavGraph)) {
            return false;
        }
        List mutableList = SequencesKt.toMutableList(SequencesKt.asSequence(SparseArrayKt.a(this.l)));
        NavGraph navGraph = (NavGraph) obj;
        Iterator a2 = SparseArrayKt.a(navGraph.l);
        while (a2.hasNext()) {
            mutableList.remove((NavDestination) a2.next());
        }
        return super.equals(obj) && this.l.p() == navGraph.l.p() && E() == navGraph.E() && mutableList.isEmpty();
    }

    public int hashCode() {
        int E = E();
        SparseArrayCompat sparseArrayCompat = this.l;
        int p2 = sparseArrayCompat.p();
        for (int i = 0; i < p2; i++) {
            E = (((E * 31) + sparseArrayCompat.l(i)) * 31) + ((NavDestination) sparseArrayCompat.q(i)).hashCode();
        }
        return E;
    }

    public final Iterator iterator() {
        return new NavGraph$iterator$1(this);
    }

    public String j() {
        return k() != 0 ? super.j() : "the root navigation";
    }

    public NavDestination.DeepLinkMatch p(NavDeepLinkRequest navDeepLinkRequest) {
        Intrinsics.checkNotNullParameter(navDeepLinkRequest, "navDeepLinkRequest");
        NavDestination.DeepLinkMatch p2 = super.p(navDeepLinkRequest);
        ArrayList arrayList = new ArrayList();
        Iterator it = iterator();
        while (it.hasNext()) {
            NavDestination.DeepLinkMatch p3 = ((NavDestination) it.next()).p(navDeepLinkRequest);
            if (p3 != null) {
                arrayList.add(p3);
            }
        }
        return (NavDestination.DeepLinkMatch) CollectionsKt.maxOrNull(CollectionsKt.listOfNotNull((T[]) new NavDestination.DeepLinkMatch[]{p2, (NavDestination.DeepLinkMatch) CollectionsKt.maxOrNull(arrayList)}));
    }

    public void q(Context context, AttributeSet attributeSet) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
        super.q(context, attributeSet);
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, R.styleable.NavGraphNavigator);
        Intrinsics.checkNotNullExpressionValue(obtainAttributes, "context.resources.obtain…vGraphNavigator\n        )");
        G(obtainAttributes.getResourceId(R.styleable.NavGraphNavigator_startDestination, 0));
        this.n = NavDestination.j.b(context, this.m);
        Unit unit = Unit.INSTANCE;
        obtainAttributes.recycle();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        NavDestination A = A(this.o);
        if (A == null) {
            A = y(E());
        }
        sb.append(" startDestination=");
        if (A == null) {
            String str = this.o;
            if (str != null) {
                sb.append(str);
            } else {
                String str2 = this.n;
                if (str2 != null) {
                    sb.append(str2);
                } else {
                    sb.append(Intrinsics.stringPlus("0x", Integer.toHexString(this.m)));
                }
            }
        } else {
            sb.append("{");
            sb.append(A.toString());
            sb.append("}");
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "sb.toString()");
        return sb2;
    }

    public final void x(NavDestination navDestination) {
        Intrinsics.checkNotNullParameter(navDestination, "node");
        int k = navDestination.k();
        String o2 = navDestination.o();
        if (k == 0 && o2 == null) {
            throw new IllegalArgumentException("Destinations must have an id or route. Call setId(), setRoute(), or include an android:id or app:route in your navigation XML.".toString());
        } else if (o() != null && !(!Intrinsics.areEqual((Object) o2, (Object) o()))) {
            throw new IllegalArgumentException(("Destination " + navDestination + " cannot have the same route as graph " + this).toString());
        } else if (k != k()) {
            NavDestination navDestination2 = (NavDestination) this.l.g(k);
            if (navDestination2 != navDestination) {
                if (navDestination.n() == null) {
                    if (navDestination2 != null) {
                        navDestination2.u((NavGraph) null);
                    }
                    navDestination.u(this);
                    this.l.m(navDestination.k(), navDestination);
                    return;
                }
                throw new IllegalStateException("Destination already has a parent set. Call NavGraph.remove() to remove the previous parent.".toString());
            }
        } else {
            throw new IllegalArgumentException(("Destination " + navDestination + " cannot have the same id as graph " + this).toString());
        }
    }

    public final NavDestination y(int i) {
        return z(i, true);
    }

    public final NavDestination z(int i, boolean z) {
        NavDestination navDestination = (NavDestination) this.l.g(i);
        if (navDestination != null) {
            return navDestination;
        }
        if (!z || n() == null) {
            return null;
        }
        NavGraph n2 = n();
        Intrinsics.checkNotNull(n2);
        return n2.y(i);
    }
}
