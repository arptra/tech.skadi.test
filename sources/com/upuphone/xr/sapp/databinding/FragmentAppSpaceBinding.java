package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.view.CardAppSpaceView;

public final class FragmentAppSpaceBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ScrollView f6774a;
    public final CardAppSpaceView b;
    public final CardAppSpaceView c;
    public final CardAppSpaceView d;
    public final CardAppSpaceView e;
    public final CardAppSpaceView f;
    public final CardAppSpaceView g;
    public final TextView h;
    public final TextView i;
    public final ConstraintLayout j;
    public final TextView k;
    public final CardAppSpaceView l;
    public final CardAppSpaceView m;
    public final CardAppSpaceView n;
    public final ConstraintLayout o;

    public FragmentAppSpaceBinding(ScrollView scrollView, CardAppSpaceView cardAppSpaceView, CardAppSpaceView cardAppSpaceView2, CardAppSpaceView cardAppSpaceView3, CardAppSpaceView cardAppSpaceView4, CardAppSpaceView cardAppSpaceView5, CardAppSpaceView cardAppSpaceView6, TextView textView, TextView textView2, ConstraintLayout constraintLayout, TextView textView3, CardAppSpaceView cardAppSpaceView7, CardAppSpaceView cardAppSpaceView8, CardAppSpaceView cardAppSpaceView9, ConstraintLayout constraintLayout2) {
        this.f6774a = scrollView;
        this.b = cardAppSpaceView;
        this.c = cardAppSpaceView2;
        this.d = cardAppSpaceView3;
        this.e = cardAppSpaceView4;
        this.f = cardAppSpaceView5;
        this.g = cardAppSpaceView6;
        this.h = textView;
        this.i = textView2;
        this.j = constraintLayout;
        this.k = textView3;
        this.l = cardAppSpaceView7;
        this.m = cardAppSpaceView8;
        this.n = cardAppSpaceView9;
        this.o = constraintLayout2;
    }

    public static FragmentAppSpaceBinding a(View view) {
        View view2 = view;
        int i2 = R.id.app_space_douyin;
        CardAppSpaceView cardAppSpaceView = (CardAppSpaceView) ViewBindings.a(view2, i2);
        if (cardAppSpaceView != null) {
            i2 = R.id.app_space_guide;
            CardAppSpaceView cardAppSpaceView2 = (CardAppSpaceView) ViewBindings.a(view2, i2);
            if (cardAppSpaceView2 != null) {
                i2 = R.id.app_space_music;
                CardAppSpaceView cardAppSpaceView3 = (CardAppSpaceView) ViewBindings.a(view2, i2);
                if (cardAppSpaceView3 != null) {
                    i2 = R.id.app_space_translator;
                    CardAppSpaceView cardAppSpaceView4 = (CardAppSpaceView) ViewBindings.a(view2, i2);
                    if (cardAppSpaceView4 != null) {
                        i2 = R.id.app_space_unbounded_screen;
                        CardAppSpaceView cardAppSpaceView5 = (CardAppSpaceView) ViewBindings.a(view2, i2);
                        if (cardAppSpaceView5 != null) {
                            i2 = R.id.app_space_wisdom_reminder;
                            CardAppSpaceView cardAppSpaceView6 = (CardAppSpaceView) ViewBindings.a(view2, i2);
                            if (cardAppSpaceView6 != null) {
                                i2 = R.id.application_space_title;
                                TextView textView = (TextView) ViewBindings.a(view2, i2);
                                if (textView != null) {
                                    i2 = R.id.ar_application;
                                    TextView textView2 = (TextView) ViewBindings.a(view2, i2);
                                    if (textView2 != null) {
                                        i2 = R.id.ar_application_layout;
                                        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.a(view2, i2);
                                        if (constraintLayout != null) {
                                            i2 = R.id.ar_desktop;
                                            TextView textView3 = (TextView) ViewBindings.a(view2, i2);
                                            if (textView3 != null) {
                                                i2 = R.id.ar_desktop_mini;
                                                CardAppSpaceView cardAppSpaceView7 = (CardAppSpaceView) ViewBindings.a(view2, i2);
                                                if (cardAppSpaceView7 != null) {
                                                    i2 = R.id.ar_desktop_vientiane;
                                                    CardAppSpaceView cardAppSpaceView8 = (CardAppSpaceView) ViewBindings.a(view2, i2);
                                                    if (cardAppSpaceView8 != null) {
                                                        i2 = R.id.control_voice_manager;
                                                        CardAppSpaceView cardAppSpaceView9 = (CardAppSpaceView) ViewBindings.a(view2, i2);
                                                        if (cardAppSpaceView9 != null) {
                                                            i2 = R.id.mini_layout;
                                                            ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.a(view2, i2);
                                                            if (constraintLayout2 != null) {
                                                                return new FragmentAppSpaceBinding((ScrollView) view2, cardAppSpaceView, cardAppSpaceView2, cardAppSpaceView3, cardAppSpaceView4, cardAppSpaceView5, cardAppSpaceView6, textView, textView2, constraintLayout, textView3, cardAppSpaceView7, cardAppSpaceView8, cardAppSpaceView9, constraintLayout2);
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

    public static FragmentAppSpaceBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_app_space, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ScrollView getRoot() {
        return this.f6774a;
    }
}
