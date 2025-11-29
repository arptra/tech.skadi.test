package com.bumptech.glide.manager;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Handler;
import android.os.Message;
import androidx.collection.ArrayMap;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.resource.bitmap.HardwareConfigState;
import com.bumptech.glide.util.Util;

public class RequestManagerRetriever implements Handler.Callback {
    public static final RequestManagerFactory f = new RequestManagerFactory() {
        public RequestManager a(Glide glide, Lifecycle lifecycle, RequestManagerTreeNode requestManagerTreeNode, Context context) {
            return new RequestManager(glide, lifecycle, requestManagerTreeNode, context);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public volatile RequestManager f2682a;
    public final RequestManagerFactory b;
    public final ArrayMap c = new ArrayMap();
    public final FrameWaiter d;
    public final LifecycleRequestManagerRetriever e;

    public interface RequestManagerFactory {
        RequestManager a(Glide glide, Lifecycle lifecycle, RequestManagerTreeNode requestManagerTreeNode, Context context);
    }

    public RequestManagerRetriever(RequestManagerFactory requestManagerFactory) {
        requestManagerFactory = requestManagerFactory == null ? f : requestManagerFactory;
        this.b = requestManagerFactory;
        this.e = new LifecycleRequestManagerRetriever(requestManagerFactory);
        this.d = b();
    }

    public static void a(Activity activity) {
        if (activity.isDestroyed()) {
            throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
        }
    }

    public static FrameWaiter b() {
        return (!HardwareConfigState.f || !HardwareConfigState.e) ? new DoNothingFirstFrameWaiter() : new FirstFrameWaiter();
    }

    public static Activity c(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return c(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    public static boolean g(Context context) {
        Activity c2 = c(context);
        return c2 == null || !c2.isFinishing();
    }

    public RequestManager d(Context context) {
        if (context != null) {
            if (Util.t() && !(context instanceof Application)) {
                if (context instanceof FragmentActivity) {
                    return e((FragmentActivity) context);
                }
                if (context instanceof ContextWrapper) {
                    ContextWrapper contextWrapper = (ContextWrapper) context;
                    if (contextWrapper.getBaseContext().getApplicationContext() != null) {
                        return d(contextWrapper.getBaseContext());
                    }
                }
            }
            return f(context);
        }
        throw new IllegalArgumentException("You cannot start a load on a null Context");
    }

    public RequestManager e(FragmentActivity fragmentActivity) {
        if (Util.s()) {
            return d(fragmentActivity.getApplicationContext());
        }
        a(fragmentActivity);
        this.d.a(fragmentActivity);
        boolean g = g(fragmentActivity);
        return this.e.b(fragmentActivity, Glide.c(fragmentActivity.getApplicationContext()), fragmentActivity.getLifecycle(), fragmentActivity.getSupportFragmentManager(), g);
    }

    public final RequestManager f(Context context) {
        if (this.f2682a == null) {
            synchronized (this) {
                try {
                    if (this.f2682a == null) {
                        this.f2682a = this.b.a(Glide.c(context.getApplicationContext()), new ApplicationLifecycle(), new EmptyRequestManagerTreeNode(), context.getApplicationContext());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.f2682a;
    }

    public boolean handleMessage(Message message) {
        return false;
    }
}
