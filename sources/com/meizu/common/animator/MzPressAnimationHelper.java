package com.meizu.common.animator;

import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.FloatRange;
import androidx.annotation.RequiresApi;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.FloatValueHolder;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import com.google.android.material.shape.Shapeable;
import java.util.ArrayList;
import java.util.List;

public class MzPressAnimationHelper {
    private static final float DAMPING = 0.9f;
    private static final float SCALE_FROM = 1.0f;
    private static final float SCALE_TO = 0.9f;
    private static final float SPRING_ANIMATION_FLOAT_TO_INT_PROP = 100.0f;
    private static final float STIFFNESS = 250.0f;
    private float mScaleTo = 0.9f;
    /* access modifiers changed from: private */
    public View mTargetView;
    /* access modifiers changed from: private */
    public boolean mUseHardwareLayer;
    private final List<SpringAnimationInfo> spaInfoList = new ArrayList();

    public static class SpringAnimationInfo {
        public Drawable drawable;
        public SpringAnimation springAnimationX;
        public SpringAnimation springAnimationY;
        public View view;

        private SpringAnimationInfo() {
        }
    }

    /* access modifiers changed from: private */
    public void doScale(MotionEvent motionEvent, SpringAnimation springAnimation, SpringAnimation springAnimation2) {
        int action = motionEvent.getAction();
        if (action == 0) {
            springAnimation.v().e(this.mScaleTo);
            springAnimation2.v().e(this.mScaleTo);
            if (this.mTargetView.getLayerType() != 2 && this.mUseHardwareLayer) {
                this.mTargetView.setLayerType(2, (Paint) null);
            }
            startAnimationInMainThread(springAnimation, springAnimation2);
        } else if (action == 1 || action == 3) {
            springAnimation.v().e(1.0f);
            springAnimation2.v().e(1.0f);
            if (this.mTargetView.getLayerType() != 2 && this.mUseHardwareLayer) {
                this.mTargetView.setLayerType(2, (Paint) null);
            }
            startAnimationInMainThread(springAnimation, springAnimation2);
        }
    }

    private void startAnimationInMainThread(final SpringAnimation springAnimation, final SpringAnimation springAnimation2) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public void run() {
                SpringAnimation springAnimation = springAnimation;
                if (springAnimation != null) {
                    springAnimation.q();
                }
                SpringAnimation springAnimation2 = springAnimation2;
                if (springAnimation2 != null) {
                    springAnimation2.q();
                }
            }
        });
    }

    @RequiresApi
    private void tryToRemovePressColor(View view) {
        Drawable background = view.getBackground();
        if (background instanceof StateListDrawable) {
            StateListDrawable stateListDrawable = (StateListDrawable) background;
            int stateCount = stateListDrawable.getStateCount();
            int i = 0;
            for (int i2 = 0; i2 < stateCount; i2++) {
                int[] stateSet = stateListDrawable.getStateSet(i2);
                if (stateSet == null || stateSet.length == 0) {
                    Drawable stateDrawable = stateListDrawable.getStateDrawable(i2);
                    if (stateDrawable instanceof GradientDrawable) {
                        GradientDrawable gradientDrawable = (GradientDrawable) stateDrawable;
                        if (i == 0) {
                            i = gradientDrawable.getColor().getDefaultColor();
                        }
                    }
                }
            }
            if (i != 0) {
                for (int i3 = 0; i3 < stateCount; i3++) {
                    int[] stateSet2 = stateListDrawable.getStateSet(i3);
                    if (!(stateSet2 == null || stateSet2.length == 0)) {
                        for (int i4 : stateSet2) {
                            if (i4 == 16842919) {
                                Drawable stateDrawable2 = stateListDrawable.getStateDrawable(i3);
                                if (stateDrawable2 instanceof GradientDrawable) {
                                    ((GradientDrawable) stateDrawable2).setColor(i);
                                }
                            }
                        }
                    }
                }
            }
        } else if (background instanceof RippleDrawable) {
            ((RippleDrawable) background).setColor(ColorStateList.valueOf(0));
        }
    }

    private boolean useHardwareLayer(View view) {
        return !(view instanceof Shapeable);
    }

    public void addTargetDrawable(Drawable drawable) {
        SpringAnimation y = new SpringAnimation(new FloatValueHolder()).y(new SpringForce().d(0.9f).f(STIFFNESS));
        y.n(SPRING_ANIMATION_FLOAT_TO_INT_PROP);
        Rect bounds = drawable.getBounds();
        final float exactCenterX = bounds.exactCenterX();
        final float exactCenterY = bounds.exactCenterY();
        final int height = bounds.height();
        final int width = bounds.width();
        final Drawable drawable2 = drawable;
        y.c(new DynamicAnimation.OnAnimationUpdateListener() {
            public void onAnimationUpdate(DynamicAnimation dynamicAnimation, float f, float f2) {
                float f3 = f / MzPressAnimationHelper.SPRING_ANIMATION_FLOAT_TO_INT_PROP;
                drawable2.setBounds(Math.round(exactCenterX - ((((float) width) / 2.0f) * f3)), Math.round(exactCenterY - ((((float) height) / 2.0f) * f3)), Math.round(exactCenterX + ((((float) width) / 2.0f) * f3)), Math.round(exactCenterY + ((((float) height) / 2.0f) * f3)));
            }
        });
        SpringAnimationInfo springAnimationInfo = new SpringAnimationInfo();
        springAnimationInfo.drawable = drawable;
        springAnimationInfo.springAnimationX = y;
        this.spaInfoList.add(springAnimationInfo);
    }

    public void addTargetView(View view, boolean z) {
        if (view != null) {
            this.mTargetView = view;
            SpringForce f = new SpringForce().d(0.9f).f(STIFFNESS);
            final SpringAnimation y = new SpringAnimation(view, DynamicAnimation.p).y(f);
            final SpringAnimation y2 = new SpringAnimation(view, DynamicAnimation.q).y(f);
            if (!view.isClickable()) {
                view.setClickable(true);
            }
            tryToRemovePressColor(view);
            this.mUseHardwareLayer = useHardwareLayer(view);
            if (z) {
                SpringAnimationInfo springAnimationInfo = new SpringAnimationInfo();
                springAnimationInfo.view = view;
                springAnimationInfo.springAnimationX = y;
                springAnimationInfo.springAnimationY = y2;
                this.spaInfoList.add(springAnimationInfo);
            } else {
                view.setOnTouchListener(new View.OnTouchListener() {
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        MzPressAnimationHelper.this.doScale(motionEvent, y, y2);
                        return false;
                    }
                });
            }
            y.b(new DynamicAnimation.OnAnimationEndListener() {
                public void onAnimationEnd(DynamicAnimation dynamicAnimation, boolean z, float f, float f2) {
                    if (MzPressAnimationHelper.this.mTargetView.getLayerType() == 2 && MzPressAnimationHelper.this.mUseHardwareLayer) {
                        MzPressAnimationHelper.this.mTargetView.setLayerType(0, (Paint) null);
                    }
                }
            });
        }
    }

    public void changeDrawableState(Drawable drawable, boolean z) {
        for (SpringAnimationInfo next : this.spaInfoList) {
            if (drawable == next.drawable) {
                SpringAnimation springAnimation = next.springAnimationX;
                if (z) {
                    springAnimation.v().e(90.0f);
                    startAnimationInMainThread(springAnimation, (SpringAnimation) null);
                } else {
                    springAnimation.v().e(SPRING_ANIMATION_FLOAT_TO_INT_PROP);
                    startAnimationInMainThread(springAnimation, (SpringAnimation) null);
                }
            }
        }
    }

    public void handleCustomTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 || motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            for (SpringAnimationInfo next : this.spaInfoList) {
                if (view == next.view) {
                    doScale(motionEvent, next.springAnimationX, next.springAnimationY);
                }
            }
        }
    }

    public void setScaleTo(@FloatRange float f) {
        this.mScaleTo = f;
    }
}
