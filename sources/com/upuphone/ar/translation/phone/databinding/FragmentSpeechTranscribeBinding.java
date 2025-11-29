package com.upuphone.ar.translation.phone.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.upuphone.ar.translation.phone.R;

public final class FragmentSpeechTranscribeBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6245a;
    public final ConstraintLayout b;
    public final ConstraintLayout c;
    public final Group d;
    public final ImageView e;
    public final LottieAnimationView f;
    public final LottieAnimationView g;
    public final TextView h;
    public final TextView i;
    public final TextView j;

    public FragmentSpeechTranscribeBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, Group group, ImageView imageView, LottieAnimationView lottieAnimationView, LottieAnimationView lottieAnimationView2, TextView textView, TextView textView2, TextView textView3) {
        this.f6245a = constraintLayout;
        this.b = constraintLayout2;
        this.c = constraintLayout3;
        this.d = group;
        this.e = imageView;
        this.f = lottieAnimationView;
        this.g = lottieAnimationView2;
        this.h = textView;
        this.i = textView2;
        this.j = textView3;
    }

    public static FragmentSpeechTranscribeBinding a(View view) {
        int i2 = R.id.cl_transcribe_btn;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.a(view, i2);
        if (constraintLayout != null) {
            i2 = R.id.cl_transcribe_func;
            ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.a(view, i2);
            if (constraintLayout2 != null) {
                i2 = R.id.gp_transcribe_running;
                Group group = (Group) ViewBindings.a(view, i2);
                if (group != null) {
                    i2 = R.id.iv_transcribe_mark;
                    ImageView imageView = (ImageView) ViewBindings.a(view, i2);
                    if (imageView != null) {
                        i2 = R.id.lottie_transcribe_loading;
                        LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.a(view, i2);
                        if (lottieAnimationView != null) {
                            i2 = R.id.lottie_transcribe_running;
                            LottieAnimationView lottieAnimationView2 = (LottieAnimationView) ViewBindings.a(view, i2);
                            if (lottieAnimationView2 != null) {
                                i2 = R.id.tv_transcribe_btn;
                                TextView textView = (TextView) ViewBindings.a(view, i2);
                                if (textView != null) {
                                    i2 = R.id.tv_transcribe_running;
                                    TextView textView2 = (TextView) ViewBindings.a(view, i2);
                                    if (textView2 != null) {
                                        i2 = R.id.tv_transcribe_src;
                                        TextView textView3 = (TextView) ViewBindings.a(view, i2);
                                        if (textView3 != null) {
                                            return new FragmentSpeechTranscribeBinding((ConstraintLayout) view, constraintLayout, constraintLayout2, group, imageView, lottieAnimationView, lottieAnimationView2, textView, textView2, textView3);
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

    public static FragmentSpeechTranscribeBinding c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentSpeechTranscribeBinding d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_speech_transcribe, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6245a;
    }
}
