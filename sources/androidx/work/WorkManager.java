package androidx.work;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.work.impl.WorkManagerImpl;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@SuppressLint({"AddedAbstractMethod"})
public abstract class WorkManager {

    public enum UpdateResult {
        NOT_APPLIED,
        APPLIED_IMMEDIATELY,
        APPLIED_FOR_NEXT_RUN
    }

    public static WorkManager d(Context context) {
        return WorkManagerImpl.k(context);
    }

    public static void f(Context context, Configuration configuration) {
        WorkManagerImpl.f(context, configuration);
    }

    public abstract Operation a(String str);

    public final Operation b(WorkRequest workRequest) {
        return c(Collections.singletonList(workRequest));
    }

    public abstract Operation c(List list);

    public abstract LiveData e(UUID uuid);
}
