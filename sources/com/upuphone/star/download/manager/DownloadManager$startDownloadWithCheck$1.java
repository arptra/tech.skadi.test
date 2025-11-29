package com.upuphone.star.download.manager;

import com.upuphone.star.download.manager.db.DownloadStatus;
import com.upuphone.star.download.manager.db.DownloadStatusKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.star.download.manager.DownloadManager$startDownloadWithCheck$1", f = "DownloadManager.kt", i = {}, l = {123}, m = "invokeSuspend", n = {}, s = {})
public final class DownloadManager$startDownloadWithCheck$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DownloadListener $downloadListener;
    final /* synthetic */ DownloadTask $downloadTask;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DownloadManager$startDownloadWithCheck$1(DownloadTask downloadTask, DownloadListener downloadListener, Continuation<? super DownloadManager$startDownloadWithCheck$1> continuation) {
        super(2, continuation);
        this.$downloadTask = downloadTask;
        this.$downloadListener = downloadListener;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new DownloadManager$startDownloadWithCheck$1(this.$downloadTask, this.$downloadListener, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            DownloadManager downloadManager = DownloadManager.b;
            String d = this.$downloadTask.d();
            String absolutePath = this.$downloadTask.a().getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
            this.label = 1;
            obj = downloadManager.r(d, absolutePath, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        DownloadStatus downloadStatus = (DownloadStatus) obj;
        if (downloadStatus == null || !DownloadStatusKt.a(downloadStatus)) {
            DownloadManager.b.v(this.$downloadTask, true, this.$downloadListener);
            return Unit.INSTANCE;
        }
        this.$downloadListener.a(this.$downloadTask);
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((DownloadManager$startDownloadWithCheck$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
