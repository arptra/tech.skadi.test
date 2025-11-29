package io.ktor.utils.io.core;

import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.core.internal.UnsafeKt;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0004\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u0002¢\u0006\u0004\b\u0004\u0010\u0003\u001a\u0011\u0010\u0006\u001a\u00020\u0005*\u00020\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0013\u0010\b\u001a\u00020\u0005*\u00020\u0000H\u0002¢\u0006\u0004\b\b\u0010\u0007\u001a\u0011\u0010\n\u001a\u00020\t*\u00020\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a\u0013\u0010\f\u001a\u00020\t*\u00020\u0000H\u0002¢\u0006\u0004\b\f\u0010\u000b\u001a\u0011\u0010\u000e\u001a\u00020\r*\u00020\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0011\u0010\u0010\u001a\u00020\r*\u00020\u0000¢\u0006\u0004\b\u0010\u0010\u000f\u001a\u0011\u0010\u0012\u001a\u00020\u0011*\u00020\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0011\u0010\u0014\u001a\u00020\u0011*\u00020\u0000¢\u0006\u0004\b\u0014\u0010\u0013¨\u0006\u0015"}, d2 = {"Lio/ktor/utils/io/core/Input;", "", "i", "(Lio/ktor/utils/io/core/Input;)S", "j", "", "e", "(Lio/ktor/utils/io/core/Input;)I", "f", "", "g", "(Lio/ktor/utils/io/core/Input;)J", "h", "", "c", "(Lio/ktor/utils/io/core/Input;)F", "d", "", "a", "(Lio/ktor/utils/io/core/Input;)D", "b", "ktor-io"}, k = 2, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nInputPrimitives.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InputPrimitives.kt\nio/ktor/utils/io/core/InputPrimitivesKt\n+ 2 Input.kt\nio/ktor/utils/io/core/Input\n+ 3 MemoryPrimitivesJvm.kt\nio/ktor/utils/io/bits/MemoryPrimitivesJvmKt\n*L\n1#1,74:1\n58#1:75\n59#1,3:77\n64#1:81\n69#1,4:82\n58#1:86\n59#1,3:88\n64#1:92\n69#1,4:93\n58#1:97\n59#1,3:99\n64#1:103\n69#1,4:104\n58#1:108\n59#1,3:110\n64#1:114\n69#1,4:115\n58#1:119\n59#1,3:121\n64#1:125\n69#1,4:126\n77#2:76\n77#2:87\n77#2:98\n77#2:109\n77#2:120\n77#2:130\n8#3:80\n16#3:91\n24#3:102\n32#3:113\n40#3:124\n*S KotlinDebug\n*F\n+ 1 InputPrimitives.kt\nio/ktor/utils/io/core/InputPrimitivesKt\n*L\n8#1:75\n8#1:77,3\n8#1:81\n13#1:82,4\n18#1:86\n18#1:88,3\n18#1:92\n23#1:93,4\n28#1:97\n28#1:99,3\n28#1:103\n33#1:104,4\n38#1:108\n38#1:110,3\n38#1:114\n43#1:115,4\n48#1:119\n48#1:121,3\n48#1:125\n53#1:126,4\n8#1:76\n18#1:87\n28#1:98\n38#1:109\n48#1:120\n58#1:130\n8#1:80\n18#1:91\n28#1:102\n38#1:113\n48#1:124\n*E\n"})
public final class InputPrimitivesKt {
    public static final double a(Input input) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        if (input.f0() - input.p0() <= 8) {
            return b(input);
        }
        int p0 = input.p0();
        input.O0(p0 + 8);
        return input.i0().getDouble(p0);
    }

    public static final double b(Input input) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        ChunkBuffer b = UnsafeKt.b(input, 8);
        if (b != null) {
            double a2 = BufferPrimitivesKt.a(b);
            UnsafeKt.a(input, b);
            return a2;
        }
        StringsKt.a(8);
        throw new KotlinNothingValueException();
    }

    public static final float c(Input input) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        if (input.f0() - input.p0() <= 4) {
            return d(input);
        }
        int p0 = input.p0();
        input.O0(p0 + 4);
        return input.i0().getFloat(p0);
    }

    public static final float d(Input input) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        ChunkBuffer b = UnsafeKt.b(input, 4);
        if (b != null) {
            float b2 = BufferPrimitivesKt.b(b);
            UnsafeKt.a(input, b);
            return b2;
        }
        StringsKt.a(4);
        throw new KotlinNothingValueException();
    }

    public static final int e(Input input) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        if (input.f0() - input.p0() <= 4) {
            return f(input);
        }
        int p0 = input.p0();
        input.O0(p0 + 4);
        return input.i0().getInt(p0);
    }

    public static final int f(Input input) {
        ChunkBuffer b = UnsafeKt.b(input, 4);
        if (b != null) {
            int e = BufferPrimitivesKt.e(b);
            UnsafeKt.a(input, b);
            return e;
        }
        StringsKt.a(4);
        throw new KotlinNothingValueException();
    }

    public static final long g(Input input) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        if (input.f0() - input.p0() <= 8) {
            return h(input);
        }
        int p0 = input.p0();
        input.O0(p0 + 8);
        return input.i0().getLong(p0);
    }

    public static final long h(Input input) {
        ChunkBuffer b = UnsafeKt.b(input, 8);
        if (b != null) {
            long f = BufferPrimitivesKt.f(b);
            UnsafeKt.a(input, b);
            return f;
        }
        StringsKt.a(8);
        throw new KotlinNothingValueException();
    }

    public static final short i(Input input) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        if (input.f0() - input.p0() <= 2) {
            return j(input);
        }
        int p0 = input.p0();
        input.O0(p0 + 2);
        return input.i0().getShort(p0);
    }

    public static final short j(Input input) {
        ChunkBuffer b = UnsafeKt.b(input, 2);
        if (b != null) {
            short g = BufferPrimitivesKt.g(b);
            UnsafeKt.a(input, b);
            return g;
        }
        StringsKt.a(2);
        throw new KotlinNothingValueException();
    }
}
