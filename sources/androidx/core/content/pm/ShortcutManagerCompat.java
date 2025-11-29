package androidx.core.content.pm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Handler;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class ShortcutManagerCompat {

    /* renamed from: androidx.core.content.pm.ShortcutManagerCompat$1  reason: invalid class name */
    class AnonymousClass1 extends BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ IntentSender f692a;

        public void onReceive(Context context, Intent intent) {
            try {
                this.f692a.sendIntent(context, 0, (Intent) null, (IntentSender.OnFinished) null, (Handler) null);
            } catch (IntentSender.SendIntentException unused) {
            }
        }
    }

    @RequiresApi
    public static class Api25Impl {
    }

    @RestrictTo
    @Retention(RetentionPolicy.SOURCE)
    public @interface ShortcutMatchFlags {
    }
}
