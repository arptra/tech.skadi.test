package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.meizu.common.widget.MzButton;
import com.upuphone.xr.sapp.R;

public final class DialogNetworkErrorBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6755a;
    public final MzButton b;
    public final TextView c;

    public DialogNetworkErrorBinding(ConstraintLayout constraintLayout, MzButton mzButton, TextView textView) {
        this.f6755a = constraintLayout;
        this.b = mzButton;
        this.c = textView;
    }

    public static DialogNetworkErrorBinding a(View view) {
        int i = R.id.sure;
        MzButton mzButton = (MzButton) ViewBindings.a(view, i);
        if (mzButton != null) {
            i = R.id.tv_content;
            TextView textView = (TextView) ViewBindings.a(view, i);
            if (textView != null) {
                return new DialogNetworkErrorBinding((ConstraintLayout) view, mzButton, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static DialogNetworkErrorBinding c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static DialogNetworkErrorBinding d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_network_error, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6755a;
    }
}
