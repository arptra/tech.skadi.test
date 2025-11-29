package androidx.work.impl;

import androidx.annotation.RestrictTo;
import androidx.work.impl.model.WorkGenerationalId;

@RestrictTo
public interface ExecutionListener {
    void c(WorkGenerationalId workGenerationalId, boolean z);
}
