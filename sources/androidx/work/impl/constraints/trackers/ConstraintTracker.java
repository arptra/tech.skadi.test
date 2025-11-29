package androidx.work.impl.constraints.trackers;

import android.content.Context;
import androidx.annotation.RestrictTo;
import androidx.work.Logger;
import androidx.work.impl.constraints.ConstraintListener;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.honey.account.n0.a;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nConstraintTracker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConstraintTracker.kt\nandroidx/work/impl/constraints/trackers/ConstraintTracker\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,124:1\n1855#2,2:125\n*S KotlinDebug\n*F\n+ 1 ConstraintTracker.kt\nandroidx/work/impl/constraints/trackers/ConstraintTracker\n*L\n96#1:125,2\n*E\n"})
@RestrictTo
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\t\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0019\b\u0004\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\f\u001a\u00020\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\t¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u000e\u001a\u00020\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\t¢\u0006\u0004\b\u000e\u0010\rJ\u000f\u0010\u000f\u001a\u00028\u0000H&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000bH&¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u000bH&¢\u0006\u0004\b\u0013\u0010\u0012R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001a\u0010\u001a\u001a\u00020\u00038\u0004X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u001bR \u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t0\u001d8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u001eR\u0018\u0010 \u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u001bR$\u0010%\u001a\u00028\u00002\u0006\u0010!\u001a\u00028\u00008F@FX\u000e¢\u0006\f\u001a\u0004\b\"\u0010\u0010\"\u0004\b#\u0010$¨\u0006&"}, d2 = {"Landroidx/work/impl/constraints/trackers/ConstraintTracker;", "T", "", "Landroid/content/Context;", "context", "Landroidx/work/impl/utils/taskexecutor/TaskExecutor;", "taskExecutor", "<init>", "(Landroid/content/Context;Landroidx/work/impl/utils/taskexecutor/TaskExecutor;)V", "Landroidx/work/impl/constraints/ConstraintListener;", "listener", "", "c", "(Landroidx/work/impl/constraints/ConstraintListener;)V", "f", "e", "()Ljava/lang/Object;", "h", "()V", "i", "a", "Landroidx/work/impl/utils/taskexecutor/TaskExecutor;", "b", "Landroid/content/Context;", "d", "()Landroid/content/Context;", "appContext", "Ljava/lang/Object;", "lock", "Ljava/util/LinkedHashSet;", "Ljava/util/LinkedHashSet;", "listeners", "currentState", "newState", "getState", "g", "(Ljava/lang/Object;)V", "state", "work-runtime_release"}, k = 1, mv = {1, 8, 0})
public abstract class ConstraintTracker<T> {

    /* renamed from: a  reason: collision with root package name */
    public final TaskExecutor f2148a;
    public final Context b;
    public final Object c = new Object();
    public final LinkedHashSet d = new LinkedHashSet();
    public Object e;

    public ConstraintTracker(Context context, TaskExecutor taskExecutor) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(taskExecutor, "taskExecutor");
        this.f2148a = taskExecutor;
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
        this.b = applicationContext;
    }

    public static final void b(List list, ConstraintTracker constraintTracker) {
        Intrinsics.checkNotNullParameter(list, "$listenersList");
        Intrinsics.checkNotNullParameter(constraintTracker, "this$0");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((ConstraintListener) it.next()).a(constraintTracker.e);
        }
    }

    public final void c(ConstraintListener constraintListener) {
        Intrinsics.checkNotNullParameter(constraintListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        synchronized (this.c) {
            try {
                if (this.d.add(constraintListener)) {
                    if (this.d.size() == 1) {
                        this.e = e();
                        Logger e2 = Logger.e();
                        String a2 = ConstraintTrackerKt.f2149a;
                        e2.a(a2, getClass().getSimpleName() + ": initial state = " + this.e);
                        h();
                    }
                    constraintListener.a(this.e);
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final Context d() {
        return this.b;
    }

    public abstract Object e();

    public final void f(ConstraintListener constraintListener) {
        Intrinsics.checkNotNullParameter(constraintListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        synchronized (this.c) {
            try {
                if (this.d.remove(constraintListener) && this.d.isEmpty()) {
                    i();
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void g(Object obj) {
        synchronized (this.c) {
            Object obj2 = this.e;
            if (obj2 == null || !Intrinsics.areEqual(obj2, obj)) {
                this.e = obj;
                this.f2148a.c().execute(new a(CollectionsKt.toList(this.d), this));
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public abstract void h();

    public abstract void i();
}
