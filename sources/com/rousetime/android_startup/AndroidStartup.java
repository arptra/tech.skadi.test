package com.rousetime.android_startup;

import com.rousetime.android_startup.dispatcher.Dispatcher;
import com.rousetime.android_startup.executor.ExecutorManager;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import kotlin.Lazy;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0003\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ#\u0010\f\u001a\u0016\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00020\u000b\u0018\u00010\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\nH\u0016¢\u0006\u0004\b\u000f\u0010\rJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J%\u0010\u0016\u001a\u00020\u00032\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eR\u001b\u0010$\u001a\u00020\u001f8BX\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R!\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001b0%8BX\u0002¢\u0006\f\n\u0004\b\u0016\u0010!\u001a\u0004\b&\u0010\r¨\u0006("}, d2 = {"Lcom/rousetime/android_startup/AndroidStartup;", "T", "Lcom/rousetime/android_startup/Startup;", "", "j", "()V", "d", "Ljava/util/concurrent/Executor;", "e", "()Ljava/util/concurrent/Executor;", "", "Ljava/lang/Class;", "dependencies", "()Ljava/util/List;", "", "f", "", "k", "()I", "startup", "", "result", "b", "(Lcom/rousetime/android_startup/Startup;Ljava/lang/Object;)V", "", "i", "()Z", "Lcom/rousetime/android_startup/dispatcher/Dispatcher;", "dispatcher", "c", "(Lcom/rousetime/android_startup/dispatcher/Dispatcher;)V", "Ljava/util/concurrent/CountDownLatch;", "a", "Lkotlin/Lazy;", "m", "()Ljava/util/concurrent/CountDownLatch;", "mWaitCountDown", "", "l", "mObservers", "android-startup_release"}, k = 1, mv = {1, 4, 0})
public abstract class AndroidStartup<T> implements Startup<T> {

    /* renamed from: a  reason: collision with root package name */
    public final Lazy f9817a;
    public final Lazy b;

    public void b(Startup startup, Object obj) {
    }

    public void c(Dispatcher dispatcher) {
        l().add(dispatcher);
    }

    public void d() {
        m().countDown();
    }

    public List dependencies() {
        return null;
    }

    public Executor e() {
        return ExecutorManager.i.a().b();
    }

    public List f() {
        return null;
    }

    public boolean i() {
        return false;
    }

    public void j() {
        try {
            m().await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int k() {
        List f = f();
        if (f == null || f.isEmpty()) {
            List dependencies = dependencies();
            if (dependencies != null) {
                return dependencies.size();
            }
            return 0;
        }
        List f2 = f();
        if (f2 != null) {
            return f2.size();
        }
        return 0;
    }

    public final List l() {
        return (List) this.b.getValue();
    }

    public final CountDownLatch m() {
        return (CountDownLatch) this.f9817a.getValue();
    }
}
