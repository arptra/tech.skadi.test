package androidx.paging;

import androidx.recyclerview.widget.ListUpdateCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J?\u0010\r\u001a\u00020\f\"\u0004\b\u0000\u0010\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Landroidx/paging/OverlappingListsDiffDispatcher;", "", "<init>", "()V", "T", "Landroidx/paging/NullPaddedList;", "oldList", "newList", "Landroidx/recyclerview/widget/ListUpdateCallback;", "callback", "Landroidx/paging/NullPaddedDiffResult;", "diffResult", "", "a", "(Landroidx/paging/NullPaddedList;Landroidx/paging/NullPaddedList;Landroidx/recyclerview/widget/ListUpdateCallback;Landroidx/paging/NullPaddedDiffResult;)V", "PlaceholderUsingUpdateCallback", "paging-runtime_release"}, k = 1, mv = {1, 8, 0})
public final class OverlappingListsDiffDispatcher {

    /* renamed from: a  reason: collision with root package name */
    public static final OverlappingListsDiffDispatcher f1563a = new OverlappingListsDiffDispatcher();

    @SourceDebugExtension({"SMAP\nNullPaddedListDiffHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NullPaddedListDiffHelper.kt\nandroidx/paging/OverlappingListsDiffDispatcher$PlaceholderUsingUpdateCallback\n*L\n1#1,532:1\n211#1:533\n211#1:534\n211#1:535\n211#1:536\n211#1:537\n211#1:538\n211#1:539\n211#1:540\n211#1:541\n211#1:542\n211#1:543\n211#1:544\n*S KotlinDebug\n*F\n+ 1 NullPaddedListDiffHelper.kt\nandroidx/paging/OverlappingListsDiffDispatcher$PlaceholderUsingUpdateCallback\n*L\n294#1:533\n316#1:534\n323#1:535\n343#1:536\n350#1:537\n366#1:538\n391#1:539\n396#1:540\n427#1:541\n434#1:542\n440#1:543\n444#1:544\n*E\n"})
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0002\u0018\u0000 **\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001+B+\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0011\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0011\u0010\u0010J\u001f\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0014\u0010\u0010J)\u0010\u0017\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0019\u0010\u000bJ\u000f\u0010\u001a\u001a\u00020\tH\u0002¢\u0006\u0004\b\u001a\u0010\u000bJ\u001f\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001e\u0010\u001dJ\u001f\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001f\u0010\u001dJ\u001f\u0010 \u001a\u00020\u001b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0002¢\u0006\u0004\b \u0010\u001dR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010!R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010!R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010\"R\u0016\u0010$\u001a\u00020\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010#R\u0016\u0010%\u001a\u00020\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010#R\u0016\u0010&\u001a\u00020\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\n\u0010#R\u0016\u0010'\u001a\u00020\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010#R\u0016\u0010)\u001a\u00020\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b(\u0010#¨\u0006,"}, d2 = {"Landroidx/paging/OverlappingListsDiffDispatcher$PlaceholderUsingUpdateCallback;", "T", "Landroidx/recyclerview/widget/ListUpdateCallback;", "Landroidx/paging/NullPaddedList;", "oldList", "newList", "callback", "<init>", "(Landroidx/paging/NullPaddedList;Landroidx/paging/NullPaddedList;Landroidx/recyclerview/widget/ListUpdateCallback;)V", "", "f", "()V", "", "position", "count", "onInserted", "(II)V", "onRemoved", "fromPosition", "toPosition", "onMoved", "", "payload", "onChanged", "(IILjava/lang/Object;)V", "g", "e", "", "b", "(II)Z", "a", "d", "c", "Landroidx/paging/NullPaddedList;", "Landroidx/recyclerview/widget/ListUpdateCallback;", "I", "placeholdersBefore", "placeholdersAfter", "storageCount", "placeholdersBeforeState", "h", "placeholdersAfterState", "i", "Companion", "paging-runtime_release"}, k = 1, mv = {1, 8, 0})
    public static final class PlaceholderUsingUpdateCallback<T> implements ListUpdateCallback {
        public static final Companion i = new Companion((DefaultConstructorMarker) null);

        /* renamed from: a  reason: collision with root package name */
        public final NullPaddedList f1564a;
        public final NullPaddedList b;
        public final ListUpdateCallback c;
        public int d;
        public int e;
        public int f;
        public int g = 1;
        public int h = 1;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Landroidx/paging/OverlappingListsDiffDispatcher$PlaceholderUsingUpdateCallback$Companion;", "", "()V", "UNUSED", "", "USED_FOR_ADDITION", "USED_FOR_REMOVAL", "paging-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public Companion() {
            }
        }

        public PlaceholderUsingUpdateCallback(NullPaddedList nullPaddedList, NullPaddedList nullPaddedList2, ListUpdateCallback listUpdateCallback) {
            Intrinsics.checkNotNullParameter(nullPaddedList, "oldList");
            Intrinsics.checkNotNullParameter(nullPaddedList2, "newList");
            Intrinsics.checkNotNullParameter(listUpdateCallback, "callback");
            this.f1564a = nullPaddedList;
            this.b = nullPaddedList2;
            this.c = listUpdateCallback;
            this.d = nullPaddedList.d();
            this.e = nullPaddedList.e();
            this.f = nullPaddedList.c();
        }

        public final boolean a(int i2, int i3) {
            if (i2 < this.f || this.h == 2) {
                return false;
            }
            int min = Math.min(i3, this.e);
            if (min > 0) {
                this.h = 3;
                this.c.onChanged(this.d + i2, min, DiffingChangePayload.PLACEHOLDER_TO_ITEM);
                this.e -= min;
            }
            int i4 = i3 - min;
            if (i4 <= 0) {
                return true;
            }
            this.c.onInserted(i2 + min + this.d, i4);
            return true;
        }

        public final boolean b(int i2, int i3) {
            if (i2 > 0 || this.g == 2) {
                return false;
            }
            int min = Math.min(i3, this.d);
            if (min > 0) {
                this.g = 3;
                this.c.onChanged((0 - min) + this.d, min, DiffingChangePayload.PLACEHOLDER_TO_ITEM);
                this.d -= min;
            }
            int i4 = i3 - min;
            if (i4 <= 0) {
                return true;
            }
            this.c.onInserted(this.d, i4);
            return true;
        }

        public final boolean c(int i2, int i3) {
            if (i2 + i3 < this.f || this.h == 3) {
                return false;
            }
            int coerceAtLeast = RangesKt.coerceAtLeast(Math.min(this.b.e() - this.e, i3), 0);
            int i4 = i3 - coerceAtLeast;
            if (coerceAtLeast > 0) {
                this.h = 2;
                this.c.onChanged(this.d + i2, coerceAtLeast, DiffingChangePayload.ITEM_TO_PLACEHOLDER);
                this.e += coerceAtLeast;
            }
            if (i4 <= 0) {
                return true;
            }
            this.c.onRemoved(i2 + coerceAtLeast + this.d, i4);
            return true;
        }

        public final boolean d(int i2, int i3) {
            if (i2 > 0 || this.g == 3) {
                return false;
            }
            int coerceAtLeast = RangesKt.coerceAtLeast(Math.min(this.b.d() - this.d, i3), 0);
            int i4 = i3 - coerceAtLeast;
            if (i4 > 0) {
                this.c.onRemoved(this.d, i4);
            }
            if (coerceAtLeast <= 0) {
                return true;
            }
            this.g = 2;
            this.c.onChanged(this.d, coerceAtLeast, DiffingChangePayload.ITEM_TO_PLACEHOLDER);
            this.d += coerceAtLeast;
            return true;
        }

        public final void e() {
            int min = Math.min(this.f1564a.d(), this.d);
            int d2 = this.b.d() - this.d;
            if (d2 > 0) {
                if (min > 0) {
                    this.c.onChanged(0, min, DiffingChangePayload.PLACEHOLDER_POSITION_CHANGE);
                }
                this.c.onInserted(0, d2);
            } else if (d2 < 0) {
                this.c.onRemoved(0, -d2);
                int i2 = min + d2;
                if (i2 > 0) {
                    this.c.onChanged(0, i2, DiffingChangePayload.PLACEHOLDER_POSITION_CHANGE);
                }
            }
            this.d = this.b.d();
        }

        public final void f() {
            e();
            g();
        }

        public final void g() {
            int min = Math.min(this.f1564a.e(), this.e);
            int e2 = this.b.e();
            int i2 = this.e;
            int i3 = e2 - i2;
            int i4 = this.d + this.f + i2;
            int i5 = i4 - min;
            boolean z = i5 != this.f1564a.b() - min;
            if (i3 > 0) {
                this.c.onInserted(i4, i3);
            } else if (i3 < 0) {
                this.c.onRemoved(i4 + i3, -i3);
                min += i3;
            }
            if (min > 0 && z) {
                this.c.onChanged(i5, min, DiffingChangePayload.PLACEHOLDER_POSITION_CHANGE);
            }
            this.e = this.b.e();
        }

        public void onChanged(int i2, int i3, Object obj) {
            this.c.onChanged(i2 + this.d, i3, obj);
        }

        public void onInserted(int i2, int i3) {
            if (!a(i2, i3) && !b(i2, i3)) {
                this.c.onInserted(i2 + this.d, i3);
            }
            this.f += i3;
        }

        public void onMoved(int i2, int i3) {
            ListUpdateCallback listUpdateCallback = this.c;
            int i4 = this.d;
            listUpdateCallback.onMoved(i2 + i4, i3 + i4);
        }

        public void onRemoved(int i2, int i3) {
            if (!c(i2, i3) && !d(i2, i3)) {
                this.c.onRemoved(i2 + this.d, i3);
            }
            this.f -= i3;
        }
    }

    public final void a(NullPaddedList nullPaddedList, NullPaddedList nullPaddedList2, ListUpdateCallback listUpdateCallback, NullPaddedDiffResult nullPaddedDiffResult) {
        Intrinsics.checkNotNullParameter(nullPaddedList, "oldList");
        Intrinsics.checkNotNullParameter(nullPaddedList2, "newList");
        Intrinsics.checkNotNullParameter(listUpdateCallback, "callback");
        Intrinsics.checkNotNullParameter(nullPaddedDiffResult, "diffResult");
        PlaceholderUsingUpdateCallback placeholderUsingUpdateCallback = new PlaceholderUsingUpdateCallback(nullPaddedList, nullPaddedList2, listUpdateCallback);
        nullPaddedDiffResult.a().dispatchUpdatesTo((ListUpdateCallback) placeholderUsingUpdateCallback);
        placeholderUsingUpdateCallback.f();
    }
}
