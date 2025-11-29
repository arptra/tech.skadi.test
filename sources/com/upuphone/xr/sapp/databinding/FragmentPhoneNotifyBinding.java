package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.meizu.common.fastscrollletter.FastScrollLetter;
import com.meizu.common.widget.Switch;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.view.FastScrollLetterRecyclerView;

public final class FragmentPhoneNotifyBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final LinearLayout f6811a;
    public final FastScrollLetter b;
    public final TextView c;
    public final LinearLayout d;
    public final TextView e;
    public final ConstraintLayout f;
    public final TextView g;
    public final Switch h;
    public final FastScrollLetterRecyclerView i;

    public FragmentPhoneNotifyBinding(LinearLayout linearLayout, FastScrollLetter fastScrollLetter, TextView textView, LinearLayout linearLayout2, TextView textView2, ConstraintLayout constraintLayout, TextView textView3, Switch switchR, FastScrollLetterRecyclerView fastScrollLetterRecyclerView) {
        this.f6811a = linearLayout;
        this.b = fastScrollLetter;
        this.c = textView;
        this.d = linearLayout2;
        this.e = textView2;
        this.f = constraintLayout;
        this.g = textView3;
        this.h = switchR;
        this.i = fastScrollLetterRecyclerView;
    }

    public static FragmentPhoneNotifyBinding a(View view) {
        int i2 = R.id.fastscrollLetter;
        FastScrollLetter fastScrollLetter = (FastScrollLetter) ViewBindings.a(view, i2);
        if (fastScrollLetter != null) {
            i2 = R.id.phone_notify;
            TextView textView = (TextView) ViewBindings.a(view, i2);
            if (textView != null) {
                i2 = R.id.phone_notify_app_lay;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.a(view, i2);
                if (linearLayout != null) {
                    i2 = R.id.phone_notify_back;
                    TextView textView2 = (TextView) ViewBindings.a(view, i2);
                    if (textView2 != null) {
                        i2 = R.id.phone_notify_item;
                        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.a(view, i2);
                        if (constraintLayout != null) {
                            i2 = R.id.phone_notify_sub_title;
                            TextView textView3 = (TextView) ViewBindings.a(view, i2);
                            if (textView3 != null) {
                                i2 = R.id.phone_notify_switch;
                                Switch switchR = (Switch) ViewBindings.a(view, i2);
                                if (switchR != null) {
                                    i2 = R.id.recyclerview;
                                    FastScrollLetterRecyclerView fastScrollLetterRecyclerView = (FastScrollLetterRecyclerView) ViewBindings.a(view, i2);
                                    if (fastScrollLetterRecyclerView != null) {
                                        return new FragmentPhoneNotifyBinding((LinearLayout) view, fastScrollLetter, textView, linearLayout, textView2, constraintLayout, textView3, switchR, fastScrollLetterRecyclerView);
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

    public static FragmentPhoneNotifyBinding c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentPhoneNotifyBinding d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_phone_notify, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f6811a;
    }
}
