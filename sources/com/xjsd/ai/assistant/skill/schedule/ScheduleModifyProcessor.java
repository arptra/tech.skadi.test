package com.xjsd.ai.assistant.skill.schedule;

import android.text.TextUtils;
import com.xjsd.ai.assistant.core.ContextHelper;
import com.xjsd.ai.assistant.json.GsonUtils;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.phone.R;
import com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder;
import com.xjsd.ai.assistant.protocol.VuiModelType;
import com.xjsd.ai.assistant.protocol.schedule.Schedule;
import com.xjsd.ai.assistant.protocol.schedule.ScheduleBusinessData;
import com.xjsd.ai.assistant.protocol.schedule.ScheduleNlpParam;
import com.xjsd.ai.assistant.template.TtsCalTemplate;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\u000f\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\t2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/xjsd/ai/assistant/skill/schedule/ScheduleModifyProcessor;", "Lcom/xjsd/ai/assistant/skill/schedule/ScheduleProcessor;", "<init>", "()V", "Lcom/xjsd/ai/assistant/protocol/schedule/ScheduleBusinessData;", "data", "", "onReceiveScheduleBusinessData", "(Lcom/xjsd/ai/assistant/protocol/schedule/ScheduleBusinessData;)V", "", "i", "()Ljava/lang/String;", "time", "", "array", "g", "(Ljava/lang/String;[Ljava/lang/String;)V", "Lcom/xjsd/ai/assistant/skill/schedule/ScheduleParams;", "params", "c", "(Lcom/xjsd/ai/assistant/skill/schedule/ScheduleParams;)V", "Lcom/xjsd/ai/assistant/protocol/schedule/Schedule;", "schedule", "Lcom/xjsd/ai/assistant/protocol/schedule/ScheduleNlpParam;", "param", "o", "(Lcom/xjsd/ai/assistant/protocol/schedule/Schedule;Lcom/xjsd/ai/assistant/protocol/schedule/ScheduleNlpParam;)V", "b", "Companion", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class ScheduleModifyProcessor extends ScheduleProcessor {
    public static final Companion b = new Companion((DefaultConstructorMarker) null);

    @SourceDebugExtension({"SMAP\nScheduleModifyProcessor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ScheduleModifyProcessor.kt\ncom/xjsd/ai/assistant/skill/schedule/ScheduleModifyProcessor$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,226:1\n1#2:227\n*E\n"})
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002XT¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000e8\u0002XT¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\n8\u0002XT¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/xjsd/ai/assistant/skill/schedule/ScheduleModifyProcessor$Companion;", "", "<init>", "()V", "Lcom/xjsd/ai/assistant/protocol/schedule/ScheduleNlpParam;", "param", "Lcom/xjsd/ai/assistant/protocol/schedule/Schedule;", "schedule", "b", "(Lcom/xjsd/ai/assistant/protocol/schedule/ScheduleNlpParam;Lcom/xjsd/ai/assistant/protocol/schedule/Schedule;)Lcom/xjsd/ai/assistant/protocol/schedule/Schedule;", "", "title", "a", "(Ljava/lang/String;)Ljava/lang/String;", "", "MILLISECOND_ONE_HOUR", "I", "MILLISECOND_TEN_SECONDS", "TAG", "Ljava/lang/String;", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a(String str) {
            Intrinsics.checkNotNullParameter(str, "title");
            return Intrinsics.areEqual((Object) str, (Object) ContextHelper.b(R.string.tts_schedule_def_title, new Object[0])) ? "" : str;
        }

        public final Schedule b(ScheduleNlpParam scheduleNlpParam, Schedule schedule) {
            Long dtEnd;
            Intrinsics.checkNotNullParameter(scheduleNlpParam, "param");
            Intrinsics.checkNotNullParameter(schedule, VuiModelType.SCHEDULE);
            if (!TextUtils.isEmpty(scheduleNlpParam.getTarget())) {
                schedule.setTitle(scheduleNlpParam.getTarget());
            }
            if (!TextUtils.isEmpty(scheduleNlpParam.getDuration())) {
                schedule.setDtStart(schedule.getDtStart() + (Long.parseLong(scheduleNlpParam.getDuration()) * 1000));
                if (!schedule.isRepeatSchedule() && (dtEnd = schedule.getDtEnd()) != null) {
                    schedule.setDtEnd(Long.valueOf(dtEnd.longValue() + (Long.parseLong(scheduleNlpParam.getDuration()) * 1000)));
                }
            } else if (!schedule.isRepeatSchedule()) {
                Long dtEnd2 = schedule.getDtEnd();
                Long valueOf = dtEnd2 != null ? Long.valueOf(dtEnd2.longValue() - schedule.getDtStart()) : null;
                if (!TextUtils.isEmpty(scheduleNlpParam.getStartTime())) {
                    ScheduleUtils scheduleUtils = ScheduleUtils.f8700a;
                    schedule.setDtStart(scheduleUtils.d(scheduleNlpParam.getStartTime()));
                    if (!TextUtils.isEmpty(scheduleNlpParam.getEndTime())) {
                        schedule.setDtEnd(Long.valueOf(scheduleUtils.d(scheduleNlpParam.getEndTime())));
                    } else if (valueOf != null) {
                        schedule.setDtEnd(Long.valueOf(schedule.getDtStart() + valueOf.longValue()));
                    } else {
                        long dtStart = schedule.getDtStart();
                        Long dtEnd3 = schedule.getDtEnd();
                        Intrinsics.checkNotNull(dtEnd3);
                        if (dtStart - dtEnd3.longValue() > 10000) {
                            ILog.a("ScheduleModifyProcessor", "起始时间 晚于 结束时间，修改结束时间");
                            schedule.setDtEnd(Long.valueOf(schedule.getDtStart() + ((long) 3600000)));
                        }
                    }
                } else if (!TextUtils.isEmpty(scheduleNlpParam.getEndTime())) {
                    schedule.setDtEnd(Long.valueOf(ScheduleUtils.f8700a.d(scheduleNlpParam.getEndTime())));
                    if (valueOf != null) {
                        Long dtEnd4 = schedule.getDtEnd();
                        Intrinsics.checkNotNull(dtEnd4);
                        schedule.setDtStart(dtEnd4.longValue() - valueOf.longValue());
                    } else {
                        long dtStart2 = schedule.getDtStart();
                        Long dtEnd5 = schedule.getDtEnd();
                        Intrinsics.checkNotNull(dtEnd5);
                        if (dtStart2 - dtEnd5.longValue() > 10000) {
                            ILog.a("ScheduleModifyProcessor", "起始时间 晚于 结束时间，修改开始时间");
                            Long dtEnd6 = schedule.getDtEnd();
                            Intrinsics.checkNotNull(dtEnd6);
                            schedule.setDtStart(dtEnd6.longValue() - ((long) 3600000));
                        }
                    }
                }
            } else if (!TextUtils.isEmpty(scheduleNlpParam.getStartTime())) {
                ScheduleUtils scheduleUtils2 = ScheduleUtils.f8700a;
                schedule.setDtStart(scheduleUtils2.d(scheduleNlpParam.getStartTime()));
                schedule.setExDateWhenModify(scheduleUtils2.b(schedule.getDtStart()));
            }
            schedule.updateParamForUI();
            return schedule;
        }

        public Companion() {
        }
    }

    public ScheduleModifyProcessor() {
        EventBus.c().o(this);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0119  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void c(com.xjsd.ai.assistant.skill.schedule.ScheduleParams r14) {
        /*
            r13 = this;
            java.lang.String r0 = "params"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            com.alibaba.fastjson.JSONObject r0 = r14.b()
            com.xjsd.ai.assistant.protocol.schedule.ScheduleNlpParam r1 = new com.xjsd.ai.assistant.protocol.schedule.ScheduleNlpParam
            r1.<init>()
            java.lang.String r2 = "index"
            java.lang.String r2 = r0.getString(r2)
            java.lang.String r3 = ""
            if (r2 != 0) goto L_0x0019
            r2 = r3
        L_0x0019:
            r1.setIndex(r2)
            java.lang.String r2 = r14.d()
            r1.setTarget(r2)
            java.lang.String r2 = r14.e()
            r1.setOriginTime(r2)
            java.lang.String r2 = r14.c()
            r1.setStartTime(r2)
            java.lang.String r14 = r14.a()
            r1.setEndTime(r14)
            java.lang.String r14 = "old_target"
            java.lang.String r14 = r0.getString(r14)
            if (r14 != 0) goto L_0x0041
            r14 = r3
        L_0x0041:
            r1.setOldTarget(r14)
            java.lang.String r14 = "duration"
            java.lang.String r14 = r0.getString(r14)
            if (r14 != 0) goto L_0x004d
            r14 = r3
        L_0x004d:
            r1.setDuration(r14)
            java.lang.String r14 = "old_time"
            java.lang.String r14 = r0.getString(r14)
            if (r14 == 0) goto L_0x0069
            java.util.Locale r0 = java.util.Locale.ROOT
            java.lang.String r14 = r14.toLowerCase(r0)
            java.lang.String r0 = "toLowerCase(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r14, r0)
            if (r14 != 0) goto L_0x0067
            goto L_0x0069
        L_0x0067:
            r4 = r14
            goto L_0x006a
        L_0x0069:
            r4 = r3
        L_0x006a:
            java.lang.String r14 = "invalid"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r14)
            r2 = 1
            r10 = 0
            if (r0 == 0) goto L_0x007b
            r1.setOldStartTime(r14)
            r1.setOldEndTime(r14)
            goto L_0x00eb
        L_0x007b:
            java.lang.String r14 = "past"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r4)
            if (r0 == 0) goto L_0x008a
            r1.setOldStartTime(r14)
            r1.setOldEndTime(r14)
            goto L_0x00eb
        L_0x008a:
            boolean r14 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r4)
            r11 = 604800000(0x240c8400, double:2.988109026E-315)
            if (r14 == 0) goto L_0x00b2
            java.util.Date r14 = new java.util.Date
            r14.<init>()
            com.xjsd.ai.assistant.skill.schedule.ScheduleUtils r0 = com.xjsd.ai.assistant.skill.schedule.ScheduleUtils.f8700a
            long r3 = r14.getTime()
            java.lang.String r3 = r0.e(r3)
            r1.setOldStartTime(r3)
            long r3 = r14.getTime()
            long r3 = r3 + r11
            java.lang.String r14 = r0.e(r3)
            r1.setOldEndTime(r14)
            goto L_0x00eb
        L_0x00b2:
            java.lang.String r14 = ","
            java.lang.String[] r5 = new java.lang.String[]{r14}
            r8 = 6
            r9 = 0
            r6 = 0
            r7 = 0
            java.util.List r14 = kotlin.text.StringsKt.split$default((java.lang.CharSequence) r4, (java.lang.String[]) r5, (boolean) r6, (int) r7, (int) r8, (java.lang.Object) r9)
            java.lang.Object r0 = r14.get(r10)
            java.lang.String r0 = (java.lang.String) r0
            r1.setOldStartTime(r0)
            int r0 = r14.size()
            if (r0 <= r2) goto L_0x00d9
            java.lang.Object r14 = r14.get(r2)
            java.lang.String r14 = (java.lang.String) r14
            r1.setOldEndTime(r14)
            goto L_0x00eb
        L_0x00d9:
            com.xjsd.ai.assistant.skill.schedule.ScheduleUtils r14 = com.xjsd.ai.assistant.skill.schedule.ScheduleUtils.f8700a
            java.lang.String r0 = r1.getOldStartTime()
            long r3 = r14.d(r0)
            long r3 = r3 + r11
            java.lang.String r14 = r14.e(r3)
            r1.setOldEndTime(r14)
        L_0x00eb:
            r1.calTime()
            r13.m(r10)
            com.xjsd.ai.assistant.skill.schedule.ScheduleRepository r14 = com.xjsd.ai.assistant.skill.schedule.ScheduleRepository.f8699a
            com.xjsd.ai.assistant.protocol.schedule.Schedule r0 = r14.e()
            if (r0 == 0) goto L_0x0119
            com.xjsd.ai.assistant.protocol.schedule.ScheduleNlpParam r2 = r14.d()
            if (r2 != 0) goto L_0x0103
            r14.j(r1)
            goto L_0x010d
        L_0x0103:
            com.xjsd.ai.assistant.protocol.schedule.ScheduleNlpParam r2 = r14.d()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            r2.update(r1)
        L_0x010d:
            com.xjsd.ai.assistant.protocol.schedule.ScheduleNlpParam r14 = r14.d()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r14)
            r13.o(r0, r14)
            goto L_0x0198
        L_0x0119:
            java.lang.String r0 = r1.getOldStartTime()
            java.util.Date r4 = r13.a(r0)
            java.lang.String r0 = r1.getOldEndTime()
            java.util.Date r5 = r13.a(r0)
            java.lang.String r6 = r1.getOldTarget()
            com.xjsd.ai.assistant.protocol.schedule.ScheduleNlpParam r0 = r14.d()
            if (r0 != 0) goto L_0x0137
            r14.j(r1)
            goto L_0x0141
        L_0x0137:
            com.xjsd.ai.assistant.protocol.schedule.ScheduleNlpParam r0 = r14.d()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            r0.update(r1)
        L_0x0141:
            com.xjsd.ai.assistant.protocol.schedule.ScheduleNlpParam r0 = r14.d()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            java.lang.String r0 = r0.getOriginTime()
            r8 = 8
            r9 = 0
            r7 = 0
            r3 = r14
            java.util.List r1 = com.xjsd.ai.assistant.skill.schedule.ScheduleRepository.i(r3, r4, r5, r6, r7, r8, r9)
            boolean r3 = r1.isEmpty()
            if (r3 == 0) goto L_0x017d
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder r13 = new com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder
            r13.<init>()
            com.xjsd.ai.assistant.template.TtsCalTemplate r14 = com.xjsd.ai.assistant.template.TtsCalTemplate.CAL01_R04
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder$TemplateTts r13 = r13.e(r14)
            java.lang.String r14 = "time"
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder$TemplateTts r13 = r13.k(r14, r0)
            java.lang.String[] r14 = new java.lang.String[]{r0}
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder$TemplateTts r13 = r13.o(r14)
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder r13 = r13.a()
            r13.c()
            goto L_0x0198
        L_0x017d:
            int r0 = r1.size()
            if (r0 != r2) goto L_0x0194
            java.lang.Object r0 = r1.get(r10)
            com.xjsd.ai.assistant.protocol.schedule.Schedule r0 = (com.xjsd.ai.assistant.protocol.schedule.Schedule) r0
            com.xjsd.ai.assistant.protocol.schedule.ScheduleNlpParam r14 = r14.d()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r14)
            r13.o(r0, r14)
            goto L_0x0198
        L_0x0194:
            r14 = 4
            r13.l(r1, r14)
        L_0x0198:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjsd.ai.assistant.skill.schedule.ScheduleModifyProcessor.c(com.xjsd.ai.assistant.skill.schedule.ScheduleParams):void");
    }

    /* JADX WARNING: type inference failed for: r11v0, types: [java.lang.Object, java.lang.String[]] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void g(java.lang.String r10, java.lang.String[] r11) {
        /*
            r9 = this;
            java.lang.String r9 = "time"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r9)
            java.lang.String r9 = "array"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r9)
            java.lang.String r9 = ""
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r10)
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x001a
            r11[r1] = r9
            r11[r2] = r9
            goto L_0x0040
        L_0x001a:
            java.lang.String r0 = ","
            java.lang.String[] r4 = new java.lang.String[]{r0}
            r7 = 6
            r8 = 0
            r5 = 0
            r6 = 0
            r3 = r10
            java.util.List r10 = kotlin.text.StringsKt.split$default((java.lang.CharSequence) r3, (java.lang.String[]) r4, (boolean) r5, (int) r6, (int) r7, (java.lang.Object) r8)
            java.lang.Object r0 = r10.get(r1)
            java.lang.String r0 = (java.lang.String) r0
            r11[r1] = r0
            int r0 = r10.size()
            if (r0 != r2) goto L_0x003a
            r11[r2] = r9
            goto L_0x0040
        L_0x003a:
            java.lang.Object r9 = r10.get(r2)
            r11[r2] = r9
        L_0x0040:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjsd.ai.assistant.skill.schedule.ScheduleModifyProcessor.g(java.lang.String, java.lang.String[]):void");
    }

    public String i() {
        return "modify";
    }

    public final void o(Schedule schedule, ScheduleNlpParam scheduleNlpParam) {
        String e = GsonUtils.e(schedule);
        ILog.a("ScheduleModifyProcessor", "updateSchedule: schedule->" + e);
        if (!Intrinsics.areEqual((Object) "", (Object) scheduleNlpParam.getStartTime()) || !Intrinsics.areEqual((Object) "", (Object) scheduleNlpParam.getEndTime()) || !Intrinsics.areEqual((Object) "", (Object) scheduleNlpParam.getTarget()) || !Intrinsics.areEqual((Object) "", (Object) scheduleNlpParam.getDuration())) {
            k();
            Schedule b2 = b.b(scheduleNlpParam, schedule);
            ScheduleRepository scheduleRepository = ScheduleRepository.f8699a;
            if (scheduleRepository.f(b2)) {
                scheduleRepository.k(b2);
                l(CollectionsKt.mutableListOf(b2), 6);
                new PhoneTtsPlayBuilder().e(TtsCalTemplate.CAL05_R04).g(2).a().c();
                return;
            }
            b();
            new PhoneTtsPlayBuilder().e(TtsCalTemplate.CAL05_R05).g(2).a().c();
            return;
        }
        ScheduleRepository.f8699a.k(schedule);
        b();
        new PhoneTtsPlayBuilder().e(TtsCalTemplate.CAL05_R02).g(2).a().c();
    }

    @Subscribe
    public final void onReceiveScheduleBusinessData(@NotNull ScheduleBusinessData scheduleBusinessData) {
        Intrinsics.checkNotNullParameter(scheduleBusinessData, "data");
        if (scheduleBusinessData.getType() == 4) {
            ScheduleNlpParam d = ScheduleRepository.f8699a.d();
            Intrinsics.checkNotNull(d);
            o((Schedule) GsonUtils.a(GsonUtils.e(scheduleBusinessData.getPayload()), Schedule.class), d);
        }
    }
}
