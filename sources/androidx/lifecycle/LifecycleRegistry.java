package androidx.lifecycle;

import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.arch.core.internal.FastSafeIterableMap;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.lifecycle.Lifecycle;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0016\u0018\u0000 ;2\u00020\u0001:\u0002>?B\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0012\u0010\u0011J\u0017\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u001c\u0010\u0016J\u0017\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001e\u0010\bJ\u0017\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001f\u0010\bJ\u000f\u0010 \u001a\u00020\u000bH\u0002¢\u0006\u0004\b \u0010\u001aJ\u0017\u0010#\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020!H\u0003¢\u0006\u0004\b#\u0010$R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\"\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020(0'8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010\u001b\u001a\u00020\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010,R\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00020-8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010.R\u0016\u00101\u001a\u00020/8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u00100R\u0016\u00102\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b#\u0010&R\u0016\u00103\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010&R&\u00107\u001a\u0012\u0012\u0004\u0012\u00020\u001304j\b\u0012\u0004\u0012\u00020\u0013`58\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\f\u00106R$\u0010:\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u00138V@VX\u000e¢\u0006\f\u001a\u0004\b%\u00108\"\u0004\b9\u0010\u0016R\u0014\u0010=\u001a\u00020\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b;\u0010<¨\u0006@"}, d2 = {"Landroidx/lifecycle/LifecycleRegistry;", "Landroidx/lifecycle/Lifecycle;", "Landroidx/lifecycle/LifecycleOwner;", "provider", "", "enforceMainThread", "<init>", "(Landroidx/lifecycle/LifecycleOwner;Z)V", "(Landroidx/lifecycle/LifecycleOwner;)V", "Landroidx/lifecycle/Lifecycle$Event;", "event", "", "i", "(Landroidx/lifecycle/Lifecycle$Event;)V", "Landroidx/lifecycle/LifecycleObserver;", "observer", "a", "(Landroidx/lifecycle/LifecycleObserver;)V", "d", "Landroidx/lifecycle/Lifecycle$State;", "next", "k", "(Landroidx/lifecycle/Lifecycle$State;)V", "f", "(Landroidx/lifecycle/LifecycleObserver;)Landroidx/lifecycle/Lifecycle$State;", "l", "()V", "state", "m", "lifecycleOwner", "h", "e", "o", "", "methodName", "g", "(Ljava/lang/String;)V", "b", "Z", "Landroidx/arch/core/internal/FastSafeIterableMap;", "Landroidx/lifecycle/LifecycleRegistry$ObserverWithState;", "c", "Landroidx/arch/core/internal/FastSafeIterableMap;", "observerMap", "Landroidx/lifecycle/Lifecycle$State;", "Ljava/lang/ref/WeakReference;", "Ljava/lang/ref/WeakReference;", "", "I", "addingObserverCounter", "handlingEvent", "newEventOccurred", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "parentStates", "()Landroidx/lifecycle/Lifecycle$State;", "n", "currentState", "j", "()Z", "isSynced", "Companion", "ObserverWithState", "lifecycle-runtime_release"}, k = 1, mv = {1, 8, 0})
public class LifecycleRegistry extends Lifecycle {
    public static final Companion j = new Companion((DefaultConstructorMarker) null);
    public final boolean b;
    public FastSafeIterableMap c;
    public Lifecycle.State d;
    public final WeakReference e;
    public int f;
    public boolean g;
    public boolean h;
    public ArrayList i;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0001¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/lifecycle/LifecycleRegistry$Companion;", "", "<init>", "()V", "Landroidx/lifecycle/Lifecycle$State;", "state1", "state2", "a", "(Landroidx/lifecycle/Lifecycle$State;Landroidx/lifecycle/Lifecycle$State;)Landroidx/lifecycle/Lifecycle$State;", "lifecycle-runtime_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Lifecycle.State a(Lifecycle.State state, Lifecycle.State state2) {
            Intrinsics.checkNotNullParameter(state, "state1");
            return (state2 == null || state2.compareTo(state) >= 0) ? state : state2;
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\r\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eR\"\u0010\u0014\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u001b\u001a\u00020\u00158\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, d2 = {"Landroidx/lifecycle/LifecycleRegistry$ObserverWithState;", "", "Landroidx/lifecycle/LifecycleObserver;", "observer", "Landroidx/lifecycle/Lifecycle$State;", "initialState", "<init>", "(Landroidx/lifecycle/LifecycleObserver;Landroidx/lifecycle/Lifecycle$State;)V", "Landroidx/lifecycle/LifecycleOwner;", "owner", "Landroidx/lifecycle/Lifecycle$Event;", "event", "", "a", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Lifecycle$Event;)V", "Landroidx/lifecycle/Lifecycle$State;", "b", "()Landroidx/lifecycle/Lifecycle$State;", "setState", "(Landroidx/lifecycle/Lifecycle$State;)V", "state", "Landroidx/lifecycle/LifecycleEventObserver;", "Landroidx/lifecycle/LifecycleEventObserver;", "getLifecycleObserver", "()Landroidx/lifecycle/LifecycleEventObserver;", "setLifecycleObserver", "(Landroidx/lifecycle/LifecycleEventObserver;)V", "lifecycleObserver", "lifecycle-runtime_release"}, k = 1, mv = {1, 8, 0})
    public static final class ObserverWithState {

        /* renamed from: a  reason: collision with root package name */
        public Lifecycle.State f1363a;
        public LifecycleEventObserver b;

        public ObserverWithState(LifecycleObserver lifecycleObserver, Lifecycle.State state) {
            Intrinsics.checkNotNullParameter(state, "initialState");
            Intrinsics.checkNotNull(lifecycleObserver);
            this.b = Lifecycling.f(lifecycleObserver);
            this.f1363a = state;
        }

        public final void a(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
            Intrinsics.checkNotNullParameter(event, "event");
            Lifecycle.State targetState = event.getTargetState();
            this.f1363a = LifecycleRegistry.j.a(this.f1363a, targetState);
            LifecycleEventObserver lifecycleEventObserver = this.b;
            Intrinsics.checkNotNull(lifecycleOwner);
            lifecycleEventObserver.onStateChanged(lifecycleOwner, event);
            this.f1363a = targetState;
        }

        public final Lifecycle.State b() {
            return this.f1363a;
        }
    }

    public LifecycleRegistry(LifecycleOwner lifecycleOwner, boolean z) {
        this.b = z;
        this.c = new FastSafeIterableMap();
        this.d = Lifecycle.State.INITIALIZED;
        this.i = new ArrayList();
        this.e = new WeakReference(lifecycleOwner);
    }

    public void a(LifecycleObserver lifecycleObserver) {
        LifecycleOwner lifecycleOwner;
        Intrinsics.checkNotNullParameter(lifecycleObserver, "observer");
        g("addObserver");
        Lifecycle.State state = this.d;
        Lifecycle.State state2 = Lifecycle.State.DESTROYED;
        if (state != state2) {
            state2 = Lifecycle.State.INITIALIZED;
        }
        ObserverWithState observerWithState = new ObserverWithState(lifecycleObserver, state2);
        if (((ObserverWithState) this.c.f(lifecycleObserver, observerWithState)) == null && (lifecycleOwner = (LifecycleOwner) this.e.get()) != null) {
            boolean z = this.f != 0 || this.g;
            Lifecycle.State f2 = f(lifecycleObserver);
            this.f++;
            while (observerWithState.b().compareTo(f2) < 0 && this.c.contains(lifecycleObserver)) {
                m(observerWithState.b());
                Lifecycle.Event c2 = Lifecycle.Event.Companion.c(observerWithState.b());
                if (c2 != null) {
                    observerWithState.a(lifecycleOwner, c2);
                    l();
                    f2 = f(lifecycleObserver);
                } else {
                    throw new IllegalStateException("no event up from " + observerWithState.b());
                }
            }
            if (!z) {
                o();
            }
            this.f--;
        }
    }

    public Lifecycle.State b() {
        return this.d;
    }

    public void d(LifecycleObserver lifecycleObserver) {
        Intrinsics.checkNotNullParameter(lifecycleObserver, "observer");
        g("removeObserver");
        this.c.h(lifecycleObserver);
    }

    public final void e(LifecycleOwner lifecycleOwner) {
        Iterator descendingIterator = this.c.descendingIterator();
        Intrinsics.checkNotNullExpressionValue(descendingIterator, "observerMap.descendingIterator()");
        while (descendingIterator.hasNext() && !this.h) {
            Map.Entry entry = (Map.Entry) descendingIterator.next();
            Intrinsics.checkNotNullExpressionValue(entry, "next()");
            LifecycleObserver lifecycleObserver = (LifecycleObserver) entry.getKey();
            ObserverWithState observerWithState = (ObserverWithState) entry.getValue();
            while (observerWithState.b().compareTo(this.d) > 0 && !this.h && this.c.contains(lifecycleObserver)) {
                Lifecycle.Event a2 = Lifecycle.Event.Companion.a(observerWithState.b());
                if (a2 != null) {
                    m(a2.getTargetState());
                    observerWithState.a(lifecycleOwner, a2);
                    l();
                } else {
                    throw new IllegalStateException("no event down from " + observerWithState.b());
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0009, code lost:
        r3 = (androidx.lifecycle.LifecycleRegistry.ObserverWithState) r3.getValue();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.lifecycle.Lifecycle.State f(androidx.lifecycle.LifecycleObserver r3) {
        /*
            r2 = this;
            androidx.arch.core.internal.FastSafeIterableMap r0 = r2.c
            java.util.Map$Entry r3 = r0.i(r3)
            r0 = 0
            if (r3 == 0) goto L_0x0016
            java.lang.Object r3 = r3.getValue()
            androidx.lifecycle.LifecycleRegistry$ObserverWithState r3 = (androidx.lifecycle.LifecycleRegistry.ObserverWithState) r3
            if (r3 == 0) goto L_0x0016
            androidx.lifecycle.Lifecycle$State r3 = r3.b()
            goto L_0x0017
        L_0x0016:
            r3 = r0
        L_0x0017:
            java.util.ArrayList r1 = r2.i
            boolean r1 = r1.isEmpty()
            r1 = r1 ^ 1
            if (r1 == 0) goto L_0x002f
            java.util.ArrayList r0 = r2.i
            int r1 = r0.size()
            int r1 = r1 + -1
            java.lang.Object r0 = r0.get(r1)
            androidx.lifecycle.Lifecycle$State r0 = (androidx.lifecycle.Lifecycle.State) r0
        L_0x002f:
            androidx.lifecycle.LifecycleRegistry$Companion r1 = j
            androidx.lifecycle.Lifecycle$State r2 = r2.d
            androidx.lifecycle.Lifecycle$State r2 = r1.a(r2, r3)
            androidx.lifecycle.Lifecycle$State r2 = r1.a(r2, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.LifecycleRegistry.f(androidx.lifecycle.LifecycleObserver):androidx.lifecycle.Lifecycle$State");
    }

    public final void g(String str) {
        if (this.b && !ArchTaskExecutor.h().c()) {
            throw new IllegalStateException(("Method " + str + " must be called on the main thread").toString());
        }
    }

    public final void h(LifecycleOwner lifecycleOwner) {
        SafeIterableMap.IteratorWithAdditions c2 = this.c.c();
        Intrinsics.checkNotNullExpressionValue(c2, "observerMap.iteratorWithAdditions()");
        while (c2.hasNext() && !this.h) {
            Map.Entry entry = (Map.Entry) c2.next();
            LifecycleObserver lifecycleObserver = (LifecycleObserver) entry.getKey();
            ObserverWithState observerWithState = (ObserverWithState) entry.getValue();
            while (observerWithState.b().compareTo(this.d) < 0 && !this.h && this.c.contains(lifecycleObserver)) {
                m(observerWithState.b());
                Lifecycle.Event c3 = Lifecycle.Event.Companion.c(observerWithState.b());
                if (c3 != null) {
                    observerWithState.a(lifecycleOwner, c3);
                    l();
                } else {
                    throw new IllegalStateException("no event up from " + observerWithState.b());
                }
            }
        }
    }

    public void i(Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(event, "event");
        g("handleLifecycleEvent");
        k(event.getTargetState());
    }

    public final boolean j() {
        if (this.c.size() == 0) {
            return true;
        }
        Map.Entry a2 = this.c.a();
        Intrinsics.checkNotNull(a2);
        Lifecycle.State b2 = ((ObserverWithState) a2.getValue()).b();
        Map.Entry d2 = this.c.d();
        Intrinsics.checkNotNull(d2);
        Lifecycle.State b3 = ((ObserverWithState) d2.getValue()).b();
        return b2 == b3 && this.d == b3;
    }

    public final void k(Lifecycle.State state) {
        Lifecycle.State state2 = this.d;
        if (state2 != state) {
            if (state2 == Lifecycle.State.INITIALIZED && state == Lifecycle.State.DESTROYED) {
                throw new IllegalStateException(("no event down from " + this.d + " in component " + this.e.get()).toString());
            }
            this.d = state;
            if (this.g || this.f != 0) {
                this.h = true;
                return;
            }
            this.g = true;
            o();
            this.g = false;
            if (this.d == Lifecycle.State.DESTROYED) {
                this.c = new FastSafeIterableMap();
            }
        }
    }

    public final void l() {
        ArrayList arrayList = this.i;
        arrayList.remove(arrayList.size() - 1);
    }

    public final void m(Lifecycle.State state) {
        this.i.add(state);
    }

    public void n(Lifecycle.State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        g("setCurrentState");
        k(state);
    }

    public final void o() {
        LifecycleOwner lifecycleOwner = (LifecycleOwner) this.e.get();
        if (lifecycleOwner != null) {
            while (!j()) {
                this.h = false;
                Lifecycle.State state = this.d;
                Map.Entry a2 = this.c.a();
                Intrinsics.checkNotNull(a2);
                if (state.compareTo(((ObserverWithState) a2.getValue()).b()) < 0) {
                    e(lifecycleOwner);
                }
                Map.Entry d2 = this.c.d();
                if (!this.h && d2 != null && this.d.compareTo(((ObserverWithState) d2.getValue()).b()) > 0) {
                    h(lifecycleOwner);
                }
            }
            this.h = false;
            return;
        }
        throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is already garbage collected. It is too late to change lifecycle state.");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public LifecycleRegistry(LifecycleOwner lifecycleOwner) {
        this(lifecycleOwner, true);
        Intrinsics.checkNotNullParameter(lifecycleOwner, "provider");
    }
}
