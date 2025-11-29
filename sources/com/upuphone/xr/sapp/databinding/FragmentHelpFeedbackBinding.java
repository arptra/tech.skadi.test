package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.xr.sapp.R;

public final class FragmentHelpFeedbackBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6796a;
    public final TextView b;
    public final TextView c;
    public final TextView d;
    public final ConstraintLayout e;
    public final TextView f;
    public final ConstraintLayout g;
    public final LinearLayout h;
    public final LinearLayout i;
    public final LinearLayout j;
    public final TextView k;

    public FragmentHelpFeedbackBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2, TextView textView3, ConstraintLayout constraintLayout2, TextView textView4, ConstraintLayout constraintLayout3, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, TextView textView5) {
        this.f6796a = constraintLayout;
        this.b = textView;
        this.c = textView2;
        this.d = textView3;
        this.e = constraintLayout2;
        this.f = textView4;
        this.g = constraintLayout3;
        this.h = linearLayout;
        this.i = linearLayout2;
        this.j = linearLayout3;
        this.k = textView5;
    }

    public static FragmentHelpFeedbackBinding a(View view) {
        int i2 = R.id.common_problem;
        TextView textView = (TextView) ViewBindings.a(view, i2);
        if (textView != null) {
            i2 = R.id.frequently_asked;
            TextView textView2 = (TextView) ViewBindings.a(view, i2);
            if (textView2 != null) {
                i2 = R.id.glass_guide;
                TextView textView3 = (TextView) ViewBindings.a(view, i2);
                if (textView3 != null) {
                    i2 = R.id.help_about_layout;
                    ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.a(view, i2);
                    if (constraintLayout != null) {
                        i2 = R.id.help_feedback_back_title;
                        TextView textView4 = (TextView) ViewBindings.a(view, i2);
                        if (textView4 != null) {
                            i2 = R.id.help_feedback_layout;
                            ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.a(view, i2);
                            if (constraintLayout2 != null) {
                                i2 = R.id.ll_consultation;
                                LinearLayout linearLayout = (LinearLayout) ViewBindings.a(view, i2);
                                if (linearLayout != null) {
                                    i2 = R.id.ll_telephone;
                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.a(view, i2);
                                    if (linearLayout2 != null) {
                                        i2 = R.id.ll_wechat;
                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.a(view, i2);
                                        if (linearLayout3 != null) {
                                            i2 = R.id.service_police;
                                            TextView textView5 = (TextView) ViewBindings.a(view, i2);
                                            if (textView5 != null) {
                                                return new FragmentHelpFeedbackBinding((ConstraintLayout) view, textView, textView2, textView3, constraintLayout, textView4, constraintLayout2, linearLayout, linearLayout2, linearLayout3, textView5);
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

    public static FragmentHelpFeedbackBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_help_feedback, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6796a;
    }
}
