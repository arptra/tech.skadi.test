package com.upuphone.xr.sapp.unicron;

import com.upuphone.star.fota.phone.GlassUpdateInfo;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.sapp.air.AirHelper;
import com.upuphone.xr.sapp.entity.CheckUpdateFileReq;
import com.upuphone.xr.sapp.entity.UnicronInfo;
import com.upuphone.xr.sapp.glass.GlassHelper;
import java.io.File;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\tH@¢\u0006\u0004\b\f\u0010\rJ'\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0016\u0010\u0003J\u0017\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/upuphone/xr/sapp/unicron/UnicronUpdateAdapter;", "Lcom/upuphone/xr/sapp/unicron/IUnicronUpdater;", "<init>", "()V", "", "msg", "", "e", "(Ljava/lang/String;)V", "Lcom/upuphone/xr/sapp/entity/CheckUpdateFileReq;", "req", "Lcom/upuphone/xr/sapp/entity/CheckUpdateFileResp;", "c", "(Lcom/upuphone/xr/sapp/entity/CheckUpdateFileReq;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ljava/io/File;", "file", "Lcom/upuphone/star/fota/phone/GlassUpdateInfo;", "glassUpdateInfo", "Lcom/upuphone/xr/sapp/entity/UnicronInfo;", "unicronInfo", "a", "(Ljava/io/File;Lcom/upuphone/star/fota/phone/GlassUpdateInfo;Lcom/upuphone/xr/sapp/entity/UnicronInfo;)V", "b", "Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;", "device", "d", "(Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;)Lcom/upuphone/xr/sapp/unicron/IUnicronUpdater;", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class UnicronUpdateAdapter implements IUnicronUpdater {

    /* renamed from: a  reason: collision with root package name */
    public static final UnicronUpdateAdapter f7835a = new UnicronUpdateAdapter();

    private final void e(String str) {
        UnicronUpdateHelper unicronUpdateHelper = UnicronUpdateHelper.b;
        unicronUpdateHelper.L("UnicronUpdateAdapter|" + str);
    }

    public void a(File file, GlassUpdateInfo glassUpdateInfo, UnicronInfo unicronInfo) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(glassUpdateInfo, "glassUpdateInfo");
        Intrinsics.checkNotNullParameter(unicronInfo, "unicronInfo");
        StarryNetDevice y = GlassHelper.f7049a.y();
        if (y == null) {
            e("onDownloadComplete, connectedGlass is null");
        } else {
            d(y).a(file, glassUpdateInfo, unicronInfo);
        }
    }

    public void b() {
        StarUnicronUpdater.b.q();
        AirUnicronUpdater.b.m();
    }

    public Object c(CheckUpdateFileReq checkUpdateFileReq, Continuation continuation) {
        StarryNetDevice y = GlassHelper.f7049a.y();
        if (y != null) {
            return d(y).c(checkUpdateFileReq, continuation);
        }
        e("checkUpdateFile, connectedGlass is null");
        return null;
    }

    public final IUnicronUpdater d(StarryNetDevice starryNetDevice) {
        return AirHelper.b.I(starryNetDevice) ? AirUnicronUpdater.b : StarUnicronUpdater.b;
    }
}
