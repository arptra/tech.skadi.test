package io.ktor.utils.io.core;

import io.ktor.utils.io.utils.AtomicKt;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\"\u0017\u0010\u0004\u001a\u00020\u00008\u0006¢\u0006\f\n\u0004\b\u0001\u0010\u0002\u001a\u0004\b\u0001\u0010\u0003*\n\u0010\u0006\"\u00020\u00052\u00020\u0005¨\u0006\u0007"}, d2 = {"", "a", "I", "()I", "PACKET_MAX_COPY_SIZE", "Ljava/io/EOFException;", "EOFException", "ktor-io"}, k = 2, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nPacketJVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PacketJVM.kt\nio/ktor/utils/io/core/PacketJVMKt\n+ 2 Buffers.kt\nio/ktor/utils/io/core/BuffersKt\n*L\n1#1,31:1\n98#2,2:32\n*S KotlinDebug\n*F\n+ 1 PacketJVM.kt\nio/ktor/utils/io/core/PacketJVMKt\n*L\n18#1:32,2\n*E\n"})
public final class PacketJVMKt {

    /* renamed from: a  reason: collision with root package name */
    public static final int f9093a = AtomicKt.a("max.copy.size", 500);

    public static final int a() {
        return f9093a;
    }
}
