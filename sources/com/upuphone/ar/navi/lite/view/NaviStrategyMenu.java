package com.upuphone.ar.navi.lite.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.upuphone.ar.navi.lite.R;

public class NaviStrategyMenu extends LinearLayout {
    public NaviStrategyMenu(Context context) {
        super(context);
        a(context);
    }

    public final void a(Context context) {
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.navi_strategy_menu_layout, this);
    }

    public void setStrategyText(String str) {
        ((TextView) findViewById(R.id.strategy)).setText(str);
    }

    public NaviStrategyMenu(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }
}
