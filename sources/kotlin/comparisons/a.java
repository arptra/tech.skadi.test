package kotlin.comparisons;

import java.util.Comparator;

public final /* synthetic */ class a implements Comparator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Comparator f3699a;

    public /* synthetic */ a(Comparator comparator) {
        this.f3699a = comparator;
    }

    public final int compare(Object obj, Object obj2) {
        return ComparisonsKt__ComparisonsKt.nullsLast$lambda$4$ComparisonsKt__ComparisonsKt(this.f3699a, obj, obj2);
    }
}
