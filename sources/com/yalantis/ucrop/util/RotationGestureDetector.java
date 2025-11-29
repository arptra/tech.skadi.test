package com.yalantis.ucrop.util;

import android.view.MotionEvent;

public class RotationGestureDetector {

    /* renamed from: a  reason: collision with root package name */
    public float f8756a;
    public float b;
    public float c;
    public float d;
    public int e = -1;
    public int f = -1;
    public float g;
    public boolean h;
    public OnRotationGestureListener i;

    public interface OnRotationGestureListener {
        boolean a(RotationGestureDetector rotationGestureDetector);
    }

    public static class SimpleOnRotationGestureListener implements OnRotationGestureListener {
        public boolean a(RotationGestureDetector rotationGestureDetector) {
            return false;
        }
    }

    public RotationGestureDetector(OnRotationGestureListener onRotationGestureListener) {
        this.i = onRotationGestureListener;
    }

    public final float a(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        return b((float) Math.toDegrees((double) ((float) Math.atan2((double) (f3 - f5), (double) (f2 - f4)))), (float) Math.toDegrees((double) ((float) Math.atan2((double) (f7 - f9), (double) (f6 - f8)))));
    }

    public final float b(float f2, float f3) {
        float f4 = (f3 % 360.0f) - (f2 % 360.0f);
        this.g = f4;
        if (f4 < -180.0f) {
            this.g = f4 + 360.0f;
        } else if (f4 > 180.0f) {
            this.g = f4 - 360.0f;
        }
        return this.g;
    }

    public float c() {
        return this.g;
    }

    public boolean d(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = motionEvent;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.c = motionEvent.getX();
            this.d = motionEvent.getY();
            this.e = motionEvent2.findPointerIndex(motionEvent2.getPointerId(0));
            this.g = 0.0f;
            this.h = true;
        } else if (actionMasked == 1) {
            this.e = -1;
        } else if (actionMasked != 2) {
            if (actionMasked == 5) {
                this.f8756a = motionEvent.getX();
                this.b = motionEvent.getY();
                this.f = motionEvent2.findPointerIndex(motionEvent2.getPointerId(motionEvent.getActionIndex()));
                this.g = 0.0f;
                this.h = true;
            } else if (actionMasked == 6) {
                this.f = -1;
            }
        } else if (!(this.e == -1 || this.f == -1 || motionEvent.getPointerCount() <= this.f)) {
            float x = motionEvent2.getX(this.e);
            float y = motionEvent2.getY(this.e);
            float x2 = motionEvent2.getX(this.f);
            float y2 = motionEvent2.getY(this.f);
            if (this.h) {
                this.g = 0.0f;
                this.h = false;
            } else {
                a(this.f8756a, this.b, this.c, this.d, x2, y2, x, y);
            }
            OnRotationGestureListener onRotationGestureListener = this.i;
            if (onRotationGestureListener != null) {
                onRotationGestureListener.a(this);
            }
            this.f8756a = x2;
            this.b = y2;
            this.c = x;
            this.d = y;
        }
        return true;
    }
}
