package kotlinx.coroutines.debug.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.Symbol;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u0015\u0010\u0002\u001a\u00020\u0001*\u0004\u0018\u00010\u0000H\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006\"\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t\"\u0014\u0010\r\u001a\u00020\u00018\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f\"\u0014\u0010\u000f\u001a\u00020\u00018\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\f¨\u0006\u0010"}, d2 = {"", "Lkotlinx/coroutines/debug/internal/Marked;", "d", "(Ljava/lang/Object;)Lkotlinx/coroutines/debug/internal/Marked;", "", "e", "()Ljava/lang/Void;", "Lkotlinx/coroutines/internal/Symbol;", "a", "Lkotlinx/coroutines/internal/Symbol;", "REHASH", "b", "Lkotlinx/coroutines/debug/internal/Marked;", "MARKED_NULL", "c", "MARKED_TRUE", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0})
public final class ConcurrentWeakMapKt {

    /* renamed from: a  reason: collision with root package name */
    public static final Symbol f3769a = new Symbol("REHASH");
    public static final Marked b = new Marked((Object) null);
    public static final Marked c = new Marked(Boolean.TRUE);

    public static final Marked d(Object obj) {
        return obj == null ? b : Intrinsics.areEqual(obj, (Object) Boolean.TRUE) ? c : new Marked(obj);
    }

    public static final Void e() {
        throw new UnsupportedOperationException("not implemented");
    }
}
