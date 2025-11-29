package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.work.Logger;
import androidx.work.impl.WorkManagerImpl;

public class RescheduleReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public static final String f2125a = Logger.i("RescheduleReceiver");

    public void onReceive(Context context, Intent intent) {
        Logger e = Logger.e();
        String str = f2125a;
        e.a(str, "Received intent " + intent);
        try {
            WorkManagerImpl.k(context).t(goAsync());
        } catch (IllegalStateException e2) {
            Logger.e().d(f2125a, "Cannot reschedule jobs. WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().", e2);
        }
    }
}
