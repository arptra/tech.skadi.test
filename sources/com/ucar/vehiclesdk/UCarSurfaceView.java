package com.ucar.vehiclesdk;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceView;
import com.easy.logger.EasyLog;

public class UCarSurfaceView extends SurfaceView {
    public UCarSurfaceView(Context context) {
        super(context);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        EasyLog.a("UCarSurfaceView", "onTouchEvent, action:" + motionEvent.getAction());
        int action = motionEvent.getAction();
        int pointerCount = motionEvent.getPointerCount();
        int[] iArr = new int[pointerCount];
        int[] iArr2 = new int[pointerCount];
        int[] iArr3 = new int[pointerCount];
        for (int i = 0; i < pointerCount; i++) {
            iArr[i] = motionEvent.getPointerId(i);
            iArr2[i] = (int) motionEvent.getX(motionEvent.findPointerIndex(motionEvent.getPointerId(i)));
            iArr3[i] = (int) motionEvent.getY(motionEvent.findPointerIndex(motionEvent.getPointerId(i)));
        }
        UCarAdapter.R0().n2(action, pointerCount, iArr, iArr2, iArr3);
        if (motionEvent.getAction() != 0) {
            return true;
        }
        performClick();
        return true;
    }

    public boolean performClick() {
        return super.performClick();
    }

    public UCarSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
