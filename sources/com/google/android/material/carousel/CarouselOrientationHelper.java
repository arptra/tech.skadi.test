package com.google.android.material.carousel;

import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

abstract class CarouselOrientationHelper {
    final int orientation;

    private static CarouselOrientationHelper createHorizontalHelper(final CarouselLayoutManager carouselLayoutManager) {
        return new CarouselOrientationHelper(0) {
            public void containMaskWithinBounds(RectF rectF, RectF rectF2, RectF rectF3) {
                float f = rectF2.left;
                float f2 = rectF3.left;
                if (f < f2 && rectF2.right > f2) {
                    float f3 = f2 - f;
                    rectF.left += f3;
                    rectF2.left += f3;
                }
                float f4 = rectF2.right;
                float f5 = rectF3.right;
                if (f4 > f5 && rectF2.left < f5) {
                    float f6 = f4 - f5;
                    rectF.right = Math.max(rectF.right - f6, rectF.left);
                    rectF2.right = Math.max(rectF2.right - f6, rectF2.left);
                }
            }

            public float getMaskMargins(RecyclerView.LayoutParams layoutParams) {
                return (float) (layoutParams.rightMargin + layoutParams.leftMargin);
            }

            public RectF getMaskRect(float f, float f2, float f3, float f4) {
                return new RectF(f4, 0.0f, f2 - f4, f);
            }

            public int getParentBottom() {
                return carouselLayoutManager.getHeight() - carouselLayoutManager.getPaddingBottom();
            }

            public int getParentEnd() {
                return carouselLayoutManager.isLayoutRtl() ? getParentLeft() : getParentRight();
            }

            public int getParentLeft() {
                return 0;
            }

            public int getParentRight() {
                return carouselLayoutManager.getWidth();
            }

            public int getParentStart() {
                return carouselLayoutManager.isLayoutRtl() ? getParentRight() : getParentLeft();
            }

            public int getParentTop() {
                return carouselLayoutManager.getPaddingTop();
            }

            public void layoutDecoratedWithMargins(View view, int i, int i2) {
                carouselLayoutManager.layoutDecoratedWithMargins(view, i, getParentTop(), i2, getParentBottom());
            }

            public void moveMaskOnEdgeOutsideBounds(RectF rectF, RectF rectF2, RectF rectF3) {
                if (rectF2.right <= rectF3.left) {
                    float floor = ((float) Math.floor((double) rectF.right)) - 1.0f;
                    rectF.right = floor;
                    rectF.left = Math.min(rectF.left, floor);
                }
                if (rectF2.left >= rectF3.right) {
                    float ceil = ((float) Math.ceil((double) rectF.left)) + 1.0f;
                    rectF.left = ceil;
                    rectF.right = Math.max(ceil, rectF.right);
                }
            }

            public void offsetChild(View view, Rect rect, float f, float f2) {
                view.offsetLeftAndRight((int) (f2 - (((float) rect.left) + f)));
            }
        };
    }

    public static CarouselOrientationHelper createOrientationHelper(CarouselLayoutManager carouselLayoutManager, int i) {
        if (i == 0) {
            return createHorizontalHelper(carouselLayoutManager);
        }
        if (i == 1) {
            return createVerticalHelper(carouselLayoutManager);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    private static CarouselOrientationHelper createVerticalHelper(final CarouselLayoutManager carouselLayoutManager) {
        return new CarouselOrientationHelper(1) {
            public void containMaskWithinBounds(RectF rectF, RectF rectF2, RectF rectF3) {
                float f = rectF2.top;
                float f2 = rectF3.top;
                if (f < f2 && rectF2.bottom > f2) {
                    float f3 = f2 - f;
                    rectF.top += f3;
                    rectF3.top += f3;
                }
                float f4 = rectF2.bottom;
                float f5 = rectF3.bottom;
                if (f4 > f5 && rectF2.top < f5) {
                    float f6 = f4 - f5;
                    rectF.bottom = Math.max(rectF.bottom - f6, rectF.top);
                    rectF2.bottom = Math.max(rectF2.bottom - f6, rectF2.top);
                }
            }

            public float getMaskMargins(RecyclerView.LayoutParams layoutParams) {
                return (float) (layoutParams.topMargin + layoutParams.bottomMargin);
            }

            public RectF getMaskRect(float f, float f2, float f3, float f4) {
                return new RectF(0.0f, f3, f2, f - f3);
            }

            public int getParentBottom() {
                return carouselLayoutManager.getHeight();
            }

            public int getParentEnd() {
                return getParentBottom();
            }

            public int getParentLeft() {
                return carouselLayoutManager.getPaddingLeft();
            }

            public int getParentRight() {
                return carouselLayoutManager.getWidth() - carouselLayoutManager.getPaddingRight();
            }

            public int getParentStart() {
                return getParentTop();
            }

            public int getParentTop() {
                return 0;
            }

            public void layoutDecoratedWithMargins(View view, int i, int i2) {
                carouselLayoutManager.layoutDecoratedWithMargins(view, getParentLeft(), i, getParentRight(), i2);
            }

            public void moveMaskOnEdgeOutsideBounds(RectF rectF, RectF rectF2, RectF rectF3) {
                if (rectF2.bottom <= rectF3.top) {
                    float floor = ((float) Math.floor((double) rectF.bottom)) - 1.0f;
                    rectF.bottom = floor;
                    rectF.top = Math.min(rectF.top, floor);
                }
                if (rectF2.top >= rectF3.bottom) {
                    float ceil = ((float) Math.ceil((double) rectF.top)) + 1.0f;
                    rectF.top = ceil;
                    rectF.bottom = Math.max(ceil, rectF.bottom);
                }
            }

            public void offsetChild(View view, Rect rect, float f, float f2) {
                view.offsetTopAndBottom((int) (f2 - (((float) rect.top) + f)));
            }
        };
    }

    public abstract void containMaskWithinBounds(RectF rectF, RectF rectF2, RectF rectF3);

    public abstract float getMaskMargins(RecyclerView.LayoutParams layoutParams);

    public abstract RectF getMaskRect(float f, float f2, float f3, float f4);

    public abstract int getParentBottom();

    public abstract int getParentEnd();

    public abstract int getParentLeft();

    public abstract int getParentRight();

    public abstract int getParentStart();

    public abstract int getParentTop();

    public abstract void layoutDecoratedWithMargins(View view, int i, int i2);

    public abstract void moveMaskOnEdgeOutsideBounds(RectF rectF, RectF rectF2, RectF rectF3);

    public abstract void offsetChild(View view, Rect rect, float f, float f2);

    private CarouselOrientationHelper(int i) {
        this.orientation = i;
    }
}
