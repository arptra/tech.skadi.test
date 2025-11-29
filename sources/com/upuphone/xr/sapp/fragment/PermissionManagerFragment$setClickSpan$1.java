package com.upuphone.xr.sapp.fragment;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.alibaba.fastjson.asm.Opcodes;
import com.upuphone.star.common.phone.UToast;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.entity.ConnectState;
import com.upuphone.xr.sapp.entity.NetDevice;
import com.upuphone.xr.sapp.utils.StaticMethodUtilsKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/upuphone/xr/sapp/fragment/PermissionManagerFragment$setClickSpan$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PermissionManagerFragment$setClickSpan$1 extends ClickableSpan {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PermissionManagerFragment f6994a;

    public PermissionManagerFragment$setClickSpan$1(PermissionManagerFragment permissionManagerFragment) {
        this.f6994a = permissionManagerFragment;
    }

    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "widget");
        NetDevice netDevice = (NetDevice) this.f6994a.k1().L().getValue();
        if (netDevice != null) {
            PermissionManagerFragment permissionManagerFragment = this.f6994a;
            if (netDevice.getState() == ConnectState.UNCONNECTED) {
                UToast.Companion companion = UToast.f6444a;
                Context requireContext = permissionManagerFragment.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
                companion.b(requireContext, R.string.device_disconnect);
                return;
            }
            permissionManagerFragment.o = true;
            StaticMethodUtilsKt.C(permissionManagerFragment, CollectionsKt.arrayListOf(Integer.valueOf(Opcodes.IF_ACMPNE)), false, false);
            permissionManagerFragment.N1();
            permissionManagerFragment.s.sendEmptyMessageDelayed(0, 5000);
        }
    }

    public void updateDrawState(TextPaint textPaint) {
        Intrinsics.checkNotNullParameter(textPaint, "ds");
        textPaint.setUnderlineText(false);
    }
}
