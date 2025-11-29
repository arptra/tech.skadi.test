package com.upuphone.xr.sapp.vu;

import android.view.MotionEvent;
import android.view.View;
import com.upuphone.star.core.log.ULog;
import com.upuphone.starrynet.strategy.protocol.ProtocolVersions;
import com.upuphone.xr.sapp.databinding.FragmentVuTouchpadBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/upuphone/xr/sapp/vu/VuTouchpadActivity$initView$1", "Landroid/view/View$OnTouchListener;", "onTouch", "", "v", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class VuTouchpadActivity$initView$1 implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ VuTouchpadActivity f8035a;

    public VuTouchpadActivity$initView$1(VuTouchpadActivity vuTouchpadActivity) {
        this.f8035a = vuTouchpadActivity;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(view, ProtocolVersions.PROTOCOL_KEY_CONNECTION_VERSION);
        Intrinsics.checkNotNullParameter(motionEvent, "event");
        int action = motionEvent.getAction() & 255;
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("VuTouchpadActivity", "homeButton onTouch: " + action);
        FragmentVuTouchpadBinding fragmentVuTouchpadBinding = null;
        if (action == 0) {
            FragmentVuTouchpadBinding I0 = this.f8035a.c;
            if (I0 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentVuTouchpadBinding = I0;
            }
            fragmentVuTouchpadBinding.p.p();
            this.f8035a.L1();
            return false;
        } else if (action != 1 && action != 3) {
            return false;
        } else {
            FragmentVuTouchpadBinding I02 = this.f8035a.c;
            if (I02 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentVuTouchpadBinding = I02;
            }
            fragmentVuTouchpadBinding.p.q();
            this.f8035a.U0();
            return false;
        }
    }
}
