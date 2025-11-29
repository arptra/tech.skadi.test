package kotlin.comparisons;

import java.util.Comparator;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class d implements Comparator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1[] f3702a;

    public /* synthetic */ d(Function1[] function1Arr) {
        this.f3702a = function1Arr;
    }

    public final int compare(Object obj, Object obj2) {
        return ComparisonsKt__ComparisonsKt.compareBy$lambda$0$ComparisonsKt__ComparisonsKt(this.f3702a, obj, obj2);
    }
}
