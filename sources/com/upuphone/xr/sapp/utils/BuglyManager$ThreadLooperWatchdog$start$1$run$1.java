package com.upuphone.xr.sapp.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.upuphone.starrynet.payload.PayloadConstant;
import com.upuphone.xr.sapp.utils.BuglyManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/upuphone/xr/sapp/utils/BuglyManager$ThreadLooperWatchdog$start$1$run$1", "Landroid/os/Handler;", "", "a", "()V", "Landroid/os/Message;", "msg", "handleMessage", "(Landroid/os/Message;)V", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class BuglyManager$ThreadLooperWatchdog$start$1$run$1 extends Handler {
    public BuglyManager$ThreadLooperWatchdog$start$1$run$1(Looper looper) {
        super(looper);
    }

    public final void a() {
        Handler c = BuglyManager.ThreadLooperWatchdog.b;
        Handler handler = null;
        if (c == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mWatchHandler");
            c = null;
        }
        c.removeMessages(2);
        Handler c2 = BuglyManager.ThreadLooperWatchdog.b;
        if (c2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mWatchHandler");
        } else {
            handler = c2;
        }
        handler.removeMessages(1);
    }

    public void handleMessage(Message message) {
        Intrinsics.checkNotNullParameter(message, PayloadConstant.PARAMS_KEY_CALLBACK_MSG);
        int i = message.what;
        Handler handler = null;
        if (i == 1) {
            a();
            Handler b = BuglyManager.ThreadLooperWatchdog.c;
            if (b == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMainLooperHandler");
                b = null;
            }
            if (b.getLooper().getQueue().isIdle()) {
                Handler c = BuglyManager.ThreadLooperWatchdog.b;
                if (c == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mWatchHandler");
                } else {
                    handler = c;
                }
                handler.sendEmptyMessageDelayed(1, BuglyManager.ThreadLooperWatchdog.d);
                return;
            }
            Handler b2 = BuglyManager.ThreadLooperWatchdog.c;
            if (b2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMainLooperHandler");
                b2 = null;
            }
            b2.sendEmptyMessage(1);
            Handler c2 = BuglyManager.ThreadLooperWatchdog.b;
            if (c2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mWatchHandler");
            } else {
                handler = c2;
            }
            handler.sendEmptyMessageDelayed(2, BuglyManager.ThreadLooperWatchdog.e);
        } else if (i == 2) {
            long a2 = BuglyManager.ThreadLooperWatchdog.d;
            Handler b3 = BuglyManager.ThreadLooperWatchdog.c;
            if (b3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMainLooperHandler");
                b3 = null;
            }
            if (b3.hasMessages(1)) {
                Handler b4 = BuglyManager.ThreadLooperWatchdog.c;
                if (b4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mMainLooperHandler");
                    b4 = null;
                }
                b4.removeMessages(1);
                BuglyManager.ThreadLooperWatchdog.f7851a.g();
                a2 = BuglyManager.ThreadLooperWatchdog.d * ((long) 10);
            }
            a();
            Handler c3 = BuglyManager.ThreadLooperWatchdog.b;
            if (c3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mWatchHandler");
            } else {
                handler = c3;
            }
            handler.sendEmptyMessageDelayed(1, a2);
        }
    }
}
