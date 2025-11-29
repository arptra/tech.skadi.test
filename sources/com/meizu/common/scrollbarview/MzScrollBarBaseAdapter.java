package com.meizu.common.scrollbarview;

import com.meizu.common.scrollbarview.MzScrollBarView;

public class MzScrollBarBaseAdapter extends MzScrollBarView.Adapter {
    private static final int MIN_LENGTH_FACTOR = 2;

    public int getScrollBarVisibleFactor() {
        return 1;
    }

    public int getScrollDistanceByDraggingDelta(int i, int i2, int i3, int i4, int i5) {
        return Math.round((((float) i) * ((float) (i5 - i4))) / ((float) (i2 - i3)));
    }

    public int getThumbLength(int i, int i2, int i3, int i4, int i5) {
        int i6 = i2 * 2;
        float f = (float) i;
        int round = Math.round((((float) i3) * f) / ((float) i4));
        if (i5 != 0) {
            round = (int) (((float) round) * (1.0f - (((float) i5) / (f * 0.3f))));
        }
        return Math.max(round, i6);
    }

    public int getThumbOffset(int i, int i2, int i3, int i4, int i5, int i6) {
        int i7 = i - i2;
        int round = Math.round((((float) i7) * ((float) i5)) / ((float) (i4 - i3)));
        return round > i7 ? i7 : round;
    }
}
