package kotlinx.coroutines.channels;

import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.selects.SelectInstance;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0010\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B;\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\"\b\u0002\u0010\n\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\t¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u000fJ&\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u00122\u0006\u0010\r\u001a\u00028\u0000H\u0016ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J%\u0010\u0018\u001a\u00020\b2\n\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u00152\b\u0010\r\u001a\u0004\u0018\u00010\u0017H\u0014¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0010H\u0010¢\u0006\u0004\b\u001a\u0010\u001bJ.\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\b0\u00122\u0006\u0010\r\u001a\u00028\u00002\u0006\u0010\u001c\u001a\u00020\u0010H\u0002ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ.\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\b0\u00122\u0006\u0010\r\u001a\u00028\u00002\u0006\u0010\u001c\u001a\u00020\u0010H\u0002ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010\u001eJ&\u0010 \u001a\b\u0012\u0004\u0012\u00020\b0\u00122\u0006\u0010\r\u001a\u00028\u0000H\u0002ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b \u0010\u0014R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010&\u001a\u00020\u00108TX\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u001b\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006'"}, d2 = {"Lkotlinx/coroutines/channels/ConflatedBufferedChannel;", "E", "Lkotlinx/coroutines/channels/BufferedChannel;", "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "onUndeliveredElement", "<init>", "(ILkotlinx/coroutines/channels/BufferOverflow;Lkotlin/jvm/functions/Function1;)V", "element", "L", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "T0", "Lkotlinx/coroutines/channels/ChannelResult;", "q", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "", "N0", "(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", "X0", "()Z", "isSendOp", "n1", "(Ljava/lang/Object;Z)Ljava/lang/Object;", "l1", "m1", "m", "I", "n", "Lkotlinx/coroutines/channels/BufferOverflow;", "m0", "isConflatedDropOldest", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nConflatedBufferedChannel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConflatedBufferedChannel.kt\nkotlinx/coroutines/channels/ConflatedBufferedChannel\n+ 2 Channel.kt\nkotlinx/coroutines/channels/ChannelKt\n+ 3 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel\n+ 4 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannelKt\n+ 5 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel$sendImpl$1\n*L\n1#1,119:1\n548#2,5:120\n514#2,6:125\n514#2,6:212\n548#2,5:218\n244#3:131\n269#3,10:132\n280#3,68:143\n3038#4:142\n269#5:211\n*S KotlinDebug\n*F\n+ 1 ConflatedBufferedChannel.kt\nkotlinx/coroutines/channels/ConflatedBufferedChannel\n*L\n41#1:120,5\n53#1:125,6\n106#1:212,6\n109#1:218,5\n80#1:131\n80#1:132,10\n80#1:143,68\n80#1:142\n80#1:211\n*E\n"})
public class ConflatedBufferedChannel<E> extends BufferedChannel<E> {
    public final int m;
    public final BufferOverflow n;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ConflatedBufferedChannel(int i, BufferOverflow bufferOverflow, Function1 function1, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, bufferOverflow, (i2 & 4) != 0 ? null : function1);
    }

    public static /* synthetic */ Object j1(ConflatedBufferedChannel conflatedBufferedChannel, Object obj, Continuation continuation) {
        UndeliveredElementException d;
        Object n1 = conflatedBufferedChannel.n1(obj, true);
        if (!(n1 instanceof ChannelResult.Closed)) {
            return Unit.INSTANCE;
        }
        ChannelResult.e(n1);
        Function1 function1 = conflatedBufferedChannel.b;
        if (function1 == null || (d = OnUndeliveredElementKt.d(function1, obj, (UndeliveredElementException) null, 2, (Object) null)) == null) {
            throw conflatedBufferedChannel.b0();
        }
        ExceptionsKt.addSuppressed(d, conflatedBufferedChannel.b0());
        throw d;
    }

    public static /* synthetic */ Object k1(ConflatedBufferedChannel conflatedBufferedChannel, Object obj, Continuation continuation) {
        Object n1 = conflatedBufferedChannel.n1(obj, true);
        if (n1 instanceof ChannelResult.Failed) {
            return Boxing.boxBoolean(false);
        }
        Unit unit = (Unit) n1;
        return Boxing.boxBoolean(true);
    }

    public Object L(Object obj, Continuation continuation) {
        return j1(this, obj, continuation);
    }

    public void N0(SelectInstance selectInstance, Object obj) {
        Object q = q(obj);
        if (!(q instanceof ChannelResult.Failed)) {
            Unit unit = (Unit) q;
            selectInstance.c(Unit.INSTANCE);
        } else if (q instanceof ChannelResult.Closed) {
            ChannelResult.e(q);
            selectInstance.c(BufferedChannelKt.z());
        } else {
            throw new IllegalStateException("unreachable".toString());
        }
    }

    public Object T0(Object obj, Continuation continuation) {
        return k1(this, obj, continuation);
    }

    public boolean X0() {
        return false;
    }

    public final Object l1(Object obj, boolean z) {
        Function1 function1;
        UndeliveredElementException d;
        Object q = super.q(obj);
        if (ChannelResult.j(q) || ChannelResult.h(q)) {
            return q;
        }
        if (!z || (function1 = this.b) == null || (d = OnUndeliveredElementKt.d(function1, obj, (UndeliveredElementException) null, 2, (Object) null)) == null) {
            return ChannelResult.b.c(Unit.INSTANCE);
        }
        throw d;
    }

    public boolean m0() {
        return this.n == BufferOverflow.DROP_OLDEST;
    }

    public final Object m1(Object obj) {
        ChannelSegment channelSegment;
        Symbol symbol = BufferedChannelKt.d;
        ChannelSegment channelSegment2 = (ChannelSegment) BufferedChannel.h.get(this);
        while (true) {
            long andIncrement = BufferedChannel.d.getAndIncrement(this);
            long j = andIncrement & 1152921504606846975L;
            boolean m2 = l0(andIncrement);
            int i = BufferedChannelKt.b;
            long j2 = j / ((long) i);
            int i2 = (int) (j % ((long) i));
            if (channelSegment2.c != j2) {
                ChannelSegment d = W(j2, channelSegment2);
                if (d != null) {
                    channelSegment = d;
                } else if (m2) {
                    return ChannelResult.b.a(b0());
                }
            } else {
                channelSegment = channelSegment2;
            }
            int H = e1(channelSegment, i2, obj, j, symbol, m2);
            if (H == 0) {
                channelSegment.b();
                return ChannelResult.b.c(Unit.INSTANCE);
            } else if (H == 1) {
                return ChannelResult.b.c(Unit.INSTANCE);
            } else {
                if (H != 2) {
                    if (H == 3) {
                        throw new IllegalStateException("unexpected".toString());
                    } else if (H != 4) {
                        if (H == 5) {
                            channelSegment.b();
                        }
                        channelSegment2 = channelSegment;
                    } else {
                        if (j < a0()) {
                            channelSegment.b();
                        }
                        return ChannelResult.b.a(b0());
                    }
                } else if (m2) {
                    channelSegment.p();
                    return ChannelResult.b.a(b0());
                } else {
                    Waiter waiter = symbol instanceof Waiter ? (Waiter) symbol : null;
                    if (waiter != null) {
                        D0(waiter, channelSegment, i2);
                    }
                    S((channelSegment.c * ((long) i)) + ((long) i2));
                    return ChannelResult.b.c(Unit.INSTANCE);
                }
            }
        }
    }

    public final Object n1(Object obj, boolean z) {
        return this.n == BufferOverflow.DROP_LATEST ? l1(obj, z) : m1(obj);
    }

    public Object q(Object obj) {
        return n1(obj, false);
    }

    public ConflatedBufferedChannel(int i, BufferOverflow bufferOverflow, Function1 function1) {
        super(i, function1);
        this.m = i;
        this.n = bufferOverflow;
        if (bufferOverflow == BufferOverflow.SUSPEND) {
            throw new IllegalArgumentException(("This implementation does not support suspension for senders, use " + Reflection.getOrCreateKotlinClass(BufferedChannel.class).getSimpleName() + " instead").toString());
        } else if (i < 1) {
            throw new IllegalArgumentException(("Buffered channel capacity must be at least 1, but " + i + " was specified").toString());
        }
    }
}
