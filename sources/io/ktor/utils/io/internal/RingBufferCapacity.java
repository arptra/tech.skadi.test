package io.ktor.utils.io.internal;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0001\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\bJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000e\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\n\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000fJ\u0015\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\rJ\u0015\u0010\u0011\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u000fJ\u0015\u0010\u0012\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0005J\u0015\u0010\u0013\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0005J\r\u0010\u0014\u001a\u00020\u000b¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0016\u001a\u00020\u000b¢\u0006\u0004\b\u0016\u0010\u0015J\r\u0010\u0017\u001a\u00020\u0006¢\u0006\u0004\b\u0017\u0010\bJ\r\u0010\u0018\u001a\u00020\u000b¢\u0006\u0004\b\u0018\u0010\u0015J\r\u0010\u0019\u001a\u00020\u000b¢\u0006\u0004\b\u0019\u0010\u0015J\u000f\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ'\u0010 \u001a\u00020\u001f2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0002¢\u0006\u0004\b \u0010!J\u001f\u0010#\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0002¢\u0006\u0004\b#\u0010$R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010%¨\u0006&"}, d2 = {"Lio/ktor/utils/io/internal/RingBufferCapacity;", "", "", "totalCapacity", "<init>", "(I)V", "", "j", "()V", "i", "n", "", "m", "(I)Z", "l", "(I)I", "p", "o", "a", "c", "e", "()Z", "k", "f", "g", "h", "", "toString", "()Ljava/lang/String;", "remaining", "update", "", "b", "(III)Ljava/lang/Void;", "pending", "d", "(II)Ljava/lang/Void;", "I", "ktor-io"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nRingBufferCapacity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RingBufferCapacity.kt\nio/ktor/utils/io/internal/RingBufferCapacity\n+ 2 AtomicFU.common.kt\nkotlinx/atomicfu/AtomicFU_commonKt\n*L\n1#1,152:1\n24#1:188\n12#1:189\n12#1,7:191\n24#1:198\n371#2,4:153\n360#2,4:157\n371#2,4:161\n371#2,4:165\n360#2,4:169\n371#2,4:173\n360#2,4:177\n360#2,4:181\n360#2,3:185\n363#2:190\n*S KotlinDebug\n*F\n+ 1 RingBufferCapacity.kt\nio/ktor/utils/io/internal/RingBufferCapacity\n*L\n130#1:188\n130#1:189\n149#1:191,7\n150#1:198\n43#1:153,4\n51#1:157,4\n59#1:161,4\n68#1:165,4\n76#1:169,4\n84#1:173,4\n93#1:177,4\n105#1:181,4\n129#1:185,3\n129#1:190\n*E\n"})
public final class RingBufferCapacity {
    public static final /* synthetic */ AtomicIntegerFieldUpdater b;
    public static final /* synthetic */ AtomicIntegerFieldUpdater c;
    public static final /* synthetic */ AtomicIntegerFieldUpdater d;
    @NotNull
    public volatile /* synthetic */ int _availableForRead$internal = 0;
    @NotNull
    public volatile /* synthetic */ int _availableForWrite$internal;
    @NotNull
    volatile /* synthetic */ int _pendingToFlush;

    /* renamed from: a  reason: collision with root package name */
    public final int f9105a;

    static {
        Class<RingBufferCapacity> cls = RingBufferCapacity.class;
        b = AtomicIntegerFieldUpdater.newUpdater(cls, "_availableForRead$internal");
        c = AtomicIntegerFieldUpdater.newUpdater(cls, "_availableForWrite$internal");
        d = AtomicIntegerFieldUpdater.newUpdater(cls, "_pendingToFlush");
    }

    public RingBufferCapacity(int i) {
        this.f9105a = i;
        this._availableForWrite$internal = i;
        this._pendingToFlush = 0;
    }

    public final void a(int i) {
        int i2;
        int i3;
        do {
            i2 = this._availableForWrite$internal;
            i3 = i2 + i;
            if (i3 > this.f9105a) {
                b(i2, i3, i);
                throw new KotlinNothingValueException();
            }
        } while (!c.compareAndSet(this, i2, i3));
    }

    public final Void b(int i, int i2, int i3) {
        throw new IllegalArgumentException("Completed read overflow: " + i + " + " + i3 + " = " + i2 + " > " + this.f9105a);
    }

    public final void c(int i) {
        int i2;
        int i3;
        do {
            i2 = this._pendingToFlush;
            i3 = i2 + i;
            if (i3 > this.f9105a) {
                d(i2, i);
                throw new KotlinNothingValueException();
            }
        } while (!d.compareAndSet(this, i2, i3));
    }

    public final Void d(int i, int i2) {
        throw new IllegalArgumentException("Complete write overflow: " + i + " + " + i2 + " > " + this.f9105a);
    }

    public final boolean e() {
        int andSet = d.getAndSet(this, 0);
        return andSet == 0 ? this._availableForRead$internal > 0 : b.addAndGet(this, andSet) > 0;
    }

    public final void f() {
        c.getAndSet(this, 0);
    }

    public final boolean g() {
        return this._availableForWrite$internal == this.f9105a;
    }

    public final boolean h() {
        return this._availableForWrite$internal == 0;
    }

    public final void i() {
        this._availableForRead$internal = this.f9105a;
        this._availableForWrite$internal = 0;
        this._pendingToFlush = 0;
    }

    public final void j() {
        this._availableForRead$internal = 0;
        this._pendingToFlush = 0;
        this._availableForWrite$internal = this.f9105a;
    }

    public final boolean k() {
        int i;
        do {
            i = this._availableForWrite$internal;
            if (this._pendingToFlush > 0 || this._availableForRead$internal > 0 || i != this.f9105a) {
                return false;
            }
        } while (!c.compareAndSet(this, i, 0));
        return true;
    }

    public final int l(int i) {
        int i2;
        int min;
        do {
            i2 = this._availableForRead$internal;
            min = Math.min(i, i2);
            if (min == 0) {
                return 0;
            }
        } while (!b.compareAndSet(this, i2, i2 - min));
        return Math.min(i, i2);
    }

    public final boolean m(int i) {
        int i2;
        do {
            i2 = this._availableForRead$internal;
            if (i2 < i) {
                return false;
            }
        } while (!b.compareAndSet(this, i2, i2 - i));
        return true;
    }

    public final int n(int i) {
        int i2;
        do {
            i2 = this._availableForWrite$internal;
            if (i2 < i) {
                return 0;
            }
        } while (!c.compareAndSet(this, i2, 0));
        return i2;
    }

    public final int o(int i) {
        int i2;
        int min;
        do {
            i2 = this._availableForWrite$internal;
            min = Math.min(i, i2);
            if (min == 0) {
                return 0;
            }
        } while (!c.compareAndSet(this, i2, i2 - min));
        return Math.min(i, i2);
    }

    public final boolean p(int i) {
        int i2;
        do {
            i2 = this._availableForWrite$internal;
            if (i2 < i) {
                return false;
            }
        } while (!c.compareAndSet(this, i2, i2 - i));
        return true;
    }

    public String toString() {
        return "RingBufferCapacity[read: " + this._availableForRead$internal + ", write: " + this._availableForWrite$internal + ", flush: " + this._pendingToFlush + ", capacity: " + this.f9105a + ']';
    }
}
