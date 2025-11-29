package com.upuphone.xr.sapp.guide.wifi;

import android.content.Context;
import com.upuphone.star.common.phone.UToast;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.databinding.FragmentWifiSettingBinding;
import com.upuphone.xr.sapp.guide.adapter.WifiListAdapter;
import com.upuphone.xr.sapp.guide.model.WifiResultModel;
import com.upuphone.xr.sapp.utils.DataStoreUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/upuphone/xr/sapp/guide/model/WifiResultModel;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class WifiSettingFragment$registerObserve$5 extends Lambda implements Function1<WifiResultModel, Unit> {
    final /* synthetic */ WifiSettingFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WifiSettingFragment$registerObserve$5(WifiSettingFragment wifiSettingFragment) {
        super(1);
        this.this$0 = wifiSettingFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((WifiResultModel) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable WifiResultModel wifiResultModel) {
        if (wifiResultModel != null) {
            WifiSettingFragment wifiSettingFragment = this.this$0;
            int mState = wifiResultModel.getMState();
            if (mState == 0) {
                wifiSettingFragment.p = -1;
                String mSetChange = wifiResultModel.getMSetChange();
                if (Intrinsics.areEqual((Object) mSetChange, (Object) "0")) {
                    WifiListAdapter S0 = wifiSettingFragment.k;
                    FragmentWifiSettingBinding fragmentWifiSettingBinding = null;
                    if (!Intrinsics.areEqual((Object) Boolean.TRUE, (Object) S0 != null ? Boolean.valueOf(S0.x()) : null)) {
                        UToast.Companion companion = UToast.f6444a;
                        Context requireContext = wifiSettingFragment.requireContext();
                        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
                        String string = wifiSettingFragment.getString(R.string.pair_ok);
                        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                        companion.d(requireContext, string);
                    }
                    WifiListAdapter S02 = wifiSettingFragment.k;
                    if (S02 != null) {
                        S02.n(wifiResultModel);
                    }
                    wifiSettingFragment.v1();
                    FragmentWifiSettingBinding L0 = wifiSettingFragment.j;
                    if (L0 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        fragmentWifiSettingBinding = L0;
                    }
                    fragmentWifiSettingBinding.h.smoothScrollToPosition(0);
                } else if (Intrinsics.areEqual((Object) mSetChange, (Object) "2")) {
                    WifiListAdapter S03 = wifiSettingFragment.k;
                    if (S03 != null) {
                        S03.p(wifiResultModel.getMSsid());
                    }
                    wifiSettingFragment.v1();
                }
            } else if (mState == 11) {
                wifiSettingFragment.m1();
            } else if (mState == 100) {
                boolean booleanValue = ((Boolean) DataStoreUtils.i(DataStoreUtils.e.a(), "wifi_auto_connect", Boolean.FALSE, (Context) null, 4, (Object) null)).booleanValue();
                ULog.Delegate delegate = ULog.f6446a;
                delegate.c("WifiSettingFragment", "RES_CODE_EXECUTING::autoConnect is:" + booleanValue);
                if (Intrinsics.areEqual((Object) wifiResultModel.getMSetChange(), (Object) "0") && booleanValue) {
                    boolean unused = wifiSettingFragment.t;
                }
            } else if (mState == 300) {
            } else {
                if (mState != 400) {
                    wifiSettingFragment.k1(wifiResultModel.getMSetChange(), wifiResultModel.getMState());
                    return;
                }
                UToast.Companion companion2 = UToast.f6444a;
                Context requireContext2 = wifiSettingFragment.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext(...)");
                String string2 = wifiSettingFragment.getString(R.string.wifi_list_no_ok);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                companion2.d(requireContext2, string2);
                WifiListAdapter S04 = wifiSettingFragment.k;
                if (S04 != null) {
                    S04.H(true);
                }
                wifiSettingFragment.v1();
            }
        }
    }
}
