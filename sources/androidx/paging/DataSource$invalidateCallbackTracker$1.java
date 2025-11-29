package androidx.paging;

import androidx.paging.DataSource;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "Key", "", "Value", "it", "Landroidx/paging/DataSource$InvalidatedCallback;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class DataSource$invalidateCallbackTracker$1 extends Lambda implements Function1<DataSource.InvalidatedCallback, Unit> {
    public static final DataSource$invalidateCallbackTracker$1 INSTANCE = new DataSource$invalidateCallbackTracker$1();

    public DataSource$invalidateCallbackTracker$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DataSource.InvalidatedCallback) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull DataSource.InvalidatedCallback invalidatedCallback) {
        Intrinsics.checkNotNullParameter(invalidatedCallback, "it");
        invalidatedCallback.a();
    }
}
