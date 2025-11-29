package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.xr.sapp.R;

public final class FragmentFontSizeBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6785a;
    public final TextView b;
    public final CheckedTextView c;
    public final CheckedTextView d;
    public final LinearLayout e;
    public final ConstraintLayout f;

    public FragmentFontSizeBinding(ConstraintLayout constraintLayout, TextView textView, CheckedTextView checkedTextView, CheckedTextView checkedTextView2, LinearLayout linearLayout, ConstraintLayout constraintLayout2) {
        this.f6785a = constraintLayout;
        this.b = textView;
        this.c = checkedTextView;
        this.d = checkedTextView2;
        this.e = linearLayout;
        this.f = constraintLayout2;
    }

    public static FragmentFontSizeBinding a(View view) {
        int i = R.id.fount_size_back;
        TextView textView = (TextView) ViewBindings.a(view, i);
        if (textView != null) {
            i = R.id.fount_size_big;
            CheckedTextView checkedTextView = (CheckedTextView) ViewBindings.a(view, i);
            if (checkedTextView != null) {
                i = R.id.fount_size_normal;
                CheckedTextView checkedTextView2 = (CheckedTextView) ViewBindings.a(view, i);
                if (checkedTextView2 != null) {
                    i = R.id.fount_size_select_lay;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.a(view, i);
                    if (linearLayout != null) {
                        i = R.id.rootView;
                        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.a(view, i);
                        if (constraintLayout != null) {
                            return new FragmentFontSizeBinding((ConstraintLayout) view, textView, checkedTextView, checkedTextView2, linearLayout, constraintLayout);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static FragmentFontSizeBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_font_size, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6785a;
    }
}
