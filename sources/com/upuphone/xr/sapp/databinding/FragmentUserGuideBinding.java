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
import com.meizu.common.widget.LoadingView;
import com.upuphone.xr.sapp.R;

public final class FragmentUserGuideBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6823a;
    public final TextView b;
    public final ConstraintLayout c;
    public final TextView d;
    public final TextView e;
    public final FrameLayout f;
    public final LoadingView g;
    public final LinearLayout h;
    public final LinearLayout i;
    public final LinearLayout j;
    public final TextView k;

    public FragmentUserGuideBinding(ConstraintLayout constraintLayout, TextView textView, ConstraintLayout constraintLayout2, TextView textView2, TextView textView3, FrameLayout frameLayout, LoadingView loadingView, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, TextView textView4) {
        this.f6823a = constraintLayout;
        this.b = textView;
        this.c = constraintLayout2;
        this.d = textView2;
        this.e = textView3;
        this.f = frameLayout;
        this.g = loadingView;
        this.h = linearLayout;
        this.i = linearLayout2;
        this.j = linearLayout3;
        this.k = textView4;
    }

    public static FragmentUserGuideBinding a(View view) {
        int i2 = R.id.back_title;
        TextView textView = (TextView) ViewBindings.a(view, i2);
        if (textView != null) {
            i2 = R.id.back_title_layout;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.a(view, i2);
            if (constraintLayout != null) {
                i2 = R.id.error_info_set;
                TextView textView2 = (TextView) ViewBindings.a(view, i2);
                if (textView2 != null) {
                    i2 = R.id.error_info_tips;
                    TextView textView3 = (TextView) ViewBindings.a(view, i2);
                    if (textView3 != null) {
                        i2 = R.id.fl_webview;
                        FrameLayout frameLayout = (FrameLayout) ViewBindings.a(view, i2);
                        if (frameLayout != null) {
                            i2 = R.id.loading_view;
                            LoadingView loadingView = (LoadingView) ViewBindings.a(view, i2);
                            if (loadingView != null) {
                                i2 = R.id.state_error_lay;
                                LinearLayout linearLayout = (LinearLayout) ViewBindings.a(view, i2);
                                if (linearLayout != null) {
                                    i2 = R.id.state_lay;
                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.a(view, i2);
                                    if (linearLayout2 != null) {
                                        i2 = R.id.state_loading_lay;
                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.a(view, i2);
                                        if (linearLayout3 != null) {
                                            i2 = R.id.tv_loading;
                                            TextView textView4 = (TextView) ViewBindings.a(view, i2);
                                            if (textView4 != null) {
                                                return new FragmentUserGuideBinding((ConstraintLayout) view, textView, constraintLayout, textView2, textView3, frameLayout, loadingView, linearLayout, linearLayout2, linearLayout3, textView4);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i2)));
    }

    public static FragmentUserGuideBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_user_guide, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6823a;
    }
}
