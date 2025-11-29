package com.upuphone.ar.translation.phone.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.ar.translation.phone.R;

public final class LayoutTlDialogCustomTitleBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6258a;
    public final TextView b;
    public final TextView c;

    public LayoutTlDialogCustomTitleBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2) {
        this.f6258a = constraintLayout;
        this.b = textView;
        this.c = textView2;
    }

    public static LayoutTlDialogCustomTitleBinding a(View view) {
        int i = R.id.tv_dialog_message;
        TextView textView = (TextView) ViewBindings.a(view, i);
        if (textView != null) {
            i = R.id.tv_dialog_title;
            TextView textView2 = (TextView) ViewBindings.a(view, i);
            if (textView2 != null) {
                return new LayoutTlDialogCustomTitleBinding((ConstraintLayout) view, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static LayoutTlDialogCustomTitleBinding c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static LayoutTlDialogCustomTitleBinding d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.layout_tl_dialog_custom_title, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6258a;
    }
}
