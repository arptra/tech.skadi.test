package androidx.appcompat.app;

import android.util.LongSparseArray;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

class ResourcesFlusher {

    @RequiresApi
    public static class Api16Impl {
        @DoNotInline
        public static void a(LongSparseArray longSparseArray) {
            longSparseArray.clear();
        }
    }
}
