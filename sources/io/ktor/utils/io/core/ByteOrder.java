package io.ktor.utils.io.core;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lio/ktor/utils/io/core/ByteOrder;", "", "nioOrder", "Ljava/nio/ByteOrder;", "(Ljava/lang/String;ILjava/nio/ByteOrder;)V", "getNioOrder", "()Ljava/nio/ByteOrder;", "BIG_ENDIAN", "LITTLE_ENDIAN", "Companion", "ktor-io"}, k = 1, mv = {1, 8, 0}, xi = 48)
public enum ByteOrder {
    BIG_ENDIAN(r1),
    LITTLE_ENDIAN(r1);
    
    @NotNull
    public static final Companion Companion = null;
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: native  reason: not valid java name */
    public static final ByteOrder f41native = null;
    @NotNull
    private final java.nio.ByteOrder nioOrder;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lio/ktor/utils/io/core/ByteOrder$Companion;", "", "<init>", "()V", "Lio/ktor/utils/io/core/ByteOrder;", "native", "Lio/ktor/utils/io/core/ByteOrder;", "ktor-io"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    static {
        Companion = new Companion((DefaultConstructorMarker) null);
        java.nio.ByteOrder nativeOrder = java.nio.ByteOrder.nativeOrder();
        Intrinsics.checkNotNullExpressionValue(nativeOrder, "nativeOrder()");
        f41native = ByteOrderJVMKt.b(nativeOrder);
    }

    private ByteOrder(java.nio.ByteOrder byteOrder) {
        this.nioOrder = byteOrder;
    }

    @NotNull
    public final java.nio.ByteOrder getNioOrder() {
        return this.nioOrder;
    }
}
