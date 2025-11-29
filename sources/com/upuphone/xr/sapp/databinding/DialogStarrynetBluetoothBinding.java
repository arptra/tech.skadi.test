package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.meizu.common.widget.MzButton;
import com.upuphone.xr.sapp.R;

public final class DialogStarrynetBluetoothBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final LinearLayout f6756a;
    public final MzButton b;
    public final TextView c;
    public final View d;
    public final ScrollView e;
    public final ConstraintLayout f;
    public final MzButton g;
    public final ConstraintLayout h;
    public final TextView i;

    public DialogStarrynetBluetoothBinding(LinearLayout linearLayout, MzButton mzButton, TextView textView, View view, ScrollView scrollView, ConstraintLayout constraintLayout, MzButton mzButton2, ConstraintLayout constraintLayout2, TextView textView2) {
        this.f6756a = linearLayout;
        this.b = mzButton;
        this.c = textView;
        this.d = view;
        this.e = scrollView;
        this.f = constraintLayout;
        this.g = mzButton2;
        this.h = constraintLayout2;
        this.i = textView2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0016, code lost:
        r0 = com.upuphone.xr.sapp.R.id.dialogBottom;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.upuphone.xr.sapp.databinding.DialogStarrynetBluetoothBinding a(android.view.View r12) {
        /*
            int r0 = com.upuphone.xr.sapp.R.id.confirm
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r12, r0)
            r4 = r1
            com.meizu.common.widget.MzButton r4 = (com.meizu.common.widget.MzButton) r4
            if (r4 == 0) goto L_0x005f
            int r0 = com.upuphone.xr.sapp.R.id.content
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r12, r0)
            r5 = r1
            android.widget.TextView r5 = (android.widget.TextView) r5
            if (r5 == 0) goto L_0x005f
            int r0 = com.upuphone.xr.sapp.R.id.dialogBottom
            android.view.View r6 = androidx.viewbinding.ViewBindings.a(r12, r0)
            if (r6 == 0) goto L_0x005f
            int r0 = com.upuphone.xr.sapp.R.id.lay_scroll_content
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r12, r0)
            r7 = r1
            android.widget.ScrollView r7 = (android.widget.ScrollView) r7
            if (r7 == 0) goto L_0x005f
            int r0 = com.upuphone.xr.sapp.R.id.notice_main
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r12, r0)
            r8 = r1
            androidx.constraintlayout.widget.ConstraintLayout r8 = (androidx.constraintlayout.widget.ConstraintLayout) r8
            if (r8 == 0) goto L_0x005f
            int r0 = com.upuphone.xr.sapp.R.id.refuse
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r12, r0)
            r9 = r1
            com.meizu.common.widget.MzButton r9 = (com.meizu.common.widget.MzButton) r9
            if (r9 == 0) goto L_0x005f
            int r0 = com.upuphone.xr.sapp.R.id.root_content
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r12, r0)
            r10 = r1
            androidx.constraintlayout.widget.ConstraintLayout r10 = (androidx.constraintlayout.widget.ConstraintLayout) r10
            if (r10 == 0) goto L_0x005f
            int r0 = com.upuphone.xr.sapp.R.id.title
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r12, r0)
            r11 = r1
            android.widget.TextView r11 = (android.widget.TextView) r11
            if (r11 == 0) goto L_0x005f
            com.upuphone.xr.sapp.databinding.DialogStarrynetBluetoothBinding r0 = new com.upuphone.xr.sapp.databinding.DialogStarrynetBluetoothBinding
            r3 = r12
            android.widget.LinearLayout r3 = (android.widget.LinearLayout) r3
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
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.databinding.DialogStarrynetBluetoothBinding.a(android.view.View):com.upuphone.xr.sapp.databinding.DialogStarrynetBluetoothBinding");
    }

    public static DialogStarrynetBluetoothBinding c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static DialogStarrynetBluetoothBinding d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_starrynet_bluetooth, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f6756a;
    }
}
