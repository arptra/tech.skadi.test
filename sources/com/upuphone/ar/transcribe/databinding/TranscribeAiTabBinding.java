package com.upuphone.ar.transcribe.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.ar.transcribe.R;

public final class TranscribeAiTabBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6042a;
    public final TextView b;

    public TranscribeAiTabBinding(ConstraintLayout constraintLayout, TextView textView) {
        this.f6042a = constraintLayout;
        this.b = textView;
    }

    public static TranscribeAiTabBinding a(View view) {
        int i = R.id.tv_tab;
        TextView textView = (TextView) ViewBindings.a(view, i);
        if (textView != null) {
            return new TranscribeAiTabBinding((ConstraintLayout) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static TranscribeAiTabBinding c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static TranscribeAiTabBinding d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.transcribe_ai_tab, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6042a;
    }
}
