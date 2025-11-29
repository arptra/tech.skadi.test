package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.transition.Transition;

public final class PreloadTarget<Z> extends CustomTarget<Z> {
    public static final Handler e = new Handler(Looper.getMainLooper(), new Handler.Callback() {
        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            ((PreloadTarget) message.obj).b();
            return true;
        }
    });
    public final RequestManager d;

    public void b() {
        this.d.l(this);
    }

    public void d(Drawable drawable) {
    }

    public void e(Object obj, Transition transition) {
        Request c = c();
        if (c != null && c.f()) {
            e.obtainMessage(1, this).sendToTarget();
        }
    }
}
