package sdk.meizu.account.factor.authentication.sdk;

import kotlin.Function;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
public final class FactorAuthenticationActivityKt$sam$kotlinx_coroutines_flow_FlowCollector$0 implements FlowCollector, FunctionAdapter {
    private final /* synthetic */ Function2 function;

    public FactorAuthenticationActivityKt$sam$kotlinx_coroutines_flow_FlowCollector$0(Function2 function2) {
        Intrinsics.checkNotNullParameter(function2, "function");
        this.function = function2;
    }

    public final /* synthetic */ Object emit(Object obj, Continuation continuation) {
        return this.function.invoke(obj, continuation);
    }

    public final boolean equals(@Nullable Object obj) {
        if (!(obj instanceof FlowCollector) || !(obj instanceof FunctionAdapter)) {
            return false;
        }
        return Intrinsics.areEqual((Object) getFunctionDelegate(), (Object) ((FunctionAdapter) obj).getFunctionDelegate());
    }

    @NotNull
    public final Function<?> getFunctionDelegate() {
        return this.function;
    }

    public final int hashCode() {
        return getFunctionDelegate().hashCode();
    }
}
