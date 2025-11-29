package com.meizu.common.widget;

import android.graphics.Outline;
import android.os.Build;
import android.view.View;
import android.view.ViewOutlineProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/meizu/common/widget/SmoothCornerView$renderMode$1", "Landroid/view/ViewOutlineProvider;", "getOutline", "", "view", "Landroid/view/View;", "outline", "Landroid/graphics/Outline;", "MeizuCommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SmoothCornerView$renderMode$1 extends ViewOutlineProvider {
    final /* synthetic */ SmoothCornerView this$0;

    public SmoothCornerView$renderMode$1(SmoothCornerView smoothCornerView) {
        this.this$0 = smoothCornerView;
    }

    public void getOutline(@NotNull View view, @NotNull Outline outline) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(outline, "outline");
        SmoothCornerView.trySmoothPath$default(this.this$0, false, 1, (Object) null);
        if (Build.VERSION.SDK_INT >= 30) {
            outline.setPath(this.this$0.path);
        } else if (this.this$0.path.isConvex()) {
            outline.setConvexPath(this.this$0.path);
        } else {
            outline.setRect(0, 0, view.getWidth(), view.getHeight());
        }
    }
}
