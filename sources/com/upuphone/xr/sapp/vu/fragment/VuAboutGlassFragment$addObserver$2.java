package com.upuphone.xr.sapp.vu.fragment;

import android.widget.TextView;
import com.upuphone.xr.sapp.databinding.FragmentVuAboutGlassBinding;
import com.upuphone.xr.sapp.entity.DeviceInfo;
import com.upuphone.xr.sapp.vu.utils.VuGlassesHidUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/upuphone/xr/sapp/entity/DeviceInfo;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class VuAboutGlassFragment$addObserver$2 extends Lambda implements Function1<DeviceInfo, Unit> {
    final /* synthetic */ VuAboutGlassFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VuAboutGlassFragment$addObserver$2(VuAboutGlassFragment vuAboutGlassFragment) {
        super(1);
        this.this$0 = vuAboutGlassFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DeviceInfo) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(DeviceInfo deviceInfo) {
        FragmentVuAboutGlassBinding C0 = this.this$0.j;
        String str = null;
        if (C0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            C0 = null;
        }
        C0.h.setText(deviceInfo != null ? deviceInfo.getName() : null);
        FragmentVuAboutGlassBinding C02 = this.this$0.j;
        if (C02 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            C02 = null;
        }
        C02.e.setText(deviceInfo != null ? deviceInfo.getModel() : null);
        FragmentVuAboutGlassBinding C03 = this.this$0.j;
        if (C03 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            C03 = null;
        }
        C03.n.setText(deviceInfo != null ? deviceInfo.getSerialNo() : null);
        FragmentVuAboutGlassBinding C04 = this.this$0.j;
        if (C04 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            C04 = null;
        }
        TextView textView = C04.l;
        VuGlassesHidUtil vuGlassesHidUtil = VuGlassesHidUtil.f8104a;
        if (deviceInfo != null) {
            str = deviceInfo.getRomVersion();
        }
        textView.setText(vuGlassesHidUtil.h(str));
    }
}
