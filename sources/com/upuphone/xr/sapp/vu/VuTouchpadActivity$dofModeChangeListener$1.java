package com.upuphone.xr.sapp.vu;

import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.vu.arspace.IOnDofModeChangeListener;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/upuphone/xr/sapp/vu/VuTouchpadActivity$dofModeChangeListener$1", "Lcom/upuphone/xr/sapp/vu/arspace/IOnDofModeChangeListener$Stub;", "onDofModeChanged", "", "dofMode", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class VuTouchpadActivity$dofModeChangeListener$1 extends IOnDofModeChangeListener.Stub {
    final /* synthetic */ VuTouchpadActivity this$0;

    public VuTouchpadActivity$dofModeChangeListener$1(VuTouchpadActivity vuTouchpadActivity) {
        this.this$0 = vuTouchpadActivity;
    }

    public void onDofModeChanged(int i) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("VuTouchpadActivity", "onDofModeChanged: " + i);
        this.this$0.R1(Integer.valueOf(i));
    }
}
