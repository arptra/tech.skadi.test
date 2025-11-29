package com.upuphone.ar.translation.eventtrack;

import com.upuphone.ar.translation.eventtrack.event.ClickEvent;
import com.upuphone.ar.translation.eventtrack.event.FuncEndEvent;
import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.xr.sapp.context.SdkContext;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\r\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\bJ\u0015\u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\fJ)\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/upuphone/ar/translation/eventtrack/EventTrackingHelper;", "", "<init>", "()V", "Lcom/upuphone/ar/translation/eventtrack/event/ClickEvent;", "clickEvent", "", "b", "(Lcom/upuphone/ar/translation/eventtrack/event/ClickEvent;)V", "Lcom/upuphone/ar/translation/eventtrack/event/FuncEndEvent;", "funcEndEvent", "d", "(Lcom/upuphone/ar/translation/eventtrack/event/FuncEndEvent;)V", "e", "f", "", "eventName", "", "eventAttrs", "c", "(Ljava/lang/String;Ljava/util/Map;)V", "", "millisecond", "a", "(J)J", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class EventTrackingHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final EventTrackingHelper f6200a = new EventTrackingHelper();

    public final long a(long j) {
        return j / ((long) 1000);
    }

    public final void b(ClickEvent clickEvent) {
        Intrinsics.checkNotNullParameter(clickEvent, "clickEvent");
        HashMap hashMap = new HashMap();
        hashMap.put("status", String.valueOf(clickEvent.a()));
        hashMap.put(RtspHeaders.Values.TIME, String.valueOf(f6200a.a(clickEvent.b())));
        Unit unit = Unit.INSTANCE;
        c("app_translator_click", hashMap);
    }

    public final void c(String str, Map map) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        Intrinsics.checkNotNullParameter(map, "eventAttrs");
        LogExt.j("EventTracking=[eventName=" + str + ", eventAttrs=" + map + "]", "EventTrackingHelper");
        SdkContext.f6675a.d().reportEvent(str, map);
    }

    public final void d(FuncEndEvent funcEndEvent) {
        Intrinsics.checkNotNullParameter(funcEndEvent, "funcEndEvent");
        HashMap hashMap = new HashMap();
        hashMap.put("status", String.valueOf(funcEndEvent.c()));
        EventTrackingHelper eventTrackingHelper = f6200a;
        hashMap.put("start_time", String.valueOf(eventTrackingHelper.a(funcEndEvent.b())));
        hashMap.put("end_time", String.valueOf(eventTrackingHelper.a(funcEndEvent.a())));
        Unit unit = Unit.INSTANCE;
        c("app_translator_end", hashMap);
    }

    public final void e(ClickEvent clickEvent) {
        Intrinsics.checkNotNullParameter(clickEvent, "clickEvent");
        HashMap hashMap = new HashMap();
        hashMap.put("status", String.valueOf(clickEvent.a()));
        hashMap.put(RtspHeaders.Values.TIME, String.valueOf(f6200a.a(clickEvent.b())));
        Unit unit = Unit.INSTANCE;
        c("app_calltranslator_click", hashMap);
    }

    public final void f(FuncEndEvent funcEndEvent) {
        Intrinsics.checkNotNullParameter(funcEndEvent, "funcEndEvent");
        HashMap hashMap = new HashMap();
        hashMap.put("status", String.valueOf(funcEndEvent.c()));
        EventTrackingHelper eventTrackingHelper = f6200a;
        hashMap.put("start_time", String.valueOf(eventTrackingHelper.a(funcEndEvent.b())));
        hashMap.put("end_time", String.valueOf(eventTrackingHelper.a(funcEndEvent.a())));
        Unit unit = Unit.INSTANCE;
        c("app_calltranslator_end", hashMap);
    }
}
