package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.xr.sapp.R;

public final class WifiItemLayoutBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6906a;
    public final LinearLayout b;
    public final FrameLayout c;
    public final ProgressBar d;
    public final TextView e;
    public final LinearLayout f;
    public final FrameLayout g;
    public final FrameLayout h;
    public final TextView i;
    public final ConstraintLayout j;
    public final ImageView k;
    public final ImageView l;
    public final ImageView m;
    public final ConstraintLayout n;
    public final ImageView o;
    public final TextView p;
    public final TextView q;
    public final TextView r;
    public final ImageView s;
    public final ImageView t;
    public final ImageView u;

    public WifiItemLayoutBinding(ConstraintLayout constraintLayout, LinearLayout linearLayout, FrameLayout frameLayout, ProgressBar progressBar, TextView textView, LinearLayout linearLayout2, FrameLayout frameLayout2, FrameLayout frameLayout3, TextView textView2, ConstraintLayout constraintLayout2, ImageView imageView, ImageView imageView2, ImageView imageView3, ConstraintLayout constraintLayout3, ImageView imageView4, TextView textView3, TextView textView4, TextView textView5, ImageView imageView5, ImageView imageView6, ImageView imageView7) {
        this.f6906a = constraintLayout;
        this.b = linearLayout;
        this.c = frameLayout;
        this.d = progressBar;
        this.e = textView;
        this.f = linearLayout2;
        this.g = frameLayout2;
        this.h = frameLayout3;
        this.i = textView2;
        this.j = constraintLayout2;
        this.k = imageView;
        this.l = imageView2;
        this.m = imageView3;
        this.n = constraintLayout3;
        this.o = imageView4;
        this.p = textView3;
        this.q = textView4;
        this.r = textView5;
        this.s = imageView5;
        this.t = imageView6;
        this.u = imageView7;
    }

    public static WifiItemLayoutBinding a(View view) {
        View view2 = view;
        int i2 = R.id.connecting_loading;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.a(view2, i2);
        if (linearLayout != null) {
            i2 = R.id.ignore_wifi;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.a(view2, i2);
            if (frameLayout != null) {
                i2 = R.id.ignore_wifi_pb;
                ProgressBar progressBar = (ProgressBar) ViewBindings.a(view2, i2);
                if (progressBar != null) {
                    i2 = R.id.ignore_wifi_tv;
                    TextView textView = (TextView) ViewBindings.a(view2, i2);
                    if (textView != null) {
                        i2 = R.id.ll_wifi_name;
                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.a(view2, i2);
                        if (linearLayout2 != null) {
                            i2 = R.id.main_bottom;
                            FrameLayout frameLayout2 = (FrameLayout) ViewBindings.a(view2, i2);
                            if (frameLayout2 != null) {
                                i2 = R.id.main_top;
                                FrameLayout frameLayout3 = (FrameLayout) ViewBindings.a(view2, i2);
                                if (frameLayout3 != null) {
                                    i2 = R.id.middle_bg;
                                    TextView textView2 = (TextView) ViewBindings.a(view2, i2);
                                    if (textView2 != null) {
                                        i2 = R.id.wifi_bg;
                                        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.a(view2, i2);
                                        if (constraintLayout != null) {
                                            i2 = R.id.wifi_bottom;
                                            ImageView imageView = (ImageView) ViewBindings.a(view2, i2);
                                            if (imageView != null) {
                                                i2 = R.id.wifi_bottom_normal;
                                                ImageView imageView2 = (ImageView) ViewBindings.a(view2, i2);
                                                if (imageView2 != null) {
                                                    i2 = R.id.wifi_connect_ed;
                                                    ImageView imageView3 = (ImageView) ViewBindings.a(view2, i2);
                                                    if (imageView3 != null) {
                                                        i2 = R.id.wifi_content;
                                                        ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.a(view2, i2);
                                                        if (constraintLayout2 != null) {
                                                            i2 = R.id.wifi_lock_state;
                                                            ImageView imageView4 = (ImageView) ViewBindings.a(view2, i2);
                                                            if (imageView4 != null) {
                                                                i2 = R.id.wifi_name;
                                                                TextView textView3 = (TextView) ViewBindings.a(view2, i2);
                                                                if (textView3 != null) {
                                                                    i2 = R.id.wifi_name_sub;
                                                                    TextView textView4 = (TextView) ViewBindings.a(view2, i2);
                                                                    if (textView4 != null) {
                                                                        i2 = R.id.wifi_name_sub_invalid;
                                                                        TextView textView5 = (TextView) ViewBindings.a(view2, i2);
                                                                        if (textView5 != null) {
                                                                            i2 = R.id.wifi_phone_connect;
                                                                            ImageView imageView5 = (ImageView) ViewBindings.a(view2, i2);
                                                                            if (imageView5 != null) {
                                                                                i2 = R.id.wifi_top;
                                                                                ImageView imageView6 = (ImageView) ViewBindings.a(view2, i2);
                                                                                if (imageView6 != null) {
                                                                                    i2 = R.id.wifi_top_normal;
                                                                                    ImageView imageView7 = (ImageView) ViewBindings.a(view2, i2);
                                                                                    if (imageView7 != null) {
                                                                                        return new WifiItemLayoutBinding((ConstraintLayout) view2, linearLayout, frameLayout, progressBar, textView, linearLayout2, frameLayout2, frameLayout3, textView2, constraintLayout, imageView, imageView2, imageView3, constraintLayout2, imageView4, textView3, textView4, textView5, imageView5, imageView6, imageView7);
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

    public static WifiItemLayoutBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.wifi_item_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6906a;
    }
}
