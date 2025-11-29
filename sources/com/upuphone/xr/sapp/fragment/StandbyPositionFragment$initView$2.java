package com.upuphone.xr.sapp.fragment;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.upuphone.star.common.phone.UToast;
import com.upuphone.xr.sapp.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/upuphone/xr/sapp/fragment/StandbyPositionFragment$initView$2", "Landroid/view/View$OnTouchListener;", "onTouch", "", "v", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class StandbyPositionFragment$initView$2 implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ StandbyPositionFragment f7006a;

    public StandbyPositionFragment$initView$2(StandbyPositionFragment standbyPositionFragment) {
        this.f7006a = standbyPositionFragment;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.f7006a.k) {
            return false;
        }
        UToast.Companion companion = UToast.f6444a;
        Context requireContext = this.f7006a.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        String string = this.f7006a.getString(R.string.device_disconnect);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        companion.d(requireContext, string);
        return true;
    }
}
