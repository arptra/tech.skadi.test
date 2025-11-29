package androidx.work;

import androidx.work.Data;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0007\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/work/OverwritingInputMerger;", "Landroidx/work/InputMerger;", "<init>", "()V", "", "Landroidx/work/Data;", "inputs", "a", "(Ljava/util/List;)Landroidx/work/Data;", "work-runtime_release"}, k = 1, mv = {1, 8, 0})
public final class OverwritingInputMerger extends InputMerger {
    public Data a(List list) {
        Intrinsics.checkNotNullParameter(list, "inputs");
        Data.Builder builder = new Data.Builder();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Map h = ((Data) it.next()).h();
            Intrinsics.checkNotNullExpressionValue(h, "input.keyValueMap");
            linkedHashMap.putAll(h);
        }
        builder.c(linkedHashMap);
        Data a2 = builder.a();
        Intrinsics.checkNotNullExpressionValue(a2, "output.build()");
        return a2;
    }
}
