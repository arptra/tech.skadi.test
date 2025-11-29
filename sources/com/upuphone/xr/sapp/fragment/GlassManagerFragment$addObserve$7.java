package com.upuphone.xr.sapp.fragment;

import android.content.Context;
import com.upuphone.xr.sapp.entity.ConnectState;
import com.upuphone.xr.sapp.entity.NetDevice;
import com.upuphone.xr.sapp.utils.ControlUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/upuphone/xr/sapp/entity/NetDevice;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class GlassManagerFragment$addObserve$7 extends Lambda implements Function1<NetDevice, Unit> {
    final /* synthetic */ GlassManagerFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlassManagerFragment$addObserve$7(GlassManagerFragment glassManagerFragment) {
        super(1);
        this.this$0 = glassManagerFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((NetDevice) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(NetDevice netDevice) {
        if (netDevice.getState() == ConnectState.CONNECTED) {
            this.this$0.m = true;
            ControlUtils controlUtils = ControlUtils.f7858a;
            Context m0 = this.this$0.m0();
            String str = null;
            controlUtils.l(m0 != null ? m0.getPackageName() : null);
            Context m02 = this.this$0.m0();
            controlUtils.j(m02 != null ? m02.getPackageName() : null);
            Context m03 = this.this$0.m0();
            if (m03 != null) {
                str = m03.getPackageName();
            }
            controlUtils.t(str);
            return;
        }
        this.this$0.m = false;
    }
}
