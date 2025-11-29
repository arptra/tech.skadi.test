package androidx.asynclayoutinflater.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.util.Pools;
import java.util.concurrent.ArrayBlockingQueue;

public final class AsyncLayoutInflater {

    /* renamed from: a  reason: collision with root package name */
    public LayoutInflater f385a;
    public Handler b;
    public InflateThread c;

    /* renamed from: androidx.asynclayoutinflater.view.AsyncLayoutInflater$1  reason: invalid class name */
    public class AnonymousClass1 implements Handler.Callback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AsyncLayoutInflater f386a;

        public boolean handleMessage(Message message) {
            InflateRequest inflateRequest = (InflateRequest) message.obj;
            if (inflateRequest.d == null) {
                inflateRequest.d = this.f386a.f385a.inflate(inflateRequest.c, inflateRequest.b, false);
            }
            inflateRequest.e.a(inflateRequest.d, inflateRequest.c, inflateRequest.b);
            this.f386a.c.a(inflateRequest);
            return true;
        }
    }

    public static class BasicInflater extends LayoutInflater {

        /* renamed from: a  reason: collision with root package name */
        public static final String[] f387a = {"android.widget.", "android.webkit.", "android.app."};

        public BasicInflater(Context context) {
            super(context);
        }

        public LayoutInflater cloneInContext(Context context) {
            return new BasicInflater(context);
        }

        public View onCreateView(String str, AttributeSet attributeSet) {
            String[] strArr = f387a;
            int length = strArr.length;
            int i = 0;
            while (i < length) {
                try {
                    View createView = createView(str, strArr[i], attributeSet);
                    if (createView != null) {
                        return createView;
                    }
                    i++;
                } catch (ClassNotFoundException unused) {
                }
            }
            return super.onCreateView(str, attributeSet);
        }
    }

    public static class InflateRequest {

        /* renamed from: a  reason: collision with root package name */
        public AsyncLayoutInflater f388a;
        public ViewGroup b;
        public int c;
        public View d;
        public OnInflateFinishedListener e;
    }

    public static class InflateThread extends Thread {
        public static final InflateThread c;

        /* renamed from: a  reason: collision with root package name */
        public ArrayBlockingQueue f389a = new ArrayBlockingQueue(10);
        public Pools.SynchronizedPool b = new Pools.SynchronizedPool(10);

        static {
            InflateThread inflateThread = new InflateThread();
            c = inflateThread;
            inflateThread.start();
        }

        public void a(InflateRequest inflateRequest) {
            inflateRequest.e = null;
            inflateRequest.f388a = null;
            inflateRequest.b = null;
            inflateRequest.c = 0;
            inflateRequest.d = null;
            this.b.a(inflateRequest);
        }

        public void b() {
            try {
                InflateRequest inflateRequest = (InflateRequest) this.f389a.take();
                try {
                    inflateRequest.d = inflateRequest.f388a.f385a.inflate(inflateRequest.c, inflateRequest.b, false);
                } catch (RuntimeException e) {
                    Log.w("AsyncLayoutInflater", "Failed to inflate resource in the background! Retrying on the UI thread", e);
                }
                Message.obtain(inflateRequest.f388a.b, 0, inflateRequest).sendToTarget();
            } catch (InterruptedException e2) {
                Log.w("AsyncLayoutInflater", e2);
            }
        }

        public void run() {
            while (true) {
                b();
            }
        }
    }

    public interface OnInflateFinishedListener {
        void a(View view, int i, ViewGroup viewGroup);
    }
}
