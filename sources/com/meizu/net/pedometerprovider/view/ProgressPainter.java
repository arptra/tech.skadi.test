package com.meizu.net.pedometerprovider.view;

public interface ProgressPainter extends Painter {
    void setMax(float f);

    void setMin(float f);

    void setValue(float f);
}
