package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.ObsoleteCoroutinesApi;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002J\"\u0010\u0007\u001a\u00020\u00062\u0010\b\u0002\u0010\u0005\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u0004H\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\tH\u0001¢\u0006\u0004\b\u000b\u0010\fJ5\u0010\u0011\u001a\u00020\u00062#\u0010\u0010\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\rH\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013H\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001b\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00028\u0000HAø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u00192\u0006\u0010\u0016\u001a\u00028\u0000H\u0001ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001c8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u001dR\u0014\u0010!\u001a\u00020\n8\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u001f\u0010 \u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\""}, d2 = {"Lkotlinx/coroutines/channels/ConflatedBroadcastChannel;", "E", "Lkotlinx/coroutines/channels/BroadcastChannel;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cause", "", "a", "(Ljava/util/concurrent/CancellationException;)V", "", "", "h", "(Ljava/lang/Throwable;)Z", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "handler", "p", "(Lkotlin/jvm/functions/Function1;)V", "Lkotlinx/coroutines/channels/ReceiveChannel;", "l", "()Lkotlinx/coroutines/channels/ReceiveChannel;", "element", "L", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/ChannelResult;", "q", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/BroadcastChannelImpl;", "Lkotlinx/coroutines/channels/BroadcastChannelImpl;", "broadcast", "A", "()Z", "isClosedForSend", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0})
@Deprecated(level = DeprecationLevel.WARNING, message = "ConflatedBroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported")
@ObsoleteCoroutinesApi
public final class ConflatedBroadcastChannel<E> implements BroadcastChannel<E> {

    /* renamed from: a  reason: collision with root package name */
    public final BroadcastChannelImpl f3758a;

    public boolean A() {
        return this.f3758a.A();
    }

    public Object L(Object obj, Continuation continuation) {
        return this.f3758a.L(obj, continuation);
    }

    public void a(CancellationException cancellationException) {
        this.f3758a.a(cancellationException);
    }

    public boolean h(Throwable th) {
        return this.f3758a.h(th);
    }

    public ReceiveChannel l() {
        return this.f3758a.l();
    }

    public void p(Function1 function1) {
        this.f3758a.p(function1);
    }

    public Object q(Object obj) {
        return this.f3758a.q(obj);
    }
}
