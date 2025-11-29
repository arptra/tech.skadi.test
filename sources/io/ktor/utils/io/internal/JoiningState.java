package io.ktor.utils.io.internal;

import com.honey.account.i.a;
import io.ktor.utils.io.ByteBufferChannel;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0013\u0010\u0005\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006R\u0017\u0010\u000b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u0005\u0010\b\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0010\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\u0003\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118BX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"Lio/ktor/utils/io/internal/JoiningState;", "", "", "b", "()V", "a", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/utils/io/ByteBufferChannel;", "Lio/ktor/utils/io/ByteBufferChannel;", "e", "()Lio/ktor/utils/io/ByteBufferChannel;", "delegatedTo", "", "Z", "d", "()Z", "delegateClose", "Lkotlinx/coroutines/Job;", "c", "()Lkotlinx/coroutines/Job;", "closeWaitJob", "ktor-io"}, k = 1, mv = {1, 8, 0})
public final class JoiningState {
    public static final /* synthetic */ AtomicReferenceFieldUpdater c = AtomicReferenceFieldUpdater.newUpdater(JoiningState.class, Object.class, "_closeWaitJob");
    @NotNull
    private volatile /* synthetic */ Object _closeWaitJob;

    /* renamed from: a  reason: collision with root package name */
    public final ByteBufferChannel f9101a;
    public final boolean b;
    @NotNull
    private volatile /* synthetic */ int closed;

    public final Object a(Continuation continuation) {
        if (this.closed == 1) {
            return Unit.INSTANCE;
        }
        Object i0 = c().i0(continuation);
        return i0 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? i0 : Unit.INSTANCE;
    }

    public final void b() {
        this.closed = 1;
        Job job = (Job) c.getAndSet(this, (Object) null);
        if (job != null) {
            Job.DefaultImpls.a(job, (CancellationException) null, 1, (Object) null);
        }
    }

    public final Job c() {
        CompletableJob b2;
        do {
            Job job = (Job) this._closeWaitJob;
            if (job != null) {
                return job;
            }
            b2 = JobKt__JobKt.b((Job) null, 1, (Object) null);
        } while (!a.a(c, this, (Object) null, b2));
        if (this.closed == 1) {
            Job.DefaultImpls.a(b2, (CancellationException) null, 1, (Object) null);
        }
        return b2;
    }

    public final boolean d() {
        return this.b;
    }

    public final ByteBufferChannel e() {
        return this.f9101a;
    }
}
