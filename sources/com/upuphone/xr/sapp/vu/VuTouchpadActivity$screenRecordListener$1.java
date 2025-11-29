package com.upuphone.xr.sapp.vu;

import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.utils.ContextExtKt;
import com.upuphone.xr.sapp.utils.PhoneTypeUtils;
import com.upuphone.xr.sapp.vu.arspace.OnRecordScreenListener;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016¨\u0006\n"}, d2 = {"com/upuphone/xr/sapp/vu/VuTouchpadActivity$screenRecordListener$1", "Lcom/upuphone/xr/sapp/vu/arspace/OnRecordScreenListener;", "onPrepare", "", "type", "", "onRecordScreenEnd", "uri", "", "onRecordScreenStart", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class VuTouchpadActivity$screenRecordListener$1 implements OnRecordScreenListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ VuTouchpadActivity f8038a;

    public VuTouchpadActivity$screenRecordListener$1(VuTouchpadActivity vuTouchpadActivity) {
        this.f8038a = vuTouchpadActivity;
    }

    public void onPrepare(int i) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("VuTouchpadActivity", "onPrepare: " + i);
        this.f8038a.O1();
    }

    public void onRecordScreenEnd(String str) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("VuTouchpadActivity", "onRecordScreenEnd: " + str);
        this.f8038a.P1();
        if (PhoneTypeUtils.f7912a.e()) {
            return;
        }
        if (str == null || str.length() == 0) {
            ContextExtKt.e(R.string.screen_record_faile, 0, 2, (Object) null);
        } else {
            ContextExtKt.e(R.string.screen_record_success, 0, 2, (Object) null);
        }
    }

    public void onRecordScreenStart() {
        ULog.f6446a.a("VuTouchpadActivity", "onRecordScreenStart");
    }
}
