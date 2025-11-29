package androidx.work.impl;

import androidx.annotation.RestrictTo;
import androidx.work.impl.model.WorkSpec;

@RestrictTo
public interface Scheduler {
    boolean a();

    void b(WorkSpec... workSpecArr);

    void cancel(String str);
}
