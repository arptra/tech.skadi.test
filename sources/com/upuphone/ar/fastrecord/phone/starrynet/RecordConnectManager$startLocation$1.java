package com.upuphone.ar.fastrecord.phone.starrynet;

import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.upuphone.xr.interconnect.entity.NaviLocationInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "locationInfo", "Lcom/upuphone/xr/interconnect/entity/NaviLocationInfo;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class RecordConnectManager$startLocation$1 extends Lambda implements Function1<NaviLocationInfo, Unit> {
    final /* synthetic */ RecordConnectManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RecordConnectManager$startLocation$1(RecordConnectManager recordConnectManager) {
        super(1);
        this.this$0 = recordConnectManager;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((NaviLocationInfo) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull NaviLocationInfo naviLocationInfo) {
        Intrinsics.checkNotNullParameter(naviLocationInfo, "locationInfo");
        String address = naviLocationInfo.getAddress();
        double latitude = naviLocationInfo.getLatitude();
        double longitude = naviLocationInfo.getLongitude();
        LogExt.logI("定位获取成功--address:" + address + ",latitude:" + latitude + " ,longitude:" + longitude, "FastRecordInterConnectHelper");
        this.this$0.location = naviLocationInfo;
    }
}
