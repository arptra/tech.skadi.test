package com.upuphone.xr.sapp.vu.input;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.upuphone.star.core.log.ULog;
import com.upuphone.starrynet.payload.PayloadConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/upuphone/xr/sapp/vu/input/VuTouchpadView$handler$1", "Landroid/os/Handler;", "handleMessage", "", "msg", "Landroid/os/Message;", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class VuTouchpadView$handler$1 extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ VuTouchpadView f8079a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VuTouchpadView$handler$1(VuTouchpadView vuTouchpadView, Looper looper) {
        super(looper);
        this.f8079a = vuTouchpadView;
    }

    public void handleMessage(Message message) {
        Intrinsics.checkNotNullParameter(message, PayloadConstant.PARAMS_KEY_CALLBACK_MSG);
        if (message.what == 100) {
            ULog.f6446a.g("VuTouchpadView", "handleMessage: MSG_LONG_PRESS");
            this.f8079a.i();
        }
    }
}
