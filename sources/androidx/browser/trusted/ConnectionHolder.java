package androidx.browser.trusted;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.customtabs.trusted.ITrustedWebActivityService;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.List;

class ConnectionHolder implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    public final Runnable f434a;
    public final WrapperFactory b;
    public int c;
    public TrustedWebActivityServiceConnection d;
    public List e;
    public Exception f;

    public static class WrapperFactory {
        public TrustedWebActivityServiceConnection a(ComponentName componentName, IBinder iBinder) {
            return new TrustedWebActivityServiceConnection(ITrustedWebActivityService.Stub.asInterface(iBinder), componentName);
        }
    }

    public void a(Exception exc) {
        for (CallbackToFutureAdapter.Completer d2 : this.e) {
            d2.d(exc);
        }
        this.e.clear();
        this.f434a.run();
        this.c = 3;
        this.f = exc;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.d = this.b.a(componentName, iBinder);
        for (CallbackToFutureAdapter.Completer b2 : this.e) {
            b2.b(this.d);
        }
        this.e.clear();
        this.c = 1;
    }

    public void onServiceDisconnected(ComponentName componentName) {
        this.d = null;
        this.f434a.run();
        this.c = 2;
    }
}
