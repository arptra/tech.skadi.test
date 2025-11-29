package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0016\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u001dB)\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u0005¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0014\u0010\rJ\u000f\u0010\u0015\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0015\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0016R&\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00188\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u00118\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u001b¨\u0006\u001e"}, d2 = {"Lkotlinx/serialization/internal/ElementMarker;", "", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lkotlin/Function2;", "", "", "readIfAbsent", "<init>", "(Lkotlinx/serialization/descriptors/SerialDescriptor;Lkotlin/jvm/functions/Function2;)V", "index", "", "a", "(I)V", "d", "()I", "elementsCount", "", "e", "(I)[J", "b", "c", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "Lkotlin/jvm/functions/Function2;", "", "J", "lowerMarks", "[J", "highMarksArray", "Companion", "kotlinx-serialization-core"}, k = 1, mv = {1, 9, 0})
@CoreFriendModuleApi
public final class ElementMarker {
    public static final Companion e = new Companion((DefaultConstructorMarker) null);
    public static final long[] f = new long[0];

    /* renamed from: a  reason: collision with root package name */
    public final SerialDescriptor f4030a;
    public final Function2 b;
    public long c;
    public final long[] d;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lkotlinx/serialization/internal/ElementMarker$Companion;", "", "()V", "EMPTY_HIGH_MARKS", "", "kotlinx-serialization-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public ElementMarker(SerialDescriptor serialDescriptor, Function2 function2) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        Intrinsics.checkNotNullParameter(function2, "readIfAbsent");
        this.f4030a = serialDescriptor;
        this.b = function2;
        int e2 = serialDescriptor.e();
        long j = 0;
        if (e2 <= 64) {
            this.c = e2 != 64 ? -1 << e2 : j;
            this.d = f;
            return;
        }
        this.c = 0;
        this.d = e(e2);
    }

    public final void a(int i) {
        if (i < 64) {
            this.c |= 1 << i;
        } else {
            b(i);
        }
    }

    public final void b(int i) {
        int i2 = (i >>> 6) - 1;
        long[] jArr = this.d;
        jArr[i2] = jArr[i2] | (1 << (i & 63));
    }

    public final int c() {
        int length = this.d.length;
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            int i3 = i2 * 64;
            long j = this.d[i];
            while (j != -1) {
                int numberOfTrailingZeros = Long.numberOfTrailingZeros(~j);
                j |= 1 << numberOfTrailingZeros;
                int i4 = numberOfTrailingZeros + i3;
                if (((Boolean) this.b.invoke(this.f4030a, Integer.valueOf(i4))).booleanValue()) {
                    this.d[i] = j;
                    return i4;
                }
            }
            this.d[i] = j;
            i = i2;
        }
        return -1;
    }

    public final int d() {
        int numberOfTrailingZeros;
        int e2 = this.f4030a.e();
        do {
            long j = this.c;
            if (j != -1) {
                numberOfTrailingZeros = Long.numberOfTrailingZeros(~j);
                this.c |= 1 << numberOfTrailingZeros;
            } else if (e2 > 64) {
                return c();
            } else {
                return -1;
            }
        } while (!((Boolean) this.b.invoke(this.f4030a, Integer.valueOf(numberOfTrailingZeros))).booleanValue());
        return numberOfTrailingZeros;
    }

    public final long[] e(int i) {
        long[] jArr = new long[((i - 1) >>> 6)];
        if ((i & 63) != 0) {
            jArr[ArraysKt.getLastIndex(jArr)] = -1 << i;
        }
        return jArr;
    }
}
