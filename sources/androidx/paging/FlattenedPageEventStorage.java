package androidx.paging;

import androidx.annotation.VisibleForTesting;
import androidx.paging.LoadState;
import androidx.paging.PageEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;

@SourceDebugExtension({"SMAP\nCachedPageEventFlow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CachedPageEventFlow.kt\nandroidx/paging/FlattenedPageEventStorage\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,282:1\n1#2:283\n1855#3,2:284\n*S KotlinDebug\n*F\n+ 1 CachedPageEventFlow.kt\nandroidx/paging/FlattenedPageEventStorage\n*L\n223#1:284,2\n*E\n"})
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0001\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\n¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u000e\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0011\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0014\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0017\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0002¢\u0006\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u001aR\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u001aR \u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001e0\u001d8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u001fR\u0014\u0010#\u001a\u00020!8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\"R\u0018\u0010&\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010%R\u0016\u0010)\u001a\u00020'8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010(¨\u0006*"}, d2 = {"Landroidx/paging/FlattenedPageEventStorage;", "", "T", "<init>", "()V", "Landroidx/paging/PageEvent;", "event", "", "a", "(Landroidx/paging/PageEvent;)V", "", "b", "()Ljava/util/List;", "Landroidx/paging/PageEvent$Drop;", "e", "(Landroidx/paging/PageEvent$Drop;)V", "Landroidx/paging/PageEvent$Insert;", "c", "(Landroidx/paging/PageEvent$Insert;)V", "Landroidx/paging/PageEvent$LoadStateUpdate;", "d", "(Landroidx/paging/PageEvent$LoadStateUpdate;)V", "Landroidx/paging/PageEvent$StaticList;", "f", "(Landroidx/paging/PageEvent$StaticList;)V", "", "I", "placeholdersBefore", "placeholdersAfter", "Lkotlin/collections/ArrayDeque;", "Landroidx/paging/TransformablePage;", "Lkotlin/collections/ArrayDeque;", "pages", "Landroidx/paging/MutableLoadStateCollection;", "Landroidx/paging/MutableLoadStateCollection;", "sourceStates", "Landroidx/paging/LoadStates;", "Landroidx/paging/LoadStates;", "mediatorStates", "", "Z", "receivedFirstEvent", "paging-common"}, k = 1, mv = {1, 8, 0})
@VisibleForTesting
public final class FlattenedPageEventStorage<T> {

    /* renamed from: a  reason: collision with root package name */
    public int f1534a;
    public int b;
    public final ArrayDeque c = new ArrayDeque();
    public final MutableLoadStateCollection d = new MutableLoadStateCollection();
    public LoadStates e;
    public boolean f;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                androidx.paging.LoadType[] r0 = androidx.paging.LoadType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                androidx.paging.LoadType r1 = androidx.paging.LoadType.PREPEND     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                androidx.paging.LoadType r1 = androidx.paging.LoadType.APPEND     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                androidx.paging.LoadType r1 = androidx.paging.LoadType.REFRESH     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.paging.FlattenedPageEventStorage.WhenMappings.<clinit>():void");
        }
    }

    public final void a(PageEvent pageEvent) {
        Intrinsics.checkNotNullParameter(pageEvent, "event");
        this.f = true;
        if (pageEvent instanceof PageEvent.Insert) {
            c((PageEvent.Insert) pageEvent);
        } else if (pageEvent instanceof PageEvent.Drop) {
            e((PageEvent.Drop) pageEvent);
        } else if (pageEvent instanceof PageEvent.LoadStateUpdate) {
            d((PageEvent.LoadStateUpdate) pageEvent);
        } else if (pageEvent instanceof PageEvent.StaticList) {
            f((PageEvent.StaticList) pageEvent);
        }
    }

    public final List b() {
        if (!this.f) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        LoadStates d2 = this.d.d();
        if (!this.c.isEmpty()) {
            arrayList.add(PageEvent.Insert.g.c(CollectionsKt.toList(this.c), this.f1534a, this.b, d2, this.e));
        } else {
            arrayList.add(new PageEvent.LoadStateUpdate(d2, this.e));
        }
        return arrayList;
    }

    public final void c(PageEvent.Insert insert) {
        this.d.b(insert.o());
        this.e = insert.k();
        int i = WhenMappings.$EnumSwitchMapping$0[insert.j().ordinal()];
        if (i == 1) {
            this.f1534a = insert.n();
            Iterator it = RangesKt.downTo(insert.l().size() - 1, 0).iterator();
            while (it.hasNext()) {
                this.c.addFirst(insert.l().get(((IntIterator) it).nextInt()));
            }
        } else if (i == 2) {
            this.b = insert.m();
            this.c.addAll(insert.l());
        } else if (i == 3) {
            this.c.clear();
            this.b = insert.m();
            this.f1534a = insert.n();
            this.c.addAll(insert.l());
        }
    }

    public final void d(PageEvent.LoadStateUpdate loadStateUpdate) {
        this.d.b(loadStateUpdate.h());
        this.e = loadStateUpdate.g();
    }

    public final void e(PageEvent.Drop drop) {
        this.d.c(drop.g(), LoadState.NotLoading.b.b());
        int i = WhenMappings.$EnumSwitchMapping$0[drop.g().ordinal()];
        int i2 = 0;
        if (i == 1) {
            this.f1534a = drop.k();
            int j = drop.j();
            while (i2 < j) {
                this.c.removeFirst();
                i2++;
            }
        } else if (i == 2) {
            this.b = drop.k();
            int j2 = drop.j();
            while (i2 < j2) {
                this.c.removeLast();
                i2++;
            }
        } else {
            throw new IllegalArgumentException("Page drop type must be prepend or append");
        }
    }

    public final void f(PageEvent.StaticList staticList) {
        if (staticList.i() != null) {
            this.d.b(staticList.i());
        }
        if (staticList.h() != null) {
            this.e = staticList.h();
        }
        this.c.clear();
        this.b = 0;
        this.f1534a = 0;
        this.c.add(new TransformablePage(0, staticList.g()));
    }
}
