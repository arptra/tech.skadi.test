package io.ktor.utils.io.core.internal;

import kotlin.Metadata;
import kotlin.UShort;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\b@\u0018\u00002\u00020\u0001B\u001c\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006B\u0012\u0012\u0006\u0010\b\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000b\u001a\u00020\u0002H\u0002ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\r\u001a\u00020\u0002H\u0002ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b\r\u0010\fJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u0011\u0010\nJ\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0003\u001a\u00020\u00028Fø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0019\u0010\fR\u001a\u0010\u0004\u001a\u00020\u00028Fø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u001a\u0010\f\u0001\b\u0001\u00020\u0007ø\u0001\u0000\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u001b"}, d2 = {"Lio/ktor/utils/io/core/internal/EncodeResult;", "", "Lkotlin/UShort;", "characters", "bytes", "d", "(SS)I", "", "value", "c", "(I)I", "a", "(I)S", "b", "", "i", "(I)Ljava/lang/String;", "h", "other", "", "e", "(ILjava/lang/Object;)Z", "I", "getValue", "()I", "g", "f", "ktor-io"}, k = 1, mv = {1, 8, 0})
@JvmInline
@SourceDebugExtension({"SMAP\nEncodeResult.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EncodeResult.kt\nio/ktor/utils/io/core/internal/EncodeResult\n+ 2 ByteOrder.kt\nio/ktor/utils/io/bits/ByteOrderKt\n*L\n1#1,20:1\n47#2:21\n49#2:22\n*S KotlinDebug\n*F\n+ 1 EncodeResult.kt\nio/ktor/utils/io/core/internal/EncodeResult\n*L\n14#1:21\n15#1:22\n*E\n"})
public final class EncodeResult {

    /* renamed from: a  reason: collision with root package name */
    public final int f9095a;

    public static final short a(int i) {
        return g(i);
    }

    public static final short b(int i) {
        return f(i);
    }

    public static int c(int i) {
        return i;
    }

    public static int d(short s, short s2) {
        return c(((s & UShort.MAX_VALUE) << 16) | (s2 & UShort.MAX_VALUE));
    }

    public static boolean e(int i, Object obj) {
        return (obj instanceof EncodeResult) && i == ((EncodeResult) obj).j();
    }

    public static final short f(int i) {
        return UShort.m301constructorimpl((short) (i & 65535));
    }

    public static final short g(int i) {
        return UShort.m301constructorimpl((short) (i >>> 16));
    }

    public static int h(int i) {
        return Integer.hashCode(i);
    }

    public static String i(int i) {
        return "EncodeResult(value=" + i + ')';
    }

    public boolean equals(Object obj) {
        return e(this.f9095a, obj);
    }

    public int hashCode() {
        return h(this.f9095a);
    }

    public final /* synthetic */ int j() {
        return this.f9095a;
    }

    public String toString() {
        return i(this.f9095a);
    }
}
