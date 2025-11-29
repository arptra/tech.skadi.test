package com.upuphone.ar.tici.phone;

import com.upuphone.ar.tici.R;
import com.upuphone.ar.tici.phone.utils.CommonExtKt;
import com.upuphone.ar.tici.phone.utils.SpUtilKt;
import com.upuphone.ar.tici.phone.utils.TiciDataTrack;
import com.upuphone.ar.tici.phone.widget.TiciScreenLocationView;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/upuphone/ar/tici/phone/TiciSettingActivity$initView$12", "Lcom/upuphone/ar/tici/phone/widget/TiciScreenLocationView$ItemClickListener;", "Lcom/upuphone/ar/tici/phone/widget/TiciScreenLocationView$Location;", "location", "", "a", "(Lcom/upuphone/ar/tici/phone/widget/TiciScreenLocationView$Location;)V", "ar-tici_release"}, k = 1, mv = {1, 9, 0})
public final class TiciSettingActivity$initView$12 implements TiciScreenLocationView.ItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TiciSettingActivity f5907a;

    public TiciSettingActivity$initView$12(TiciSettingActivity ticiSettingActivity) {
        this.f5907a = ticiSettingActivity;
    }

    public void a(TiciScreenLocationView.Location location) {
        Intrinsics.checkNotNullParameter(location, "location");
        CommonExtKt.e("TiciScreenLocationView-onItemClick, location: " + location, "TiciSettingActivity");
        if (TiciApp.b.q().getConnectXrDevice() == null) {
            CommonExtKt.j(this.f5907a, R.string.tici_disconnect_toast, 0, 2, (Object) null);
            return;
        }
        this.f5907a.N0().i.n(location.getValue());
        SpUtilKt.r(location.getValue());
        TiciSettingActivity.j1(this.f5907a, 0, 0, 3, (Object) null);
        TiciDataTrack.f6001a.c("app_prompt_display", MapsKt.mapOf(TuplesKt.to("display", Integer.valueOf(location.getValue()))));
    }
}
