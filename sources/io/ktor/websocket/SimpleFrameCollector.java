package io.ktor.websocket;

import io.ktor.util.NIOKt;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001J\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0010\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0011R\u001c\u0010\u0014\u001a\n \u0013*\u0004\u0018\u00010\u00040\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0011R\u0011\u0010\u0017\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0016¨\u0006\u0018"}, d2 = {"Lio/ktor/websocket/SimpleFrameCollector;", "", "", "length", "Ljava/nio/ByteBuffer;", "bb", "", "c", "(ILjava/nio/ByteBuffer;)V", "b", "(Ljava/nio/ByteBuffer;)V", "maskKey", "d", "(Ljava/lang/Integer;)Ljava/nio/ByteBuffer;", "a", "I", "remaining", "Ljava/nio/ByteBuffer;", "buffer", "kotlin.jvm.PlatformType", "maskBuffer", "", "()Z", "hasRemaining", "ktor-websockets"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nSimpleFrameCollector.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SimpleFrameCollector.kt\nio/ktor/websocket/SimpleFrameCollector\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,52:1\n1#2:53\n*E\n"})
public final class SimpleFrameCollector {

    /* renamed from: a  reason: collision with root package name */
    public int f9139a;
    public ByteBuffer b;
    public final ByteBuffer c;

    public final boolean a() {
        return this.f9139a > 0;
    }

    public final void b(ByteBuffer byteBuffer) {
        Intrinsics.checkNotNullParameter(byteBuffer, "bb");
        int i = this.f9139a;
        ByteBuffer byteBuffer2 = this.b;
        Intrinsics.checkNotNull(byteBuffer2);
        this.f9139a = i - NIOKt.c(byteBuffer, byteBuffer2, this.f9139a);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0016, code lost:
        if (r0.capacity() < r2) goto L_0x0018;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(int r2, java.nio.ByteBuffer r3) {
        /*
            r1 = this;
            java.lang.String r0 = "bb"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            int r0 = r1.f9139a
            if (r0 != 0) goto L_0x002a
            r1.f9139a = r2
            java.nio.ByteBuffer r0 = r1.b
            if (r0 == 0) goto L_0x0018
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            int r0 = r0.capacity()
            if (r0 >= r2) goto L_0x001e
        L_0x0018:
            java.nio.ByteBuffer r2 = java.nio.ByteBuffer.allocate(r2)
            r1.b = r2
        L_0x001e:
            java.nio.ByteBuffer r2 = r1.b
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            r2.clear()
            r1.b(r3)
            return
        L_0x002a:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "remaining should be 0"
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.SimpleFrameCollector.c(int, java.nio.ByteBuffer):void");
    }

    public final ByteBuffer d(Integer num) {
        ByteBuffer byteBuffer = this.b;
        Intrinsics.checkNotNull(byteBuffer);
        byteBuffer.flip();
        ByteBuffer slice = byteBuffer.slice();
        if (num != null) {
            this.c.clear();
            this.c.asIntBuffer().put(num.intValue());
            this.c.clear();
            Intrinsics.checkNotNullExpressionValue(slice, "view");
            ByteBuffer byteBuffer2 = this.c;
            Intrinsics.checkNotNullExpressionValue(byteBuffer2, "maskBuffer");
            UtilsKt.b(slice, byteBuffer2);
        }
        this.b = null;
        ByteBuffer asReadOnlyBuffer = slice.asReadOnlyBuffer();
        Intrinsics.checkNotNullExpressionValue(asReadOnlyBuffer, "buffer!!.run {\n        f….asReadOnlyBuffer()\n    }");
        return asReadOnlyBuffer;
    }
}
