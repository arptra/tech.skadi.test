package com.upuphone.starrynet.api.hid;

import android.view.MotionEvent;

public interface ITouchPadWrapper {
    boolean onTouch(MotionEvent motionEvent);

    void sendBytes(byte[] bArr);

    void setTouchAreaSize(int i, int i2);
}
