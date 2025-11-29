package kotlinx.coroutines.channels;

import com.honey.account.u1.c;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.Segment;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00000\u0002B7\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00028\u0000H\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\bH\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\bH\u0000¢\u0006\u0004\b\u0013\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\bH\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\f\u001a\u00020\bH\u0000¢\u0006\u0004\b\u0017\u0010\u0012J!\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0016H\u0000¢\u0006\u0004\b\u0019\u0010\u0010J+\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\f\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u0016H\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ#\u0010 \u001a\u0004\u0018\u00010\u00162\u0006\u0010\f\u001a\u00020\b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0016H\u0000¢\u0006\u0004\b \u0010!J)\u0010&\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\b2\b\u0010#\u001a\u0004\u0018\u00010\"2\u0006\u0010%\u001a\u00020$H\u0016¢\u0006\u0004\b&\u0010'J\u001d\u0010)\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010(\u001a\u00020\u001c¢\u0006\u0004\b)\u0010*J!\u0010+\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0004\b+\u0010\u0010R\u001c\u0010.\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00068F¢\u0006\u0006\u001a\u0004\b/\u00100R\u0014\u00103\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b1\u00102R\u0013\u00105\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u0016048\u0002X\u0004¨\u00066"}, d2 = {"Lkotlinx/coroutines/channels/ChannelSegment;", "E", "Lkotlinx/coroutines/internal/Segment;", "", "id", "prev", "Lkotlinx/coroutines/channels/BufferedChannel;", "channel", "", "pointers", "<init>", "(JLkotlinx/coroutines/channels/ChannelSegment;Lkotlinx/coroutines/channels/BufferedChannel;I)V", "index", "element", "", "B", "(ILjava/lang/Object;)V", "v", "(I)Ljava/lang/Object;", "y", "s", "(I)V", "", "w", "value", "A", "from", "to", "", "r", "(ILjava/lang/Object;Ljava/lang/Object;)Z", "update", "t", "(ILjava/lang/Object;)Ljava/lang/Object;", "", "cause", "Lkotlin/coroutines/CoroutineContext;", "context", "o", "(ILjava/lang/Throwable;Lkotlin/coroutines/CoroutineContext;)V", "receiver", "x", "(IZ)V", "z", "e", "Lkotlinx/coroutines/channels/BufferedChannel;", "_channel", "u", "()Lkotlinx/coroutines/channels/BufferedChannel;", "n", "()I", "numberOfSlots", "Lkotlinx/atomicfu/AtomicArray;", "data", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nBufferedChannel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BufferedChannel.kt\nkotlinx/coroutines/channels/ChannelSegment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,3055:1\n1#2:3056\n*E\n"})
public final class ChannelSegment<E> extends Segment<ChannelSegment<E>> {
    public final BufferedChannel e;
    public final AtomicReferenceArray f = new AtomicReferenceArray(BufferedChannelKt.b * 2);

    public ChannelSegment(long j, ChannelSegment channelSegment, BufferedChannel bufferedChannel, int i) {
        super(j, channelSegment, i);
        this.e = bufferedChannel;
    }

    public final void A(int i, Object obj) {
        this.f.set((i * 2) + 1, obj);
    }

    public final void B(int i, Object obj) {
        z(i, obj);
    }

    public int n() {
        return BufferedChannelKt.b;
    }

    public void o(int i, Throwable th, CoroutineContext coroutineContext) {
        Function1 function1;
        Function1 function12;
        int i2 = BufferedChannelKt.b;
        boolean z = i >= i2;
        if (z) {
            i -= i2;
        }
        Object v = v(i);
        while (true) {
            Object w = w(i);
            if ((w instanceof Waiter) || (w instanceof WaiterEB)) {
                if (r(i, w, z ? BufferedChannelKt.j : BufferedChannelKt.k)) {
                    s(i);
                    x(i, !z);
                    if (z && (function1 = u().b) != null) {
                        OnUndeliveredElementKt.b(function1, v, coroutineContext);
                        return;
                    }
                    return;
                }
            } else if (w == BufferedChannelKt.j || w == BufferedChannelKt.k) {
                s(i);
            } else if (!(w == BufferedChannelKt.g || w == BufferedChannelKt.f)) {
                if (w != BufferedChannelKt.i && w != BufferedChannelKt.d && w != BufferedChannelKt.z()) {
                    throw new IllegalStateException(("unexpected state: " + w).toString());
                }
                return;
            }
        }
        s(i);
        if (z && (function12 = u().b) != null) {
            OnUndeliveredElementKt.b(function12, v, coroutineContext);
        }
    }

    public final boolean r(int i, Object obj, Object obj2) {
        return c.a(this.f, (i * 2) + 1, obj, obj2);
    }

    public final void s(int i) {
        z(i, (Object) null);
    }

    public final Object t(int i, Object obj) {
        return this.f.getAndSet((i * 2) + 1, obj);
    }

    public final BufferedChannel u() {
        BufferedChannel bufferedChannel = this.e;
        Intrinsics.checkNotNull(bufferedChannel);
        return bufferedChannel;
    }

    public final Object v(int i) {
        return this.f.get(i * 2);
    }

    public final Object w(int i) {
        return this.f.get((i * 2) + 1);
    }

    public final void x(int i, boolean z) {
        if (z) {
            u().i1((this.c * ((long) BufferedChannelKt.b)) + ((long) i));
        }
        p();
    }

    public final Object y(int i) {
        Object v = v(i);
        s(i);
        return v;
    }

    public final void z(int i, Object obj) {
        this.f.lazySet(i * 2, obj);
    }
}
