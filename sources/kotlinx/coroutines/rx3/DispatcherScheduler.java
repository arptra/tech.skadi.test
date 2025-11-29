package kotlinx.coroutines.rx3;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001:\u0001#J+\u0010\n\u001a\u00020\t2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\u00158\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u000b\u0010\"\u001a\u00020!8\u0002X\u0004¨\u0006$"}, d2 = {"Lkotlinx/coroutines/rx3/DispatcherScheduler;", "Lio/reactivex/rxjava3/core/Scheduler;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "", "delay", "Ljava/util/concurrent/TimeUnit;", "unit", "Lio/reactivex/rxjava3/disposables/Disposable;", "scheduleDirect", "(Ljava/lang/Runnable;JLjava/util/concurrent/TimeUnit;)Lio/reactivex/rxjava3/disposables/Disposable;", "Lio/reactivex/rxjava3/core/Scheduler$Worker;", "createWorker", "()Lio/reactivex/rxjava3/core/Scheduler$Worker;", "", "shutdown", "()V", "", "toString", "()Ljava/lang/String;", "Lkotlinx/coroutines/CoroutineDispatcher;", "a", "Lkotlinx/coroutines/CoroutineDispatcher;", "dispatcher", "Lkotlinx/coroutines/CompletableJob;", "b", "Lkotlinx/coroutines/CompletableJob;", "schedulerJob", "Lkotlinx/coroutines/CoroutineScope;", "c", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Lkotlinx/atomicfu/AtomicLong;", "workerCounter", "DispatcherWorker", "kotlinx-coroutines-rx3"}, k = 1, mv = {1, 8, 0})
final class DispatcherScheduler extends Scheduler {
    public static final AtomicLongFieldUpdater d = AtomicLongFieldUpdater.newUpdater(DispatcherScheduler.class, "workerCounter");

    /* renamed from: a  reason: collision with root package name */
    public final CoroutineDispatcher f3946a;
    public final CompletableJob b;
    public final CoroutineScope c;
    @Volatile
    private volatile long workerCounter;

    @Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ+\u0010\u0011\u001a\u00020\u00102\n\u0010\f\u001a\u00060\nj\u0002`\u000b2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010#\u001a\u00020 8\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010'\u001a\u00020$8\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R3\u0010.\u001a\u001e\u0012\u001a\u0012\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160*\u0012\u0006\u0012\u0004\u0018\u00010+0)0(8\u0002X\u0004ø\u0001\u0000¢\u0006\u0006\n\u0004\b,\u0010-\u0002\u0004\n\u0002\b\u0019¨\u0006/"}, d2 = {"Lkotlinx/coroutines/rx3/DispatcherScheduler$DispatcherWorker;", "Lio/reactivex/rxjava3/core/Scheduler$Worker;", "", "counter", "Lkotlinx/coroutines/CoroutineDispatcher;", "dispatcher", "Lkotlinx/coroutines/Job;", "parentJob", "<init>", "(JLkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/Job;)V", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "delay", "Ljava/util/concurrent/TimeUnit;", "unit", "Lio/reactivex/rxjava3/disposables/Disposable;", "schedule", "(Ljava/lang/Runnable;JLjava/util/concurrent/TimeUnit;)Lio/reactivex/rxjava3/disposables/Disposable;", "", "isDisposed", "()Z", "", "dispose", "()V", "", "toString", "()Ljava/lang/String;", "a", "J", "b", "Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlinx/coroutines/CompletableJob;", "c", "Lkotlinx/coroutines/CompletableJob;", "workerJob", "Lkotlinx/coroutines/CoroutineScope;", "d", "Lkotlinx/coroutines/CoroutineScope;", "workerScope", "Lkotlinx/coroutines/channels/Channel;", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "e", "Lkotlinx/coroutines/channels/Channel;", "blockChannel", "kotlinx-coroutines-rx3"}, k = 1, mv = {1, 8, 0})
    public static final class DispatcherWorker extends Scheduler.Worker {

        /* renamed from: a  reason: collision with root package name */
        public final long f3949a;
        public final CoroutineDispatcher b;
        public final CompletableJob c;
        public final CoroutineScope d;
        public final Channel e = ChannelKt.b(Integer.MAX_VALUE, (BufferOverflow) null, (Function1) null, 6, (Object) null);

        public DispatcherWorker(long j, CoroutineDispatcher coroutineDispatcher, Job job) {
            this.f3949a = j;
            this.b = coroutineDispatcher;
            CompletableJob a2 = SupervisorKt.a(job);
            this.c = a2;
            CoroutineScope a3 = CoroutineScopeKt.a(a2.plus(coroutineDispatcher));
            this.d = a3;
            Job unused = BuildersKt__Builders_commonKt.d(a3, (CoroutineContext) null, (CoroutineStart) null, new Function2<CoroutineScope, Continuation<? super Unit>, Object>(this, (Continuation<? super AnonymousClass1>) null) {
                Object L$0;
                Object L$1;
                int label;
                final /* synthetic */ DispatcherWorker this$0;

                {
                    this.this$0 = r1;
                }

                @NotNull
                public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                    return 

                    public Scheduler.Worker createWorker() {
                        return new DispatcherWorker(d.getAndIncrement(this), this.f3946a, this.b);
                    }

                    public Disposable scheduleDirect(Runnable runnable, long j, TimeUnit timeUnit) {
                        return RxSchedulerKt.e(this.c, runnable, timeUnit.toMillis(j), new DispatcherScheduler$scheduleDirect$1(this));
                    }

                    public void shutdown() {
                        Job.DefaultImpls.a(this.b, (CancellationException) null, 1, (Object) null);
                    }

                    public String toString() {
                        return this.f3946a.toString();
                    }
                }
