package com.upuphone.ar.navi.lite.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import com.upuphone.ar.navi.lite.base.BaseViewModel;
import com.upuphone.ar.navi.lite.view.ActionBarView;

public abstract class ActivityAddressBinding extends ViewDataBinding {
    public final LinearLayout A;
    public final TextView B;
    public final ConstraintLayout C;
    public final TextView D;
    public final ImageView E;
    public final TextView F;
    public final ImageView G;
    public final View H;
    public final TextView I;
    public final TextView J;
    public final TextView K;
    public final TextView L;
    public final LinearLayout M;
    public final TextView N;
    public final TextView O;
    public final ActionBarView P;
    public BaseViewModel Q;
    public final View z;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ActivityAddressBinding(Object obj, View view, int i, View view2, LinearLayout linearLayout, TextView textView, ConstraintLayout constraintLayout, TextView textView2, ImageView imageView, TextView textView3, ImageView imageView2, View view3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, LinearLayout linearLayout2, TextView textView8, TextView textView9, ActionBarView actionBarView) {
        super(obj, view, i);
        this.z = view2;
        this.A = linearLayout;
        this.B = textView;
        this.C = constraintLayout;
        this.D = textView2;
        this.E = imageView;
        this.F = textView3;
        this.G = imageView2;
        this.H = view3;
        this.I = textView4;
        this.J = textView5;
        this.K = textView6;
        this.L = textView7;
        this.M = linearLayout2;
        this.N = textView8;
        this.O = textView9;
        this.P = actionBarView;
    }

    public abstract void C(BaseViewModel baseViewModel);
}
