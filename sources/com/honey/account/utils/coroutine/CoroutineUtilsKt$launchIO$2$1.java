package com.honey.account.utils.coroutine;

import com.honey.account.utils.log.LogUtils;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "T", "run"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class CoroutineUtilsKt$launchIO$2$1 implements Runnable {
    final /* synthetic */ Function0<T> $block;
    final /* synthetic */ Continuation<T> $continuation;

    public CoroutineUtilsKt$launchIO$2$1(Function0<? extends T> function0, Continuation<? super T> continuation) {
        this.$block = function0;
        this.$continuation = continuation;
    }

    public final void run() {
        try {
            this.$continuation.resumeWith(Result.m20constructorimpl(this.$block.invoke()));
        } catch (Exception e) {
            LogUtils logUtils = LogUtils.INSTANCE;
            logUtils.e("CoroutineUtils", "suspend launchIO command error: " + e);
            Continuation<T> continuation = this.$continuation;
            Result.Companion companion = Result.Companion;
            continuation.resumeWith(Result.m20constructorimpl(ResultKt.createFailure(e)));
        }
    }
}
