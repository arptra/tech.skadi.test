package androidx.paging;

import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListUpdateCallback;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u00002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u001a?\u0010\u0007\u001a\u00020\u0006\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0000¢\u0006\u0004\b\u0007\u0010\b\u001aA\u0010\r\u001a\u00020\f\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\n\u001a\u00020\t2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u000b\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a3\u0010\u0011\u001a\u00020\u000f*\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u000b\u001a\u00020\u00062\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0000¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"", "T", "Landroidx/paging/NullPaddedList;", "newList", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "diffCallback", "Landroidx/paging/NullPaddedDiffResult;", "a", "(Landroidx/paging/NullPaddedList;Landroidx/paging/NullPaddedList;Landroidx/recyclerview/widget/DiffUtil$ItemCallback;)Landroidx/paging/NullPaddedDiffResult;", "Landroidx/recyclerview/widget/ListUpdateCallback;", "callback", "diffResult", "", "b", "(Landroidx/paging/NullPaddedList;Landroidx/recyclerview/widget/ListUpdateCallback;Landroidx/paging/NullPaddedList;Landroidx/paging/NullPaddedDiffResult;)V", "", "oldPosition", "c", "(Landroidx/paging/NullPaddedList;Landroidx/paging/NullPaddedDiffResult;Landroidx/paging/NullPaddedList;I)I", "paging-runtime_release"}, k = 2, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nNullPaddedListDiffHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NullPaddedListDiffHelper.kt\nandroidx/paging/NullPaddedListDiffHelperKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,532:1\n1747#2,3:533\n*S KotlinDebug\n*F\n+ 1 NullPaddedListDiffHelper.kt\nandroidx/paging/NullPaddedListDiffHelperKt\n*L\n84#1:533,3\n*E\n"})
public final class NullPaddedListDiffHelperKt {
    public static final NullPaddedDiffResult a(NullPaddedList nullPaddedList, NullPaddedList nullPaddedList2, DiffUtil.ItemCallback itemCallback) {
        Intrinsics.checkNotNullParameter(nullPaddedList, "<this>");
        Intrinsics.checkNotNullParameter(nullPaddedList2, "newList");
        Intrinsics.checkNotNullParameter(itemCallback, "diffCallback");
        boolean z = true;
        DiffUtil.DiffResult calculateDiff = DiffUtil.calculateDiff(new NullPaddedListDiffHelperKt$computeDiff$diffResult$1(nullPaddedList, nullPaddedList2, itemCallback, nullPaddedList.c(), nullPaddedList2.c()), true);
        Intrinsics.checkNotNullExpressionValue(calculateDiff, "NullPaddedList<T>.comput…    },\n        true\n    )");
        IntRange until = RangesKt.until(0, nullPaddedList.c());
        if (!(until instanceof Collection) || !((Collection) until).isEmpty()) {
            Iterator it = until.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (calculateDiff.convertOldPositionToNew(((IntIterator) it).nextInt()) != -1) {
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        z = false;
        return new NullPaddedDiffResult(calculateDiff, z);
    }

    public static final void b(NullPaddedList nullPaddedList, ListUpdateCallback listUpdateCallback, NullPaddedList nullPaddedList2, NullPaddedDiffResult nullPaddedDiffResult) {
        Intrinsics.checkNotNullParameter(nullPaddedList, "<this>");
        Intrinsics.checkNotNullParameter(listUpdateCallback, "callback");
        Intrinsics.checkNotNullParameter(nullPaddedList2, "newList");
        Intrinsics.checkNotNullParameter(nullPaddedDiffResult, "diffResult");
        if (nullPaddedDiffResult.b()) {
            OverlappingListsDiffDispatcher.f1563a.a(nullPaddedList, nullPaddedList2, listUpdateCallback, nullPaddedDiffResult);
        } else {
            DistinctListsDiffDispatcher.f1532a.b(listUpdateCallback, nullPaddedList, nullPaddedList2);
        }
    }

    public static final int c(NullPaddedList nullPaddedList, NullPaddedDiffResult nullPaddedDiffResult, NullPaddedList nullPaddedList2, int i) {
        int convertOldPositionToNew;
        Intrinsics.checkNotNullParameter(nullPaddedList, "<this>");
        Intrinsics.checkNotNullParameter(nullPaddedDiffResult, "diffResult");
        Intrinsics.checkNotNullParameter(nullPaddedList2, "newList");
        if (!nullPaddedDiffResult.b()) {
            return RangesKt.coerceIn(i, (ClosedRange<Integer>) RangesKt.until(0, nullPaddedList2.b()));
        }
        int d = i - nullPaddedList.d();
        int c = nullPaddedList.c();
        if (d >= 0 && d < c) {
            for (int i2 = 0; i2 < 30; i2++) {
                int i3 = i2 / 2;
                int i4 = 1;
                if (i2 % 2 == 1) {
                    i4 = -1;
                }
                int i5 = (i3 * i4) + d;
                if (i5 >= 0 && i5 < nullPaddedList.c() && (convertOldPositionToNew = nullPaddedDiffResult.a().convertOldPositionToNew(i5)) != -1) {
                    return convertOldPositionToNew + nullPaddedList2.d();
                }
            }
        }
        return RangesKt.coerceIn(i, (ClosedRange<Integer>) RangesKt.until(0, nullPaddedList2.b()));
    }
}
