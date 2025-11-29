package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.meizu.common.widget.AnimCheckBox;
import com.meizu.common.widget.MzButton;
import com.upuphone.xr.sapp.R;
import org.libpag.PAGImageView;

public final class DialogStarrynetConnectBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final LinearLayout f6757a;
    public final MzButton b;
    public final MzButton c;
    public final MzButton d;
    public final MzButton e;
    public final LinearLayout f;
    public final TextView g;
    public final TextView h;
    public final FrameLayout i;
    public final ImageView j;
    public final PAGImageView k;
    public final TextView l;
    public final View m;
    public final LinearLayout n;
    public final LinearLayout o;
    public final LinearLayout p;
    public final AnimCheckBox q;
    public final TextView r;
    public final LinearLayout s;

    public DialogStarrynetConnectBinding(LinearLayout linearLayout, MzButton mzButton, MzButton mzButton2, MzButton mzButton3, MzButton mzButton4, LinearLayout linearLayout2, TextView textView, TextView textView2, FrameLayout frameLayout, ImageView imageView, PAGImageView pAGImageView, TextView textView3, View view, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, AnimCheckBox animCheckBox, TextView textView4, LinearLayout linearLayout6) {
        this.f6757a = linearLayout;
        this.b = mzButton;
        this.c = mzButton2;
        this.d = mzButton3;
        this.e = mzButton4;
        this.f = linearLayout2;
        this.g = textView;
        this.h = textView2;
        this.i = frameLayout;
        this.j = imageView;
        this.k = pAGImageView;
        this.l = textView3;
        this.m = view;
        this.n = linearLayout3;
        this.o = linearLayout4;
        this.p = linearLayout5;
        this.q = animCheckBox;
        this.r = textView4;
        this.s = linearLayout6;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x007b, code lost:
        r1 = com.upuphone.xr.sapp.R.id.dialogBottom;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.upuphone.xr.sapp.databinding.DialogStarrynetConnectBinding a(android.view.View r23) {
        /*
            r0 = r23
            int r1 = com.upuphone.xr.sapp.R.id.confirm_remove
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r5 = r2
            com.meizu.common.widget.MzButton r5 = (com.meizu.common.widget.MzButton) r5
            if (r5 == 0) goto L_0x00d5
            int r1 = com.upuphone.xr.sapp.R.id.device_cancel
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r6 = r2
            com.meizu.common.widget.MzButton r6 = (com.meizu.common.widget.MzButton) r6
            if (r6 == 0) goto L_0x00d5
            int r1 = com.upuphone.xr.sapp.R.id.device_confirm
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r7 = r2
            com.meizu.common.widget.MzButton r7 = (com.meizu.common.widget.MzButton) r7
            if (r7 == 0) goto L_0x00d5
            int r1 = com.upuphone.xr.sapp.R.id.device_connect
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r8 = r2
            com.meizu.common.widget.MzButton r8 = (com.meizu.common.widget.MzButton) r8
            if (r8 == 0) goto L_0x00d5
            int r1 = com.upuphone.xr.sapp.R.id.device_connect_main
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r9 = r2
            android.widget.LinearLayout r9 = (android.widget.LinearLayout) r9
            if (r9 == 0) goto L_0x00d5
            int r1 = com.upuphone.xr.sapp.R.id.device_connect_other
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r10 = r2
            android.widget.TextView r10 = (android.widget.TextView) r10
            if (r10 == 0) goto L_0x00d5
            int r1 = com.upuphone.xr.sapp.R.id.device_content
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r11 = r2
            android.widget.TextView r11 = (android.widget.TextView) r11
            if (r11 == 0) goto L_0x00d5
            int r1 = com.upuphone.xr.sapp.R.id.device_display
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r12 = r2
            android.widget.FrameLayout r12 = (android.widget.FrameLayout) r12
            if (r12 == 0) goto L_0x00d5
            int r1 = com.upuphone.xr.sapp.R.id.device_img
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r13 = r2
            android.widget.ImageView r13 = (android.widget.ImageView) r13
            if (r13 == 0) goto L_0x00d5
            int r1 = com.upuphone.xr.sapp.R.id.device_pag
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r14 = r2
            org.libpag.PAGImageView r14 = (org.libpag.PAGImageView) r14
            if (r14 == 0) goto L_0x00d5
            int r1 = com.upuphone.xr.sapp.R.id.device_title
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r15 = r2
            android.widget.TextView r15 = (android.widget.TextView) r15
            if (r15 == 0) goto L_0x00d5
            int r1 = com.upuphone.xr.sapp.R.id.dialogBottom
            android.view.View r16 = androidx.viewbinding.ViewBindings.a(r0, r1)
            if (r16 == 0) goto L_0x00d5
            int r1 = com.upuphone.xr.sapp.R.id.glass_protocol
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r17 = r2
            android.widget.LinearLayout r17 = (android.widget.LinearLayout) r17
            if (r17 == 0) goto L_0x00d5
            int r1 = com.upuphone.xr.sapp.R.id.ll_bind_device
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r18 = r2
            android.widget.LinearLayout r18 = (android.widget.LinearLayout) r18
            if (r18 == 0) goto L_0x00d5
            int r1 = com.upuphone.xr.sapp.R.id.ll_bind_other_device
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r19 = r2
            android.widget.LinearLayout r19 = (android.widget.LinearLayout) r19
            if (r19 == 0) goto L_0x00d5
            int r1 = com.upuphone.xr.sapp.R.id.protocol_cbx
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r20 = r2
            com.meizu.common.widget.AnimCheckBox r20 = (com.meizu.common.widget.AnimCheckBox) r20
            if (r20 == 0) goto L_0x00d5
            int r1 = com.upuphone.xr.sapp.R.id.protocol_text
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r21 = r2
            android.widget.TextView r21 = (android.widget.TextView) r21
            if (r21 == 0) goto L_0x00d5
            int r1 = com.upuphone.xr.sapp.R.id.remove_device_from_setting
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r22 = r2
            android.widget.LinearLayout r22 = (android.widget.LinearLayout) r22
            if (r22 == 0) goto L_0x00d5
            com.upuphone.xr.sapp.databinding.DialogStarrynetConnectBinding r1 = new com.upuphone.xr.sapp.databinding.DialogStarrynetConnectBinding
            r3 = r1
            r4 = r0
            android.widget.LinearLayout r4 = (android.widget.LinearLayout) r4
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            return r1
        L_0x00d5:
            android.content.res.Resources r0 = r23.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.databinding.DialogStarrynetConnectBinding.a(android.view.View):com.upuphone.xr.sapp.databinding.DialogStarrynetConnectBinding");
    }

    public static DialogStarrynetConnectBinding c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static DialogStarrynetConnectBinding d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_starrynet_connect, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f6757a;
    }
}
