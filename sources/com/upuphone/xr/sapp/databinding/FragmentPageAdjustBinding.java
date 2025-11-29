package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.meizu.common.widget.StepSeekBar;
import com.upuphone.xr.sapp.R;

public final class FragmentPageAdjustBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6809a;
    public final StepSeekBar b;
    public final AppCompatTextView c;
    public final TextView d;
    public final AppCompatImageView e;
    public final AppCompatImageView f;
    public final StepSeekBar g;
    public final AppCompatTextView h;
    public final AppCompatTextView i;
    public final StepSeekBar j;
    public final AppCompatTextView k;
    public final ConstraintLayout l;

    public FragmentPageAdjustBinding(ConstraintLayout constraintLayout, StepSeekBar stepSeekBar, AppCompatTextView appCompatTextView, TextView textView, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, StepSeekBar stepSeekBar2, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, StepSeekBar stepSeekBar3, AppCompatTextView appCompatTextView4, ConstraintLayout constraintLayout2) {
        this.f6809a = constraintLayout;
        this.b = stepSeekBar;
        this.c = appCompatTextView;
        this.d = textView;
        this.e = appCompatImageView;
        this.f = appCompatImageView2;
        this.g = stepSeekBar2;
        this.h = appCompatTextView2;
        this.i = appCompatTextView3;
        this.j = stepSeekBar3;
        this.k = appCompatTextView4;
        this.l = constraintLayout2;
    }

    public static FragmentPageAdjustBinding a(View view) {
        int i2 = R.id.page_adjust_angle_step;
        StepSeekBar stepSeekBar = (StepSeekBar) ViewBindings.a(view, i2);
        if (stepSeekBar != null) {
            i2 = R.id.page_adjust_angle_txt;
            AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.a(view, i2);
            if (appCompatTextView != null) {
                i2 = R.id.page_adjust_back;
                TextView textView = (TextView) ViewBindings.a(view, i2);
                if (textView != null) {
                    i2 = R.id.page_adjust_bg;
                    AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.a(view, i2);
                    if (appCompatImageView != null) {
                        i2 = R.id.page_adjust_dock;
                        AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.a(view, i2);
                        if (appCompatImageView2 != null) {
                            i2 = R.id.page_adjust_left_right_step;
                            StepSeekBar stepSeekBar2 = (StepSeekBar) ViewBindings.a(view, i2);
                            if (stepSeekBar2 != null) {
                                i2 = R.id.page_adjust_left_right_txt;
                                AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.a(view, i2);
                                if (appCompatTextView2 != null) {
                                    i2 = R.id.page_adjust_reset;
                                    AppCompatTextView appCompatTextView3 = (AppCompatTextView) ViewBindings.a(view, i2);
                                    if (appCompatTextView3 != null) {
                                        i2 = R.id.page_adjust_up_down_step;
                                        StepSeekBar stepSeekBar3 = (StepSeekBar) ViewBindings.a(view, i2);
                                        if (stepSeekBar3 != null) {
                                            i2 = R.id.page_adjust_up_down_txt;
                                            AppCompatTextView appCompatTextView4 = (AppCompatTextView) ViewBindings.a(view, i2);
                                            if (appCompatTextView4 != null) {
                                                i2 = R.id.rootView;
                                                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.a(view, i2);
                                                if (constraintLayout != null) {
                                                    return new FragmentPageAdjustBinding((ConstraintLayout) view, stepSeekBar, appCompatTextView, textView, appCompatImageView, appCompatImageView2, stepSeekBar2, appCompatTextView2, appCompatTextView3, stepSeekBar3, appCompatTextView4, constraintLayout);
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

    public static FragmentPageAdjustBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_page_adjust, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6809a;
    }
}
