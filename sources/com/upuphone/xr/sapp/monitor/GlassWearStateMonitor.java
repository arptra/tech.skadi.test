package com.upuphone.xr.sapp.monitor;

import com.upuphone.xr.interconnect.util.log.ILog;
import com.upuphone.xr.sapp.monitor.schedule.calendar.CalendarScheduleProvider;
import kotlin.Metadata;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\bR\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b8\u0006¢\u0006\f\n\u0004\b\u0007\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/GlassWearStateMonitor;", "", "<init>", "()V", "", "connected", "", "b", "(Z)V", "worn", "c", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "a", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "wearState", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class GlassWearStateMonitor {

    /* renamed from: a  reason: collision with root package name */
    public static final GlassWearStateMonitor f7735a = new GlassWearStateMonitor();
    public static final MutableStateFlow b = StateFlowKt.a(Boolean.FALSE);

    public final MutableStateFlow a() {
        return b;
    }

    public final synchronized void b(boolean z) {
        ILog.d("GlassWearStateMonitor", "onConnectedStateChanged: " + z);
        if (!z) {
            b.setValue(Boolean.FALSE);
        }
    }

    public final synchronized void c(boolean z) {
        ILog.d("GlassWearStateMonitor", "onWearStateChanged: " + z);
        b.setValue(Boolean.valueOf(z));
        if (z) {
            CalendarScheduleProvider.f7784a.c();
        }
    }
}
