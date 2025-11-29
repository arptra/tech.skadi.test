package com.upuphone.xr.interconnect.util.statemachine;

import android.util.Log;
import com.upuphone.xr.interconnect.util.log.PrettyPrintExtKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.sync.Semaphore;
import org.aspectj.lang.JoinPoint;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a3\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u0002H\u0002¢\u0006\u0002\u0010\t\u001a#\u0010\n\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001a\u0002H\u0002¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"emitAction", "", "E", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "lock", "Lkotlinx/coroutines/sync/Semaphore;", "event", "(Lkotlinx/coroutines/flow/MutableSharedFlow;Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/sync/Semaphore;Ljava/lang/Object;)V", "emitOrErr", "(Lkotlinx/coroutines/flow/MutableSharedFlow;Ljava/lang/Object;)V", "Shared_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class FlowExtKt {
    public static final <E> void emitAction(@NotNull MutableSharedFlow<E> mutableSharedFlow, @NotNull CoroutineScope coroutineScope, @NotNull Semaphore semaphore, E e) {
        Intrinsics.checkNotNullParameter(mutableSharedFlow, "<this>");
        Intrinsics.checkNotNullParameter(coroutineScope, "scope");
        Intrinsics.checkNotNullParameter(semaphore, JoinPoint.SYNCHRONIZATION_LOCK);
        Job unused = BuildersKt__Builders_commonKt.d(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new FlowExtKt$emitAction$1(semaphore, mutableSharedFlow, e, (Continuation<? super FlowExtKt$emitAction$1>) null), 3, (Object) null);
    }

    public static final <E> void emitOrErr(@NotNull MutableSharedFlow<E> mutableSharedFlow, E e) {
        Intrinsics.checkNotNullParameter(mutableSharedFlow, "<this>");
        if (!mutableSharedFlow.b(e)) {
            Log.e("FlowExt", "Failed inserting " + e + " into " + PrettyPrintExtKt.stringify(mutableSharedFlow) + ", it's highly possible that event processing has stopped.");
        }
    }
}
