package com.meizu.common.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import com.meizu.common.R;

public class BottomBarDrawerView extends FrameLayout {
    private ImageButton mEndButton;
    private ImageButton mStartButton;

    public BottomBarDrawerView(Context context) {
        this(context, (AttributeSet) null);
    }

    public void setEndButton(Drawable drawable, View.OnClickListener onClickListener) {
        this.mEndButton.setImageDrawable(drawable);
        this.mEndButton.setOnClickListener(onClickListener);
    }

    public void setStartButton(Drawable drawable, View.OnClickListener onClickListener) {
        this.mStartButton.setImageDrawable(drawable);
        this.mStartButton.setOnClickListener(onClickListener);
    }

    public BottomBarDrawerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BottomBarDrawerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        addView(LayoutInflater.from(context).inflate(R.layout.mz_bottom_bar_drawer_content, (ViewGroup) null, false), -1, -1);
        this.mStartButton = (ImageButton) findViewById(R.id.left_btn);
        this.mEndButton = (ImageButton) findViewById(R.id.right_btn);
    }
}
