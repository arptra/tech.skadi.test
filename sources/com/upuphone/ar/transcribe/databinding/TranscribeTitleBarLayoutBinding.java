package com.upuphone.ar.transcribe.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.ar.transcribe.R;

public final class TranscribeTitleBarLayoutBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6051a;
    public final ImageView b;
    public final ImageView c;
    public final ImageView d;
    public final ImageView e;
    public final TextView f;
    public final TextView g;

    public TranscribeTitleBarLayoutBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, TextView textView, TextView textView2) {
        this.f6051a = constraintLayout;
        this.b = imageView;
        this.c = imageView2;
        this.d = imageView3;
        this.e = imageView4;
        this.f = textView;
        this.g = textView2;
    }

    public static TranscribeTitleBarLayoutBinding a(View view) {
        int i = R.id.ivBack;
        ImageView imageView = (ImageView) ViewBindings.a(view, i);
        if (imageView != null) {
            i = R.id.ivMenu;
            ImageView imageView2 = (ImageView) ViewBindings.a(view, i);
            if (imageView2 != null) {
                i = R.id.ivMenu2;
                ImageView imageView3 = (ImageView) ViewBindings.a(view, i);
                if (imageView3 != null) {
                    i = R.id.ivMenu3;
                    ImageView imageView4 = (ImageView) ViewBindings.a(view, i);
                    if (imageView4 != null) {
                        i = R.id.tvMenu;
                        TextView textView = (TextView) ViewBindings.a(view, i);
                        if (textView != null) {
                            i = R.id.tvTitle;
                            TextView textView2 = (TextView) ViewBindings.a(view, i);
                            if (textView2 != null) {
                                return new TranscribeTitleBarLayoutBinding((ConstraintLayout) view, imageView, imageView2, imageView3, imageView4, textView, textView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static TranscribeTitleBarLayoutBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.transcribe_title_bar_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6051a;
    }
}
