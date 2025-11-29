package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.view.CardItemView;

public final class FragmentAboutGlassBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6768a;
    public final TextView b;
    public final TextView c;
    public final TextView d;
    public final CardItemView e;
    public final TextView f;
    public final ConstraintLayout g;
    public final CardItemView h;
    public final CardItemView i;
    public final TextView j;
    public final LinearLayout k;
    public final CardItemView l;
    public final NestedScrollView m;
    public final TextView n;
    public final TextView o;
    public final CardItemView p;

    public FragmentAboutGlassBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2, TextView textView3, CardItemView cardItemView, TextView textView4, ConstraintLayout constraintLayout2, CardItemView cardItemView2, CardItemView cardItemView3, TextView textView5, LinearLayout linearLayout, CardItemView cardItemView4, NestedScrollView nestedScrollView, TextView textView6, TextView textView7, CardItemView cardItemView5) {
        this.f6768a = constraintLayout;
        this.b = textView;
        this.c = textView2;
        this.d = textView3;
        this.e = cardItemView;
        this.f = textView4;
        this.g = constraintLayout2;
        this.h = cardItemView2;
        this.i = cardItemView3;
        this.j = textView5;
        this.k = linearLayout;
        this.l = cardItemView4;
        this.m = nestedScrollView;
        this.n = textView6;
        this.o = textView7;
        this.p = cardItemView5;
    }

    public static FragmentAboutGlassBinding a(View view) {
        View view2 = view;
        int i2 = R.id.about_children_info_protect;
        TextView textView = (TextView) ViewBindings.a(view2, i2);
        if (textView != null) {
            i2 = R.id.account_personal_info_list;
            TextView textView2 = (TextView) ViewBindings.a(view2, i2);
            if (textView2 != null) {
                i2 = R.id.account_third_share_list;
                TextView textView3 = (TextView) ViewBindings.a(view2, i2);
                if (textView3 != null) {
                    i2 = R.id.factory_reset_main_title;
                    CardItemView cardItemView = (CardItemView) ViewBindings.a(view2, i2);
                    if (cardItemView != null) {
                        i2 = R.id.glass_info_back;
                        TextView textView4 = (TextView) ViewBindings.a(view2, i2);
                        if (textView4 != null) {
                            i2 = R.id.glass_info_layout;
                            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.a(view2, i2);
                            if (constraintLayout != null) {
                                i2 = R.id.glass_name;
                                CardItemView cardItemView2 = (CardItemView) ViewBindings.a(view2, i2);
                                if (cardItemView2 != null) {
                                    i2 = R.id.glass_regulatory_certification;
                                    CardItemView cardItemView3 = (CardItemView) ViewBindings.a(view2, i2);
                                    if (cardItemView3 != null) {
                                        i2 = R.id.glass_service_protocol;
                                        TextView textView5 = (TextView) ViewBindings.a(view2, i2);
                                        if (textView5 != null) {
                                            i2 = R.id.lay_glass_update;
                                            LinearLayout linearLayout = (LinearLayout) ViewBindings.a(view2, i2);
                                            if (linearLayout != null) {
                                                i2 = R.id.page_glass_info;
                                                CardItemView cardItemView4 = (CardItemView) ViewBindings.a(view2, i2);
                                                if (cardItemView4 != null) {
                                                    i2 = R.id.scroll_layout;
                                                    NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.a(view2, i2);
                                                    if (nestedScrollView != null) {
                                                        i2 = R.id.superapp_privacy_policy;
                                                        TextView textView6 = (TextView) ViewBindings.a(view2, i2);
                                                        if (textView6 != null) {
                                                            i2 = R.id.tv_glass_update_badge;
                                                            TextView textView7 = (TextView) ViewBindings.a(view2, i2);
                                                            if (textView7 != null) {
                                                                i2 = R.id.unbound_device;
                                                                CardItemView cardItemView5 = (CardItemView) ViewBindings.a(view2, i2);
                                                                if (cardItemView5 != null) {
                                                                    return new FragmentAboutGlassBinding((ConstraintLayout) view2, textView, textView2, textView3, cardItemView, textView4, constraintLayout, cardItemView2, cardItemView3, textView5, linearLayout, cardItemView4, nestedScrollView, textView6, textView7, cardItemView5);
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

    public static FragmentAboutGlassBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_about_glass, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6768a;
    }
}
