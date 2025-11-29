package com.meizu.common.fastscrollletter;

import android.view.MotionEvent;
import android.view.ViewGroup;

public interface IFastScrollLetterListView {
    ViewGroup.LayoutParams getLayoutParams();

    boolean onTouchEvent(MotionEvent motionEvent);

    void setLayoutParams(ViewGroup.LayoutParams layoutParams);

    void setSelection(int i);

    void setVerticalScrollBarEnabled(boolean z);
}
