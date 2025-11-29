package androidx.core.content;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import androidx.concurrent.futures.ResolvableFuture;
import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback;
import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportService;

class UnusedAppRestrictionsBackportServiceConnection implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    public IUnusedAppRestrictionsBackportService f691a;
    public ResolvableFuture b;

    public final IUnusedAppRestrictionsBackportCallback a() {
        return new IUnusedAppRestrictionsBackportCallback.Stub() {
            public void onIsPermissionRevocationEnabledForAppResult(boolean z, boolean z2) throws RemoteException {
                if (!z) {
                    UnusedAppRestrictionsBackportServiceConnection.this.b.o(0);
                    Log.e("PackageManagerCompat", "Unable to retrieve the permission revocation setting from the backport");
                } else if (z2) {
                    UnusedAppRestrictionsBackportServiceConnection.this.b.o(3);
                } else {
                    UnusedAppRestrictionsBackportServiceConnection.this.b.o(2);
                }
            }
        };
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        IUnusedAppRestrictionsBackportService asInterface = IUnusedAppRestrictionsBackportService.Stub.asInterface(iBinder);
        this.f691a = asInterface;
        try {
            asInterface.isPermissionRevocationEnabledForApp(a());
        } catch (RemoteException unused) {
            this.b.o(0);
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        this.f691a = null;
    }
}
