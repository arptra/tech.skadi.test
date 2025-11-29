package com.luck.picture.lib.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.luck.picture.lib.R;
import com.luck.picture.lib.config.SelectorConfig;
import com.luck.picture.lib.config.SelectorProviders;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.style.BottomNavBarStyle;
import com.luck.picture.lib.utils.DensityUtil;
import com.luck.picture.lib.utils.PictureFileUtils;
import com.luck.picture.lib.utils.StyleUtils;

public class BottomNavBar extends RelativeLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public TextView f9477a;
    public TextView b;
    public CheckBox c;
    public SelectorConfig d;
    public OnBottomNavBarListener e;

    public static class OnBottomNavBarListener {
        public void a() {
        }

        public void b() {
        }

        public void c() {
        }

        public void d() {
        }
    }

    public BottomNavBar(Context context) {
        super(context);
        e();
    }

    public final void b() {
        if (this.d.x0) {
            long j = 0;
            for (int i = 0; i < this.d.g(); i++) {
                j += ((LocalMedia) this.d.h().get(i)).getSize();
            }
            if (j > 0) {
                this.c.setText(getContext().getString(R.string.ps_original_image, new Object[]{PictureFileUtils.e(j)}));
                return;
            }
            this.c.setText(getContext().getString(R.string.ps_default_original_image));
            return;
        }
        this.c.setText(getContext().getString(R.string.ps_default_original_image));
    }

    public void c() {
    }

    public void d() {
        View.inflate(getContext(), R.layout.ps_bottom_nav_bar, this);
    }

    public void e() {
        d();
        setClickable(true);
        setFocusable(true);
        this.d = SelectorProviders.c().d();
        this.f9477a = (TextView) findViewById(R.id.ps_tv_preview);
        this.b = (TextView) findViewById(R.id.ps_tv_editor);
        this.c = (CheckBox) findViewById(R.id.cb_original);
        this.f9477a.setOnClickListener(this);
        this.b.setVisibility(8);
        setBackgroundColor(ContextCompat.getColor(getContext(), R.color.ps_color_grey));
        this.c.setChecked(this.d.S);
        this.c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                BottomNavBar bottomNavBar = BottomNavBar.this;
                bottomNavBar.d.S = z;
                bottomNavBar.c.setChecked(BottomNavBar.this.d.S);
                OnBottomNavBarListener onBottomNavBarListener = BottomNavBar.this.e;
                if (onBottomNavBarListener != null) {
                    onBottomNavBarListener.a();
                    if (z && BottomNavBar.this.d.g() == 0) {
                        BottomNavBar.this.e.c();
                    }
                }
            }
        });
        c();
    }

    public void f() {
        SelectorConfig selectorConfig = this.d;
        if (selectorConfig.c) {
            setVisibility(8);
            return;
        }
        BottomNavBarStyle b2 = selectorConfig.K0.b();
        if (this.d.x0) {
            this.c.setVisibility(0);
            int g = b2.g();
            if (StyleUtils.c(g)) {
                this.c.setButtonDrawable(g);
            }
            String string = StyleUtils.c(b2.j()) ? getContext().getString(b2.j()) : b2.h();
            if (StyleUtils.f(string)) {
                this.c.setText(string);
            }
            int k = b2.k();
            if (StyleUtils.b(k)) {
                this.c.setTextSize((float) k);
            }
            int i = b2.i();
            if (StyleUtils.c(i)) {
                this.c.setTextColor(i);
            }
        }
        int f = b2.f();
        if (StyleUtils.b(f)) {
            getLayoutParams().height = f;
        } else {
            getLayoutParams().height = DensityUtil.a(getContext(), 46.0f);
        }
        int e2 = b2.e();
        if (StyleUtils.c(e2)) {
            setBackgroundColor(e2);
        }
        int n = b2.n();
        if (StyleUtils.c(n)) {
            this.f9477a.setTextColor(n);
        }
        int p = b2.p();
        if (StyleUtils.b(p)) {
            this.f9477a.setTextSize((float) p);
        }
        String string2 = StyleUtils.c(b2.o()) ? getContext().getString(b2.o()) : b2.m();
        if (StyleUtils.f(string2)) {
            this.f9477a.setText(string2);
        }
        String string3 = StyleUtils.c(b2.c()) ? getContext().getString(b2.c()) : b2.a();
        if (StyleUtils.f(string3)) {
            this.b.setText(string3);
        }
        int d2 = b2.d();
        if (StyleUtils.b(d2)) {
            this.b.setTextSize((float) d2);
        }
        int b3 = b2.b();
        if (StyleUtils.c(b3)) {
            this.b.setTextColor(b3);
        }
        int g2 = b2.g();
        if (StyleUtils.c(g2)) {
            this.c.setButtonDrawable(g2);
        }
        String string4 = StyleUtils.c(b2.j()) ? getContext().getString(b2.j()) : b2.h();
        if (StyleUtils.f(string4)) {
            this.c.setText(string4);
        }
        int k2 = b2.k();
        if (StyleUtils.b(k2)) {
            this.c.setTextSize((float) k2);
        }
        int i2 = b2.i();
        if (StyleUtils.c(i2)) {
            this.c.setTextColor(i2);
        }
    }

    public void g() {
        this.c.setChecked(this.d.S);
    }

    public void h() {
        b();
        BottomNavBarStyle b2 = this.d.K0.b();
        if (this.d.g() > 0) {
            this.f9477a.setEnabled(true);
            int r = b2.r();
            if (StyleUtils.c(r)) {
                this.f9477a.setTextColor(r);
            } else {
                this.f9477a.setTextColor(ContextCompat.getColor(getContext(), R.color.ps_color_fa632d));
            }
            String string = StyleUtils.c(b2.s()) ? getContext().getString(b2.s()) : b2.q();
            if (!StyleUtils.f(string)) {
                this.f9477a.setText(getContext().getString(R.string.ps_preview_num, new Object[]{Integer.valueOf(this.d.g())}));
            } else if (StyleUtils.d(string)) {
                this.f9477a.setText(String.format(string, new Object[]{Integer.valueOf(this.d.g())}));
            } else {
                this.f9477a.setText(string);
            }
        } else {
            this.f9477a.setEnabled(false);
            int n = b2.n();
            if (StyleUtils.c(n)) {
                this.f9477a.setTextColor(n);
            } else {
                this.f9477a.setTextColor(ContextCompat.getColor(getContext(), R.color.ps_color_9b));
            }
            String string2 = StyleUtils.c(b2.o()) ? getContext().getString(b2.o()) : b2.m();
            if (StyleUtils.f(string2)) {
                this.f9477a.setText(string2);
            } else {
                this.f9477a.setText(getContext().getString(R.string.ps_preview));
            }
        }
    }

    public void onClick(View view) {
        if (this.e != null && view.getId() == R.id.ps_tv_preview) {
            this.e.d();
        }
    }

    public void setOnBottomNavBarListener(OnBottomNavBarListener onBottomNavBarListener) {
        this.e = onBottomNavBarListener;
    }

    public BottomNavBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        e();
    }

    public BottomNavBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        e();
    }
}
