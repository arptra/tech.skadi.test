package com.upuphone.ar.translation.phone.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.upuphone.ar.translation.phone.R;

public final class FragmentSimulTranslationBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6244a;
    public final ConstraintLayout b;
    public final ConstraintLayout c;
    public final ConstraintLayout d;
    public final FrameLayout e;
    public final FrameLayout f;
    public final FrameLayout g;
    public final Guideline h;
    public final Group i;
    public final Group j;
    public final ImageView k;
    public final LinearLayout l;
    public final LottieAnimationView m;
    public final LottieAnimationView n;
    public final LottieAnimationView o;
    public final LottieAnimationView p;
    public final RecyclerView q;
    public final TextView r;
    public final TextView s;
    public final TextView t;
    public final TextView u;
    public final TextView v;
    public final TextView w;
    public final TextView x;
    public final TextView y;

    public FragmentSimulTranslationBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, FrameLayout frameLayout, FrameLayout frameLayout2, FrameLayout frameLayout3, Guideline guideline, Group group, Group group2, ImageView imageView, LinearLayout linearLayout, LottieAnimationView lottieAnimationView, LottieAnimationView lottieAnimationView2, LottieAnimationView lottieAnimationView3, LottieAnimationView lottieAnimationView4, RecyclerView recyclerView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8) {
        this.f6244a = constraintLayout;
        this.b = constraintLayout2;
        this.c = constraintLayout3;
        this.d = constraintLayout4;
        this.e = frameLayout;
        this.f = frameLayout2;
        this.g = frameLayout3;
        this.h = guideline;
        this.i = group;
        this.j = group2;
        this.k = imageView;
        this.l = linearLayout;
        this.m = lottieAnimationView;
        this.n = lottieAnimationView2;
        this.o = lottieAnimationView3;
        this.p = lottieAnimationView4;
        this.q = recyclerView;
        this.r = textView;
        this.s = textView2;
        this.t = textView3;
        this.u = textView4;
        this.v = textView5;
        this.w = textView6;
        this.x = textView7;
        this.y = textView8;
    }

    public static FragmentSimulTranslationBinding a(View view) {
        View view2 = view;
        int i2 = R.id.cl_trans_btn;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.a(view2, i2);
        if (constraintLayout != null) {
            i2 = R.id.cl_trans_func;
            ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.a(view2, i2);
            if (constraintLayout2 != null) {
                i2 = R.id.cl_trans_running;
                ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.a(view2, i2);
                if (constraintLayout3 != null) {
                    i2 = R.id.fl_running_tip;
                    FrameLayout frameLayout = (FrameLayout) ViewBindings.a(view2, i2);
                    if (frameLayout != null) {
                        i2 = R.id.fl_trans_dst;
                        FrameLayout frameLayout2 = (FrameLayout) ViewBindings.a(view2, i2);
                        if (frameLayout2 != null) {
                            i2 = R.id.fl_trans_src;
                            FrameLayout frameLayout3 = (FrameLayout) ViewBindings.a(view2, i2);
                            if (frameLayout3 != null) {
                                i2 = R.id.gl_trans_center;
                                Guideline guideline = (Guideline) ViewBindings.a(view2, i2);
                                if (guideline != null) {
                                    i2 = R.id.gp_trans_lang;
                                    Group group = (Group) ViewBindings.a(view2, i2);
                                    if (group != null) {
                                        i2 = R.id.gp_trans_running;
                                        Group group2 = (Group) ViewBindings.a(view2, i2);
                                        if (group2 != null) {
                                            i2 = R.id.iv_trans_mark;
                                            ImageView imageView = (ImageView) ViewBindings.a(view2, i2);
                                            if (imageView != null) {
                                                i2 = R.id.ll_records;
                                                LinearLayout linearLayout = (LinearLayout) ViewBindings.a(view2, i2);
                                                if (linearLayout != null) {
                                                    i2 = R.id.lottie_trans_chang;
                                                    LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.a(view2, i2);
                                                    if (lottieAnimationView != null) {
                                                        i2 = R.id.lottie_trans_loading;
                                                        LottieAnimationView lottieAnimationView2 = (LottieAnimationView) ViewBindings.a(view2, i2);
                                                        if (lottieAnimationView2 != null) {
                                                            i2 = R.id.lottie_trans_running;
                                                            LottieAnimationView lottieAnimationView3 = (LottieAnimationView) ViewBindings.a(view2, i2);
                                                            if (lottieAnimationView3 != null) {
                                                                i2 = R.id.lottie_trans_running_new;
                                                                LottieAnimationView lottieAnimationView4 = (LottieAnimationView) ViewBindings.a(view2, i2);
                                                                if (lottieAnimationView4 != null) {
                                                                    i2 = R.id.rv_records;
                                                                    RecyclerView recyclerView = (RecyclerView) ViewBindings.a(view2, i2);
                                                                    if (recyclerView != null) {
                                                                        i2 = R.id.tv_record_title;
                                                                        TextView textView = (TextView) ViewBindings.a(view2, i2);
                                                                        if (textView != null) {
                                                                            i2 = R.id.tv_stop_btn;
                                                                            TextView textView2 = (TextView) ViewBindings.a(view2, i2);
                                                                            if (textView2 != null) {
                                                                                i2 = R.id.tv_trans_auto_tips;
                                                                                TextView textView3 = (TextView) ViewBindings.a(view2, i2);
                                                                                if (textView3 != null) {
                                                                                    i2 = R.id.tv_trans_btn;
                                                                                    TextView textView4 = (TextView) ViewBindings.a(view2, i2);
                                                                                    if (textView4 != null) {
                                                                                        i2 = R.id.tv_trans_dst;
                                                                                        TextView textView5 = (TextView) ViewBindings.a(view2, i2);
                                                                                        if (textView5 != null) {
                                                                                            i2 = R.id.tv_trans_running;
                                                                                            TextView textView6 = (TextView) ViewBindings.a(view2, i2);
                                                                                            if (textView6 != null) {
                                                                                                i2 = R.id.tv_trans_running_new;
                                                                                                TextView textView7 = (TextView) ViewBindings.a(view2, i2);
                                                                                                if (textView7 != null) {
                                                                                                    i2 = R.id.tv_trans_src;
                                                                                                    TextView textView8 = (TextView) ViewBindings.a(view2, i2);
                                                                                                    if (textView8 != null) {
                                                                                                        return new FragmentSimulTranslationBinding((ConstraintLayout) view2, constraintLayout, constraintLayout2, constraintLayout3, frameLayout, frameLayout2, frameLayout3, guideline, group, group2, imageView, linearLayout, lottieAnimationView, lottieAnimationView2, lottieAnimationView3, lottieAnimationView4, recyclerView, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8);
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
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i2)));
    }

    public static FragmentSimulTranslationBinding c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentSimulTranslationBinding d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_simul_translation, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6244a;
    }
}
