package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.meizu.common.widget.SmoothCornerView;
import com.meizu.common.widget.Switch;
import com.upuphone.xr.sapp.R;

public final class FragmentEditScheduleBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6781a;
    public final TextView b;
    public final LinearLayout c;
    public final View d;
    public final Switch e;
    public final AppCompatTextView f;
    public final AppCompatImageView g;
    public final AppCompatTextView h;
    public final LinearLayout i;
    public final SmoothCornerView j;

    public FragmentEditScheduleBinding(ConstraintLayout constraintLayout, TextView textView, LinearLayout linearLayout, View view, Switch switchR, AppCompatTextView appCompatTextView, AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView2, LinearLayout linearLayout2, SmoothCornerView smoothCornerView) {
        this.f6781a = constraintLayout;
        this.b = textView;
        this.c = linearLayout;
        this.d = view;
        this.e = switchR;
        this.f = appCompatTextView;
        this.g = appCompatImageView;
        this.h = appCompatTextView2;
        this.i = linearLayout2;
        this.j = smoothCornerView;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0016, code lost:
        r0 = com.upuphone.xr.sapp.R.id.edit_schedule_display_line;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.upuphone.xr.sapp.databinding.FragmentEditScheduleBinding a(android.view.View r13) {
        /*
            int r0 = com.upuphone.xr.sapp.R.id.edit_schedule_back
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r13, r0)
            r4 = r1
            android.widget.TextView r4 = (android.widget.TextView) r4
            if (r4 == 0) goto L_0x006a
            int r0 = com.upuphone.xr.sapp.R.id.edit_schedule_display_lay
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r13, r0)
            r5 = r1
            android.widget.LinearLayout r5 = (android.widget.LinearLayout) r5
            if (r5 == 0) goto L_0x006a
            int r0 = com.upuphone.xr.sapp.R.id.edit_schedule_display_line
            android.view.View r6 = androidx.viewbinding.ViewBindings.a(r13, r0)
            if (r6 == 0) goto L_0x006a
            int r0 = com.upuphone.xr.sapp.R.id.edit_schedule_display_switch
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r13, r0)
            r7 = r1
            com.meizu.common.widget.Switch r7 = (com.meizu.common.widget.Switch) r7
            if (r7 == 0) goto L_0x006a
            int r0 = com.upuphone.xr.sapp.R.id.edit_schedule_display_unbound
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r13, r0)
            r8 = r1
            androidx.appcompat.widget.AppCompatTextView r8 = (androidx.appcompat.widget.AppCompatTextView) r8
            if (r8 == 0) goto L_0x006a
            int r0 = com.upuphone.xr.sapp.R.id.edit_schedule_icon
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r13, r0)
            r9 = r1
            androidx.appcompat.widget.AppCompatImageView r9 = (androidx.appcompat.widget.AppCompatImageView) r9
            if (r9 == 0) goto L_0x006a
            int r0 = com.upuphone.xr.sapp.R.id.edit_schedule_name
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r13, r0)
            r10 = r1
            androidx.appcompat.widget.AppCompatTextView r10 = (androidx.appcompat.widget.AppCompatTextView) r10
            if (r10 == 0) goto L_0x006a
            int r0 = com.upuphone.xr.sapp.R.id.edit_schedule_name_lay
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r13, r0)
            r11 = r1
            android.widget.LinearLayout r11 = (android.widget.LinearLayout) r11
            if (r11 == 0) goto L_0x006a
            int r0 = com.upuphone.xr.sapp.R.id.schedule_display_dot
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r13, r0)
            r12 = r1
            com.meizu.common.widget.SmoothCornerView r12 = (com.meizu.common.widget.SmoothCornerView) r12
            if (r12 == 0) goto L_0x006a
            com.upuphone.xr.sapp.databinding.FragmentEditScheduleBinding r0 = new com.upuphone.xr.sapp.databinding.FragmentEditScheduleBinding
            r3 = r13
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return r0
        L_0x006a:
            android.content.res.Resources r13 = r13.getResources()
            java.lang.String r13 = r13.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r13 = r1.concat(r13)
            r0.<init>(r13)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.databinding.FragmentEditScheduleBinding.a(android.view.View):com.upuphone.xr.sapp.databinding.FragmentEditScheduleBinding");
    }

    public static FragmentEditScheduleBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_edit_schedule, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6781a;
    }
}
