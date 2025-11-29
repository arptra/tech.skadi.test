package androidx.core.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.honey.account.q.k;
import com.honey.account.q.l;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class MenuHostHelper {

    /* renamed from: a  reason: collision with root package name */
    public final Runnable f872a;
    public final CopyOnWriteArrayList b = new CopyOnWriteArrayList();
    public final Map c = new HashMap();

    public static class LifecycleContainer {

        /* renamed from: a  reason: collision with root package name */
        public final Lifecycle f873a;
        public LifecycleEventObserver b;

        public LifecycleContainer(Lifecycle lifecycle, LifecycleEventObserver lifecycleEventObserver) {
            this.f873a = lifecycle;
            this.b = lifecycleEventObserver;
            lifecycle.a(lifecycleEventObserver);
        }

        public void a() {
            this.f873a.d(this.b);
            this.b = null;
        }
    }

    public MenuHostHelper(Runnable runnable) {
        this.f872a = runnable;
    }

    public void c(MenuProvider menuProvider) {
        this.b.add(menuProvider);
        this.f872a.run();
    }

    public void d(MenuProvider menuProvider, LifecycleOwner lifecycleOwner) {
        c(menuProvider);
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        LifecycleContainer lifecycleContainer = (LifecycleContainer) this.c.remove(menuProvider);
        if (lifecycleContainer != null) {
            lifecycleContainer.a();
        }
        this.c.put(menuProvider, new LifecycleContainer(lifecycle, new l(this, menuProvider)));
    }

    public void e(MenuProvider menuProvider, LifecycleOwner lifecycleOwner, Lifecycle.State state) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        LifecycleContainer lifecycleContainer = (LifecycleContainer) this.c.remove(menuProvider);
        if (lifecycleContainer != null) {
            lifecycleContainer.a();
        }
        this.c.put(menuProvider, new LifecycleContainer(lifecycle, new k(this, state, menuProvider)));
    }

    public final /* synthetic */ void f(MenuProvider menuProvider, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        if (event == Lifecycle.Event.ON_DESTROY) {
            l(menuProvider);
        }
    }

    public final /* synthetic */ void g(Lifecycle.State state, MenuProvider menuProvider, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        if (event == Lifecycle.Event.upTo(state)) {
            c(menuProvider);
        } else if (event == Lifecycle.Event.ON_DESTROY) {
            l(menuProvider);
        } else if (event == Lifecycle.Event.downFrom(state)) {
            this.b.remove(menuProvider);
            this.f872a.run();
        }
    }

    public void h(Menu menu, MenuInflater menuInflater) {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ((MenuProvider) it.next()).a(menu, menuInflater);
        }
    }

    public void i(Menu menu) {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ((MenuProvider) it.next()).b(menu);
        }
    }

    public boolean j(MenuItem menuItem) {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            if (((MenuProvider) it.next()).d(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void k(Menu menu) {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ((MenuProvider) it.next()).c(menu);
        }
    }

    public void l(MenuProvider menuProvider) {
        this.b.remove(menuProvider);
        LifecycleContainer lifecycleContainer = (LifecycleContainer) this.c.remove(menuProvider);
        if (lifecycleContainer != null) {
            lifecycleContainer.a();
        }
        this.f872a.run();
    }
}
