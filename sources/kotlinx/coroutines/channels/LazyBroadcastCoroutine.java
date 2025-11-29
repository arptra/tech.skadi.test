package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.intrinsics.CancellableKt;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\t8\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lkotlinx/coroutines/channels/LazyBroadcastCoroutine;", "E", "Lkotlinx/coroutines/channels/BroadcastCoroutine;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "l", "()Lkotlinx/coroutines/channels/ReceiveChannel;", "", "Y0", "()V", "Lkotlin/coroutines/Continuation;", "e", "Lkotlin/coroutines/Continuation;", "continuation", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0})
final class LazyBroadcastCoroutine<E> extends BroadcastCoroutine<E> {
    public final Continuation e;

    public void Y0() {
        CancellableKt.b(this.e, this);
    }

    public ReceiveChannel l() {
        ReceiveChannel l = s1().l();
        start();
        return l;
    }
}
