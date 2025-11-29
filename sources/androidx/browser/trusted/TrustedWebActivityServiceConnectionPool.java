package androidx.browser.trusted;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import no.nordicsemi.android.dfu.DfuBaseService;

public final class TrustedWebActivityServiceConnectionPool {

    public static class BindToServiceAsyncTask extends AsyncTask<Void, Void, Exception> {

        /* renamed from: a  reason: collision with root package name */
        public final Context f445a;
        public final Intent b;
        public final ConnectionHolder c;

        /* renamed from: a */
        public Exception doInBackground(Void... voidArr) {
            try {
                if (this.f445a.bindService(this.b, this.c, DfuBaseService.ERROR_FILE_NOT_FOUND)) {
                    return null;
                }
                this.f445a.unbindService(this.c);
                return new IllegalStateException("Could not bind to the service");
            } catch (SecurityException e) {
                Log.w("TWAConnectionPool", "SecurityException while binding.", e);
                return e;
            }
        }

        /* renamed from: b */
        public void onPostExecute(Exception exc) {
            if (exc != null) {
                this.c.a(exc);
            }
        }
    }
}
