package com.luck.picture.lib.magical;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class MagicalViewWrapper {

    /* renamed from: a  reason: collision with root package name */
    public final ViewGroup.MarginLayoutParams f9432a;
    public final View b;

    public MagicalViewWrapper(View view) {
        this.b = view;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        this.f9432a = marginLayoutParams;
        if (marginLayoutParams instanceof LinearLayout.LayoutParams) {
            ((LinearLayout.LayoutParams) marginLayoutParams).gravity = 8388611;
        }
    }

    public void a(float f) {
        this.f9432a.height = Math.round(f);
        this.b.setLayoutParams(this.f9432a);
    }

    public void b(int i) {
        ViewGroup.MarginLayoutParams marginLayoutParams = this.f9432a;
        marginLayoutParams.leftMargin = i;
        this.b.setLayoutParams(marginLayoutParams);
    }

    public void c(int i) {
        ViewGroup.MarginLayoutParams marginLayoutParams = this.f9432a;
        marginLayoutParams.topMargin = i;
        this.b.setLayoutParams(marginLayoutParams);
    }

    public void d(float f) {
        this.f9432a.width = Math.round(f);
        this.b.setLayoutParams(this.f9432a);
    }
}
