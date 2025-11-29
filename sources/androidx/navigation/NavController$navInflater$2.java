package androidx.navigation;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/navigation/NavInflater;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class NavController$navInflater$2 extends Lambda implements Function0<NavInflater> {
    final /* synthetic */ NavController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavController$navInflater$2(NavController navController) {
        super(0);
        this.this$0 = navController;
    }

    @NotNull
    public final NavInflater invoke() {
        NavInflater g = this.this$0.c;
        return g == null ? new NavInflater(this.this$0.A(), this.this$0.w) : g;
    }
}
