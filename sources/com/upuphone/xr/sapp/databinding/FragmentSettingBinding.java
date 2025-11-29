package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.xr.sapp.R;

public final class FragmentSettingBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6815a;
    public final TextView b;
    public final TextView c;
    public final ConstraintLayout d;
    public final TextView e;
    public final TextView f;
    public final ConstraintLayout g;
    public final ConstraintLayout h;
    public final ImageView i;
    public final TextView j;
    public final TextView k;
    public final TextView l;
    public final TextView m;
    public final TextView n;
    public final TextView o;

    public FragmentSettingBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2, ConstraintLayout constraintLayout2, TextView textView3, TextView textView4, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, ImageView imageView, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10) {
        this.f6815a = constraintLayout;
        this.b = textView;
        this.c = textView2;
        this.d = constraintLayout2;
        this.e = textView3;
        this.f = textView4;
        this.g = constraintLayout3;
        this.h = constraintLayout4;
        this.i = imageView;
        this.j = textView5;
        this.k = textView6;
        this.l = textView7;
        this.m = textView8;
        this.n = textView9;
        this.o = textView10;
    }

    public static FragmentSettingBinding a(View view) {
        View view2 = view;
        int i2 = R.id.about_superapp;
        TextView textView = (TextView) ViewBindings.a(view2, i2);
        if (textView != null) {
            i2 = R.id.account_center;
            TextView textView2 = (TextView) ViewBindings.a(view2, i2);
            if (textView2 != null) {
                i2 = R.id.account_center_layout;
                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.a(view2, i2);
                if (constraintLayout != null) {
                    i2 = R.id.account_logout;
                    TextView textView3 = (TextView) ViewBindings.a(view2, i2);
                    if (textView3 != null) {
                        i2 = R.id.cac_tv;
                        TextView textView4 = (TextView) ViewBindings.a(view2, i2);
                        if (textView4 != null) {
                            i2 = R.id.help_about_layout;
                            ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.a(view2, i2);
                            if (constraintLayout2 != null) {
                                i2 = R.id.information_list_layout;
                                ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.a(view2, i2);
                                if (constraintLayout3 != null) {
                                    i2 = R.id.need_update_version;
                                    ImageView imageView = (ImageView) ViewBindings.a(view2, i2);
                                    if (imageView != null) {
                                        i2 = R.id.permission_manager;
                                        TextView textView5 = (TextView) ViewBindings.a(view2, i2);
                                        if (textView5 != null) {
                                            i2 = R.id.personal_info;
                                            TextView textView6 = (TextView) ViewBindings.a(view2, i2);
                                            if (textView6 != null) {
                                                i2 = R.id.privacy_policy;
                                                TextView textView7 = (TextView) ViewBindings.a(view2, i2);
                                                if (textView7 != null) {
                                                    i2 = R.id.recordation;
                                                    TextView textView8 = (TextView) ViewBindings.a(view2, i2);
                                                    if (textView8 != null) {
                                                        i2 = R.id.setting_back_title;
                                                        TextView textView9 = (TextView) ViewBindings.a(view2, i2);
                                                        if (textView9 != null) {
                                                            i2 = R.id.third_share;
                                                            TextView textView10 = (TextView) ViewBindings.a(view2, i2);
                                                            if (textView10 != null) {
                                                                return new FragmentSettingBinding((ConstraintLayout) view2, textView, textView2, constraintLayout, textView3, textView4, constraintLayout2, constraintLayout3, imageView, textView5, textView6, textView7, textView8, textView9, textView10);
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

    public static FragmentSettingBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_setting, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6815a;
    }
}
