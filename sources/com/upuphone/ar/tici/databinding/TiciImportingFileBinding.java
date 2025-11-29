package com.upuphone.ar.tici.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.ar.tici.R;

public final class TiciImportingFileBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f5866a;
    public final TextView b;
    public final TextView c;

    public TiciImportingFileBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2) {
        this.f5866a = constraintLayout;
        this.b = textView;
        this.c = textView2;
    }

    public static TiciImportingFileBinding a(View view) {
        int i = R.id.tv_file_name;
        TextView textView = (TextView) ViewBindings.a(view, i);
        if (textView != null) {
            i = R.id.tv_importing;
            TextView textView2 = (TextView) ViewBindings.a(view, i);
            if (textView2 != null) {
                return new TiciImportingFileBinding((ConstraintLayout) view, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f5866a;
    }
}
