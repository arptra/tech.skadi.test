package com.xjsd.ai.assistant.skill.schedule;

import com.upuphone.starrynet.payload.PayloadConstant;
import com.xjsd.ai.assistant.core.ContextHelper;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.phone.R;
import com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder;
import com.xjsd.ai.assistant.protocol.schedule.Schedule;
import com.xjsd.ai.assistant.skill.call.util.PhoneCallUtil;
import com.xjsd.ai.assistant.skill.schedule.ScheduleException;
import com.xjsd.ai.assistant.template.TtsCalTemplate;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00112\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J%\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/xjsd/ai/assistant/skill/schedule/ScheduleCreateProcessor;", "Lcom/xjsd/ai/assistant/skill/schedule/ScheduleProcessor;", "<init>", "()V", "", "i", "()Ljava/lang/String;", "time", "", "array", "", "g", "(Ljava/lang/String;[Ljava/lang/String;)V", "Lcom/xjsd/ai/assistant/skill/schedule/ScheduleParams;", "params", "c", "(Lcom/xjsd/ai/assistant/skill/schedule/ScheduleParams;)V", "b", "Companion", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class ScheduleCreateProcessor extends ScheduleProcessor {
    public static final Companion b = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/xjsd/ai/assistant/skill/schedule/ScheduleCreateProcessor$Companion;", "", "()V", "TAG", "", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public void c(ScheduleParams scheduleParams) {
        Intrinsics.checkNotNullParameter(scheduleParams, PayloadConstant.KEY_PARAMS);
        boolean containsKey = scheduleParams.b().containsKey("confirm");
        m(false);
        k();
        Date a2 = a(scheduleParams.c());
        Date a3 = a(scheduleParams.a());
        String b2 = Intrinsics.areEqual((Object) "", (Object) scheduleParams.d()) ? ContextHelper.b(R.string.tts_schedule_def_title, new Object[0]) : scheduleParams.d();
        if (!containsKey && PhoneCallUtil.c()) {
            ScheduleRepository scheduleRepository = ScheduleRepository.f8699a;
            Intrinsics.checkNotNull(b2);
            List<Schedule> h = scheduleRepository.h(a2, a3, b2, true);
            if (true ^ h.isEmpty()) {
                for (Schedule schedule : h) {
                    if (schedule.getInstanceBegin() == a2.getTime() && schedule.getInstanceEnd() == a3.getTime() && Intrinsics.areEqual((Object) schedule.getTitle(), (Object) b2)) {
                        ILog.a("ScheduleCreateProcessor", "handleCreateCommand: 已有重复日程，直接更新");
                        ScheduleRepository.f8699a.f(schedule);
                        String timeInfo = schedule.timeInfo();
                        new PhoneTtsPlayBuilder().e(TtsCalTemplate.CAL02_R05).o(timeInfo).k("CAL_time", timeInfo).g(2).a().c();
                        return;
                    }
                }
            }
        }
        CoroutineScopeKt.a(Dispatchers.b());
        try {
            Result.Companion companion = Result.Companion;
            Intrinsics.checkNotNull(b2);
            Schedule schedule2 = new Schedule(b2, a2.getTime(), a3.getTime());
            ScheduleRepository scheduleRepository2 = ScheduleRepository.f8699a;
            Object a4 = scheduleRepository2.a(schedule2);
            if (Result.m27isSuccessimpl(a4)) {
                long longValue = ((Number) a4).longValue();
                ILog.a("ScheduleCreateProcessor", "createSchedule: success, result id->" + longValue);
                schedule2.setId(String.valueOf(longValue));
                String timeInfo2 = schedule2.timeInfo();
                scheduleRepository2.k(schedule2);
                l(CollectionsKt.listOf(schedule2), 2);
                new PhoneTtsPlayBuilder().e(TtsCalTemplate.CAL02_R05).o(timeInfo2).k("CAL_time", timeInfo2).g(2).a().c();
            }
            Throwable r12 = Result.m23exceptionOrNullimpl(a4);
            if (r12 != null) {
                String message = r12.getMessage();
                ILog.a("ScheduleCreateProcessor", "createSchedule: failure, message->" + message);
                if (!StringsKt.contains$default((CharSequence) String.valueOf(r12.getMessage()), (CharSequence) "lack WRITE_CALENDAR permission", false, 2, (Object) null)) {
                    new PhoneTtsPlayBuilder().e(TtsCalTemplate.CAL02_R06).a().c();
                } else {
                    throw new ScheduleException.ScheduleWritePermissionException();
                }
            }
            Result.m20constructorimpl(Result.m19boximpl(a4));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.m20constructorimpl(ResultKt.createFailure(th));
        }
    }

    /* JADX WARNING: type inference failed for: r12v0, types: [java.lang.Object, java.lang.String[]] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void g(java.lang.String r11, java.lang.String[] r12) {
        /*
            r10 = this;
            java.lang.String r0 = "time"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "array"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = ""
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r11)
            r2 = 0
            r3 = 1
            if (r1 != 0) goto L_0x0052
            boolean r10 = r10.f(r11)
            if (r10 == 0) goto L_0x001c
            goto L_0x0052
        L_0x001c:
            java.lang.String r10 = ","
            java.lang.String[] r5 = new java.lang.String[]{r10}
            r8 = 6
            r9 = 0
            r6 = 0
            r7 = 0
            r4 = r11
            java.util.List r10 = kotlin.text.StringsKt.split$default((java.lang.CharSequence) r4, (java.lang.String[]) r5, (boolean) r6, (int) r7, (int) r8, (java.lang.Object) r9)
            java.lang.Object r11 = r10.get(r2)
            java.lang.String r11 = (java.lang.String) r11
            r12[r2] = r11
            int r0 = r10.size()
            r1 = 2
            if (r0 != r1) goto L_0x0041
            java.lang.Object r10 = r10.get(r3)
            r12[r3] = r10
            goto L_0x0056
        L_0x0041:
            com.xjsd.ai.assistant.skill.schedule.ScheduleUtils r10 = com.xjsd.ai.assistant.skill.schedule.ScheduleUtils.f8700a
            long r0 = r10.d(r11)
            r4 = 3600000(0x36ee80, double:1.7786363E-317)
            long r0 = r0 + r4
            java.lang.String r10 = r10.e(r0)
            r12[r3] = r10
            goto L_0x0056
        L_0x0052:
            r12[r2] = r0
            r12[r3] = r0
        L_0x0056:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjsd.ai.assistant.skill.schedule.ScheduleCreateProcessor.g(java.lang.String, java.lang.String[]):void");
    }

    public String i() {
        return "create";
    }
}
