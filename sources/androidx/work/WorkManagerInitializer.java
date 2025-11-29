package androidx.work;

import android.content.Context;
import androidx.startup.Initializer;
import androidx.work.Configuration;
import java.util.Collections;
import java.util.List;

public final class WorkManagerInitializer implements Initializer<WorkManager> {

    /* renamed from: a  reason: collision with root package name */
    public static final String f2068a = Logger.i("WrkMgrInitializer");

    /* renamed from: b */
    public WorkManager a(Context context) {
        Logger.e().a(f2068a, "Initializing WorkManager with default configuration.");
        WorkManager.f(context, new Configuration.Builder().a());
        return WorkManager.d(context);
    }

    public List dependencies() {
        return Collections.emptyList();
    }
}
