package com.luck.picture.lib.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.luck.picture.lib.R;
import com.luck.picture.lib.style.BottomNavBarStyle;
import com.luck.picture.lib.utils.StyleUtils;
import com.luck.picture.lib.widget.BottomNavBar;

public class PreviewBottomNavBar extends BottomNavBar {
    public PreviewBottomNavBar(Context context) {
        super(context);
    }

    public void c() {
        int i = 8;
        this.f9477a.setVisibility(8);
        this.b.setOnClickListener(this);
        TextView textView = this.b;
        if (this.d.c1 != null) {
            i = 0;
        }
        textView.setVisibility(i);
    }

    public void f() {
        super.f();
        BottomNavBarStyle b = this.d.K0.b();
        if (StyleUtils.c(b.l())) {
            setBackgroundColor(b.l());
        } else if (StyleUtils.b(b.e())) {
            setBackgroundColor(b.e());
        }
    }

    public TextView getEditor() {
        return this.b;
    }

    public void i(boolean z) {
        this.b.setVisibility((this.d.c1 == null || z) ? 8 : 0);
    }

    public void onClick(View view) {
        BottomNavBar.OnBottomNavBarListener onBottomNavBarListener;
        super.onClick(view);
        if (view.getId() == R.id.ps_tv_editor && (onBottomNavBarListener = this.e) != null) {
            onBottomNavBarListener.b();
        }
    }

    public PreviewBottomNavBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PreviewBottomNavBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
