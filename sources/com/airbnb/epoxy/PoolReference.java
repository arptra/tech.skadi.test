package com.airbnb.epoxy;

import android.content.Context;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0007¢\u0006\u0004\b\r\u0010\fR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u00138\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0014R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u00028F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/airbnb/epoxy/PoolReference;", "Landroidx/lifecycle/LifecycleObserver;", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "viewPool", "Lcom/airbnb/epoxy/ActivityRecyclerPool;", "parent", "<init>", "(Landroid/content/Context;Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;Lcom/airbnb/epoxy/ActivityRecyclerPool;)V", "", "a", "()V", "onContextDestroyed", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "c", "()Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "b", "Lcom/airbnb/epoxy/ActivityRecyclerPool;", "Ljava/lang/ref/WeakReference;", "Ljava/lang/ref/WeakReference;", "contextReference", "()Landroid/content/Context;", "epoxy-adapter_release"}, k = 1, mv = {1, 8, 0})
public final class PoolReference implements LifecycleObserver {

    /* renamed from: a  reason: collision with root package name */
    public final RecyclerView.RecycledViewPool f2313a;
    public final ActivityRecyclerPool b;
    public final WeakReference c;

    public PoolReference(Context context, RecyclerView.RecycledViewPool recycledViewPool, ActivityRecyclerPool activityRecyclerPool) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(recycledViewPool, "viewPool");
        Intrinsics.checkNotNullParameter(activityRecyclerPool, "parent");
        this.f2313a = recycledViewPool;
        this.b = activityRecyclerPool;
        this.c = new WeakReference(context);
    }

    public final void a() {
        this.b.a(this);
    }

    public final Context b() {
        return (Context) this.c.get();
    }

    public final RecyclerView.RecycledViewPool c() {
        return this.f2313a;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onContextDestroyed() {
        a();
    }
}
