package androidx.core.content;

import android.content.Intent;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.io.Serializable;
import java.util.ArrayList;

public final class IntentCompat {

    @RequiresApi
    public static class Api33Impl {
        @DoNotInline
        public static <T> T[] a(@NonNull Intent intent, @Nullable String str, @NonNull Class<T> cls) {
            return intent.getParcelableArrayExtra(str, cls);
        }

        @DoNotInline
        public static <T> ArrayList<T> b(@NonNull Intent intent, @Nullable String str, @NonNull Class<? extends T> cls) {
            return intent.getParcelableArrayListExtra(str, cls);
        }

        @DoNotInline
        public static <T> T c(@NonNull Intent intent, @Nullable String str, @NonNull Class<T> cls) {
            return intent.getParcelableExtra(str, cls);
        }

        @DoNotInline
        public static <T extends Serializable> T d(@NonNull Intent intent, @Nullable String str, @NonNull Class<T> cls) {
            return intent.getSerializableExtra(str, cls);
        }
    }
}
