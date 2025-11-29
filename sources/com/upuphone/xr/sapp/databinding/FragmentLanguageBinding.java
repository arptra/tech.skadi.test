package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.xr.sapp.R;

public final class FragmentLanguageBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6798a;
    public final TextView b;
    public final RecyclerView c;
    public final ConstraintLayout d;

    public FragmentLanguageBinding(ConstraintLayout constraintLayout, TextView textView, RecyclerView recyclerView, ConstraintLayout constraintLayout2) {
        this.f6798a = constraintLayout;
        this.b = textView;
        this.c = recyclerView;
        this.d = constraintLayout2;
    }

    public static FragmentLanguageBinding a(View view) {
        int i = R.id.language_back;
        TextView textView = (TextView) ViewBindings.a(view, i);
        if (textView != null) {
            i = R.id.language_rv;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.a(view, i);
            if (recyclerView != null) {
                i = R.id.rootView;
                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.a(view, i);
                if (constraintLayout != null) {
                    return new FragmentLanguageBinding((ConstraintLayout) view, textView, recyclerView, constraintLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static FragmentLanguageBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_language, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6798a;
    }
}
