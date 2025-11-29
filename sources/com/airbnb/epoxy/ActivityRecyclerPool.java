package com.airbnb.epoxy;

import android.content.Context;
import android.content.ContextWrapper;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0010*\u00020\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\u00138\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/airbnb/epoxy/ActivityRecyclerPool;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Lkotlin/Function0;", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "poolFactory", "Lcom/airbnb/epoxy/PoolReference;", "b", "(Landroid/content/Context;Lkotlin/jvm/functions/Function0;)Lcom/airbnb/epoxy/PoolReference;", "pool", "", "a", "(Lcom/airbnb/epoxy/PoolReference;)V", "Landroidx/lifecycle/Lifecycle;", "c", "(Landroid/content/Context;)Landroidx/lifecycle/Lifecycle;", "Ljava/util/ArrayList;", "Ljava/util/ArrayList;", "pools", "epoxy-adapter_release"}, k = 1, mv = {1, 8, 0})
public final class ActivityRecyclerPool {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f2265a = new ArrayList(5);

    public final void a(PoolReference poolReference) {
        Intrinsics.checkNotNullParameter(poolReference, "pool");
        if (ActivityRecyclerPoolKt.a(poolReference.b())) {
            poolReference.c().clear();
            this.f2265a.remove(poolReference);
        }
    }

    public final PoolReference b(Context context, Function0 function0) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(function0, "poolFactory");
        Iterator it = this.f2265a.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "pools.iterator()");
        PoolReference poolReference = null;
        while (it.hasNext()) {
            Object next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "iterator.next()");
            PoolReference poolReference2 = (PoolReference) next;
            if (poolReference2.b() == context) {
                if (poolReference == null) {
                    poolReference = poolReference2;
                } else {
                    throw new IllegalStateException("A pool was already found");
                }
            } else if (ActivityRecyclerPoolKt.a(poolReference2.b())) {
                poolReference2.c().clear();
                it.remove();
            }
        }
        if (poolReference == null) {
            poolReference = new PoolReference(context, (RecyclerView.RecycledViewPool) function0.invoke(), this);
            Lifecycle c = c(context);
            if (c != null) {
                c.a(poolReference);
            }
            this.f2265a.add(poolReference);
        }
        return poolReference;
    }

    public final Lifecycle c(Context context) {
        if (context instanceof LifecycleOwner) {
            return ((LifecycleOwner) context).getLifecycle();
        }
        if (!(context instanceof ContextWrapper)) {
            return null;
        }
        Context baseContext = ((ContextWrapper) context).getBaseContext();
        Intrinsics.checkNotNullExpressionValue(baseContext, "baseContext");
        return c(baseContext);
    }
}
