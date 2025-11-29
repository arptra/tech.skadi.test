package com.upuphone.ar.transcribe.phone.helper;

import com.upuphone.ar.transcribe.phone.bean.SearchBean;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

@SourceDebugExtension({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$thenByDescending$1\n+ 2 TranscribeDBHelper.kt\ncom/upuphone/ar/transcribe/phone/helper/TranscribeDBHelper\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,328:1\n399#2,2:329\n401#2,4:332\n405#2:337\n401#2,5:338\n1855#3:331\n1856#3:336\n*S KotlinDebug\n*F\n+ 1 TranscribeDBHelper.kt\ncom/upuphone/ar/transcribe/phone/helper/TranscribeDBHelper\n*L\n400#1:331\n400#1:336\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$thenByDescending$1"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class TranscribeDBHelper$search$$inlined$thenByDescending$1<T> implements Comparator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Comparator f6110a;
    public final /* synthetic */ List b;

    public TranscribeDBHelper$search$$inlined$thenByDescending$1(Comparator comparator, List list) {
        this.f6110a = comparator;
        this.b = list;
    }

    public final int compare(Object obj, Object obj2) {
        int compare = this.f6110a.compare(obj, obj2);
        if (compare != 0) {
            return compare;
        }
        SearchBean searchBean = (SearchBean) obj2;
        int i = 0;
        for (String contains$default : this.b) {
            if (StringsKt.contains$default((CharSequence) searchBean.getMessage(), (CharSequence) contains$default, false, 2, (Object) null)) {
                i++;
            }
        }
        Integer valueOf = Integer.valueOf(i);
        SearchBean searchBean2 = (SearchBean) obj;
        int i2 = 0;
        for (String contains$default2 : this.b) {
            if (StringsKt.contains$default((CharSequence) searchBean2.getMessage(), (CharSequence) contains$default2, false, 2, (Object) null)) {
                i2++;
            }
        }
        return ComparisonsKt.compareValues(valueOf, Integer.valueOf(i2));
    }
}
