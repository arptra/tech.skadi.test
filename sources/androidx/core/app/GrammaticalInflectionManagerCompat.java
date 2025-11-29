package androidx.core.app;

import android.app.GrammaticalInflectionManager;
import android.content.Context;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class GrammaticalInflectionManagerCompat {

    @RequiresApi
    public static class Api34Impl {
        @DoNotInline
        public static int a(Context context) {
            return b(context).getApplicationGrammaticalGender();
        }

        public static GrammaticalInflectionManager b(Context context) {
            return (GrammaticalInflectionManager) context.getSystemService(GrammaticalInflectionManager.class);
        }

        @DoNotInline
        public static void c(Context context, int i) {
            b(context).setRequestedApplicationGrammaticalGender(i);
        }
    }

    @RestrictTo
    @Retention(RetentionPolicy.SOURCE)
    public @interface GrammaticalGender {
    }
}
