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

public final class FragmentVuLanguageBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6837a;
    public final TextView b;
    public final TextView c;
    public final ConstraintLayout d;
    public final ImageView e;
    public final TextView f;
    public final ConstraintLayout g;
    public final ImageView h;
    public final TextView i;
    public final ConstraintLayout j;
    public final ImageView k;
    public final ConstraintLayout l;

    public FragmentVuLanguageBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2, ConstraintLayout constraintLayout2, ImageView imageView, TextView textView3, ConstraintLayout constraintLayout3, ImageView imageView2, TextView textView4, ConstraintLayout constraintLayout4, ImageView imageView3, ConstraintLayout constraintLayout5) {
        this.f6837a = constraintLayout;
        this.b = textView;
        this.c = textView2;
        this.d = constraintLayout2;
        this.e = imageView;
        this.f = textView3;
        this.g = constraintLayout3;
        this.h = imageView2;
        this.i = textView4;
        this.j = constraintLayout4;
        this.k = imageView3;
        this.l = constraintLayout5;
    }

    public static FragmentVuLanguageBinding a(View view) {
        int i2 = R.id.language_back;
        TextView textView = (TextView) ViewBindings.a(view, i2);
        if (textView != null) {
            i2 = R.id.language_cn_zh;
            TextView textView2 = (TextView) ViewBindings.a(view, i2);
            if (textView2 != null) {
                i2 = R.id.language_cn_zh_layout;
                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.a(view, i2);
                if (constraintLayout != null) {
                    i2 = R.id.language_cn_zh_select;
                    ImageView imageView = (ImageView) ViewBindings.a(view, i2);
                    if (imageView != null) {
                        i2 = R.id.language_en_ms;
                        TextView textView3 = (TextView) ViewBindings.a(view, i2);
                        if (textView3 != null) {
                            i2 = R.id.language_en_ms_layout;
                            ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.a(view, i2);
                            if (constraintLayout2 != null) {
                                i2 = R.id.language_en_ms_select;
                                ImageView imageView2 = (ImageView) ViewBindings.a(view, i2);
                                if (imageView2 != null) {
                                    i2 = R.id.language_en_us;
                                    TextView textView4 = (TextView) ViewBindings.a(view, i2);
                                    if (textView4 != null) {
                                        i2 = R.id.language_en_us_layout;
                                        ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.a(view, i2);
                                        if (constraintLayout3 != null) {
                                            i2 = R.id.language_en_us_select;
                                            ImageView imageView3 = (ImageView) ViewBindings.a(view, i2);
                                            if (imageView3 != null) {
                                                i2 = R.id.lay_glass_update;
                                                ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.a(view, i2);
                                                if (constraintLayout4 != null) {
                                                    return new FragmentVuLanguageBinding((ConstraintLayout) view, textView, textView2, constraintLayout, imageView, textView3, constraintLayout2, imageView2, textView4, constraintLayout3, imageView3, constraintLayout4);
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

    public static FragmentVuLanguageBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_vu_language, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6837a;
    }
}
