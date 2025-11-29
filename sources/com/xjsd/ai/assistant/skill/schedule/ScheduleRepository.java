package com.xjsd.ai.assistant.skill.schedule;

import android.content.Context;
import android.text.TextUtils;
import com.meizu.common.widget.MzContactsContract;
import com.xjsd.ai.assistant.core.ContextHelper;
import com.xjsd.ai.assistant.json.GsonUtils;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.phone.event.UserAbortEvent;
import com.xjsd.ai.assistant.protocol.VuiModelType;
import com.xjsd.ai.assistant.protocol.schedule.Event;
import com.xjsd.ai.assistant.protocol.schedule.Instance;
import com.xjsd.ai.assistant.protocol.schedule.Schedule;
import com.xjsd.ai.assistant.protocol.schedule.ScheduleNlpParam;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\n\u001a\u00020\tø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0012\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0014\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0014\u0010\u0015J'\u0010\u0019\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\f¢\u0006\u0004\b\u0019\u0010\u001aJ7\u0010!\u001a\b\u0012\u0004\u0012\u00020\t0 2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001b2\b\b\u0002\u0010\u001e\u001a\u00020\u000f2\b\b\u0002\u0010\u001f\u001a\u00020\u0011¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b#\u0010$R\u0014\u0010'\u001a\u00020%8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010&R$\u0010,\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b#\u0010(\u001a\u0004\b)\u0010$\"\u0004\b*\u0010+R$\u00103\u001a\u0004\u0018\u00010-8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b.\u00100\"\u0004\b1\u00102\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u00064"}, d2 = {"Lcom/xjsd/ai/assistant/skill/schedule/ScheduleRepository;", "", "<init>", "()V", "Lcom/xjsd/ai/assistant/phone/event/UserAbortEvent;", "event", "", "onReceiveUserAbortEvent", "(Lcom/xjsd/ai/assistant/phone/event/UserAbortEvent;)V", "Lcom/xjsd/ai/assistant/protocol/schedule/Schedule;", "schedule", "Lkotlin/Result;", "", "a", "(Lcom/xjsd/ai/assistant/protocol/schedule/Schedule;)Ljava/lang/Object;", "", "delType", "", "b", "(Lcom/xjsd/ai/assistant/protocol/schedule/Schedule;Ljava/lang/String;)Z", "f", "(Lcom/xjsd/ai/assistant/protocol/schedule/Schedule;)Z", "eventId", "startTime", "endTime", "g", "(JJJ)Lcom/xjsd/ai/assistant/protocol/schedule/Schedule;", "Ljava/util/Date;", "startDate", "endDate", "target", "explicitlyInclude", "", "h", "(Ljava/util/Date;Ljava/util/Date;Ljava/lang/String;Z)Ljava/util/List;", "c", "()Lcom/xjsd/ai/assistant/protocol/schedule/Schedule;", "Lcom/xjsd/ai/assistant/skill/schedule/ScheduleHelper;", "Lcom/xjsd/ai/assistant/skill/schedule/ScheduleHelper;", "mScheduleHelper", "Lcom/xjsd/ai/assistant/protocol/schedule/Schedule;", "e", "k", "(Lcom/xjsd/ai/assistant/protocol/schedule/Schedule;)V", "mSelectSchedule", "Lcom/xjsd/ai/assistant/protocol/schedule/ScheduleNlpParam;", "d", "Lcom/xjsd/ai/assistant/protocol/schedule/ScheduleNlpParam;", "()Lcom/xjsd/ai/assistant/protocol/schedule/ScheduleNlpParam;", "j", "(Lcom/xjsd/ai/assistant/protocol/schedule/ScheduleNlpParam;)V", "mModifyScheduleNlpParam", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nScheduleRepository.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ScheduleRepository.kt\ncom/xjsd/ai/assistant/skill/schedule/ScheduleRepository\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,179:1\n1855#2,2:180\n1855#2,2:182\n1855#2,2:184\n*S KotlinDebug\n*F\n+ 1 ScheduleRepository.kt\ncom/xjsd/ai/assistant/skill/schedule/ScheduleRepository\n*L\n129#1:180,2\n134#1:182,2\n160#1:184,2\n*E\n"})
public final class ScheduleRepository {

    /* renamed from: a  reason: collision with root package name */
    public static final ScheduleRepository f8699a;
    public static final ScheduleHelper b = new ScheduleHelper();
    public static Schedule c;
    public static ScheduleNlpParam d;

    static {
        ScheduleRepository scheduleRepository = new ScheduleRepository();
        f8699a = scheduleRepository;
        EventBus.c().o(scheduleRepository);
    }

    public static /* synthetic */ List i(ScheduleRepository scheduleRepository, Date date, Date date2, String str, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            str = "";
        }
        if ((i & 8) != 0) {
            z = false;
        }
        return scheduleRepository.h(date, date2, str, z);
    }

    public final Object a(Schedule schedule) {
        Intrinsics.checkNotNullParameter(schedule, VuiModelType.SCHEDULE);
        ScheduleHelper scheduleHelper = b;
        Context a2 = ContextHelper.a();
        Intrinsics.checkNotNullExpressionValue(a2, "getContext(...)");
        long dtStart = schedule.getDtStart();
        Long dtEnd = schedule.getDtEnd();
        Intrinsics.checkNotNull(dtEnd);
        return scheduleHelper.c(a2, dtStart, dtEnd.longValue(), schedule.getTitle());
    }

    public final boolean b(Schedule schedule, String str) {
        String str2;
        Intrinsics.checkNotNullParameter(schedule, VuiModelType.SCHEDULE);
        Intrinsics.checkNotNullParameter(str, "delType");
        Context a2 = ContextHelper.a();
        if (!schedule.isRepeatSchedule()) {
            ScheduleHelper scheduleHelper = b;
            Context a3 = ContextHelper.a();
            Intrinsics.checkNotNullExpressionValue(a3, "getContext(...)");
            return scheduleHelper.f(a3, schedule.getId());
        } else if (Intrinsics.areEqual((Object) str, (Object) "all")) {
            String ruleWithUntil = schedule.getRuleWithUntil(ScheduleUtils.f8700a.a(schedule.getInstanceBegin() - ((long) 100)));
            ILog.a("ScheduleRepository", "deleteSchedule: old rrule->" + schedule.getRrule() + ", new rrule->" + ruleWithUntil);
            ScheduleHelper scheduleHelper2 = b;
            Intrinsics.checkNotNull(a2);
            return scheduleHelper2.e(a2, schedule, ruleWithUntil);
        } else if (Intrinsics.areEqual((Object) str, (Object) "current")) {
            String exDate = schedule.getExDate();
            if (TextUtils.isEmpty(exDate)) {
                str2 = ScheduleUtils.f8700a.a(schedule.getInstanceBegin());
            } else {
                str2 = exDate + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA + ScheduleUtils.f8700a.a(schedule.getInstanceBegin());
            }
            ScheduleHelper scheduleHelper3 = b;
            Intrinsics.checkNotNull(a2);
            return scheduleHelper3.d(a2, schedule, str2);
        } else {
            ScheduleHelper scheduleHelper4 = b;
            Context a4 = ContextHelper.a();
            Intrinsics.checkNotNullExpressionValue(a4, "getContext(...)");
            return scheduleHelper4.f(a4, schedule.getId());
        }
    }

    public final Schedule c() {
        try {
            Context a2 = ContextHelper.a();
            HashMap hashMap = new HashMap();
            ScheduleHelper scheduleHelper = b;
            Intrinsics.checkNotNull(a2);
            for (Event event : ScheduleHelper.h(scheduleHelper, a2, (String) null, 2, (Object) null)) {
                hashMap.put(event.getId(), event);
            }
            Date date = new Date();
            for (Instance instance : b.j(a2, date.getTime(), date.getTime() + 604800000)) {
                Event event2 = (Event) hashMap.remove(instance.getEventId());
                if (event2 != null) {
                    ILog.a("ScheduleRepository", "getLatestSchedule: find last event->" + event2);
                    return new Schedule(event2, instance);
                }
            }
        } catch (Exception e) {
            ILog.h("ScheduleRepository", "getLatestSchedule: error", e);
        }
        return null;
    }

    public final ScheduleNlpParam d() {
        return d;
    }

    public final Schedule e() {
        return c;
    }

    public final boolean f(Schedule schedule) {
        Intrinsics.checkNotNullParameter(schedule, VuiModelType.SCHEDULE);
        String e = GsonUtils.e(schedule);
        ILog.j("ScheduleRepository", "modifySchedule: schedule->" + e);
        ScheduleHelper scheduleHelper = b;
        Context a2 = ContextHelper.a();
        Intrinsics.checkNotNullExpressionValue(a2, "getContext(...)");
        return scheduleHelper.l(a2, schedule);
    }

    public final Schedule g(long j, long j2, long j3) {
        Context a2 = ContextHelper.a();
        ScheduleHelper scheduleHelper = b;
        Intrinsics.checkNotNull(a2);
        Event k = scheduleHelper.k(a2, j);
        if (k == null) {
            return null;
        }
        for (Instance instance : scheduleHelper.j(a2, j2, j3)) {
            if (Intrinsics.areEqual((Object) instance.getEventId(), (Object) k.getId())) {
                return new Schedule(k, instance);
            }
        }
        return null;
    }

    public final List h(Date date, Date date2, String str, boolean z) {
        Intrinsics.checkNotNullParameter(date, "startDate");
        Intrinsics.checkNotNullParameter(date2, "endDate");
        Intrinsics.checkNotNullParameter(str, "target");
        ILog.a("ScheduleRepository", "getSchedule: startDate->" + date + ", endDate->" + date2 + ", target->" + str);
        Context a2 = ContextHelper.a();
        long time = date.getTime();
        long time2 = date2.getTime();
        HashMap hashMap = new HashMap();
        ScheduleHelper scheduleHelper = b;
        Intrinsics.checkNotNull(a2);
        for (Event event : scheduleHelper.g(a2, str)) {
            ILog.a("ScheduleRepository", "queryScheduleList: event->" + event);
            hashMap.put(event.getId(), event);
        }
        ArrayList arrayList = new ArrayList();
        for (Instance instance : b.j(a2, time, time2)) {
            ILog.a("ScheduleRepository", "queryScheduleList: instance->" + instance);
            Event event2 = (Event) hashMap.get(instance.getEventId());
            if (event2 != null) {
                if (!z) {
                    arrayList.add(new Schedule(event2, instance));
                } else if (time >= instance.getBegin() - 1000 && time2 <= instance.getEnd() + 1000) {
                    arrayList.add(new Schedule(event2, instance));
                }
            }
        }
        String e = GsonUtils.e(arrayList);
        ILog.a("ScheduleRepository", "queryScheduleList: 查询日程返回数据->" + e);
        return arrayList.size() > 15 ? arrayList.subList(0, RangesKt.coerceAtMost(arrayList.size(), 15)) : arrayList;
    }

    public final void j(ScheduleNlpParam scheduleNlpParam) {
        d = scheduleNlpParam;
    }

    public final void k(Schedule schedule) {
        c = schedule;
    }

    @Subscribe
    public final void onReceiveUserAbortEvent(@NotNull UserAbortEvent userAbortEvent) {
        Intrinsics.checkNotNullParameter(userAbortEvent, "event");
        c = null;
        d = null;
    }
}
