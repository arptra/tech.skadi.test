package androidx.core.app;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.io.Closeable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.CountDownLatch;

public final class PendingIntentCompat {

    @RequiresApi
    public static class Api23Impl {
        @DoNotInline
        public static void a(@NonNull PendingIntent pendingIntent, @NonNull Context context, int i, @NonNull Intent intent, @Nullable PendingIntent.OnFinished onFinished, @Nullable Handler handler, @Nullable String str, @Nullable Bundle bundle) throws PendingIntent.CanceledException {
            pendingIntent.send(context, i, intent, onFinished, handler, str, bundle);
        }
    }

    @RequiresApi
    public static class Api26Impl {
        @DoNotInline
        public static PendingIntent a(Context context, int i, Intent intent, int i2) {
            return PendingIntent.getForegroundService(context, i, intent, i2);
        }
    }

    @RestrictTo
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    public static class GatedCallback implements Closeable {

        /* renamed from: a  reason: collision with root package name */
        public final CountDownLatch f675a;
        public PendingIntent.OnFinished b;
        public boolean c;

        public void close() {
            if (!this.c) {
                this.b = null;
            }
            this.f675a.countDown();
        }
    }
}
