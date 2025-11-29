package com.luck.picture.lib.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.luck.picture.lib.R;
import com.luck.picture.lib.style.TitleBarStyle;
import com.luck.picture.lib.utils.StyleUtils;

public class PreviewTitleBar extends TitleBar {
    public PreviewTitleBar(Context context) {
        super(context);
    }

    public void d() {
        super.d();
        TitleBarStyle d = this.i.K0.d();
        if (StyleUtils.c(d.b())) {
            setBackgroundColor(d.b());
        } else if (StyleUtils.b(d.e())) {
            setBackgroundColor(d.e());
        }
        if (StyleUtils.c(d.c())) {
            this.b.setImageResource(d.c());
        }
        this.f9489a.setOnClickListener((View.OnClickListener) null);
        this.h.setOnClickListener((View.OnClickListener) null);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f9489a.getLayoutParams();
        layoutParams.removeRule(17);
        layoutParams.addRule(14);
        this.f9489a.setBackgroundResource(R.drawable.ps_ic_trans_1px);
        this.f.setVisibility(8);
        this.c.setVisibility(8);
        this.h.setVisibility(8);
    }

    public PreviewTitleBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PreviewTitleBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
