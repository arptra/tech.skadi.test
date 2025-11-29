package kotlinx.serialization;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lkotlin/reflect/KClassifier;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class SerializersKt__SerializersKt$serializerByKTypeImpl$contextualSerializer$1 extends Lambda implements Function0<KClassifier> {
    final /* synthetic */ List<KType> $typeArguments;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SerializersKt__SerializersKt$serializerByKTypeImpl$contextualSerializer$1(List<? extends KType> list) {
        super(0);
        this.$typeArguments = list;
    }

    @Nullable
    public final KClassifier invoke() {
        return this.$typeArguments.get(0).getClassifier();
    }
}
