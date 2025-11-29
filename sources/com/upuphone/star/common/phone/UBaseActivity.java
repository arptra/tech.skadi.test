package com.upuphone.star.common.phone;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;

public class UBaseActivity extends AppCompatActivity {
    private final SystemBarHelper systemBarHelper = new SystemBarHelper(this);

    private View getContentView() {
        ViewGroup viewGroup = (ViewGroup) findViewById(16908290);
        if (viewGroup == null || viewGroup.getChildCount() <= 0) {
            return null;
        }
        return viewGroup.getChildAt(0);
    }

    public void fitNavigationBar(boolean z) {
        this.systemBarHelper.d(z);
    }

    public void fitStatusBar(boolean z) {
        this.systemBarHelper.e(z);
    }

    public void fitSystemWindow(boolean z) {
        this.systemBarHelper.f(z);
    }

    public final void n0(View view) {
        this.systemBarHelper.h(view);
    }

    public void setContentView(int i) {
        super.setContentView(i);
        n0(getContentView());
    }

    public void setNavigationBarColor(@ColorInt int i) {
        this.systemBarHelper.i(i);
    }

    public void setStatusBarColor(@ColorInt int i) {
        this.systemBarHelper.j(i);
    }

    public void setContentView(View view) {
        super.setContentView(view);
        n0(getContentView());
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        n0(getContentView());
    }
}
