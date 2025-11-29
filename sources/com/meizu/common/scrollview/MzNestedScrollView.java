package com.meizu.common.scrollview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.widget.OverScroller;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import flyme.support.v7.widget.animations.GlobalOverScrollListener;
import flyme.support.v7.widget.animations.SpringAnimationHelper;

public class MzNestedScrollView extends NestedScrollView {
    private boolean mShouldRequestDisallow;
    private final SpringAnimationHelper mSpringAnimationHelper;

    public interface OverScrollListener extends GlobalOverScrollListener {
    }

    public MzNestedScrollView(@NonNull Context context) {
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
        this.mSpringAnimationHelper.fling(0, i);
    }

    public SpringAnimationHelper getSpringAnimationHelper() {
        return this.mSpringAnimationHelper;
    }

    public boolean isBottomOverScrollEnable() {
        return this.mSpringAnimationHelper.isBottomOverScrollEnable();
    }

    public boolean isOverScrollEnable() {
        return this.mSpringAnimationHelper.isOverScrollEnable();
    }

    public boolean isTopOverScrollEnable() {
        return this.mSpringAnimationHelper.isTopOverScrollEnable();
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

    public void setBottomOverScrollEnable(boolean z) {
        this.mSpringAnimationHelper.setBottomOverScrollEnable(z);
    }

    public void setOverScrollEnable(boolean z) {
        this.mSpringAnimationHelper.setOverScrollEnable(z);
    }

    public void setShouldRequestDisallowInterceptTouchEventWhenOverScroll(boolean z) {
        this.mShouldRequestDisallow = z;
    }

    public void setTopOverScrollEnable(boolean z) {
        this.mSpringAnimationHelper.setTopOverScrollEnable(z);
    }

    public MzNestedScrollView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MzNestedScrollView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mShouldRequestDisallow = false;
        this.mSpringAnimationHelper = new SpringAnimationHelper(context, this, (OverScroller) null, 1);
        setOverScrollMode(2);
    }
}
