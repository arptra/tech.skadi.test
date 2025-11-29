package com.meizu.common.util;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.meizu.common.R;
import java.util.ArrayList;

public class TabScroller {
    private float mCurrentTabOffset;
    private int mCurrentTabPos = 0;
    private float mOldTabOffset = 0.0f;
    private Drawable mTabIndicator;
    private int mTabIndicatorHeight = 20;
    private ArrayList<Integer> mTabLength = new ArrayList<>();
    private ViewGroup mTabParentView;
    private ArrayList<View> mTabViews = new ArrayList<>();

    public TabScroller(Context context, ViewGroup viewGroup) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, R.styleable.TabScroller, R.attr.MeizuCommon_TabScrollerStyle, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.TabScroller_mcTabIndicatorDrawable);
        this.mTabIndicator = drawable;
        if (drawable == null) {
            this.mTabIndicator = context.getResources().getDrawable(R.drawable.mz_tab_selected);
        }
        obtainStyledAttributes.recycle();
        this.mTabIndicatorHeight = this.mTabIndicator.getIntrinsicHeight();
        this.mTabParentView = viewGroup;
    }

    public void addTabView(View view) {
        if (view != null && !this.mTabViews.contains(view)) {
            this.mTabViews.add(view);
        }
    }

    public void dispatchDraw(Canvas canvas) {
        View view;
        float f;
        int i;
        int i2;
        int size = this.mTabViews.size();
        if (size != 0) {
            int i3 = this.mCurrentTabPos;
            int i4 = 0;
            if (i3 >= size) {
                this.mCurrentTabPos = size - 1;
            } else if (i3 < 0) {
                this.mCurrentTabPos = 0;
            }
            boolean z = this.mTabLength.size() == size;
            View view2 = this.mTabViews.get(this.mCurrentTabPos);
            int intValue = z ? this.mTabLength.get(this.mCurrentTabPos).intValue() : view2.getWidth();
            if (intValue < 0 || intValue > view2.getWidth()) {
                intValue = view2.getWidth();
            }
            int height = view2.getHeight();
            int left = view2.getLeft() + (view2.getWidth() / 2);
            float f2 = this.mCurrentTabOffset;
            float f3 = this.mOldTabOffset;
            if (f2 > f3 && (i2 = this.mCurrentTabPos) < size - 1) {
                view = this.mTabViews.get(i2 + 1);
                i4 = z ? this.mTabLength.get(this.mCurrentTabPos + 1).intValue() : view.getWidth();
                if (i4 < 0 || i4 > view.getWidth()) {
                    i4 = view.getWidth();
                }
            } else if (f2 >= f3 || (i = this.mCurrentTabPos) <= 0) {
                view = null;
            } else {
                view = this.mTabViews.get(i - 1);
                i4 = z ? this.mTabLength.get(this.mCurrentTabPos - 1).intValue() : view.getWidth();
                if (i4 < 0 || i4 > view.getWidth()) {
                    i4 = view.getWidth();
                }
            }
            if (view != null) {
                f = ((float) (i4 - intValue)) * this.mCurrentTabOffset;
                left = (int) (((float) left) + (((float) ((view.getLeft() + (view.getWidth() / 2)) - (view2.getLeft() + (view2.getWidth() / 2)))) * this.mCurrentTabOffset));
            } else {
                f = 0.0f;
            }
            int i5 = ((int) (((float) intValue) + f)) / 2;
            this.mTabIndicator.setBounds(left - i5, height - this.mTabIndicatorHeight, left + i5, height);
            canvas.save();
            this.mTabIndicator.draw(canvas);
            canvas.restore();
        }
    }

    public void onTabScrolled(int i, float f) {
        this.mCurrentTabPos = i;
        this.mCurrentTabOffset = f;
        ViewGroup viewGroup = this.mTabParentView;
        if (viewGroup != null) {
            viewGroup.invalidate();
        }
    }

    public void removeAllTabView() {
        this.mTabViews.clear();
        ViewGroup viewGroup = this.mTabParentView;
        if (viewGroup != null) {
            viewGroup.invalidate();
        }
    }

    public boolean removeTabView(View view) {
        boolean remove = this.mTabViews.remove(view);
        ViewGroup viewGroup = this.mTabParentView;
        if (viewGroup != null) {
            viewGroup.invalidate();
        }
        return remove;
    }

    public void setCurrentTab(int i) {
        ViewGroup viewGroup = this.mTabParentView;
        if (viewGroup != null) {
            this.mCurrentTabPos = i;
            this.mCurrentTabOffset = 0.0f;
            viewGroup.invalidate();
        }
    }

    public void setTabIndicatorDrawable(Drawable drawable) {
        if (drawable != null) {
            this.mTabIndicator = drawable;
            this.mTabIndicatorHeight = drawable.getIntrinsicHeight();
        }
    }

    public void setTabIndicatorHeight(int i) {
        if (i > 0) {
            this.mTabIndicatorHeight = i;
        }
    }

    public void setTabLength(int[] iArr) {
        this.mTabLength.clear();
        if (iArr != null) {
            for (int valueOf : iArr) {
                this.mTabLength.add(Integer.valueOf(valueOf));
            }
        }
    }

    public void addTabView(int i, View view) {
        if (view != null && !this.mTabViews.contains(view)) {
            this.mTabViews.add(i, view);
        }
    }

    public boolean removeTabView(int i) {
        return removeTabView(this.mTabViews.get(i));
    }
}
