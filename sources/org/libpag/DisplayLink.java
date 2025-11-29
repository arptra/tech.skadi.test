package org.libpag;

import android.animation.ValueAnimator;
import android.os.Handler;
import android.os.Looper;

class DisplayLink implements ValueAnimator.AnimatorUpdateListener {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public ValueAnimator f3412a;
    private Handler b = new Handler(Looper.getMainLooper());
    private long nativeContext = 0;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            DisplayLink.this.f3412a.start();
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            DisplayLink.this.f3412a.cancel();
        }
    }

    private DisplayLink() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.f3412a = ofFloat;
        ofFloat.setDuration(1000);
        this.f3412a.addUpdateListener(this);
        this.f3412a.setRepeatCount(-1);
    }

    public static DisplayLink Create(long j) {
        DisplayLink displayLink = new DisplayLink();
        displayLink.nativeContext = j;
        return displayLink;
    }

    private native void onUpdate(long j);

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        onUpdate(this.nativeContext);
    }

    public void start() {
        this.b.post(new a());
    }

    public void stop() {
        this.b.post(new b());
    }
}
