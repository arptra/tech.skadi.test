package androidx.navigation;

import android.os.Bundle;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "entry", "Landroidx/navigation/NavBackStackEntry;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class NavController$restoreStateInternal$4 extends Lambda implements Function1<NavBackStackEntry, Unit> {
    final /* synthetic */ Bundle $args;
    final /* synthetic */ List<NavBackStackEntry> $entries;
    final /* synthetic */ Ref.IntRef $lastNavigatedIndex;
    final /* synthetic */ Ref.BooleanRef $navigated;
    final /* synthetic */ NavController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavController$restoreStateInternal$4(Ref.BooleanRef booleanRef, List<NavBackStackEntry> list, Ref.IntRef intRef, NavController navController, Bundle bundle) {
        super(1);
        this.$navigated = booleanRef;
        this.$entries = list;
        this.$lastNavigatedIndex = intRef;
        this.this$0 = navController;
        this.$args = bundle;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((NavBackStackEntry) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull NavBackStackEntry navBackStackEntry) {
        List<NavBackStackEntry> list;
        Intrinsics.checkNotNullParameter(navBackStackEntry, "entry");
        this.$navigated.element = true;
        int indexOf = this.$entries.indexOf(navBackStackEntry);
        if (indexOf != -1) {
            int i = indexOf + 1;
            list = this.$entries.subList(this.$lastNavigatedIndex.element, i);
            this.$lastNavigatedIndex.element = i;
        } else {
            list = CollectionsKt.emptyList();
        }
        this.this$0.n(navBackStackEntry.f(), this.$args, navBackStackEntry, list);
    }
}
