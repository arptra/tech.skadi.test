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

public final class FragmentVuAboutGlassBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6831a;
    public final TextView b;
    public final ConstraintLayout c;
    public final TextView d;
    public final TextView e;
    public final ConstraintLayout f;
    public final TextView g;
    public final TextView h;
    public final TextView i;
    public final TextView j;
    public final ConstraintLayout k;
    public final TextView l;
    public final TextView m;
    public final TextView n;
    public final NestedScrollView o;

    public FragmentVuAboutGlassBinding(ConstraintLayout constraintLayout, TextView textView, ConstraintLayout constraintLayout2, TextView textView2, TextView textView3, ConstraintLayout constraintLayout3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, ConstraintLayout constraintLayout4, TextView textView8, TextView textView9, TextView textView10, NestedScrollView nestedScrollView) {
        this.f6831a = constraintLayout;
        this.b = textView;
        this.c = constraintLayout2;
        this.d = textView2;
        this.e = textView3;
        this.f = constraintLayout3;
        this.g = textView4;
        this.h = textView5;
        this.i = textView6;
        this.j = textView7;
        this.k = constraintLayout4;
        this.l = textView8;
        this.m = textView9;
        this.n = textView10;
        this.o = nestedScrollView;
    }

    public static FragmentVuAboutGlassBinding a(View view) {
        View view2 = view;
        int i2 = R.id.glass_info_back;
        TextView textView = (TextView) ViewBindings.a(view2, i2);
        if (textView != null) {
            i2 = R.id.glass_info_layout;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.a(view2, i2);
            if (constraintLayout != null) {
                i2 = R.id.glass_model;
                TextView textView2 = (TextView) ViewBindings.a(view2, i2);
                if (textView2 != null) {
                    i2 = R.id.glass_model_value;
                    TextView textView3 = (TextView) ViewBindings.a(view2, i2);
                    if (textView3 != null) {
                        i2 = R.id.glass_name_layout;
                        ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.a(view2, i2);
                        if (constraintLayout2 != null) {
                            i2 = R.id.glass_name_title;
                            TextView textView4 = (TextView) ViewBindings.a(view2, i2);
                            if (textView4 != null) {
                                i2 = R.id.glass_name_value;
                                TextView textView5 = (TextView) ViewBindings.a(view2, i2);
                                if (textView5 != null) {
                                    i2 = R.id.glass_regulatory_certification;
                                    TextView textView6 = (TextView) ViewBindings.a(view2, i2);
                                    if (textView6 != null) {
                                        i2 = R.id.glass_rom_version;
                                        TextView textView7 = (TextView) ViewBindings.a(view2, i2);
                                        if (textView7 != null) {
                                            i2 = R.id.glass_rom_version_layout;
                                            ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.a(view2, i2);
                                            if (constraintLayout3 != null) {
                                                i2 = R.id.glass_rom_version_value;
                                                TextView textView8 = (TextView) ViewBindings.a(view2, i2);
                                                if (textView8 != null) {
                                                    i2 = R.id.glass_serial_number;
                                                    TextView textView9 = (TextView) ViewBindings.a(view2, i2);
                                                    if (textView9 != null) {
                                                        i2 = R.id.glass_serial_number_value;
                                                        TextView textView10 = (TextView) ViewBindings.a(view2, i2);
                                                        if (textView10 != null) {
                                                            i2 = R.id.scroll_layout;
                                                            NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.a(view2, i2);
                                                            if (nestedScrollView != null) {
                                                                return new FragmentVuAboutGlassBinding((ConstraintLayout) view2, textView, constraintLayout, textView2, textView3, constraintLayout2, textView4, textView5, textView6, textView7, constraintLayout3, textView8, textView9, textView10, nestedScrollView);
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
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i2)));
    }

    public static FragmentVuAboutGlassBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_vu_about_glass, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6831a;
    }
}
