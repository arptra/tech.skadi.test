package com.upuphone.xr.sapp.vu.utils;

import android.net.Uri;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.vu.utils.ArSpaceReportHelper;
import java.io.File;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.vu.utils.VuScreenRecordHelper$screenShot$1", f = "VuScreenRecordHelper.kt", i = {0}, l = {137}, m = "invokeSuspend", n = {"file"}, s = {"L$1"})
public final class VuScreenRecordHelper$screenShot$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ VuScreenRecordHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VuScreenRecordHelper$screenShot$1(VuScreenRecordHelper vuScreenRecordHelper, Continuation<? super VuScreenRecordHelper$screenShot$1> continuation) {
        super(2, continuation);
        this.this$0 = vuScreenRecordHelper;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        VuScreenRecordHelper$screenShot$1 vuScreenRecordHelper$screenShot$1 = new VuScreenRecordHelper$screenShot$1(this.this$0, continuation);
        vuScreenRecordHelper$screenShot$1.L$0 = obj;
        return vuScreenRecordHelper$screenShot$1;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object obj2;
        VuScreenRecordHelper vuScreenRecordHelper;
        File file;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            VuScreenRecordHelper vuScreenRecordHelper2 = this.this$0;
            Result.Companion companion = Result.Companion;
            vuScreenRecordHelper2.F();
            vuScreenRecordHelper2.H();
            vuScreenRecordHelper2.D().screenshot();
            String recordPath = vuScreenRecordHelper2.D().getRecordPath();
            File file2 = new File(recordPath);
            ULog.Delegate delegate = ULog.f6446a;
            long length = file2.length();
            delegate.a("ScreenRecordHelper", "screenShot path:" + recordPath + ", size: " + length);
            CoroutineDispatcher b = Dispatchers.b();
            VuScreenRecordHelper$screenShot$1$1$uri$1 vuScreenRecordHelper$screenShot$1$1$uri$1 = new VuScreenRecordHelper$screenShot$1$1$uri$1(file2, vuScreenRecordHelper2, (Continuation<? super VuScreenRecordHelper$screenShot$1$1$uri$1>) null);
            this.L$0 = vuScreenRecordHelper2;
            this.L$1 = file2;
            this.label = 1;
            Object g = BuildersKt.g(b, vuScreenRecordHelper$screenShot$1$1$uri$1, this);
            if (g == coroutine_suspended) {
                return coroutine_suspended;
            }
            file = file2;
            VuScreenRecordHelper vuScreenRecordHelper3 = vuScreenRecordHelper2;
            obj = g;
            vuScreenRecordHelper = vuScreenRecordHelper3;
        } else if (i == 1) {
            file = (File) this.L$1;
            vuScreenRecordHelper = (VuScreenRecordHelper) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj2 = Result.m20constructorimpl(ResultKt.createFailure(th));
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Uri uri = (Uri) obj;
        ULog.f6446a.a("ScreenRecordHelper", "screenShot file: uri");
        vuScreenRecordHelper.y(file);
        if (uri == null) {
            ArSpaceReportHelper.g(ArSpaceReportHelper.f8088a, ArSpaceReportHelper.ScreenshotResult.FILE_SAVE_ERROR, (String) null, 2, (Object) null);
        } else {
            ArSpaceReportHelper.g(ArSpaceReportHelper.f8088a, ArSpaceReportHelper.ScreenshotResult.SUCCESS, (String) null, 2, (Object) null);
        }
        vuScreenRecordHelper.G(String.valueOf(uri));
        obj2 = Result.m20constructorimpl(Unit.INSTANCE);
        Throwable r12 = Result.m23exceptionOrNullimpl(obj2);
        if (r12 != null) {
            ULog.f6446a.d("ScreenRecordHelper", "screenShot error", r12);
            ArSpaceReportHelper arSpaceReportHelper = ArSpaceReportHelper.f8088a;
            ArSpaceReportHelper.ScreenshotResult screenshotResult = ArSpaceReportHelper.ScreenshotResult.ERROR;
            String message = r12.getMessage();
            if (message == null) {
                message = "";
            }
            arSpaceReportHelper.f(screenshotResult, message);
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((VuScreenRecordHelper$screenShot$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
