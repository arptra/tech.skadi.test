package kotlinx.serialization.internal;

import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;

@ExperimentalUnsignedTypes
@PublishedApi
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÁ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0003B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\t\u001a\u00020\b*\u00020\u0002H\u0014ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\u000b\u001a\u00020\u0005*\u00020\u0002H\u0014ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\r\u001a\u00020\u0002H\u0014ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ/\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013H\u0014¢\u0006\u0004\b\u0016\u0010\u0017J*\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\bH\u0014ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001e"}, d2 = {"Lkotlinx/serialization/internal/UShortArraySerializer;", "Lkotlinx/serialization/KSerializer;", "Lkotlin/UShortArray;", "Lkotlinx/serialization/internal/PrimitiveArraySerializer;", "Lkotlin/UShort;", "Lkotlinx/serialization/internal/UShortArrayBuilder;", "<init>", "()V", "", "z", "([S)I", "C", "([S)Lkotlinx/serialization/internal/UShortArrayBuilder;", "A", "()[S", "Lkotlinx/serialization/encoding/CompositeDecoder;", "decoder", "index", "builder", "", "checkIndex", "", "B", "(Lkotlinx/serialization/encoding/CompositeDecoder;ILkotlinx/serialization/internal/UShortArrayBuilder;Z)V", "Lkotlinx/serialization/encoding/CompositeEncoder;", "encoder", "content", "size", "D", "(Lkotlinx/serialization/encoding/CompositeEncoder;[SI)V", "kotlinx-serialization-core"}, k = 1, mv = {1, 9, 0})
@ExperimentalSerializationApi
public final class UShortArraySerializer extends PrimitiveArraySerializer<UShort, UShortArray, UShortArrayBuilder> implements KSerializer<UShortArray> {
    public static final UShortArraySerializer c = new UShortArraySerializer();

    public UShortArraySerializer() {
        super(BuiltinSerializersKt.x(UShort.Companion));
    }

    public short[] A() {
        return UShortArray.m353constructorimpl(0);
    }

    /* renamed from: B */
    public void l(CompositeDecoder compositeDecoder, int i, UShortArrayBuilder uShortArrayBuilder, boolean z) {
        Intrinsics.checkNotNullParameter(compositeDecoder, "decoder");
        Intrinsics.checkNotNullParameter(uShortArrayBuilder, "builder");
        uShortArrayBuilder.e(UShort.m301constructorimpl(compositeDecoder.l(getDescriptor(), i).m()));
    }

    public UShortArrayBuilder C(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$this$toBuilder");
        return new UShortArrayBuilder(sArr, (DefaultConstructorMarker) null);
    }

    public void D(CompositeEncoder compositeEncoder, short[] sArr, int i) {
        Intrinsics.checkNotNullParameter(compositeEncoder, "encoder");
        Intrinsics.checkNotNullParameter(sArr, "content");
        for (int i2 = 0; i2 < i; i2++) {
            compositeEncoder.w(getDescriptor(), i2).k(UShortArray.m359getMh2AYeg(sArr, i2));
        }
    }

    public /* bridge */ /* synthetic */ int i(Object obj) {
        return z(((UShortArray) obj).m368unboximpl());
    }

    public /* bridge */ /* synthetic */ Object o(Object obj) {
        return C(((UShortArray) obj).m368unboximpl());
    }

    public /* bridge */ /* synthetic */ Object v() {
        return UShortArray.m352boximpl(A());
    }

    public /* bridge */ /* synthetic */ void y(CompositeEncoder compositeEncoder, Object obj, int i) {
        D(compositeEncoder, ((UShortArray) obj).m368unboximpl(), i);
    }

    public int z(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$this$collectionSize");
        return UShortArray.m360getSizeimpl(sArr);
    }
}
