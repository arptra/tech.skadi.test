package com.meizu.net.pedometerprovider.view;

public class SubProgressPainterImp extends ProgressPainterImp {
    public static final float MAX_ANGLE = 273.4f;

    public SubProgressPainterImp(int i, float f, float f2, int i2) {
        super(i, f, f2, i2);
        this.startAngle = 133.3f;
    }

    public void setValue(float f) {
        float f2 = (f * 273.4f) / this.max;
        this.plusAngle = f2;
        if (f2 > 273.4f) {
            this.plusAngle = 273.4f;
        }
    }
}
