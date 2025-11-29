package com.xjsd.ai.assistant.skill.alarm;

import android.content.Context;
import com.xjsd.ai.assistant.core.ContextHelper;
import com.xjsd.ai.assistant.json.JsonUtil;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder;
import com.xjsd.ai.assistant.protocol.alarm.AlarmBusinessData;
import com.xjsd.ai.assistant.protocol.alarm.AlarmExt;
import com.xjsd.ai.assistant.template.TtsAlarmTemplate;
import com.xjsd.ai.assistant.template.TtsGlobalTemplate;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00072\u00020\u0001:\u0001\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/xjsd/ai/assistant/skill/alarm/AlarmDeleteProcessor;", "", "<init>", "()V", "Lcom/xjsd/ai/assistant/protocol/alarm/AlarmExt;", "alarmExt", "", "a", "(Lcom/xjsd/ai/assistant/protocol/alarm/AlarmExt;)V", "Companion", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class AlarmDeleteProcessor {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f8664a = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/xjsd/ai/assistant/skill/alarm/AlarmDeleteProcessor$Companion;", "", "()V", "TAG", "", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public final void a(AlarmExt alarmExt) {
        Intrinsics.checkNotNullParameter(alarmExt, "alarmExt");
        String c = JsonUtil.c(alarmExt);
        ILog.a("AlarmDeleteProcessor", "deleteAlarm: alarm->" + c);
        AlarmHelper alarmHelper = AlarmHelper.f8665a;
        alarmHelper.k();
        Context a2 = ContextHelper.a();
        Intrinsics.checkNotNullExpressionValue(a2, "getContext(...)");
        if (AlarmUtils.c(a2, alarmExt.getId())) {
            new PhoneTtsPlayBuilder().e(TtsGlobalTemplate.GLOBAL06_P01).a().c();
        } else {
            new PhoneTtsPlayBuilder().e(TtsAlarmTemplate.ALARM03_R03).a().c();
        }
        alarmHelper.l(new AlarmBusinessData(7));
    }
}
