package com.xjsd.ai.assistant.skill.alarm;

import android.content.Context;
import com.xjsd.ai.assistant.common.Communicator;
import com.xjsd.ai.assistant.core.ContextHelper;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.phone.event.DomainChangeEvent;
import com.xjsd.ai.assistant.phone.event.UserAbortEvent;
import com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder;
import com.xjsd.ai.assistant.protocol.BusinessDataType;
import com.xjsd.ai.assistant.protocol.VuiModelType;
import com.xjsd.ai.assistant.protocol.alarm.Alarm;
import com.xjsd.ai.assistant.protocol.alarm.AlarmBusinessData;
import com.xjsd.ai.assistant.protocol.alarm.AlarmExt;
import com.xjsd.ai.assistant.template.TtsAlarmTemplate;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\tH\u0007¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\u0003J%\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u00062\b\b\u0002\u0010\u0014\u001a\u00020\r¢\u0006\u0004\b\u0015\u0010\u0016J/\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00102\b\b\u0002\u0010\u0014\u001a\u00020\r¢\u0006\u0004\b\u0018\u0010\u0019J!\u0010\u001b\u001a\u00020\u00062\b\b\u0002\u0010\u001a\u001a\u00020\r2\b\b\u0002\u0010\u0014\u001a\u00020\r¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 R\u001b\u0010&\u001a\u00020!8FX\u0002¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001b\u0010*\u001a\u00020'8FX\u0002¢\u0006\f\n\u0004\b(\u0010#\u001a\u0004\b\"\u0010)R\u001b\u0010.\u001a\u00020+8FX\u0002¢\u0006\f\n\u0004\b,\u0010#\u001a\u0004\b(\u0010-R\u001b\u00102\u001a\u00020/8FX\u0002¢\u0006\f\n\u0004\b0\u0010#\u001a\u0004\b,\u00101R$\u00108\u001a\u0004\u0018\u0001038\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0012\u00104\u001a\u0004\b0\u00105\"\u0004\b6\u00107¨\u00069"}, d2 = {"Lcom/xjsd/ai/assistant/skill/alarm/AlarmHelper;", "", "<init>", "()V", "Lcom/xjsd/ai/assistant/phone/event/UserAbortEvent;", "event", "", "onReceiveUserAbortEvent", "(Lcom/xjsd/ai/assistant/phone/event/UserAbortEvent;)V", "Lcom/xjsd/ai/assistant/phone/event/DomainChangeEvent;", "onReceiveDomainChangeEvent", "(Lcom/xjsd/ai/assistant/phone/event/DomainChangeEvent;)V", "k", "", "time", "name", "", "weekTime", "f", "(Ljava/lang/String;Ljava/lang/String;I)V", "tag", "g", "(Ljava/lang/String;)V", "week", "i", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "enable", "h", "(Ljava/lang/String;Ljava/lang/String;)V", "Lcom/xjsd/ai/assistant/protocol/alarm/AlarmBusinessData;", "alarmBusinessData", "l", "(Lcom/xjsd/ai/assistant/protocol/alarm/AlarmBusinessData;)V", "Lcom/xjsd/ai/assistant/skill/alarm/AlarmCreateProcessor;", "b", "Lkotlin/Lazy;", "a", "()Lcom/xjsd/ai/assistant/skill/alarm/AlarmCreateProcessor;", "createProcessor", "Lcom/xjsd/ai/assistant/skill/alarm/AlarmDeleteProcessor;", "c", "()Lcom/xjsd/ai/assistant/skill/alarm/AlarmDeleteProcessor;", "deleteProcessor", "Lcom/xjsd/ai/assistant/skill/alarm/AlarmModifyProcessor;", "d", "()Lcom/xjsd/ai/assistant/skill/alarm/AlarmModifyProcessor;", "modifyProcessor", "Lcom/xjsd/ai/assistant/skill/alarm/AlarmQueryProcessor;", "e", "()Lcom/xjsd/ai/assistant/skill/alarm/AlarmQueryProcessor;", "queryProcessor", "Lcom/xjsd/ai/assistant/protocol/alarm/AlarmExt;", "Lcom/xjsd/ai/assistant/protocol/alarm/AlarmExt;", "()Lcom/xjsd/ai/assistant/protocol/alarm/AlarmExt;", "m", "(Lcom/xjsd/ai/assistant/protocol/alarm/AlarmExt;)V", "selectAlarmExt", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class AlarmHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final AlarmHelper f8665a;
    public static final Lazy b = LazyKt.lazy(AlarmHelper$createProcessor$2.INSTANCE);
    public static final Lazy c = LazyKt.lazy(AlarmHelper$deleteProcessor$2.INSTANCE);
    public static final Lazy d = LazyKt.lazy(AlarmHelper$modifyProcessor$2.INSTANCE);
    public static final Lazy e = LazyKt.lazy(AlarmHelper$queryProcessor$2.INSTANCE);
    public static AlarmExt f;

    static {
        AlarmHelper alarmHelper = new AlarmHelper();
        f8665a = alarmHelper;
        EventBus.c().o(alarmHelper);
    }

    public static /* synthetic */ void j(AlarmHelper alarmHelper, String str, String str2, int i, String str3, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            str3 = "";
        }
        alarmHelper.i(str, str2, i, str3);
    }

    public final AlarmCreateProcessor a() {
        return (AlarmCreateProcessor) b.getValue();
    }

    public final AlarmDeleteProcessor b() {
        return (AlarmDeleteProcessor) c.getValue();
    }

    public final AlarmModifyProcessor c() {
        return (AlarmModifyProcessor) d.getValue();
    }

    public final AlarmQueryProcessor d() {
        return (AlarmQueryProcessor) e.getValue();
    }

    public final AlarmExt e() {
        return f;
    }

    public final void f(String str, String str2, int i) {
        Intrinsics.checkNotNullParameter(str, RtspHeaders.Values.TIME);
        Intrinsics.checkNotNullParameter(str2, "name");
        k();
        a().b(str, str2, i);
    }

    public final void g(String str) {
        Intrinsics.checkNotNullParameter(str, "tag");
        if (f == null) {
            k();
            AlarmUtils alarmUtils = AlarmUtils.f8668a;
            Context a2 = ContextHelper.a();
            Intrinsics.checkNotNullExpressionValue(a2, "getContext(...)");
            List f2 = alarmUtils.f(a2, -1, str);
            if (f2.isEmpty()) {
                new PhoneTtsPlayBuilder().e(TtsAlarmTemplate.ALARM03_R02).a().c();
            } else if (f2.size() == 1) {
                b().a(AlarmExt.Companion.formatAlarm((Alarm) f2.get(0)));
            } else {
                AlarmBusinessData alarmBusinessData = new AlarmBusinessData(3);
                alarmBusinessData.setPayload(f2);
                l(alarmBusinessData);
            }
        } else {
            AlarmDeleteProcessor b2 = b();
            AlarmExt alarmExt = f;
            Intrinsics.checkNotNull(alarmExt);
            b2.a(alarmExt);
        }
    }

    public final void h(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "enable");
        Intrinsics.checkNotNullParameter(str2, "tag");
        k();
        d().a(str, str2);
    }

    public final void i(String str, String str2, int i, String str3) {
        Intrinsics.checkNotNullParameter(str, RtspHeaders.Values.TIME);
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(str3, "tag");
        c().f(f, str, str2, i, str3);
    }

    public final void k() {
        c().c();
        f = null;
    }

    public final void l(AlarmBusinessData alarmBusinessData) {
        Intrinsics.checkNotNullParameter(alarmBusinessData, "alarmBusinessData");
        Communicator.a(BusinessDataType.ALARM, alarmBusinessData, new AlarmHelper$sendDataToGlass$1());
    }

    public final void m(AlarmExt alarmExt) {
        f = alarmExt;
    }

    @Subscribe
    public final void onReceiveDomainChangeEvent(@NotNull DomainChangeEvent domainChangeEvent) {
        Intrinsics.checkNotNullParameter(domainChangeEvent, "event");
        if (!Intrinsics.areEqual((Object) VuiModelType.ALARM, (Object) domainChangeEvent.a()) && Intrinsics.areEqual((Object) domainChangeEvent.b(), (Object) VuiModelType.ALARM)) {
            k();
        }
    }

    @Subscribe
    public final void onReceiveUserAbortEvent(@NotNull UserAbortEvent userAbortEvent) {
        Intrinsics.checkNotNullParameter(userAbortEvent, "event");
        ILog.a("AlarmManager-phone", "onReceiveUserAbortEvent and reset alarm data");
        k();
    }
}
