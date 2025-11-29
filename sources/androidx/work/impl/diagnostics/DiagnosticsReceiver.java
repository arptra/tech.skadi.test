package androidx.work.impl.diagnostics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.RestrictTo;
import androidx.work.Logger;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.impl.workers.DiagnosticsWorker;

@RestrictTo
public class DiagnosticsReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public static final String f2154a = Logger.i("DiagnosticsRcvr");

    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            Logger.e().a(f2154a, "Requesting diagnostics");
            try {
                WorkManager.d(context).b(OneTimeWorkRequest.e(DiagnosticsWorker.class));
            } catch (IllegalStateException e) {
                Logger.e().d(f2154a, "WorkManager is not initialized", e);
            }
        }
    }
}
