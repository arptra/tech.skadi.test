package com.upuphone.xr.sapp.monitor.schedule.request;

import com.upuphone.xr.sapp.monitor.schedule.model.LocalScheduleModel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.monitor.schedule.request.ScheduleErrorInterceptor", f = "ScheduleErrorInterceptor.kt", i = {0}, l = {79}, m = "getFsToken", n = {"account"}, s = {"L$0"})
public final class ScheduleErrorInterceptor$getFsToken$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ScheduleErrorInterceptor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScheduleErrorInterceptor$getFsToken$1(ScheduleErrorInterceptor scheduleErrorInterceptor, Continuation<? super ScheduleErrorInterceptor$getFsToken$1> continuation) {
        super(continuation);
        this.this$0 = scheduleErrorInterceptor;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b((LocalScheduleModel) null, this);
    }
}
