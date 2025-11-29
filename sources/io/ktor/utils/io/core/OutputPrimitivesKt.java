package io.ktor.utils.io.core;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001b\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0006\u0010\u0005\u001a\u0019\u0010\b\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\t\u001a\u001b\u0010\n\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\t\u001a\u0019\u0010\f\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\r\u001a\u001b\u0010\u000e\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\r\u001a\u0019\u0010\u0010\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0019\u0010\u0013\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lio/ktor/utils/io/core/Output;", "", "value", "", "g", "(Lio/ktor/utils/io/core/Output;S)V", "h", "", "c", "(Lio/ktor/utils/io/core/Output;I)V", "d", "", "e", "(Lio/ktor/utils/io/core/Output;J)V", "f", "", "b", "(Lio/ktor/utils/io/core/Output;F)V", "", "a", "(Lio/ktor/utils/io/core/Output;D)V", "ktor-io"}, k = 2, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nOutputPrimitives.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OutputPrimitives.kt\nio/ktor/utils/io/core/OutputPrimitivesKt\n+ 2 MemoryPrimitivesJvm.kt\nio/ktor/utils/io/bits/MemoryPrimitivesJvmKt\n+ 3 ByteOrder.kt\nio/ktor/utils/io/bits/ByteOrderKt\n*L\n1#1,100:1\n80#1,4:101\n84#1,4:107\n95#1,4:111\n80#1,4:117\n84#1,4:123\n95#1,4:127\n80#1,4:137\n84#1,4:143\n95#1,4:147\n80#1,4:153\n84#1,4:159\n80#1,4:163\n84#1,4:169\n65#2,2:105\n51#2,2:121\n79#2,2:141\n93#2,2:157\n107#2,2:167\n43#3:115\n45#3:116\n47#3:131\n43#3:132\n45#3:133\n49#3:134\n43#3:135\n45#3:136\n51#3:151\n53#3:152\n*S KotlinDebug\n*F\n+ 1 OutputPrimitives.kt\nio/ktor/utils/io/core/OutputPrimitivesKt\n*L\n7#1:101,4\n7#1:107,4\n14#1:111,4\n22#1:117,4\n22#1:123,4\n29#1:127,4\n48#1:137,4\n48#1:143,4\n55#1:147,4\n63#1:153,4\n63#1:159,4\n70#1:163,4\n70#1:169,4\n7#1:105,2\n22#1:121,2\n48#1:141,2\n63#1:157,2\n70#1:167,2\n15#1:115\n16#1:116\n36#1:131\n37#1:132\n38#1:133\n40#1:134\n41#1:135\n42#1:136\n56#1:151\n57#1:152\n*E\n"})
public final class OutputPrimitivesKt {
    public static final void a(Output output, double d) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        int T = output.T();
        if (output.N() - T > 8) {
            output.d0(T + 8);
            output.S().putDouble(T, d);
            return;
        }
        f(output, Double.doubleToRawLongBits(d));
    }

    public static final void b(Output output, float f) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        int T = output.T();
        if (output.N() - T > 4) {
            output.d0(T + 4);
            output.S().putFloat(T, f);
            return;
        }
        d(output, Float.floatToRawIntBits(f));
    }

    public static final void c(Output output, int i) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        int T = output.T();
        if (output.N() - T > 4) {
            output.d0(T + 4);
            output.S().putInt(T, i);
            return;
        }
        d(output, i);
    }

    public static final void d(Output output, int i) {
        BufferPrimitivesKt.j(output.c0(4), i);
        output.b();
    }

    public static final void e(Output output, long j) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        int T = output.T();
        if (output.N() - T > 8) {
            output.d0(T + 8);
            output.S().putLong(T, j);
            return;
        }
        f(output, j);
    }

    public static final void f(Output output, long j) {
        BufferPrimitivesKt.k(output.c0(8), j);
        output.b();
    }

    public static final void g(Output output, short s) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        int T = output.T();
        if (output.N() - T > 2) {
            output.d0(T + 2);
            output.S().putShort(T, s);
            return;
        }
        h(output, s);
    }

    public static final void h(Output output, short s) {
        BufferPrimitivesKt.l(output.c0(2), s);
        output.b();
    }
}
