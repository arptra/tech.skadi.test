package com.upuphone.xr.sapp.fragment;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.FragmentActivity;
import com.honey.account.h8.h2;
import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.star.common.phone.UToast;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.interconnect.listener.SendMessageListener;
import com.upuphone.xr.sapp.R;
import com.xjmz.myvu.MYVUActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, d2 = {"com/upuphone/xr/sapp/fragment/FactoryResetFragment$buttonAction$1", "Lcom/upuphone/xr/interconnect/listener/SendMessageListener;", "onFail", "", "msgId", "", "errorCode", "", "onSuccess", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class FactoryResetFragment$buttonAction$1 extends SendMessageListener {
    final /* synthetic */ FactoryResetFragment this$0;

    public FactoryResetFragment$buttonAction$1(FactoryResetFragment factoryResetFragment) {
        this.this$0 = factoryResetFragment;
    }

    /* access modifiers changed from: private */
    public static final void onFail$lambda$2(FactoryResetFragment factoryResetFragment) {
        Intrinsics.checkNotNullParameter(factoryResetFragment, "this$0");
        Context context = factoryResetFragment.getContext();
        if (context != null) {
            UToast.Companion companion = UToast.f6444a;
            String string = factoryResetFragment.getResources().getString(R.string.msg_send_glass_failed);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            companion.d(context, string);
        }
    }

    public void onFail(@Nullable String str, int i) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("FactoryResetFragment", "send factory reset msg failed : " + str);
        new Handler(Looper.getMainLooper()).post(new h2(this.this$0));
    }

    public void onSuccess(@Nullable String str) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("FactoryResetFragment", "send factory reset msg success : " + str);
        StarryDevice connectedDevice = InterconnectManager.getInstance().getStarryNetDeviceManager().getConnectedDevice();
        if (connectedDevice != null) {
            FactoryResetFragment factoryResetFragment = this.this$0;
            if (factoryResetFragment.getActivity() instanceof MYVUActivity) {
                FragmentActivity activity = factoryResetFragment.getActivity();
                Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type com.xjmz.myvu.MYVUActivity");
                ((MYVUActivity) activity).C1(connectedDevice.getId());
            }
        }
    }
}
