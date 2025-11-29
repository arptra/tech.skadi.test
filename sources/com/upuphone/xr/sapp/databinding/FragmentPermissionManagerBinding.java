package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.view.CardItemView;

public final class FragmentPermissionManagerBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6810a;
    public final CardItemView b;
    public final CardItemView c;
    public final CardItemView d;
    public final CardItemView e;
    public final CardItemView f;
    public final CardItemView g;
    public final CardItemView h;
    public final CardItemView i;
    public final ConstraintLayout j;
    public final CardItemView k;
    public final LinearLayout l;
    public final ImageView m;
    public final CardItemView n;
    public final CardItemView o;
    public final LinearLayout p;
    public final CardItemView q;
    public final CardItemView r;
    public final TextView s;
    public final TextView t;
    public final CardItemView u;
    public final CardItemView v;
    public final CardItemView w;
    public final CardItemView x;
    public final ScrollView y;
    public final CardItemView z;

    public FragmentPermissionManagerBinding(ConstraintLayout constraintLayout, CardItemView cardItemView, CardItemView cardItemView2, CardItemView cardItemView3, CardItemView cardItemView4, CardItemView cardItemView5, CardItemView cardItemView6, CardItemView cardItemView7, CardItemView cardItemView8, ConstraintLayout constraintLayout2, CardItemView cardItemView9, LinearLayout linearLayout, ImageView imageView, CardItemView cardItemView10, CardItemView cardItemView11, LinearLayout linearLayout2, CardItemView cardItemView12, CardItemView cardItemView13, TextView textView, TextView textView2, CardItemView cardItemView14, CardItemView cardItemView15, CardItemView cardItemView16, CardItemView cardItemView17, ScrollView scrollView, CardItemView cardItemView18) {
        this.f6810a = constraintLayout;
        this.b = cardItemView;
        this.c = cardItemView2;
        this.d = cardItemView3;
        this.e = cardItemView4;
        this.f = cardItemView5;
        this.g = cardItemView6;
        this.h = cardItemView7;
        this.i = cardItemView8;
        this.j = constraintLayout2;
        this.k = cardItemView9;
        this.l = linearLayout;
        this.m = imageView;
        this.n = cardItemView10;
        this.o = cardItemView11;
        this.p = linearLayout2;
        this.q = cardItemView12;
        this.r = cardItemView13;
        this.s = textView;
        this.t = textView2;
        this.u = cardItemView14;
        this.v = cardItemView15;
        this.w = cardItemView16;
        this.x = cardItemView17;
        this.y = scrollView;
        this.z = cardItemView18;
    }

    public static FragmentPermissionManagerBinding a(View view) {
        View view2 = view;
        int i2 = R.id.alert_window;
        CardItemView cardItemView = (CardItemView) ViewBindings.a(view2, i2);
        if (cardItemView != null) {
            i2 = R.id.app_in_over_lay;
            CardItemView cardItemView2 = (CardItemView) ViewBindings.a(view2, i2);
            if (cardItemView2 != null) {
                i2 = R.id.app_list;
                CardItemView cardItemView3 = (CardItemView) ViewBindings.a(view2, i2);
                if (cardItemView3 != null) {
                    i2 = R.id.barrier_free;
                    CardItemView cardItemView4 = (CardItemView) ViewBindings.a(view2, i2);
                    if (cardItemView4 != null) {
                        i2 = R.id.bluetooth;
                        CardItemView cardItemView5 = (CardItemView) ViewBindings.a(view2, i2);
                        if (cardItemView5 != null) {
                            i2 = R.id.calendar;
                            CardItemView cardItemView6 = (CardItemView) ViewBindings.a(view2, i2);
                            if (cardItemView6 != null) {
                                i2 = R.id.call_log;
                                CardItemView cardItemView7 = (CardItemView) ViewBindings.a(view2, i2);
                                if (cardItemView7 != null) {
                                    i2 = R.id.camera;
                                    CardItemView cardItemView8 = (CardItemView) ViewBindings.a(view2, i2);
                                    if (cardItemView8 != null) {
                                        i2 = R.id.clear_loading_layout;
                                        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.a(view2, i2);
                                        if (constraintLayout != null) {
                                            i2 = R.id.file_read;
                                            CardItemView cardItemView9 = (CardItemView) ViewBindings.a(view2, i2);
                                            if (cardItemView9 != null) {
                                                i2 = R.id.lay_permission_list;
                                                LinearLayout linearLayout = (LinearLayout) ViewBindings.a(view2, i2);
                                                if (linearLayout != null) {
                                                    i2 = R.id.loading_view;
                                                    ImageView imageView = (ImageView) ViewBindings.a(view2, i2);
                                                    if (imageView != null) {
                                                        i2 = R.id.location;
                                                        CardItemView cardItemView10 = (CardItemView) ViewBindings.a(view2, i2);
                                                        if (cardItemView10 != null) {
                                                            i2 = R.id.notification;
                                                            CardItemView cardItemView11 = (CardItemView) ViewBindings.a(view2, i2);
                                                            if (cardItemView11 != null) {
                                                                i2 = R.id.notification_layout;
                                                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.a(view2, i2);
                                                                if (linearLayout2 != null) {
                                                                    i2 = R.id.notification_resident_bar;
                                                                    CardItemView cardItemView12 = (CardItemView) ViewBindings.a(view2, i2);
                                                                    if (cardItemView12 != null) {
                                                                        i2 = R.id.notification_right;
                                                                        CardItemView cardItemView13 = (CardItemView) ViewBindings.a(view2, i2);
                                                                        if (cardItemView13 != null) {
                                                                            i2 = R.id.permission_manager_note;
                                                                            TextView textView = (TextView) ViewBindings.a(view2, i2);
                                                                            if (textView != null) {
                                                                                i2 = R.id.permission_manager_title;
                                                                                TextView textView2 = (TextView) ViewBindings.a(view2, i2);
                                                                                if (textView2 != null) {
                                                                                    i2 = R.id.phoneAndDial;
                                                                                    CardItemView cardItemView14 = (CardItemView) ViewBindings.a(view2, i2);
                                                                                    if (cardItemView14 != null) {
                                                                                        i2 = R.id.photo;
                                                                                        CardItemView cardItemView15 = (CardItemView) ViewBindings.a(view2, i2);
                                                                                        if (cardItemView15 != null) {
                                                                                            i2 = R.id.read_contact;
                                                                                            CardItemView cardItemView16 = (CardItemView) ViewBindings.a(view2, i2);
                                                                                            if (cardItemView16 != null) {
                                                                                                i2 = R.id.record_audio;
                                                                                                CardItemView cardItemView17 = (CardItemView) ViewBindings.a(view2, i2);
                                                                                                if (cardItemView17 != null) {
                                                                                                    i2 = R.id.scroll_view;
                                                                                                    ScrollView scrollView = (ScrollView) ViewBindings.a(view2, i2);
                                                                                                    if (scrollView != null) {
                                                                                                        i2 = R.id.sport;
                                                                                                        CardItemView cardItemView18 = (CardItemView) ViewBindings.a(view2, i2);
                                                                                                        if (cardItemView18 != null) {
                                                                                                            return new FragmentPermissionManagerBinding((ConstraintLayout) view2, cardItemView, cardItemView2, cardItemView3, cardItemView4, cardItemView5, cardItemView6, cardItemView7, cardItemView8, constraintLayout, cardItemView9, linearLayout, imageView, cardItemView10, cardItemView11, linearLayout2, cardItemView12, cardItemView13, textView, textView2, cardItemView14, cardItemView15, cardItemView16, cardItemView17, scrollView, cardItemView18);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i2)));
    }

    public static FragmentPermissionManagerBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z2) {
        View inflate = layoutInflater.inflate(R.layout.fragment_permission_manager, viewGroup, false);
        if (z2) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6810a;
    }
}
