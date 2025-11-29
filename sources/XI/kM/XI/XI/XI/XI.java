package XI.kM.XI.XI.XI;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class XI implements ServiceConnection {
    public static final ThreadPoolExecutor c = new ThreadPoolExecutor(0, 3, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(2048), new ThreadPoolExecutor.DiscardPolicy());

    /* renamed from: a  reason: collision with root package name */
    public boolean f57a = false;
    public final LinkedBlockingQueue b = new LinkedBlockingQueue(1);

    /* renamed from: XI.kM.XI.XI.XI.XI$XI  reason: collision with other inner class name */
    public class C0006XI implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ IBinder f58a;

        public C0006XI(IBinder iBinder) {
            this.f58a = iBinder;
        }

        public final void run() {
            try {
                System.currentTimeMillis();
                XI.this.b.offer(this.f58a);
            } catch (Throwable unused) {
            }
        }
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        c.execute(new C0006XI(iBinder));
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        System.currentTimeMillis();
    }
}
