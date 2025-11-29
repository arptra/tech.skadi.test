package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.meizu.common.widget.MzButton;
import com.upuphone.xr.sapp.R;

public final class DialogAppUserGuideBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final LinearLayout f6749a;
    public final TextView b;
    public final TextView c;
    public final TextView d;
    public final TextView e;
    public final CheckBox f;
    public final CheckBox g;
    public final MzButton h;
    public final TextView i;
    public final TextView j;
    public final LinearLayoutCompat k;
    public final TextView l;
    public final ScrollView m;
    public final TextView n;
    public final TextView o;
    public final MzButton p;
    public final TextView q;
    public final TextView r;

    public DialogAppUserGuideBinding(LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, CheckBox checkBox, CheckBox checkBox2, MzButton mzButton, TextView textView5, TextView textView6, LinearLayoutCompat linearLayoutCompat, TextView textView7, ScrollView scrollView, TextView textView8, TextView textView9, MzButton mzButton2, TextView textView10, TextView textView11) {
        this.f6749a = linearLayout;
        this.b = textView;
        this.c = textView2;
        this.d = textView3;
        this.e = textView4;
        this.f = checkBox;
        this.g = checkBox2;
        this.h = mzButton;
        this.i = textView5;
        this.j = textView6;
        this.k = linearLayoutCompat;
        this.l = textView7;
        this.m = scrollView;
        this.n = textView8;
        this.o = textView9;
        this.p = mzButton2;
        this.q = textView10;
        this.r = textView11;
    }

    public static DialogAppUserGuideBinding a(View view) {
        View view2 = view;
        int i2 = R.id.account_tips_content;
        TextView textView = (TextView) ViewBindings.a(view2, i2);
        if (textView != null) {
            i2 = R.id.account_tips_title;
            TextView textView2 = (TextView) ViewBindings.a(view2, i2);
            if (textView2 != null) {
                i2 = R.id.bt_tips_content;
                TextView textView3 = (TextView) ViewBindings.a(view2, i2);
                if (textView3 != null) {
                    i2 = R.id.bt_tips_title;
                    TextView textView4 = (TextView) ViewBindings.a(view2, i2);
                    if (textView4 != null) {
                        i2 = R.id.checkbox_over_18_years;
                        CheckBox checkBox = (CheckBox) ViewBindings.a(view2, i2);
                        if (checkBox != null) {
                            i2 = R.id.checkbox_transfer_personal_data;
                            CheckBox checkBox2 = (CheckBox) ViewBindings.a(view2, i2);
                            if (checkBox2 != null) {
                                i2 = R.id.exit;
                                MzButton mzButton = (MzButton) ViewBindings.a(view2, i2);
                                if (mzButton != null) {
                                    i2 = R.id.gps_tips_content;
                                    TextView textView5 = (TextView) ViewBindings.a(view2, i2);
                                    if (textView5 != null) {
                                        i2 = R.id.gps_tips_title;
                                        TextView textView6 = (TextView) ViewBindings.a(view2, i2);
                                        if (textView6 != null) {
                                            i2 = R.id.linear_korean_checkbox;
                                            LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) ViewBindings.a(view2, i2);
                                            if (linearLayoutCompat != null) {
                                                i2 = R.id.permission_tips_content;
                                                TextView textView7 = (TextView) ViewBindings.a(view2, i2);
                                                if (textView7 != null) {
                                                    i2 = R.id.permission_tips_scrollview;
                                                    ScrollView scrollView = (ScrollView) ViewBindings.a(view2, i2);
                                                    if (scrollView != null) {
                                                        i2 = R.id.permission_tips_subject;
                                                        TextView textView8 = (TextView) ViewBindings.a(view2, i2);
                                                        if (textView8 != null) {
                                                            i2 = R.id.permission_tips_title;
                                                            TextView textView9 = (TextView) ViewBindings.a(view2, i2);
                                                            if (textView9 != null) {
                                                                i2 = R.id.sure;
                                                                MzButton mzButton2 = (MzButton) ViewBindings.a(view2, i2);
                                                                if (mzButton2 != null) {
                                                                    i2 = R.id.text_over_18_years;
                                                                    TextView textView10 = (TextView) ViewBindings.a(view2, i2);
                                                                    if (textView10 != null) {
                                                                        i2 = R.id.text_transfer_personal_data;
                                                                        TextView textView11 = (TextView) ViewBindings.a(view2, i2);
                                                                        if (textView11 != null) {
                                                                            return new DialogAppUserGuideBinding((LinearLayout) view2, textView, textView2, textView3, textView4, checkBox, checkBox2, mzButton, textView5, textView6, linearLayoutCompat, textView7, scrollView, textView8, textView9, mzButton2, textView10, textView11);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i2)));
    }

    public static DialogAppUserGuideBinding c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static DialogAppUserGuideBinding d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_app_user_guide, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f6749a;
    }
}
