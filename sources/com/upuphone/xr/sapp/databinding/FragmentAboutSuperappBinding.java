package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.view.CardItemView;

public final class FragmentAboutSuperappBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6769a;
    public final TextView b;
    public final ImageView c;
    public final TextView d;
    public final TextView e;
    public final TextView f;
    public final TextView g;
    public final TextView h;
    public final TextView i;
    public final TextView j;
    public final TextView k;
    public final ImageView l;
    public final NestedScrollView m;
    public final TextView n;
    public final TextView o;
    public final TextView p;
    public final CardItemView q;
    public final ConstraintLayout r;
    public final TextView s;

    public FragmentAboutSuperappBinding(ConstraintLayout constraintLayout, TextView textView, ImageView imageView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, ImageView imageView2, NestedScrollView nestedScrollView, TextView textView10, TextView textView11, TextView textView12, CardItemView cardItemView, ConstraintLayout constraintLayout2, TextView textView13) {
        this.f6769a = constraintLayout;
        this.b = textView;
        this.c = imageView;
        this.d = textView2;
        this.e = textView3;
        this.f = textView4;
        this.g = textView5;
        this.h = textView6;
        this.i = textView7;
        this.j = textView8;
        this.k = textView9;
        this.l = imageView2;
        this.m = nestedScrollView;
        this.n = textView10;
        this.o = textView11;
        this.p = textView12;
        this.q = cardItemView;
        this.r = constraintLayout2;
        this.s = textView13;
    }

    public static FragmentAboutSuperappBinding a(View view) {
        View view2 = view;
        int i2 = R.id.about_reporting_of_violations;
        TextView textView = (TextView) ViewBindings.a(view2, i2);
        if (textView != null) {
            i2 = R.id.about_superapp_pic;
            ImageView imageView = (ImageView) ViewBindings.a(view2, i2);
            if (imageView != null) {
                i2 = R.id.about_superapp_title;
                TextView textView2 = (TextView) ViewBindings.a(view2, i2);
                if (textView2 != null) {
                    i2 = R.id.algorithm_principles;
                    TextView textView3 = (TextView) ViewBindings.a(view2, i2);
                    if (textView3 != null) {
                        i2 = R.id.assistant_privacy_policy;
                        TextView textView4 = (TextView) ViewBindings.a(view2, i2);
                        if (textView4 != null) {
                            i2 = R.id.assistant_service_agreement;
                            TextView textView5 = (TextView) ViewBindings.a(view2, i2);
                            if (textView5 != null) {
                                i2 = R.id.can_update;
                                TextView textView6 = (TextView) ViewBindings.a(view2, i2);
                                if (textView6 != null) {
                                    i2 = R.id.cancel_agree;
                                    TextView textView7 = (TextView) ViewBindings.a(view2, i2);
                                    if (textView7 != null) {
                                        i2 = R.id.children_info;
                                        TextView textView8 = (TextView) ViewBindings.a(view2, i2);
                                        if (textView8 != null) {
                                            i2 = R.id.copyright_company;
                                            TextView textView9 = (TextView) ViewBindings.a(view2, i2);
                                            if (textView9 != null) {
                                                i2 = R.id.loading;
                                                ImageView imageView2 = (ImageView) ViewBindings.a(view2, i2);
                                                if (imageView2 != null) {
                                                    i2 = R.id.scroll_layout;
                                                    NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.a(view2, i2);
                                                    if (nestedScrollView != null) {
                                                        i2 = R.id.superapp_name;
                                                        TextView textView10 = (TextView) ViewBindings.a(view2, i2);
                                                        if (textView10 != null) {
                                                            i2 = R.id.superapp_user_protocol;
                                                            TextView textView11 = (TextView) ViewBindings.a(view2, i2);
                                                            if (textView11 != null) {
                                                                i2 = R.id.superapp_version;
                                                                TextView textView12 = (TextView) ViewBindings.a(view2, i2);
                                                                if (textView12 != null) {
                                                                    i2 = R.id.user_share;
                                                                    CardItemView cardItemView = (CardItemView) ViewBindings.a(view2, i2);
                                                                    if (cardItemView != null) {
                                                                        i2 = R.id.version_protocol_policy_layout;
                                                                        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.a(view2, i2);
                                                                        if (constraintLayout != null) {
                                                                            i2 = R.id.version_update;
                                                                            TextView textView13 = (TextView) ViewBindings.a(view2, i2);
                                                                            if (textView13 != null) {
                                                                                return new FragmentAboutSuperappBinding((ConstraintLayout) view2, textView, imageView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, imageView2, nestedScrollView, textView10, textView11, textView12, cardItemView, constraintLayout, textView13);
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

    public static FragmentAboutSuperappBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_about_superapp, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6769a;
    }
}
