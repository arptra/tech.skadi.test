package com.upuphone.xr.sapp.monitor.schedule;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.monitor.schedule.ScheduleWorker", f = "ScheduleWorker.kt", i = {0, 0, 0, 0}, l = {32}, m = "doWork", n = {"this", "result", "account", "dataArray"}, s = {"L$0", "L$1", "L$3", "L$4"})
public final class ScheduleWorker$doWork$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ScheduleWorker this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScheduleWorker$doWork$1(ScheduleWorker scheduleWorker, Continuation<? super ScheduleWorker$doWork$1> continuation) {
        super(continuation);
        this.this$0 = scheduleWorker;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.r(this);
    }
}
