package com.upuphone.ar.fastrecord.phone.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

public class RecordTabViewPager extends ViewPager {
    private boolean isCanMove = true;

    public RecordTabViewPager(@NonNull Context context) {
        super(context);
    }

    public boolean isCanMove() {
        return this.isCanMove;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.isCanMove) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    public void setCanMove(boolean z) {
        this.isCanMove = z;
    }

    public RecordTabViewPager(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
