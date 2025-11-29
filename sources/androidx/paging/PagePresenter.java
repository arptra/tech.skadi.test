package androidx.paging;

import androidx.paging.LoadState;
import androidx.paging.PageEvent;
import androidx.paging.ViewportHint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;

@SourceDebugExtension({"SMAP\nPagePresenter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PagePresenter.kt\nandroidx/paging/PagePresenter\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,375:1\n1#2:376\n1360#3:377\n1446#3,5:378\n12774#4,2:383\n*S KotlinDebug\n*F\n+ 1 PagePresenter.kt\nandroidx/paging/PagePresenter\n*L\n80#1:377\n80#1:378,5\n245#1:383,2\n*E\n"})
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0011\b\u0000\u0018\u0000 9*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0002?@B+\u0012\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bB\u0017\b\u0016\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f¢\u0006\u0004\b\n\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J#\u0010\u001a\u001a\u00020\u00192\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u00152\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010!\u001a\u00020 2\u0006\u0010\u001f\u001a\u00020\u0007¢\u0006\u0004\b!\u0010\"J\u001f\u0010#\u001a\u00020\u0007*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u0004H\u0002¢\u0006\u0004\b#\u0010$J%\u0010&\u001a\u00020\u00192\f\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000\f2\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b&\u0010'J\u0017\u0010*\u001a\u00020\u00072\u0006\u0010)\u001a\u00020(H\u0002¢\u0006\u0004\b*\u0010+J%\u0010.\u001a\u00020\u00192\f\u0010-\u001a\b\u0012\u0004\u0012\u00028\u00000,2\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b.\u0010/R \u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005008\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u00101R$\u00107\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u00078\u0016@RX\u000e¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R$\u0010\b\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u00078\u0016@RX\u000e¢\u0006\f\n\u0004\b5\u00104\u001a\u0004\b8\u00106R$\u0010\t\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u00078\u0016@RX\u000e¢\u0006\f\n\u0004\b8\u00104\u001a\u0004\b9\u00106R\u0014\u0010:\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b3\u00106R\u0014\u0010<\u001a\u00020\u00078BX\u0004¢\u0006\u0006\u001a\u0004\b;\u00106R\u0014\u0010>\u001a\u00020\u00078BX\u0004¢\u0006\u0006\u001a\u0004\b=\u00106¨\u0006A"}, d2 = {"Landroidx/paging/PagePresenter;", "", "T", "Landroidx/paging/NullPaddedList;", "", "Landroidx/paging/TransformablePage;", "pages", "", "placeholdersBefore", "placeholdersAfter", "<init>", "(Ljava/util/List;II)V", "Landroidx/paging/PageEvent$Insert;", "insertEvent", "(Landroidx/paging/PageEvent$Insert;)V", "", "toString", "()Ljava/lang/String;", "localIndex", "f", "(I)Ljava/lang/Object;", "Landroidx/paging/PageEvent;", "pageEvent", "Landroidx/paging/PagePresenter$ProcessPageEventCallback;", "callback", "", "n", "(Landroidx/paging/PageEvent;Landroidx/paging/PagePresenter$ProcessPageEventCallback;)V", "Landroidx/paging/ViewportHint$Initial;", "l", "()Landroidx/paging/ViewportHint$Initial;", "index", "Landroidx/paging/ViewportHint$Access;", "a", "(I)Landroidx/paging/ViewportHint$Access;", "i", "(Ljava/util/List;)I", "insert", "m", "(Landroidx/paging/PageEvent$Insert;Landroidx/paging/PagePresenter$ProcessPageEventCallback;)V", "Lkotlin/ranges/IntRange;", "pageOffsetsToDrop", "h", "(Lkotlin/ranges/IntRange;)I", "Landroidx/paging/PageEvent$Drop;", "drop", "g", "(Landroidx/paging/PageEvent$Drop;Landroidx/paging/PagePresenter$ProcessPageEventCallback;)V", "", "Ljava/util/List;", "<set-?>", "b", "I", "c", "()I", "storageCount", "d", "e", "size", "j", "originalPageOffsetFirst", "k", "originalPageOffsetLast", "Companion", "ProcessPageEventCallback", "paging-common"}, k = 1, mv = {1, 8, 0})
public final class PagePresenter<T> implements NullPaddedList<T> {
    public static final Companion e = new Companion((DefaultConstructorMarker) null);
    public static final PagePresenter f = new PagePresenter(PageEvent.Insert.g.e());

    /* renamed from: a  reason: collision with root package name */
    public final List f1589a;
    public int b;
    public int c;
    public int d;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/paging/PagePresenter$Companion;", "", "<init>", "()V", "Landroidx/paging/PagePresenter;", "INITIAL", "Landroidx/paging/PagePresenter;", "paging-common"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b`\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\u0007J\u001f\u0010\t\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\u0007J'\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0012H&¢\u0006\u0004\b\u0015\u0010\u0016ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0017À\u0006\u0001"}, d2 = {"Landroidx/paging/PagePresenter$ProcessPageEventCallback;", "", "", "position", "count", "", "a", "(II)V", "onInserted", "onRemoved", "Landroidx/paging/LoadType;", "loadType", "", "fromMediator", "Landroidx/paging/LoadState;", "loadState", "b", "(Landroidx/paging/LoadType;ZLandroidx/paging/LoadState;)V", "Landroidx/paging/LoadStates;", "source", "mediator", "c", "(Landroidx/paging/LoadStates;Landroidx/paging/LoadStates;)V", "paging-common"}, k = 1, mv = {1, 8, 0})
    public interface ProcessPageEventCallback {
        void a(int i, int i2);

        void b(LoadType loadType, boolean z, LoadState loadState);

        void c(LoadStates loadStates, LoadStates loadStates2);

        void onInserted(int i, int i2);

        void onRemoved(int i, int i2);
    }

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
                androidx.paging.LoadType r1 = androidx.paging.LoadType.REFRESH     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                androidx.paging.LoadType r1 = androidx.paging.LoadType.PREPEND     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                androidx.paging.LoadType r1 = androidx.paging.LoadType.APPEND     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PagePresenter.WhenMappings.<clinit>():void");
        }
    }

    public PagePresenter(List list, int i, int i2) {
        Intrinsics.checkNotNullParameter(list, "pages");
        this.f1589a = CollectionsKt.toMutableList(list);
        this.b = i(list);
        this.c = i;
        this.d = i2;
    }

    public final ViewportHint.Access a(int i) {
        int i2 = 0;
        int d2 = i - d();
        while (d2 >= ((TransformablePage) this.f1589a.get(i2)).b().size() && i2 < CollectionsKt.getLastIndex(this.f1589a)) {
            d2 -= ((TransformablePage) this.f1589a.get(i2)).b().size();
            i2++;
        }
        return ((TransformablePage) this.f1589a.get(i2)).f(d2, i - d(), ((b() - i) - e()) - 1, j(), k());
    }

    public int b() {
        return d() + c() + e();
    }

    public int c() {
        return this.b;
    }

    public int d() {
        return this.c;
    }

    public int e() {
        return this.d;
    }

    public Object f(int i) {
        int size = this.f1589a.size();
        int i2 = 0;
        while (i2 < size) {
            int size2 = ((TransformablePage) this.f1589a.get(i2)).b().size();
            if (size2 > i) {
                break;
            }
            i -= size2;
            i2++;
        }
        return ((TransformablePage) this.f1589a.get(i2)).b().get(i);
    }

    public final void g(PageEvent.Drop drop, ProcessPageEventCallback processPageEventCallback) {
        int b2 = b();
        LoadType g = drop.g();
        LoadType loadType = LoadType.PREPEND;
        if (g == loadType) {
            int d2 = d();
            this.b = c() - h(new IntRange(drop.i(), drop.h()));
            this.c = drop.k();
            int b3 = b() - b2;
            if (b3 > 0) {
                processPageEventCallback.onInserted(0, b3);
            } else if (b3 < 0) {
                processPageEventCallback.onRemoved(0, -b3);
            }
            int max = Math.max(0, d2 + b3);
            int k = drop.k() - max;
            if (k > 0) {
                processPageEventCallback.a(max, k);
            }
            processPageEventCallback.b(loadType, false, LoadState.NotLoading.b.b());
            return;
        }
        int e2 = e();
        this.b = c() - h(new IntRange(drop.i(), drop.h()));
        this.d = drop.k();
        int b4 = b() - b2;
        if (b4 > 0) {
            processPageEventCallback.onInserted(b2, b4);
        } else if (b4 < 0) {
            processPageEventCallback.onRemoved(b2 + b4, -b4);
        }
        int k2 = drop.k() - (e2 - (b4 < 0 ? Math.min(e2, -b4) : 0));
        if (k2 > 0) {
            processPageEventCallback.a(b() - drop.k(), k2);
        }
        processPageEventCallback.b(LoadType.APPEND, false, LoadState.NotLoading.b.b());
    }

    public final int h(IntRange intRange) {
        Iterator it = this.f1589a.iterator();
        int i = 0;
        while (it.hasNext()) {
            TransformablePage transformablePage = (TransformablePage) it.next();
            int[] e2 = transformablePage.e();
            int length = e2.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                } else if (intRange.contains(e2[i2])) {
                    i += transformablePage.b().size();
                    it.remove();
                    break;
                } else {
                    i2++;
                }
            }
        }
        return i;
    }

    public final int i(List list) {
        Iterator it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            i += ((TransformablePage) it.next()).b().size();
        }
        return i;
    }

    public final int j() {
        Integer minOrNull = ArraysKt.minOrNull(((TransformablePage) CollectionsKt.first(this.f1589a)).e());
        Intrinsics.checkNotNull(minOrNull);
        return minOrNull.intValue();
    }

    public final int k() {
        Integer maxOrNull = ArraysKt.maxOrNull(((TransformablePage) CollectionsKt.last(this.f1589a)).e());
        Intrinsics.checkNotNull(maxOrNull);
        return maxOrNull.intValue();
    }

    public final ViewportHint.Initial l() {
        int c2 = c() / 2;
        return new ViewportHint.Initial(c2, c2, j(), k());
    }

    public final void m(PageEvent.Insert insert, ProcessPageEventCallback processPageEventCallback) {
        int i = i(insert.l());
        int b2 = b();
        int i2 = WhenMappings.$EnumSwitchMapping$0[insert.j().ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                int min = Math.min(d(), i);
                int i3 = i - min;
                this.f1589a.addAll(0, insert.l());
                this.b = c() + i;
                this.c = insert.n();
                processPageEventCallback.a(d() - min, min);
                processPageEventCallback.onInserted(0, i3);
                int b3 = (b() - b2) - i3;
                if (b3 > 0) {
                    processPageEventCallback.onInserted(0, b3);
                } else if (b3 < 0) {
                    processPageEventCallback.onRemoved(0, -b3);
                }
            } else if (i2 == 3) {
                int min2 = Math.min(e(), i);
                int d2 = d() + c();
                int i4 = i - min2;
                List list = this.f1589a;
                list.addAll(list.size(), insert.l());
                this.b = c() + i;
                this.d = insert.m();
                processPageEventCallback.a(d2, min2);
                processPageEventCallback.onInserted(d2 + min2, i4);
                int b4 = (b() - b2) - i4;
                if (b4 > 0) {
                    processPageEventCallback.onInserted(b() - b4, b4);
                } else if (b4 < 0) {
                    processPageEventCallback.onRemoved(b(), -b4);
                }
            }
            processPageEventCallback.c(insert.o(), insert.k());
            return;
        }
        throw new IllegalStateException("Paging received a refresh event in the middle of an actively loading generation\nof PagingData. If you see this exception, it is most likely a bug in the library.\nPlease file a bug so we can fix it at:\nhttps://issuetracker.google.com/issues/new?component=413106");
    }

    public final void n(PageEvent pageEvent, ProcessPageEventCallback processPageEventCallback) {
        Intrinsics.checkNotNullParameter(pageEvent, "pageEvent");
        Intrinsics.checkNotNullParameter(processPageEventCallback, "callback");
        if (pageEvent instanceof PageEvent.Insert) {
            m((PageEvent.Insert) pageEvent, processPageEventCallback);
        } else if (pageEvent instanceof PageEvent.Drop) {
            g((PageEvent.Drop) pageEvent, processPageEventCallback);
        } else if (pageEvent instanceof PageEvent.LoadStateUpdate) {
            PageEvent.LoadStateUpdate loadStateUpdate = (PageEvent.LoadStateUpdate) pageEvent;
            processPageEventCallback.c(loadStateUpdate.h(), loadStateUpdate.g());
        } else if (pageEvent instanceof PageEvent.StaticList) {
            throw new IllegalStateException("Paging received an event to display a static list, while still actively loading\nfrom an existing generation of PagingData. If you see this exception, it is most\nlikely a bug in the library. Please file a bug so we can fix it at:\nhttps://issuetracker.google.com/issues/new?component=413106");
        }
    }

    public String toString() {
        int c2 = c();
        ArrayList arrayList = new ArrayList(c2);
        for (int i = 0; i < c2; i++) {
            arrayList.add(f(i));
        }
        String joinToString$default = CollectionsKt.joinToString$default(arrayList, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null);
        return "[(" + d() + " placeholders), " + joinToString$default + ", (" + e() + " placeholders)]";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public PagePresenter(PageEvent.Insert insert) {
        this(insert.l(), insert.n(), insert.m());
        Intrinsics.checkNotNullParameter(insert, "insertEvent");
    }
}
