package com.meizu.common.scrollbarview;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;

class MzScrollBarDrawable extends Drawable implements Drawable.Callback {
    private static final boolean DEBUG = false;
    private static final int OPAQUE = 255;
    private static final String TAG = "MZScrollBarView";
    private int mAbsTranslation;
    private int mAlpha = 255;
    private boolean mAlwaysDrawHorizontalTrack;
    private boolean mAlwaysDrawVerticalTrack;
    private boolean mBoundsChanged;
    private ColorFilter mColorFilter;
    private int mExtent;
    private boolean mHasSetAlpha;
    private boolean mHasSetColorFilter;
    private Drawable mHorizontalThumbDrawable;
    private Drawable mHorizontalTrackDrawable;
    private boolean mMutated;
    private int mOffset;
    private MzScrollBarBaseAdapter mProxy;
    private int mRange;
    private boolean mRangeChanged;
    private int mThumbOffset;
    private final boolean mVertical;
    private Drawable mVerticalThumbDrawable;
    private Drawable mVerticalTrackDrawable;

    public MzScrollBarDrawable(boolean z, @NonNull MzScrollBarBaseAdapter mzScrollBarBaseAdapter) {
        this.mVertical = z;
        this.mProxy = mzScrollBarBaseAdapter;
    }

    private void drawThumb(Canvas canvas, Rect rect, int i) {
        boolean z = this.mRangeChanged || this.mBoundsChanged;
        boolean z2 = this.mVertical;
        Drawable drawable = z2 ? this.mVerticalThumbDrawable : this.mHorizontalThumbDrawable;
        if (drawable != null) {
            if (z) {
                if (z2) {
                    int i2 = rect.left;
                    int i3 = rect.top;
                    int i4 = this.mThumbOffset;
                    drawable.setBounds(i2, i3 + i4, rect.right, i3 + i4 + i);
                } else {
                    int i5 = rect.left;
                    int i6 = this.mThumbOffset;
                    drawable.setBounds(i5 + i6, rect.top, i5 + i6 + i, rect.bottom);
                }
                if (drawable instanceof GradientDrawable) {
                    ((GradientDrawable) drawable).setCornerRadius((float) (this.mVertical ? drawable.getBounds().width() / 2 : drawable.getBounds().height() / 2));
                }
            }
            drawable.draw(canvas);
        }
    }

    private void drawTrack(Canvas canvas, Rect rect) {
        Drawable drawable = this.mVertical ? this.mVerticalTrackDrawable : this.mHorizontalTrackDrawable;
        if (drawable != null) {
            if (this.mBoundsChanged) {
                drawable.setBounds(rect);
            }
            if (drawable instanceof GradientDrawable) {
                ((GradientDrawable) drawable).setCornerRadius((float) (this.mVertical ? drawable.getBounds().width() / 2 : drawable.getBounds().height() / 2));
            }
            drawable.draw(canvas);
        }
    }

    private void propagateCurrentState(Drawable drawable) {
        if (drawable != null) {
            if (this.mMutated) {
                drawable.mutate();
            }
            drawable.setState(getState());
            drawable.setCallback(this);
            if (this.mHasSetAlpha) {
                drawable.setAlpha(this.mAlpha);
            }
            if (this.mHasSetColorFilter) {
                drawable.setColorFilter(this.mColorFilter);
            }
        }
    }

    public void draw(Canvas canvas) {
        boolean z;
        boolean z2;
        int i = this.mExtent;
        int i2 = this.mRange;
        if (i <= 0 || i2 <= this.mProxy.getScrollBarVisibleFactor() * i) {
            z2 = this.mVertical ? this.mAlwaysDrawVerticalTrack : this.mAlwaysDrawHorizontalTrack;
            z = false;
        } else {
            z2 = true;
            z = true;
        }
        Rect bounds = getBounds();
        if (Build.VERSION.SDK_INT < 30 || !canvas.quickReject((float) bounds.left, (float) bounds.top, (float) bounds.right, (float) bounds.bottom)) {
            if (z2) {
                drawTrack(canvas, bounds);
            }
            if (z) {
                int height = this.mVertical ? bounds.height() : bounds.width();
                int i3 = i;
                int i4 = i2;
                int thumbLength = this.mProxy.getThumbLength(height, this.mVertical ? bounds.width() : bounds.height(), i3, i4, this.mAbsTranslation);
                this.mThumbOffset = this.mProxy.getThumbOffset(height, thumbLength, i3, i4, this.mOffset, this.mAbsTranslation);
                drawThumb(canvas, bounds, thumbLength);
            }
        }
    }

    public int getAlpha() {
        return this.mAlpha;
    }

    public ColorFilter getColorFilter() {
        return this.mColorFilter;
    }

    public int getOpacity() {
        return -3;
    }

    @IntRange
    public int getSize() {
        if (this.mVertical) {
            Drawable drawable = this.mVerticalTrackDrawable;
            if (drawable != null) {
                return drawable.getIntrinsicWidth();
            }
            Drawable drawable2 = this.mVerticalThumbDrawable;
            if (drawable2 != null) {
                return drawable2.getIntrinsicWidth();
            }
            return 0;
        }
        Drawable drawable3 = this.mHorizontalTrackDrawable;
        if (drawable3 != null) {
            return drawable3.getIntrinsicHeight();
        }
        Drawable drawable4 = this.mHorizontalThumbDrawable;
        if (drawable4 != null) {
            return drawable4.getIntrinsicHeight();
        }
        return 0;
    }

    public Drawable getThumbDrawable() {
        return this.mVertical ? this.mVerticalThumbDrawable : this.mHorizontalThumbDrawable;
    }

    @IntRange
    public int getThumbOffset() {
        return this.mThumbOffset;
    }

    public Drawable getTrackDrawable() {
        return this.mVertical ? this.mVerticalTrackDrawable : this.mHorizontalTrackDrawable;
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    public boolean isAlwaysDrawHorizontalTrack() {
        return this.mAlwaysDrawHorizontalTrack;
    }

    public boolean isAlwaysDrawVerticalTrack() {
        return this.mAlwaysDrawVerticalTrack;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
        r0 = r1.mHorizontalThumbDrawable;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
        r0 = r1.mVerticalThumbDrawable;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0014, code lost:
        r0 = r1.mHorizontalTrackDrawable;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isStateful() {
        /*
            r1 = this;
            android.graphics.drawable.Drawable r0 = r1.mVerticalTrackDrawable
            if (r0 == 0) goto L_0x000a
            boolean r0 = r0.isStateful()
            if (r0 != 0) goto L_0x002e
        L_0x000a:
            android.graphics.drawable.Drawable r0 = r1.mVerticalThumbDrawable
            if (r0 == 0) goto L_0x0014
            boolean r0 = r0.isStateful()
            if (r0 != 0) goto L_0x002e
        L_0x0014:
            android.graphics.drawable.Drawable r0 = r1.mHorizontalTrackDrawable
            if (r0 == 0) goto L_0x001e
            boolean r0 = r0.isStateful()
            if (r0 != 0) goto L_0x002e
        L_0x001e:
            android.graphics.drawable.Drawable r0 = r1.mHorizontalThumbDrawable
            if (r0 == 0) goto L_0x0028
            boolean r0 = r0.isStateful()
            if (r0 != 0) goto L_0x002e
        L_0x0028:
            boolean r1 = super.isStateful()
            if (r1 == 0) goto L_0x0030
        L_0x002e:
            r1 = 1
            goto L_0x0031
        L_0x0030:
            r1 = 0
        L_0x0031:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.common.scrollbarview.MzScrollBarDrawable.isStateful():boolean");
    }

    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.mBoundsChanged = true;
    }

    public boolean onStateChange(int[] iArr) {
        boolean onStateChange = super.onStateChange(iArr);
        Drawable drawable = this.mVerticalTrackDrawable;
        if (drawable != null) {
            onStateChange |= drawable.setState(iArr);
        }
        Drawable drawable2 = this.mVerticalThumbDrawable;
        if (drawable2 != null) {
            onStateChange |= drawable2.setState(iArr);
        }
        Drawable drawable3 = this.mHorizontalTrackDrawable;
        if (drawable3 != null) {
            onStateChange |= drawable3.setState(iArr);
        }
        Drawable drawable4 = this.mHorizontalThumbDrawable;
        return drawable4 != null ? onStateChange | drawable4.setState(iArr) : onStateChange;
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    public void setAlpha(int i) {
        this.mAlpha = i;
        this.mHasSetAlpha = true;
        Drawable drawable = this.mVerticalTrackDrawable;
        if (drawable != null) {
            drawable.setAlpha(i);
        }
        Drawable drawable2 = this.mVerticalThumbDrawable;
        if (drawable2 != null) {
            drawable2.setAlpha(i);
        }
        Drawable drawable3 = this.mHorizontalTrackDrawable;
        if (drawable3 != null) {
            drawable3.setAlpha(i);
        }
        Drawable drawable4 = this.mHorizontalThumbDrawable;
        if (drawable4 != null) {
            drawable4.setAlpha(i);
        }
    }

    public void setAlwaysDrawHorizontalTrack(boolean z) {
        this.mAlwaysDrawHorizontalTrack = z;
    }

    public void setAlwaysDrawVerticalTrack(boolean z) {
        this.mAlwaysDrawVerticalTrack = z;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mColorFilter = colorFilter;
        this.mHasSetColorFilter = true;
        Drawable drawable = this.mVerticalTrackDrawable;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        }
        Drawable drawable2 = this.mVerticalThumbDrawable;
        if (drawable2 != null) {
            drawable2.setColorFilter(colorFilter);
        }
        Drawable drawable3 = this.mHorizontalTrackDrawable;
        if (drawable3 != null) {
            drawable3.setColorFilter(colorFilter);
        }
        Drawable drawable4 = this.mHorizontalThumbDrawable;
        if (drawable4 != null) {
            drawable4.setColorFilter(colorFilter);
        }
    }

    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    public void setParameters(@IntRange int i, @IntRange int i2, @IntRange int i3, @IntRange int i4) {
        if (this.mRange != i || this.mOffset != i2 || this.mExtent != i3 || this.mAbsTranslation != i4) {
            this.mRange = i;
            this.mOffset = i2;
            this.mExtent = i3;
            this.mAbsTranslation = i4;
            this.mRangeChanged = true;
        }
    }

    public void setProxy(@NonNull MzScrollBarBaseAdapter mzScrollBarBaseAdapter) {
        this.mProxy = mzScrollBarBaseAdapter;
    }

    public void setThickness(@IntRange int i) {
        Rect bounds = getBounds();
        if (this.mVertical) {
            int i2 = bounds.right;
            setBounds(i2 - i, bounds.top, i2, bounds.bottom);
            return;
        }
        int i3 = bounds.left;
        int i4 = bounds.bottom;
        setBounds(i3, i4 - i, bounds.right, i4);
    }

    public void setThumbDrawable(@NonNull Drawable drawable) {
        if (this.mVertical) {
            Drawable drawable2 = this.mVerticalThumbDrawable;
            if (drawable2 != null) {
                drawable2.setCallback((Drawable.Callback) null);
            }
            propagateCurrentState(drawable);
            this.mVerticalThumbDrawable = drawable;
            return;
        }
        Drawable drawable3 = this.mHorizontalThumbDrawable;
        if (drawable3 != null) {
            drawable3.setCallback((Drawable.Callback) null);
        }
        propagateCurrentState(drawable);
        this.mHorizontalThumbDrawable = drawable;
    }

    public void setTrackDrawable(@NonNull Drawable drawable) {
        if (this.mVertical) {
            Drawable drawable2 = this.mVerticalTrackDrawable;
            if (drawable2 != null) {
                drawable2.setCallback((Drawable.Callback) null);
            }
            propagateCurrentState(drawable);
            this.mVerticalTrackDrawable = drawable;
            return;
        }
        Drawable drawable3 = this.mHorizontalTrackDrawable;
        if (drawable3 != null) {
            drawable3.setCallback((Drawable.Callback) null);
        }
        propagateCurrentState(drawable);
        this.mHorizontalTrackDrawable = drawable;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ScrollBarDrawable: range=");
        sb.append(this.mRange);
        sb.append(" offset=");
        sb.append(this.mOffset);
        sb.append(" extent=");
        sb.append(this.mExtent);
        sb.append(",direction:");
        sb.append(this.mVertical ? "vertical" : "horizontal");
        return sb.toString();
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }

    public MzScrollBarDrawable mutate() {
        if (!this.mMutated && super.mutate() == this) {
            Drawable drawable = this.mVerticalTrackDrawable;
            if (drawable != null) {
                drawable.mutate();
            }
            Drawable drawable2 = this.mVerticalThumbDrawable;
            if (drawable2 != null) {
                drawable2.mutate();
            }
            Drawable drawable3 = this.mHorizontalTrackDrawable;
            if (drawable3 != null) {
                drawable3.mutate();
            }
            Drawable drawable4 = this.mHorizontalThumbDrawable;
            if (drawable4 != null) {
                drawable4.mutate();
            }
            this.mMutated = true;
        }
        return this;
    }
}
