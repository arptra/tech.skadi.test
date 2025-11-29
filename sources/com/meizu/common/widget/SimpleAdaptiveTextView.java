package com.meizu.common.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.meizu.common.util.TextViewUtils;

public class SimpleAdaptiveTextView extends TextView {
    private float mTextSize;

    public SimpleAdaptiveTextView(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: private */
    @SuppressLint({"WrongCall"})
    public void superMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    /* access modifiers changed from: private */
    public void superSetTextSize(int i, float f) {
        super.setTextSize(i, f);
    }

    public void onMeasure(int i, int i2) {
        super.setTextSize(0, this.mTextSize);
        super.onMeasure(i, i2);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        TextViewUtils.adaptiveTextSizeIfNeed(this, getMeasuredWidth(), new TextViewUtils.AdaptiveCallback() {
            public void measure(TextView textView, int i, int i2) {
                SimpleAdaptiveTextView.this.superMeasure(i, i2);
            }

            public void setTextSize(TextView textView, int i, float f) {
                SimpleAdaptiveTextView.this.superSetTextSize(i, f);
            }
        });
        super.onMeasure(i, makeMeasureSpec);
    }

    public void setTextSize(int i, float f) {
        super.setTextSize(i, f);
        this.mTextSize = TypedValue.applyDimension(i, f, getContext().getResources().getDisplayMetrics());
    }

    public SimpleAdaptiveTextView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        setFallbackLineSpacing(false);
    }

    public SimpleAdaptiveTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTextSize = getTextSize();
    }
}
