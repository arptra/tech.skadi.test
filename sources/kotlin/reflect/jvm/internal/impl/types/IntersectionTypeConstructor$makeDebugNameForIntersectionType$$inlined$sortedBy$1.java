package kotlin.reflect.jvm.internal.impl.types;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2\n+ 2 IntersectionTypeConstructor.kt\norg/jetbrains/kotlin/types/IntersectionTypeConstructor\n*L\n1#1,328:1\n66#2:329\n*E\n"})
public final class IntersectionTypeConstructor$makeDebugNameForIntersectionType$$inlined$sortedBy$1<T> implements Comparator {
    final /* synthetic */ Function1 $getProperTypeRelatedToStringify$inlined;

    public IntersectionTypeConstructor$makeDebugNameForIntersectionType$$inlined$sortedBy$1(Function1 function1) {
        this.$getProperTypeRelatedToStringify$inlined = function1;
    }

    public final int compare(T t, T t2) {
        KotlinType kotlinType = (KotlinType) t;
        Function1 function1 = this.$getProperTypeRelatedToStringify$inlined;
        Intrinsics.checkNotNullExpressionValue(kotlinType, "it");
        String obj = function1.invoke(kotlinType).toString();
        KotlinType kotlinType2 = (KotlinType) t2;
        Function1 function12 = this.$getProperTypeRelatedToStringify$inlined;
        Intrinsics.checkNotNullExpressionValue(kotlinType2, "it");
        return ComparisonsKt.compareValues(obj, function12.invoke(kotlinType2).toString());
    }
}
