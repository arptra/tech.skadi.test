package com.upuphone.star.download.manager;

import com.upuphone.star.download.manager.db.DownloadDao;
import com.upuphone.star.download.manager.db.DownloadDb;
import com.upuphone.star.download.manager.db.DownloadStatus;
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
@DebugMetadata(c = "com.upuphone.star.download.manager.DownloadManager$onDownloadComplete$1", f = "DownloadManager.kt", i = {}, l = {207}, m = "invokeSuspend", n = {}, s = {})
public final class DownloadManager$onDownloadComplete$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DownloadListener $downloadListener;
    final /* synthetic */ DownloadTask $downloadTask;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DownloadManager$onDownloadComplete$1(DownloadTask downloadTask, DownloadListener downloadListener, Continuation<? super DownloadManager$onDownloadComplete$1> continuation) {
        super(2, continuation);
        this.$downloadTask = downloadTask;
        this.$downloadListener = downloadListener;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new DownloadManager$onDownloadComplete$1(this.$downloadTask, this.$downloadListener, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            DownloadManager downloadManager = DownloadManager.b;
            DownloadTask downloadTask = this.$downloadTask;
            downloadManager.n("onDownloadComplete: " + downloadTask);
            String d = this.$downloadTask.d();
            String absolutePath = this.$downloadTask.a().getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
            DownloadStatus downloadStatus = new DownloadStatus(d, absolutePath, this.$downloadTask.a().length(), 1.0f);
            DownloadDao f = DownloadDb.f6469a.b(downloadManager.l()).f();
            this.label = 1;
            if (f.b(downloadStatus, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.$downloadListener.a(this.$downloadTask);
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((DownloadManager$onDownloadComplete$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
