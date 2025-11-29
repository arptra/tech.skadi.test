package androidx.paging;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension({"SMAP\nSeparators.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Separators.kt\nandroidx/paging/SeparatorState$onDrop$1\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,607:1\n12774#2,2:608\n*S KotlinDebug\n*F\n+ 1 Separators.kt\nandroidx/paging/SeparatorState$onDrop$1\n*L\n508#1:608,2\n*E\n"})
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u0002H\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0006H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "", "R", "", "T", "stash", "Landroidx/paging/TransformablePage;", "invoke", "(Landroidx/paging/TransformablePage;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class SeparatorState$onDrop$1 extends Lambda implements Function1<TransformablePage<T>, Boolean> {
    final /* synthetic */ IntRange $pageOffsetsToDrop;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SeparatorState$onDrop$1(IntRange intRange) {
        super(1);
        this.$pageOffsetsToDrop = intRange;
    }

    @NotNull
    public final Boolean invoke(@NotNull TransformablePage<T> transformablePage) {
        Intrinsics.checkNotNullParameter(transformablePage, "stash");
        int[] e = transformablePage.e();
        IntRange intRange = this.$pageOffsetsToDrop;
        int length = e.length;
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            } else if (intRange.contains(e[i])) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        return Boolean.valueOf(z);
    }
}
