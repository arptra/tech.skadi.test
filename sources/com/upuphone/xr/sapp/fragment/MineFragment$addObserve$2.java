package com.upuphone.xr.sapp.fragment;

import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.entity.DeviceState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/upuphone/xr/sapp/entity/DeviceState;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class MineFragment$addObserve$2 extends Lambda implements Function1<DeviceState, Unit> {
    final /* synthetic */ MineFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MineFragment$addObserve$2(MineFragment mineFragment) {
        super(1);
        this.this$0 = mineFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DeviceState) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(DeviceState deviceState) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("MineFragment", "deviceBoundState: " + deviceState);
        this.this$0.E0(deviceState);
    }
}
