package com.upuphone.xr.sapp.fragment;

import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.databinding.FragmentDlnaPhoneBinding;
import com.upuphone.xr.sapp.entity.GlassWifiData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/upuphone/xr/sapp/entity/GlassWifiData;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class DlnaPhoneFragment$addObserver$1 extends Lambda implements Function1<GlassWifiData, Unit> {
    final /* synthetic */ DlnaPhoneFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DlnaPhoneFragment$addObserver$1(DlnaPhoneFragment dlnaPhoneFragment) {
        super(1);
        this.this$0 = dlnaPhoneFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((GlassWifiData) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(GlassWifiData glassWifiData) {
        ULog.f6446a.a("DlnaPhoneFragment", "glassWifiInfo::state is:" + glassWifiData.getWifiState() + ", ssid is:" + glassWifiData.getSsid());
        FragmentDlnaPhoneBinding fragmentDlnaPhoneBinding = null;
        if (StringsKt.isBlank(this.this$0.g) || !Intrinsics.areEqual((Object) glassWifiData.getSsid(), (Object) this.this$0.g)) {
            FragmentDlnaPhoneBinding i0 = this.this$0.f6950a;
            if (i0 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                i0 = null;
            }
            i0.c.setText(this.this$0.getString(R.string.dlna_goto_connect));
            FragmentDlnaPhoneBinding i02 = this.this$0.f6950a;
            if (i02 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                i02 = null;
            }
            i02.c.setBackground(this.this$0.getResources().getDrawable(R.drawable.dlna_goto_connect));
            FragmentDlnaPhoneBinding i03 = this.this$0.f6950a;
            if (i03 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                i03 = null;
            }
            i03.c.setClickable(true);
            FragmentDlnaPhoneBinding i04 = this.this$0.f6950a;
            if (i04 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentDlnaPhoneBinding = i04;
            }
            fragmentDlnaPhoneBinding.c.setTextColor(this.this$0.getResources().getColor(R.color.color_EEEEEE));
            return;
        }
        FragmentDlnaPhoneBinding i05 = this.this$0.f6950a;
        if (i05 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            i05 = null;
        }
        i05.c.setText(this.this$0.getString(R.string.dlna_network_connected));
        FragmentDlnaPhoneBinding i06 = this.this$0.f6950a;
        if (i06 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            i06 = null;
        }
        i06.c.setBackground(this.this$0.getResources().getDrawable(R.drawable.dlna_connected));
        FragmentDlnaPhoneBinding i07 = this.this$0.f6950a;
        if (i07 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            i07 = null;
        }
        i07.c.setClickable(false);
        FragmentDlnaPhoneBinding i08 = this.this$0.f6950a;
        if (i08 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentDlnaPhoneBinding = i08;
        }
        fragmentDlnaPhoneBinding.c.setTextColor(this.this$0.getResources().getColor(R.color.dlna_connected_text_color));
    }
}
