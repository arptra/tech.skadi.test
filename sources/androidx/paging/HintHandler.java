package androidx.paging;

import androidx.paging.ViewportHint;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001:\u0002\u0017\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0012\u001a\u00060\u0010R\u00020\u00008\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0011R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u00138F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Landroidx/paging/HintHandler;", "", "<init>", "()V", "Landroidx/paging/LoadType;", "loadType", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/ViewportHint;", "c", "(Landroidx/paging/LoadType;)Lkotlinx/coroutines/flow/Flow;", "viewportHint", "", "a", "(Landroidx/paging/LoadType;Landroidx/paging/ViewportHint;)V", "d", "(Landroidx/paging/ViewportHint;)V", "Landroidx/paging/HintHandler$State;", "Landroidx/paging/HintHandler$State;", "state", "Landroidx/paging/ViewportHint$Access;", "b", "()Landroidx/paging/ViewportHint$Access;", "lastAccessHint", "HintFlow", "State", "paging-common"}, k = 1, mv = {1, 8, 0})
public final class HintHandler {

    /* renamed from: a  reason: collision with root package name */
    public final State f1540a = new State();

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R.\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@FX\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\rR\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u000f8F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0010¨\u0006\u0012"}, d2 = {"Landroidx/paging/HintHandler$HintFlow;", "", "<init>", "(Landroidx/paging/HintHandler;)V", "Landroidx/paging/ViewportHint;", "value", "a", "Landroidx/paging/ViewportHint;", "b", "()Landroidx/paging/ViewportHint;", "c", "(Landroidx/paging/ViewportHint;)V", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "_flow", "Lkotlinx/coroutines/flow/Flow;", "()Lkotlinx/coroutines/flow/Flow;", "flow", "paging-common"}, k = 1, mv = {1, 8, 0})
    public final class HintFlow {

        /* renamed from: a  reason: collision with root package name */
        public ViewportHint f1541a;
        public final MutableSharedFlow b = SharedFlowKt.b(1, 0, BufferOverflow.DROP_OLDEST, 2, (Object) null);

        public HintFlow() {
        }

        public final Flow a() {
            return this.b;
        }

        public final ViewportHint b() {
            return this.f1541a;
        }

        public final void c(ViewportHint viewportHint) {
            this.f1541a = viewportHint;
            if (viewportHint != null) {
                this.b.b(viewportHint);
            }
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JW\u0010\u000f\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042>\u0010\u000e\u001a:\u0012\u0017\u0012\u00150\u0007R\u00020\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0017\u0012\u00150\u0007R\u00020\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0006¢\u0006\u0004\b\u000f\u0010\u0010R\u0018\u0010\u000b\u001a\u00060\u0007R\u00020\b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\f\u001a\u00060\u0007R\u00020\b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012R(\u0010\u0018\u001a\u0004\u0018\u00010\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u00048\u0006@BX\u000e¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u00198\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u001aR\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c8F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u001eR\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u001e¨\u0006!"}, d2 = {"Landroidx/paging/HintHandler$State;", "", "<init>", "(Landroidx/paging/HintHandler;)V", "Landroidx/paging/ViewportHint$Access;", "accessHint", "Lkotlin/Function2;", "Landroidx/paging/HintHandler$HintFlow;", "Landroidx/paging/HintHandler;", "Lkotlin/ParameterName;", "name", "prepend", "append", "", "block", "d", "(Landroidx/paging/ViewportHint$Access;Lkotlin/jvm/functions/Function2;)V", "a", "Landroidx/paging/HintHandler$HintFlow;", "b", "<set-?>", "c", "Landroidx/paging/ViewportHint$Access;", "()Landroidx/paging/ViewportHint$Access;", "lastAccessHint", "Ljava/util/concurrent/locks/ReentrantLock;", "Ljava/util/concurrent/locks/ReentrantLock;", "lock", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/ViewportHint;", "()Lkotlinx/coroutines/flow/Flow;", "prependFlow", "appendFlow", "paging-common"}, k = 1, mv = {1, 8, 0})
    public final class State {

        /* renamed from: a  reason: collision with root package name */
        public final HintFlow f1542a;
        public final HintFlow b;
        public ViewportHint.Access c;
        public final ReentrantLock d = new ReentrantLock();

        public State() {
            this.f1542a = new HintFlow();
            this.b = new HintFlow();
        }

        public final Flow a() {
            return this.b.a();
        }

        public final ViewportHint.Access b() {
            return this.c;
        }

        public final Flow c() {
            return this.f1542a.a();
        }

        public final void d(ViewportHint.Access access, Function2 function2) {
            Intrinsics.checkNotNullParameter(function2, "block");
            ReentrantLock reentrantLock = this.d;
            reentrantLock.lock();
            if (access != null) {
                try {
                    this.c = access;
                } catch (Throwable th) {
                    reentrantLock.unlock();
                    throw th;
                }
            }
            function2.invoke(this.f1542a, this.b);
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                androidx.paging.LoadType[] r0 = androidx.paging.LoadType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                androidx.paging.LoadType r1 = androidx.paging.LoadType.PREPEND     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                androidx.paging.LoadType r1 = androidx.paging.LoadType.APPEND     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.paging.HintHandler.WhenMappings.<clinit>():void");
        }
    }

    public final void a(LoadType loadType, ViewportHint viewportHint) {
        Intrinsics.checkNotNullParameter(loadType, "loadType");
        Intrinsics.checkNotNullParameter(viewportHint, "viewportHint");
        if (loadType == LoadType.PREPEND || loadType == LoadType.APPEND) {
            this.f1540a.d((ViewportHint.Access) null, new HintHandler$forceSetHint$2(loadType, viewportHint));
            return;
        }
        throw new IllegalArgumentException(("invalid load type for reset: " + loadType).toString());
    }

    public final ViewportHint.Access b() {
        return this.f1540a.b();
    }

    public final Flow c(LoadType loadType) {
        Intrinsics.checkNotNullParameter(loadType, "loadType");
        int i = WhenMappings.$EnumSwitchMapping$0[loadType.ordinal()];
        if (i == 1) {
            return this.f1540a.c();
        }
        if (i == 2) {
            return this.f1540a.a();
        }
        throw new IllegalArgumentException("invalid load type for hints");
    }

    public final void d(ViewportHint viewportHint) {
        Intrinsics.checkNotNullParameter(viewportHint, "viewportHint");
        this.f1540a.d(viewportHint instanceof ViewportHint.Access ? (ViewportHint.Access) viewportHint : null, new HintHandler$processHint$1(viewportHint));
    }
}
