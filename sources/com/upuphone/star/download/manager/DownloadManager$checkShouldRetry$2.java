package com.upuphone.star.download.manager;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.star.download.manager.DownloadManager$checkShouldRetry$2", f = "DownloadManager.kt", i = {}, l = {239}, m = "invokeSuspend", n = {}, s = {})
public final class DownloadManager$checkShouldRetry$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DownloadListener $downloadListener;
    final /* synthetic */ DownloadTask $downloadTask;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DownloadManager$checkShouldRetry$2(DownloadTask downloadTask, DownloadListener downloadListener, Continuation<? super DownloadManager$checkShouldRetry$2> continuation) {
        super(2, continuation);
        this.$downloadTask = downloadTask;
        this.$downloadListener = downloadListener;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new DownloadManager$checkShouldRetry$2(this.$downloadTask, this.$downloadListener, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            long c = this.$downloadTask.c();
            this.label = 1;
            if (DelayKt.b(c, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        DownloadManager downloadManager = DownloadManager.b;
        DownloadTask downloadTask = this.$downloadTask;
        downloadManager.n("checkShouldRetry, restart download: " + downloadTask);
        downloadManager.v(this.$downloadTask, false, this.$downloadListener);
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((DownloadManager$checkShouldRetry$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
