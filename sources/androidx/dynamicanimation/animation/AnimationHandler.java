package androidx.dynamicanimation.animation;

import android.os.Handler;
import android.os.SystemClock;
import android.view.Choreographer;
import androidx.annotation.RequiresApi;
import androidx.collection.SimpleArrayMap;
import java.util.ArrayList;

class AnimationHandler {
    public static final ThreadLocal g = new ThreadLocal();

    /* renamed from: a  reason: collision with root package name */
    public final SimpleArrayMap f1179a = new SimpleArrayMap();
    public final ArrayList b = new ArrayList();
    public final AnimationCallbackDispatcher c = new AnimationCallbackDispatcher();
    public AnimationFrameCallbackProvider d;
    public long e = 0;
    public boolean f = false;

    public class AnimationCallbackDispatcher {
        public AnimationCallbackDispatcher() {
        }

        public void a() {
            AnimationHandler.this.e = SystemClock.uptimeMillis();
            AnimationHandler animationHandler = AnimationHandler.this;
            animationHandler.c(animationHandler.e);
            if (AnimationHandler.this.b.size() > 0) {
                AnimationHandler.this.e().a();
            }
        }
    }

    public interface AnimationFrameCallback {
        boolean a(long j);
    }

    public static abstract class AnimationFrameCallbackProvider {

        /* renamed from: a  reason: collision with root package name */
        public final AnimationCallbackDispatcher f1181a;

        public AnimationFrameCallbackProvider(AnimationCallbackDispatcher animationCallbackDispatcher) {
            this.f1181a = animationCallbackDispatcher;
        }

        public abstract void a();
    }

    public static class FrameCallbackProvider14 extends AnimationFrameCallbackProvider {
        public final Runnable b;
        public final Handler c;
        public long d;

        /* renamed from: androidx.dynamicanimation.animation.AnimationHandler$FrameCallbackProvider14$1  reason: invalid class name */
        class AnonymousClass1 implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ FrameCallbackProvider14 f1182a;

            public void run() {
                this.f1182a.d = SystemClock.uptimeMillis();
                this.f1182a.f1181a.a();
            }
        }

        public void a() {
            this.c.postDelayed(this.b, Math.max(10 - (SystemClock.uptimeMillis() - this.d), 0));
        }
    }

    @RequiresApi
    public static class FrameCallbackProvider16 extends AnimationFrameCallbackProvider {
        public final Choreographer b = Choreographer.getInstance();
        public final Choreographer.FrameCallback c = new Choreographer.FrameCallback() {
            public void doFrame(long j) {
                FrameCallbackProvider16.this.f1181a.a();
            }
        };

        public FrameCallbackProvider16(AnimationCallbackDispatcher animationCallbackDispatcher) {
            super(animationCallbackDispatcher);
        }

        public void a() {
            this.b.postFrameCallback(this.c);
        }
    }

    public static AnimationHandler d() {
        ThreadLocal threadLocal = g;
        if (threadLocal.get() == null) {
            threadLocal.set(new AnimationHandler());
        }
        return (AnimationHandler) threadLocal.get();
    }

    public void a(AnimationFrameCallback animationFrameCallback, long j) {
        if (this.b.size() == 0) {
            e().a();
        }
        if (!this.b.contains(animationFrameCallback)) {
            this.b.add(animationFrameCallback);
        }
        if (j > 0) {
            this.f1179a.put(animationFrameCallback, Long.valueOf(SystemClock.uptimeMillis() + j));
        }
    }

    public final void b() {
        if (this.f) {
            for (int size = this.b.size() - 1; size >= 0; size--) {
                if (this.b.get(size) == null) {
                    this.b.remove(size);
                }
            }
            this.f = false;
        }
    }

    public void c(long j) {
        long uptimeMillis = SystemClock.uptimeMillis();
        for (int i = 0; i < this.b.size(); i++) {
            AnimationFrameCallback animationFrameCallback = (AnimationFrameCallback) this.b.get(i);
            if (animationFrameCallback != null && f(animationFrameCallback, uptimeMillis)) {
                animationFrameCallback.a(j);
            }
        }
        b();
    }

    public AnimationFrameCallbackProvider e() {
        if (this.d == null) {
            this.d = new FrameCallbackProvider16(this.c);
        }
        return this.d;
    }

    public final boolean f(AnimationFrameCallback animationFrameCallback, long j) {
        Long l = (Long) this.f1179a.get(animationFrameCallback);
        if (l == null) {
            return true;
        }
        if (l.longValue() >= j) {
            return false;
        }
        this.f1179a.remove(animationFrameCallback);
        return true;
    }

    public void g(AnimationFrameCallback animationFrameCallback) {
        this.f1179a.remove(animationFrameCallback);
        int indexOf = this.b.indexOf(animationFrameCallback);
        if (indexOf >= 0) {
            this.b.set(indexOf, (Object) null);
            this.f = true;
        }
    }
}
