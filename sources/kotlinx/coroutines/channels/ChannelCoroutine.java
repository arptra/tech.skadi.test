package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.JobCancellationException;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectClause2;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00028\u00000\u0004B-\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0001¢\u0006\u0004\b\u000f\u0010\u0010J5\u0010\u0015\u001a\u00020\u00032#\u0010\u0014\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00030\u0011H\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017H\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0013\u0010\u001a\u001a\u00028\u0000HAø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\"\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u001cHAø\u0001\u0001ø\u0001\u0002ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001bJ\u001b\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00028\u0000HAø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 J\u001f\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\u001cH\u0001ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b!\u0010\"J'\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00030\u001c2\u0006\u0010\u001e\u001a\u00028\u0000H\u0001ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b#\u0010$J\u001d\u0010'\u001a\u00020\u00032\u000e\u0010\u000e\u001a\n\u0018\u00010%j\u0004\u0018\u0001`&¢\u0006\u0004\b'\u0010(J\u0017\u0010)\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b)\u0010*R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048\u0004X\u0004¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u0014\u00101\u001a\u00020\b8\u0016X\u0005¢\u0006\u0006\u001a\u0004\b/\u00100R\u0014\u00103\u001a\u00020\b8\u0016X\u0005¢\u0006\u0006\u001a\u0004\b2\u00100R\u001a\u00107\u001a\b\u0012\u0004\u0012\u00028\u0000048\u0016X\u0005¢\u0006\u0006\u001a\u0004\b5\u00106R#\u00109\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001c048\u0016X\u0005ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b8\u00106R&\u0010>\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000;0:8\u0016X\u0005¢\u0006\u0006\u001a\u0004\b<\u0010=R\u0017\u0010@\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048F¢\u0006\u0006\u001a\u0004\b?\u0010.\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006A"}, d2 = {"Lkotlinx/coroutines/channels/ChannelCoroutine;", "E", "Lkotlinx/coroutines/AbstractCoroutine;", "", "Lkotlinx/coroutines/channels/Channel;", "Lkotlin/coroutines/CoroutineContext;", "parentContext", "_channel", "", "initParentJob", "active", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/channels/Channel;ZZ)V", "", "cause", "h", "(Ljava/lang/Throwable;)Z", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "handler", "p", "(Lkotlin/jvm/functions/Function1;)V", "Lkotlinx/coroutines/channels/ChannelIterator;", "iterator", "()Lkotlinx/coroutines/channels/ChannelIterator;", "K", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/ChannelResult;", "y", "element", "L", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "x", "()Ljava/lang/Object;", "q", "(Ljava/lang/Object;)Ljava/lang/Object;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "a", "(Ljava/util/concurrent/CancellationException;)V", "e0", "(Ljava/lang/Throwable;)V", "d", "Lkotlinx/coroutines/channels/Channel;", "t1", "()Lkotlinx/coroutines/channels/Channel;", "D", "()Z", "isClosedForReceive", "A", "isClosedForSend", "Lkotlinx/coroutines/selects/SelectClause1;", "G", "()Lkotlinx/coroutines/selects/SelectClause1;", "onReceive", "t", "onReceiveCatching", "Lkotlinx/coroutines/selects/SelectClause2;", "Lkotlinx/coroutines/channels/SendChannel;", "k", "()Lkotlinx/coroutines/selects/SelectClause2;", "onSend", "s1", "channel", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nChannelCoroutine.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ChannelCoroutine.kt\nkotlinx/coroutines/channels/ChannelCoroutine\n+ 2 JobSupport.kt\nkotlinx/coroutines/JobSupport\n*L\n1#1,41:1\n706#2,2:42\n706#2,2:44\n706#2,2:46\n*S KotlinDebug\n*F\n+ 1 ChannelCoroutine.kt\nkotlinx/coroutines/channels/ChannelCoroutine\n*L\n21#1:42,2\n26#1:44,2\n32#1:46,2\n*E\n"})
public class ChannelCoroutine<E> extends AbstractCoroutine<Unit> implements Channel<E> {
    public final Channel d;

    public ChannelCoroutine(CoroutineContext coroutineContext, Channel channel, boolean z, boolean z2) {
        super(coroutineContext, z, z2);
        this.d = channel;
    }

    public boolean A() {
        return this.d.A();
    }

    public boolean D() {
        return this.d.D();
    }

    public SelectClause1 G() {
        return this.d.G();
    }

    public Object K(Continuation continuation) {
        return this.d.K(continuation);
    }

    public Object L(Object obj, Continuation continuation) {
        return this.d.L(obj, continuation);
    }

    public final void a(CancellationException cancellationException) {
        if (!isCancelled()) {
            if (cancellationException == null) {
                cancellationException = new JobCancellationException(j0(), (Throwable) null, this);
            }
            e0(cancellationException);
        }
    }

    public void e0(Throwable th) {
        CancellationException h1 = JobSupport.h1(this, th, (String) null, 1, (Object) null);
        this.d.a(h1);
        a0(h1);
    }

    public boolean h(Throwable th) {
        return this.d.h(th);
    }

    public ChannelIterator iterator() {
        return this.d.iterator();
    }

    public SelectClause2 k() {
        return this.d.k();
    }

    public void p(Function1 function1) {
        this.d.p(function1);
    }

    public Object q(Object obj) {
        return this.d.q(obj);
    }

    public final Channel s1() {
        return this;
    }

    public SelectClause1 t() {
        return this.d.t();
    }

    public final Channel t1() {
        return this.d;
    }

    public Object x() {
        return this.d.x();
    }

    public Object y(Continuation continuation) {
        Object y = this.d.y(continuation);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return y;
    }
}
