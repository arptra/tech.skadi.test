package com.bumptech.glide.manager;

import android.app.Activity;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.resource.bitmap.HardwareConfigState;
import com.bumptech.glide.util.Util;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

@RequiresApi
final class FirstFrameWaiter implements FrameWaiter {

    /* renamed from: a  reason: collision with root package name */
    public final Set f2675a = Collections.newSetFromMap(new WeakHashMap());
    public volatile boolean b;

    public static void b(View view, ViewTreeObserver.OnDrawListener onDrawListener) {
        view.getViewTreeObserver().removeOnDrawListener(onDrawListener);
    }

    public void a(Activity activity) {
        if (!this.b && this.f2675a.add(activity)) {
            final View decorView = activity.getWindow().getDecorView();
            decorView.getViewTreeObserver().addOnDrawListener(new ViewTreeObserver.OnDrawListener() {
                public void onDraw() {
                    Util.w(new Runnable() {
                        public void run() {
                            HardwareConfigState.b().h();
                            FirstFrameWaiter.this.b = true;
                            FirstFrameWaiter.b(decorView, this);
                            FirstFrameWaiter.this.f2675a.clear();
                        }
                    });
                }
            });
        }
    }
}
