package com.meizu.common.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.meizu.common.R;

public class PreferenceCategory extends android.preference.PreferenceCategory {
    private static final String TAG = "PreferenceCategory";
    private int mNoTitleLayoutResId = R.layout.mz_preference_category_no_title;
    private int mTopPadding = 0;

    public PreferenceCategory(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        initAttributes(context, attributeSet);
    }

    private void initAttributes(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PreferenceCategory, 0, 0);
        this.mNoTitleLayoutResId = obtainStyledAttributes.getResourceId(R.styleable.PreferenceCategory_mzNoTitleLayout, this.mNoTitleLayoutResId);
        this.mTopPadding = obtainStyledAttributes.getDimensionPixelSize(R.styleable.PreferenceCategory_mzTopPadding, 0);
        obtainStyledAttributes.recycle();
    }

    public View getView(View view, ViewGroup viewGroup) {
        return super.getView((View) null, viewGroup);
    }

    public View onCreateView(ViewGroup viewGroup) {
        View view;
        if (getTitle() == null && getTitleRes() == 0) {
            LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService("layout_inflater");
            view = layoutInflater.inflate(this.mNoTitleLayoutResId, viewGroup, false);
            ViewGroup viewGroup2 = (ViewGroup) view.findViewById(16908312);
            if (viewGroup2 != null) {
                if (getWidgetLayoutResource() != 0) {
                    layoutInflater.inflate(getWidgetLayoutResource(), viewGroup2);
                } else {
                    viewGroup2.setVisibility(8);
                }
            }
        } else {
            view = super.onCreateView(viewGroup);
        }
        if (this.mTopPadding != 0) {
            view.setPadding(view.getPaddingStart(), this.mTopPadding, view.getPaddingEnd(), view.getPaddingBottom());
        }
        return view;
    }

    public void setTopPadding(int i) {
        this.mTopPadding = i;
    }

    public PreferenceCategory(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initAttributes(context, attributeSet);
    }

    public PreferenceCategory(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initAttributes(context, attributeSet);
    }

    public PreferenceCategory(Context context) {
        super(context);
    }
}
