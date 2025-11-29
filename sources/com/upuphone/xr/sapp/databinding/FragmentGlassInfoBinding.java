package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.xr.sapp.R;

public final class FragmentGlassInfoBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final LinearLayout f6787a;
    public final TextView b;
    public final TextView c;
    public final TextView d;
    public final ConstraintLayout e;
    public final TextView f;
    public final TextView g;
    public final TextView h;
    public final ConstraintLayout i;
    public final TextView j;
    public final TextView k;
    public final TextView l;
    public final TextView m;
    public final ConstraintLayout n;
    public final ProgressBar o;
    public final TextView p;
    public final TextView q;
    public final TextView r;

    public FragmentGlassInfoBinding(LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, ConstraintLayout constraintLayout, TextView textView4, TextView textView5, TextView textView6, ConstraintLayout constraintLayout2, TextView textView7, TextView textView8, TextView textView9, TextView textView10, ConstraintLayout constraintLayout3, ProgressBar progressBar, TextView textView11, TextView textView12, TextView textView13) {
        this.f6787a = linearLayout;
        this.b = textView;
        this.c = textView2;
        this.d = textView3;
        this.e = constraintLayout;
        this.f = textView4;
        this.g = textView5;
        this.h = textView6;
        this.i = constraintLayout2;
        this.j = textView7;
        this.k = textView8;
        this.l = textView9;
        this.m = textView10;
        this.n = constraintLayout3;
        this.o = progressBar;
        this.p = textView11;
        this.q = textView12;
        this.r = textView13;
    }

    public static FragmentGlassInfoBinding a(View view) {
        View view2 = view;
        int i2 = R.id.glass_bt_addr;
        TextView textView = (TextView) ViewBindings.a(view2, i2);
        if (textView != null) {
            i2 = R.id.glass_bt_addr_value;
            TextView textView2 = (TextView) ViewBindings.a(view2, i2);
            if (textView2 != null) {
                i2 = R.id.glass_info_back;
                TextView textView3 = (TextView) ViewBindings.a(view2, i2);
                if (textView3 != null) {
                    i2 = R.id.glass_info_layout;
                    ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.a(view2, i2);
                    if (constraintLayout != null) {
                        i2 = R.id.glass_model;
                        TextView textView4 = (TextView) ViewBindings.a(view2, i2);
                        if (textView4 != null) {
                            i2 = R.id.glass_model_value;
                            TextView textView5 = (TextView) ViewBindings.a(view2, i2);
                            if (textView5 != null) {
                                i2 = R.id.glass_rom_version;
                                TextView textView6 = (TextView) ViewBindings.a(view2, i2);
                                if (textView6 != null) {
                                    i2 = R.id.glass_rom_version_layout;
                                    ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.a(view2, i2);
                                    if (constraintLayout2 != null) {
                                        i2 = R.id.glass_rom_version_value;
                                        TextView textView7 = (TextView) ViewBindings.a(view2, i2);
                                        if (textView7 != null) {
                                            i2 = R.id.glass_serial_number;
                                            TextView textView8 = (TextView) ViewBindings.a(view2, i2);
                                            if (textView8 != null) {
                                                i2 = R.id.glass_serial_number_value;
                                                TextView textView9 = (TextView) ViewBindings.a(view2, i2);
                                                if (textView9 != null) {
                                                    i2 = R.id.glass_storage;
                                                    TextView textView10 = (TextView) ViewBindings.a(view2, i2);
                                                    if (textView10 != null) {
                                                        i2 = R.id.glass_storage_layout;
                                                        ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.a(view2, i2);
                                                        if (constraintLayout3 != null) {
                                                            i2 = R.id.glass_storage_progress;
                                                            ProgressBar progressBar = (ProgressBar) ViewBindings.a(view2, i2);
                                                            if (progressBar != null) {
                                                                i2 = R.id.glass_storage_value;
                                                                TextView textView11 = (TextView) ViewBindings.a(view2, i2);
                                                                if (textView11 != null) {
                                                                    i2 = R.id.glass_wifi_addr;
                                                                    TextView textView12 = (TextView) ViewBindings.a(view2, i2);
                                                                    if (textView12 != null) {
                                                                        i2 = R.id.glass_wifi_addr_value;
                                                                        TextView textView13 = (TextView) ViewBindings.a(view2, i2);
                                                                        if (textView13 != null) {
                                                                            return new FragmentGlassInfoBinding((LinearLayout) view2, textView, textView2, textView3, constraintLayout, textView4, textView5, textView6, constraintLayout2, textView7, textView8, textView9, textView10, constraintLayout3, progressBar, textView11, textView12, textView13);
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
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i2)));
    }

    public static FragmentGlassInfoBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_glass_info, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f6787a;
    }
}
