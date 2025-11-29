package androidx.navigation.ui;

import androidx.navigation.NavDestination;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\b\u001a\u00020\u0007*\u00020\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u0005H\u0001¢\u0006\u0004\b\b\u0010\tJ#\u0010\f\u001a\u00020\u0007*\u00020\u00042\u000e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\nH\u0001¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Landroidx/navigation/ui/NavigationUI;", "", "<init>", "()V", "Landroidx/navigation/NavDestination;", "", "destId", "", "a", "(Landroidx/navigation/NavDestination;I)Z", "", "destinationIds", "b", "(Landroidx/navigation/NavDestination;Ljava/util/Set;)Z", "navigation-ui_release"}, k = 1, mv = {1, 6, 0})
public final class NavigationUI {

    /* renamed from: a  reason: collision with root package name */
    public static final NavigationUI f1505a = new NavigationUI();

    public static final boolean a(NavDestination navDestination, int i) {
        Intrinsics.checkNotNullParameter(navDestination, "<this>");
        for (NavDestination k : NavDestination.j.c(navDestination)) {
            if (k.k() == i) {
                return true;
            }
        }
        return false;
    }

    public static final boolean b(NavDestination navDestination, Set set) {
        Intrinsics.checkNotNullParameter(navDestination, "<this>");
        Intrinsics.checkNotNullParameter(set, "destinationIds");
        for (NavDestination k : NavDestination.j.c(navDestination)) {
            if (set.contains(Integer.valueOf(k.k()))) {
                return true;
            }
        }
        return false;
    }
}
