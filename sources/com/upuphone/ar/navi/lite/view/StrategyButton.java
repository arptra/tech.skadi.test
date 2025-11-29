package com.upuphone.ar.navi.lite.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.TextView;
import com.upuphone.ar.navi.lite.R;

public class StrategyButton extends TextView {
    public StrategyButton(Context context) {
        super(context);
    }

    public void setSelect(boolean z) {
        if (z) {
            setTextColor(getResources().getColor(R.color.text_blue, (Resources.Theme) null));
            setBackgroundResource(R.drawable.btn_strategy_s);
        } else {
            setTextColor(getResources().getColor(R.color.search_menu_color, (Resources.Theme) null));
            setBackgroundResource(R.drawable.btn_strategy_n);
        }
        setSelected(z);
    }

    public StrategyButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setSelect(isSelected());
    }
}
