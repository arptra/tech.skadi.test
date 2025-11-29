package io.ktor.utils.io.jvm.javaio;

import com.honey.account.i.a;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.EventLoopKt;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\b\"\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\u0007\u001a\u00020\u0006H¤@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ%\u0010\u0010\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\rH\u0004¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u001d\u0010\u001e\u001a\u00020\u00012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00010\u001cH\u0002¢\u0006\u0004\b\u001e\u0010\bR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001a\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00060\u001c8\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u0004\u0018\u00010&8\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R$\u0010\u000e\u001a\u00020\r2\u0006\u0010*\u001a\u00020\r8\u0004@BX\u000e¢\u0006\f\n\u0004\b\u0016\u0010+\u001a\u0004\b,\u0010-R$\u0010\u000f\u001a\u00020\r2\u0006\u0010*\u001a\u00020\r8\u0004@BX\u000e¢\u0006\f\n\u0004\b.\u0010+\u001a\u0004\b.\u0010-\u0002\u0004\n\u0002\b\u0019¨\u0006/"}, d2 = {"Lio/ktor/utils/io/jvm/javaio/BlockingAdapter;", "", "Lkotlinx/coroutines/Job;", "parent", "<init>", "(Lkotlinx/coroutines/Job;)V", "", "h", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "k", "()V", "", "buffer", "", "offset", "length", "m", "([BII)I", "jobToken", "l", "(Ljava/lang/Object;)I", "rc", "d", "(I)V", "Ljava/lang/Thread;", "thread", "i", "(Ljava/lang/Thread;)V", "Lkotlin/coroutines/Continuation;", "ucont", "j", "a", "Lkotlinx/coroutines/Job;", "g", "()Lkotlinx/coroutines/Job;", "b", "Lkotlin/coroutines/Continuation;", "end", "Lkotlinx/coroutines/DisposableHandle;", "c", "Lkotlinx/coroutines/DisposableHandle;", "disposable", "<set-?>", "I", "f", "()I", "e", "ktor-io"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nBlocking.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Blocking.kt\nio/ktor/utils/io/jvm/javaio/BlockingAdapter\n+ 2 AtomicFU.common.kt\nkotlinx/atomicfu/AtomicFU_commonKt\n*L\n1#1,316:1\n164#2,4:317\n164#2,4:321\n*S KotlinDebug\n*F\n+ 1 Blocking.kt\nio/ktor/utils/io/jvm/javaio/BlockingAdapter\n*L\n209#1:317,4\n285#1:321,4\n*E\n"})
abstract class BlockingAdapter {
    public static final /* synthetic */ AtomicReferenceFieldUpdater f = AtomicReferenceFieldUpdater.newUpdater(BlockingAdapter.class, Object.class, "state");

    /* renamed from: a  reason: collision with root package name */
    public final Job f9107a;
    public final Continuation b;
    public final DisposableHandle c;
    public int d;
    public int e;
    @NotNull
    volatile /* synthetic */ int result = 0;
    @NotNull
    volatile /* synthetic */ Object state = this;

    public BlockingAdapter(Job job) {
        this.f9107a = job;
        BlockingAdapter$end$1 blockingAdapter$end$1 = new BlockingAdapter$end$1(this);
        this.b = blockingAdapter$end$1;
        this.c = job != null ? job.r(new BlockingAdapter$disposable$1(this)) : null;
        ((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(new BlockingAdapter$block$1(this, (Continuation<? super BlockingAdapter$block$1>) null), 1)).invoke(blockingAdapter$end$1);
        if (this.state == this) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    public final void d(int i) {
        this.result = i;
    }

    public final int e() {
        return this.e;
    }

    public final int f() {
        return this.d;
    }

    public final Job g() {
        return this.f9107a;
    }

    public abstract Object h(Continuation continuation);

    public final void i(Thread thread) {
        if (this.state == thread) {
            if (!PollersKt.b()) {
                BlockingKt.d().warn("Blocking network thread detected. \nIt can possible lead to a performance decline or even a deadlock.\nPlease make sure you're using blocking IO primitives like InputStream and OutputStream only in \nthe context of Dispatchers.IO:\n```\nwithContext(Dispatchers.IO) {\n    myInputStream.read()\n}\n```");
            }
            while (true) {
                long b2 = EventLoopKt.b();
                if (this.state != thread) {
                    return;
                }
                if (b2 > 0) {
                    PollersKt.a().a(b2);
                }
            }
        }
    }

    public final Object j(Continuation continuation) {
        Object obj;
        Continuation continuation2;
        Object obj2 = null;
        while (true) {
            Object obj3 = this.state;
            if (obj3 instanceof Thread) {
                continuation2 = IntrinsicsKt.intercepted(continuation);
                obj = obj3;
            } else if (Intrinsics.areEqual(obj3, (Object) this)) {
                obj = obj2;
                continuation2 = IntrinsicsKt.intercepted(continuation);
            } else {
                throw new IllegalStateException("Already suspended or in finished state");
            }
            if (a.a(f, this, obj3, continuation2)) {
                if (obj != null) {
                    PollersKt.a().b(obj);
                }
                return IntrinsicsKt.getCOROUTINE_SUSPENDED();
            }
            obj2 = obj;
        }
    }

    public final void k() {
        DisposableHandle disposableHandle = this.c;
        if (disposableHandle != null) {
            disposableHandle.dispose();
        }
        Continuation continuation = this.b;
        Result.Companion companion = Result.Companion;
        continuation.resumeWith(Result.m20constructorimpl(ResultKt.createFailure(new CancellationException("Stream closed"))));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: kotlin.coroutines.Continuation} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int l(java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.String r0 = "jobToken"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r1 = 0
        L_0x000a:
            java.lang.Object r2 = r5.state
            boolean r3 = r2 instanceof kotlin.coroutines.Continuation
            if (r3 == 0) goto L_0x001a
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2, r1)
            r1 = r2
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r3 = r0
            goto L_0x0034
        L_0x001a:
            boolean r3 = r2 instanceof kotlin.Unit
            if (r3 == 0) goto L_0x0021
            int r5 = r5.result
            return r5
        L_0x0021:
            boolean r3 = r2 instanceof java.lang.Throwable
            if (r3 != 0) goto L_0x0071
            boolean r3 = r2 instanceof java.lang.Thread
            if (r3 != 0) goto L_0x0069
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r5)
            if (r3 != 0) goto L_0x0061
            kotlin.NoWhenBranchMatchedException r3 = new kotlin.NoWhenBranchMatchedException
            r3.<init>()
        L_0x0034:
            java.lang.String r4 = "when (value) {\n         …Exception()\n            }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = f
            boolean r2 = com.honey.account.i.a.a(r4, r5, r2, r3)
            if (r2 == 0) goto L_0x000a
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            java.lang.Object r6 = kotlin.Result.m20constructorimpl(r6)
            r1.resumeWith(r6)
            java.lang.String r6 = "thread"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r6)
            r5.i(r0)
            java.lang.Object r6 = r5.state
            boolean r0 = r6 instanceof java.lang.Throwable
            if (r0 != 0) goto L_0x005e
            int r5 = r5.result
            return r5
        L_0x005e:
            java.lang.Throwable r6 = (java.lang.Throwable) r6
            throw r6
        L_0x0061:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "Not yet started"
            r5.<init>(r6)
            throw r5
        L_0x0069:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "There is already thread owning adapter"
            r5.<init>(r6)
            throw r5
        L_0x0071:
            java.lang.Throwable r2 = (java.lang.Throwable) r2
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.jvm.javaio.BlockingAdapter.l(java.lang.Object):int");
    }

    public final int m(byte[] bArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(bArr, "buffer");
        this.d = i;
        this.e = i2;
        return l(bArr);
    }
}
