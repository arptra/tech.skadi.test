package com.upuphone.xr.sapp.vu.fragment;

import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.databinding.FragmentVuGlassUpdateInfoBinding;
import com.upuphone.xr.sapp.entity.DeviceInfo;
import com.upuphone.xr.sapp.vu.utils.VuGlassesHidUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/upuphone/xr/sapp/entity/DeviceInfo;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class VuGlassUpdateFragment$showNoUpdate$1 extends Lambda implements Function1<DeviceInfo, Unit> {
    final /* synthetic */ VuGlassUpdateFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VuGlassUpdateFragment$showNoUpdate$1(VuGlassUpdateFragment vuGlassUpdateFragment) {
        super(1);
        this.this$0 = vuGlassUpdateFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DeviceInfo) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(DeviceInfo deviceInfo) {
        FragmentVuGlassUpdateInfoBinding F0 = this.this$0.k;
        FragmentVuGlassUpdateInfoBinding fragmentVuGlassUpdateInfoBinding = null;
        if (F0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            F0 = null;
        }
        F0.c.d.setText(VuGlassesHidUtil.f8104a.h(deviceInfo.getRomVersion()));
        FragmentVuGlassUpdateInfoBinding F02 = this.this$0.k;
        if (F02 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentVuGlassUpdateInfoBinding = F02;
        }
        fragmentVuGlassUpdateInfoBinding.c.c.setText(this.this$0.getString(R.string.view_glass_is_latest_version));
    }
}
