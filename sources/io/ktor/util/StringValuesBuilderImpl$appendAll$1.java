package io.ktor.util;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "name", "", "values", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class StringValuesBuilderImpl$appendAll$1 extends Lambda implements Function2<String, List<? extends String>, Unit> {
    final /* synthetic */ StringValuesBuilderImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StringValuesBuilderImpl$appendAll$1(StringValuesBuilderImpl stringValuesBuilderImpl) {
        super(2);
        this.this$0 = stringValuesBuilderImpl;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((String) obj, (List<String>) (List) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull String str, @NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(list, "values");
        this.this$0.c(str, list);
    }
}
