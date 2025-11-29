package androidx.paging.multicast;

import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.SendChannel;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b \u0018\u0000 \u000b*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u0017J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00028\u0000H¦@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\t\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u000b\u0010\u0005R\u001c\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u00108\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00148\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0015\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"Landroidx/paging/multicast/StoreRealActor;", "T", "", "", "f", "()V", "msg", "e", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "c", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "d", "Lkotlinx/coroutines/channels/Channel;", "a", "Lkotlinx/coroutines/channels/Channel;", "inboundChannel", "Lkotlinx/coroutines/CompletableDeferred;", "b", "Lkotlinx/coroutines/CompletableDeferred;", "closeCompleted", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "didClose", "Companion", "paging-common"}, k = 1, mv = {1, 8, 0})
public abstract class StoreRealActor<T> {
    public static final Companion d = new Companion((DefaultConstructorMarker) null);
    public static final Object e = new Object();

    /* renamed from: a  reason: collision with root package name */
    public final Channel f1649a;
    public final CompletableDeferred b;
    public final AtomicBoolean c;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\u00020\u00018\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/paging/multicast/StoreRealActor$Companion;", "", "<init>", "()V", "CLOSE_TOKEN", "Ljava/lang/Object;", "a", "()Ljava/lang/Object;", "paging-common"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Object a() {
            return StoreRealActor.e;
        }

        public Companion() {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x005b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object c(kotlin.coroutines.Continuation r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof androidx.paging.multicast.StoreRealActor$close$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            androidx.paging.multicast.StoreRealActor$close$1 r0 = (androidx.paging.multicast.StoreRealActor$close$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.paging.multicast.StoreRealActor$close$1 r0 = new androidx.paging.multicast.StoreRealActor$close$1
            r0.<init>(r5, r6)
        L_0x0018:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003c
            if (r2 == r4) goto L_0x0034
            if (r2 != r3) goto L_0x002c
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x005c
        L_0x002c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0034:
            java.lang.Object r5 = r0.L$0
            androidx.paging.multicast.StoreRealActor r5 = (androidx.paging.multicast.StoreRealActor) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x004e
        L_0x003c:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlinx.coroutines.channels.Channel r6 = r5.f1649a
            java.lang.Object r2 = e
            r0.L$0 = r5
            r0.label = r4
            java.lang.Object r6 = r6.L(r2, r0)
            if (r6 != r1) goto L_0x004e
            return r1
        L_0x004e:
            kotlinx.coroutines.CompletableDeferred r5 = r5.b
            r6 = 0
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r5 = r5.c(r0)
            if (r5 != r1) goto L_0x005c
            return r1
        L_0x005c:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.multicast.StoreRealActor.c(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void d() {
        if (this.c.compareAndSet(false, true)) {
            try {
                f();
            } finally {
                SendChannel.DefaultImpls.a(this.f1649a, (Throwable) null, 1, (Object) null);
                this.b.w(Unit.INSTANCE);
            }
        }
    }

    public abstract Object e(Object obj, Continuation continuation);

    public void f() {
    }
}
