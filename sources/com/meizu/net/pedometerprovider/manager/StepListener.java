package com.meizu.net.pedometerprovider.manager;

public interface StepListener {
    public static final int LISTENER_TYPE_MAINSCREEN = 10012;
    public static final int LISTENER_TYPE_SUBSCREEN = 10011;
    public static final int LISTENER_TYPE_WIDGET = 10010;

    int getType();

    void onStepChanged(int i);
}
