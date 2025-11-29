package kotlinx.serialization.internal;

import java.util.Arrays;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.UIntArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.serialization.ExperimentalSerializationApi;

@ExperimentalUnsignedTypes
@PublishedApi
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0010¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0000ø\u0001\u0000¢\u0006\u0004\b\r\u0010\nJ\u0015\u0010\u000e\u001a\u00020\u0002H\u0010ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0012\u001a\u00020\u00028\u0002@\u0002X\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R$\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00068\u0010@RX\u000e¢\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0018"}, d2 = {"Lkotlinx/serialization/internal/UIntArrayBuilder;", "Lkotlinx/serialization/internal/PrimitiveArrayBuilder;", "Lkotlin/UIntArray;", "bufferWithData", "<init>", "([ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "", "requiredCapacity", "", "b", "(I)V", "Lkotlin/UInt;", "c", "e", "f", "()[I", "a", "[I", "buffer", "<set-?>", "I", "d", "()I", "position", "kotlinx-serialization-core"}, k = 1, mv = {1, 9, 0})
@ExperimentalSerializationApi
public final class UIntArrayBuilder extends PrimitiveArrayBuilder<UIntArray> {

    /* renamed from: a  reason: collision with root package name */
    public int[] f4067a;
    public int b;

    public /* synthetic */ UIntArrayBuilder(int[] iArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(iArr);
    }

    public /* bridge */ /* synthetic */ Object a() {
        return UIntArray.m168boximpl(f());
    }

    public void b(int i) {
        if (UIntArray.m176getSizeimpl(this.f4067a) < i) {
            int[] iArr = this.f4067a;
            int[] copyOf = Arrays.copyOf(iArr, RangesKt.coerceAtLeast(i, UIntArray.m176getSizeimpl(iArr) * 2));
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
            this.f4067a = UIntArray.m170constructorimpl(copyOf);
        }
    }

    public int d() {
        return this.b;
    }

    public final void e(int i) {
        PrimitiveArrayBuilder.c(this, 0, 1, (Object) null);
        int[] iArr = this.f4067a;
        int d = d();
        this.b = d + 1;
        UIntArray.m180setVXSXFK8(iArr, d, i);
    }

    public int[] f() {
        int[] copyOf = Arrays.copyOf(this.f4067a, d());
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
        return UIntArray.m170constructorimpl(copyOf);
    }

    public UIntArrayBuilder(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "bufferWithData");
        this.f4067a = iArr;
        this.b = UIntArray.m176getSizeimpl(iArr);
        b(10);
    }
}
