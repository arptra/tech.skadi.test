package com.meizu.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.opengl.EGLContext;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.meizu.common.R;
import com.meizu.common.util.PAGReporterPrevent;
import org.libpag.PAGView;

public class MzPAGView extends FrameLayout {
    private String mInitPath;
    private int mInitRepeatCount = 1;
    PAGView pagView;

    public MzPAGView(Context context) {
        super(context);
        PAGReporterPrevent.init(context.getApplicationContext());
        this.pagView = new PAGView(context);
        init(context, (AttributeSet) null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        PAGView pAGView = this.pagView;
        if (pAGView != null) {
            addView(pAGView, new FrameLayout.LayoutParams(-1, -1));
        }
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MzPAGView);
            this.mInitPath = obtainStyledAttributes.getString(R.styleable.MzPAGView_pagPath);
            this.mInitRepeatCount = obtainStyledAttributes.getInt(R.styleable.MzPAGView_android_repeatCount, 1);
            obtainStyledAttributes.recycle();
        }
    }

    public PAGView getPagView() {
        return this.pagView;
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        setPagPath(this.mInitPath);
        PAGView pAGView = this.pagView;
        if (pAGView != null) {
            pAGView.setRepeatCount(this.mInitRepeatCount);
        }
    }

    public void setPagPath(String str) {
        PAGView pAGView;
        if (!TextUtils.isEmpty(str) && (pAGView = this.pagView) != null) {
            pAGView.setPath(str);
        }
    }

    public void setPageRepeatCount(int i) {
        PAGView pAGView = this.pagView;
        if (pAGView != null) {
            pAGView.setRepeatCount(i);
        }
    }

    public void start() {
        PAGView pAGView = this.pagView;
        if (pAGView != null) {
            pAGView.play();
        }
    }

    public void startDelay(int i) {
        postDelayed(new Runnable() {
            public void run() {
                PAGView pAGView = MzPAGView.this.pagView;
                if (pAGView != null) {
                    pAGView.play();
                }
            }
        }, (long) i);
    }

    public MzPAGView(Context context, EGLContext eGLContext) {
        super(context);
        PAGReporterPrevent.init(context.getApplicationContext());
        this.pagView = new PAGView(context, eGLContext);
        init(context, (AttributeSet) null);
    }

    public MzPAGView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        PAGReporterPrevent.init(context.getApplicationContext());
        this.pagView = new PAGView(context);
        init(context, attributeSet);
    }

    public MzPAGView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        PAGReporterPrevent.init(context.getApplicationContext());
        this.pagView = new PAGView(context);
        init(context, attributeSet);
    }
}
