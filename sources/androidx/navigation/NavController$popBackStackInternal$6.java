package androidx.navigation;

import io.netty.handler.codec.rtsp.RtspHeaders;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/navigation/NavDestination;", "destination", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class NavController$popBackStackInternal$6 extends Lambda implements Function1<NavDestination, NavDestination> {
    public static final NavController$popBackStackInternal$6 INSTANCE = new NavController$popBackStackInternal$6();

    public NavController$popBackStackInternal$6() {
        super(1);
    }

    @Nullable
    public final NavDestination invoke(@NotNull NavDestination navDestination) {
        Intrinsics.checkNotNullParameter(navDestination, RtspHeaders.Values.DESTINATION);
        NavGraph n = navDestination.n();
        if (n != null && n.E() == navDestination.k()) {
            return navDestination.n();
        }
        return null;
    }
}
