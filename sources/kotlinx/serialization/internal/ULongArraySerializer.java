package kotlinx.serialization.internal;

import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;

@ExperimentalUnsignedTypes
@PublishedApi
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÁ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0003B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\t\u001a\u00020\b*\u00020\u0002H\u0014ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\u000b\u001a\u00020\u0005*\u00020\u0002H\u0014ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\r\u001a\u00020\u0002H\u0014ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ/\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013H\u0014¢\u0006\u0004\b\u0016\u0010\u0017J*\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\bH\u0014ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001e"}, d2 = {"Lkotlinx/serialization/internal/ULongArraySerializer;", "Lkotlinx/serialization/KSerializer;", "Lkotlin/ULongArray;", "Lkotlinx/serialization/internal/PrimitiveArraySerializer;", "Lkotlin/ULong;", "Lkotlinx/serialization/internal/ULongArrayBuilder;", "<init>", "()V", "", "z", "([J)I", "C", "([J)Lkotlinx/serialization/internal/ULongArrayBuilder;", "A", "()[J", "Lkotlinx/serialization/encoding/CompositeDecoder;", "decoder", "index", "builder", "", "checkIndex", "", "B", "(Lkotlinx/serialization/encoding/CompositeDecoder;ILkotlinx/serialization/internal/ULongArrayBuilder;Z)V", "Lkotlinx/serialization/encoding/CompositeEncoder;", "encoder", "content", "size", "D", "(Lkotlinx/serialization/encoding/CompositeEncoder;[JI)V", "kotlinx-serialization-core"}, k = 1, mv = {1, 9, 0})
@ExperimentalSerializationApi
public final class ULongArraySerializer extends PrimitiveArraySerializer<ULong, ULongArray, ULongArrayBuilder> implements KSerializer<ULongArray> {
    public static final ULongArraySerializer c = new ULongArraySerializer();

    public ULongArraySerializer() {
        super(BuiltinSerializersKt.w(ULong.Companion));
    }

    public long[] A() {
        return ULongArray.m248constructorimpl(0);
    }

    /* renamed from: B */
    public void l(CompositeDecoder compositeDecoder, int i, ULongArrayBuilder uLongArrayBuilder, boolean z) {
        Intrinsics.checkNotNullParameter(compositeDecoder, "decoder");
        Intrinsics.checkNotNullParameter(uLongArrayBuilder, "builder");
        uLongArrayBuilder.e(ULong.m194constructorimpl(compositeDecoder.l(getDescriptor(), i).h()));
    }

    public ULongArrayBuilder C(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$this$toBuilder");
        return new ULongArrayBuilder(jArr, (DefaultConstructorMarker) null);
    }

    public void D(CompositeEncoder compositeEncoder, long[] jArr, int i) {
        Intrinsics.checkNotNullParameter(compositeEncoder, "encoder");
        Intrinsics.checkNotNullParameter(jArr, "content");
        for (int i2 = 0; i2 < i; i2++) {
            compositeEncoder.w(getDescriptor(), i2).A(ULongArray.m254getsVKNKU(jArr, i2));
        }
    }

    public /* bridge */ /* synthetic */ int i(Object obj) {
        return z(((ULongArray) obj).m263unboximpl());
    }

    public /* bridge */ /* synthetic */ Object o(Object obj) {
        return C(((ULongArray) obj).m263unboximpl());
    }

    public /* bridge */ /* synthetic */ Object v() {
        return ULongArray.m247boximpl(A());
    }

    public /* bridge */ /* synthetic */ void y(CompositeEncoder compositeEncoder, Object obj, int i) {
        D(compositeEncoder, ((ULongArray) obj).m263unboximpl(), i);
    }

    public int z(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$this$collectionSize");
        return ULongArray.m255getSizeimpl(jArr);
    }
}
