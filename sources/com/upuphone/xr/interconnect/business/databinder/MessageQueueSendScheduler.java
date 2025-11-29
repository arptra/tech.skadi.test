package com.upuphone.xr.interconnect.business.databinder;

import android.os.SystemClock;
import com.upuphone.xr.interconnect.common.IDataBinder;
import com.upuphone.xr.interconnect.util.log.ILog;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.MutableSharedFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B5\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u000e\u0010\u0007\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0006\u0010\u0013\u001a\u00020\u0014J\u0010\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u000fJ\u000e\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0005J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0003\u001a\u00028\u0000X\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u000e\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/upuphone/xr/interconnect/business/databinder/MessageQueueSendScheduler;", "E", "", "sendEvent", "clearanceTargetTimeMs", "", "windowSize", "flow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "context", "Lkotlin/coroutines/CoroutineContext;", "(Ljava/lang/Object;IILkotlinx/coroutines/flow/MutableSharedFlow;Lkotlin/coroutines/CoroutineContext;)V", "lastSendJob", "Lkotlinx/coroutines/Job;", "lastSendTime", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "Ljava/lang/Object;", "cancelNextSend", "", "markSendTime", "time", "scheduleNextSend", "pendingSize", "targetDelayTimeOf", "size", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class MessageQueueSendScheduler<E> {
    private final int clearanceTargetTimeMs;
    /* access modifiers changed from: private */
    @NotNull
    public final MutableSharedFlow<? super E> flow;
    @Nullable
    private Job lastSendJob;
    private long lastSendTime = SystemClock.uptimeMillis();
    @NotNull
    private final CoroutineScope scope;
    /* access modifiers changed from: private */
    public final E sendEvent;
    private int windowSize;

    public MessageQueueSendScheduler(E e, int i, int i2, @NotNull MutableSharedFlow<? super E> mutableSharedFlow, @NotNull CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(mutableSharedFlow, "flow");
        Intrinsics.checkNotNullParameter(coroutineContext, "context");
        this.sendEvent = e;
        this.clearanceTargetTimeMs = i;
        this.windowSize = i2;
        this.flow = mutableSharedFlow;
        this.scope = CoroutineScopeKt.a(coroutineContext);
    }

    public static /* synthetic */ void markSendTime$default(MessageQueueSendScheduler messageQueueSendScheduler, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = SystemClock.uptimeMillis();
        }
        messageQueueSendScheduler.markSendTime(j);
    }

    private final int targetDelayTimeOf(int i) {
        return this.clearanceTargetTimeMs / RangesKt.coerceAtLeast(i / this.windowSize, 1);
    }

    public final void cancelNextSend() {
        Job job = this.lastSendJob;
        if (job != null) {
            Job.DefaultImpls.a(job, (CancellationException) null, 1, (Object) null);
        }
    }

    public final void markSendTime(long j) {
        this.lastSendTime = j;
    }

    public final void scheduleNextSend(int i) {
        if (i != 0) {
            int targetDelayTimeOf = targetDelayTimeOf(i);
            long j = this.lastSendTime + ((long) targetDelayTimeOf);
            ILog.d(IDataBinder.TAG, "Queueing next send at +" + targetDelayTimeOf + "(" + j + ").");
            this.lastSendJob = BuildersKt__Builders_commonKt.d(this.scope, (CoroutineContext) null, (CoroutineStart) null, new MessageQueueSendScheduler$scheduleNextSend$1(j, this, (Continuation<? super MessageQueueSendScheduler$scheduleNextSend$1>) null), 3, (Object) null);
        }
    }
}
