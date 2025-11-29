package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.xr.sapp.R;

public final class FragmentHelpFeedbackH5Binding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6797a;
    public final TextView b;
    public final Barrier c;
    public final LinearLayout d;
    public final TextView e;
    public final TextView f;
    public final ConstraintLayout g;
    public final ConstraintLayout h;
    public final TextView i;
    public final SwipeRefreshLayout j;

    public FragmentHelpFeedbackH5Binding(ConstraintLayout constraintLayout, TextView textView, Barrier barrier, LinearLayout linearLayout, TextView textView2, TextView textView3, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, TextView textView4, SwipeRefreshLayout swipeRefreshLayout) {
        this.f6797a = constraintLayout;
        this.b = textView;
        this.c = barrier;
        this.d = linearLayout;
        this.e = textView2;
        this.f = textView3;
        this.g = constraintLayout2;
        this.h = constraintLayout3;
        this.i = textView4;
        this.j = swipeRefreshLayout;
    }

    public static FragmentHelpFeedbackH5Binding a(View view) {
        int i2 = R.id.back_title;
        TextView textView = (TextView) ViewBindings.a(view, i2);
        if (textView != null) {
            i2 = R.id.barrier;
            Barrier barrier = (Barrier) ViewBindings.a(view, i2);
            if (barrier != null) {
                i2 = R.id.error_info;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.a(view, i2);
                if (linearLayout != null) {
                    i2 = R.id.error_info_set;
                    TextView textView2 = (TextView) ViewBindings.a(view, i2);
                    if (textView2 != null) {
                        i2 = R.id.error_info_tips;
                        TextView textView3 = (TextView) ViewBindings.a(view, i2);
                        if (textView3 != null) {
                            i2 = R.id.help_main;
                            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.a(view, i2);
                            if (constraintLayout != null) {
                                i2 = R.id.problem_feedback_layout;
                                ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.a(view, i2);
                                if (constraintLayout2 != null) {
                                    i2 = R.id.problem_feedback_tv;
                                    TextView textView4 = (TextView) ViewBindings.a(view, i2);
                                    if (textView4 != null) {
                                        i2 = R.id.refreshlayout;
                                        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) ViewBindings.a(view, i2);
                                        if (swipeRefreshLayout != null) {
                                            return new FragmentHelpFeedbackH5Binding((ConstraintLayout) view, textView, barrier, linearLayout, textView2, textView3, constraintLayout, constraintLayout2, textView4, swipeRefreshLayout);
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

    public static FragmentHelpFeedbackH5Binding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_help_feedback_h5, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6797a;
    }
}
