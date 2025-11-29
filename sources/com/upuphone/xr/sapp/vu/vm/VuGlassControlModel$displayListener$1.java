package com.upuphone.xr.sapp.vu.vm;

import android.hardware.display.DisplayManager;
import android.view.Display;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.utils.DataStoreUtils;
import com.upuphone.xr.sapp.vu.utils.VuGlassesHelper;
import com.upuphone.xr.sapp.vu.vm.VuGlassControlModel;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b"}, d2 = {"com/upuphone/xr/sapp/vu/vm/VuGlassControlModel$displayListener$1", "Landroid/hardware/display/DisplayManager$DisplayListener;", "onDisplayAdded", "", "displayId", "", "onDisplayChanged", "onDisplayRemoved", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class VuGlassControlModel$displayListener$1 implements DisplayManager.DisplayListener {
    public void onDisplayAdded(int i) {
        Display display = VuGlassControlModel.f8109a.t().getDisplay(i);
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("VuGlassControlModel", "onDisplayAdded: display: " + display);
        if (VuGlassesHelper.f8099a.e(display)) {
            Deferred f = VuGlassControlModel.g;
            if (f != null) {
                Job.DefaultImpls.a(f, (CancellationException) null, 1, (Object) null);
            }
            Job unused = BuildersKt__Builders_commonKt.d(VuGlassControlModel.f, Dispatchers.b(), (CoroutineStart) null, new VuGlassControlModel$displayListener$1$onDisplayAdded$1(display, i, (Continuation<? super VuGlassControlModel$displayListener$1$onDisplayAdded$1>) null), 2, (Object) null);
        }
    }

    public void onDisplayChanged(int i) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("VuGlassControlModel", "onDisplayChanged: " + i);
        Job unused = BuildersKt__Builders_commonKt.d(VuGlassControlModel.f, Dispatchers.b(), (CoroutineStart) null, new VuGlassControlModel$displayListener$1$onDisplayChanged$1(i, (Continuation<? super VuGlassControlModel$displayListener$1$onDisplayChanged$1>) null), 2, (Object) null);
    }

    public void onDisplayRemoved(int i) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("VuGlassControlModel", "onDisplayRemoved: " + i);
        VuGlassControlModel.ViewGlassesInfo viewGlassesInfo = (VuGlassControlModel.ViewGlassesInfo) VuGlassControlModel.b.getValue();
        Integer valueOf = viewGlassesInfo != null ? Integer.valueOf(viewGlassesInfo.a()) : null;
        if (i != 0 && valueOf != null && i == valueOf.intValue()) {
            VuGlassControlModel.ViewGlassesInfo viewGlassesInfo2 = new VuGlassControlModel.ViewGlassesInfo((VuGlassControlModel.ViewGlassesInfo) VuGlassControlModel.b.getValue());
            viewGlassesInfo2.h(0);
            viewGlassesInfo2.i(0);
            viewGlassesInfo2.l(0);
            VuGlassControlModel.b.setValue(viewGlassesInfo2);
            DataStoreUtils.e.a().o("vu_connected_view_glass", viewGlassesInfo2.m());
            VuGlassControlModel.f8109a.n();
        }
    }
}
