package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.view.CardItemView;

public final class FragmentVuGlassesManagerBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6836a;
    public final CardItemView b;
    public final CardItemView c;
    public final CardItemView d;
    public final CardItemView e;
    public final CardItemView f;
    public final CardItemView g;
    public final CardItemView h;
    public final CardItemView i;
    public final ConstraintLayout j;
    public final ConstraintLayout k;
    public final LinearLayout l;
    public final ScrollView m;
    public final CardItemView n;
    public final LinearLayout o;
    public final TextView p;
    public final TextView q;

    public FragmentVuGlassesManagerBinding(ConstraintLayout constraintLayout, CardItemView cardItemView, CardItemView cardItemView2, CardItemView cardItemView3, CardItemView cardItemView4, CardItemView cardItemView5, CardItemView cardItemView6, CardItemView cardItemView7, CardItemView cardItemView8, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, LinearLayout linearLayout, ScrollView scrollView, CardItemView cardItemView9, LinearLayout linearLayout2, TextView textView, TextView textView2) {
        this.f6836a = constraintLayout;
        this.b = cardItemView;
        this.c = cardItemView2;
        this.d = cardItemView3;
        this.e = cardItemView4;
        this.f = cardItemView5;
        this.g = cardItemView6;
        this.h = cardItemView7;
        this.i = cardItemView8;
        this.j = constraintLayout2;
        this.k = constraintLayout3;
        this.l = linearLayout;
        this.m = scrollView;
        this.n = cardItemView9;
        this.o = linearLayout2;
        this.p = textView;
        this.q = textView2;
    }

    public static FragmentVuGlassesManagerBinding a(View view) {
        View view2 = view;
        int i2 = R.id.about_glass;
        CardItemView cardItemView = (CardItemView) ViewBindings.a(view2, i2);
        if (cardItemView != null) {
            i2 = R.id.adapter_devices;
            CardItemView cardItemView2 = (CardItemView) ViewBindings.a(view2, i2);
            if (cardItemView2 != null) {
                i2 = R.id.anti_shake;
                CardItemView cardItemView3 = (CardItemView) ViewBindings.a(view2, i2);
                if (cardItemView3 != null) {
                    i2 = R.id.auto_sleep;
                    CardItemView cardItemView4 = (CardItemView) ViewBindings.a(view2, i2);
                    if (cardItemView4 != null) {
                        i2 = R.id.default_open_mode;
                        CardItemView cardItemView5 = (CardItemView) ViewBindings.a(view2, i2);
                        if (cardItemView5 != null) {
                            i2 = R.id.display_mode;
                            CardItemView cardItemView6 = (CardItemView) ViewBindings.a(view2, i2);
                            if (cardItemView6 != null) {
                                i2 = R.id.frequently_asked;
                                CardItemView cardItemView7 = (CardItemView) ViewBindings.a(view2, i2);
                                if (cardItemView7 != null) {
                                    i2 = R.id.glass_name;
                                    CardItemView cardItemView8 = (CardItemView) ViewBindings.a(view2, i2);
                                    if (cardItemView8 != null) {
                                        i2 = R.id.glass_setting_layout;
                                        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.a(view2, i2);
                                        if (constraintLayout != null) {
                                            i2 = R.id.glass_setting_update_layout;
                                            ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.a(view2, i2);
                                            if (constraintLayout2 != null) {
                                                i2 = R.id.lay_glass_update;
                                                LinearLayout linearLayout = (LinearLayout) ViewBindings.a(view2, i2);
                                                if (linearLayout != null) {
                                                    i2 = R.id.middle_scroll;
                                                    ScrollView scrollView = (ScrollView) ViewBindings.a(view2, i2);
                                                    if (scrollView != null) {
                                                        i2 = R.id.privacy_agreement;
                                                        CardItemView cardItemView9 = (CardItemView) ViewBindings.a(view2, i2);
                                                        if (cardItemView9 != null) {
                                                            i2 = R.id.privacy_protocol_layout;
                                                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.a(view2, i2);
                                                            if (linearLayout2 != null) {
                                                                i2 = R.id.setting_back_title;
                                                                TextView textView = (TextView) ViewBindings.a(view2, i2);
                                                                if (textView != null) {
                                                                    i2 = R.id.tv_glass_update_badge;
                                                                    TextView textView2 = (TextView) ViewBindings.a(view2, i2);
                                                                    if (textView2 != null) {
                                                                        return new FragmentVuGlassesManagerBinding((ConstraintLayout) view2, cardItemView, cardItemView2, cardItemView3, cardItemView4, cardItemView5, cardItemView6, cardItemView7, cardItemView8, constraintLayout, constraintLayout2, linearLayout, scrollView, cardItemView9, linearLayout2, textView, textView2);
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i2)));
    }

    public static FragmentVuGlassesManagerBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_vu_glasses_manager, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6836a;
    }
}
