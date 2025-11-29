package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.serialization.json.JsonElement;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "node", "Lkotlinx/serialization/json/JsonElement;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class AbstractJsonTreeEncoder$beginStructure$consumer$1 extends Lambda implements Function1<JsonElement, Unit> {
    final /* synthetic */ AbstractJsonTreeEncoder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AbstractJsonTreeEncoder$beginStructure$consumer$1(AbstractJsonTreeEncoder abstractJsonTreeEncoder) {
        super(1);
        this.this$0 = abstractJsonTreeEncoder;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((JsonElement) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull JsonElement jsonElement) {
        Intrinsics.checkNotNullParameter(jsonElement, "node");
        AbstractJsonTreeEncoder abstractJsonTreeEncoder = this.this$0;
        abstractJsonTreeEncoder.z0(AbstractJsonTreeEncoder.h0(abstractJsonTreeEncoder), jsonElement);
    }
}
