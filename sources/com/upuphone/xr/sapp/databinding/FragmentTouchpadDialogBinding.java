package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.xr.sapp.R;

public final class FragmentTouchpadDialogBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6821a;
    public final ConstraintLayout b;
    public final TextView c;
    public final TextView d;
    public final FrameLayout e;
    public final FrameLayout f;
    public final Button g;
    public final ConstraintLayout h;
    public final FrameLayout i;
    public final LinearLayout j;
    public final FrameLayout k;
    public final TextView l;
    public final TextView m;

    public FragmentTouchpadDialogBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, TextView textView, TextView textView2, FrameLayout frameLayout, FrameLayout frameLayout2, Button button, ConstraintLayout constraintLayout3, FrameLayout frameLayout3, LinearLayout linearLayout, FrameLayout frameLayout4, TextView textView3, TextView textView4) {
        this.f6821a = constraintLayout;
        this.b = constraintLayout2;
        this.c = textView;
        this.d = textView2;
        this.e = frameLayout;
        this.f = frameLayout2;
        this.g = button;
        this.h = constraintLayout3;
        this.i = frameLayout3;
        this.j = linearLayout;
        this.k = frameLayout4;
        this.l = textView3;
        this.m = textView4;
    }

    public static FragmentTouchpadDialogBinding a(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i2 = R.id.sync_vol_tilte;
        TextView textView = (TextView) ViewBindings.a(view, i2);
        if (textView != null) {
            i2 = R.id.textView2;
            TextView textView2 = (TextView) ViewBindings.a(view, i2);
            if (textView2 != null) {
                i2 = R.id.touchpad_click;
                FrameLayout frameLayout = (FrameLayout) ViewBindings.a(view, i2);
                if (frameLayout != null) {
                    i2 = R.id.touchpad_double_click;
                    FrameLayout frameLayout2 = (FrameLayout) ViewBindings.a(view, i2);
                    if (frameLayout2 != null) {
                        i2 = R.id.touchpad_gesture_confirm;
                        Button button = (Button) ViewBindings.a(view, i2);
                        if (button != null) {
                            i2 = R.id.touchpad_gesture_layout;
                            ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.a(view, i2);
                            if (constraintLayout2 != null) {
                                i2 = R.id.touchpad_long_press;
                                FrameLayout frameLayout3 = (FrameLayout) ViewBindings.a(view, i2);
                                if (frameLayout3 != null) {
                                    i2 = R.id.touchpad_main;
                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.a(view, i2);
                                    if (linearLayout != null) {
                                        i2 = R.id.touchpad_scroll;
                                        FrameLayout frameLayout4 = (FrameLayout) ViewBindings.a(view, i2);
                                        if (frameLayout4 != null) {
                                            i2 = R.id.tv_long_press;
                                            TextView textView3 = (TextView) ViewBindings.a(view, i2);
                                            if (textView3 != null) {
                                                i2 = R.id.tv_scroll;
                                                TextView textView4 = (TextView) ViewBindings.a(view, i2);
                                                if (textView4 != null) {
                                                    return new FragmentTouchpadDialogBinding(constraintLayout, constraintLayout, textView, textView2, frameLayout, frameLayout2, button, constraintLayout2, frameLayout3, linearLayout, frameLayout4, textView3, textView4);
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

    public static FragmentTouchpadDialogBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_touchpad_dialog, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6821a;
    }
}
