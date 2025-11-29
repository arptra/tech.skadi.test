package com.upuphone.ar.transcribe.eventtrack;

import com.upuphone.ar.transcribe.eventtrack.event.ClickEvent;
import com.upuphone.ar.transcribe.eventtrack.event.FuncEndEvent;
import com.upuphone.ar.transcribe.ext.LogExt;
import com.upuphone.xr.sapp.context.SdkContext;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\r¢\u0006\u0004\b\u0014\u0010\u0011J\u001d\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0017\u0010\u0018J)\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00192\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00190\u001b¢\u0006\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lcom/upuphone/ar/transcribe/eventtrack/EventTrackingHelper;", "", "<init>", "()V", "Lcom/upuphone/ar/transcribe/eventtrack/event/ClickEvent;", "clickEvent", "", "c", "(Lcom/upuphone/ar/transcribe/eventtrack/event/ClickEvent;)V", "Lcom/upuphone/ar/transcribe/eventtrack/event/FuncEndEvent;", "funcEndEvent", "e", "(Lcom/upuphone/ar/transcribe/eventtrack/event/FuncEndEvent;)V", "", "delayTime", "receiveTime", "a", "(JJ)V", "intervalTime", "logTime", "b", "", "state", "f", "(IJ)V", "", "eventName", "", "eventAttrs", "d", "(Ljava/lang/String;Ljava/util/Map;)V", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class EventTrackingHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final EventTrackingHelper f6058a = new EventTrackingHelper();

    public final void a(long j, long j2) {
        HashMap hashMap = new HashMap();
        hashMap.put("delay_time", String.valueOf(j));
        hashMap.put("receive_time", String.valueOf(j2 / ((long) 1000)));
        Unit unit = Unit.INSTANCE;
        d("app_transcript_audio_delay", hashMap);
    }

    public final void b(long j, long j2) {
        HashMap hashMap = new HashMap();
        hashMap.put("interval_time", String.valueOf(j));
        hashMap.put("receive_time", String.valueOf(j2 / ((long) 1000)));
        Unit unit = Unit.INSTANCE;
        d("app_transcript_audio_interval", hashMap);
    }

    public final void c(ClickEvent clickEvent) {
        Intrinsics.checkNotNullParameter(clickEvent, "clickEvent");
        HashMap hashMap = new HashMap();
        hashMap.put("status", String.valueOf(clickEvent.a()));
        hashMap.put(RtspHeaders.Values.TIME, String.valueOf(clickEvent.b()));
        hashMap.put("type", String.valueOf(clickEvent.c()));
        Unit unit = Unit.INSTANCE;
        d("app_transcript_click", hashMap);
    }

    public final void d(String str, Map map) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        Intrinsics.checkNotNullParameter(map, "eventAttrs");
        LogExt.g("EventTracking=[eventName=" + str + ", eventAttrs=" + map + "]", "EventTrackingHelper");
        SdkContext.f6675a.d().reportEvent(str, map);
    }

    public final void e(FuncEndEvent funcEndEvent) {
        Intrinsics.checkNotNullParameter(funcEndEvent, "funcEndEvent");
        HashMap hashMap = new HashMap();
        hashMap.put("status", String.valueOf(funcEndEvent.c()));
        hashMap.put("start_time", String.valueOf(funcEndEvent.b()));
        hashMap.put("end_time", String.valueOf(funcEndEvent.a()));
        hashMap.put("type", String.valueOf(funcEndEvent.d()));
        Unit unit = Unit.INSTANCE;
        d("app_transcript_end", hashMap);
    }

    public final void f(int i, long j) {
        HashMap hashMap = new HashMap();
        hashMap.put("state", String.valueOf(i));
        hashMap.put("pingTime", String.valueOf(j));
        hashMap.put(RtspHeaders.Values.TIME, String.valueOf(System.currentTimeMillis() / ((long) 1000)));
        Unit unit = Unit.INSTANCE;
        d("app_transcript_audio_delay", hashMap);
    }
}
