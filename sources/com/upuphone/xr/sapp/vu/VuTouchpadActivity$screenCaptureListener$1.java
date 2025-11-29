package com.upuphone.xr.sapp.vu;

import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.utils.ContextExtKt;
import com.upuphone.xr.sapp.utils.PhoneTypeUtils;
import com.upuphone.xr.sapp.vu.arspace.OnCaptureScreenListener;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"com/upuphone/xr/sapp/vu/VuTouchpadActivity$screenCaptureListener$1", "Lcom/upuphone/xr/sapp/vu/arspace/OnCaptureScreenListener;", "onCaptureScreenEnd", "", "uri", "", "onCaptureScreenStart", "onPrepare", "type", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class VuTouchpadActivity$screenCaptureListener$1 implements OnCaptureScreenListener {
    public void onCaptureScreenEnd(String str) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("VuTouchpadActivity", "onCaptureScreenEnd: " + str);
        if (PhoneTypeUtils.f7912a.e()) {
            return;
        }
        if (str == null || str.length() == 0) {
            ContextExtKt.e(R.string.screenshot_failed, 0, 2, (Object) null);
        } else {
            ContextExtKt.e(R.string.screenshot_save_success, 0, 2, (Object) null);
        }
    }

    public void onCaptureScreenStart() {
        ULog.f6446a.a("VuTouchpadActivity", "onCaptureScreenStart");
    }

    public void onPrepare(int i) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("VuTouchpadActivity", "onPrepare: " + i);
    }
}
