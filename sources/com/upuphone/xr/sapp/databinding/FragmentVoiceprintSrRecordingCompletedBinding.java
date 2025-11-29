package com.upuphone.xr.sapp.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.meizu.common.widget.MzButton;
import com.upuphone.xr.sapp.R;

public final class FragmentVoiceprintSrRecordingCompletedBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6829a;
    public final LottieAnimationView b;
    public final MzButton c;
    public final MzButton d;

    public FragmentVoiceprintSrRecordingCompletedBinding(ConstraintLayout constraintLayout, LottieAnimationView lottieAnimationView, MzButton mzButton, MzButton mzButton2) {
        this.f6829a = constraintLayout;
        this.b = lottieAnimationView;
        this.c = mzButton;
        this.d = mzButton2;
    }

    public static FragmentVoiceprintSrRecordingCompletedBinding a(View view) {
        int i = R.id.lottie_success;
        LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.a(view, i);
        if (lottieAnimationView != null) {
            i = R.id.mbt_completed;
            MzButton mzButton = (MzButton) ViewBindings.a(view, i);
            if (mzButton != null) {
                i = R.id.mbt_wake;
                MzButton mzButton2 = (MzButton) ViewBindings.a(view, i);
                if (mzButton2 != null) {
                    return new FragmentVoiceprintSrRecordingCompletedBinding((ConstraintLayout) view, lottieAnimationView, mzButton, mzButton2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6829a;
    }
}
