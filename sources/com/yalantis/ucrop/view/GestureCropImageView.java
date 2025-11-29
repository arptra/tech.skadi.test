package com.yalantis.ucrop.view;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import com.yalantis.ucrop.util.RotationGestureDetector;

public class GestureCropImageView extends CropImageView {
    public ScaleGestureDetector D;
    public RotationGestureDetector E;
    public GestureDetector F;
    public float G;
    public float H;
    public boolean I;
    public boolean J;
    public boolean K;
    public int L;

    public class GestureListener extends GestureDetector.SimpleOnGestureListener {
        public GestureListener() {
        }

        public boolean onDoubleTap(MotionEvent motionEvent) {
            GestureCropImageView gestureCropImageView = GestureCropImageView.this;
            gestureCropImageView.z(gestureCropImageView.getDoubleTapTargetScale(), motionEvent.getX(), motionEvent.getY(), 200);
            return super.onDoubleTap(motionEvent);
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            GestureCropImageView.this.h(-f, -f2);
            return true;
        }
    }

    public class RotateListener extends RotationGestureDetector.SimpleOnRotationGestureListener {
        public RotateListener() {
        }

        public boolean a(RotationGestureDetector rotationGestureDetector) {
            GestureCropImageView.this.f(rotationGestureDetector.c(), GestureCropImageView.this.G, GestureCropImageView.this.H);
            return true;
        }
    }

    public class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        public ScaleListener() {
        }

        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            GestureCropImageView.this.g(scaleGestureDetector.getScaleFactor(), GestureCropImageView.this.G, GestureCropImageView.this.H);
            return true;
        }
    }

    public GestureCropImageView(Context context) {
        super(context);
        this.I = true;
        this.J = true;
        this.K = true;
        this.L = 5;
    }

    public final void G() {
        this.F = new GestureDetector(getContext(), new GestureListener(), (Handler) null, true);
        this.D = new ScaleGestureDetector(getContext(), new ScaleListener());
        this.E = new RotationGestureDetector(new RotateListener());
    }

    public void d() {
        super.d();
        G();
    }

    public int getDoubleTapScaleSteps() {
        return this.L;
    }

    public float getDoubleTapTargetScale() {
        return getCurrentScale() * ((float) Math.pow((double) (getMaxScale() / getMinScale()), (double) (1.0f / ((float) this.L))));
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() & 255) == 0) {
            r();
        }
        if (motionEvent.getPointerCount() > 1) {
            this.G = (motionEvent.getX(0) + motionEvent.getX(1)) / 2.0f;
            this.H = (motionEvent.getY(0) + motionEvent.getY(1)) / 2.0f;
        }
        if (this.K) {
            this.F.onTouchEvent(motionEvent);
        }
        if (this.J) {
            this.D.onTouchEvent(motionEvent);
        }
        if (this.I) {
            this.E.d(motionEvent);
        }
        if ((motionEvent.getAction() & 255) == 1) {
            x();
        }
        return true;
    }

    public void setDoubleTapScaleSteps(int i) {
        this.L = i;
    }

    public void setGestureEnabled(boolean z) {
        this.K = z;
    }

    public void setRotateEnabled(boolean z) {
        this.I = z;
    }

    public void setScaleEnabled(boolean z) {
        this.J = z;
    }

    public GestureCropImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GestureCropImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.I = true;
        this.J = true;
        this.K = true;
        this.L = 5;
    }
}
