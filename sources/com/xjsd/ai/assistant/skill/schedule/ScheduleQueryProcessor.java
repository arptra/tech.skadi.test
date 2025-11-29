package com.xjsd.ai.assistant.skill.schedule;

import android.text.TextUtils;
import com.google.android.gms.actions.SearchIntents;
import com.upuphone.starrynet.payload.PayloadConstant;
import com.xjsd.ai.assistant.core.ContextHelper;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.phone.R;
import com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder;
import com.xjsd.ai.assistant.protocol.schedule.Schedule;
import com.xjsd.ai.assistant.template.TtsCalTemplate;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J%\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/xjsd/ai/assistant/skill/schedule/ScheduleQueryProcessor;", "Lcom/xjsd/ai/assistant/skill/schedule/ScheduleProcessor;", "<init>", "()V", "", "i", "()Ljava/lang/String;", "time", "", "array", "", "g", "(Ljava/lang/String;[Ljava/lang/String;)V", "Lcom/xjsd/ai/assistant/skill/schedule/ScheduleParams;", "params", "c", "(Lcom/xjsd/ai/assistant/skill/schedule/ScheduleParams;)V", "title", "o", "(Ljava/lang/String;)Ljava/lang/String;", "b", "Companion", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class ScheduleQueryProcessor extends ScheduleProcessor {
    public static final Companion b = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/xjsd/ai/assistant/skill/schedule/ScheduleQueryProcessor$Companion;", "", "()V", "TAG", "", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public void c(ScheduleParams scheduleParams) {
        Intrinsics.checkNotNullParameter(scheduleParams, PayloadConstant.KEY_PARAMS);
        m(true);
        k();
        Date a2 = a(scheduleParams.c());
        Date a3 = a(scheduleParams.a());
        String e = scheduleParams.e();
        String d = scheduleParams.d();
        ScheduleRepository scheduleRepository = ScheduleRepository.f8699a;
        List i = ScheduleRepository.i(scheduleRepository, a2, a3, d, false, 8, (Object) null);
        int size = i.size();
        ILog.a("ScheduleQueryProcessor", "execute: 查询日程返回个数->" + size);
        l(i, 0);
        if (i.isEmpty()) {
            new PhoneTtsPlayBuilder().e(TtsCalTemplate.CAL01_R04).o(e).k(RtspHeaders.Values.TIME, e).a().c();
        } else if (i.size() == 1) {
            Schedule schedule = (Schedule) i.get(0);
            String timeInfo = schedule.timeInfo();
            String o = o(schedule.getTitle());
            new PhoneTtsPlayBuilder().e(TtsCalTemplate.CAL01_R03).o(timeInfo, o).k("CAL_time", timeInfo).k("CAL_title", o).g(2).a().c();
        } else {
            Schedule schedule2 = (Schedule) i.get(0);
            String valueOf = String.valueOf(i.size());
            String timeInfo2 = schedule2.timeInfo();
            String o2 = o(schedule2.getTitle());
            if (TextUtils.isEmpty(e)) {
                new PhoneTtsPlayBuilder().e(TtsCalTemplate.CAL01_R02).o(valueOf, timeInfo2, o2).k("num", valueOf).k("CAL_time", timeInfo2).k("CAL_title", o2).g(2).a().c();
                return;
            }
            Schedule c = scheduleRepository.c();
            if (c == null || !i.contains(c)) {
                new PhoneTtsPlayBuilder().e(TtsCalTemplate.CAL01_R06).o(e, valueOf).k(RtspHeaders.Values.TIME, e).k("num", valueOf).g(2).a().c();
            } else {
                new PhoneTtsPlayBuilder().e(TtsCalTemplate.CAL01_R05).o(e, valueOf, timeInfo2, o2).k(RtspHeaders.Values.TIME, e).k("num", valueOf).k("CAL_time", timeInfo2).k("CAL_title", o2).g(2).a().c();
            }
        }
    }

    /* JADX WARNING: type inference failed for: r12v0, types: [java.lang.Object, java.lang.String[]] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void g(java.lang.String r11, java.lang.String[] r12) {
        /*
            r10 = this;
            java.lang.String r10 = "time"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r10)
            java.lang.String r10 = "array"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r10)
            java.lang.String r10 = ""
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r11)
            r0 = 604800000(0x240c8400, double:2.988109026E-315)
            r2 = 0
            r3 = 1
            if (r10 == 0) goto L_0x0035
            java.util.Date r10 = new java.util.Date
            r10.<init>()
            com.xjsd.ai.assistant.skill.schedule.ScheduleUtils r11 = com.xjsd.ai.assistant.skill.schedule.ScheduleUtils.f8700a
            long r4 = r10.getTime()
            java.lang.String r4 = r11.e(r4)
            r12[r2] = r4
            long r4 = r10.getTime()
            long r4 = r4 + r0
            java.lang.String r10 = r11.e(r4)
            r12[r3] = r10
            goto L_0x0067
        L_0x0035:
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
            int r2 = r10.size()
            r4 = 2
            if (r2 != r4) goto L_0x005a
            java.lang.Object r10 = r10.get(r3)
            r12[r3] = r10
            goto L_0x0067
        L_0x005a:
            com.xjsd.ai.assistant.skill.schedule.ScheduleUtils r10 = com.xjsd.ai.assistant.skill.schedule.ScheduleUtils.f8700a
            long r4 = r10.d(r11)
            long r4 = r4 + r0
            java.lang.String r10 = r10.e(r4)
            r12[r3] = r10
        L_0x0067:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjsd.ai.assistant.skill.schedule.ScheduleQueryProcessor.g(java.lang.String, java.lang.String[]):void");
    }

    public String i() {
        return SearchIntents.EXTRA_QUERY;
    }

    public final String o(String str) {
        return Intrinsics.areEqual((Object) str, (Object) ContextHelper.b(R.string.tts_schedule_def_title, new Object[0])) ? "" : str;
    }
}
