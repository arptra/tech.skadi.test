package com.xjsd.ai.assistant.skill.alarm;

import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder;
import com.xjsd.ai.assistant.protocol.alarm.Weekdays;
import com.xjsd.ai.assistant.skill.alarm.AlarmCreateException;
import com.xjsd.ai.assistant.skill.alarm.AlarmException;
import com.xjsd.ai.assistant.template.TtsAlarmTemplate;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.Calendar;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.lang3.time.DateUtils;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00102\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ/\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/xjsd/ai/assistant/skill/alarm/AlarmCreateProcessor;", "", "<init>", "()V", "", "time", "name", "", "weekTime", "", "b", "(Ljava/lang/String;Ljava/lang/String;I)V", "hour", "minutes", "Lcom/xjsd/ai/assistant/protocol/alarm/Weekdays;", "daysOfWeek", "a", "(Ljava/lang/String;IILcom/xjsd/ai/assistant/protocol/alarm/Weekdays;)V", "Lcom/xjsd/ai/assistant/skill/alarm/AlarmException;", "e", "c", "(Lcom/xjsd/ai/assistant/skill/alarm/AlarmException;)V", "Companion", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class AlarmCreateProcessor {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f8663a = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/xjsd/ai/assistant/skill/alarm/AlarmCreateProcessor$Companion;", "", "()V", "MILLISECOND_ONE_DAY", "", "MILLISECOND_ONE_HOUR", "TAG", "", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: com.xjsd.ai.assistant.protocol.alarm.Alarm} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r8, int r9, int r10, com.xjsd.ai.assistant.protocol.alarm.Weekdays r11) {
        /*
            r7 = this;
            android.content.Context r7 = com.xjsd.ai.assistant.core.ContextHelper.a()
            com.xjsd.ai.assistant.protocol.alarm.Alarm r0 = new com.xjsd.ai.assistant.protocol.alarm.Alarm
            r0.<init>()
            r0.setHour(r9)
            r0.setMinutes(r10)
            r0.setDaysOfWeek(r11)
            r0.setLabel(r8)
            kotlin.jvm.internal.StringCompanionObject r8 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.Integer r8 = java.lang.Integer.valueOf(r10)
            java.lang.Object[] r8 = new java.lang.Object[]{r8}
            r10 = 1
            java.lang.Object[] r8 = java.util.Arrays.copyOf(r8, r10)
            java.lang.String r1 = "%02d"
            java.lang.String r8 = java.lang.String.format(r1, r8)
            java.lang.String r1 = "format(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r9)
            java.lang.String r9 = ":"
            r1.append(r9)
            r1.append(r8)
            java.lang.String r8 = r1.toString()
            com.xjsd.ai.assistant.skill.alarm.AlarmUtils r9 = com.xjsd.ai.assistant.skill.alarm.AlarmUtils.f8668a
            java.lang.String r1 = r9.g(r11)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)
            java.lang.Object r2 = r9.h(r7, r0)
            boolean r3 = kotlin.Result.m27isSuccessimpl(r2)
            java.lang.String r4 = "time"
            r5 = 2
            if (r3 == 0) goto L_0x00ae
            r0 = r2
            com.xjsd.ai.assistant.protocol.alarm.Alarm r0 = (com.xjsd.ai.assistant.protocol.alarm.Alarm) r0
            boolean r3 = r0.getEnabled()
            if (r3 == 0) goto L_0x0083
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder r3 = new com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder
            r3.<init>()
            com.xjsd.ai.assistant.template.TtsAlarmTemplate r6 = com.xjsd.ai.assistant.template.TtsAlarmTemplate.ALARM02_R04
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder$TemplateTts r3 = r3.e(r6)
            java.lang.String[] r6 = new java.lang.String[]{r8}
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder$TemplateTts r3 = r3.o(r6)
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder$TemplateTts r3 = r3.k(r4, r8)
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder$PhoneTts r3 = r3.g(r5)
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder r3 = r3.a()
            goto L_0x00af
        L_0x0083:
            com.xjsd.ai.assistant.protocol.alarm.Alarm r3 = new com.xjsd.ai.assistant.protocol.alarm.Alarm
            r3.<init>((com.xjsd.ai.assistant.protocol.alarm.Alarm) r0)
            r3.setEnabled(r10)
            r9.j(r7, r3)
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder r3 = new com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder
            r3.<init>()
            com.xjsd.ai.assistant.template.TtsAlarmTemplate r6 = com.xjsd.ai.assistant.template.TtsAlarmTemplate.ALARM02_R05
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder$TemplateTts r3 = r3.e(r6)
            java.lang.String[] r6 = new java.lang.String[]{r8}
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder$TemplateTts r3 = r3.o(r6)
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder$TemplateTts r3 = r3.k(r4, r8)
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder$PhoneTts r3 = r3.g(r5)
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder r3 = r3.a()
            goto L_0x00af
        L_0x00ae:
            r3 = 0
        L_0x00af:
            java.lang.Throwable r2 = kotlin.Result.m23exceptionOrNullimpl(r2)
            if (r2 == 0) goto L_0x010f
            long r2 = r9.a(r7, r0)
            r0.setId(r2)
            com.xjsd.ai.assistant.protocol.alarm.Weekdays$Companion r7 = com.xjsd.ai.assistant.protocol.alarm.Weekdays.Companion
            com.xjsd.ai.assistant.protocol.alarm.Weekdays r7 = r7.getNONE()
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r11, (java.lang.Object) r7)
            if (r7 == 0) goto L_0x00e9
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder r7 = new com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder
            r7.<init>()
            com.xjsd.ai.assistant.template.TtsAlarmTemplate r9 = com.xjsd.ai.assistant.template.TtsAlarmTemplate.ALARM02_R01
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder$TemplateTts r7 = r7.e(r9)
            java.lang.String[] r9 = new java.lang.String[]{r8}
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder$TemplateTts r7 = r7.o(r9)
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder$TemplateTts r7 = r7.k(r4, r8)
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder$PhoneTts r7 = r7.g(r5)
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder r7 = r7.a()
        L_0x00e7:
            r3 = r7
            goto L_0x010f
        L_0x00e9:
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder r7 = new com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder
            r7.<init>()
            com.xjsd.ai.assistant.template.TtsAlarmTemplate r9 = com.xjsd.ai.assistant.template.TtsAlarmTemplate.ALARM02_R01
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder$TemplateTts r7 = r7.e(r9)
            java.lang.String[] r9 = new java.lang.String[]{r8, r1}
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder$TemplateTts r7 = r7.o(r9)
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder$TemplateTts r7 = r7.k(r4, r8)
            java.lang.String r8 = "date"
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder$TemplateTts r7 = r7.k(r8, r1)
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder$PhoneTts r7 = r7.g(r5)
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder r7 = r7.a()
            goto L_0x00e7
        L_0x010f:
            com.xjsd.ai.assistant.skill.alarm.AlarmHelper r7 = com.xjsd.ai.assistant.skill.alarm.AlarmHelper.f8665a
            com.xjsd.ai.assistant.protocol.alarm.AlarmExt$Companion r8 = com.xjsd.ai.assistant.protocol.alarm.AlarmExt.Companion
            com.xjsd.ai.assistant.protocol.alarm.AlarmExt r8 = r8.formatAlarm(r0)
            r7.m(r8)
            com.xjsd.ai.assistant.protocol.alarm.AlarmBusinessData r8 = new com.xjsd.ai.assistant.protocol.alarm.AlarmBusinessData
            r8.<init>(r5)
            r0.setEnabled(r10)
            java.util.List r9 = kotlin.collections.CollectionsKt.listOf(r0)
            r8.setPayload(r9)
            r7.l(r8)
            if (r3 == 0) goto L_0x0131
            r3.c()
        L_0x0131:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjsd.ai.assistant.skill.alarm.AlarmCreateProcessor.a(java.lang.String, int, int, com.xjsd.ai.assistant.protocol.alarm.Weekdays):void");
    }

    public final void b(String str, String str2, int i) {
        Intrinsics.checkNotNullParameter(str, RtspHeaders.Values.TIME);
        Intrinsics.checkNotNullParameter(str2, "name");
        if (Intrinsics.areEqual((Object) "invalid", (Object) str)) {
            new PhoneTtsPlayBuilder().e(TtsAlarmTemplate.ALARM02_R03).a().c();
            return;
        }
        try {
            Date b = AlarmUtils.f8668a.b(str);
            Calendar instance = Calendar.getInstance();
            instance.setTime(b);
            int i2 = instance.get(11);
            int i3 = instance.get(12);
            Weekdays.Companion companion = Weekdays.Companion;
            Weekdays none = companion.getNONE();
            try {
                none = companion.fromBits(i);
            } catch (NumberFormatException unused) {
                ILog.g("AlarmCreateProcessor", "createAlarm: create alarm weekdays invalid, just enable once");
            }
            if (Intrinsics.areEqual((Object) none, (Object) Weekdays.Companion.getNONE())) {
                if (instance.getTimeInMillis() - System.currentTimeMillis() > DateUtils.MILLIS_PER_DAY) {
                    throw new AlarmException.TimeExceedException();
                } else if (instance.getTimeInMillis() < System.currentTimeMillis()) {
                    throw new AlarmException.TimePassedException();
                }
            }
            a(str2, i2, i3, none);
        } catch (Exception unused2) {
            throw new AlarmException.TimeFormatException();
        } catch (AlarmException e) {
            ILog.h("AlarmCreateProcessor", "createAlarm: failed", e);
            c(e);
        }
    }

    public final void c(AlarmException alarmException) {
        if (alarmException instanceof AlarmException.TimeFormatException) {
            new PhoneTtsPlayBuilder().e(TtsAlarmTemplate.ALARM02_R06).g(2).a().c();
        } else if (alarmException instanceof AlarmException.TimeExceedException) {
            new PhoneTtsPlayBuilder().e(TtsAlarmTemplate.ALARM02_R08).a().c();
        } else if (alarmException instanceof AlarmException.TimePassedException) {
            new PhoneTtsPlayBuilder().e(TtsAlarmTemplate.ALARM02_R07).a().c();
        } else {
            if (alarmException instanceof AlarmCreateException.TimeFormatException ? true : alarmException instanceof AlarmCreateException.SqliteException) {
                new PhoneTtsPlayBuilder().e(TtsAlarmTemplate.ALARM02_R03).a().c();
            }
        }
    }
}
