package com.upuphone.xr.sapp.utils;

import android.os.Handler;
import android.os.Looper;
import com.upuphone.xr.sapp.utils.BuglyManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nBuglyManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BuglyManager.kt\ncom/upuphone/xr/sapp/utils/BuglyManager$ThreadLooperWatchdog$start$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,349:1\n1#2:350\n*E\n"})
@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/upuphone/xr/sapp/utils/BuglyManager$ThreadLooperWatchdog$start$1", "Ljava/lang/Thread;", "run", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class BuglyManager$ThreadLooperWatchdog$start$1 extends Thread {
    public void run() {
        Looper.prepare();
        Looper myLooper = Looper.myLooper();
        Intrinsics.checkNotNull(myLooper);
        BuglyManager.ThreadLooperWatchdog.b = new BuglyManager$ThreadLooperWatchdog$start$1$run$1(myLooper);
        BuglyManager.ThreadLooperWatchdog.c = new Handler(Looper.getMainLooper());
        Handler c = BuglyManager.ThreadLooperWatchdog.b;
        if (c == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mWatchHandler");
            c = null;
        }
        c.sendEmptyMessageDelayed(1, BuglyManager.ThreadLooperWatchdog.d);
        Looper.loop();
    }
}
