package io.ktor.utils.io.core.internal;

import com.honey.account.i.a;
import io.ktor.utils.io.bits.Memory;
import io.ktor.utils.io.core.Buffer;
import io.ktor.utils.io.core.BufferFactoryKt;
import io.ktor.utils.io.pool.ObjectPool;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension({"SMAP\nChunkBuffer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ChunkBuffer.kt\nio/ktor/utils/io/core/internal/ChunkBuffer\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 AtomicFU.common.kt\nkotlinx/atomicfu/AtomicFU_commonKt\n*L\n1#1,180:1\n1#2:181\n360#3,4:182\n360#3,4:186\n382#3,4:190\n*S KotlinDebug\n*F\n+ 1 ChunkBuffer.kt\nio/ktor/utils/io/core/internal/ChunkBuffer\n*L\n89#1:182,4\n99#1:186,4\n116#1:190,4\n*E\n"})
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0006\b\u0017\u0018\u0000 +2\u00020\u0001:\u0001,B,\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0000\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0005ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u001d\u0010\u000e\u001a\u00020\r2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00000\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\rH\u0000¢\u0006\u0004\b\u0012\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\rH\u0000¢\u0006\u0004\b\u0013\u0010\u0011J\u000f\u0010\u0015\u001a\u00020\u0014H\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\r¢\u0006\u0004\b\u0017\u0010\u0011J\u0017\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0019\u0010\u001aR\"\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u00058\u0000X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR(\u0010\u0004\u001a\u0004\u0018\u00010\u00002\b\u0010\u001f\u001a\u0004\u0018\u00010\u00008\u0006@BX\u000e¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010\nR(\u0010&\u001a\u0004\u0018\u00010\u00002\b\u0010#\u001a\u0004\u0018\u00010\u00008F@FX\u000e¢\u0006\f\u001a\u0004\b$\u0010\n\"\u0004\b%\u0010\u001aR\u0011\u0010*\u001a\u00020'8F¢\u0006\u0006\u001a\u0004\b(\u0010)\u0002\u0004\n\u0002\b\u0019¨\u0006-"}, d2 = {"Lio/ktor/utils/io/core/internal/ChunkBuffer;", "Lio/ktor/utils/io/core/Buffer;", "Lio/ktor/utils/io/bits/Memory;", "memory", "origin", "Lio/ktor/utils/io/pool/ObjectPool;", "parentPool", "<init>", "(Ljava/nio/ByteBuffer;Lio/ktor/utils/io/core/internal/ChunkBuffer;Lio/ktor/utils/io/pool/ObjectPool;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "A", "()Lio/ktor/utils/io/core/internal/ChunkBuffer;", "B", "pool", "", "F", "(Lio/ktor/utils/io/pool/ObjectPool;)V", "I", "()V", "y", "J", "", "G", "()Z", "r", "chunk", "z", "(Lio/ktor/utils/io/core/internal/ChunkBuffer;)V", "h", "Lio/ktor/utils/io/pool/ObjectPool;", "getParentPool$ktor_io", "()Lio/ktor/utils/io/pool/ObjectPool;", "<set-?>", "i", "Lio/ktor/utils/io/core/internal/ChunkBuffer;", "D", "newValue", "C", "H", "next", "", "E", "()I", "referenceCount", "j", "Companion", "ktor-io"}, k = 1, mv = {1, 8, 0})
@Deprecated(message = "\n    We're migrating to the new kotlinx-io library.\n    This declaration is deprecated and will be removed in Ktor 4.0.0\n    If you have any problems with migration, please contact us in \n    https://youtrack.jetbrains.com/issue/KTOR-6030/Migrate-to-new-kotlinx.io-library\n    ")
public class ChunkBuffer extends Buffer {
    public static final Companion j = new Companion((DefaultConstructorMarker) null);
    public static final /* synthetic */ AtomicReferenceFieldUpdater k;
    public static final /* synthetic */ AtomicIntegerFieldUpdater l;
    public static final ObjectPool m;
    public static final ChunkBuffer n;
    public static final ObjectPool o = new ChunkBuffer$Companion$NoPool$1();
    public static final ObjectPool p = new ChunkBuffer$Companion$NoPoolManuallyManaged$1();
    public final ObjectPool h;
    public ChunkBuffer i;
    @NotNull
    private volatile /* synthetic */ Object nextRef;
    @NotNull
    private volatile /* synthetic */ int refCount;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\u0007R\u0017\u0010\f\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lio/ktor/utils/io/core/internal/ChunkBuffer$Companion;", "", "<init>", "()V", "Lio/ktor/utils/io/pool/ObjectPool;", "Lio/ktor/utils/io/core/internal/ChunkBuffer;", "c", "()Lio/ktor/utils/io/pool/ObjectPool;", "Pool", "EmptyPool", "Lio/ktor/utils/io/pool/ObjectPool;", "b", "Empty", "Lio/ktor/utils/io/core/internal/ChunkBuffer;", "a", "()Lio/ktor/utils/io/core/internal/ChunkBuffer;", "ktor-io"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ChunkBuffer a() {
            return ChunkBuffer.n;
        }

        public final ObjectPool b() {
            return ChunkBuffer.m;
        }

        public final ObjectPool c() {
            return BufferFactoryKt.a();
        }

        public Companion() {
        }
    }

    static {
        ChunkBuffer$Companion$EmptyPool$1 chunkBuffer$Companion$EmptyPool$1 = new ChunkBuffer$Companion$EmptyPool$1();
        m = chunkBuffer$Companion$EmptyPool$1;
        n = new ChunkBuffer(Memory.b.a(), (ChunkBuffer) null, chunkBuffer$Companion$EmptyPool$1, (DefaultConstructorMarker) null);
        Class<ChunkBuffer> cls = ChunkBuffer.class;
        k = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "nextRef");
        l = AtomicIntegerFieldUpdater.newUpdater(cls, "refCount");
    }

    public /* synthetic */ ChunkBuffer(ByteBuffer byteBuffer, ChunkBuffer chunkBuffer, ObjectPool objectPool, DefaultConstructorMarker defaultConstructorMarker) {
        this(byteBuffer, chunkBuffer, objectPool);
    }

    public final ChunkBuffer A() {
        return (ChunkBuffer) k.getAndSet(this, (Object) null);
    }

    public ChunkBuffer B() {
        ChunkBuffer chunkBuffer = this.i;
        if (chunkBuffer == null) {
            chunkBuffer = this;
        }
        chunkBuffer.y();
        ChunkBuffer chunkBuffer2 = new ChunkBuffer(h(), chunkBuffer, this.h, (DefaultConstructorMarker) null);
        e(chunkBuffer2);
        return chunkBuffer2;
    }

    public final ChunkBuffer C() {
        return (ChunkBuffer) this.nextRef;
    }

    public final ChunkBuffer D() {
        return this.i;
    }

    public final int E() {
        return this.refCount;
    }

    public void F(ObjectPool objectPool) {
        Intrinsics.checkNotNullParameter(objectPool, "pool");
        if (G()) {
            ChunkBuffer chunkBuffer = this.i;
            if (chunkBuffer != null) {
                I();
                chunkBuffer.F(objectPool);
                return;
            }
            ObjectPool objectPool2 = this.h;
            if (objectPool2 != null) {
                objectPool = objectPool2;
            }
            objectPool.recycle(this);
        }
    }

    public final boolean G() {
        int i2;
        int i3;
        do {
            i2 = this.refCount;
            if (i2 > 0) {
                i3 = i2 - 1;
            } else {
                throw new IllegalStateException("Unable to release: it is already released.");
            }
        } while (!l.compareAndSet(this, i2, i3));
        return i3 == 0;
    }

    public final void H(ChunkBuffer chunkBuffer) {
        if (chunkBuffer == null) {
            A();
        } else {
            z(chunkBuffer);
        }
    }

    public final void I() {
        if (l.compareAndSet(this, 0, -1)) {
            A();
            this.i = null;
            return;
        }
        throw new IllegalStateException("Unable to unlink: buffer is in use.");
    }

    public final void J() {
        int i2;
        do {
            i2 = this.refCount;
            if (i2 < 0) {
                throw new IllegalStateException("This instance is already disposed and couldn't be borrowed.");
            } else if (i2 > 0) {
                throw new IllegalStateException("This instance is already in use but somehow appeared in the pool.");
            }
        } while (!l.compareAndSet(this, i2, 1));
    }

    public final void r() {
        if (this.i == null) {
            super.r();
            this.nextRef = null;
            return;
        }
        throw new IllegalArgumentException("Unable to reset buffer with origin".toString());
    }

    public final void y() {
        int i2;
        do {
            i2 = this.refCount;
            if (i2 > 0) {
            } else {
                throw new IllegalStateException("Unable to acquire chunk: it is already released.");
            }
        } while (!l.compareAndSet(this, i2, i2 + 1));
    }

    public final void z(ChunkBuffer chunkBuffer) {
        if (!a.a(k, this, (Object) null, chunkBuffer)) {
            throw new IllegalStateException("This chunk has already a next chunk.");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChunkBuffer(ByteBuffer byteBuffer, ChunkBuffer chunkBuffer, ObjectPool objectPool) {
        super(byteBuffer, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(byteBuffer, "memory");
        this.h = objectPool;
        if (chunkBuffer != this) {
            this.nextRef = null;
            this.refCount = 1;
            this.i = chunkBuffer;
            return;
        }
        throw new IllegalArgumentException("A chunk couldn't be a view of itself.".toString());
    }
}
