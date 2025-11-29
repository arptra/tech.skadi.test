package com.luck.picture.lib.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.luck.picture.lib.R;
import com.luck.picture.lib.config.SelectMimeType;
import com.luck.picture.lib.config.SelectorConfig;
import com.luck.picture.lib.config.SelectorProviders;
import com.luck.picture.lib.style.TitleBarStyle;
import com.luck.picture.lib.utils.DensityUtil;
import com.luck.picture.lib.utils.StyleUtils;

public class TitleBar extends RelativeLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public RelativeLayout f9489a;
    public ImageView b;
    public ImageView c;
    public ImageView d;
    public MarqueeTextView e;
    public TextView f;
    public View g;
    public View h;
    public SelectorConfig i;
    public View j;
    public RelativeLayout k;
    public OnTitleBarListener l;

    public static class OnTitleBarListener {
        public void a() {
        }

        public void b(View view) {
        }

        public void c() {
        }
    }

    public TitleBar(Context context) {
        super(context);
        c();
    }

    public void a() {
    }

    public void b() {
        LayoutInflater.from(getContext()).inflate(R.layout.ps_title_bar, this);
    }

    public void c() {
        Context context;
        int i2;
        b();
        setClickable(true);
        setFocusable(true);
        this.i = SelectorProviders.c().d();
        this.j = findViewById(R.id.top_status_bar);
        this.k = (RelativeLayout) findViewById(R.id.rl_title_bar);
        this.b = (ImageView) findViewById(R.id.ps_iv_left_back);
        this.f9489a = (RelativeLayout) findViewById(R.id.ps_rl_album_bg);
        this.d = (ImageView) findViewById(R.id.ps_iv_delete);
        this.h = findViewById(R.id.ps_rl_album_click);
        this.e = (MarqueeTextView) findViewById(R.id.ps_tv_title);
        this.c = (ImageView) findViewById(R.id.ps_iv_arrow);
        this.f = (TextView) findViewById(R.id.ps_tv_cancel);
        this.g = findViewById(R.id.title_bar_line);
        this.b.setOnClickListener(this);
        this.f.setOnClickListener(this);
        this.f9489a.setOnClickListener(this);
        this.k.setOnClickListener(this);
        this.h.setOnClickListener(this);
        setBackgroundColor(ContextCompat.getColor(getContext(), R.color.ps_color_grey));
        a();
        if (TextUtils.isEmpty(this.i.c0)) {
            if (this.i.f9404a == SelectMimeType.b()) {
                context = getContext();
                i2 = R.string.ps_all_audio;
            } else {
                context = getContext();
                i2 = R.string.ps_camera_roll;
            }
            setTitle(context.getString(i2));
            return;
        }
        setTitle(this.i.c0);
    }

    public void d() {
        if (this.i.K) {
            this.j.getLayoutParams().height = DensityUtil.i(getContext());
        }
        TitleBarStyle d2 = this.i.K0.d();
        int f2 = d2.f();
        if (StyleUtils.b(f2)) {
            this.k.getLayoutParams().height = f2;
        } else {
            this.k.getLayoutParams().height = DensityUtil.a(getContext(), 48.0f);
        }
        if (this.g != null) {
            if (d2.s()) {
                this.g.setVisibility(0);
                if (StyleUtils.c(d2.g())) {
                    this.g.setBackgroundColor(d2.g());
                }
            } else {
                this.g.setVisibility(8);
            }
        }
        int e2 = d2.e();
        if (StyleUtils.c(e2)) {
            setBackgroundColor(e2);
        }
        int p = d2.p();
        if (StyleUtils.c(p)) {
            this.b.setImageResource(p);
        }
        String string = StyleUtils.c(d2.n()) ? getContext().getString(d2.n()) : d2.m();
        if (StyleUtils.f(string)) {
            this.e.setText(string);
        }
        int r = d2.r();
        if (StyleUtils.b(r)) {
            this.e.setTextSize((float) r);
        }
        int q = d2.q();
        if (StyleUtils.c(q)) {
            this.e.setTextColor(q);
        }
        if (this.i.o0) {
            this.c.setImageResource(R.drawable.ps_ic_trans_1px);
        } else {
            int o = d2.o();
            if (StyleUtils.c(o)) {
                this.c.setImageResource(o);
            }
        }
        int d3 = d2.d();
        if (StyleUtils.c(d3)) {
            this.f9489a.setBackgroundResource(d3);
        }
        if (d2.t()) {
            this.f.setVisibility(8);
        } else {
            this.f.setVisibility(0);
            int h2 = d2.h();
            if (StyleUtils.c(h2)) {
                this.f.setBackgroundResource(h2);
            }
            String string2 = StyleUtils.c(d2.k()) ? getContext().getString(d2.k()) : d2.i();
            if (StyleUtils.f(string2)) {
                this.f.setText(string2);
            }
            int j2 = d2.j();
            if (StyleUtils.c(j2)) {
                this.f.setTextColor(j2);
            }
            int l2 = d2.l();
            if (StyleUtils.b(l2)) {
                this.f.setTextSize((float) l2);
            }
        }
        int a2 = d2.a();
        if (StyleUtils.c(a2)) {
            this.d.setBackgroundResource(a2);
        } else {
            this.d.setBackgroundResource(R.drawable.ps_ic_delete);
        }
    }

    public ImageView getImageArrow() {
        return this.c;
    }

    public ImageView getImageDelete() {
        return this.d;
    }

    public View getTitleBarLine() {
        return this.g;
    }

    public TextView getTitleCancelView() {
        return this.f;
    }

    public String getTitleText() {
        return this.e.getText().toString();
    }

    public void onClick(View view) {
        OnTitleBarListener onTitleBarListener;
        int id = view.getId();
        if (id == R.id.ps_iv_left_back || id == R.id.ps_tv_cancel) {
            OnTitleBarListener onTitleBarListener2 = this.l;
            if (onTitleBarListener2 != null) {
                onTitleBarListener2.a();
            }
        } else if (id == R.id.ps_rl_album_bg || id == R.id.ps_rl_album_click) {
            OnTitleBarListener onTitleBarListener3 = this.l;
            if (onTitleBarListener3 != null) {
                onTitleBarListener3.b(this);
            }
        } else if (id == R.id.rl_title_bar && (onTitleBarListener = this.l) != null) {
            onTitleBarListener.c();
        }
    }

    public void setOnTitleBarListener(OnTitleBarListener onTitleBarListener) {
        this.l = onTitleBarListener;
    }

    public void setTitle(String str) {
        this.e.setText(str);
    }

    public TitleBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c();
    }

    public TitleBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        c();
    }
}
