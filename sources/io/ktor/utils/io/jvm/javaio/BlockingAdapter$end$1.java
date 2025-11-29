package io.ktor.utils.io.jvm.javaio;

import com.honey.account.i.a;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;

@SourceDebugExtension({"SMAP\nBlocking.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Blocking.kt\nio/ktor/utils/io/jvm/javaio/BlockingAdapter$end$1\n+ 2 AtomicFU.common.kt\nkotlinx/atomicfu/AtomicFU_commonKt\n*L\n1#1,316:1\n175#2,4:317\n*S KotlinDebug\n*F\n+ 1 Blocking.kt\nio/ktor/utils/io/jvm/javaio/BlockingAdapter$end$1\n*L\n148#1:317,4\n*E\n"})
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J \u0010\u0005\u001a\u00020\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\f\u001a\u00020\u00078\u0016X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"io/ktor/utils/io/jvm/javaio/BlockingAdapter$end$1", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/Result;", "result", "resumeWith", "(Ljava/lang/Object;)V", "Lkotlin/coroutines/CoroutineContext;", "a", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "context", "ktor-io"}, k = 1, mv = {1, 8, 0})
public final class BlockingAdapter$end$1 implements Continuation<Unit> {

    /* renamed from: a  reason: collision with root package name */
    public final CoroutineContext f9108a;
    public final /* synthetic */ BlockingAdapter b;

    public BlockingAdapter$end$1(BlockingAdapter blockingAdapter) {
        this.b = blockingAdapter;
        this.f9108a = blockingAdapter.g() != null ? UnsafeBlockingTrampoline.f9115a.plus(blockingAdapter.g()) : UnsafeBlockingTrampoline.f9115a;
    }

    public CoroutineContext getContext() {
        return this.f9108a;
    }

    public void resumeWith(Object obj) {
        Object obj2;
        boolean z;
        Job g;
        Throwable r0;
        Object r02 = Result.m23exceptionOrNullimpl(obj);
        if (r02 == null) {
            r02 = Unit.INSTANCE;
        }
        BlockingAdapter blockingAdapter = this.b;
        do {
            obj2 = blockingAdapter.state;
            z = obj2 instanceof Thread;
            if (!(z ? true : obj2 instanceof Continuation ? true : Intrinsics.areEqual(obj2, (Object) this))) {
                return;
            }
        } while (!a.a(BlockingAdapter.f, blockingAdapter, obj2, r02));
        if (z) {
            PollersKt.a().b(obj2);
        } else if ((obj2 instanceof Continuation) && (r0 = Result.m23exceptionOrNullimpl(obj)) != null) {
            ((Continuation) obj2).resumeWith(Result.m20constructorimpl(ResultKt.createFailure(r0)));
        }
        if (Result.m26isFailureimpl(obj) && !(Result.m23exceptionOrNullimpl(obj) instanceof CancellationException) && (g = this.b.g()) != null) {
            Job.DefaultImpls.a(g, (CancellationException) null, 1, (Object) null);
        }
        DisposableHandle a2 = this.b.c;
        if (a2 != null) {
            a2.dispose();
        }
    }
}
