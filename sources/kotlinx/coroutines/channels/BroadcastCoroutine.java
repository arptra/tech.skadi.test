package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import kotlinx.coroutines.JobCancellationException;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.channels.SendChannel;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0012\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00028\u00000\u00042\b\u0012\u0004\u0012\u00028\u00000\u0005J5\u0010\f\u001a\u00020\u00032#\u0010\u000b\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00030\u0006H\u0001¢\u0006\u0004\b\f\u0010\rJ\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00028\u0000HAø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J'\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u00142\u0006\u0010\u0011\u001a\u00028\u0000H\u0001ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u0019\u001a\u00020\u00032\u000e\u0010\n\u001a\n\u0018\u00010\u0017j\u0004\u0018\u0001`\u0018¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010\"\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010!\u001a\u00020 H\u0014¢\u0006\u0004\b\"\u0010#J\u0019\u0010$\u001a\u00020 2\b\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b$\u0010%R \u0010*\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058\u0004X\u0004¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u0014\u0010-\u001a\u00020 8\u0016X\u0005¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0014\u0010.\u001a\u00020 8VX\u0004¢\u0006\u0006\u001a\u0004\b.\u0010,R\u001a\u00102\u001a\b\u0012\u0004\u0012\u00028\u00000/8VX\u0004¢\u0006\u0006\u001a\u0004\b0\u00101\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u00063"}, d2 = {"Lkotlinx/coroutines/channels/BroadcastCoroutine;", "E", "Lkotlinx/coroutines/AbstractCoroutine;", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Lkotlinx/coroutines/channels/BroadcastChannel;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "handler", "p", "(Lkotlin/jvm/functions/Function1;)V", "Lkotlinx/coroutines/channels/ReceiveChannel;", "l", "()Lkotlinx/coroutines/channels/ReceiveChannel;", "element", "L", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/ChannelResult;", "q", "(Ljava/lang/Object;)Ljava/lang/Object;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "a", "(Ljava/util/concurrent/CancellationException;)V", "e0", "(Ljava/lang/Throwable;)V", "value", "t1", "(Lkotlin/Unit;)V", "", "handled", "p1", "(Ljava/lang/Throwable;Z)V", "h", "(Ljava/lang/Throwable;)Z", "d", "Lkotlinx/coroutines/channels/BroadcastChannel;", "s1", "()Lkotlinx/coroutines/channels/BroadcastChannel;", "_channel", "A", "()Z", "isClosedForSend", "isActive", "Lkotlinx/coroutines/channels/SendChannel;", "b", "()Lkotlinx/coroutines/channels/SendChannel;", "channel", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nBroadcast.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Broadcast.kt\nkotlinx/coroutines/channels/BroadcastCoroutine\n+ 2 JobSupport.kt\nkotlinx/coroutines/JobSupport\n*L\n1#1,202:1\n706#2,2:203\n706#2,2:205\n*S KotlinDebug\n*F\n+ 1 Broadcast.kt\nkotlinx/coroutines/channels/BroadcastCoroutine\n*L\n152#1:203,2\n157#1:205,2\n*E\n"})
class BroadcastCoroutine<E> extends AbstractCoroutine<Unit> implements ProducerScope<E>, BroadcastChannel<E> {
    public final BroadcastChannel d;

    public boolean A() {
        return this.d.A();
    }

    public Object L(Object obj, Continuation continuation) {
        return this.d.L(obj, continuation);
    }

    public final void a(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new JobCancellationException(j0(), (Throwable) null, this);
        }
        e0(cancellationException);
    }

    public SendChannel b() {
        return this;
    }

    public void e0(Throwable th) {
        CancellationException h1 = JobSupport.h1(this, th, (String) null, 1, (Object) null);
        this.d.a(h1);
        a0(h1);
    }

    public boolean h(Throwable th) {
        boolean h = this.d.h(th);
        start();
        return h;
    }

    public boolean isActive() {
        return super.isActive();
    }

    public ReceiveChannel l() {
        return this.d.l();
    }

    public void p(Function1 function1) {
        this.d.p(function1);
    }

    public void p1(Throwable th, boolean z) {
        if (!this.d.h(th) && !z) {
            CoroutineExceptionHandlerKt.a(getContext(), th);
        }
    }

    public Object q(Object obj) {
        return this.d.q(obj);
    }

    public final BroadcastChannel s1() {
        return this.d;
    }

    /* renamed from: t1 */
    public void q1(Unit unit) {
        SendChannel.DefaultImpls.a(this.d, (Throwable) null, 1, (Object) null);
    }
}
