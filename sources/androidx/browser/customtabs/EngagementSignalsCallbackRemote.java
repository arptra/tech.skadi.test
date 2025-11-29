package androidx.browser.customtabs;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.customtabs.IEngagementSignalsCallback;
import android.util.Log;
import androidx.annotation.RestrictTo;

@RestrictTo
final class EngagementSignalsCallbackRemote implements EngagementSignalsCallback {

    /* renamed from: a  reason: collision with root package name */
    public final IEngagementSignalsCallback f424a;

    public EngagementSignalsCallbackRemote(IEngagementSignalsCallback iEngagementSignalsCallback) {
        this.f424a = iEngagementSignalsCallback;
    }

    public static EngagementSignalsCallbackRemote a(IBinder iBinder) {
        return new EngagementSignalsCallbackRemote(IEngagementSignalsCallback.Stub.asInterface(iBinder));
    }

    public void onGreatestScrollPercentageIncreased(int i, Bundle bundle) {
        try {
            this.f424a.onGreatestScrollPercentageIncreased(i, bundle);
        } catch (RemoteException unused) {
            Log.e("EngagementSigsCallbkRmt", "RemoteException during IEngagementSignalsCallback transaction");
        }
    }

    public void onSessionEnded(boolean z, Bundle bundle) {
        try {
            this.f424a.onSessionEnded(z, bundle);
        } catch (RemoteException unused) {
            Log.e("EngagementSigsCallbkRmt", "RemoteException during IEngagementSignalsCallback transaction");
        }
    }

    public void onVerticalScrollEvent(boolean z, Bundle bundle) {
        try {
            this.f424a.onVerticalScrollEvent(z, bundle);
        } catch (RemoteException unused) {
            Log.e("EngagementSigsCallbkRmt", "RemoteException during IEngagementSignalsCallback transaction");
        }
    }
}
