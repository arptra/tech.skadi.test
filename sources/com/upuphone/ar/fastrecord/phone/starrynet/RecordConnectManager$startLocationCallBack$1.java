package com.upuphone.ar.fastrecord.phone.starrynet;

import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.upuphone.xr.interconnect.entity.NaviLocationInfo;
import com.upuphone.xr.interconnect.listener.NaviLocationCallback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nRecordConnectManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RecordConnectManager.kt\ncom/upuphone/ar/fastrecord/phone/starrynet/RecordConnectManager$startLocationCallBack$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,517:1\n1#2:518\n*E\n"})
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/upuphone/ar/fastrecord/phone/starrynet/RecordConnectManager$startLocationCallBack$1", "Lcom/upuphone/xr/interconnect/listener/NaviLocationCallback;", "onLocationChanged", "", "locationInfo", "Lcom/upuphone/xr/interconnect/entity/NaviLocationInfo;", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class RecordConnectManager$startLocationCallBack$1 extends NaviLocationCallback {
    final /* synthetic */ Function1<NaviLocationInfo, Unit> $hasGetLocationCallback;
    final /* synthetic */ RecordConnectManager this$0;

    public RecordConnectManager$startLocationCallBack$1(RecordConnectManager recordConnectManager, Function1<? super NaviLocationInfo, Unit> function1) {
        this.this$0 = recordConnectManager;
        this.$hasGetLocationCallback = function1;
    }

    public void onLocationChanged(@Nullable NaviLocationInfo naviLocationInfo) {
        NaviLocationInfo naviLocationInfo2 = naviLocationInfo;
        if (naviLocationInfo2 != null) {
            Function1<NaviLocationInfo, Unit> function1 = this.$hasGetLocationCallback;
            String address = naviLocationInfo.getAddress();
            String city = naviLocationInfo.getCity();
            String cityCode = naviLocationInfo.getCityCode();
            String district = naviLocationInfo.getDistrict();
            String district2 = naviLocationInfo.getDistrict();
            String poiName = naviLocationInfo.getPoiName();
            String street = naviLocationInfo.getStreet();
            String province = naviLocationInfo.getProvince();
            double latitude = naviLocationInfo.getLatitude();
            double longitude = naviLocationInfo.getLongitude();
            LogExt.logI("定位获取成功--address:" + address + ",city = " + city + ",cityCode = " + cityCode + ",district = " + district + ",district = " + district2 + ",poiName = " + poiName + ",street = " + street + ",province = " + province + "latitude:" + latitude + " ,longitude:" + longitude, "FastRecordInterConnectHelper");
            if (function1 != null) {
                function1.invoke(naviLocationInfo2);
            }
        }
        NaviLocationCallback access$getMNaviLocationCallback$p = this.this$0.mNaviLocationCallback;
        if (access$getMNaviLocationCallback$p != null) {
            this.this$0.stopLocation(access$getMNaviLocationCallback$p);
        }
    }
}
