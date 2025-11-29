package com.upuphone.ar.translation.phone.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.upuphone.ar.translation.phone.R;

public final class ItemBroadcastAudioTtsBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6248a;
    public final ConstraintLayout b;
    public final ImageView c;
    public final LottieAnimationView d;
    public final TextView e;
    public final TextView f;

    public ItemBroadcastAudioTtsBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ImageView imageView, LottieAnimationView lottieAnimationView, TextView textView, TextView textView2) {
        this.f6248a = constraintLayout;
        this.b = constraintLayout2;
        this.c = imageView;
        this.d = lottieAnimationView;
        this.e = textView;
        this.f = textView2;
    }

    public static ItemBroadcastAudioTtsBinding a(View view) {
        int i = R.id.cl_item_single_choice;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.a(view, i);
        if (constraintLayout != null) {
            i = R.id.iv_item_selected;
            ImageView imageView = (ImageView) ViewBindings.a(view, i);
            if (imageView != null) {
                i = R.id.lottie_audio_playing;
                LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.a(view, i);
                if (lottieAnimationView != null) {
                    i = R.id.tv_item_tips;
                    TextView textView = (TextView) ViewBindings.a(view, i);
                    if (textView != null) {
                        i = R.id.tv_item_title;
                        TextView textView2 = (TextView) ViewBindings.a(view, i);
                        if (textView2 != null) {
                            return new ItemBroadcastAudioTtsBinding((ConstraintLayout) view, constraintLayout, imageView, lottieAnimationView, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ItemBroadcastAudioTtsBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_broadcast_audio_tts, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6248a;
    }
}
