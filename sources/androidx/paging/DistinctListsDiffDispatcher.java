package androidx.paging;

import androidx.recyclerview.widget.ListUpdateCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J;\u0010\u000b\u001a\u00020\n\"\b\b\u0000\u0010\u0004*\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0004\b\u000b\u0010\fJ?\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Landroidx/paging/DistinctListsDiffDispatcher;", "", "<init>", "()V", "T", "Landroidx/recyclerview/widget/ListUpdateCallback;", "callback", "Landroidx/paging/NullPaddedList;", "oldList", "newList", "", "b", "(Landroidx/recyclerview/widget/ListUpdateCallback;Landroidx/paging/NullPaddedList;Landroidx/paging/NullPaddedList;)V", "", "startBoundary", "endBoundary", "start", "end", "payload", "a", "(Landroidx/recyclerview/widget/ListUpdateCallback;IIIILjava/lang/Object;)V", "paging-runtime_release"}, k = 1, mv = {1, 8, 0})
public final class DistinctListsDiffDispatcher {

    /* renamed from: a  reason: collision with root package name */
    public static final DistinctListsDiffDispatcher f1532a = new DistinctListsDiffDispatcher();

    public final void a(ListUpdateCallback listUpdateCallback, int i, int i2, int i3, int i4, Object obj) {
        int i5 = i - i3;
        if (i5 > 0) {
            listUpdateCallback.onChanged(i3, i5, obj);
        }
        int i6 = i4 - i2;
        if (i6 > 0) {
            listUpdateCallback.onChanged(i2, i6, obj);
        }
    }

    public final void b(ListUpdateCallback listUpdateCallback, NullPaddedList nullPaddedList, NullPaddedList nullPaddedList2) {
        Intrinsics.checkNotNullParameter(listUpdateCallback, "callback");
        Intrinsics.checkNotNullParameter(nullPaddedList, "oldList");
        Intrinsics.checkNotNullParameter(nullPaddedList2, "newList");
        int max = Math.max(nullPaddedList.d(), nullPaddedList2.d());
        int min = Math.min(nullPaddedList.d() + nullPaddedList.c(), nullPaddedList2.d() + nullPaddedList2.c());
        int i = min - max;
        if (i > 0) {
            listUpdateCallback.onRemoved(max, i);
            listUpdateCallback.onInserted(max, i);
        }
        int min2 = Math.min(max, min);
        ListUpdateCallback listUpdateCallback2 = listUpdateCallback;
        int i2 = min2;
        int max2 = Math.max(max, min);
        a(listUpdateCallback2, i2, max2, RangesKt.coerceAtMost(nullPaddedList.d(), nullPaddedList2.b()), RangesKt.coerceAtMost(nullPaddedList.d() + nullPaddedList.c(), nullPaddedList2.b()), DiffingChangePayload.ITEM_TO_PLACEHOLDER);
        a(listUpdateCallback2, i2, max2, RangesKt.coerceAtMost(nullPaddedList2.d(), nullPaddedList.b()), RangesKt.coerceAtMost(nullPaddedList2.d() + nullPaddedList2.c(), nullPaddedList.b()), DiffingChangePayload.PLACEHOLDER_TO_ITEM);
        int b = nullPaddedList2.b() - nullPaddedList.b();
        if (b > 0) {
            listUpdateCallback.onInserted(nullPaddedList.b(), b);
        } else if (b < 0) {
            listUpdateCallback.onRemoved(nullPaddedList.b() + b, -b);
        }
    }
}
