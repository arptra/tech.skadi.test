package com.luck.picture.lib.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.luck.picture.lib.R;
import com.luck.picture.lib.config.SelectorConfig;
import com.luck.picture.lib.config.SelectorProviders;
import com.luck.picture.lib.interfaces.OnSelectAnimListener;
import com.luck.picture.lib.style.BottomNavBarStyle;
import com.luck.picture.lib.style.PictureSelectorStyle;
import com.luck.picture.lib.style.SelectMainStyle;
import com.luck.picture.lib.utils.StyleUtils;
import com.luck.picture.lib.utils.ValueOf;

public class CompleteSelectView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public TextView f9479a;
    public TextView b;
    public Animation c;
    public SelectorConfig d;

    public CompleteSelectView(Context context) {
        super(context);
        b();
    }

    public void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.ps_complete_selected_layout, this);
    }

    public final void b() {
        a();
        setOrientation(0);
        this.f9479a = (TextView) findViewById(R.id.ps_tv_select_num);
        this.b = (TextView) findViewById(R.id.ps_tv_complete);
        setGravity(16);
        this.c = AnimationUtils.loadAnimation(getContext(), R.anim.ps_anim_modal_in);
        this.d = SelectorProviders.c().d();
    }

    public void c() {
        PictureSelectorStyle pictureSelectorStyle = this.d.K0;
        SelectMainStyle c2 = pictureSelectorStyle.c();
        if (StyleUtils.c(c2.K())) {
            setBackgroundResource(c2.K());
        }
        String string = StyleUtils.c(c2.N()) ? getContext().getString(c2.N()) : c2.L();
        if (StyleUtils.f(string)) {
            if (StyleUtils.e(string)) {
                this.b.setText(String.format(string, new Object[]{Integer.valueOf(this.d.g()), Integer.valueOf(this.d.k)}));
            } else {
                this.b.setText(string);
            }
        }
        int O = c2.O();
        if (StyleUtils.b(O)) {
            this.b.setTextSize((float) O);
        }
        int M = c2.M();
        if (StyleUtils.c(M)) {
            this.b.setTextColor(M);
        }
        BottomNavBarStyle b2 = pictureSelectorStyle.b();
        if (b2.w()) {
            int t = b2.t();
            if (StyleUtils.c(t)) {
                this.f9479a.setBackgroundResource(t);
            }
            int v = b2.v();
            if (StyleUtils.b(v)) {
                this.f9479a.setTextSize((float) v);
            }
            int u = b2.u();
            if (StyleUtils.c(u)) {
                this.f9479a.setTextColor(u);
            }
        }
    }

    public void setSelectedChange(boolean z) {
        PictureSelectorStyle pictureSelectorStyle = this.d.K0;
        SelectMainStyle c2 = pictureSelectorStyle.c();
        if (this.d.g() > 0) {
            setEnabled(true);
            int J = c2.J();
            if (StyleUtils.c(J)) {
                setBackgroundResource(J);
            } else {
                setBackgroundResource(R.drawable.ps_ic_trans_1px);
            }
            String string = StyleUtils.c(c2.R()) ? getContext().getString(c2.R()) : c2.P();
            if (!StyleUtils.f(string)) {
                this.b.setText(getContext().getString(R.string.ps_completed));
            } else if (StyleUtils.e(string)) {
                this.b.setText(String.format(string, new Object[]{Integer.valueOf(this.d.g()), Integer.valueOf(this.d.k)}));
            } else {
                this.b.setText(string);
            }
            int S = c2.S();
            if (StyleUtils.b(S)) {
                this.b.setTextSize((float) S);
            }
            int Q = c2.Q();
            if (StyleUtils.c(Q)) {
                this.b.setTextColor(Q);
            } else {
                this.b.setTextColor(ContextCompat.getColor(getContext(), R.color.ps_color_fa632d));
            }
            if (pictureSelectorStyle.b().w()) {
                if (this.f9479a.getVisibility() == 8 || this.f9479a.getVisibility() == 4) {
                    this.f9479a.setVisibility(0);
                }
                if (!TextUtils.equals(ValueOf.g(Integer.valueOf(this.d.g())), this.f9479a.getText())) {
                    this.f9479a.setText(ValueOf.g(Integer.valueOf(this.d.g())));
                    OnSelectAnimListener onSelectAnimListener = this.d.o1;
                    if (onSelectAnimListener != null) {
                        onSelectAnimListener.a(this.f9479a);
                    } else {
                        this.f9479a.startAnimation(this.c);
                    }
                }
            } else {
                this.f9479a.setVisibility(8);
            }
        } else {
            if (!z || !c2.V()) {
                setEnabled(this.d.N);
                int K = c2.K();
                if (StyleUtils.c(K)) {
                    setBackgroundResource(K);
                } else {
                    setBackgroundResource(R.drawable.ps_ic_trans_1px);
                }
                int M = c2.M();
                if (StyleUtils.c(M)) {
                    this.b.setTextColor(M);
                } else {
                    this.b.setTextColor(ContextCompat.getColor(getContext(), R.color.ps_color_9b));
                }
            } else {
                setEnabled(true);
                int J2 = c2.J();
                if (StyleUtils.c(J2)) {
                    setBackgroundResource(J2);
                } else {
                    setBackgroundResource(R.drawable.ps_ic_trans_1px);
                }
                int Q2 = c2.Q();
                if (StyleUtils.c(Q2)) {
                    this.b.setTextColor(Q2);
                } else {
                    this.b.setTextColor(ContextCompat.getColor(getContext(), R.color.ps_color_9b));
                }
            }
            this.f9479a.setVisibility(8);
            String string2 = StyleUtils.c(c2.N()) ? getContext().getString(c2.N()) : c2.L();
            if (!StyleUtils.f(string2)) {
                this.b.setText(getContext().getString(R.string.ps_please_select));
            } else if (StyleUtils.e(string2)) {
                this.b.setText(String.format(string2, new Object[]{Integer.valueOf(this.d.g()), Integer.valueOf(this.d.k)}));
            } else {
                this.b.setText(string2);
            }
            int O = c2.O();
            if (StyleUtils.b(O)) {
                this.b.setTextSize((float) O);
            }
        }
    }

    public CompleteSelectView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }

    public CompleteSelectView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b();
    }
}
