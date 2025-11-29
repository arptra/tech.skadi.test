package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.upuphone.xr.sapp.R;
import org.libpag.PAGImageView;

public final class WakeupRecordingFragmentBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6902a;
    public final AppCompatTextView b;
    public final AppCompatTextView c;
    public final LottieAnimationView d;
    public final PAGImageView e;
    public final AppCompatTextView f;

    public WakeupRecordingFragmentBinding(ConstraintLayout constraintLayout, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, LottieAnimationView lottieAnimationView, PAGImageView pAGImageView, AppCompatTextView appCompatTextView3) {
        this.f6902a = constraintLayout;
        this.b = appCompatTextView;
        this.c = appCompatTextView2;
        this.d = lottieAnimationView;
        this.e = pAGImageView;
        this.f = appCompatTextView3;
    }

    public static WakeupRecordingFragmentBinding a(View view) {
        int i = R.id.cancel_button;
        AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.a(view, i);
        if (appCompatTextView != null) {
            i = R.id.count_text;
            AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.a(view, i);
            if (appCompatTextView2 != null) {
                i = R.id.record_success_icon;
                LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.a(view, i);
                if (lottieAnimationView != null) {
                    i = R.id.voice_animation;
                    PAGImageView pAGImageView = (PAGImageView) ViewBindings.a(view, i);
                    if (pAGImageView != null) {
                        i = R.id.wakeup_record_subtitle;
                        AppCompatTextView appCompatTextView3 = (AppCompatTextView) ViewBindings.a(view, i);
                        if (appCompatTextView3 != null) {
                            return new WakeupRecordingFragmentBinding((ConstraintLayout) view, appCompatTextView, appCompatTextView2, lottieAnimationView, pAGImageView, appCompatTextView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static WakeupRecordingFragmentBinding c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static WakeupRecordingFragmentBinding d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.wakeup_recording_fragment, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6902a;
    }
}
