package androidx.tracing;

import android.os.Trace;
import androidx.annotation.RequiresApi;

@RequiresApi
final class TraceApi18Impl {
    public static void a(String str) {
        Trace.beginSection(str);
    }

    public static void b() {
        Trace.endSection();
    }
}
