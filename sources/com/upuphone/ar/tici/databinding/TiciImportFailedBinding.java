package com.upuphone.ar.tici.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.ar.tici.R;

public final class TiciImportFailedBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f5865a;
    public final TextView b;

    public TiciImportFailedBinding(ConstraintLayout constraintLayout, TextView textView) {
        this.f5865a = constraintLayout;
        this.b = textView;
    }

    public static TiciImportFailedBinding a(View view) {
        int i = R.id.tv_failed;
        TextView textView = (TextView) ViewBindings.a(view, i);
        if (textView != null) {
            return new TiciImportFailedBinding((ConstraintLayout) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f5865a;
    }
}
