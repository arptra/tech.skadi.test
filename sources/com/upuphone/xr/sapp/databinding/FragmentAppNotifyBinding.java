package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.meizu.common.widget.Switch;
import com.upuphone.xr.sapp.R;

public final class FragmentAppNotifyBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6773a;
    public final ConstraintLayout b;
    public final AppCompatImageView c;
    public final AppCompatTextView d;
    public final TextView e;
    public final LinearLayout f;
    public final AppCompatTextView g;
    public final ConstraintLayout h;
    public final AppCompatImageView i;
    public final AppCompatTextView j;
    public final LinearLayout k;
    public final Switch l;
    public final TextView m;
    public final ConstraintLayout n;

    public FragmentAppNotifyBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView, TextView textView, LinearLayout linearLayout, AppCompatTextView appCompatTextView2, ConstraintLayout constraintLayout3, AppCompatImageView appCompatImageView2, AppCompatTextView appCompatTextView3, LinearLayout linearLayout2, Switch switchR, TextView textView2, ConstraintLayout constraintLayout4) {
        this.f6773a = constraintLayout;
        this.b = constraintLayout2;
        this.c = appCompatImageView;
        this.d = appCompatTextView;
        this.e = textView;
        this.f = linearLayout;
        this.g = appCompatTextView2;
        this.h = constraintLayout3;
        this.i = appCompatImageView2;
        this.j = appCompatTextView3;
        this.k = linearLayout2;
        this.l = switchR;
        this.m = textView2;
        this.n = constraintLayout4;
    }

    public static FragmentAppNotifyBinding a(View view) {
        View view2 = view;
        int i2 = R.id.app_notify_all_lay;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.a(view2, i2);
        if (constraintLayout != null) {
            i2 = R.id.app_notify_all_select;
            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.a(view2, i2);
            if (appCompatImageView != null) {
                i2 = R.id.app_notify_all_title;
                AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.a(view2, i2);
                if (appCompatTextView != null) {
                    i2 = R.id.app_notify_back;
                    TextView textView = (TextView) ViewBindings.a(view2, i2);
                    if (textView != null) {
                        i2 = R.id.app_notify_choose;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.a(view2, i2);
                        if (linearLayout != null) {
                            i2 = R.id.app_notify_important_desc;
                            AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.a(view2, i2);
                            if (appCompatTextView2 != null) {
                                i2 = R.id.app_notify_important_lay;
                                ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.a(view2, i2);
                                if (constraintLayout2 != null) {
                                    i2 = R.id.app_notify_important_select;
                                    AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.a(view2, i2);
                                    if (appCompatImageView2 != null) {
                                        i2 = R.id.app_notify_important_title;
                                        AppCompatTextView appCompatTextView3 = (AppCompatTextView) ViewBindings.a(view2, i2);
                                        if (appCompatTextView3 != null) {
                                            i2 = R.id.app_notify_setting;
                                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.a(view2, i2);
                                            if (linearLayout2 != null) {
                                                i2 = R.id.app_notify_switch;
                                                Switch switchR = (Switch) ViewBindings.a(view2, i2);
                                                if (switchR != null) {
                                                    i2 = R.id.app_notify_title;
                                                    TextView textView2 = (TextView) ViewBindings.a(view2, i2);
                                                    if (textView2 != null) {
                                                        i2 = R.id.phone_notify_item;
                                                        ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.a(view2, i2);
                                                        if (constraintLayout3 != null) {
                                                            return new FragmentAppNotifyBinding((ConstraintLayout) view2, constraintLayout, appCompatImageView, appCompatTextView, textView, linearLayout, appCompatTextView2, constraintLayout2, appCompatImageView2, appCompatTextView3, linearLayout2, switchR, textView2, constraintLayout3);
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

    public static FragmentAppNotifyBinding c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentAppNotifyBinding d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_app_notify, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6773a;
    }
}
