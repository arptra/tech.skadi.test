package com.upuphone.xr.sapp.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.meizu.common.widget.MzButton;
import com.upuphone.xr.sapp.R;

public final class FragmentVoiceprintSrRecordingFailedBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6830a;
    public final LottieAnimationView b;
    public final MzButton c;
    public final TextView d;
    public final TextView e;

    public FragmentVoiceprintSrRecordingFailedBinding(ConstraintLayout constraintLayout, LottieAnimationView lottieAnimationView, MzButton mzButton, TextView textView, TextView textView2) {
        this.f6830a = constraintLayout;
        this.b = lottieAnimationView;
        this.c = mzButton;
        this.d = textView;
        this.e = textView2;
    }

    public static FragmentVoiceprintSrRecordingFailedBinding a(View view) {
        int i = R.id.lottie_fail;
        LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.a(view, i);
        if (lottieAnimationView != null) {
            i = R.id.mbt_re_entry;
            MzButton mzButton = (MzButton) ViewBindings.a(view, i);
            if (mzButton != null) {
                i = R.id.tv_failed_content;
                TextView textView = (TextView) ViewBindings.a(view, i);
                if (textView != null) {
                    i = R.id.tv_failed_title;
                    TextView textView2 = (TextView) ViewBindings.a(view, i);
                    if (textView2 != null) {
                        return new FragmentVoiceprintSrRecordingFailedBinding((ConstraintLayout) view, lottieAnimationView, mzButton, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6830a;
    }
}
