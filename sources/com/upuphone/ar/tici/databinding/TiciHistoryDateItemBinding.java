package com.upuphone.ar.tici.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.ar.tici.R;

public final class TiciHistoryDateItemBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final FrameLayout f5863a;
    public final TextView b;

    public TiciHistoryDateItemBinding(FrameLayout frameLayout, TextView textView) {
        this.f5863a = frameLayout;
        this.b = textView;
    }

    public static TiciHistoryDateItemBinding a(View view) {
        int i = R.id.date_text;
        TextView textView = (TextView) ViewBindings.a(view, i);
        if (textView != null) {
            return new TiciHistoryDateItemBinding((FrameLayout) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    /* renamed from: b */
    public FrameLayout getRoot() {
        return this.f5863a;
    }
}
