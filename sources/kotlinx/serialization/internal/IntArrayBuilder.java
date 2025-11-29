package kotlinx.serialization.internal;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000f\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0010¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\f\u0010\nJ\u000f\u0010\r\u001a\u00020\u0002H\u0010¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R$\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00068\u0010@RX\u000e¢\u0006\f\n\u0004\b\t\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lkotlinx/serialization/internal/IntArrayBuilder;", "Lkotlinx/serialization/internal/PrimitiveArrayBuilder;", "", "bufferWithData", "<init>", "([I)V", "", "requiredCapacity", "", "b", "(I)V", "c", "e", "f", "()[I", "a", "[I", "buffer", "<set-?>", "I", "d", "()I", "position", "kotlinx-serialization-core"}, k = 1, mv = {1, 9, 0})
@PublishedApi
public final class IntArrayBuilder extends PrimitiveArrayBuilder<int[]> {

    /* renamed from: a  reason: collision with root package name */
    public int[] f4035a;
    public int b;

    public IntArrayBuilder(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "bufferWithData");
        this.f4035a = iArr;
        this.b = iArr.length;
        b(10);
    }

    public void b(int i) {
        int[] iArr = this.f4035a;
        if (iArr.length < i) {
            int[] copyOf = Arrays.copyOf(iArr, RangesKt.coerceAtLeast(i, iArr.length * 2));
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
            this.f4035a = copyOf;
        }
    }

    public int d() {
        return this.b;
    }

    public final void e(int i) {
        PrimitiveArrayBuilder.c(this, 0, 1, (Object) null);
        int[] iArr = this.f4035a;
        int d = d();
        this.b = d + 1;
        iArr[d] = i;
    }

    /* renamed from: f */
    public int[] a() {
        int[] copyOf = Arrays.copyOf(this.f4035a, d());
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
        return copyOf;
    }
}
