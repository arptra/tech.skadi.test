package com.airbnb.epoxy.preload;

import android.widget.ImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/airbnb/epoxy/preload/ImageViewMetadata;", "Lcom/airbnb/epoxy/preload/ViewMetadata;", "Landroid/widget/ImageView$ScaleType;", "scaleType", "<init>", "(Landroid/widget/ImageView$ScaleType;)V", "b", "Landroid/widget/ImageView$ScaleType;", "getScaleType", "()Landroid/widget/ImageView$ScaleType;", "epoxy-adapter_release"}, k = 1, mv = {1, 8, 0})
public class ImageViewMetadata implements ViewMetadata {
    public final ImageView.ScaleType b;

    public ImageViewMetadata(ImageView.ScaleType scaleType) {
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        this.b = scaleType;
    }
}
