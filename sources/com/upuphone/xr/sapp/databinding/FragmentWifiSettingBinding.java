package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.upuphone.xr.sapp.R;
import flyme.support.v7.widget.MzRecyclerView;

public final class FragmentWifiSettingBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6839a;
    public final TextView b;
    public final LinearLayout c;
    public final TextView d;
    public final TextView e;
    public final ConstraintLayout f;
    public final View g;
    public final MzRecyclerView h;
    public final LinearLayout i;

    public FragmentWifiSettingBinding(ConstraintLayout constraintLayout, TextView textView, LinearLayout linearLayout, TextView textView2, TextView textView3, ConstraintLayout constraintLayout2, View view, MzRecyclerView mzRecyclerView, LinearLayout linearLayout2) {
        this.f6839a = constraintLayout;
        this.b = textView;
        this.c = linearLayout;
        this.d = textView2;
        this.e = textView3;
        this.f = constraintLayout2;
        this.g = view;
        this.h = mzRecyclerView;
        this.i = linearLayout2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0037, code lost:
        r0 = com.upuphone.xr.sapp.R.id.touch_event;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.upuphone.xr.sapp.databinding.FragmentWifiSettingBinding a(android.view.View r12) {
        /*
            int r0 = com.upuphone.xr.sapp.R.id.back_title
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r12, r0)
            r4 = r1
            android.widget.TextView r4 = (android.widget.TextView) r4
            if (r4 == 0) goto L_0x005f
            int r0 = com.upuphone.xr.sapp.R.id.goto_ap_setting
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r12, r0)
            r5 = r1
            android.widget.LinearLayout r5 = (android.widget.LinearLayout) r5
            if (r5 == 0) goto L_0x005f
            int r0 = com.upuphone.xr.sapp.R.id.goto_ap_setting_end
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r12, r0)
            r6 = r1
            android.widget.TextView r6 = (android.widget.TextView) r6
            if (r6 == 0) goto L_0x005f
            int r0 = com.upuphone.xr.sapp.R.id.goto_ap_setting_start
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r12, r0)
            r7 = r1
            android.widget.TextView r7 = (android.widget.TextView) r7
            if (r7 == 0) goto L_0x005f
            int r0 = com.upuphone.xr.sapp.R.id.rootView
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r12, r0)
            r8 = r1
            androidx.constraintlayout.widget.ConstraintLayout r8 = (androidx.constraintlayout.widget.ConstraintLayout) r8
            if (r8 == 0) goto L_0x005f
            int r0 = com.upuphone.xr.sapp.R.id.touch_event
            android.view.View r9 = androidx.viewbinding.ViewBindings.a(r12, r0)
            if (r9 == 0) goto L_0x005f
            int r0 = com.upuphone.xr.sapp.R.id.wifi_list
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r12, r0)
            r10 = r1
            flyme.support.v7.widget.MzRecyclerView r10 = (flyme.support.v7.widget.MzRecyclerView) r10
            if (r10 == 0) goto L_0x005f
            int r0 = com.upuphone.xr.sapp.R.id.wifi_switch_close_ui
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r12, r0)
            r11 = r1
            android.widget.LinearLayout r11 = (android.widget.LinearLayout) r11
            if (r11 == 0) goto L_0x005f
            com.upuphone.xr.sapp.databinding.FragmentWifiSettingBinding r0 = new com.upuphone.xr.sapp.databinding.FragmentWifiSettingBinding
            r3 = r12
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11)
            return r0
        L_0x005f:
            android.content.res.Resources r12 = r12.getResources()
            java.lang.String r12 = r12.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r12 = r1.concat(r12)
            r0.<init>(r12)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.databinding.FragmentWifiSettingBinding.a(android.view.View):com.upuphone.xr.sapp.databinding.FragmentWifiSettingBinding");
    }

    public static FragmentWifiSettingBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_wifi_setting, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6839a;
    }
}
