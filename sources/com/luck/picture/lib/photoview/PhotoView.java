package com.luck.picture.lib.photoview;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;

public class PhotoView extends AppCompatImageView {

    /* renamed from: a  reason: collision with root package name */
    public PhotoViewAttacher f9443a;
    public ImageView.ScaleType b;

    public PhotoView(Context context) {
        this(context, (AttributeSet) null);
    }

    private void a() {
        this.f9443a = new PhotoViewAttacher(this);
        super.setScaleType(ImageView.ScaleType.MATRIX);
        ImageView.ScaleType scaleType = this.b;
        if (scaleType != null) {
            setScaleType(scaleType);
            this.b = null;
        }
    }

    public PhotoViewAttacher getAttacher() {
        return this.f9443a;
    }

    public RectF getDisplayRect() {
        return this.f9443a.B();
    }

    public Matrix getImageMatrix() {
        return this.f9443a.E();
    }

    public float getMaximumScale() {
        return this.f9443a.H();
    }

    public float getMediumScale() {
        return this.f9443a.I();
    }

    public float getMinimumScale() {
        return this.f9443a.J();
    }

    public float getScale() {
        return this.f9443a.K();
    }

    public ImageView.ScaleType getScaleType() {
        return this.f9443a.L();
    }

    public void setAllowParentInterceptOnEdge(boolean z) {
        this.f9443a.O(z);
    }

    public boolean setFrame(int i, int i2, int i3, int i4) {
        boolean frame = super.setFrame(i, i2, i3, i4);
        if (frame) {
            this.f9443a.l0();
        }
        return frame;
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        PhotoViewAttacher photoViewAttacher = this.f9443a;
        if (photoViewAttacher != null) {
            photoViewAttacher.l0();
        }
    }

    public void setImageResource(int i) {
        super.setImageResource(i);
        PhotoViewAttacher photoViewAttacher = this.f9443a;
        if (photoViewAttacher != null) {
            photoViewAttacher.l0();
        }
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        PhotoViewAttacher photoViewAttacher = this.f9443a;
        if (photoViewAttacher != null) {
            photoViewAttacher.l0();
        }
    }

    public void setMaximumScale(float f) {
        this.f9443a.Q(f);
    }

    public void setMediumScale(float f) {
        this.f9443a.R(f);
    }

    public void setMinimumScale(float f) {
        this.f9443a.S(f);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f9443a.T(onClickListener);
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.f9443a.U(onDoubleTapListener);
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f9443a.V(onLongClickListener);
    }

    public void setOnMatrixChangeListener(OnMatrixChangedListener onMatrixChangedListener) {
        this.f9443a.W(onMatrixChangedListener);
    }

    public void setOnOutsidePhotoTapListener(OnOutsidePhotoTapListener onOutsidePhotoTapListener) {
        this.f9443a.X(onOutsidePhotoTapListener);
    }

    public void setOnPhotoTapListener(OnPhotoTapListener onPhotoTapListener) {
        this.f9443a.Y(onPhotoTapListener);
    }

    public void setOnScaleChangeListener(OnScaleChangedListener onScaleChangedListener) {
        this.f9443a.Z(onScaleChangedListener);
    }

    public void setOnSingleFlingListener(OnSingleFlingListener onSingleFlingListener) {
        this.f9443a.a0(onSingleFlingListener);
    }

    public void setOnViewDragListener(OnViewDragListener onViewDragListener) {
        this.f9443a.b0(onViewDragListener);
    }

    public void setOnViewTapListener(OnViewTapListener onViewTapListener) {
        this.f9443a.c0(onViewTapListener);
    }

    public void setRotationBy(float f) {
        this.f9443a.d0(f);
    }

    public void setRotationTo(float f) {
        this.f9443a.e0(f);
    }

    public void setScale(float f) {
        this.f9443a.f0(f);
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        PhotoViewAttacher photoViewAttacher = this.f9443a;
        if (photoViewAttacher == null) {
            this.b = scaleType;
        } else {
            photoViewAttacher.i0(scaleType);
        }
    }

    public void setZoomTransitionDuration(int i) {
        this.f9443a.j0(i);
    }

    public void setZoomable(boolean z) {
        this.f9443a.k0(z);
    }

    public PhotoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PhotoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }
}
