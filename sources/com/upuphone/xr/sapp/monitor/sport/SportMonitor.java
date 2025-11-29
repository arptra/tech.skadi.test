package com.upuphone.xr.sapp.monitor.sport;

import android.content.Context;
import com.upuphone.xr.interconnect.listener.SendMessageListener;
import com.upuphone.xr.sapp.MainApplication;
import com.upuphone.xr.sapp.monitor.sport.mz.MeiZuSportInfoProvider;
import com.upuphone.xr.sapp.monitor.starry.StarryMessageHelper;
import com.upuphone.xr.sapp.utils.PhoneTypeUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003J\r\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0003J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\nJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u000e8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u000f\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/sport/SportMonitor;", "Lcom/upuphone/xr/sapp/monitor/sport/OnSportUpdatedListener;", "<init>", "()V", "", "c", "e", "Lcom/upuphone/xr/sapp/monitor/sport/SportInfo;", "sportInfo", "a", "(Lcom/upuphone/xr/sapp/monitor/sport/SportInfo;)V", "d", "Landroid/content/Context;", "context", "Lcom/upuphone/xr/sapp/monitor/sport/SportInfoProvider;", "b", "(Landroid/content/Context;)Lcom/upuphone/xr/sapp/monitor/sport/SportInfoProvider;", "Lcom/upuphone/xr/sapp/monitor/sport/SportInfoProvider;", "sportInfoProvider", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class SportMonitor implements OnSportUpdatedListener {

    /* renamed from: a  reason: collision with root package name */
    public static final SportMonitor f7796a = new SportMonitor();
    public static SportInfoProvider b;

    public void a(SportInfo sportInfo) {
        Intrinsics.checkNotNullParameter(sportInfo, "sportInfo");
        d(sportInfo);
    }

    public final SportInfoProvider b(Context context) {
        return PhoneTypeUtils.f7912a.i() ? new MeiZuSportInfoProvider(context) : new DefaultSportInfoProvider(context);
    }

    public final void c() {
        SportInfoProvider b2 = b(MainApplication.k.f());
        b = b2;
        if (b2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sportInfoProvider");
            b2 = null;
        }
        b2.b(this);
    }

    public final void d(SportInfo sportInfo) {
        StarryMessageHelper.p(StarryMessageHelper.f7799a, (byte[]) null, "sport", sportInfo, (SendMessageListener) null, (String) null, 25, (Object) null);
    }

    public final void e() {
        SportInfoProvider sportInfoProvider = b;
        if (sportInfoProvider == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sportInfoProvider");
            sportInfoProvider = null;
        }
        sportInfoProvider.c();
    }
}
