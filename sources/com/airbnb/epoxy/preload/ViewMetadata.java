package com.airbnb.epoxy.preload;

import android.view.View;
import android.widget.ImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/airbnb/epoxy/preload/ViewMetadata;", "", "a", "Companion", "epoxy-adapter_release"}, k = 1, mv = {1, 8, 0})
public interface ViewMetadata {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f2331a = Companion.f2332a;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/airbnb/epoxy/preload/ViewMetadata$Companion;", "", "<init>", "()V", "Landroid/view/View;", "view", "Lcom/airbnb/epoxy/preload/ViewMetadata;", "a", "(Landroid/view/View;)Lcom/airbnb/epoxy/preload/ViewMetadata;", "epoxy-adapter_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ Companion f2332a = new Companion();

        public final ViewMetadata a(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            if (!(view instanceof ImageView)) {
                return null;
            }
            ImageView.ScaleType scaleType = ((ImageView) view).getScaleType();
            Intrinsics.checkNotNullExpressionValue(scaleType, "view.scaleType");
            return new ImageViewMetadata(scaleType);
        }
    }
}
