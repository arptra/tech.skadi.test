package com.meizu.net.pedometerprovider.view;

import android.content.Context;
import android.util.AttributeSet;

public class SubDashedCircularProgress extends DashedCircularProgress {
    public SubDashedCircularProgress(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ProgressPainter getProgressPainter() {
        return new SubProgressPainterImp(this.progressColor, this.min, this.max, this.progressStrokeHeight);
    }

    public SubDashedCircularProgress(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
