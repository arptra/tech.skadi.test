package com.yalantis.ucrop.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.callback.CropBoundsChangeListener;
import com.yalantis.ucrop.callback.OverlayViewChangeListener;

public class UCropView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public GestureCropImageView f8769a;
    public final OverlayView b;

    public UCropView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void c() {
        this.f8769a.setCropBoundsChangeListener(new CropBoundsChangeListener() {
            public void a(float f) {
                UCropView.this.b.setTargetAspectRatio(f);
            }
        });
        this.b.setOverlayViewChangeListener(new OverlayViewChangeListener() {
            public void a(float f, float f2) {
                UCropView.this.f8769a.h(f, f2);
            }

            public void b(RectF rectF) {
                UCropView.this.f8769a.setCropRect(rectF);
            }
        });
    }

    @NonNull
    public GestureCropImageView getCropImageView() {
        return this.f8769a;
    }

    @NonNull
    public OverlayView getOverlayView() {
        return this.b;
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public UCropView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(R.layout.ucrop_view, this, true);
        this.f8769a = (GestureCropImageView) findViewById(R.id.image_view_crop);
        OverlayView overlayView = (OverlayView) findViewById(R.id.view_overlay);
        this.b = overlayView;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ucrop_UCropView);
        overlayView.j(obtainStyledAttributes);
        this.f8769a.w(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        c();
    }
}
