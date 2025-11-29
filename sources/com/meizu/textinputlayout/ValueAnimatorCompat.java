package com.meizu.textinputlayout;

import android.view.animation.Interpolator;

class ValueAnimatorCompat {
    private final Impl mImpl;

    public interface AnimatorListener {
        void onAnimationCancel(ValueAnimatorCompat valueAnimatorCompat);

        void onAnimationEnd(ValueAnimatorCompat valueAnimatorCompat);

        void onAnimationStart(ValueAnimatorCompat valueAnimatorCompat);
    }

    public static class AnimatorListenerAdapter implements AnimatorListener {
        public void onAnimationCancel(ValueAnimatorCompat valueAnimatorCompat) {
        }

        public void onAnimationEnd(ValueAnimatorCompat valueAnimatorCompat) {
        }

        public void onAnimationStart(ValueAnimatorCompat valueAnimatorCompat) {
        }
    }

    public interface AnimatorUpdateListener {
        void onAnimationUpdate(ValueAnimatorCompat valueAnimatorCompat);
    }

    public interface Creator {
        ValueAnimatorCompat createAnimator();
    }

    public static abstract class Impl {

        public interface AnimatorListenerProxy {
            void onAnimationCancel();

            void onAnimationEnd();

            void onAnimationStart();
        }

        public interface AnimatorUpdateListenerProxy {
            void onAnimationUpdate();
        }

        public abstract void cancel();

        public abstract void end();

        public abstract float getAnimatedFloatValue();

        public abstract float getAnimatedFraction();

        public abstract int getAnimatedIntValue();

        public abstract boolean isRunning();

        public abstract void setDuration(int i);

        public abstract void setFloatValues(float f, float f2);

        public abstract void setIntValues(int i, int i2);

        public abstract void setInterpolator(Interpolator interpolator);

        public abstract void setListener(AnimatorListenerProxy animatorListenerProxy);

        public abstract void setUpdateListener(AnimatorUpdateListenerProxy animatorUpdateListenerProxy);

        public abstract void start();
    }

    public ValueAnimatorCompat(Impl impl) {
        this.mImpl = impl;
    }

    public void cancel() {
        this.mImpl.cancel();
    }

    public void end() {
        this.mImpl.end();
    }

    public float getAnimatedFloatValue() {
        return this.mImpl.getAnimatedFloatValue();
    }

    public float getAnimatedFraction() {
        return this.mImpl.getAnimatedFraction();
    }

    public int getAnimatedIntValue() {
        return this.mImpl.getAnimatedIntValue();
    }

    public boolean isRunning() {
        return this.mImpl.isRunning();
    }

    public void setDuration(int i) {
        this.mImpl.setDuration(i);
    }

    public void setFloatValues(float f, float f2) {
        this.mImpl.setFloatValues(f, f2);
    }

    public void setIntValues(int i, int i2) {
        this.mImpl.setIntValues(i, i2);
    }

    public void setInterpolator(Interpolator interpolator) {
        this.mImpl.setInterpolator(interpolator);
    }

    public void setListener(final AnimatorListener animatorListener) {
        if (animatorListener != null) {
            this.mImpl.setListener(new Impl.AnimatorListenerProxy() {
                public void onAnimationCancel() {
                    animatorListener.onAnimationCancel(ValueAnimatorCompat.this);
                }

                public void onAnimationEnd() {
                    animatorListener.onAnimationEnd(ValueAnimatorCompat.this);
                }

                public void onAnimationStart() {
                    animatorListener.onAnimationStart(ValueAnimatorCompat.this);
                }
            });
        } else {
            this.mImpl.setListener((Impl.AnimatorListenerProxy) null);
        }
    }

    public void setUpdateListener(final AnimatorUpdateListener animatorUpdateListener) {
        if (animatorUpdateListener != null) {
            this.mImpl.setUpdateListener(new Impl.AnimatorUpdateListenerProxy() {
                public void onAnimationUpdate() {
                    animatorUpdateListener.onAnimationUpdate(ValueAnimatorCompat.this);
                }
            });
        } else {
            this.mImpl.setUpdateListener((Impl.AnimatorUpdateListenerProxy) null);
        }
    }

    public void start() {
        this.mImpl.start();
    }
}
