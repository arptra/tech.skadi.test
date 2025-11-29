package com.meizu.common.scrollview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.widget.HorizontalScrollView;
import android.widget.OverScroller;
import androidx.annotation.NonNull;
import flyme.support.v7.widget.animations.GlobalOverScrollListener;
import flyme.support.v7.widget.animations.SpringAnimationHelper;

public class MzHorizontalScrollView extends HorizontalScrollView {
    private boolean mShouldRequestDisallow;
    private final SpringAnimationHelper mSpringAnimationHelper;

    public interface OverScrollListener extends GlobalOverScrollListener {
    }

    public MzHorizontalScrollView(Context context) {
        this(context, (AttributeSet) null);
    }

    public void addOnOverScrollListener(@NonNull OverScrollListener overScrollListener) {
        this.mSpringAnimationHelper.addOnOverScrollListener(overScrollListener);
    }

    public void clearOnOverScrollListener() {
        this.mSpringAnimationHelper.clearOnOverScrollListener();
    }

    public void fling(int i) {
        super.fling(i);
        this.mSpringAnimationHelper.fling(i, 0);
    }

    public boolean isEndOverScrollEnable() {
        return this.mSpringAnimationHelper.isEndOverScrollEnable();
    }

    public boolean isOverScrollEnable() {
        return this.mSpringAnimationHelper.isOverScrollEnable();
    }

    public boolean isStartOverScrollEnable() {
        return this.mSpringAnimationHelper.isStartOverScrollEnable();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return false;
        }
        if (!this.mSpringAnimationHelper.onTouchEvent(motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        ViewParent parent = getParent();
        if (parent != null && this.mShouldRequestDisallow) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        return true;
    }

    public void removeOverScrollListener(@NonNull OverScrollListener overScrollListener) {
        this.mSpringAnimationHelper.removeOverScrollListener(overScrollListener);
    }

    public void setEndOverScrollEnable(boolean z) {
        this.mSpringAnimationHelper.setEndOverScrollEnable(z);
    }

    public void setOverScrollEnable(boolean z) {
        this.mSpringAnimationHelper.setOverScrollEnable(z);
    }

    public void setShouldRequestDisallowInterceptTouchEventWhenOverScroll(boolean z) {
        this.mShouldRequestDisallow = z;
    }

    public void setStartOverScrollEnable(boolean z) {
        this.mSpringAnimationHelper.setStartOverScrollEnable(z);
    }

    public MzHorizontalScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MzHorizontalScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mShouldRequestDisallow = false;
        this.mSpringAnimationHelper = new SpringAnimationHelper(context, this, (OverScroller) null, 0);
        setOverScrollMode(2);
    }
}
