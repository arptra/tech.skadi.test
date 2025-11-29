package androidx.core.content;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback;
import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportService;

public abstract class UnusedAppRestrictionsBackportService extends Service {

    /* renamed from: a  reason: collision with root package name */
    public IUnusedAppRestrictionsBackportService.Stub f690a = new IUnusedAppRestrictionsBackportService.Stub() {
        public void isPermissionRevocationEnabledForApp(@Nullable IUnusedAppRestrictionsBackportCallback iUnusedAppRestrictionsBackportCallback) throws RemoteException {
            if (iUnusedAppRestrictionsBackportCallback != null) {
                UnusedAppRestrictionsBackportService.this.a(new UnusedAppRestrictionsBackportCallback(iUnusedAppRestrictionsBackportCallback));
            }
        }
    };

    public abstract void a(UnusedAppRestrictionsBackportCallback unusedAppRestrictionsBackportCallback);

    public IBinder onBind(Intent intent) {
        return this.f690a;
    }
}
