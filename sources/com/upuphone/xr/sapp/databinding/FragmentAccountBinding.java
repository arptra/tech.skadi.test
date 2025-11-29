package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.xr.sapp.R;

public final class FragmentAccountBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6770a;
    public final TextView b;
    public final TextView c;
    public final TextView d;
    public final ConstraintLayout e;
    public final TextView f;
    public final TextView g;
    public final TextView h;
    public final TextView i;
    public final TextView j;
    public final ConstraintLayout k;
    public final TextView l;
    public final TextView m;
    public final TextView n;
    public final TextView o;
    public final TextView p;
    public final TextView q;

    public FragmentAccountBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2, TextView textView3, ConstraintLayout constraintLayout2, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, ConstraintLayout constraintLayout3, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14) {
        this.f6770a = constraintLayout;
        this.b = textView;
        this.c = textView2;
        this.d = textView3;
        this.e = constraintLayout2;
        this.f = textView4;
        this.g = textView5;
        this.h = textView6;
        this.i = textView7;
        this.j = textView8;
        this.k = constraintLayout3;
        this.l = textView9;
        this.m = textView10;
        this.n = textView11;
        this.o = textView12;
        this.p = textView13;
        this.q = textView14;
    }

    public static FragmentAccountBinding a(View view) {
        View view2 = view;
        int i2 = R.id.account_center_title;
        TextView textView = (TextView) ViewBindings.a(view2, i2);
        if (textView != null) {
            i2 = R.id.account_logout;
            TextView textView2 = (TextView) ViewBindings.a(view2, i2);
            if (textView2 != null) {
                i2 = R.id.account_name;
                TextView textView3 = (TextView) ViewBindings.a(view2, i2);
                if (textView3 != null) {
                    i2 = R.id.account_name_layout;
                    ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.a(view2, i2);
                    if (constraintLayout != null) {
                        i2 = R.id.account_nickname;
                        TextView textView4 = (TextView) ViewBindings.a(view2, i2);
                        if (textView4 != null) {
                            i2 = R.id.account_nickname_value;
                            TextView textView5 = (TextView) ViewBindings.a(view2, i2);
                            if (textView5 != null) {
                                i2 = R.id.account_title;
                                TextView textView6 = (TextView) ViewBindings.a(view2, i2);
                                if (textView6 != null) {
                                    i2 = R.id.ai_model;
                                    TextView textView7 = (TextView) ViewBindings.a(view2, i2);
                                    if (textView7 != null) {
                                        i2 = R.id.ai_pp_model;
                                        TextView textView8 = (TextView) ViewBindings.a(view2, i2);
                                        if (textView8 != null) {
                                            i2 = R.id.center_item;
                                            ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.a(view2, i2);
                                            if (constraintLayout2 != null) {
                                                i2 = R.id.children_info;
                                                TextView textView9 = (TextView) ViewBindings.a(view2, i2);
                                                if (textView9 != null) {
                                                    i2 = R.id.flyme_privacy_text;
                                                    TextView textView10 = (TextView) ViewBindings.a(view2, i2);
                                                    if (textView10 != null) {
                                                        i2 = R.id.personal_info;
                                                        TextView textView11 = (TextView) ViewBindings.a(view2, i2);
                                                        if (textView11 != null) {
                                                            i2 = R.id.privacy_policy;
                                                            TextView textView12 = (TextView) ViewBindings.a(view2, i2);
                                                            if (textView12 != null) {
                                                                i2 = R.id.real_name_auth;
                                                                TextView textView13 = (TextView) ViewBindings.a(view2, i2);
                                                                if (textView13 != null) {
                                                                    i2 = R.id.third_share;
                                                                    TextView textView14 = (TextView) ViewBindings.a(view2, i2);
                                                                    if (textView14 != null) {
                                                                        return new FragmentAccountBinding((ConstraintLayout) view2, textView, textView2, textView3, constraintLayout, textView4, textView5, textView6, textView7, textView8, constraintLayout2, textView9, textView10, textView11, textView12, textView13, textView14);
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

    public static FragmentAccountBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_account, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6770a;
    }
}
