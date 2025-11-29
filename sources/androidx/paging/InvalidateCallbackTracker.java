package androidx.paging;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0007\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B-\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00028\u0000H\u0000¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00028\u0000H\u0000¢\u0006\u0004\b\u000e\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\u000f\u0010\u0010R \u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001c\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00148\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0015R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u00178\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0018R$\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00078\u0000@BX\u000e¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u001e"}, d2 = {"Landroidx/paging/InvalidateCallbackTracker;", "T", "", "Lkotlin/Function1;", "", "callbackInvoker", "Lkotlin/Function0;", "", "invalidGetter", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "callback", "c", "(Ljava/lang/Object;)V", "d", "b", "()Z", "a", "Lkotlin/jvm/functions/Function1;", "Lkotlin/jvm/functions/Function0;", "Ljava/util/concurrent/locks/ReentrantLock;", "Ljava/util/concurrent/locks/ReentrantLock;", "lock", "", "Ljava/util/List;", "callbacks", "<set-?>", "e", "Z", "invalid", "paging-common"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nInvalidateCallbackTracker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InvalidateCallbackTracker.kt\nandroidx/paging/InvalidateCallbackTracker\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,89:1\n1855#2,2:90\n*S KotlinDebug\n*F\n+ 1 InvalidateCallbackTracker.kt\nandroidx/paging/InvalidateCallbackTracker\n*L\n86#1:90,2\n*E\n"})
public final class InvalidateCallbackTracker<T> {

    /* renamed from: a  reason: collision with root package name */
    public final Function1 f1543a;
    public final Function0 b;
    public final ReentrantLock c;
    public final List d;
    public boolean e;

    public InvalidateCallbackTracker(Function1 function1, Function0 function0) {
        Intrinsics.checkNotNullParameter(function1, "callbackInvoker");
        this.f1543a = function1;
        this.b = function0;
        this.c = new ReentrantLock();
        this.d = new ArrayList();
    }

    public final boolean a() {
        return this.e;
    }

    public final boolean b() {
        if (this.e) {
            return false;
        }
        ReentrantLock reentrantLock = this.c;
        reentrantLock.lock();
        try {
            if (this.e) {
                return false;
            }
            this.e = true;
            List<Object> list = CollectionsKt.toList(this.d);
            this.d.clear();
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
            if (list != null) {
                Function1 function1 = this.f1543a;
                for (Object invoke : list) {
                    function1.invoke(invoke);
                }
            }
            return true;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void c(Object obj) {
        Function0 function0 = this.b;
        boolean z = true;
        if (function0 != null && ((Boolean) function0.invoke()).booleanValue()) {
            b();
        }
        if (this.e) {
            this.f1543a.invoke(obj);
            return;
        }
        ReentrantLock reentrantLock = this.c;
        reentrantLock.lock();
        try {
            if (this.e) {
                Unit unit = Unit.INSTANCE;
            } else {
                this.d.add(obj);
                z = false;
            }
            if (z) {
                this.f1543a.invoke(obj);
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void d(Object obj) {
        ReentrantLock reentrantLock = this.c;
        reentrantLock.lock();
        try {
            this.d.remove(obj);
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ InvalidateCallbackTracker(Function1 function1, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(function1, (i & 2) != 0 ? null : function0);
    }
}
