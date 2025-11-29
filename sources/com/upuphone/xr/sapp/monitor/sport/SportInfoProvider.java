package com.upuphone.xr.sapp.monitor.sport;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\u0003R$\u0010\u0010\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/sport/SportInfoProvider;", "", "<init>", "()V", "Lcom/upuphone/xr/sapp/monitor/sport/SportInfo;", "sportInfo", "", "a", "(Lcom/upuphone/xr/sapp/monitor/sport/SportInfo;)V", "c", "Lcom/upuphone/xr/sapp/monitor/sport/OnSportUpdatedListener;", "Lcom/upuphone/xr/sapp/monitor/sport/OnSportUpdatedListener;", "getListener", "()Lcom/upuphone/xr/sapp/monitor/sport/OnSportUpdatedListener;", "b", "(Lcom/upuphone/xr/sapp/monitor/sport/OnSportUpdatedListener;)V", "listener", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public abstract class SportInfoProvider {

    /* renamed from: a  reason: collision with root package name */
    public OnSportUpdatedListener f7795a;

    public final void a(SportInfo sportInfo) {
        Intrinsics.checkNotNullParameter(sportInfo, "sportInfo");
        OnSportUpdatedListener onSportUpdatedListener = this.f7795a;
        if (onSportUpdatedListener != null) {
            onSportUpdatedListener.a(sportInfo);
        }
    }

    public final void b(OnSportUpdatedListener onSportUpdatedListener) {
        this.f7795a = onSportUpdatedListener;
    }

    public abstract void c();
}
