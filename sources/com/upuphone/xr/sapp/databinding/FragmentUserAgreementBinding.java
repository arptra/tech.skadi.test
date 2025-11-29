package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.xr.sapp.R;

public final class FragmentUserAgreementBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6822a;
    public final TextView b;
    public final TextView c;
    public final NestedScrollView d;
    public final TextView e;

    public FragmentUserAgreementBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2, NestedScrollView nestedScrollView, TextView textView3) {
        this.f6822a = constraintLayout;
        this.b = textView;
        this.c = textView2;
        this.d = nestedScrollView;
        this.e = textView3;
    }

    public static FragmentUserAgreementBinding a(View view) {
        int i = R.id.back_title;
        TextView textView = (TextView) ViewBindings.a(view, i);
        if (textView != null) {
            i = R.id.confirm_button;
            TextView textView2 = (TextView) ViewBindings.a(view, i);
            if (textView2 != null) {
                i = R.id.scroll_view;
                NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.a(view, i);
                if (nestedScrollView != null) {
                    i = R.id.tv_user_agreement;
                    TextView textView3 = (TextView) ViewBindings.a(view, i);
                    if (textView3 != null) {
                        return new FragmentUserAgreementBinding((ConstraintLayout) view, textView, textView2, nestedScrollView, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static FragmentUserAgreementBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_user_agreement, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6822a;
    }
}
