package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.xr.sapp.R;

public final class FragmentCommonH5Binding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6776a;
    public final TextView b;
    public final LinearLayout c;
    public final TextView d;
    public final TextView e;
    public final ConstraintLayout f;
    public final FrameLayout g;

    public FragmentCommonH5Binding(ConstraintLayout constraintLayout, TextView textView, LinearLayout linearLayout, TextView textView2, TextView textView3, ConstraintLayout constraintLayout2, FrameLayout frameLayout) {
        this.f6776a = constraintLayout;
        this.b = textView;
        this.c = linearLayout;
        this.d = textView2;
        this.e = textView3;
        this.f = constraintLayout2;
        this.g = frameLayout;
    }

    public static FragmentCommonH5Binding a(View view) {
        int i = R.id.back_title;
        TextView textView = (TextView) ViewBindings.a(view, i);
        if (textView != null) {
            i = R.id.error_info;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.a(view, i);
            if (linearLayout != null) {
                i = R.id.error_info_set;
                TextView textView2 = (TextView) ViewBindings.a(view, i);
                if (textView2 != null) {
                    i = R.id.error_info_tips;
                    TextView textView3 = (TextView) ViewBindings.a(view, i);
                    if (textView3 != null) {
                        i = R.id.help_main;
                        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.a(view, i);
                        if (constraintLayout != null) {
                            i = R.id.webviewContainer;
                            FrameLayout frameLayout = (FrameLayout) ViewBindings.a(view, i);
                            if (frameLayout != null) {
                                return new FragmentCommonH5Binding((ConstraintLayout) view, textView, linearLayout, textView2, textView3, constraintLayout, frameLayout);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static FragmentCommonH5Binding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_common_h5, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6776a;
    }
}
