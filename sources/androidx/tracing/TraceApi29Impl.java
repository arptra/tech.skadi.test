package androidx.tracing;

import android.os.Trace;
import androidx.annotation.RequiresApi;

@RequiresApi
final class TraceApi29Impl {
    public static void a(String str, int i) {
        Trace.beginAsyncSection(str, i);
    }

    public static void b(String str, int i) {
        Trace.endAsyncSection(str, i);
    }
}
