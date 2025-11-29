package androidx.navigation;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u0014\u0010\bJ\u0017\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0016\u0010\bR\u0014\u0010\u0019\u001a\u00020\u00178\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0018R \u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u001b0\u001a8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR \u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u001f0\u001a8\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010\u001dR\"\u0010'\u001a\u00020\u00108\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b\"\u0010$\"\u0004\b%\u0010&R#\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u001b0(8\u0006¢\u0006\f\n\u0004\b\u0016\u0010)\u001a\u0004\b\u001c\u0010*R#\u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u001f0(8\u0006¢\u0006\f\n\u0004\b\u0014\u0010)\u001a\u0004\b \u0010*¨\u0006-"}, d2 = {"Landroidx/navigation/NavigatorState;", "", "<init>", "()V", "Landroidx/navigation/NavBackStackEntry;", "backStackEntry", "", "h", "(Landroidx/navigation/NavBackStackEntry;)V", "Landroidx/navigation/NavDestination;", "destination", "Landroid/os/Bundle;", "arguments", "a", "(Landroidx/navigation/NavDestination;Landroid/os/Bundle;)Landroidx/navigation/NavBackStackEntry;", "popUpTo", "", "saveState", "g", "(Landroidx/navigation/NavBackStackEntry;Z)V", "f", "entry", "e", "Ljava/util/concurrent/locks/ReentrantLock;", "Ljava/util/concurrent/locks/ReentrantLock;", "backStackLock", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "b", "Lkotlinx/coroutines/flow/MutableStateFlow;", "_backStack", "", "c", "_transitionsInProgress", "d", "Z", "()Z", "i", "(Z)V", "isNavigating", "Lkotlinx/coroutines/flow/StateFlow;", "Lkotlinx/coroutines/flow/StateFlow;", "()Lkotlinx/coroutines/flow/StateFlow;", "backStack", "transitionsInProgress", "navigation-common_release"}, k = 1, mv = {1, 6, 0})
public abstract class NavigatorState {

    /* renamed from: a  reason: collision with root package name */
    public final ReentrantLock f1496a = new ReentrantLock(true);
    public final MutableStateFlow b;
    public final MutableStateFlow c;
    public boolean d;
    public final StateFlow e;
    public final StateFlow f;

    public NavigatorState() {
        MutableStateFlow a2 = StateFlowKt.a(CollectionsKt.emptyList());
        this.b = a2;
        MutableStateFlow a3 = StateFlowKt.a(SetsKt.emptySet());
        this.c = a3;
        this.e = FlowKt.c(a2);
        this.f = FlowKt.c(a3);
    }

    public abstract NavBackStackEntry a(NavDestination navDestination, Bundle bundle);

    public final StateFlow b() {
        return this.e;
    }

    public final StateFlow c() {
        return this.f;
    }

    public final boolean d() {
        return this.d;
    }

    public void e(NavBackStackEntry navBackStackEntry) {
        Intrinsics.checkNotNullParameter(navBackStackEntry, "entry");
        MutableStateFlow mutableStateFlow = this.c;
        mutableStateFlow.setValue(SetsKt.minus((Set) mutableStateFlow.getValue(), navBackStackEntry));
    }

    public void f(NavBackStackEntry navBackStackEntry) {
        Intrinsics.checkNotNullParameter(navBackStackEntry, "backStackEntry");
        MutableStateFlow mutableStateFlow = this.b;
        mutableStateFlow.setValue(CollectionsKt.plus(CollectionsKt.minus((Iterable) mutableStateFlow.getValue(), CollectionsKt.last((List) this.b.getValue())), navBackStackEntry));
    }

    public void g(NavBackStackEntry navBackStackEntry, boolean z) {
        Intrinsics.checkNotNullParameter(navBackStackEntry, "popUpTo");
        ReentrantLock reentrantLock = this.f1496a;
        reentrantLock.lock();
        try {
            MutableStateFlow mutableStateFlow = this.b;
            ArrayList arrayList = new ArrayList();
            Iterator it = ((Iterable) mutableStateFlow.getValue()).iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (!(!Intrinsics.areEqual((Object) (NavBackStackEntry) next, (Object) navBackStackEntry))) {
                    break;
                }
                arrayList.add(next);
            }
            mutableStateFlow.setValue(arrayList);
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public void h(NavBackStackEntry navBackStackEntry) {
        Intrinsics.checkNotNullParameter(navBackStackEntry, "backStackEntry");
        ReentrantLock reentrantLock = this.f1496a;
        reentrantLock.lock();
        try {
            MutableStateFlow mutableStateFlow = this.b;
            mutableStateFlow.setValue(CollectionsKt.plus((Collection) mutableStateFlow.getValue(), navBackStackEntry));
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void i(boolean z) {
        this.d = z;
    }
}
