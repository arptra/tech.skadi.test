package com.upuphone.xr.sapp.monitor.schedule;

import com.upuphone.xr.sapp.monitor.notification.model.ArReminderModel;
import com.upuphone.xr.sapp.monitor.schedule.lark.LarkScheduleProvider;
import com.upuphone.xr.sapp.monitor.schedule.model.LocalScheduleModel;
import com.upuphone.xr.sapp.monitor.schedule.model.SubscribeType;
import com.upuphone.xr.sapp.monitor.schedule.rimet.RimetScheduleProvider;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nScheduleWorker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ScheduleWorker.kt\ncom/upuphone/xr/sapp/monitor/schedule/ScheduleWorker$querySchedule$2\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,72:1\n314#2,11:73\n*S KotlinDebug\n*F\n+ 1 ScheduleWorker.kt\ncom/upuphone/xr/sapp/monitor/schedule/ScheduleWorker$querySchedule$2\n*L\n53#1:73,11\n*E\n"})
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H@"}, d2 = {"<anonymous>", "", "Lcom/upuphone/xr/sapp/monitor/notification/model/ArReminderModel;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.monitor.schedule.ScheduleWorker$querySchedule$2", f = "ScheduleWorker.kt", i = {}, l = {73}, m = "invokeSuspend", n = {}, s = {})
public final class ScheduleWorker$querySchedule$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends ArReminderModel>>, Object> {
    final /* synthetic */ LocalScheduleModel $config;
    Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScheduleWorker$querySchedule$2(LocalScheduleModel localScheduleModel, Continuation<? super ScheduleWorker$querySchedule$2> continuation) {
        super(2, continuation);
        this.$config = localScheduleModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ScheduleWorker$querySchedule$2(this.$config, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            LocalScheduleModel localScheduleModel = this.$config;
            this.L$0 = localScheduleModel;
            this.label = 1;
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(this), 1);
            cancellableContinuationImpl.x();
            ScheduleProvider larkScheduleProvider = localScheduleModel.e() == SubscribeType.feishu ? new LarkScheduleProvider(localScheduleModel) : new RimetScheduleProvider(localScheduleModel);
            larkScheduleProvider.d(new ScheduleWorker$querySchedule$2$1$1(cancellableContinuationImpl));
            larkScheduleProvider.c();
            obj = cancellableContinuationImpl.u();
            if (obj == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(this);
            }
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            LocalScheduleModel localScheduleModel2 = (LocalScheduleModel) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super List<ArReminderModel>> continuation) {
        return ((ScheduleWorker$querySchedule$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
