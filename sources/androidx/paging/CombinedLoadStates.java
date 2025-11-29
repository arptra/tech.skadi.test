package androidx.paging;

import io.netty.handler.codec.rtsp.RtspHeaders;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u001a\u0010\u0018R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0016\u001a\u0004\b\u0015\u0010\u0018R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001b\u001a\u0004\b\u0019\u0010\u001d¨\u0006\u001e"}, d2 = {"Landroidx/paging/CombinedLoadStates;", "", "Landroidx/paging/LoadState;", "refresh", "prepend", "append", "Landroidx/paging/LoadStates;", "source", "mediator", "<init>", "(Landroidx/paging/LoadState;Landroidx/paging/LoadState;Landroidx/paging/LoadState;Landroidx/paging/LoadStates;Landroidx/paging/LoadStates;)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "a", "Landroidx/paging/LoadState;", "d", "()Landroidx/paging/LoadState;", "b", "c", "Landroidx/paging/LoadStates;", "e", "()Landroidx/paging/LoadStates;", "paging-common"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nCombinedLoadStates.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CombinedLoadStates.kt\nandroidx/paging/CombinedLoadStates\n+ 2 LoadStates.kt\nandroidx/paging/LoadStates\n*L\n1#1,109:1\n36#2,4:110\n36#2,4:114\n*S KotlinDebug\n*F\n+ 1 CombinedLoadStates.kt\nandroidx/paging/CombinedLoadStates\n*L\n101#1:110,4\n104#1:114,4\n*E\n"})
public final class CombinedLoadStates {

    /* renamed from: a  reason: collision with root package name */
    public final LoadState f1524a;
    public final LoadState b;
    public final LoadState c;
    public final LoadStates d;
    public final LoadStates e;

    public CombinedLoadStates(LoadState loadState, LoadState loadState2, LoadState loadState3, LoadStates loadStates, LoadStates loadStates2) {
        Intrinsics.checkNotNullParameter(loadState, "refresh");
        Intrinsics.checkNotNullParameter(loadState2, "prepend");
        Intrinsics.checkNotNullParameter(loadState3, RtspHeaders.Values.APPEND);
        Intrinsics.checkNotNullParameter(loadStates, "source");
        this.f1524a = loadState;
        this.b = loadState2;
        this.c = loadState3;
        this.d = loadStates;
        this.e = loadStates2;
    }

    public final LoadState a() {
        return this.c;
    }

    public final LoadStates b() {
        return this.e;
    }

    public final LoadState c() {
        return this.b;
    }

    public final LoadState d() {
        return this.f1524a;
    }

    public final LoadStates e() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual((Object) CombinedLoadStates.class, (Object) obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.paging.CombinedLoadStates");
        CombinedLoadStates combinedLoadStates = (CombinedLoadStates) obj;
        return Intrinsics.areEqual((Object) this.f1524a, (Object) combinedLoadStates.f1524a) && Intrinsics.areEqual((Object) this.b, (Object) combinedLoadStates.b) && Intrinsics.areEqual((Object) this.c, (Object) combinedLoadStates.c) && Intrinsics.areEqual((Object) this.d, (Object) combinedLoadStates.d) && Intrinsics.areEqual((Object) this.e, (Object) combinedLoadStates.e);
    }

    public int hashCode() {
        int hashCode = ((((((this.f1524a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
        LoadStates loadStates = this.e;
        return hashCode + (loadStates != null ? loadStates.hashCode() : 0);
    }

    public String toString() {
        return "CombinedLoadStates(refresh=" + this.f1524a + ", prepend=" + this.b + ", append=" + this.c + ", source=" + this.d + ", mediator=" + this.e + ')';
    }
}
