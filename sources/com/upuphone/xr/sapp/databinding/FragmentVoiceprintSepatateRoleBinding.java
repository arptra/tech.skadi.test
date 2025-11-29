package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.meizu.common.widget.MzButton;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.view.SappTitleBar;

public final class FragmentVoiceprintSepatateRoleBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6826a;
    public final CheckBox b;
    public final Group c;
    public final Group d;
    public final MzButton e;
    public final MzButton f;
    public final MzButton g;
    public final SappTitleBar h;
    public final TextView i;
    public final TextView j;
    public final TextView k;

    public FragmentVoiceprintSepatateRoleBinding(ConstraintLayout constraintLayout, CheckBox checkBox, Group group, Group group2, MzButton mzButton, MzButton mzButton2, MzButton mzButton3, SappTitleBar sappTitleBar, TextView textView, TextView textView2, TextView textView3) {
        this.f6826a = constraintLayout;
        this.b = checkBox;
        this.c = group;
        this.d = group2;
        this.e = mzButton;
        this.f = mzButton2;
        this.g = mzButton3;
        this.h = sappTitleBar;
        this.i = textView;
        this.j = textView2;
        this.k = textView3;
    }

    public static FragmentVoiceprintSepatateRoleBinding a(View view) {
        int i2 = R.id.cb_privacy_policy;
        CheckBox checkBox = (CheckBox) ViewBindings.a(view, i2);
        if (checkBox != null) {
            i2 = R.id.gp_privacy_policy;
            Group group = (Group) ViewBindings.a(view, i2);
            if (group != null) {
                i2 = R.id.gp_record_more;
                Group group2 = (Group) ViewBindings.a(view, i2);
                if (group2 != null) {
                    i2 = R.id.mbt_clear_vp;
                    MzButton mzButton = (MzButton) ViewBindings.a(view, i2);
                    if (mzButton != null) {
                        i2 = R.id.mbt_more_record;
                        MzButton mzButton2 = (MzButton) ViewBindings.a(view, i2);
                        if (mzButton2 != null) {
                            i2 = R.id.mbt_record;
                            MzButton mzButton3 = (MzButton) ViewBindings.a(view, i2);
                            if (mzButton3 != null) {
                                i2 = R.id.title_bar;
                                SappTitleBar sappTitleBar = (SappTitleBar) ViewBindings.a(view, i2);
                                if (sappTitleBar != null) {
                                    i2 = R.id.tv_privacy_policy;
                                    TextView textView = (TextView) ViewBindings.a(view, i2);
                                    if (textView != null) {
                                        i2 = R.id.tv_record_voiceprint;
                                        TextView textView2 = (TextView) ViewBindings.a(view, i2);
                                        if (textView2 != null) {
                                            i2 = R.id.tv_record_voiceprint1;
                                            TextView textView3 = (TextView) ViewBindings.a(view, i2);
                                            if (textView3 != null) {
                                                return new FragmentVoiceprintSepatateRoleBinding((ConstraintLayout) view, checkBox, group, group2, mzButton, mzButton2, mzButton3, sappTitleBar, textView, textView2, textView3);
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

    public static FragmentVoiceprintSepatateRoleBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_voiceprint_sepatate_role, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6826a;
    }
}
