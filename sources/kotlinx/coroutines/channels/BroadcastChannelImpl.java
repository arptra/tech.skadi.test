package kotlinx.coroutines.channels;

import com.meizu.common.widget.MzContactsContract;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.selects.SelectInstance;

@SourceDebugExtension({"SMAP\nBroadcastChannel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BroadcastChannel.kt\nkotlinx/coroutines/channels/BroadcastChannelImpl\n+ 2 Concurrent.kt\nkotlinx/coroutines/internal/ConcurrentKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,414:1\n15#2:415\n15#2:416\n15#2:420\n15#2:423\n15#2:429\n15#2:430\n15#2:436\n15#2:439\n15#2:440\n15#2:441\n766#3:417\n857#3,2:418\n1855#3,2:421\n1747#3,3:424\n1855#3,2:427\n1855#3,2:431\n766#3:433\n857#3,2:434\n1855#3,2:437\n*S KotlinDebug\n*F\n+ 1 BroadcastChannel.kt\nkotlinx/coroutines/channels/BroadcastChannelImpl\n*L\n166#1:415\n188#1:416\n213#1:420\n237#1:423\n279#1:429\n331#1:430\n343#1:436\n355#1:439\n382#1:440\n394#1:441\n189#1:417\n189#1:418,2\n226#1:421,2\n242#1:424,3\n251#1:427,2\n333#1:431,2\n338#1:433\n338#1:434,2\n346#1:437,2\n*E\n"})
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0002=>J\u0015\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ&\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u000b2\u0006\u0010\u0007\u001a\u00028\u0000H\u0016ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ%\u0010\u0011\u001a\u00020\b2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u000e2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0010H\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u0018\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0010¢\u0006\u0004\b\u0018\u0010\u0017J\u000f\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u001d\u0010\u001d\u001a\u00020\b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0002¢\u0006\u0004\b\u001d\u0010\u001eR\u0017\u0010$\u001a\u00020\u001f8\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0018\u0010)\u001a\u00060%j\u0002`&8\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\"\u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020*8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0018\u00100\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b.\u0010/R<\u00104\u001a*\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u001001j\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u0010`28\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u00103R\u0014\u00107\u001a\u00020\u00158VX\u0004¢\u0006\u0006\u001a\u0004\b5\u00106R\u0017\u0010<\u001a\u00028\u00008F¢\u0006\f\u0012\u0004\b:\u0010;\u001a\u0004\b8\u00109\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006?"}, d2 = {"Lkotlinx/coroutines/channels/BroadcastChannelImpl;", "E", "Lkotlinx/coroutines/channels/BufferedChannel;", "Lkotlinx/coroutines/channels/BroadcastChannel;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "l", "()Lkotlinx/coroutines/channels/ReceiveChannel;", "element", "", "L", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/ChannelResult;", "q", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "", "N0", "(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", "", "cause", "", "h", "(Ljava/lang/Throwable;)Z", "J", "", "toString", "()Ljava/lang/String;", "s", "o1", "(Lkotlinx/coroutines/channels/ReceiveChannel;)V", "", "m", "I", "m1", "()I", "capacity", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", "n", "Ljava/util/concurrent/locks/ReentrantLock;", "lock", "", "o", "Ljava/util/List;", "subscribers", "p", "Ljava/lang/Object;", "lastConflatedElement", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "onSendInternalResult", "A", "()Z", "isClosedForSend", "n1", "()Ljava/lang/Object;", "getValue$annotations", "()V", "value", "SubscriberBuffered", "SubscriberConflated", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0})
public final class BroadcastChannelImpl<E> extends BufferedChannel<E> implements BroadcastChannel<E> {
    public final int m;
    public final ReentrantLock n;
    public List o;
    public Object p;
    public final HashMap q;

    @SourceDebugExtension({"SMAP\nBroadcastChannel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BroadcastChannel.kt\nkotlinx/coroutines/channels/BroadcastChannelImpl$SubscriberBuffered\n+ 2 Concurrent.kt\nkotlinx/coroutines/internal/ConcurrentKt\n*L\n1#1,414:1\n15#2:415\n*S KotlinDebug\n*F\n+ 1 BroadcastChannel.kt\nkotlinx/coroutines/channels/BroadcastChannelImpl$SubscriberBuffered\n*L\n362#1:415\n*E\n"})
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lkotlinx/coroutines/channels/BroadcastChannelImpl$SubscriberBuffered;", "Lkotlinx/coroutines/channels/BufferedChannel;", "<init>", "(Lkotlinx/coroutines/channels/BroadcastChannelImpl;)V", "", "cause", "", "j1", "(Ljava/lang/Throwable;)Z", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0})
    public final class SubscriberBuffered extends BufferedChannel<E> {
        public SubscriberBuffered() {
            super(BroadcastChannelImpl.this.m1(), (Function1) null, 2, (DefaultConstructorMarker) null);
        }

        /* renamed from: j1 */
        public boolean J(Throwable th) {
            ReentrantLock j1 = BroadcastChannelImpl.this.n;
            BroadcastChannelImpl broadcastChannelImpl = BroadcastChannelImpl.this;
            j1.lock();
            try {
                broadcastChannelImpl.o1(this);
                return super.J(th);
            } finally {
                j1.unlock();
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lkotlinx/coroutines/channels/BroadcastChannelImpl$SubscriberConflated;", "Lkotlinx/coroutines/channels/ConflatedBufferedChannel;", "<init>", "(Lkotlinx/coroutines/channels/BroadcastChannelImpl;)V", "", "cause", "", "o1", "(Ljava/lang/Throwable;)Z", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0})
    public final class SubscriberConflated extends ConflatedBufferedChannel<E> {
        public SubscriberConflated() {
            super(1, BufferOverflow.DROP_OLDEST, (Function1) null, 4, (DefaultConstructorMarker) null);
        }

        /* renamed from: o1 */
        public boolean J(Throwable th) {
            BroadcastChannelImpl.this.o1(this);
            return super.J(th);
        }
    }

    public boolean A() {
        ReentrantLock reentrantLock = this.n;
        reentrantLock.lock();
        try {
            return super.A();
        } finally {
            reentrantLock.unlock();
        }
    }

    public boolean J(Throwable th) {
        ReentrantLock reentrantLock = this.n;
        reentrantLock.lock();
        try {
            for (BufferedChannel J : this.o) {
                J.J(th);
            }
            this.p = BroadcastChannelKt.f3750a;
            boolean J2 = super.J(th);
            reentrantLock.unlock();
            return J2;
        } catch (Throwable th2) {
            reentrantLock.unlock();
            throw th2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object L(java.lang.Object r7, kotlin.coroutines.Continuation r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof kotlinx.coroutines.channels.BroadcastChannelImpl$send$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            kotlinx.coroutines.channels.BroadcastChannelImpl$send$1 r0 = (kotlinx.coroutines.channels.BroadcastChannelImpl$send$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.channels.BroadcastChannelImpl$send$1 r0 = new kotlinx.coroutines.channels.BroadcastChannelImpl$send$1
            r0.<init>(r6, r8)
        L_0x0018:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003f
            if (r2 != r3) goto L_0x0037
            java.lang.Object r6 = r0.L$2
            java.util.Iterator r6 = (java.util.Iterator) r6
            java.lang.Object r7 = r0.L$1
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.channels.BroadcastChannelImpl r2 = (kotlinx.coroutines.channels.BroadcastChannelImpl) r2
            kotlin.ResultKt.throwOnFailure(r8)
            r5 = r0
            r0 = r7
            r7 = r2
        L_0x0035:
            r2 = r5
            goto L_0x0083
        L_0x0037:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x003f:
            kotlin.ResultKt.throwOnFailure(r8)
            java.util.concurrent.locks.ReentrantLock r8 = r6.n
            r8.lock()
            boolean r2 = r6.A()     // Catch:{ all -> 0x0055 }
            if (r2 != 0) goto L_0x009d
            int r2 = r6.m     // Catch:{ all -> 0x0055 }
            r4 = -1
            if (r2 != r4) goto L_0x0057
            r6.p = r7     // Catch:{ all -> 0x0055 }
            goto L_0x0057
        L_0x0055:
            r6 = move-exception
            goto L_0x00a2
        L_0x0057:
            java.util.List r2 = r6.o     // Catch:{ all -> 0x0055 }
            r8.unlock()
            java.util.Iterator r8 = r2.iterator()
            r5 = r7
            r7 = r6
            r6 = r8
            r8 = r5
        L_0x0064:
            boolean r2 = r6.hasNext()
            if (r2 == 0) goto L_0x009a
            java.lang.Object r2 = r6.next()
            kotlinx.coroutines.channels.BufferedChannel r2 = (kotlinx.coroutines.channels.BufferedChannel) r2
            r0.L$0 = r7
            r0.L$1 = r8
            r0.L$2 = r6
            r0.label = r3
            java.lang.Object r2 = r2.T0(r8, r0)
            if (r2 != r1) goto L_0x007f
            return r1
        L_0x007f:
            r5 = r0
            r0 = r8
            r8 = r2
            goto L_0x0035
        L_0x0083:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 != 0) goto L_0x0097
            boolean r8 = r7.A()
            if (r8 != 0) goto L_0x0092
            goto L_0x0097
        L_0x0092:
            java.lang.Throwable r6 = r7.b0()
            throw r6
        L_0x0097:
            r8 = r0
            r0 = r2
            goto L_0x0064
        L_0x009a:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L_0x009d:
            java.lang.Throwable r6 = r6.b0()     // Catch:{ all -> 0x0055 }
            throw r6     // Catch:{ all -> 0x0055 }
        L_0x00a2:
            r8.unlock()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BroadcastChannelImpl.L(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public void N0(SelectInstance selectInstance, Object obj) {
        ReentrantLock reentrantLock = this.n;
        reentrantLock.lock();
        try {
            Object remove = this.q.remove(selectInstance);
            if (remove != null) {
                selectInstance.c(remove);
                return;
            }
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
            Job unused = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(selectInstance.getContext()), (CoroutineContext) null, CoroutineStart.UNDISPATCHED, new BroadcastChannelImpl$registerSelectForSend$2(this, obj, selectInstance, (Continuation<? super BroadcastChannelImpl$registerSelectForSend$2>) null), 1, (Object) null);
        } finally {
            reentrantLock.unlock();
        }
    }

    public boolean h(Throwable th) {
        ReentrantLock reentrantLock = this.n;
        reentrantLock.lock();
        try {
            for (BufferedChannel h : this.o) {
                h.h(th);
            }
            List list = this.o;
            ArrayList arrayList = new ArrayList();
            for (Object next : list) {
                if (((BufferedChannel) next).d0()) {
                    arrayList.add(next);
                }
            }
            this.o = arrayList;
            boolean h2 = super.h(th);
            reentrantLock.unlock();
            return h2;
        } catch (Throwable th2) {
            reentrantLock.unlock();
            throw th2;
        }
    }

    public ReceiveChannel l() {
        ReentrantLock reentrantLock = this.n;
        reentrantLock.lock();
        try {
            BufferedChannel subscriberConflated = this.m == -1 ? new SubscriberConflated() : new SubscriberBuffered();
            if (!A() || this.p != BroadcastChannelKt.f3750a) {
                if (this.p != BroadcastChannelKt.f3750a) {
                    subscriberConflated.q(n1());
                }
                this.o = CollectionsKt.plus(this.o, subscriberConflated);
                reentrantLock.unlock();
                return subscriberConflated;
            }
            subscriberConflated.h(Y());
            reentrantLock.unlock();
            return subscriberConflated;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final int m1() {
        return this.m;
    }

    public final Object n1() {
        ReentrantLock reentrantLock = this.n;
        reentrantLock.lock();
        try {
            if (A()) {
                Throwable Y = Y();
                if (Y == null) {
                    Y = new IllegalStateException("This broadcast channel is closed");
                }
                throw Y;
            } else if (this.p != BroadcastChannelKt.f3750a) {
                Object obj = this.p;
                reentrantLock.unlock();
                return obj;
            } else {
                throw new IllegalStateException("No value".toString());
            }
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: kotlinx.coroutines.channels.BufferedChannel} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void o1(kotlinx.coroutines.channels.ReceiveChannel r6) {
        /*
            r5 = this;
            java.util.concurrent.locks.ReentrantLock r0 = r5.n
            r0.lock()
            java.util.List r1 = r5.o     // Catch:{ all -> 0x0023 }
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x0023 }
            r2.<init>()     // Catch:{ all -> 0x0023 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x0023 }
        L_0x0010:
            boolean r3 = r1.hasNext()     // Catch:{ all -> 0x0023 }
            if (r3 == 0) goto L_0x0025
            java.lang.Object r3 = r1.next()     // Catch:{ all -> 0x0023 }
            r4 = r3
            kotlinx.coroutines.channels.BufferedChannel r4 = (kotlinx.coroutines.channels.BufferedChannel) r4     // Catch:{ all -> 0x0023 }
            if (r4 == r6) goto L_0x0010
            r2.add(r3)     // Catch:{ all -> 0x0023 }
            goto L_0x0010
        L_0x0023:
            r5 = move-exception
            goto L_0x002d
        L_0x0025:
            r5.o = r2     // Catch:{ all -> 0x0023 }
            kotlin.Unit r5 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0023 }
            r0.unlock()
            return
        L_0x002d:
            r0.unlock()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BroadcastChannelImpl.o1(kotlinx.coroutines.channels.ReceiveChannel):void");
    }

    public Object q(Object obj) {
        ReentrantLock reentrantLock = this.n;
        reentrantLock.lock();
        try {
            if (A()) {
                return super.q(obj);
            }
            List<BufferedChannel> list = this.o;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                for (BufferedChannel X0 : list) {
                    if (X0.X0()) {
                        Object b = ChannelResult.b.b();
                        reentrantLock.unlock();
                        return b;
                    }
                }
            }
            if (this.m == -1) {
                this.p = obj;
            }
            for (BufferedChannel q2 : this.o) {
                q2.q(obj);
            }
            Object c = ChannelResult.b.c(Unit.INSTANCE);
            reentrantLock.unlock();
            return c;
        } finally {
            reentrantLock.unlock();
        }
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        if (this.p != BroadcastChannelKt.f3750a) {
            str = "CONFLATED_ELEMENT=" + this.p + "; ";
        } else {
            str = "";
        }
        sb.append(str);
        sb.append("BROADCAST=<");
        sb.append(super.toString());
        sb.append(">; SUBSCRIBERS=");
        sb.append(CollectionsKt.joinToString$default(this.o, MzContactsContract.MzGroups.GROUP_SPLIT_MARK_VCARD, "<", ">", 0, (CharSequence) null, (Function1) null, 56, (Object) null));
        return sb.toString();
    }
}
