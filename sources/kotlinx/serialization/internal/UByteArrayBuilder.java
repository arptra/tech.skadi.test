package kotlinx.serialization.internal;

import java.util.Arrays;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.UByteArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.serialization.ExperimentalSerializationApi;

@ExperimentalUnsignedTypes
@PublishedApi
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0010¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0000ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u000f\u001a\u00020\u0002H\u0010ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0013\u001a\u00020\u00028\u0002@\u0002X\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R$\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00068\u0010@RX\u000e¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0019"}, d2 = {"Lkotlinx/serialization/internal/UByteArrayBuilder;", "Lkotlinx/serialization/internal/PrimitiveArrayBuilder;", "Lkotlin/UByteArray;", "bufferWithData", "<init>", "([BLkotlin/jvm/internal/DefaultConstructorMarker;)V", "", "requiredCapacity", "", "b", "(I)V", "Lkotlin/UByte;", "c", "e", "(B)V", "f", "()[B", "a", "[B", "buffer", "<set-?>", "I", "d", "()I", "position", "kotlinx-serialization-core"}, k = 1, mv = {1, 9, 0})
@ExperimentalSerializationApi
public final class UByteArrayBuilder extends PrimitiveArrayBuilder<UByteArray> {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f4065a;
    public int b;

    public /* synthetic */ UByteArrayBuilder(byte[] bArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(bArr);
    }

    public /* bridge */ /* synthetic */ Object a() {
        return UByteArray.m89boximpl(f());
    }

    public void b(int i) {
        if (UByteArray.m97getSizeimpl(this.f4065a) < i) {
            byte[] bArr = this.f4065a;
            byte[] copyOf = Arrays.copyOf(bArr, RangesKt.coerceAtLeast(i, UByteArray.m97getSizeimpl(bArr) * 2));
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
            this.f4065a = UByteArray.m91constructorimpl(copyOf);
        }
    }

    public int d() {
        return this.b;
    }

    public final void e(byte b2) {
        PrimitiveArrayBuilder.c(this, 0, 1, (Object) null);
        byte[] bArr = this.f4065a;
        int d = d();
        this.b = d + 1;
        UByteArray.m101setVurrAj0(bArr, d, b2);
    }

    public byte[] f() {
        byte[] copyOf = Arrays.copyOf(this.f4065a, d());
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
        return UByteArray.m91constructorimpl(copyOf);
    }

    public UByteArrayBuilder(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "bufferWithData");
        this.f4065a = bArr;
        this.b = UByteArray.m97getSizeimpl(bArr);
        b(10);
    }
}
