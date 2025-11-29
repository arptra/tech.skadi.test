package com.upuphone.xr.sapp.vu.utils;

import android.content.Intent;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.vu.utils.ArSpaceReportHelper;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.vu.utils.VuScreenRecordHelper$startScreenRecord$1", f = "VuScreenRecordHelper.kt", i = {0}, l = {213}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
public final class VuScreenRecordHelper$startScreenRecord$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ VuScreenRecordHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VuScreenRecordHelper$startScreenRecord$1(VuScreenRecordHelper vuScreenRecordHelper, Continuation<? super VuScreenRecordHelper$startScreenRecord$1> continuation) {
        super(2, continuation);
        this.this$0 = vuScreenRecordHelper;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        VuScreenRecordHelper$startScreenRecord$1 vuScreenRecordHelper$startScreenRecord$1 = new VuScreenRecordHelper$startScreenRecord$1(this.this$0, continuation);
        vuScreenRecordHelper$startScreenRecord$1.L$0 = obj;
        return vuScreenRecordHelper$startScreenRecord$1;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            VuScreenRecordHelper vuScreenRecordHelper = this.this$0;
            this.L$0 = (CoroutineScope) this.L$0;
            this.label = 1;
            obj = vuScreenRecordHelper.O(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Intent intent = (Intent) obj;
        if (intent == null) {
            ArSpaceReportHelper.e(ArSpaceReportHelper.f8088a, ArSpaceReportHelper.ScreenRecordResult.NOT_AUTHORIZE, 0, (String) null, 6, (Object) null);
            return Unit.INSTANCE;
        }
        VuScreenRecordHelper vuScreenRecordHelper2 = this.this$0;
        try {
            Result.Companion companion = Result.Companion;
            vuScreenRecordHelper2.J();
            vuScreenRecordHelper2.K();
            vuScreenRecordHelper2.T();
            vuScreenRecordHelper2.D().startRecord(intent);
            obj2 = Result.m20constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj2 = Result.m20constructorimpl(ResultKt.createFailure(th));
        }
        VuScreenRecordHelper vuScreenRecordHelper3 = this.this$0;
        Throwable r8 = Result.m23exceptionOrNullimpl(obj2);
        if (r8 != null) {
            ULog.f6446a.d("ScreenRecordHelper", "startScreenRecord error", r8);
            ArSpaceReportHelper arSpaceReportHelper = ArSpaceReportHelper.f8088a;
            ArSpaceReportHelper.ScreenRecordResult screenRecordResult = ArSpaceReportHelper.ScreenRecordResult.ERROR;
            String message = r8.getMessage();
            if (message == null) {
                message = "";
            }
            arSpaceReportHelper.d(screenRecordResult, 0, message);
            vuScreenRecordHelper3.I((String) null);
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((VuScreenRecordHelper$startScreenRecord$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
