package com.airbnb.epoxy.preload;

import android.view.View;
import com.airbnb.epoxy.EpoxyModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\n\u0018\u00002\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0001J\u0017\u0010\u0004\u001a\u00028\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\b\u0010\tJ-\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\n\u001a\u00028\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00010\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"com/airbnb/epoxy/preload/EpoxyModelPreloader$Companion$with$5", "Lcom/airbnb/epoxy/preload/EpoxyModelPreloader;", "Landroid/view/View;", "view", "a", "(Landroid/view/View;)Lcom/airbnb/epoxy/preload/ViewMetadata;", "epoxyModel", "", "e", "(Lcom/airbnb/epoxy/EpoxyModel;)Ljava/lang/Object;", "preloadTarget", "Lcom/airbnb/epoxy/preload/ViewData;", "viewData", "", "d", "(Lcom/airbnb/epoxy/EpoxyModel;Lcom/airbnb/epoxy/preload/PreloadRequestHolder;Lcom/airbnb/epoxy/preload/ViewData;)V", "epoxy-adapter_release"}, k = 1, mv = {1, 8, 0})
public final class EpoxyModelPreloader$Companion$with$5 extends EpoxyModelPreloader<EpoxyModel<?>, ViewMetadata, PreloadRequestHolder> {
    public final /* synthetic */ Function1 d;
    public final /* synthetic */ Function1 e;
    public final /* synthetic */ Function3 f;

    public ViewMetadata a(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return (ViewMetadata) this.d.invoke(view);
    }

    public void d(EpoxyModel epoxyModel, PreloadRequestHolder preloadRequestHolder, ViewData viewData) {
        Intrinsics.checkNotNullParameter(epoxyModel, "epoxyModel");
        Intrinsics.checkNotNullParameter(preloadRequestHolder, "preloadTarget");
        Intrinsics.checkNotNullParameter(viewData, "viewData");
        this.f.invoke(epoxyModel, preloadRequestHolder, viewData);
    }

    public Object e(EpoxyModel epoxyModel) {
        Intrinsics.checkNotNullParameter(epoxyModel, "epoxyModel");
        return this.e.invoke(epoxyModel);
    }
}
