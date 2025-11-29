package com.honey.account.utils.coroutine;

import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationKt;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a:\u0010\u0002\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u001c\u0010\u0007\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\bø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001a%\u0010\f\u001a\u0002H\u0004\"\u0004\b\u0000\u0010\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00040\rH@ø\u0001\u0000¢\u0006\u0002\u0010\u000e\u001a%\u0010\u000f\u001a\u0002H\u0004\"\u0004\b\u0000\u0010\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00040\rH@ø\u0001\u0000¢\u0006\u0002\u0010\u000e\u001a,\u0010\u0010\u001a\u00020\u00032\u001c\u0010\u0007\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\bø\u0001\u0000¢\u0006\u0002\u0010\u0011\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"TAG", "", "coroutine", "", "T", "executor", "Ljava/util/concurrent/Executor;", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Ljava/util/concurrent/Executor;Lkotlin/jvm/functions/Function1;)V", "launchDefault", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "launchIO", "launchMain", "(Lkotlin/jvm/functions/Function1;)V", "CoreLibrary_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class CoroutineUtilsKt {
    @NotNull
    private static final String TAG = "CoroutineUtils";

    public static final <T> void coroutine(@NotNull Executor executor, @NotNull Function1<? super Continuation<? super T>, ? extends Object> function1) {
        Intrinsics.checkNotNullParameter(executor, "executor");
        Intrinsics.checkNotNullParameter(function1, "block");
        ContinuationKt.startCoroutine(function1, new CoroutineUtilsKt$coroutine$1(executor));
    }

    @Nullable
    public static final <T> Object launchDefault(@NotNull Function0<? extends T> function0, @NotNull Continuation<? super T> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        DispatcherHelper.Companion.getDefault().execute(new CoroutineUtilsKt$launchDefault$2$1(function0, safeContinuation));
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    @Nullable
    public static final <T> Object launchIO(@NotNull Function0<? extends T> function0, @NotNull Continuation<? super T> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        DispatcherHelper.Companion.getIO().execute(new CoroutineUtilsKt$launchIO$2$1(function0, safeContinuation));
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public static final void launchMain(@NotNull Function1<? super Continuation<? super Unit>, ? extends Object> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        coroutine(DispatcherHelper.Companion.getMain(), function1);
    }
}
