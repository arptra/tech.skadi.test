package com.upuphone.ar.fastrecord.phone.listener;

import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.upuphone.xr.interconnect.entity.NaviLocationInfo;
import com.upuphone.xr.interconnect.listener.NaviLocationCallback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/listener/RecordLocationCallBack;", "Lcom/upuphone/xr/interconnect/listener/NaviLocationCallback;", "()V", "onLocationChanged", "", "locationInfo", "Lcom/upuphone/xr/interconnect/entity/NaviLocationInfo;", "Companion", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class RecordLocationCallBack extends NaviLocationCallback {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @Nullable
    public static Function1<? super NaviLocationInfo, Unit> hasGetLocationCallback;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R9\u0010\u0003\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/listener/RecordLocationCallBack$Companion;", "", "()V", "hasGetLocationCallback", "Lkotlin/Function1;", "Lcom/upuphone/xr/interconnect/entity/NaviLocationInfo;", "Lkotlin/ParameterName;", "name", "locationInfo", "", "getHasGetLocationCallback", "()Lkotlin/jvm/functions/Function1;", "setHasGetLocationCallback", "(Lkotlin/jvm/functions/Function1;)V", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final Function1<NaviLocationInfo, Unit> getHasGetLocationCallback() {
            return RecordLocationCallBack.hasGetLocationCallback;
        }

        public final void setHasGetLocationCallback(@Nullable Function1<? super NaviLocationInfo, Unit> function1) {
            RecordLocationCallBack.hasGetLocationCallback = function1;
        }

        private Companion() {
        }
    }

    public void onLocationChanged(@Nullable NaviLocationInfo naviLocationInfo) {
        if (naviLocationInfo != null) {
            String address = naviLocationInfo.getAddress();
            double latitude = naviLocationInfo.getLatitude();
            double longitude = naviLocationInfo.getLongitude();
            LogExt.logI("定位获取成功--address:" + address + ",latitude:" + latitude + " ,longitude:" + longitude, "RecordLocationCallBack");
        }
        Function1<? super NaviLocationInfo, Unit> function1 = hasGetLocationCallback;
        if (function1 != null) {
            function1.invoke(naviLocationInfo);
        }
    }
}
