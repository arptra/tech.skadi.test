package com.xjsd.ai.assistant.skill.schedule;

import com.upuphone.starrynet.payload.PayloadConstant;
import com.xjsd.ai.assistant.common.util.DeviceBrandUtil;
import com.xjsd.ai.assistant.json.GsonUtils;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder;
import com.xjsd.ai.assistant.protocol.schedule.Schedule;
import com.xjsd.ai.assistant.protocol.schedule.ScheduleBusinessData;
import com.xjsd.ai.assistant.template.TtsCalTemplate;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\u000f\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\t2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/xjsd/ai/assistant/skill/schedule/ScheduleDeleteProcessor;", "Lcom/xjsd/ai/assistant/skill/schedule/ScheduleProcessor;", "<init>", "()V", "Lcom/xjsd/ai/assistant/protocol/schedule/ScheduleBusinessData;", "data", "", "onReceiveScheduleBusinessData", "(Lcom/xjsd/ai/assistant/protocol/schedule/ScheduleBusinessData;)V", "", "i", "()Ljava/lang/String;", "time", "", "array", "g", "(Ljava/lang/String;[Ljava/lang/String;)V", "Lcom/xjsd/ai/assistant/skill/schedule/ScheduleParams;", "params", "c", "(Lcom/xjsd/ai/assistant/skill/schedule/ScheduleParams;)V", "Lcom/xjsd/ai/assistant/protocol/schedule/Schedule;", "schedule", "type", "o", "(Lcom/xjsd/ai/assistant/protocol/schedule/Schedule;Ljava/lang/String;)V", "b", "Companion", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class ScheduleDeleteProcessor extends ScheduleProcessor {
    public static final Companion b = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/xjsd/ai/assistant/skill/schedule/ScheduleDeleteProcessor$Companion;", "", "()V", "TAG", "", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public ScheduleDeleteProcessor() {
        EventBus.c().o(this);
    }

    public void c(ScheduleParams scheduleParams) {
        Intrinsics.checkNotNullParameter(scheduleParams, PayloadConstant.KEY_PARAMS);
        m(false);
        String string = scheduleParams.b().getString("index");
        if (string == null) {
            string = "";
        }
        ScheduleRepository scheduleRepository = ScheduleRepository.f8699a;
        Schedule e = scheduleRepository.e();
        if (e != null) {
            o(e, string);
            return;
        }
        Date a2 = a(scheduleParams.c());
        Date a3 = a(scheduleParams.a());
        String d = scheduleParams.d();
        String e2 = scheduleParams.e();
        k();
        List i = ScheduleRepository.i(scheduleRepository, a2, a3, d, false, 8, (Object) null);
        if (i.isEmpty()) {
            new PhoneTtsPlayBuilder().e(TtsCalTemplate.CAL01_R04).k(RtspHeaders.Values.TIME, e2).o(e2).a().c();
        } else if (i.size() == 1) {
            o((Schedule) i.get(0), "");
        } else {
            l(i, 3);
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
        throw new UnsupportedOperationException("Method not decompiled: com.xjsd.ai.assistant.skill.schedule.ScheduleDeleteProcessor.g(java.lang.String, java.lang.String[]):void");
    }

    public String i() {
        return "delete";
    }

    public final void o(Schedule schedule, String str) {
        String e = GsonUtils.e(schedule);
        ILog.a("ScheduleDeleteProcessor", "deleteSchedule: deleteType->" + str + ", data->" + e);
        if (DeviceBrandUtil.f()) {
            str = "whole";
        }
        String duration = schedule.getDuration();
        if (duration == null || duration.length() == 0 || Intrinsics.areEqual((Object) str, (Object) "current") || Intrinsics.areEqual((Object) str, (Object) "all") || Intrinsics.areEqual((Object) str, (Object) "whole")) {
            k();
            new PhoneTtsPlayBuilder().e(ScheduleRepository.f8699a.b(schedule, str) ? TtsCalTemplate.CAL04_R03 : TtsCalTemplate.CAL04_R04).a().c();
            b();
            return;
        }
        ScheduleRepository.f8699a.k(schedule);
        b();
        new PhoneTtsPlayBuilder().e(TtsCalTemplate.CAL04_R02).g(2).a().c();
    }

    @Subscribe
    public final void onReceiveScheduleBusinessData(@NotNull ScheduleBusinessData scheduleBusinessData) {
        Intrinsics.checkNotNullParameter(scheduleBusinessData, "data");
        if (scheduleBusinessData.getType() == 3) {
            o((Schedule) GsonUtils.a(GsonUtils.e(scheduleBusinessData.getPayload()), Schedule.class), "");
        }
    }
}
