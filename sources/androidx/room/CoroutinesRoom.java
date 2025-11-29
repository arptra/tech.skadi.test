package androidx.room;

import android.os.CancellationSignal;
import androidx.annotation.RestrictTo;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Landroidx/room/CoroutinesRoom;", "", "a", "Companion", "room-ktx_release"}, k = 1, mv = {1, 8, 0})
@RestrictTo
public final class CoroutinesRoom {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f1730a = new Companion((DefaultConstructorMarker) null);

    @SourceDebugExtension({"SMAP\nCoroutinesRoom.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutinesRoom.kt\nandroidx/room/CoroutinesRoom$Companion\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,162:1\n314#2,11:163\n*S KotlinDebug\n*F\n+ 1 CoroutinesRoom.kt\nandroidx/room/CoroutinesRoom$Companion\n*L\n84#1:163,11\n*E\n"})
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J7\u0010\u000b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\tH@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJA\u0010\u000f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\tH@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010JL\u0010\u0016\u001a\r\u0012\t\u0012\u00078\u0000¢\u0006\u0002\b\u00150\u0014\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0007¢\u0006\u0004\b\u0016\u0010\u0017\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"Landroidx/room/CoroutinesRoom$Companion;", "", "<init>", "()V", "R", "Landroidx/room/RoomDatabase;", "db", "", "inTransaction", "Ljava/util/concurrent/Callable;", "callable", "c", "(Landroidx/room/RoomDatabase;ZLjava/util/concurrent/Callable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/os/CancellationSignal;", "cancellationSignal", "b", "(Landroidx/room/RoomDatabase;ZLandroid/os/CancellationSignal;Ljava/util/concurrent/Callable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "", "tableNames", "Lkotlinx/coroutines/flow/Flow;", "Lkotlin/jvm/JvmSuppressWildcards;", "a", "(Landroidx/room/RoomDatabase;Z[Ljava/lang/String;Ljava/util/concurrent/Callable;)Lkotlinx/coroutines/flow/Flow;", "room-ktx_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Flow a(RoomDatabase roomDatabase, boolean z, String[] strArr, Callable callable) {
            return FlowKt.C(new CoroutinesRoom$Companion$createFlow$1(z, roomDatabase, strArr, callable, (Continuation<? super CoroutinesRoom$Companion$createFlow$1>) null));
        }

        public final Object b(RoomDatabase roomDatabase, boolean z, CancellationSignal cancellationSignal, Callable callable, Continuation continuation) {
            CoroutineContext b;
            if (roomDatabase.isOpenInternal() && roomDatabase.inTransaction()) {
                return callable.call();
            }
            TransactionElement transactionElement = (TransactionElement) continuation.getContext().get(TransactionElement.c);
            if (transactionElement == null || (b = transactionElement.f()) == null) {
                b = z ? CoroutinesRoomKt.b(roomDatabase) : CoroutinesRoomKt.a(roomDatabase);
            }
            CoroutineContext coroutineContext = b;
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
            cancellableContinuationImpl.x();
            cancellableContinuationImpl.E(new CoroutinesRoom$Companion$execute$4$1(cancellationSignal, BuildersKt__Builders_commonKt.d(GlobalScope.f3732a, coroutineContext, (CoroutineStart) null, new CoroutinesRoom$Companion$execute$4$job$1(callable, cancellableContinuationImpl, (Continuation<? super CoroutinesRoom$Companion$execute$4$job$1>) null), 2, (Object) null)));
            Object u = cancellableContinuationImpl.u();
            if (u == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return u;
        }

        public final Object c(RoomDatabase roomDatabase, boolean z, Callable callable, Continuation continuation) {
            CoroutineContext coroutineContext;
            if (roomDatabase.isOpenInternal() && roomDatabase.inTransaction()) {
                return callable.call();
            }
            TransactionElement transactionElement = (TransactionElement) continuation.getContext().get(TransactionElement.c);
            if (transactionElement == null || (coroutineContext = transactionElement.f()) == null) {
                coroutineContext = z ? CoroutinesRoomKt.b(roomDatabase) : CoroutinesRoomKt.a(roomDatabase);
            }
            return BuildersKt.g(coroutineContext, new CoroutinesRoom$Companion$execute$2(callable, (Continuation<? super CoroutinesRoom$Companion$execute$2>) null), continuation);
        }

        public Companion() {
        }
    }

    public static final Flow a(RoomDatabase roomDatabase, boolean z, String[] strArr, Callable callable) {
        return f1730a.a(roomDatabase, z, strArr, callable);
    }

    public static final Object b(RoomDatabase roomDatabase, boolean z, CancellationSignal cancellationSignal, Callable callable, Continuation continuation) {
        return f1730a.b(roomDatabase, z, cancellationSignal, callable, continuation);
    }

    public static final Object c(RoomDatabase roomDatabase, boolean z, Callable callable, Continuation continuation) {
        return f1730a.c(roomDatabase, z, callable, continuation);
    }
}
