package io.ktor.http;

import com.upuphone.runasone.relay.api.IntentKey;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "key", "", "values", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class URLParserKt$parseQuery$1 extends Lambda implements Function2<String, List<? extends String>, Unit> {
    final /* synthetic */ URLBuilder $this_parseQuery;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public URLParserKt$parseQuery$1(URLBuilder uRLBuilder) {
        super(2);
        this.$this_parseQuery = uRLBuilder;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((String) obj, (List<String>) (List) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull String str, @NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(str, IntentKey.ACTIVITY.ACTION_KEY);
        Intrinsics.checkNotNullParameter(list, "values");
        this.$this_parseQuery.e().c(str, list);
    }
}
