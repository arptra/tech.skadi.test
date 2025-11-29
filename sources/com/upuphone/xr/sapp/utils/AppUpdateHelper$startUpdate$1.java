package com.upuphone.xr.sapp.utils;

import com.upuphone.star.core.log.ULog;
import com.upuphone.star.download.manager.DownloadManager;
import com.upuphone.star.download.manager.db.DownloadStatus;
import com.upuphone.star.download.manager.db.DownloadStatusKt;
import com.upuphone.xr.sapp.entity.AppUpdateInfo;
import java.io.File;
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
@DebugMetadata(c = "com.upuphone.xr.sapp.utils.AppUpdateHelper$startUpdate$1", f = "AppUpdateHelper.kt", i = {}, l = {427}, m = "invokeSuspend", n = {}, s = {})
public final class AppUpdateHelper$startUpdate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $downloadLink;
    final /* synthetic */ File $file;
    final /* synthetic */ AppUpdateInfo $updateInfo;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AppUpdateHelper$startUpdate$1(String str, File file, AppUpdateInfo appUpdateInfo, Continuation<? super AppUpdateHelper$startUpdate$1> continuation) {
        super(2, continuation);
        this.$downloadLink = str;
        this.$file = file;
        this.$updateInfo = appUpdateInfo;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new AppUpdateHelper$startUpdate$1(this.$downloadLink, this.$file, this.$updateInfo, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            DownloadManager downloadManager = DownloadManager.b;
            String str = this.$downloadLink;
            String absolutePath = this.$file.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
            this.label = 1;
            obj = downloadManager.r(str, absolutePath, this);
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
            AppUpdateHelper.O(AppUpdateHelper.f7841a, false, 1, (Object) null);
            return Unit.INSTANCE;
        }
        ULog.f6446a.a("AppUpdateHelper", "startUpdate, isComplete: true");
        AppUpdateHelper.f7841a.x(this.$updateInfo, this.$file);
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((AppUpdateHelper$startUpdate$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
