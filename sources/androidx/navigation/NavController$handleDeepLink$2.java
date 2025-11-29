package androidx.navigation;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/navigation/NavOptionsBuilder;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class NavController$handleDeepLink$2 extends Lambda implements Function1<NavOptionsBuilder, Unit> {
    final /* synthetic */ NavDestination $node;
    final /* synthetic */ NavController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavController$handleDeepLink$2(NavDestination navDestination, NavController navController) {
        super(1);
        this.$node = navDestination;
        this.this$0 = navController;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((NavOptionsBuilder) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull NavOptionsBuilder navOptionsBuilder) {
        Intrinsics.checkNotNullParameter(navOptionsBuilder, "$this$navOptions");
        navOptionsBuilder.a(AnonymousClass1.INSTANCE);
        NavDestination navDestination = this.$node;
        if (navDestination instanceof NavGraph) {
            Sequence<NavDestination> c = NavDestination.j.c(navDestination);
            NavController navController = this.this$0;
            for (NavDestination navDestination2 : c) {
                NavDestination C = navController.C();
                if (Intrinsics.areEqual((Object) navDestination2, (Object) C == null ? null : C.n())) {
                    return;
                }
            }
            if (NavController.H) {
                navOptionsBuilder.g(NavGraph.p.a(this.this$0.E()).k(), AnonymousClass2.INSTANCE);
            }
        }
    }
}
