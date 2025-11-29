package androidx.work;

import androidx.annotation.RestrictTo;

@RestrictTo
public class SystemClock implements Clock {
    public long currentTimeMillis() {
        return System.currentTimeMillis();
    }
}
