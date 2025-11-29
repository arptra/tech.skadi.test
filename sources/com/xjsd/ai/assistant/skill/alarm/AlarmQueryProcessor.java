package com.xjsd.ai.assistant.skill.alarm;

import android.content.Context;
import com.xjsd.ai.assistant.core.ContextHelper;
import com.xjsd.ai.assistant.json.JsonUtil;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder;
import com.xjsd.ai.assistant.protocol.alarm.Alarm;
import com.xjsd.ai.assistant.protocol.alarm.AlarmBusinessData;
import com.xjsd.ai.assistant.protocol.alarm.AlarmExt;
import com.xjsd.ai.assistant.template.TtsAlarmTemplate;
import com.xjsd.ai.assistant.template.TtsNotDefinedTemplate;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \b2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/xjsd/ai/assistant/skill/alarm/AlarmQueryProcessor;", "", "<init>", "()V", "", "enable", "tag", "", "a", "(Ljava/lang/String;Ljava/lang/String;)V", "", "enableArg", "b", "(ILjava/lang/String;)V", "Companion", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class AlarmQueryProcessor {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f8667a = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/xjsd/ai/assistant/skill/alarm/AlarmQueryProcessor$Companion;", "", "()V", "ALARM_DISABLED", "", "ALARM_ENABLED", "ALARM_INVALID", "TAG", "", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public final void a(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "enable");
        Intrinsics.checkNotNullParameter(str2, "tag");
        Boolean booleanStrictOrNull = StringsKt.toBooleanStrictOrNull(str);
        int i = Intrinsics.areEqual((Object) booleanStrictOrNull, (Object) Boolean.TRUE) ? 1 : Intrinsics.areEqual((Object) booleanStrictOrNull, (Object) Boolean.FALSE) ? 0 : -1;
        AlarmUtils alarmUtils = AlarmUtils.f8668a;
        Context a2 = ContextHelper.a();
        Intrinsics.checkNotNullExpressionValue(a2, "getContext(...)");
        List f = alarmUtils.f(a2, i, str2);
        String c = JsonUtil.c(f);
        ILog.j("AlarmQueryProcessor", "queryAlarm: get alarm list->" + c);
        if (f.size() == 1) {
            AlarmHelper.f8665a.m(AlarmExt.Companion.formatAlarm((Alarm) f.get(0)));
        }
        AlarmHelper alarmHelper = AlarmHelper.f8665a;
        AlarmBusinessData alarmBusinessData = new AlarmBusinessData(0);
        alarmBusinessData.setPayload(f);
        alarmHelper.l(alarmBusinessData);
        b(i, str2);
    }

    public final void b(int i, String str) {
        AlarmUtils alarmUtils = AlarmUtils.f8668a;
        Context a2 = ContextHelper.a();
        Intrinsics.checkNotNullExpressionValue(a2, "getContext(...)");
        int e = alarmUtils.e(a2, -1, str);
        if (e == 0) {
            new PhoneTtsPlayBuilder().e(TtsAlarmTemplate.ALARM01_R02).g(2).a().c();
        } else if (i == -1) {
            new PhoneTtsPlayBuilder().e(TtsAlarmTemplate.ALARM01_R01).o(String.valueOf(e)).k("num", String.valueOf(e)).g(2).a().c();
        } else {
            Context a3 = ContextHelper.a();
            Intrinsics.checkNotNullExpressionValue(a3, "getContext(...)");
            int e2 = alarmUtils.e(a3, i, str);
            ILog.j("AlarmQueryProcessor", "speakResultTts: get enabled->" + i + ", alarm Count->" + e2);
            String valueOf = String.valueOf(e2);
            if (i == 0) {
                if (e2 == 0) {
                    new PhoneTtsPlayBuilder().e(TtsNotDefinedTemplate.ALARM04_R05).a().c();
                } else {
                    new PhoneTtsPlayBuilder().e(TtsNotDefinedTemplate.ALARM04_R06).o(valueOf).k("num", valueOf).g(2).a().c();
                }
            } else if (e2 == 0) {
                new PhoneTtsPlayBuilder().e(TtsAlarmTemplate.ALARM01_R04).a().c();
            } else {
                new PhoneTtsPlayBuilder().e(TtsAlarmTemplate.ALARM01_R03).o(valueOf).k("num", valueOf).g(2).a().c();
            }
        }
    }
}
