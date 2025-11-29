package androidx.work;

import android.content.Context;
import java.util.List;

public class DelegatingWorkerFactory extends WorkerFactory {
    public static final String c = Logger.i("DelegatingWkrFctry");
    public final List b;

    public final ListenableWorker a(Context context, String str, WorkerParameters workerParameters) {
        for (WorkerFactory a2 : this.b) {
            try {
                ListenableWorker a3 = a2.a(context, str, workerParameters);
                if (a3 != null) {
                    return a3;
                }
            } catch (Throwable th) {
                Logger.e().d(c, "Unable to instantiate a ListenableWorker (" + str + ")", th);
                throw th;
            }
        }
        return null;
    }
}
