package android.bluetooth.client.pbap;

import android.os.Handler;
import android.util.Log;
import com.meizu.common.widget.MzContactsContract;
import java.io.IOException;
import javax.obex.ClientSession;
import javax.obex.HeaderSet;
import javax.obex.ObexTransport;

final class BluetoothPbapObexSession {
    public static final byte[] e = {121, 97, 53, -16, -16, -59, 17, -40, 9, 102, 8, 0, 32, 12, -102, 102};

    /* renamed from: a  reason: collision with root package name */
    public Handler f69a;
    public final ObexTransport b;
    public ObexClientThread c;
    public BluetoothPbapObexAuthenticator d = null;

    /* renamed from: android.bluetooth.client.pbap.BluetoothPbapObexSession$1  reason: invalid class name */
    class AnonymousClass1 extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BluetoothPbapObexSession f70a;

        public void run() {
            this.f70a.c.c.a();
        }
    }

    public class ObexClientThread extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public final Object f71a = new Object();
        public ClientSession b = null;
        public BluetoothPbapRequest c = null;
        public volatile boolean d = true;

        public ObexClientThread() {
        }

        /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean b() {
            /*
                r4 = this;
                java.lang.String r0 = "ObexClientThread"
                java.lang.String r1 = "connect"
                android.util.Log.d(r0, r1)
                r0 = 0
                javax.obex.ClientSession r1 = new javax.obex.ClientSession     // Catch:{ IOException -> 0x0040 }
                android.bluetooth.client.pbap.BluetoothPbapObexSession r2 = android.bluetooth.client.pbap.BluetoothPbapObexSession.this     // Catch:{ IOException -> 0x0040 }
                javax.obex.ObexTransport r2 = r2.b     // Catch:{ IOException -> 0x0040 }
                r1.<init>(r2)     // Catch:{ IOException -> 0x0040 }
                r4.b = r1     // Catch:{ IOException -> 0x0040 }
                android.bluetooth.client.pbap.BluetoothPbapObexSession r2 = android.bluetooth.client.pbap.BluetoothPbapObexSession.this     // Catch:{ IOException -> 0x0040 }
                android.bluetooth.client.pbap.BluetoothPbapObexAuthenticator r2 = r2.d     // Catch:{ IOException -> 0x0040 }
                r1.i(r2)     // Catch:{ IOException -> 0x0040 }
                javax.obex.HeaderSet r1 = new javax.obex.HeaderSet
                r1.<init>()
                r2 = 70
                byte[] r3 = android.bluetooth.client.pbap.BluetoothPbapObexSession.e
                r1.e(r2, r3)
                javax.obex.ClientSession r2 = r4.b     // Catch:{  }
                javax.obex.HeaderSet r1 = r2.d(r1)     // Catch:{  }
                int r1 = r1.d()     // Catch:{  }
                r2 = 160(0xa0, float:2.24E-43)
                if (r1 == r2) goto L_0x003e
                r4.c()     // Catch:{  }
                return r0
            L_0x003e:
                r4 = 1
                return r4
            L_0x0040:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: android.bluetooth.client.pbap.BluetoothPbapObexSession.ObexClientThread.b():boolean");
        }

        public final void c() {
            Log.d("ObexClientThread", "disconnect");
            ClientSession clientSession = this.b;
            if (clientSession != null) {
                try {
                    clientSession.e((HeaderSet) null);
                    this.b.c();
                } catch (IOException unused) {
                }
            }
        }

        public boolean d(BluetoothPbapRequest bluetoothPbapRequest) {
            synchronized (this.f71a) {
                try {
                    Log.d("ObexClientThread", "schedule: " + bluetoothPbapRequest.getClass().getSimpleName());
                    if (this.c != null) {
                        return false;
                    }
                    this.c = bluetoothPbapRequest;
                    this.f71a.notifyAll();
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:18:0x003f, code lost:
            if (r3.d == false) goto L_0x0078;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0041, code lost:
            r0 = r3.c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0043, code lost:
            if (r0 == null) goto L_0x0078;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
            r0.c(r3.b);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x004b, code lost:
            r3.d = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
            java.lang.Thread.currentThread().interrupt();
            r3.d = false;
         */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:30:0x007c */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r3 = this;
                super.run()
                boolean r0 = r3.b()
                if (r0 != 0) goto L_0x0019
                android.bluetooth.client.pbap.BluetoothPbapObexSession r3 = android.bluetooth.client.pbap.BluetoothPbapObexSession.this
                android.os.Handler r3 = r3.f69a
                r0 = 101(0x65, float:1.42E-43)
                android.os.Message r3 = r3.obtainMessage(r0)
                r3.sendToTarget()
                return
            L_0x0019:
                android.bluetooth.client.pbap.BluetoothPbapObexSession r0 = android.bluetooth.client.pbap.BluetoothPbapObexSession.this
                android.os.Handler r0 = r0.f69a
                r1 = 100
                android.os.Message r0 = r0.obtainMessage(r1)
                r0.sendToTarget()
            L_0x0028:
                boolean r0 = r3.d
                if (r0 == 0) goto L_0x0089
                java.lang.Object r0 = r3.f71a
                monitor-enter(r0)
                r1 = 0
                android.bluetooth.client.pbap.BluetoothPbapRequest r2 = r3.c     // Catch:{ InterruptedException -> 0x007c }
                if (r2 != 0) goto L_0x003c
                java.lang.Object r2 = r3.f71a     // Catch:{ InterruptedException -> 0x007c }
                r2.wait()     // Catch:{ InterruptedException -> 0x007c }
                goto L_0x003c
            L_0x003a:
                r3 = move-exception
                goto L_0x0087
            L_0x003c:
                monitor-exit(r0)     // Catch:{ all -> 0x003a }
                boolean r0 = r3.d
                if (r0 == 0) goto L_0x0078
                android.bluetooth.client.pbap.BluetoothPbapRequest r0 = r3.c
                if (r0 == 0) goto L_0x0078
                javax.obex.ClientSession r2 = r3.b     // Catch:{ IOException -> 0x004b }
                r0.c(r2)     // Catch:{ IOException -> 0x004b }
                goto L_0x004d
            L_0x004b:
                r3.d = r1
            L_0x004d:
                android.bluetooth.client.pbap.BluetoothPbapRequest r0 = r3.c
                boolean r0 = r0.d()
                if (r0 == 0) goto L_0x0067
                android.bluetooth.client.pbap.BluetoothPbapObexSession r0 = android.bluetooth.client.pbap.BluetoothPbapObexSession.this
                android.os.Handler r0 = r0.f69a
                r1 = 103(0x67, float:1.44E-43)
                android.bluetooth.client.pbap.BluetoothPbapRequest r2 = r3.c
                android.os.Message r0 = r0.obtainMessage(r1, r2)
                r0.sendToTarget()
                goto L_0x0078
            L_0x0067:
                android.bluetooth.client.pbap.BluetoothPbapObexSession r0 = android.bluetooth.client.pbap.BluetoothPbapObexSession.this
                android.os.Handler r0 = r0.f69a
                r1 = 104(0x68, float:1.46E-43)
                android.bluetooth.client.pbap.BluetoothPbapRequest r2 = r3.c
                android.os.Message r0 = r0.obtainMessage(r1, r2)
                r0.sendToTarget()
            L_0x0078:
                r0 = 0
                r3.c = r0
                goto L_0x0028
            L_0x007c:
                java.lang.Thread r2 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x003a }
                r2.interrupt()     // Catch:{ all -> 0x003a }
                r3.d = r1     // Catch:{ all -> 0x003a }
                monitor-exit(r0)     // Catch:{ all -> 0x003a }
                goto L_0x0089
            L_0x0087:
                monitor-exit(r0)     // Catch:{ all -> 0x003a }
                throw r3
            L_0x0089:
                r3.c()
                android.bluetooth.client.pbap.BluetoothPbapObexSession r0 = android.bluetooth.client.pbap.BluetoothPbapObexSession.this
                android.os.Handler r0 = r0.f69a
                android.os.Looper r0 = r0.getLooper()
                java.lang.Thread r0 = r0.getThread()
                boolean r0 = r0.isAlive()
                if (r0 == 0) goto L_0x00b0
                android.bluetooth.client.pbap.BluetoothPbapObexSession r3 = android.bluetooth.client.pbap.BluetoothPbapObexSession.this
                android.os.Handler r3 = r3.f69a
                r0 = 102(0x66, float:1.43E-43)
                android.os.Message r3 = r3.obtainMessage(r0)
                r3.sendToTarget()
                goto L_0x00b7
            L_0x00b0:
                java.lang.String r3 = "ObexClientThread"
                java.lang.String r0 = "Thread of mSessionHandler is already died, ignore the message."
                android.util.Log.d(r3, r0)
            L_0x00b7:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: android.bluetooth.client.pbap.BluetoothPbapObexSession.ObexClientThread.run():void");
        }
    }

    public BluetoothPbapObexSession(ObexTransport obexTransport) {
        this.b = obexTransport;
    }

    public boolean f(BluetoothPbapRequest bluetoothPbapRequest) {
        Log.d("BluetoothPbapObexSession", "schedule: " + bluetoothPbapRequest.getClass().getSimpleName());
        ObexClientThread obexClientThread = this.c;
        if (obexClientThread != null) {
            return obexClientThread.d(bluetoothPbapRequest);
        }
        Log.e("BluetoothPbapObexSession", "OBEX session not started");
        return false;
    }

    public boolean g(String str) {
        Log.d("BluetoothPbapObexSession", "setAuthReply key=" + str);
        BluetoothPbapObexAuthenticator bluetoothPbapObexAuthenticator = this.d;
        if (bluetoothPbapObexAuthenticator == null) {
            return false;
        }
        bluetoothPbapObexAuthenticator.c(str);
        return true;
    }

    public void h(Handler handler) {
        Log.d("BluetoothPbapObexSession", MzContactsContract.START_PARAM_KEY);
        this.f69a = handler;
        this.d = new BluetoothPbapObexAuthenticator(handler);
        ObexClientThread obexClientThread = new ObexClientThread();
        this.c = obexClientThread;
        obexClientThread.start();
    }

    public void i() {
        Log.d("BluetoothPbapObexSession", "stop");
        ObexClientThread obexClientThread = this.c;
        if (obexClientThread != null) {
            try {
                obexClientThread.interrupt();
                this.c.join();
                this.c = null;
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
