package androidx.browser.trusted;

import android.os.IBinder;
import android.support.customtabs.trusted.ITrustedWebActivityCallback;

public class TrustedWebActivityCallbackRemote {

    /* renamed from: a  reason: collision with root package name */
    public final ITrustedWebActivityCallback f437a;

    public TrustedWebActivityCallbackRemote(ITrustedWebActivityCallback iTrustedWebActivityCallback) {
        this.f437a = iTrustedWebActivityCallback;
    }

    public static TrustedWebActivityCallbackRemote a(IBinder iBinder) {
        ITrustedWebActivityCallback asInterface = iBinder == null ? null : ITrustedWebActivityCallback.Stub.asInterface(iBinder);
        if (asInterface == null) {
            return null;
        }
        return new TrustedWebActivityCallbackRemote(asInterface);
    }
}
