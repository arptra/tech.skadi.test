package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.xr.sapp.R;

public final class FragmentVuDisplayModeBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6833a;
    public final TextView b;
    public final ImageView c;
    public final TextView d;
    public final ConstraintLayout e;
    public final ImageView f;
    public final TextView g;
    public final ImageView h;
    public final ConstraintLayout i;
    public final TextView j;
    public final ConstraintLayout k;
    public final ImageView l;

    public FragmentVuDisplayModeBinding(ConstraintLayout constraintLayout, TextView textView, ImageView imageView, TextView textView2, ConstraintLayout constraintLayout2, ImageView imageView2, TextView textView3, ImageView imageView3, ConstraintLayout constraintLayout3, TextView textView4, ConstraintLayout constraintLayout4, ImageView imageView4) {
        this.f6833a = constraintLayout;
        this.b = textView;
        this.c = imageView;
        this.d = textView2;
        this.e = constraintLayout2;
        this.f = imageView2;
        this.g = textView3;
        this.h = imageView3;
        this.i = constraintLayout3;
        this.j = textView4;
        this.k = constraintLayout4;
        this.l = imageView4;
    }

    public static FragmentVuDisplayModeBinding a(View view) {
        int i2 = R.id.back;
        TextView textView = (TextView) ViewBindings.a(view, i2);
        if (textView != null) {
            i2 = R.id.display_mode_preview;
            ImageView imageView = (ImageView) ViewBindings.a(view, i2);
            if (imageView != null) {
                i2 = R.id.eye_care_mode;
                TextView textView2 = (TextView) ViewBindings.a(view, i2);
                if (textView2 != null) {
                    i2 = R.id.eye_care_mode_layout;
                    ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.a(view, i2);
                    if (constraintLayout != null) {
                        i2 = R.id.eye_care_mode_select;
                        ImageView imageView2 = (ImageView) ViewBindings.a(view, i2);
                        if (imageView2 != null) {
                            i2 = R.id.pro_mode;
                            TextView textView3 = (TextView) ViewBindings.a(view, i2);
                            if (textView3 != null) {
                                i2 = R.id.pro_mode_select;
                                ImageView imageView3 = (ImageView) ViewBindings.a(view, i2);
                                if (imageView3 != null) {
                                    i2 = R.id.standard_mode_layout;
                                    ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.a(view, i2);
                                    if (constraintLayout2 != null) {
                                        i2 = R.id.video_mode;
                                        TextView textView4 = (TextView) ViewBindings.a(view, i2);
                                        if (textView4 != null) {
                                            i2 = R.id.video_mode_layout;
                                            ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.a(view, i2);
                                            if (constraintLayout3 != null) {
                                                i2 = R.id.video_mode_select;
                                                ImageView imageView4 = (ImageView) ViewBindings.a(view, i2);
                                                if (imageView4 != null) {
                                                    return new FragmentVuDisplayModeBinding((ConstraintLayout) view, textView, imageView, textView2, constraintLayout, imageView2, textView3, imageView3, constraintLayout2, textView4, constraintLayout3, imageView4);
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

    public static FragmentVuDisplayModeBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_vu_display_mode, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6833a;
    }
}
