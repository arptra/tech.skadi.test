package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.meizu.common.widget.Switch;
import com.upuphone.xr.sapp.R;

public final class FragmentRingManagerBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6813a;
    public final ConstraintLayout b;
    public final ConstraintLayout c;
    public final Switch d;
    public final ConstraintLayout e;
    public final TextView f;
    public final TextView g;
    public final ConstraintLayout h;
    public final TextView i;
    public final ConstraintLayout j;
    public final TextView k;
    public final ConstraintLayout l;
    public final TextView m;
    public final TextView n;
    public final ConstraintLayout o;
    public final TextView p;

    public FragmentRingManagerBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, Switch switchR, ConstraintLayout constraintLayout4, TextView textView, TextView textView2, ConstraintLayout constraintLayout5, TextView textView3, ConstraintLayout constraintLayout6, TextView textView4, ConstraintLayout constraintLayout7, TextView textView5, TextView textView6, ConstraintLayout constraintLayout8, TextView textView7) {
        this.f6813a = constraintLayout;
        this.b = constraintLayout2;
        this.c = constraintLayout3;
        this.d = switchR;
        this.e = constraintLayout4;
        this.f = textView;
        this.g = textView2;
        this.h = constraintLayout5;
        this.i = textView3;
        this.j = constraintLayout6;
        this.k = textView4;
        this.l = constraintLayout7;
        this.m = textView5;
        this.n = textView6;
        this.o = constraintLayout8;
        this.p = textView7;
    }

    public static FragmentRingManagerBinding a(View view) {
        View view2 = view;
        int i2 = R.id.help_about_layout;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.a(view2, i2);
        if (constraintLayout != null) {
            i2 = R.id.lay_ring_sn;
            ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.a(view2, i2);
            if (constraintLayout2 != null) {
                i2 = R.id.mouse_switch;
                Switch switchR = (Switch) ViewBindings.a(view2, i2);
                if (switchR != null) {
                    i2 = R.id.ring_bluetooth_address;
                    ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.a(view2, i2);
                    if (constraintLayout3 != null) {
                        i2 = R.id.ring_bluetooth_address_value;
                        TextView textView = (TextView) ViewBindings.a(view2, i2);
                        if (textView != null) {
                            i2 = R.id.ring_manager_title;
                            TextView textView2 = (TextView) ViewBindings.a(view2, i2);
                            if (textView2 != null) {
                                i2 = R.id.ring_model;
                                ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.a(view2, i2);
                                if (constraintLayout4 != null) {
                                    i2 = R.id.ring_model_value;
                                    TextView textView3 = (TextView) ViewBindings.a(view2, i2);
                                    if (textView3 != null) {
                                        i2 = R.id.ring_mouse;
                                        ConstraintLayout constraintLayout5 = (ConstraintLayout) ViewBindings.a(view2, i2);
                                        if (constraintLayout5 != null) {
                                            i2 = R.id.ring_mouse_text;
                                            TextView textView4 = (TextView) ViewBindings.a(view2, i2);
                                            if (textView4 != null) {
                                                i2 = R.id.ring_name;
                                                ConstraintLayout constraintLayout6 = (ConstraintLayout) ViewBindings.a(view2, i2);
                                                if (constraintLayout6 != null) {
                                                    i2 = R.id.ring_name_text;
                                                    TextView textView5 = (TextView) ViewBindings.a(view2, i2);
                                                    if (textView5 != null) {
                                                        i2 = R.id.ring_sn_value;
                                                        TextView textView6 = (TextView) ViewBindings.a(view2, i2);
                                                        if (textView6 != null) {
                                                            i2 = R.id.ring_version;
                                                            ConstraintLayout constraintLayout7 = (ConstraintLayout) ViewBindings.a(view2, i2);
                                                            if (constraintLayout7 != null) {
                                                                i2 = R.id.ring_version_value;
                                                                TextView textView7 = (TextView) ViewBindings.a(view2, i2);
                                                                if (textView7 != null) {
                                                                    return new FragmentRingManagerBinding((ConstraintLayout) view2, constraintLayout, constraintLayout2, switchR, constraintLayout3, textView, textView2, constraintLayout4, textView3, constraintLayout5, textView4, constraintLayout6, textView5, textView6, constraintLayout7, textView7);
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

    public static FragmentRingManagerBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_ring_manager, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6813a;
    }
}
