package com.upuphone.xr.sapp.glass;

import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.entity.GlassScreenShotState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.glass.GlassScreenShotHelper$startScreenShot$1", f = "GlassScreenShotHelper.kt", i = {}, l = {243}, m = "invokeSuspend", n = {}, s = {})
public final class GlassScreenShotHelper$startScreenShot$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $timeout;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlassScreenShotHelper$startScreenShot$1(long j, Continuation<? super GlassScreenShotHelper$startScreenShot$1> continuation) {
        super(2, continuation);
        this.$timeout = j;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GlassScreenShotHelper$startScreenShot$1(this.$timeout, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        int i2 = 999;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            GlassScreenShotHelper.g.setValue(new GlassScreenShotState.Running((String) null, 0));
            long j = this.$timeout;
            GlassScreenShotHelper$startScreenShot$1$result$1 glassScreenShotHelper$startScreenShot$1$result$1 = new GlassScreenShotHelper$startScreenShot$1$result$1((Continuation<? super GlassScreenShotHelper$startScreenShot$1$result$1>) null);
            this.label = 1;
            obj = TimeoutKt.c(j, glassScreenShotHelper$startScreenShot$1$result$1, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Exception e) {
                ULog.f6446a.d("GlassScreenShotHelper", "startScreenShot, error:", e);
                GlassScreenShotHelper.b.H((String) null, 999);
                return Unit.INSTANCE;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        GlassScreenshotResult glassScreenshotResult = (GlassScreenshotResult) obj;
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("GlassScreenShotHelper", "startScreenShot, result: " + glassScreenshotResult);
        if (glassScreenshotResult == null || glassScreenshotResult.getErrorCode() != 200) {
            GlassScreenShotHelper glassScreenShotHelper = GlassScreenShotHelper.b;
            String taskId = glassScreenshotResult != null ? glassScreenshotResult.getTaskId() : null;
            if (glassScreenshotResult != null) {
                i2 = glassScreenshotResult.getErrorCode();
            }
            glassScreenShotHelper.H(taskId, i2);
            GlassScreenShotHelper.d = null;
            GlassScreenShotHelper.e = Boxing.boxBoolean(false);
        } else {
            GlassScreenShotHelper glassScreenShotHelper2 = GlassScreenShotHelper.b;
            GlassScreenShotHelper.d = glassScreenshotResult.getTaskId();
            GlassScreenShotHelper.e = glassScreenshotResult.getUseEncoding();
            GlassScreenShotHelper.b.w();
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GlassScreenShotHelper$startScreenShot$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
