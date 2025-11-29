package android.bluetooth.client.pbap;

import android.os.Handler;
import android.util.Log;
import javax.obex.Authenticator;

class BluetoothPbapObexAuthenticator implements Authenticator {

    /* renamed from: a  reason: collision with root package name */
    public String f68a;
    public boolean b;
    public final Handler c;

    public BluetoothPbapObexAuthenticator(Handler handler) {
        this.c = handler;
    }

    public byte[] a(byte[] bArr) {
        return null;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(9:5|6|7|9|10|24|21|3|2) */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x000f, code lost:
        continue;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0020 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public javax.obex.PasswordAuthentication b(java.lang.String r2, boolean r3, boolean r4) {
        /*
            r1 = this;
            r2 = 0
            r1.b = r2
            android.os.Handler r2 = r1.c
            r3 = 105(0x69, float:1.47E-43)
            android.os.Message r2 = r2.obtainMessage(r3)
            r2.sendToTarget()
            monitor-enter(r1)
        L_0x000f:
            boolean r2 = r1.b     // Catch:{ all -> 0x001e }
            if (r2 != 0) goto L_0x002f
            java.lang.String r2 = "BluetoothPbapObexAuthenticator"
            java.lang.String r3 = "onAuthenticationChallenge: waiting for response"
            android.util.Log.v(r2, r3)     // Catch:{ InterruptedException -> 0x0020 }
            r1.wait()     // Catch:{ InterruptedException -> 0x0020 }
            goto L_0x000f
        L_0x001e:
            r2 = move-exception
            goto L_0x0068
        L_0x0020:
            java.lang.Thread r2 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x001e }
            r2.interrupt()     // Catch:{ all -> 0x001e }
            java.lang.String r2 = "BluetoothPbapObexAuthenticator"
            java.lang.String r3 = "Interrupted while waiting for challenge response"
            android.util.Log.e(r2, r3)     // Catch:{ all -> 0x001e }
            goto L_0x000f
        L_0x002f:
            monitor-exit(r1)     // Catch:{ all -> 0x001e }
            java.lang.String r2 = r1.f68a
            r3 = 0
            if (r2 == 0) goto L_0x0060
            int r2 = r2.length()
            if (r2 == 0) goto L_0x0060
            java.lang.String r2 = "BluetoothPbapObexAuthenticator"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r0 = "onAuthenticationChallenge: mSessionKey="
            r4.append(r0)
            java.lang.String r0 = r1.f68a
            r4.append(r0)
            java.lang.String r4 = r4.toString()
            android.util.Log.v(r2, r4)
            javax.obex.PasswordAuthentication r2 = new javax.obex.PasswordAuthentication
            java.lang.String r1 = r1.f68a
            byte[] r1 = r1.getBytes()
            r2.<init>(r3, r1)
            r3 = r2
            goto L_0x0067
        L_0x0060:
            java.lang.String r1 = "BluetoothPbapObexAuthenticator"
            java.lang.String r2 = "onAuthenticationChallenge: mSessionKey is empty, timeout/cancel occured"
            android.util.Log.v(r1, r2)
        L_0x0067:
            return r3
        L_0x0068:
            monitor-exit(r1)     // Catch:{ all -> 0x001e }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: android.bluetooth.client.pbap.BluetoothPbapObexAuthenticator.b(java.lang.String, boolean, boolean):javax.obex.PasswordAuthentication");
    }

    public synchronized void c(String str) {
        Log.d("BluetoothPbapObexAuthenticator", "setReply key=" + str);
        this.f68a = str;
        this.b = true;
        notifyAll();
    }
}
