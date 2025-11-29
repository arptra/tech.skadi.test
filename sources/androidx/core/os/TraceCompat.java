package androidx.core.os;

import android.os.Trace;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

@Deprecated
public final class TraceCompat {

    @RequiresApi
    public static class Api29Impl {
        @DoNotInline
        public static void a(String str, int i) {
            Trace.beginAsyncSection(str, i);
        }

        @DoNotInline
        public static void b(String str, int i) {
            Trace.endAsyncSection(str, i);
        }

        @DoNotInline
        public static boolean c() {
            return Trace.isEnabled();
        }

        @DoNotInline
        public static void d(String str, long j) {
            Trace.setCounter(str, j);
        }
    }

    public static void a(String str) {
        Trace.beginSection(str);
    }

    public static void b() {
        Trace.endSection();
    }
}
