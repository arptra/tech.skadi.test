package androidx.core.app;

import android.os.Bundle;
import android.os.IBinder;

@Deprecated
public final class BundleCompat {
    public static IBinder a(Bundle bundle, String str) {
        return bundle.getBinder(str);
    }

    public static void b(Bundle bundle, String str, IBinder iBinder) {
        bundle.putBinder(str, iBinder);
    }
}
