package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.meizu.common.widget.MzButton;
import com.upuphone.xr.sapp.R;

public final class WakeupRecordFinishedFragmentBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6900a;
    public final AppCompatTextView b;
    public final MzButton c;
    public final MzButton d;
    public final LottieAnimationView e;
    public final AppCompatTextView f;
    public final AppCompatTextView g;

    public WakeupRecordFinishedFragmentBinding(ConstraintLayout constraintLayout, AppCompatTextView appCompatTextView, MzButton mzButton, MzButton mzButton2, LottieAnimationView lottieAnimationView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3) {
        this.f6900a = constraintLayout;
        this.b = appCompatTextView;
        this.c = mzButton;
        this.d = mzButton2;
        this.e = lottieAnimationView;
        this.f = appCompatTextView2;
        this.g = appCompatTextView3;
    }

    public static WakeupRecordFinishedFragmentBinding a(View view) {
        int i = R.id.exit_button;
        AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.a(view, i);
        if (appCompatTextView != null) {
            i = R.id.finished;
            MzButton mzButton = (MzButton) ViewBindings.a(view, i);
            if (mzButton != null) {
                i = R.id.record_more;
                MzButton mzButton2 = (MzButton) ViewBindings.a(view, i);
                if (mzButton2 != null) {
                    i = R.id.record_success_icon;
                    LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.a(view, i);
                    if (lottieAnimationView != null) {
                        i = R.id.wakeup_record_quiet;
                        AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.a(view, i);
                        if (appCompatTextView2 != null) {
                            i = R.id.wakeup_record_subtitle;
                            AppCompatTextView appCompatTextView3 = (AppCompatTextView) ViewBindings.a(view, i);
                            if (appCompatTextView3 != null) {
                                return new WakeupRecordFinishedFragmentBinding((ConstraintLayout) view, appCompatTextView, mzButton, mzButton2, lottieAnimationView, appCompatTextView2, appCompatTextView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static WakeupRecordFinishedFragmentBinding c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static WakeupRecordFinishedFragmentBinding d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.wakeup_record_finished_fragment, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6900a;
    }
}
