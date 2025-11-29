package androidx.navigation;

import android.os.Bundle;
import androidx.navigation.Navigator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0017\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ1\u0010\u0011\u001a\u00020\u00102\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J+\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Landroidx/navigation/NavGraphNavigator;", "Landroidx/navigation/Navigator;", "Landroidx/navigation/NavGraph;", "Landroidx/navigation/NavigatorProvider;", "navigatorProvider", "<init>", "(Landroidx/navigation/NavigatorProvider;)V", "l", "()Landroidx/navigation/NavGraph;", "", "Landroidx/navigation/NavBackStackEntry;", "entries", "Landroidx/navigation/NavOptions;", "navOptions", "Landroidx/navigation/Navigator$Extras;", "navigatorExtras", "", "e", "(Ljava/util/List;Landroidx/navigation/NavOptions;Landroidx/navigation/Navigator$Extras;)V", "entry", "m", "(Landroidx/navigation/NavBackStackEntry;Landroidx/navigation/NavOptions;Landroidx/navigation/Navigator$Extras;)V", "c", "Landroidx/navigation/NavigatorProvider;", "navigation-common_release"}, k = 1, mv = {1, 6, 0})
@Navigator.Name("navigation")
public class NavGraphNavigator extends Navigator<NavGraph> {
    public final NavigatorProvider c;

    public NavGraphNavigator(NavigatorProvider navigatorProvider) {
        Intrinsics.checkNotNullParameter(navigatorProvider, "navigatorProvider");
        this.c = navigatorProvider;
    }

    public void e(List list, NavOptions navOptions, Navigator.Extras extras) {
        Intrinsics.checkNotNullParameter(list, "entries");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            m((NavBackStackEntry) it.next(), navOptions, extras);
        }
    }

    /* renamed from: l */
    public NavGraph a() {
        return new NavGraph(this);
    }

    public final void m(NavBackStackEntry navBackStackEntry, NavOptions navOptions, Navigator.Extras extras) {
        NavGraph navGraph = (NavGraph) navBackStackEntry.f();
        Bundle d = navBackStackEntry.d();
        int E = navGraph.E();
        String F = navGraph.F();
        if (E == 0 && F == null) {
            throw new IllegalStateException(Intrinsics.stringPlus("no start destination defined via app:startDestination for ", navGraph.j()).toString());
        }
        NavDestination B = F != null ? navGraph.B(F, false) : navGraph.z(E, false);
        if (B != null) {
            this.c.d(B.m()).e(CollectionsKt.listOf(b().a(B, B.d(d))), navOptions, extras);
            return;
        }
        String D = navGraph.D();
        throw new IllegalArgumentException("navigation destination " + D + " is not a direct child of this NavGraph");
    }
}
