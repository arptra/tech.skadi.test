package com.bumptech.glide.load.engine;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class ResourceRecycler {

    /* renamed from: a  reason: collision with root package name */
    public boolean f2500a;
    public final Handler b = new Handler(Looper.getMainLooper(), new ResourceRecyclerCallback());

    public static final class ResourceRecyclerCallback implements Handler.Callback {
        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            ((Resource) message.obj).a();
            return true;
        }
    }

    public synchronized void a(Resource resource, boolean z) {
        try {
            if (!this.f2500a) {
                if (!z) {
                    this.f2500a = true;
                    resource.a();
                    this.f2500a = false;
                }
            }
            this.b.obtainMessage(1, resource).sendToTarget();
        } catch (Throwable th) {
            throw th;
        }
    }
}
