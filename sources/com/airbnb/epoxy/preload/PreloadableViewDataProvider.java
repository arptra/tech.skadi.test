package com.airbnb.epoxy.preload;

import android.content.Context;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.airbnb.epoxy.BaseEpoxyAdapter;
import com.airbnb.epoxy.BoundViewHolders;
import com.airbnb.epoxy.EpoxyModel;
import com.airbnb.epoxy.EpoxyViewHolder;
import com.airbnb.epoxy.InternalExposerKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010%\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u00013B1\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012 \u0010\n\u001a\u001c\u0012\u0004\u0012\u00020\u0005\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b0\u0004j\u0002`\t¢\u0006\u0004\b\u000b\u0010\fJg\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00190\u0018\"\f\b\u0000\u0010\u000e*\u0006\u0012\u0002\b\u00030\r\"\n\b\u0001\u0010\u0010*\u0004\u0018\u00010\u000f\"\b\b\u0002\u0010\u0012*\u00020\u00112\u0018\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00132\u0006\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u001a\u0010\u001bJC\u0010\u001d\u001a\u00020\u001c\"\f\b\u0000\u0010\u000e*\u0006\u0012\u0002\b\u00030\r2\u0014\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00132\u0006\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJk\u0010 \u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0019\u0018\u00010\u0018\"\f\b\u0000\u0010\u000e*\u0006\u0012\u0002\b\u00030\r\"\n\b\u0001\u0010\u0010*\u0004\u0018\u00010\u000f\"\b\b\u0002\u0010\u0012*\u00020\u00112\u0018\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00132\u0006\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00020\u001cH\u0002¢\u0006\u0004\b \u0010!J=\u0010$\u001a\b\u0012\u0004\u0012\u00020\"0\u0018\"\f\b\u0000\u0010\u000e*\u0006\u0012\u0002\b\u00030\r*\u00020\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00160\u00182\u0006\u0010\u0015\u001a\u00028\u0000H\u0002¢\u0006\u0004\b$\u0010%J#\u0010&\u001a\b\u0012\u0004\u0012\u00020\"0\u0018\"\b\b\u0000\u0010\u000e*\u00020\"*\u00028\u0000H\u0002¢\u0006\u0004\b&\u0010'Ja\u0010(\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0019\"\f\b\u0000\u0010\u000e*\u0006\u0012\u0002\b\u00030\r\"\n\b\u0001\u0010\u0010*\u0004\u0018\u00010\u000f\"\b\b\u0002\u0010\u0012*\u00020\u0011*\u00020\"2\u0018\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00132\u0006\u0010\u0015\u001a\u00028\u0000H\u0002¢\u0006\u0004\b(\u0010)R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b(\u0010*\u001a\u0004\b+\u0010,R1\u0010\n\u001a\u001c\u0012\u0004\u0012\u00020\u0005\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b0\u0004j\u0002`\t8\u0006¢\u0006\f\n\u0004\b\u001d\u0010-\u001a\u0004\b.\u0010/R,\u00102\u001a\u001a\u0012\u0004\u0012\u00020\u001c\u0012\u0010\u0012\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0019\u0018\u00010\u0018008\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u00101¨\u00064"}, d2 = {"Lcom/airbnb/epoxy/preload/PreloadableViewDataProvider;", "", "Lcom/airbnb/epoxy/BaseEpoxyAdapter;", "adapter", "Lkotlin/Function2;", "Landroid/content/Context;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "", "Lcom/airbnb/epoxy/preload/PreloadErrorHandler;", "errorHandler", "<init>", "(Lcom/airbnb/epoxy/BaseEpoxyAdapter;Lkotlin/jvm/functions/Function2;)V", "Lcom/airbnb/epoxy/EpoxyModel;", "T", "Lcom/airbnb/epoxy/preload/ViewMetadata;", "U", "Lcom/airbnb/epoxy/preload/PreloadRequestHolder;", "P", "Lcom/airbnb/epoxy/preload/EpoxyModelPreloader;", "preloader", "epoxyModel", "", "position", "", "Lcom/airbnb/epoxy/preload/ViewData;", "c", "(Lcom/airbnb/epoxy/preload/EpoxyModelPreloader;Lcom/airbnb/epoxy/EpoxyModel;I)Ljava/util/List;", "Lcom/airbnb/epoxy/preload/PreloadableViewDataProvider$CacheKey;", "b", "(Lcom/airbnb/epoxy/preload/EpoxyModelPreloader;Lcom/airbnb/epoxy/EpoxyModel;I)Lcom/airbnb/epoxy/preload/PreloadableViewDataProvider$CacheKey;", "cacheKey", "d", "(Lcom/airbnb/epoxy/preload/EpoxyModelPreloader;Lcom/airbnb/epoxy/EpoxyModel;Lcom/airbnb/epoxy/preload/PreloadableViewDataProvider$CacheKey;)Ljava/util/List;", "Landroid/view/View;", "viewIds", "e", "(Landroid/view/View;Ljava/util/List;Lcom/airbnb/epoxy/EpoxyModel;)Ljava/util/List;", "f", "(Landroid/view/View;)Ljava/util/List;", "a", "(Landroid/view/View;Lcom/airbnb/epoxy/preload/EpoxyModelPreloader;Lcom/airbnb/epoxy/EpoxyModel;)Lcom/airbnb/epoxy/preload/ViewData;", "Lcom/airbnb/epoxy/BaseEpoxyAdapter;", "getAdapter", "()Lcom/airbnb/epoxy/BaseEpoxyAdapter;", "Lkotlin/jvm/functions/Function2;", "getErrorHandler", "()Lkotlin/jvm/functions/Function2;", "", "Ljava/util/Map;", "cache", "CacheKey", "epoxy-adapter_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nPreloadableViewDataProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PreloadableViewDataProvider.kt\ncom/airbnb/epoxy/preload/PreloadableViewDataProvider\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,160:1\n361#2,7:161\n1360#3:168\n1446#3,5:169\n1603#3,9:174\n1855#3:183\n1856#3:185\n1612#3:186\n1603#3,9:187\n1855#3:196\n1856#3:198\n1612#3:199\n1360#3:200\n1446#3,5:201\n1#4:184\n1#4:197\n*S KotlinDebug\n*F\n+ 1 PreloadableViewDataProvider.kt\ncom/airbnb/epoxy/preload/PreloadableViewDataProvider\n*L\n43#1:161,7\n111#1:168\n111#1:169,5\n112#1:174,9\n112#1:183\n112#1:185\n112#1:186\n120#1:187,9\n120#1:196\n120#1:198\n120#1:199\n130#1:200\n130#1:201,5\n112#1:184\n120#1:197\n*E\n"})
public final class PreloadableViewDataProvider {

    /* renamed from: a  reason: collision with root package name */
    public final BaseEpoxyAdapter f2328a;
    public final Function2 b;
    public final Map c = new LinkedHashMap();

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0010\b\b\u0018\u00002\u00020\u0001B5\u0012\u0012\u0010\u0004\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00030\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R#\u0010\u0004\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0019\u001a\u0004\b\u001c\u0010\u000fR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00018\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lcom/airbnb/epoxy/preload/PreloadableViewDataProvider$CacheKey;", "", "Ljava/lang/Class;", "Lcom/airbnb/epoxy/EpoxyModel;", "epoxyModelClass", "", "spanSize", "viewType", "signature", "<init>", "(Ljava/lang/Class;IILjava/lang/Object;)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/Class;", "getEpoxyModelClass", "()Ljava/lang/Class;", "b", "I", "getSpanSize", "c", "getViewType", "d", "Ljava/lang/Object;", "getSignature", "()Ljava/lang/Object;", "epoxy-adapter_release"}, k = 1, mv = {1, 8, 0})
    public static final class CacheKey {

        /* renamed from: a  reason: collision with root package name */
        public final Class f2329a;
        public final int b;
        public final int c;
        public final Object d;

        public CacheKey(Class cls, int i, int i2, Object obj) {
            Intrinsics.checkNotNullParameter(cls, "epoxyModelClass");
            this.f2329a = cls;
            this.b = i;
            this.c = i2;
            this.d = obj;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CacheKey)) {
                return false;
            }
            CacheKey cacheKey = (CacheKey) obj;
            return Intrinsics.areEqual((Object) this.f2329a, (Object) cacheKey.f2329a) && this.b == cacheKey.b && this.c == cacheKey.c && Intrinsics.areEqual(this.d, cacheKey.d);
        }

        public int hashCode() {
            int hashCode = ((((this.f2329a.hashCode() * 31) + Integer.hashCode(this.b)) * 31) + Integer.hashCode(this.c)) * 31;
            Object obj = this.d;
            return hashCode + (obj == null ? 0 : obj.hashCode());
        }

        public String toString() {
            return "CacheKey(epoxyModelClass=" + this.f2329a + ", spanSize=" + this.b + ", viewType=" + this.c + ", signature=" + this.d + ')';
        }
    }

    public PreloadableViewDataProvider(BaseEpoxyAdapter baseEpoxyAdapter, Function2 function2) {
        Intrinsics.checkNotNullParameter(baseEpoxyAdapter, "adapter");
        Intrinsics.checkNotNullParameter(function2, "errorHandler");
        this.f2328a = baseEpoxyAdapter;
        this.b = function2;
    }

    public final ViewData a(View view, EpoxyModelPreloader epoxyModelPreloader, EpoxyModel epoxyModel) {
        int width = (view.getWidth() - view.getPaddingLeft()) - view.getPaddingRight();
        int height = (view.getHeight() - view.getPaddingTop()) - view.getPaddingBottom();
        if (width > 0 && height > 0) {
            return new ViewData(view.getId(), width, height, epoxyModelPreloader.a(view));
        }
        Function2 function2 = this.b;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        function2.invoke(context, new EpoxyPreloadException(view.getClass().getSimpleName() + " in " + epoxyModel.getClass().getSimpleName() + " has zero size. A size must be set to allow preloading."));
        return null;
    }

    public final CacheKey b(EpoxyModelPreloader epoxyModelPreloader, EpoxyModel epoxyModel, int i) {
        return new CacheKey(epoxyModel.getClass(), this.f2328a.n() ? epoxyModel.Q(this.f2328a.l(), i, this.f2328a.getItemCount()) : 1, InternalExposerKt.d(epoxyModel), epoxyModelPreloader.e(epoxyModel));
    }

    public final List c(EpoxyModelPreloader epoxyModelPreloader, EpoxyModel epoxyModel, int i) {
        Intrinsics.checkNotNullParameter(epoxyModelPreloader, "preloader");
        Intrinsics.checkNotNullParameter(epoxyModel, "epoxyModel");
        CacheKey b2 = b(epoxyModelPreloader, epoxyModel, i);
        Map map = this.c;
        Object obj = map.get(b2);
        if (obj == null) {
            obj = d(epoxyModelPreloader, epoxyModel, b2);
            map.put(b2, obj);
        }
        List list = obj instanceof List ? (List) obj : null;
        return list == null ? CollectionsKt.emptyList() : list;
    }

    public final List d(EpoxyModelPreloader epoxyModelPreloader, EpoxyModel epoxyModel, CacheKey cacheKey) {
        Object obj;
        View view;
        BoundViewHolders a2 = InternalExposerKt.a(this.f2328a);
        Intrinsics.checkNotNullExpressionValue(a2, "adapter.boundViewHoldersInternal()");
        Iterator it = a2.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            EpoxyViewHolder epoxyViewHolder = (EpoxyViewHolder) obj;
            EpoxyModel d = epoxyViewHolder.d();
            if (d.getClass() == epoxyModel.getClass() && ViewCompat.V(epoxyViewHolder.itemView) && ViewCompat.W(epoxyViewHolder.itemView)) {
                Intrinsics.checkNotNull(d, "null cannot be cast to non-null type T of com.airbnb.epoxy.preload.PreloadableViewDataProvider.findViewData$lambda$1");
                if (Intrinsics.areEqual((Object) b(epoxyModelPreloader, d, epoxyViewHolder.getAdapterPosition()), (Object) cacheKey)) {
                    break;
                }
            }
        }
        EpoxyViewHolder epoxyViewHolder2 = (EpoxyViewHolder) obj;
        if (epoxyViewHolder2 == null || (view = epoxyViewHolder2.itemView) == null) {
            return null;
        }
        Object c2 = InternalExposerKt.c(epoxyViewHolder2);
        List<View> e = epoxyModelPreloader.c().isEmpty() ^ true ? e(view, epoxyModelPreloader.c(), epoxyModel) : view instanceof Preloadable ? ((Preloadable) view).a() : c2 instanceof Preloadable ? ((Preloadable) c2).a() : CollectionsKt.emptyList();
        if (e.isEmpty()) {
            Function2 function2 = this.b;
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "rootView.context");
            function2.invoke(context, new EpoxyPreloadException("No preloadable views were found in " + epoxyModel.getClass().getSimpleName()));
        }
        ArrayList<View> arrayList = new ArrayList<>();
        for (View f : e) {
            CollectionsKt.addAll(arrayList, f(f));
        }
        ArrayList arrayList2 = new ArrayList();
        for (View a3 : arrayList) {
            ViewData a4 = a(a3, epoxyModelPreloader, epoxyModel);
            if (a4 != null) {
                arrayList2.add(a4);
            }
        }
        return arrayList2;
    }

    public final List e(View view, List list, EpoxyModel epoxyModel) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            int intValue = ((Number) it.next()).intValue();
            View findViewById = view.findViewById(intValue);
            if (findViewById == null) {
                Function2 function2 = this.b;
                Context context = view.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                function2.invoke(context, new EpoxyPreloadException("View with id " + intValue + " in " + epoxyModel.getClass().getSimpleName() + " could not be found."));
            }
            if (findViewById != null) {
                arrayList.add(findViewById);
            }
        }
        return arrayList;
    }

    public final List f(View view) {
        if (!(view instanceof Preloadable)) {
            return CollectionsKt.listOf(view);
        }
        List<View> a2 = ((Preloadable) view).a();
        ArrayList arrayList = new ArrayList();
        for (View f : a2) {
            CollectionsKt.addAll(arrayList, f(f));
        }
        return arrayList;
    }
}
