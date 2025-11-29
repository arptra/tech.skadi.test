package androidx.core.provider;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import androidx.annotation.RestrictTo;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

@Deprecated
@RestrictTo
public class SelfDestructiveThread {

    /* renamed from: a  reason: collision with root package name */
    public final Object f803a;
    public HandlerThread b;
    public Handler c;
    public final int d;

    /* renamed from: androidx.core.provider.SelfDestructiveThread$1  reason: invalid class name */
    public class AnonymousClass1 implements Handler.Callback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SelfDestructiveThread f804a;

        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                this.f804a.a();
                return true;
            } else if (i != 1) {
                return true;
            } else {
                this.f804a.b((Runnable) message.obj);
                return true;
            }
        }
    }

    /* renamed from: androidx.core.provider.SelfDestructiveThread$2  reason: invalid class name */
    class AnonymousClass2 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Callable f805a;
        public final /* synthetic */ Handler b;
        public final /* synthetic */ ReplyCallback c;

        public void run() {
            final Object obj;
            try {
                obj = this.f805a.call();
            } catch (Exception unused) {
                obj = null;
            }
            this.b.post(new Runnable() {
                public void run() {
                    AnonymousClass2.this.c.a(obj);
                }
            });
        }
    }

    /* renamed from: androidx.core.provider.SelfDestructiveThread$3  reason: invalid class name */
    class AnonymousClass3 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AtomicReference f807a;
        public final /* synthetic */ Callable b;
        public final /* synthetic */ ReentrantLock c;
        public final /* synthetic */ AtomicBoolean d;
        public final /* synthetic */ Condition e;

        public void run() {
            try {
                this.f807a.set(this.b.call());
            } catch (Exception unused) {
            }
            this.c.lock();
            try {
                this.d.set(false);
                this.e.signal();
            } finally {
                this.c.unlock();
            }
        }
    }

    public interface ReplyCallback<T> {
        void a(Object obj);
    }

    public void a() {
        synchronized (this.f803a) {
            try {
                if (!this.c.hasMessages(1)) {
                    this.b.quit();
                    this.b = null;
                    this.c = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void b(Runnable runnable) {
        runnable.run();
        synchronized (this.f803a) {
            this.c.removeMessages(0);
            Handler handler = this.c;
            handler.sendMessageDelayed(handler.obtainMessage(0), (long) this.d);
        }
    }
}
