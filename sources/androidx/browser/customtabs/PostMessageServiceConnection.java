package androidx.browser.customtabs;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.customtabs.ICustomTabsCallback;
import android.support.customtabs.IPostMessageService;

public abstract class PostMessageServiceConnection implements PostMessageBackend, ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    public final Object f426a;
    public final ICustomTabsCallback b;
    public IPostMessageService c;
    public boolean d;

    public final boolean a(Bundle bundle) {
        if (this.c == null) {
            return false;
        }
        synchronized (this.f426a) {
            try {
                this.c.onMessageChannelReady(this.b, bundle);
            } catch (RemoteException unused) {
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
        return true;
    }

    public void b() {
        if (this.d) {
            a((Bundle) null);
        }
    }

    public void c() {
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.c = IPostMessageService.Stub.asInterface(iBinder);
        b();
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        this.c = null;
        c();
    }
}
