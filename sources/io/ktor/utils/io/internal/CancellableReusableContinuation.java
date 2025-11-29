package io.ktor.utils.io.internal;

import com.honey.account.constant.AccountConstantKt;
import com.honey.account.i.a;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension({"SMAP\nCancellableReusableContinuation.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CancellableReusableContinuation.kt\nio/ktor/utils/io/internal/CancellableReusableContinuation\n+ 2 AtomicFU.common.kt\nkotlinx/atomicfu/AtomicFU_commonKt\n*L\n1#1,137:1\n175#2,4:138\n175#2,4:142\n175#2,4:146\n*S KotlinDebug\n*F\n+ 1 CancellableReusableContinuation.kt\nio/ktor/utils/io/internal/CancellableReusableContinuation\n*L\n60#1:138,4\n82#1:142,4\n99#1:146,4\n*E\n"})
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001#B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00028\u0000¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u000f\u001a\u00020\u00012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0004\b\u000f\u0010\u0010J \u0010\u0013\u001a\u00020\u00072\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\tJ\u0017\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u001a\u001a\u00020\u00072\u0010\u0010\u0019\u001a\f0\u0018R\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001f\u0010 R\u0014\u0010\u0015\u001a\u00020\u00148VX\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"\u0002\u0004\n\u0002\b\u0019¨\u0006$"}, d2 = {"Lio/ktor/utils/io/internal/CancellableReusableContinuation;", "", "T", "Lkotlin/coroutines/Continuation;", "<init>", "()V", "value", "", "c", "(Ljava/lang/Object;)V", "", "cause", "d", "(Ljava/lang/Throwable;)V", "actual", "g", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Result;", "result", "resumeWith", "Lkotlin/coroutines/CoroutineContext;", "context", "i", "(Lkotlin/coroutines/CoroutineContext;)V", "Lio/ktor/utils/io/internal/CancellableReusableContinuation$JobRelation;", "relation", "h", "(Lio/ktor/utils/io/internal/CancellableReusableContinuation$JobRelation;)V", "Lkotlinx/coroutines/Job;", "job", "exception", "j", "(Lkotlinx/coroutines/Job;Ljava/lang/Throwable;)V", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "JobRelation", "ktor-io"}, k = 1, mv = {1, 8, 0})
public final class CancellableReusableContinuation<T> implements Continuation<T> {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f9098a;
    public static final /* synthetic */ AtomicReferenceFieldUpdater b;
    @NotNull
    private volatile /* synthetic */ Object jobCancellationHandler = null;
    @NotNull
    private volatile /* synthetic */ Object state = null;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002#\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001j\u0002`\u0007B\u000f\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\f\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u0006¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0014¨\u0006\u0016"}, d2 = {"Lio/ktor/utils/io/internal/CancellableReusableContinuation$JobRelation;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "Lkotlinx/coroutines/CompletionHandler;", "Lkotlinx/coroutines/Job;", "job", "<init>", "(Lio/ktor/utils/io/internal/CancellableReusableContinuation;Lkotlinx/coroutines/Job;)V", "c", "(Ljava/lang/Throwable;)V", "a", "()V", "Lkotlinx/coroutines/Job;", "b", "()Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/DisposableHandle;", "handler", "ktor-io"}, k = 1, mv = {1, 8, 0})
    public final class JobRelation implements Function1<Throwable, Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final Job f9099a;
        public DisposableHandle b;
        public final /* synthetic */ CancellableReusableContinuation c;

        public JobRelation(CancellableReusableContinuation cancellableReusableContinuation, Job job) {
            Intrinsics.checkNotNullParameter(job, "job");
            this.c = cancellableReusableContinuation;
            this.f9099a = job;
            DisposableHandle d = Job.DefaultImpls.d(job, true, false, this, 2, (Object) null);
            if (job.isActive()) {
                this.b = d;
            }
        }

        public final void a() {
            DisposableHandle disposableHandle = this.b;
            if (disposableHandle != null) {
                this.b = null;
                disposableHandle.dispose();
            }
        }

        public final Job b() {
            return this.f9099a;
        }

        public void c(Throwable th) {
            this.c.h(this);
            a();
            if (th != null) {
                this.c.j(this.f9099a, th);
            }
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            c((Throwable) obj);
            return Unit.INSTANCE;
        }
    }

    static {
        Class<CancellableReusableContinuation> cls = CancellableReusableContinuation.class;
        Class<Object> cls2 = Object.class;
        f9098a = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "state");
        b = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "jobCancellationHandler");
    }

    public final void c(Object obj) {
        Intrinsics.checkNotNullParameter(obj, AccountConstantKt.RESPONSE_VALUE);
        resumeWith(Result.m20constructorimpl(obj));
        JobRelation jobRelation = (JobRelation) b.getAndSet(this, (Object) null);
        if (jobRelation != null) {
            jobRelation.a();
        }
    }

    public final void d(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "cause");
        Result.Companion companion = Result.Companion;
        resumeWith(Result.m20constructorimpl(ResultKt.createFailure(th)));
        JobRelation jobRelation = (JobRelation) b.getAndSet(this, (Object) null);
        if (jobRelation != null) {
            jobRelation.a();
        }
    }

    public final Object g(Continuation continuation) {
        Intrinsics.checkNotNullParameter(continuation, "actual");
        while (true) {
            Object obj = this.state;
            if (obj == null) {
                if (a.a(f9098a, this, (Object) null, continuation)) {
                    i(continuation.getContext());
                    return IntrinsicsKt.getCOROUTINE_SUSPENDED();
                }
            } else if (a.a(f9098a, this, obj, (Object) null)) {
                if (!(obj instanceof Throwable)) {
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of io.ktor.utils.io.internal.CancellableReusableContinuation");
                    return obj;
                }
                throw ((Throwable) obj);
            }
        }
    }

    public CoroutineContext getContext() {
        CoroutineContext context;
        Object obj = this.state;
        Continuation continuation = obj instanceof Continuation ? (Continuation) obj : null;
        return (continuation == null || (context = continuation.getContext()) == null) ? EmptyCoroutineContext.INSTANCE : context;
    }

    public final void h(JobRelation jobRelation) {
        a.a(b, this, jobRelation, (Object) null);
    }

    public final void i(CoroutineContext coroutineContext) {
        Object obj;
        JobRelation jobRelation;
        Job job = (Job) coroutineContext.get(Job.b0);
        JobRelation jobRelation2 = (JobRelation) this.jobCancellationHandler;
        if ((jobRelation2 != null ? jobRelation2.b() : null) != job) {
            if (job == null) {
                JobRelation jobRelation3 = (JobRelation) b.getAndSet(this, (Object) null);
                if (jobRelation3 != null) {
                    jobRelation3.a();
                    return;
                }
                return;
            }
            JobRelation jobRelation4 = new JobRelation(this, job);
            do {
                obj = this.jobCancellationHandler;
                jobRelation = (JobRelation) obj;
                if (jobRelation != null && jobRelation.b() == job) {
                    jobRelation4.a();
                    return;
                }
            } while (!a.a(b, this, obj, jobRelation4));
            if (jobRelation != null) {
                jobRelation.a();
            }
        }
    }

    public final void j(Job job, Throwable th) {
        Object obj;
        Continuation continuation;
        do {
            obj = this.state;
            if (obj instanceof Continuation) {
                continuation = (Continuation) obj;
                if (continuation.getContext().get(Job.b0) != job) {
                    return;
                }
            } else {
                return;
            }
        } while (!a.a(f9098a, this, obj, (Object) null));
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.coroutines.Continuation<T of io.ktor.utils.io.internal.CancellableReusableContinuation>");
        Result.Companion companion = Result.Companion;
        continuation.resumeWith(Result.m20constructorimpl(ResultKt.createFailure(th)));
    }

    public void resumeWith(Object obj) {
        Object obj2;
        Object obj3;
        do {
            obj2 = this.state;
            if (obj2 == null) {
                obj3 = Result.m23exceptionOrNullimpl(obj);
                if (obj3 == null) {
                    ResultKt.throwOnFailure(obj);
                    obj3 = obj;
                }
            } else if (obj2 instanceof Continuation) {
                obj3 = null;
            } else {
                return;
            }
        } while (!a.a(f9098a, this, obj2, obj3));
        if (obj2 instanceof Continuation) {
            ((Continuation) obj2).resumeWith(obj);
        }
    }
}
