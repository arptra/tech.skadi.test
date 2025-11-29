package com.upuphone.ar.tici.phone;

import com.upuphone.ar.tici.R;
import com.upuphone.ar.tici.phone.utils.CommonExtKt;
import com.upuphone.ar.tici.phone.viewmodel.TiciMainViewModel;
import com.upuphone.ar.tici.phone.widget.TouchScrollView;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004¨\u0006\u0006"}, d2 = {"com/upuphone/ar/tici/phone/TiciMainActivity$initViews$6", "Lcom/upuphone/ar/tici/phone/widget/TouchScrollView$OnScrollListener;", "", "b", "()V", "a", "ar-tici_release"}, k = 1, mv = {1, 9, 0})
public final class TiciMainActivity$initViews$6 implements TouchScrollView.OnScrollListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TiciMainActivity f5900a;

    public TiciMainActivity$initViews$6(TiciMainActivity ticiMainActivity) {
        this.f5900a = ticiMainActivity;
    }

    public void a() {
        TiciApp ticiApp = TiciApp.b;
        if (ticiApp.j()) {
            StarryNetDevice connectXrDevice = ticiApp.q().getConnectXrDevice();
            CommonExtKt.e("onScrollDown-> device: " + connectXrDevice, "TiciMainActivity");
            if (connectXrDevice == null) {
                CommonExtKt.j(this.f5900a, R.string.tici_disconnect_toast, 0, 2, (Object) null);
                return;
            }
        }
        TiciMainViewModel.D(this.f5900a.e1(), -1, false, 2, (Object) null);
    }

    public void b() {
        TiciApp ticiApp = TiciApp.b;
        if (ticiApp.j()) {
            StarryNetDevice connectXrDevice = ticiApp.q().getConnectXrDevice();
            CommonExtKt.e("onScrollUp-> device: " + connectXrDevice, "TiciMainActivity");
            if (connectXrDevice == null) {
                CommonExtKt.j(this.f5900a, R.string.tici_disconnect_toast, 0, 2, (Object) null);
                return;
            }
        }
        TiciMainViewModel.D(this.f5900a.e1(), 1, false, 2, (Object) null);
    }
}
