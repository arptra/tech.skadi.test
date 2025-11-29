package com.upuphone.xr.interconnect.business.databinder;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.MutableSharedFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B%\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u000fR\u0016\u0010\u0004\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0003\u001a\u00028\u0000X\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/upuphone/xr/interconnect/business/databinder/FullDataRequester;", "E", "", "requestEvent", "flow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "context", "Lkotlin/coroutines/CoroutineContext;", "(Ljava/lang/Object;Lkotlinx/coroutines/flow/MutableSharedFlow;Lkotlin/coroutines/CoroutineContext;)V", "lastRequestJob", "Lkotlinx/coroutines/Job;", "Ljava/lang/Object;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "cancelLastRequest", "", "doRequest", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class FullDataRequester<E> {
    /* access modifiers changed from: private */
    @NotNull
    public final MutableSharedFlow<? super E> flow;
    /* access modifiers changed from: private */
    @Nullable
    public Job lastRequestJob;
    /* access modifiers changed from: private */
    public final E requestEvent;
    @NotNull
    private final CoroutineScope scope;

    public FullDataRequester(E e, @NotNull MutableSharedFlow<? super E> mutableSharedFlow, @NotNull CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(mutableSharedFlow, "flow");
        Intrinsics.checkNotNullParameter(coroutineContext, "context");
        this.requestEvent = e;
        this.flow = mutableSharedFlow;
        this.scope = CoroutineScopeKt.a(coroutineContext);
    }

    public final void cancelLastRequest() {
        Job job = this.lastRequestJob;
        if (job != null) {
            Job.DefaultImpls.a(job, (CancellationException) null, 1, (Object) null);
        }
    }

    public final void doRequest() {
        this.lastRequestJob = BuildersKt__Builders_commonKt.d(this.scope, (CoroutineContext) null, (CoroutineStart) null, new FullDataRequester$doRequest$1(this, (Continuation<? super FullDataRequester$doRequest$1>) null), 3, (Object) null);
    }
}
