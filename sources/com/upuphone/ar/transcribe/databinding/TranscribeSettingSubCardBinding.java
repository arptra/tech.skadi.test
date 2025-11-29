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

public final class TranscribeSettingSubCardBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6049a;
    public final View b;
    public final ImageView c;
    public final TextView d;
    public final TextView e;
    public final TextView f;

    public TranscribeSettingSubCardBinding(ConstraintLayout constraintLayout, View view, ImageView imageView, TextView textView, TextView textView2, TextView textView3) {
        this.f6049a = constraintLayout;
        this.b = view;
        this.c = imageView;
        this.d = textView;
        this.e = textView2;
        this.f = textView3;
    }

    public static TranscribeSettingSubCardBinding a(View view) {
        int i = R.id.bg;
        View a2 = ViewBindings.a(view, i);
        if (a2 != null) {
            i = R.id.iv_voice_print;
            ImageView imageView = (ImageView) ViewBindings.a(view, i);
            if (imageView != null) {
                i = R.id.title;
                TextView textView = (TextView) ViewBindings.a(view, i);
                if (textView != null) {
                    i = R.id.tv_tips;
                    TextView textView2 = (TextView) ViewBindings.a(view, i);
                    if (textView2 != null) {
                        i = R.id.tv_tips2;
                        TextView textView3 = (TextView) ViewBindings.a(view, i);
                        if (textView3 != null) {
                            return new TranscribeSettingSubCardBinding((ConstraintLayout) view, a2, imageView, textView, textView2, textView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static TranscribeSettingSubCardBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.transcribe_setting_sub_card, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6049a;
    }
}
