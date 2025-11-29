package com.upuphone.xr.sapp.monitor.schedule.lark;

import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.monitor.notification.model.ArReminderModel;
import com.upuphone.xr.sapp.monitor.schedule.ScheduleRequestManager;
import com.upuphone.xr.sapp.monitor.schedule.ScheduleUpdateListener;
import com.upuphone.xr.sapp.monitor.schedule.config.ScheduleConfig;
import com.upuphone.xr.sapp.monitor.schedule.model.BaseResp;
import com.upuphone.xr.sapp.monitor.schedule.model.FsScheduleArrayRespModel;
import com.upuphone.xr.sapp.monitor.schedule.model.RemoteCalendarModel;
import com.upuphone.xr.sapp.monitor.schedule.model.ScheduleArrayRespModel;
import com.upuphone.xr.sapp.monitor.schedule.request.ScheduleApi;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nLarkScheduleProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LarkScheduleProvider.kt\ncom/upuphone/xr/sapp/monitor/schedule/lark/LarkScheduleProvider$query$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,102:1\n1855#2:103\n1855#2,2:104\n1856#2:106\n*S KotlinDebug\n*F\n+ 1 LarkScheduleProvider.kt\ncom/upuphone/xr/sapp/monitor/schedule/lark/LarkScheduleProvider$query$2\n*L\n59#1:103\n66#1:104,2\n59#1:106\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.monitor.schedule.lark.LarkScheduleProvider$query$2", f = "LarkScheduleProvider.kt", i = {}, l = {45}, m = "invokeSuspend", n = {}, s = {})
public final class LarkScheduleProvider$query$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ LarkScheduleProvider this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LarkScheduleProvider$query$2(LarkScheduleProvider larkScheduleProvider, Continuation<? super LarkScheduleProvider$query$2> continuation) {
        super(2, continuation);
        this.this$0 = larkScheduleProvider;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new LarkScheduleProvider$query$2(this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object obj2;
        Iterator<T> it;
        String timestamp;
        Long longOrNull;
        Long longOrNull2;
        String timestamp2;
        Long longOrNull3;
        String str;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            LocalDate now = LocalDate.now();
            long epochSecond = now.atStartOfDay(ZoneId.systemDefault()).toEpochSecond();
            long epochSecond2 = now.plusDays(1).atStartOfDay(ZoneId.systemDefault()).plusDays(1).minusSeconds(1).toEpochSecond();
            ScheduleApi c = ScheduleRequestManager.f7781a.c();
            Pair pair = TuplesKt.to("type", ScheduleConfig.f7785a.a().name());
            RemoteCalendarModel d = this.this$0.a().d();
            if (d == null || (str = d.a()) == null) {
                str = "";
            }
            HashMap hashMapOf = MapsKt.hashMapOf(pair, TuplesKt.to("userAccessToken", str), TuplesKt.to("startTime", Boxing.boxLong(epochSecond)), TuplesKt.to("endTime", Boxing.boxLong(epochSecond2)), TuplesKt.to("getWay", this.this$0.a().e().name()));
            String c2 = this.this$0.a().c();
            this.label = 1;
            obj2 = c.getCalendar(hashMapOf, c2, this);
            if (obj2 == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
            obj2 = obj;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        BaseResp baseResp = (BaseResp) obj2;
        FsScheduleArrayRespModel calendarFsResultPO = ((ScheduleArrayRespModel) baseResp.b()).getCalendarFsResultPO();
        List<FsScheduleArrayRespModel.FsSchedule> items = calendarFsResultPO != null ? calendarFsResultPO.getItems() : null;
        if (baseResp.a() == 0 || baseResp.a() == 200) {
            ArrayList arrayList = new ArrayList();
            if (items != null && !items.isEmpty()) {
                LarkScheduleProvider larkScheduleProvider = this.this$0;
                Iterator<T> it2 = items.iterator();
                while (it2.hasNext()) {
                    FsScheduleArrayRespModel.FsSchedule fsSchedule = (FsScheduleArrayRespModel.FsSchedule) it2.next();
                    if (fsSchedule.getEventId() == null || Intrinsics.areEqual((Object) fsSchedule.getStatus(), (Object) "cancelled")) {
                        it = it2;
                    } else {
                        ArrayList arrayList2 = new ArrayList();
                        FsScheduleArrayRespModel.FsSchedule.StartTime startTime = fsSchedule.getStartTime();
                        long j = (long) 1000;
                        long longValue = ((startTime == null || (timestamp2 = startTime.getTimestamp()) == null || (longOrNull3 = StringsKt.toLongOrNull(timestamp2)) == null) ? 0 : longOrNull3.longValue()) * j;
                        for (FsScheduleArrayRespModel.FsSchedule.Reminder minutes : fsSchedule.getReminders()) {
                            arrayList2.add(Boxing.boxLong(longValue - ((long) (minutes.getMinutes() * 60000))));
                        }
                        if (arrayList2.isEmpty()) {
                            arrayList2.add(Boxing.boxLong(longValue));
                        }
                        String eventId = fsSchedule.getEventId();
                        String createTime = fsSchedule.getCreateTime();
                        long longValue2 = ((createTime == null || (longOrNull2 = StringsKt.toLongOrNull(createTime)) == null) ? 0 : longOrNull2.longValue()) * j;
                        String summary = fsSchedule.getSummary();
                        String str2 = summary == null ? "" : summary;
                        Long boxLong = Boxing.boxLong(longValue);
                        FsScheduleArrayRespModel.FsSchedule.EndTime endTime = fsSchedule.getEndTime();
                        it = it2;
                        ArReminderModel arReminderModel = r8;
                        ArReminderModel arReminderModel2 = new ArReminderModel(eventId, longValue2, "com.ss.android.lark", str2, boxLong, Boxing.boxLong(((endTime == null || (timestamp = endTime.getTimestamp()) == null || (longOrNull = StringsKt.toLongOrNull(timestamp)) == null) ? 0 : longOrNull.longValue()) * j), larkScheduleProvider.a().c(), arrayList2);
                        arrayList.add(arReminderModel);
                    }
                    it2 = it;
                }
            }
            ULog.Delegate delegate = ULog.f6446a;
            int size = arrayList.size();
            delegate.a("Schedule-LarkScheduleProvider", "query succeed size:" + size);
            ScheduleUpdateListener b = this.this$0.b();
            if (b != null) {
                b.a(arrayList);
            }
        } else {
            ULog.Delegate delegate2 = ULog.f6446a;
            String c3 = baseResp.c();
            delegate2.a("Schedule-LarkScheduleProvider", "query fail " + c3);
            ScheduleUpdateListener b2 = this.this$0.b();
            if (b2 != null) {
                b2.a((List) null);
            }
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((LarkScheduleProvider$query$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
