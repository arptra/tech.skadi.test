package androidx.work.impl.foreground;

import androidx.annotation.RestrictTo;
import androidx.work.ForegroundInfo;

@RestrictTo
public interface ForegroundProcessor {
    void a(String str, ForegroundInfo foregroundInfo);
}
