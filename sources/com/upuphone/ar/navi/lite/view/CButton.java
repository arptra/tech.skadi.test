package com.upuphone.ar.navi.lite.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import com.upuphone.ar.navi.lite.R;

public class CButton extends DrawableCenterTextView {
    public CButton(Context context) {
        super(context);
    }

    public void setSelect(boolean z) {
        if (z) {
            setTextColor(getResources().getColor(R.color.theme_color_1, (Resources.Theme) null));
            setBackgroundResource(R.drawable.btn_select);
            return;
        }
        setTextColor(getResources().getColor(R.color.theme_white_alpha_color, (Resources.Theme) null));
        setBackgroundResource(R.drawable.btn_unselect);
    }

    public CButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
