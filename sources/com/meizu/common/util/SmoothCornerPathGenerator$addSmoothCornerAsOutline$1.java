package com.meizu.common.util;

import android.graphics.Outline;
import android.graphics.Path;
import android.os.Build;
import android.view.View;
import android.view.ViewOutlineProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/meizu/common/util/SmoothCornerPathGenerator$addSmoothCornerAsOutline$1", "Landroid/view/ViewOutlineProvider;", "getOutline", "", "view", "Landroid/view/View;", "outline", "Landroid/graphics/Outline;", "MeizuCommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SmoothCornerPathGenerator$addSmoothCornerAsOutline$1 extends ViewOutlineProvider {
    final /* synthetic */ float $radius;
    final /* synthetic */ float $smoothness;
    final /* synthetic */ View $this_addSmoothCornerAsOutline;
    final /* synthetic */ boolean $useNativeRoundCornerWhileParamsInvalid;

    public SmoothCornerPathGenerator$addSmoothCornerAsOutline$1(View view, float f, float f2, boolean z) {
        this.$this_addSmoothCornerAsOutline = view;
        this.$smoothness = f;
        this.$radius = f2;
        this.$useNativeRoundCornerWhileParamsInvalid = z;
    }

    public void getOutline(@NotNull View view, @NotNull Outline outline) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(outline, "outline");
        Path genSmoothCornerPath = SmoothCornerPathGenerator.genSmoothCornerPath(0.0f, 0.0f, (float) view.getWidth(), (float) view.getHeight(), this.$smoothness, RangesKt.coerceIn(this.$radius, 0.0f, SmoothCornerPathGenerator.INSTANCE.getSmoothnessRadiusLimit((float) this.$this_addSmoothCornerAsOutline.getWidth(), (float) this.$this_addSmoothCornerAsOutline.getHeight(), this.$smoothness)), this.$useNativeRoundCornerWhileParamsInvalid);
        if (Build.VERSION.SDK_INT >= 30) {
            outline.setPath(genSmoothCornerPath);
        } else {
            outline.setConvexPath(genSmoothCornerPath);
        }
    }
}
