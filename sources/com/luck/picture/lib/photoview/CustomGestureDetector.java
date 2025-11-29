package com.luck.picture.lib.photoview;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

class CustomGestureDetector {

    /* renamed from: a  reason: collision with root package name */
    public int f9441a = -1;
    public int b = 0;
    public final ScaleGestureDetector c;
    public VelocityTracker d;
    public boolean e;
    public float f;
    public float g;
    public final float h;
    public final float i;
    public OnGestureListener j;

    public CustomGestureDetector(Context context, OnGestureListener onGestureListener) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.i = (float) viewConfiguration.getScaledMinimumFlingVelocity();
        this.h = (float) viewConfiguration.getScaledTouchSlop();
        this.j = onGestureListener;
        this.c = new ScaleGestureDetector(context, new ScaleGestureDetector.OnScaleGestureListener() {

            /* renamed from: a  reason: collision with root package name */
            public float f9442a;
            public float b = 0.0f;

            public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (Float.isNaN(scaleFactor) || Float.isInfinite(scaleFactor)) {
                    return false;
                }
                if (scaleFactor < 0.0f) {
                    return true;
                }
                CustomGestureDetector.this.j.b(scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY(), scaleGestureDetector.getFocusX() - this.f9442a, scaleGestureDetector.getFocusY() - this.b);
                this.f9442a = scaleGestureDetector.getFocusX();
                this.b = scaleGestureDetector.getFocusY();
                return true;
            }

            public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
                this.f9442a = scaleGestureDetector.getFocusX();
                this.b = scaleGestureDetector.getFocusY();
                return true;
            }

            public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            }
        });
    }

    public final float b(MotionEvent motionEvent) {
        try {
            return motionEvent.getX(this.b);
        } catch (Exception unused) {
            return motionEvent.getX();
        }
    }

    public final float c(MotionEvent motionEvent) {
        try {
            return motionEvent.getY(this.b);
        } catch (Exception unused) {
            return motionEvent.getY();
        }
    }

    public boolean d() {
        return this.e;
    }

    public boolean e() {
        return this.c.isInProgress();
    }

    public boolean f(MotionEvent motionEvent) {
        try {
            this.c.onTouchEvent(motionEvent);
            return g(motionEvent);
        } catch (IllegalArgumentException unused) {
            return true;
        }
    }

    public final boolean g(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        int i2 = 0;
        if (action == 0) {
            this.f9441a = motionEvent.getPointerId(0);
            VelocityTracker obtain = VelocityTracker.obtain();
            this.d = obtain;
            if (obtain != null) {
                obtain.addMovement(motionEvent);
            }
            this.f = b(motionEvent);
            this.g = c(motionEvent);
            this.e = false;
        } else if (action == 1) {
            this.f9441a = -1;
            if (this.e && this.d != null) {
                this.f = b(motionEvent);
                this.g = c(motionEvent);
                this.d.addMovement(motionEvent);
                this.d.computeCurrentVelocity(1000);
                float xVelocity = this.d.getXVelocity();
                float yVelocity = this.d.getYVelocity();
                if (Math.max(Math.abs(xVelocity), Math.abs(yVelocity)) >= this.i) {
                    this.j.c(this.f, this.g, -xVelocity, -yVelocity);
                }
            }
            VelocityTracker velocityTracker = this.d;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.d = null;
            }
        } else if (action == 2) {
            float b2 = b(motionEvent);
            float c2 = c(motionEvent);
            float f2 = b2 - this.f;
            float f3 = c2 - this.g;
            if (!this.e) {
                this.e = Math.sqrt((double) ((f2 * f2) + (f3 * f3))) >= ((double) this.h);
            }
            if (this.e) {
                this.j.a(f2, f3);
                this.f = b2;
                this.g = c2;
                VelocityTracker velocityTracker2 = this.d;
                if (velocityTracker2 != null) {
                    velocityTracker2.addMovement(motionEvent);
                }
            }
        } else if (action == 3) {
            this.f9441a = -1;
            VelocityTracker velocityTracker3 = this.d;
            if (velocityTracker3 != null) {
                velocityTracker3.recycle();
                this.d = null;
            }
        } else if (action == 6) {
            int b3 = Util.b(motionEvent.getAction());
            if (motionEvent.getPointerId(b3) == this.f9441a) {
                int i3 = b3 == 0 ? 1 : 0;
                this.f9441a = motionEvent.getPointerId(i3);
                this.f = motionEvent.getX(i3);
                this.g = motionEvent.getY(i3);
            }
        }
        int i4 = this.f9441a;
        if (i4 != -1) {
            i2 = i4;
        }
        this.b = motionEvent.findPointerIndex(i2);
        return true;
    }
}
