package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.utils.widget.ImageFilterView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.xr.sapp.R;

public final class FragmentMineBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final LinearLayout f6805a;
    public final ImageView b;
    public final TextView c;
    public final TextView d;
    public final ImageFilterView e;
    public final ImageFilterView f;
    public final ImageView g;
    public final ImageView h;
    public final TextView i;
    public final TextView j;
    public final TextView k;
    public final TextView l;
    public final ConstraintLayout m;
    public final ImageView n;
    public final ConstraintLayout o;
    public final ConstraintLayout p;
    public final TextView q;
    public final ConstraintLayout r;
    public final ConstraintLayout s;
    public final TextView t;
    public final TextView u;
    public final TextView v;

    public FragmentMineBinding(LinearLayout linearLayout, ImageView imageView, TextView textView, TextView textView2, ImageFilterView imageFilterView, ImageFilterView imageFilterView2, ImageView imageView2, ImageView imageView3, TextView textView3, TextView textView4, TextView textView5, TextView textView6, ConstraintLayout constraintLayout, ImageView imageView4, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, TextView textView7, ConstraintLayout constraintLayout4, ConstraintLayout constraintLayout5, TextView textView8, TextView textView9, TextView textView10) {
        this.f6805a = linearLayout;
        this.b = imageView;
        this.c = textView;
        this.d = textView2;
        this.e = imageFilterView;
        this.f = imageFilterView2;
        this.g = imageView2;
        this.h = imageView3;
        this.i = textView3;
        this.j = textView4;
        this.k = textView5;
        this.l = textView6;
        this.m = constraintLayout;
        this.n = imageView4;
        this.o = constraintLayout2;
        this.p = constraintLayout3;
        this.q = textView7;
        this.r = constraintLayout4;
        this.s = constraintLayout5;
        this.t = textView8;
        this.u = textView9;
        this.v = textView10;
    }

    public static FragmentMineBinding a(View view) {
        View view2 = view;
        int i2 = R.id.account_bg;
        ImageView imageView = (ImageView) ViewBindings.a(view2, i2);
        if (imageView != null) {
            i2 = R.id.account_name;
            TextView textView = (TextView) ViewBindings.a(view2, i2);
            if (textView != null) {
                i2 = R.id.account_phone;
                TextView textView2 = (TextView) ViewBindings.a(view2, i2);
                if (textView2 != null) {
                    i2 = R.id.account_photo;
                    ImageFilterView imageFilterView = (ImageFilterView) ViewBindings.a(view2, i2);
                    if (imageFilterView != null) {
                        i2 = R.id.account_photo_circle;
                        ImageFilterView imageFilterView2 = (ImageFilterView) ViewBindings.a(view2, i2);
                        if (imageFilterView2 != null) {
                            i2 = R.id.btn_back;
                            ImageView imageView2 = (ImageView) ViewBindings.a(view2, i2);
                            if (imageView2 != null) {
                                i2 = R.id.check_update_version;
                                ImageView imageView3 = (ImageView) ViewBindings.a(view2, i2);
                                if (imageView3 != null) {
                                    i2 = R.id.community;
                                    TextView textView3 = (TextView) ViewBindings.a(view2, i2);
                                    if (textView3 != null) {
                                        i2 = R.id.guide_btn;
                                        TextView textView4 = (TextView) ViewBindings.a(view2, i2);
                                        if (textView4 != null) {
                                            i2 = R.id.guide_name;
                                            TextView textView5 = (TextView) ViewBindings.a(view2, i2);
                                            if (textView5 != null) {
                                                i2 = R.id.help_feedback;
                                                TextView textView6 = (TextView) ViewBindings.a(view2, i2);
                                                if (textView6 != null) {
                                                    i2 = R.id.help_layout;
                                                    ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.a(view2, i2);
                                                    if (constraintLayout != null) {
                                                        i2 = R.id.iv_connect_help;
                                                        ImageView imageView4 = (ImageView) ViewBindings.a(view2, i2);
                                                        if (imageView4 != null) {
                                                            i2 = R.id.lay_connect_help;
                                                            ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.a(view2, i2);
                                                            if (constraintLayout2 != null) {
                                                                i2 = R.id.lay_guide_main;
                                                                ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.a(view2, i2);
                                                                if (constraintLayout3 != null) {
                                                                    i2 = R.id.mall;
                                                                    TextView textView7 = (TextView) ViewBindings.a(view2, i2);
                                                                    if (textView7 != null) {
                                                                        i2 = R.id.mall_community_layout;
                                                                        ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.a(view2, i2);
                                                                        if (constraintLayout4 != null) {
                                                                            i2 = R.id.setting_layout;
                                                                            ConstraintLayout constraintLayout5 = (ConstraintLayout) ViewBindings.a(view2, i2);
                                                                            if (constraintLayout5 != null) {
                                                                                i2 = R.id.setting_menu;
                                                                                TextView textView8 = (TextView) ViewBindings.a(view2, i2);
                                                                                if (textView8 != null) {
                                                                                    i2 = R.id.tv_connect_help;
                                                                                    TextView textView9 = (TextView) ViewBindings.a(view2, i2);
                                                                                    if (textView9 != null) {
                                                                                        i2 = R.id.tv_device_manage;
                                                                                        TextView textView10 = (TextView) ViewBindings.a(view2, i2);
                                                                                        if (textView10 != null) {
                                                                                            return new FragmentMineBinding((LinearLayout) view2, imageView, textView, textView2, imageFilterView, imageFilterView2, imageView2, imageView3, textView3, textView4, textView5, textView6, constraintLayout, imageView4, constraintLayout2, constraintLayout3, textView7, constraintLayout4, constraintLayout5, textView8, textView9, textView10);
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
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i2)));
    }

    public static FragmentMineBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_mine, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f6805a;
    }
}
