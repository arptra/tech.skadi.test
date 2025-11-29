package com.upuphone.ar.transcribe.phone.helper;

import com.upuphone.ar.transcribe.phone.bean.SearchBean;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$thenByDescending$1\n+ 2 TranscribeDBHelper.kt\ncom/upuphone/ar/transcribe/phone/helper/TranscribeDBHelper\n*L\n1#1,328:1\n407#2:329\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$thenByDescending$1"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class TranscribeDBHelper$search$$inlined$thenByDescending$2<T> implements Comparator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Comparator f6111a;

    public TranscribeDBHelper$search$$inlined$thenByDescending$2(Comparator comparator) {
        this.f6111a = comparator;
    }

    public final int compare(Object obj, Object obj2) {
        int compare = this.f6111a.compare(obj, obj2);
        return compare != 0 ? compare : ComparisonsKt.compareValues(Long.valueOf(((SearchBean) obj2).getRecordTime()), Long.valueOf(((SearchBean) obj).getRecordTime()));
    }
}
