package androidx.navigation;

import android.os.Bundle;
import androidx.navigation.NavDestination;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.Retention;
import kotlin.annotation.Target;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0014\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003:\u000212B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0017¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00028\u0000H&¢\u0006\u0004\b\u000b\u0010\fJ1\u0010\u0014\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J7\u0010\u001c\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0019\u001a\u00028\u00002\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010!\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u001fH\u0016¢\u0006\u0004\b#\u0010$J\u0011\u0010%\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0004\b%\u0010&J\u0017\u0010'\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u001aH\u0016¢\u0006\u0004\b'\u0010(R\u0018\u0010*\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010)R$\u0010/\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020\u001f8\u0006@BX\u000e¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010$R\u0014\u0010\u0007\u001a\u00020\u00068DX\u0004¢\u0006\u0006\u001a\u0004\b,\u00100¨\u00063"}, d2 = {"Landroidx/navigation/Navigator;", "Landroidx/navigation/NavDestination;", "D", "", "<init>", "()V", "Landroidx/navigation/NavigatorState;", "state", "", "f", "(Landroidx/navigation/NavigatorState;)V", "a", "()Landroidx/navigation/NavDestination;", "", "Landroidx/navigation/NavBackStackEntry;", "entries", "Landroidx/navigation/NavOptions;", "navOptions", "Landroidx/navigation/Navigator$Extras;", "navigatorExtras", "e", "(Ljava/util/List;Landroidx/navigation/NavOptions;Landroidx/navigation/Navigator$Extras;)V", "backStackEntry", "g", "(Landroidx/navigation/NavBackStackEntry;)V", "destination", "Landroid/os/Bundle;", "args", "d", "(Landroidx/navigation/NavDestination;Landroid/os/Bundle;Landroidx/navigation/NavOptions;Landroidx/navigation/Navigator$Extras;)Landroidx/navigation/NavDestination;", "popUpTo", "", "savedState", "j", "(Landroidx/navigation/NavBackStackEntry;Z)V", "k", "()Z", "i", "()Landroid/os/Bundle;", "h", "(Landroid/os/Bundle;)V", "Landroidx/navigation/NavigatorState;", "_state", "<set-?>", "b", "Z", "c", "isAttached", "()Landroidx/navigation/NavigatorState;", "Extras", "Name", "navigation-common_release"}, k = 1, mv = {1, 6, 0})
public abstract class Navigator<D extends NavDestination> {

    /* renamed from: a  reason: collision with root package name */
    public NavigatorState f1494a;
    public boolean b;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Landroidx/navigation/Navigator$Extras;", "", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Extras {
    }

    @Target(allowedTargets = {AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.CLASS})
    @Retention(AnnotationRetention.RUNTIME)
    @java.lang.annotation.Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\b\u0012\u0006\u0010\u0002\u001a\u00020\u0003R\u000f\u0010\u0002\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Landroidx/navigation/Navigator$Name;", "", "value", "", "()Ljava/lang/String;", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @java.lang.annotation.Retention(RetentionPolicy.RUNTIME)
    public @interface Name {
        String value();
    }

    public abstract NavDestination a();

    public final NavigatorState b() {
        NavigatorState navigatorState = this.f1494a;
        if (navigatorState != null) {
            return navigatorState;
        }
        throw new IllegalStateException("You cannot access the Navigator's state until the Navigator is attached".toString());
    }

    public final boolean c() {
        return this.b;
    }

    public NavDestination d(NavDestination navDestination, Bundle bundle, NavOptions navOptions, Extras extras) {
        Intrinsics.checkNotNullParameter(navDestination, RtspHeaders.Values.DESTINATION);
        return navDestination;
    }

    public void e(List list, NavOptions navOptions, Extras extras) {
        Intrinsics.checkNotNullParameter(list, "entries");
        for (NavBackStackEntry h : SequencesKt.filterNotNull(SequencesKt.map(CollectionsKt.asSequence(list), new Navigator$navigate$1(this, navOptions, extras)))) {
            b().h(h);
        }
    }

    public void f(NavigatorState navigatorState) {
        Intrinsics.checkNotNullParameter(navigatorState, "state");
        this.f1494a = navigatorState;
        this.b = true;
    }

    public void g(NavBackStackEntry navBackStackEntry) {
        Intrinsics.checkNotNullParameter(navBackStackEntry, "backStackEntry");
        NavDestination f = navBackStackEntry.f();
        if (!(f instanceof NavDestination)) {
            f = null;
        }
        if (f != null) {
            d(f, (Bundle) null, NavOptionsBuilderKt.a(Navigator$onLaunchSingleTop$1.INSTANCE), (Extras) null);
            b().f(navBackStackEntry);
        }
    }

    public void h(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "savedState");
    }

    public Bundle i() {
        return null;
    }

    public void j(NavBackStackEntry navBackStackEntry, boolean z) {
        Intrinsics.checkNotNullParameter(navBackStackEntry, "popUpTo");
        List list = (List) b().b().getValue();
        if (list.contains(navBackStackEntry)) {
            ListIterator listIterator = list.listIterator(list.size());
            NavBackStackEntry navBackStackEntry2 = null;
            while (k()) {
                navBackStackEntry2 = (NavBackStackEntry) listIterator.previous();
                if (Intrinsics.areEqual((Object) navBackStackEntry2, (Object) navBackStackEntry)) {
                    break;
                }
            }
            if (navBackStackEntry2 != null) {
                b().g(navBackStackEntry2, z);
                return;
            }
            return;
        }
        throw new IllegalStateException(("popBackStack was called with " + navBackStackEntry + " which does not exist in back stack " + list).toString());
    }

    public boolean k() {
        return true;
    }
}
