package com.xjsd.ai.assistant.skill.alarm;

import android.content.Context;
import com.honey.account.constant.AccountConstantKt;
import com.xjsd.ai.assistant.core.ContextHelper;
import com.xjsd.ai.assistant.json.JsonUtil;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder;
import com.xjsd.ai.assistant.protocol.alarm.Alarm;
import com.xjsd.ai.assistant.protocol.alarm.AlarmBusinessData;
import com.xjsd.ai.assistant.protocol.alarm.AlarmExt;
import com.xjsd.ai.assistant.protocol.alarm.Weekdays;
import com.xjsd.ai.assistant.template.TtsAlarmTemplate;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u00052\u00020\u0001:\u0001$B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003J7\u0010\u000e\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0006¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0014\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J'\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001d\u0010\u0012J\u0017\u0010\u001e\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u001e\u0010\u001fR\u0018\u0010!\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010 R\u0016\u0010#\u001a\u00020\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\"¨\u0006%"}, d2 = {"Lcom/xjsd/ai/assistant/skill/alarm/AlarmModifyProcessor;", "", "<init>", "()V", "", "c", "Lcom/xjsd/ai/assistant/protocol/alarm/AlarmExt;", "selectAlarmExt", "", "time", "name", "", "weekTime", "tag", "f", "(Lcom/xjsd/ai/assistant/protocol/alarm/AlarmExt;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "alarmExt", "b", "(Lcom/xjsd/ai/assistant/protocol/alarm/AlarmExt;)V", "", "d", "(Ljava/lang/String;Ljava/lang/String;I)Z", "src", "Ljava/util/Date;", "date", "Lcom/xjsd/ai/assistant/protocol/alarm/Weekdays;", "weekdays", "g", "(Lcom/xjsd/ai/assistant/protocol/alarm/AlarmExt;Ljava/util/Date;Lcom/xjsd/ai/assistant/protocol/alarm/Weekdays;)V", "e", "a", "(Ljava/util/Date;)Ljava/lang/String;", "Ljava/util/Date;", "modifyDate", "Lcom/xjsd/ai/assistant/protocol/alarm/Weekdays;", "modifyWeekdays", "Companion", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class AlarmModifyProcessor {
    public static final Companion c = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public Date f8666a;
    public Weekdays b = Weekdays.Companion.getNONE();

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/xjsd/ai/assistant/skill/alarm/AlarmModifyProcessor$Companion;", "", "()V", "TAG", "", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public final String a(Date date) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        int i = instance.get(11);
        int i2 = instance.get(12);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(new Object[]{Integer.valueOf(i2)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return i + AccountConstantKt.CODE_SEPARTOR + format;
    }

    public final void b(AlarmExt alarmExt) {
        Intrinsics.checkNotNullParameter(alarmExt, "alarmExt");
        AlarmHelper alarmHelper = AlarmHelper.f8665a;
        alarmHelper.m(alarmExt);
        if (this.f8666a == null) {
            new PhoneTtsPlayBuilder().e(TtsAlarmTemplate.ALARM04_R02).g(2).a().c();
            return;
        }
        AlarmExt e = alarmHelper.e();
        Intrinsics.checkNotNull(e);
        Date date = this.f8666a;
        Intrinsics.checkNotNull(date);
        g(e, date, this.b);
    }

    public final void c() {
        this.f8666a = null;
        this.b = Weekdays.Companion.getNONE();
    }

    public final boolean d(String str, String str2, int i) {
        if (Intrinsics.areEqual((Object) "invalid", (Object) str)) {
            ILog.a("AlarmModifyProcessor", "saveUpdateParam: invalid time");
            return false;
        }
        try {
            this.f8666a = AlarmUtils.f8668a.b(str);
            try {
                this.b = Weekdays.Companion.fromBits(i);
            } catch (NumberFormatException unused) {
                ILog.g("AlarmModifyProcessor", "saveUpdateParam: create alarm weekdays invalid, just enable once");
            }
            Date date = this.f8666a;
            ILog.j("AlarmModifyProcessor", "saveUpdateParam: saveUpdateParam:  " + date);
            return true;
        } catch (Exception e) {
            ILog.h("AlarmModifyProcessor", "saveUpdateParam: failed", e);
            return false;
        }
    }

    public final void e(AlarmExt alarmExt) {
        AlarmHelper alarmHelper = AlarmHelper.f8665a;
        alarmHelper.m(alarmExt);
        AlarmBusinessData alarmBusinessData = new AlarmBusinessData(6);
        alarmBusinessData.setPayload(CollectionsKt.listOf(alarmExt));
        alarmHelper.l(alarmBusinessData);
    }

    public final void f(AlarmExt alarmExt, String str, String str2, int i, String str3) {
        Intrinsics.checkNotNullParameter(str, RtspHeaders.Values.TIME);
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(str3, "tag");
        String c2 = JsonUtil.c(alarmExt);
        ILog.a("AlarmModifyProcessor", "updateAlarm: the select alarm->" + c2);
        c();
        if (alarmExt == null) {
            AlarmUtils alarmUtils = AlarmUtils.f8668a;
            Context a2 = ContextHelper.a();
            Intrinsics.checkNotNullExpressionValue(a2, "getContext(...)");
            if (alarmUtils.f(a2, -1, str3).isEmpty()) {
                new PhoneTtsPlayBuilder().e(TtsAlarmTemplate.ALARM03_R02).a().c();
            } else {
                new PhoneTtsPlayBuilder().e(TtsAlarmTemplate.ALARM04_R04).a().c();
            }
        } else if (d(str, str2, i)) {
            Date date = this.f8666a;
            Intrinsics.checkNotNull(date);
            g(alarmExt, date, this.b);
        } else {
            new PhoneTtsPlayBuilder().e(TtsAlarmTemplate.ALARM04_R02).g(2).a().c();
        }
    }

    public final void g(AlarmExt alarmExt, Date date, Weekdays weekdays) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        alarmExt.setHour(instance.get(11));
        alarmExt.setMinutes(instance.get(12));
        if (!Intrinsics.areEqual((Object) weekdays, (Object) Weekdays.Companion.getNONE())) {
            alarmExt.setDaysOfWeek(weekdays);
        }
        alarmExt.setEnabled(true);
        c();
        AlarmHelper.f8665a.m((AlarmExt) null);
        Context a2 = ContextHelper.a();
        Intrinsics.checkNotNullExpressionValue(a2, "getContext(...)");
        if (AlarmUtils.i(a2, alarmExt)) {
            AlarmUtils alarmUtils = AlarmUtils.f8668a;
            Context a3 = ContextHelper.a();
            Intrinsics.checkNotNullExpressionValue(a3, "getContext(...)");
            Object d = alarmUtils.d(a3, alarmExt.getId());
            if (Result.m27isSuccessimpl(d)) {
                e(AlarmExt.Companion.formatAlarm((Alarm) d));
            }
            if (Result.m23exceptionOrNullimpl(d) != null) {
                e(alarmExt);
            }
            String a4 = a(date);
            new PhoneTtsPlayBuilder().e(TtsAlarmTemplate.ALARM04_R03).o(a4).k(RtspHeaders.Values.TIME, a4).g(2).a().c();
            return;
        }
        new PhoneTtsPlayBuilder().e(TtsAlarmTemplate.ALARM03_R03).a().c();
    }
}
