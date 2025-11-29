package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlinx.serialization.json.JsonElement;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "T", "it", "Lkotlinx/serialization/json/JsonElement;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class TreeJsonEncoderKt$writeJson$encoder$1 extends Lambda implements Function1<JsonElement, Unit> {
    final /* synthetic */ Ref.ObjectRef<JsonElement> $result;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TreeJsonEncoderKt$writeJson$encoder$1(Ref.ObjectRef<JsonElement> objectRef) {
        super(1);
        this.$result = objectRef;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((JsonElement) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull JsonElement jsonElement) {
        Intrinsics.checkNotNullParameter(jsonElement, "it");
        this.$result.element = jsonElement;
    }
}
