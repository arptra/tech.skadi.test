package dagger.hilt.android.lifecycle;

import androidx.lifecycle.ViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModel;", "VMF", "factory", "", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class HiltViewModelExtensions$addCreationCallback$1$1 extends Lambda implements Function1<Object, ViewModel> {
    final /* synthetic */ Function1<VMF, ViewModel> $callback;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HiltViewModelExtensions$addCreationCallback$1$1(Function1<? super VMF, ? extends ViewModel> function1) {
        super(1);
        this.$callback = function1;
    }

    @NotNull
    public final ViewModel invoke(Object obj) {
        return this.$callback.invoke(obj);
    }
}
