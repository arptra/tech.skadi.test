package com.google.android.material.carousel;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.math.MathUtils;
import androidx.recyclerview.widget.RecyclerView;

public class HeroCarouselStrategy extends CarouselStrategy {
    private static final int[] MEDIUM_COUNTS = {0, 1};
    private static final int[] SMALL_COUNTS = {1};
    private int keylineCount = 0;

    @NonNull
    public KeylineState onFirstChildMeasuredWithMargins(@NonNull Carousel carousel, @NonNull View view) {
        int i;
        int containerHeight = carousel.getContainerHeight();
        if (carousel.isHorizontal()) {
            containerHeight = carousel.getContainerWidth();
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        float f = (float) (layoutParams.topMargin + layoutParams.bottomMargin);
        float measuredWidth = (float) (view.getMeasuredWidth() * 2);
        if (carousel.isHorizontal()) {
            f = (float) (layoutParams.leftMargin + layoutParams.rightMargin);
            measuredWidth = (float) (view.getMeasuredHeight() * 2);
        }
        float smallSizeMin = CarouselStrategyHelper.getSmallSizeMin(view.getContext()) + f;
        float smallSizeMax = CarouselStrategyHelper.getSmallSizeMax(view.getContext()) + f;
        float f2 = (float) containerHeight;
        float min = Math.min(measuredWidth + f, f2);
        float a2 = MathUtils.a((measuredWidth / 3.0f) + f, CarouselStrategyHelper.getSmallSizeMin(view.getContext()) + f, CarouselStrategyHelper.getSmallSizeMax(view.getContext()) + f);
        float f3 = (min + a2) / 2.0f;
        int[] iArr = SMALL_COUNTS;
        int[] iArr2 = f2 < 2.0f * smallSizeMin ? new int[]{0} : iArr;
        int max = (int) Math.max(1.0d, Math.floor((double) ((f2 - (((float) CarouselStrategyHelper.maxValue(iArr)) * smallSizeMax)) / min)));
        int ceil = (((int) Math.ceil((double) (f2 / min))) - max) + 1;
        int[] iArr3 = new int[ceil];
        for (int i2 = 0; i2 < ceil; i2++) {
            iArr3[i2] = max + i2;
        }
        int i3 = carousel.getCarouselAlignment() == 1 ? 1 : 0;
        int[] iArr4 = iArr3;
        Arrangement findLowestCostArrangement = Arrangement.findLowestCostArrangement(f2, a2, smallSizeMin, smallSizeMax, i3 != 0 ? CarouselStrategy.doubleCounts(iArr2) : iArr2, f3, i3 != 0 ? CarouselStrategy.doubleCounts(MEDIUM_COUNTS) : MEDIUM_COUNTS, min, iArr3);
        this.keylineCount = findLowestCostArrangement.getItemCount();
        if (findLowestCostArrangement.getItemCount() > carousel.getItemCount()) {
            findLowestCostArrangement = Arrangement.findLowestCostArrangement(f2, a2, smallSizeMin, smallSizeMax, iArr2, f3, MEDIUM_COUNTS, min, iArr4);
            i = 0;
        } else {
            i = i3;
        }
        return CarouselStrategyHelper.createKeylineState(view.getContext(), f, f2, findLowestCostArrangement, i);
    }

    public boolean shouldRefreshKeylineState(@NonNull Carousel carousel, int i) {
        if (carousel.getCarouselAlignment() == 1) {
            if (i >= this.keylineCount || carousel.getItemCount() < this.keylineCount) {
                return i >= this.keylineCount && carousel.getItemCount() < this.keylineCount;
            }
            return true;
        }
    }
}
