package com.upuphone.xr.sapp.guide.connectui;

import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.sapp.MainApplication;
import com.upuphone.xr.sapp.entity.DeviceState;
import com.upuphone.xr.sapp.guide.model.ConnectResult;
import com.upuphone.xr.sapp.utils.CustomFrameAnimation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/upuphone/xr/sapp/entity/DeviceState;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class AddGlassFragment$registerDeviceConnectCallback$1 extends Lambda implements Function1<DeviceState, Unit> {
    final /* synthetic */ AddGlassFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AddGlassFragment$registerDeviceConnectCallback$1(AddGlassFragment addGlassFragment) {
        super(1);
        this.this$0 = addGlassFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DeviceState) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(DeviceState deviceState) {
        int i;
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("AddGlassFragment", "registerDeviceConnectCallback::device is: " + deviceState + " it.validTime is: " + deviceState.getValidTime() + " and mCurrentTime " + this.this$0.t + " and mConnectOK is: " + this.this$0.u);
        if (deviceState.getFromModifyGlassName() || deviceState.getValidTime() < this.this$0.t || this.this$0.u) {
            delegate.a("AddGlassFragment", "registerDeviceConnectCallback::no need handle");
            return;
        }
        if (deviceState.getState() != 2) {
            MainApplication.k.o(true);
            i = -100;
        } else {
            this.this$0.u = true;
            i = 0;
        }
        boolean Q0 = this.this$0.r;
        boolean M0 = this.this$0.u;
        MainApplication.Companion companion = MainApplication.k;
        delegate.a("AddGlassFragment", "registerDeviceConnectCallback::show result mInitSearch = " + Q0 + ",mConnectOK = " + M0 + ",mConnectFail = " + companion.g());
        if (!this.this$0.r) {
            return;
        }
        if (this.this$0.u) {
            this.this$0.E1(deviceState.getDevice());
            CustomFrameAnimation.d.b().p(true);
        } else if (companion.g()) {
            AddGlassFragment addGlassFragment = this.this$0;
            StarryNetDevice device = deviceState.getDevice();
            String deviceId = device != null ? device.getDeviceId() : null;
            if (deviceId == null) {
                deviceId = "-1";
            }
            addGlassFragment.X1(new ConnectResult(false, deviceId, i));
        }
    }
}
