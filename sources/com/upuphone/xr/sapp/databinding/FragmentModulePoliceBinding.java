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

public final class FragmentModulePoliceBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6807a;
    public final TextView b;
    public final TextView c;
    public final TextView d;
    public final TextView e;
    public final TextView f;
    public final TextView g;
    public final TextView h;
    public final NestedScrollView i;
    public final TextView j;

    public FragmentModulePoliceBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, NestedScrollView nestedScrollView, TextView textView8) {
        this.f6807a = constraintLayout;
        this.b = textView;
        this.c = textView2;
        this.d = textView3;
        this.e = textView4;
        this.f = textView5;
        this.g = textView6;
        this.h = textView7;
        this.i = nestedScrollView;
        this.j = textView8;
    }

    public static FragmentModulePoliceBinding a(View view) {
        int i2 = R.id.app_cancel_agree;
        TextView textView = (TextView) ViewBindings.a(view, i2);
        if (textView != null) {
            i2 = R.id.app_cancel_agree_bottom;
            TextView textView2 = (TextView) ViewBindings.a(view, i2);
            if (textView2 != null) {
                i2 = R.id.app_cancel_agree_top;
                TextView textView3 = (TextView) ViewBindings.a(view, i2);
                if (textView3 != null) {
                    i2 = R.id.cancel_ai_assistan_agree;
                    TextView textView4 = (TextView) ViewBindings.a(view, i2);
                    if (textView4 != null) {
                        i2 = R.id.cancel_navi_agree;
                        TextView textView5 = (TextView) ViewBindings.a(view, i2);
                        if (textView5 != null) {
                            i2 = R.id.cancel_tici_agree;
                            TextView textView6 = (TextView) ViewBindings.a(view, i2);
                            if (textView6 != null) {
                                i2 = R.id.cancel_translator_agree;
                                TextView textView7 = (TextView) ViewBindings.a(view, i2);
                                if (textView7 != null) {
                                    i2 = R.id.fragment_scroll_layout;
                                    NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.a(view, i2);
                                    if (nestedScrollView != null) {
                                        i2 = R.id.module_cancel_agree_title;
                                        TextView textView8 = (TextView) ViewBindings.a(view, i2);
                                        if (textView8 != null) {
                                            return new FragmentModulePoliceBinding((ConstraintLayout) view, textView, textView2, textView3, textView4, textView5, textView6, textView7, nestedScrollView, textView8);
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

    public static FragmentModulePoliceBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_module_police, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6807a;
    }
}
