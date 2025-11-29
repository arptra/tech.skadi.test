package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.xr.sapp.R;

public final class FragmentGlassPowerActionBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6791a;
    public final TextView b;
    public final CheckedTextView c;
    public final LinearLayout d;
    public final CheckedTextView e;
    public final CheckedTextView f;
    public final ConstraintLayout g;

    public FragmentGlassPowerActionBinding(ConstraintLayout constraintLayout, TextView textView, CheckedTextView checkedTextView, LinearLayout linearLayout, CheckedTextView checkedTextView2, CheckedTextView checkedTextView3, ConstraintLayout constraintLayout2) {
        this.f6791a = constraintLayout;
        this.b = textView;
        this.c = checkedTextView;
        this.d = linearLayout;
        this.e = checkedTextView2;
        this.f = checkedTextView3;
        this.g = constraintLayout2;
    }

    public static FragmentGlassPowerActionBinding a(View view) {
        int i = R.id.power_action_back;
        TextView textView = (TextView) ViewBindings.a(view, i);
        if (textView != null) {
            i = R.id.power_action_recorder;
            CheckedTextView checkedTextView = (CheckedTextView) ViewBindings.a(view, i);
            if (checkedTextView != null) {
                i = R.id.power_action_select_lay;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.a(view, i);
                if (linearLayout != null) {
                    i = R.id.power_action_transcribe;
                    CheckedTextView checkedTextView2 = (CheckedTextView) ViewBindings.a(view, i);
                    if (checkedTextView2 != null) {
                        i = R.id.power_action_translation;
                        CheckedTextView checkedTextView3 = (CheckedTextView) ViewBindings.a(view, i);
                        if (checkedTextView3 != null) {
                            i = R.id.rootView;
                            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.a(view, i);
                            if (constraintLayout != null) {
                                return new FragmentGlassPowerActionBinding((ConstraintLayout) view, textView, checkedTextView, linearLayout, checkedTextView2, checkedTextView3, constraintLayout);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static FragmentGlassPowerActionBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_glass_power_action, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6791a;
    }
}
