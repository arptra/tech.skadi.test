package com.upuphone.ar.navi.lite.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.TextView;
import com.upuphone.ar.navi.lite.R;

public class CarTypeButton extends TextView {
    public CarTypeButton(Context context) {
        super(context);
    }

    public void setSelect(boolean z) {
        if (z) {
            setTextColor(getResources().getColor(R.color.text_blue, (Resources.Theme) null));
            setBackgroundResource(R.drawable.btn_car_type_s);
        } else {
            setTextColor(getResources().getColor(R.color.search_menu_color, (Resources.Theme) null));
            setBackgroundResource(R.drawable.btn_car_type_n);
        }
        setSelected(z);
    }

    public CarTypeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setSelect(isSelected());
    }
}
