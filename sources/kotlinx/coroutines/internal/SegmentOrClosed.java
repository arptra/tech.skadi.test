package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.Segment;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b@\u0018\u0000*\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00012\u00020\u0003B\u0014\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0003HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0011R\u0011\u0010\u0014\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0019\u001a\u00028\u00008F¢\u0006\f\u0012\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016\u0001\u0004\u0001\u0004\u0018\u00010\u0003ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lkotlinx/coroutines/internal/SegmentOrClosed;", "Lkotlinx/coroutines/internal/Segment;", "S", "", "value", "a", "(Ljava/lang/Object;)Ljava/lang/Object;", "", "f", "(Ljava/lang/Object;)Ljava/lang/String;", "", "d", "(Ljava/lang/Object;)I", "other", "", "b", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "Ljava/lang/Object;", "e", "(Ljava/lang/Object;)Z", "isClosed", "c", "(Ljava/lang/Object;)Lkotlinx/coroutines/internal/Segment;", "getSegment$annotations", "()V", "segment", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0})
@JvmInline
public final class SegmentOrClosed<S extends Segment<S>> {

    /* renamed from: a  reason: collision with root package name */
    public final Object f3929a;

    public static Object a(Object obj) {
        return obj;
    }

    public static boolean b(Object obj, Object obj2) {
        return (obj2 instanceof SegmentOrClosed) && Intrinsics.areEqual(obj, ((SegmentOrClosed) obj2).g());
    }

    public static final Segment c(Object obj) {
        if (obj != ConcurrentLinkedListKt.f3909a) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type S of kotlinx.coroutines.internal.SegmentOrClosed");
            return (Segment) obj;
        }
        throw new IllegalStateException("Does not contain segment".toString());
    }

    public static int d(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public static final boolean e(Object obj) {
        return obj == ConcurrentLinkedListKt.f3909a;
    }

    public static String f(Object obj) {
        return "SegmentOrClosed(value=" + obj + ')';
    }

    public boolean equals(Object obj) {
        return b(this.f3929a, obj);
    }

    public final /* synthetic */ Object g() {
        return this.f3929a;
    }

    public int hashCode() {
        return d(this.f3929a);
    }

    public String toString() {
        return f(this.f3929a);
    }
}
