package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.serialization.DeserializationStrategy;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nTagged.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Tagged.kt\nkotlinx/serialization/internal/TaggedDecoder$decodeNullableSerializableElement$1\n+ 2 Decoding.kt\nkotlinx/serialization/encoding/DecodingKt\n*L\n1#1,335:1\n270#2,2:336\n*S KotlinDebug\n*F\n+ 1 Tagged.kt\nkotlinx/serialization/internal/TaggedDecoder$decodeNullableSerializableElement$1\n*L\n287#1:336,2\n*E\n"})
@Metadata(d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002\"\u0004\b\u0001\u0010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "T", "", "Tag", "invoke", "()Ljava/lang/Object;"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class TaggedDecoder$decodeNullableSerializableElement$1 extends Lambda implements Function0<Object> {
    final /* synthetic */ DeserializationStrategy<Object> $deserializer;
    final /* synthetic */ Object $previousValue;
    final /* synthetic */ TaggedDecoder<Tag> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TaggedDecoder$decodeNullableSerializableElement$1(TaggedDecoder<Tag> taggedDecoder, DeserializationStrategy<Object> deserializationStrategy, Object obj) {
        super(0);
        this.this$0 = taggedDecoder;
        this.$deserializer = deserializationStrategy;
        this.$previousValue = obj;
    }

    @Nullable
    public final Object invoke() {
        TaggedDecoder<Tag> taggedDecoder = this.this$0;
        DeserializationStrategy<Object> deserializationStrategy = this.$deserializer;
        return (deserializationStrategy.getDescriptor().b() || taggedDecoder.D()) ? taggedDecoder.I(deserializationStrategy, this.$previousValue) : taggedDecoder.g();
    }
}
