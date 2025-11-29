package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.upuphone.starrynet.strategy.protocol.ProtocolVersions;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0001,B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\r\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\b¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\b¢\u0006\u0004\b\u0014\u0010\u0013J'\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0011\u001a\u00020\b¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0011\u001a\u00020\b¢\u0006\u0004\b\u0019\u0010\u0018J'\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0011\u001a\u00020\b¢\u0006\u0004\b\u001a\u0010\u0018J/\u0010\u001d\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0011\u001a\u00020\b¢\u0006\u0004\b\u001d\u0010\u001eJ\u001d\u0010\u001f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\b¢\u0006\u0004\b\u001f\u0010\u0013J\u001d\u0010 \u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\b¢\u0006\u0004\b \u0010\u0013J\u001d\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\b¢\u0006\u0004\b\u0010\u0010\u0013J\u001d\u0010!\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\b¢\u0006\u0004\b!\u0010\u0013J%\u0010#\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\b¢\u0006\u0004\b#\u0010\u0018J\u001d\u0010$\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\b¢\u0006\u0004\b$\u0010\u0013J\u001d\u0010%\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\b¢\u0006\u0004\b%\u0010\u0013J\u001d\u0010&\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\b¢\u0006\u0004\b&\u0010\u0013R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010'R\u001a\u0010+\u001a\b\u0012\u0004\u0012\u00020)0(8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010*¨\u0006-"}, d2 = {"Landroidx/fragment/app/FragmentLifecycleCallbacksDispatcher;", "", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "<init>", "(Landroidx/fragment/app/FragmentManager;)V", "Landroidx/fragment/app/FragmentManager$FragmentLifecycleCallbacks;", "cb", "", "recursive", "", "o", "(Landroidx/fragment/app/FragmentManager$FragmentLifecycleCallbacks;Z)V", "p", "(Landroidx/fragment/app/FragmentManager$FragmentLifecycleCallbacks;)V", "Landroidx/fragment/app/Fragment;", "f", "onlyRecursive", "g", "(Landroidx/fragment/app/Fragment;Z)V", "b", "Landroid/os/Bundle;", "savedInstanceState", "h", "(Landroidx/fragment/app/Fragment;Landroid/os/Bundle;Z)V", "c", "a", "Landroid/view/View;", "v", "m", "(Landroidx/fragment/app/Fragment;Landroid/view/View;Landroid/os/Bundle;Z)V", "k", "i", "l", "outState", "j", "n", "d", "e", "Landroidx/fragment/app/FragmentManager;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Landroidx/fragment/app/FragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "lifecycleCallbacks", "FragmentLifecycleCallbacksHolder", "fragment_release"}, k = 1, mv = {1, 8, 0})
public final class FragmentLifecycleCallbacksDispatcher {

    /* renamed from: a  reason: collision with root package name */
    public final FragmentManager f1278a;
    public final CopyOnWriteArrayList b = new CopyOnWriteArrayList();

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\nR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r¨\u0006\u000e"}, d2 = {"Landroidx/fragment/app/FragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder;", "", "Landroidx/fragment/app/FragmentManager$FragmentLifecycleCallbacks;", "callback", "", "recursive", "<init>", "(Landroidx/fragment/app/FragmentManager$FragmentLifecycleCallbacks;Z)V", "a", "Landroidx/fragment/app/FragmentManager$FragmentLifecycleCallbacks;", "()Landroidx/fragment/app/FragmentManager$FragmentLifecycleCallbacks;", "b", "Z", "()Z", "fragment_release"}, k = 1, mv = {1, 8, 0})
    public static final class FragmentLifecycleCallbacksHolder {

        /* renamed from: a  reason: collision with root package name */
        public final FragmentManager.FragmentLifecycleCallbacks f1279a;
        public final boolean b;

        public FragmentLifecycleCallbacksHolder(FragmentManager.FragmentLifecycleCallbacks fragmentLifecycleCallbacks, boolean z) {
            Intrinsics.checkNotNullParameter(fragmentLifecycleCallbacks, "callback");
            this.f1279a = fragmentLifecycleCallbacks;
            this.b = z;
        }

        public final FragmentManager.FragmentLifecycleCallbacks a() {
            return this.f1279a;
        }

        public final boolean b() {
            return this.b;
        }
    }

    public FragmentLifecycleCallbacksDispatcher(FragmentManager fragmentManager) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        this.f1278a = fragmentManager;
    }

    public final void a(Fragment fragment, Bundle bundle, boolean z) {
        Intrinsics.checkNotNullParameter(fragment, "f");
        Fragment J0 = this.f1278a.J0();
        if (J0 != null) {
            FragmentManager parentFragmentManager = J0.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.I0().a(fragment, bundle, true);
        }
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder = (FragmentLifecycleCallbacksHolder) it.next();
            if (!z || fragmentLifecycleCallbacksHolder.b()) {
                fragmentLifecycleCallbacksHolder.a().a(this.f1278a, fragment, bundle);
            }
        }
    }

    public final void b(Fragment fragment, boolean z) {
        Intrinsics.checkNotNullParameter(fragment, "f");
        Context f = this.f1278a.G0().f();
        Fragment J0 = this.f1278a.J0();
        if (J0 != null) {
            FragmentManager parentFragmentManager = J0.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.I0().b(fragment, true);
        }
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder = (FragmentLifecycleCallbacksHolder) it.next();
            if (!z || fragmentLifecycleCallbacksHolder.b()) {
                fragmentLifecycleCallbacksHolder.a().b(this.f1278a, fragment, f);
            }
        }
    }

    public final void c(Fragment fragment, Bundle bundle, boolean z) {
        Intrinsics.checkNotNullParameter(fragment, "f");
        Fragment J0 = this.f1278a.J0();
        if (J0 != null) {
            FragmentManager parentFragmentManager = J0.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.I0().c(fragment, bundle, true);
        }
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder = (FragmentLifecycleCallbacksHolder) it.next();
            if (!z || fragmentLifecycleCallbacksHolder.b()) {
                fragmentLifecycleCallbacksHolder.a().c(this.f1278a, fragment, bundle);
            }
        }
    }

    public final void d(Fragment fragment, boolean z) {
        Intrinsics.checkNotNullParameter(fragment, "f");
        Fragment J0 = this.f1278a.J0();
        if (J0 != null) {
            FragmentManager parentFragmentManager = J0.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.I0().d(fragment, true);
        }
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder = (FragmentLifecycleCallbacksHolder) it.next();
            if (!z || fragmentLifecycleCallbacksHolder.b()) {
                fragmentLifecycleCallbacksHolder.a().d(this.f1278a, fragment);
            }
        }
    }

    public final void e(Fragment fragment, boolean z) {
        Intrinsics.checkNotNullParameter(fragment, "f");
        Fragment J0 = this.f1278a.J0();
        if (J0 != null) {
            FragmentManager parentFragmentManager = J0.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.I0().e(fragment, true);
        }
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder = (FragmentLifecycleCallbacksHolder) it.next();
            if (!z || fragmentLifecycleCallbacksHolder.b()) {
                fragmentLifecycleCallbacksHolder.a().e(this.f1278a, fragment);
            }
        }
    }

    public final void f(Fragment fragment, boolean z) {
        Intrinsics.checkNotNullParameter(fragment, "f");
        Fragment J0 = this.f1278a.J0();
        if (J0 != null) {
            FragmentManager parentFragmentManager = J0.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.I0().f(fragment, true);
        }
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder = (FragmentLifecycleCallbacksHolder) it.next();
            if (!z || fragmentLifecycleCallbacksHolder.b()) {
                fragmentLifecycleCallbacksHolder.a().f(this.f1278a, fragment);
            }
        }
    }

    public final void g(Fragment fragment, boolean z) {
        Intrinsics.checkNotNullParameter(fragment, "f");
        Context f = this.f1278a.G0().f();
        Fragment J0 = this.f1278a.J0();
        if (J0 != null) {
            FragmentManager parentFragmentManager = J0.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.I0().g(fragment, true);
        }
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder = (FragmentLifecycleCallbacksHolder) it.next();
            if (!z || fragmentLifecycleCallbacksHolder.b()) {
                fragmentLifecycleCallbacksHolder.a().g(this.f1278a, fragment, f);
            }
        }
    }

    public final void h(Fragment fragment, Bundle bundle, boolean z) {
        Intrinsics.checkNotNullParameter(fragment, "f");
        Fragment J0 = this.f1278a.J0();
        if (J0 != null) {
            FragmentManager parentFragmentManager = J0.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.I0().h(fragment, bundle, true);
        }
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder = (FragmentLifecycleCallbacksHolder) it.next();
            if (!z || fragmentLifecycleCallbacksHolder.b()) {
                fragmentLifecycleCallbacksHolder.a().h(this.f1278a, fragment, bundle);
            }
        }
    }

    public final void i(Fragment fragment, boolean z) {
        Intrinsics.checkNotNullParameter(fragment, "f");
        Fragment J0 = this.f1278a.J0();
        if (J0 != null) {
            FragmentManager parentFragmentManager = J0.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.I0().i(fragment, true);
        }
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder = (FragmentLifecycleCallbacksHolder) it.next();
            if (!z || fragmentLifecycleCallbacksHolder.b()) {
                fragmentLifecycleCallbacksHolder.a().i(this.f1278a, fragment);
            }
        }
    }

    public final void j(Fragment fragment, Bundle bundle, boolean z) {
        Intrinsics.checkNotNullParameter(fragment, "f");
        Intrinsics.checkNotNullParameter(bundle, "outState");
        Fragment J0 = this.f1278a.J0();
        if (J0 != null) {
            FragmentManager parentFragmentManager = J0.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.I0().j(fragment, bundle, true);
        }
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder = (FragmentLifecycleCallbacksHolder) it.next();
            if (!z || fragmentLifecycleCallbacksHolder.b()) {
                fragmentLifecycleCallbacksHolder.a().j(this.f1278a, fragment, bundle);
            }
        }
    }

    public final void k(Fragment fragment, boolean z) {
        Intrinsics.checkNotNullParameter(fragment, "f");
        Fragment J0 = this.f1278a.J0();
        if (J0 != null) {
            FragmentManager parentFragmentManager = J0.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.I0().k(fragment, true);
        }
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder = (FragmentLifecycleCallbacksHolder) it.next();
            if (!z || fragmentLifecycleCallbacksHolder.b()) {
                fragmentLifecycleCallbacksHolder.a().k(this.f1278a, fragment);
            }
        }
    }

    public final void l(Fragment fragment, boolean z) {
        Intrinsics.checkNotNullParameter(fragment, "f");
        Fragment J0 = this.f1278a.J0();
        if (J0 != null) {
            FragmentManager parentFragmentManager = J0.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.I0().l(fragment, true);
        }
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder = (FragmentLifecycleCallbacksHolder) it.next();
            if (!z || fragmentLifecycleCallbacksHolder.b()) {
                fragmentLifecycleCallbacksHolder.a().l(this.f1278a, fragment);
            }
        }
    }

    public final void m(Fragment fragment, View view, Bundle bundle, boolean z) {
        Intrinsics.checkNotNullParameter(fragment, "f");
        Intrinsics.checkNotNullParameter(view, ProtocolVersions.PROTOCOL_KEY_CONNECTION_VERSION);
        Fragment J0 = this.f1278a.J0();
        if (J0 != null) {
            FragmentManager parentFragmentManager = J0.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.I0().m(fragment, view, bundle, true);
        }
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder = (FragmentLifecycleCallbacksHolder) it.next();
            if (!z || fragmentLifecycleCallbacksHolder.b()) {
                fragmentLifecycleCallbacksHolder.a().m(this.f1278a, fragment, view, bundle);
            }
        }
    }

    public final void n(Fragment fragment, boolean z) {
        Intrinsics.checkNotNullParameter(fragment, "f");
        Fragment J0 = this.f1278a.J0();
        if (J0 != null) {
            FragmentManager parentFragmentManager = J0.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.I0().n(fragment, true);
        }
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder = (FragmentLifecycleCallbacksHolder) it.next();
            if (!z || fragmentLifecycleCallbacksHolder.b()) {
                fragmentLifecycleCallbacksHolder.a().n(this.f1278a, fragment);
            }
        }
    }

    public final void o(FragmentManager.FragmentLifecycleCallbacks fragmentLifecycleCallbacks, boolean z) {
        Intrinsics.checkNotNullParameter(fragmentLifecycleCallbacks, "cb");
        this.b.add(new FragmentLifecycleCallbacksHolder(fragmentLifecycleCallbacks, z));
    }

    public final void p(FragmentManager.FragmentLifecycleCallbacks fragmentLifecycleCallbacks) {
        Intrinsics.checkNotNullParameter(fragmentLifecycleCallbacks, "cb");
        synchronized (this.b) {
            try {
                int size = this.b.size();
                int i = 0;
                while (true) {
                    if (i >= size) {
                        break;
                    } else if (((FragmentLifecycleCallbacksHolder) this.b.get(i)).a() == fragmentLifecycleCallbacks) {
                        this.b.remove(i);
                        break;
                    } else {
                        i++;
                    }
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
