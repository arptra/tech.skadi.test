package com.upuphone.ar.transcribe.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.ar.transcribe.R;

public final class TranscribeFuncItemLayoutBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6044a;
    public final FrameLayout b;
    public final ImageView c;
    public final TextView d;
    public final TextView e;

    public TranscribeFuncItemLayoutBinding(ConstraintLayout constraintLayout, FrameLayout frameLayout, ImageView imageView, TextView textView, TextView textView2) {
        this.f6044a = constraintLayout;
        this.b = frameLayout;
        this.c = imageView;
        this.d = textView;
        this.e = textView2;
    }

    public static TranscribeFuncItemLayoutBinding a(View view) {
        int i = R.id.fl_subtitle;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.a(view, i);
        if (frameLayout != null) {
            i = R.id.iv_func_icon;
            ImageView imageView = (ImageView) ViewBindings.a(view, i);
            if (imageView != null) {
                i = R.id.tv_subtitle;
                TextView textView = (TextView) ViewBindings.a(view, i);
                if (textView != null) {
                    i = R.id.tv_title;
                    TextView textView2 = (TextView) ViewBindings.a(view, i);
                    if (textView2 != null) {
                        return new TranscribeFuncItemLayoutBinding((ConstraintLayout) view, frameLayout, imageView, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static TranscribeFuncItemLayoutBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.transcribe_func_item_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6044a;
    }
}
