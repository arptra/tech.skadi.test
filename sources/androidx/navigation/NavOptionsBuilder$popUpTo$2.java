package androidx.navigation;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/navigation/PopUpToBuilder;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class NavOptionsBuilder$popUpTo$2 extends Lambda implements Function1<PopUpToBuilder, Unit> {
    public static final NavOptionsBuilder$popUpTo$2 INSTANCE = new NavOptionsBuilder$popUpTo$2();

    public NavOptionsBuilder$popUpTo$2() {
        super(1);
    }

    public final void invoke(@NotNull PopUpToBuilder popUpToBuilder) {
        Intrinsics.checkNotNullParameter(popUpToBuilder, "$this$null");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((PopUpToBuilder) obj);
        return Unit.INSTANCE;
    }
}
