package com.airbnb.epoxy.preload;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.epoxy.BaseEpoxyAdapter;
import com.airbnb.epoxy.EpoxyAdapter;
import com.airbnb.epoxy.EpoxyController;
import com.airbnb.epoxy.preload.PreloadRequestHolder;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

@SourceDebugExtension({"SMAP\nEpoxyPreloader.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EpoxyPreloader.kt\ncom/airbnb/epoxy/preload/EpoxyPreloader\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,294:1\n1194#2,2:295\n1222#2,4:297\n1855#2,2:301\n1855#2,2:303\n*S KotlinDebug\n*F\n+ 1 EpoxyPreloader.kt\ncom/airbnb/epoxy/preload/EpoxyPreloader\n*L\n44#1:295,2\n44#1:297,4\n131#1:301,2\n175#1:303,2\n*E\n"})
@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 K*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003:\u0001LBg\b\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012 \u0010\u000e\u001a\u001c\u0012\u0004\u0012\u00020\t\u0012\b\u0012\u00060\nj\u0002`\u000b\u0012\u0004\u0012\u00020\f0\bj\u0002`\r\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u001c\u0010\u0013\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0006\b\u0001\u0012\u00028\u00000\u00120\u0011¢\u0006\u0004\b\u0014\u0010\u0015Bg\b\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012 \u0010\u000e\u001a\u001c\u0012\u0004\u0012\u00020\t\u0012\b\u0012\u00060\nj\u0002`\u000b\u0012\u0004\u0012\u00020\f0\bj\u0002`\r\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u001c\u0010\u0013\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0006\b\u0001\u0012\u00028\u00000\u00120\u0011¢\u0006\u0004\b\u0014\u0010\u0019Bg\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u001a\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012 \u0010\u000e\u001a\u001c\u0012\u0004\u0012\u00020\t\u0012\b\u0012\u00060\nj\u0002`\u000b\u0012\u0004\u0012\u00020\f0\bj\u0002`\r\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u001c\u0010\u0013\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0006\b\u0001\u0012\u00028\u00000\u00120\u0011¢\u0006\u0004\b\u0014\u0010\u001bJ\u001f\u0010\u001f\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u001f\u0010 J'\u0010#\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\u000fH\u0016¢\u0006\u0004\b#\u0010$J\r\u0010%\u001a\u00020\f¢\u0006\u0004\b%\u0010&J\u0013\u0010(\u001a\u00020'*\u00020\u000fH\u0002¢\u0006\u0004\b(\u0010)J'\u0010.\u001a\u00020-2\u0006\u0010*\u001a\u00020\u000f2\u0006\u0010+\u001a\u00020\u000f2\u0006\u0010,\u001a\u00020'H\u0002¢\u0006\u0004\b.\u0010/J\u0013\u00100\u001a\u00020'*\u00020\u000fH\u0002¢\u0006\u0004\b0\u0010)J\u0013\u00101\u001a\u00020\u000f*\u00020\u000fH\u0002¢\u0006\u0004\b1\u00102J\u0017\u00104\u001a\u00020\f2\u0006\u00103\u001a\u00020\u000fH\u0002¢\u0006\u0004\b4\u00105R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u00106R\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u00107R\u0016\u0010:\u001a\u0002088\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b1\u00109R\u0016\u0010<\u001a\u00020-8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b(\u0010;R\u0016\u0010=\u001a\u00020\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b0\u00107R\u0016\u0010>\u001a\u00020\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b4\u00107R<\u0010\u0013\u001a*\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030A0@\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0006\b\u0001\u0012\u00028\u00000\u00120?8\u0002X\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000D8\u0002X\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\u0014\u0010J\u001a\u00020G8\u0002X\u0004¢\u0006\u0006\n\u0004\bH\u0010I¨\u0006M"}, d2 = {"Lcom/airbnb/epoxy/preload/EpoxyPreloader;", "Lcom/airbnb/epoxy/preload/PreloadRequestHolder;", "P", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Lcom/airbnb/epoxy/BaseEpoxyAdapter;", "adapter", "Lkotlin/Function0;", "preloadTargetFactory", "Lkotlin/Function2;", "Landroid/content/Context;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "", "Lcom/airbnb/epoxy/preload/PreloadErrorHandler;", "errorHandler", "", "maxItemsToPreload", "", "Lcom/airbnb/epoxy/preload/EpoxyModelPreloader;", "modelPreloaders", "<init>", "(Lcom/airbnb/epoxy/BaseEpoxyAdapter;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;ILjava/util/List;)V", "Lcom/airbnb/epoxy/EpoxyController;", "epoxyController", "requestHolderFactory", "(Lcom/airbnb/epoxy/EpoxyController;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;ILjava/util/List;)V", "Lcom/airbnb/epoxy/EpoxyAdapter;", "(Lcom/airbnb/epoxy/EpoxyAdapter;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;ILjava/util/List;)V", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "newState", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", "dx", "dy", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", "b", "()V", "", "d", "(I)Z", "firstVisiblePosition", "lastVisiblePosition", "isIncreasing", "Lkotlin/ranges/IntProgression;", "a", "(IIZ)Lkotlin/ranges/IntProgression;", "e", "c", "(I)I", "position", "f", "(I)V", "Lcom/airbnb/epoxy/BaseEpoxyAdapter;", "I", "Lkotlin/ranges/IntRange;", "Lkotlin/ranges/IntRange;", "lastVisibleRange", "Lkotlin/ranges/IntProgression;", "lastPreloadRange", "totalItemCount", "scrollState", "", "Ljava/lang/Class;", "Lcom/airbnb/epoxy/EpoxyModel;", "g", "Ljava/util/Map;", "Lcom/airbnb/epoxy/preload/PreloadTargetProvider;", "h", "Lcom/airbnb/epoxy/preload/PreloadTargetProvider;", "Lcom/airbnb/epoxy/preload/PreloadableViewDataProvider;", "i", "Lcom/airbnb/epoxy/preload/PreloadableViewDataProvider;", "viewDataCache", "j", "Companion", "epoxy-adapter_release"}, k = 1, mv = {1, 8, 0})
public final class EpoxyPreloader<P extends PreloadRequestHolder> extends RecyclerView.OnScrollListener {
    public static final Companion j = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final BaseEpoxyAdapter f2326a;
    public final int b;
    public IntRange c;
    public IntProgression d;
    public int e;
    public int f;
    public final Map g;
    public final PreloadTargetProvider h;
    public final PreloadableViewDataProvider i;

    @Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0001\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00010\u0018\"\b\b\u0001\u0010\u0005*\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\b2 \u0010\u0010\u001a\u001c\u0012\u0004\u0012\u00020\u000b\u0012\b\u0012\u00060\fj\u0002`\r\u0012\u0004\u0012\u00020\u000e0\nj\u0002`\u000f2\u0006\u0010\u0012\u001a\u00020\u00112*\u0010\u0017\u001a&\u0012\"\u0012 \u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u0015\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0016\u0012\u0006\b\u0001\u0012\u00028\u00010\u00140\u0013¢\u0006\u0004\b\u0019\u0010\u001aJ\u0001\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00010\u0018\"\b\b\u0001\u0010\u0005*\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\b2 \u0010\u0010\u001a\u001c\u0012\u0004\u0012\u00020\u000b\u0012\b\u0012\u00060\fj\u0002`\r\u0012\u0004\u0012\u00020\u000e0\nj\u0002`\u000f2\u0006\u0010\u0012\u001a\u00020\u00112*\u0010\u0017\u001a&\u0012\"\u0012 \u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u0015\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0016\u0012\u0006\b\u0001\u0012\u00028\u00010\u00140\u0013¢\u0006\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\u00020\u00118\u0002XT¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lcom/airbnb/epoxy/preload/EpoxyPreloader$Companion;", "", "<init>", "()V", "Lcom/airbnb/epoxy/preload/PreloadRequestHolder;", "P", "Lcom/airbnb/epoxy/EpoxyController;", "epoxyController", "Lkotlin/Function0;", "requestHolderFactory", "Lkotlin/Function2;", "Landroid/content/Context;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "", "Lcom/airbnb/epoxy/preload/PreloadErrorHandler;", "errorHandler", "", "maxItemsToPreload", "", "Lcom/airbnb/epoxy/preload/EpoxyModelPreloader;", "Lcom/airbnb/epoxy/EpoxyModel;", "Lcom/airbnb/epoxy/preload/ViewMetadata;", "modelPreloaders", "Lcom/airbnb/epoxy/preload/EpoxyPreloader;", "b", "(Lcom/airbnb/epoxy/EpoxyController;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;ILjava/util/List;)Lcom/airbnb/epoxy/preload/EpoxyPreloader;", "Lcom/airbnb/epoxy/EpoxyAdapter;", "epoxyAdapter", "a", "(Lcom/airbnb/epoxy/EpoxyAdapter;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;ILjava/util/List;)Lcom/airbnb/epoxy/preload/EpoxyPreloader;", "FLING_THRESHOLD_PX", "I", "epoxy-adapter_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final EpoxyPreloader a(EpoxyAdapter epoxyAdapter, Function0 function0, Function2 function2, int i, List list) {
            Intrinsics.checkNotNullParameter(epoxyAdapter, "epoxyAdapter");
            Intrinsics.checkNotNullParameter(function0, "requestHolderFactory");
            Intrinsics.checkNotNullParameter(function2, "errorHandler");
            Intrinsics.checkNotNullParameter(list, "modelPreloaders");
            return new EpoxyPreloader(epoxyAdapter, function0, function2, i, list);
        }

        public final EpoxyPreloader b(EpoxyController epoxyController, Function0 function0, Function2 function2, int i, List list) {
            Intrinsics.checkNotNullParameter(epoxyController, "epoxyController");
            Intrinsics.checkNotNullParameter(function0, "requestHolderFactory");
            Intrinsics.checkNotNullParameter(function2, "errorHandler");
            Intrinsics.checkNotNullParameter(list, "modelPreloaders");
            return new EpoxyPreloader(epoxyController, function0, function2, i, list);
        }

        public Companion() {
        }
    }

    public EpoxyPreloader(BaseEpoxyAdapter baseEpoxyAdapter, Function0 function0, Function2 function2, int i2, List list) {
        this.f2326a = baseEpoxyAdapter;
        this.b = i2;
        IntRange.Companion companion = IntRange.Companion;
        this.c = companion.getEMPTY();
        this.d = companion.getEMPTY();
        this.e = -1;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list, 10)), 16));
        for (Object next : list) {
            linkedHashMap.put(((EpoxyModelPreloader) next).b(), next);
        }
        this.g = linkedHashMap;
        this.h = new PreloadTargetProvider(this.b, function0);
        this.i = new PreloadableViewDataProvider(this.f2326a, function2);
        if (this.b <= 0) {
            throw new IllegalArgumentException(("maxItemsToPreload must be greater than 0. Was " + this.b).toString());
        }
    }

    public final IntProgression a(int i2, int i3, boolean z) {
        int i4 = 1;
        int i5 = z ? i3 + 1 : i2 - 1;
        int i6 = this.b;
        int i7 = (z ? i6 - 1 : 1 - i6) + i5;
        IntProgression.Companion companion = IntProgression.Companion;
        int c2 = c(i5);
        int c3 = c(i7);
        if (!z) {
            i4 = -1;
        }
        return companion.fromClosedRange(c2, c3, i4);
    }

    public final void b() {
        this.h.a();
    }

    public final int c(int i2) {
        return Math.min(this.e - 1, Math.max(i2, 0));
    }

    public final boolean d(int i2) {
        return Math.abs(i2) > 75;
    }

    public final boolean e(int i2) {
        return i2 == -1 || i2 >= this.e;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: com.airbnb.epoxy.preload.EpoxyModelPreloader} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void f(int r5) {
        /*
            r4 = this;
            com.airbnb.epoxy.BaseEpoxyAdapter r0 = r4.f2326a
            com.airbnb.epoxy.EpoxyModel r0 = com.airbnb.epoxy.InternalExposerKt.b(r0, r5)
            boolean r1 = r0 instanceof com.airbnb.epoxy.EpoxyModel
            r2 = 0
            if (r1 == 0) goto L_0x000c
            goto L_0x000d
        L_0x000c:
            r0 = r2
        L_0x000d:
            if (r0 != 0) goto L_0x0010
            return
        L_0x0010:
            java.util.Map r1 = r4.g
            java.lang.Class r3 = r0.getClass()
            java.lang.Object r1 = r1.get(r3)
            boolean r3 = r1 instanceof com.airbnb.epoxy.preload.EpoxyModelPreloader
            if (r3 == 0) goto L_0x0021
            r2 = r1
            com.airbnb.epoxy.preload.EpoxyModelPreloader r2 = (com.airbnb.epoxy.preload.EpoxyModelPreloader) r2
        L_0x0021:
            if (r2 != 0) goto L_0x0024
            return
        L_0x0024:
            com.airbnb.epoxy.preload.PreloadableViewDataProvider r1 = r4.i
            java.util.List r5 = r1.c(r2, r0, r5)
            java.util.Iterator r5 = r5.iterator()
        L_0x002e:
            boolean r1 = r5.hasNext()
            if (r1 == 0) goto L_0x0044
            java.lang.Object r1 = r5.next()
            com.airbnb.epoxy.preload.ViewData r1 = (com.airbnb.epoxy.preload.ViewData) r1
            com.airbnb.epoxy.preload.PreloadTargetProvider r3 = r4.h
            com.airbnb.epoxy.preload.PreloadRequestHolder r3 = r3.b()
            r2.d(r0, r3, r1)
            goto L_0x002e
        L_0x0044:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.epoxy.preload.EpoxyPreloader.f(int):void");
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        this.f = i2;
    }

    public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        if (!(i2 == 0 && i3 == 0) && !d(i2) && !d(i3)) {
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            boolean z = false;
            this.e = adapter != null ? adapter.getItemCount() : 0;
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
            int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
            if (e(findFirstVisibleItemPosition) || e(findLastVisibleItemPosition)) {
                IntRange.Companion companion = IntRange.Companion;
                this.c = companion.getEMPTY();
                this.d = companion.getEMPTY();
                return;
            }
            IntRange intRange = new IntRange(findFirstVisibleItemPosition, findLastVisibleItemPosition);
            if (!Intrinsics.areEqual((Object) intRange, (Object) this.c)) {
                if (intRange.getFirst() > this.c.getFirst() || intRange.getLast() > this.c.getLast()) {
                    z = true;
                }
                IntProgression a2 = a(findFirstVisibleItemPosition, findLastVisibleItemPosition, z);
                for (Number intValue : CollectionsKt.subtract(a2, this.d)) {
                    f(intValue.intValue());
                }
                this.c = intRange;
                this.d = a2;
            }
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public EpoxyPreloader(com.airbnb.epoxy.EpoxyController r8, kotlin.jvm.functions.Function0 r9, kotlin.jvm.functions.Function2 r10, int r11, java.util.List r12) {
        /*
            r7 = this;
            java.lang.String r0 = "epoxyController"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "requestHolderFactory"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "errorHandler"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "modelPreloaders"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            com.airbnb.epoxy.EpoxyControllerAdapter r2 = r8.getAdapter()
            java.lang.String r8 = "epoxyController.adapter"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r8)
            r1 = r7
            r3 = r9
            r4 = r10
            r5 = r11
            r6 = r12
            r1.<init>((com.airbnb.epoxy.BaseEpoxyAdapter) r2, (kotlin.jvm.functions.Function0) r3, (kotlin.jvm.functions.Function2) r4, (int) r5, (java.util.List) r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.epoxy.preload.EpoxyPreloader.<init>(com.airbnb.epoxy.EpoxyController, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function2, int, java.util.List):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public EpoxyPreloader(EpoxyAdapter epoxyAdapter, Function0 function0, Function2 function2, int i2, List list) {
        this((BaseEpoxyAdapter) epoxyAdapter, function0, function2, i2, list);
        Intrinsics.checkNotNullParameter(epoxyAdapter, "adapter");
        Intrinsics.checkNotNullParameter(function0, "requestHolderFactory");
        Intrinsics.checkNotNullParameter(function2, "errorHandler");
        Intrinsics.checkNotNullParameter(list, "modelPreloaders");
    }
}
