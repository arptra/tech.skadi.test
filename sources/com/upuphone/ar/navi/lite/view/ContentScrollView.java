package com.upuphone.ar.navi.lite.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.widget.ScrollView;
import com.upuphone.ar.navi.lite.view.ScrollLayout;

public class ContentScrollView extends ScrollView {

    /* renamed from: a  reason: collision with root package name */
    public OnScrollChangedListener f5822a;

    public interface OnScrollChangedListener {
        void a(int i, int i2, int i3, int i4);
    }

    public ContentScrollView(Context context) {
        super(context);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof ScrollLayout) {
                ((ScrollLayout) parent).setAssociatedScrollView(this);
                return;
            }
        }
    }

    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        this.f5822a.a(i, i2, i3, i4);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        ViewParent parent = getParent();
        if (!(parent instanceof ScrollLayout) || ((ScrollLayout) parent).getCurrentStatus() != ScrollLayout.Status.OPENED) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    public void setOnScrollChangeListener(OnScrollChangedListener onScrollChangedListener) {
        this.f5822a = onScrollChangedListener;
    }

    public ContentScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ContentScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
