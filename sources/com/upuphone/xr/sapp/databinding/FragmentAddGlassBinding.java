package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.meizu.common.widget.MzButton;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.view.GlassScanAnimView;

public final class FragmentAddGlassBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6771a;
    public final ConstraintLayout b;
    public final MzButton c;
    public final GlassScanAnimView d;
    public final ImageView e;
    public final TextView f;
    public final MzButton g;
    public final TextView h;
    public final TextView i;

    public FragmentAddGlassBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, MzButton mzButton, GlassScanAnimView glassScanAnimView, ImageView imageView, TextView textView, MzButton mzButton2, TextView textView2, TextView textView3) {
        this.f6771a = constraintLayout;
        this.b = constraintLayout2;
        this.c = mzButton;
        this.d = glassScanAnimView;
        this.e = imageView;
        this.f = textView;
        this.g = mzButton2;
        this.h = textView2;
        this.i = textView3;
    }

    public static FragmentAddGlassBinding a(View view) {
        int i2 = R.id.bottom_main;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.a(view, i2);
        if (constraintLayout != null) {
            i2 = R.id.cancel_tv;
            MzButton mzButton = (MzButton) ViewBindings.a(view, i2);
            if (mzButton != null) {
                i2 = R.id.glass_scan_anim;
                GlassScanAnimView glassScanAnimView = (GlassScanAnimView) ViewBindings.a(view, i2);
                if (glassScanAnimView != null) {
                    i2 = R.id.iv_guide;
                    ImageView imageView = (ImageView) ViewBindings.a(view, i2);
                    if (imageView != null) {
                        i2 = R.id.notify_bt;
                        TextView textView = (TextView) ViewBindings.a(view, i2);
                        if (textView != null) {
                            i2 = R.id.research_tv;
                            MzButton mzButton2 = (MzButton) ViewBindings.a(view, i2);
                            if (mzButton2 != null) {
                                i2 = R.id.search_title;
                                TextView textView2 = (TextView) ViewBindings.a(view, i2);
                                if (textView2 != null) {
                                    i2 = R.id.tv_guide_title;
                                    TextView textView3 = (TextView) ViewBindings.a(view, i2);
                                    if (textView3 != null) {
                                        return new FragmentAddGlassBinding((ConstraintLayout) view, constraintLayout, mzButton, glassScanAnimView, imageView, textView, mzButton2, textView2, textView3);
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

    public static FragmentAddGlassBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_add_glass, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6771a;
    }
}
