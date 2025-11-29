package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.upuphone.xr.sapp.R;

public final class ActivityGlassUpdateInfoBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6722a;
    public final ImageButton b;
    public final LayGlassCheckUpdateErrorBinding c;
    public final LayGlassNoUpdateBinding d;
    public final LayGlassUpdateInfoBinding e;
    public final LinearLayout f;

    public ActivityGlassUpdateInfoBinding(ConstraintLayout constraintLayout, ImageButton imageButton, LayGlassCheckUpdateErrorBinding layGlassCheckUpdateErrorBinding, LayGlassNoUpdateBinding layGlassNoUpdateBinding, LayGlassUpdateInfoBinding layGlassUpdateInfoBinding, LinearLayout linearLayout) {
        this.f6722a = constraintLayout;
        this.b = imageButton;
        this.c = layGlassCheckUpdateErrorBinding;
        this.d = layGlassNoUpdateBinding;
        this.e = layGlassUpdateInfoBinding;
        this.f = linearLayout;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        r0 = com.upuphone.xr.sapp.R.id.lay_glass_check_update_error;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.upuphone.xr.sapp.databinding.ActivityGlassUpdateInfoBinding a(android.view.View r9) {
        /*
            int r0 = com.upuphone.xr.sapp.R.id.btn_back
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r9, r0)
            r4 = r1
            android.widget.ImageButton r4 = (android.widget.ImageButton) r4
            if (r4 == 0) goto L_0x0044
            int r0 = com.upuphone.xr.sapp.R.id.lay_glass_check_update_error
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r9, r0)
            if (r1 == 0) goto L_0x0044
            com.upuphone.xr.sapp.databinding.LayGlassCheckUpdateErrorBinding r5 = com.upuphone.xr.sapp.databinding.LayGlassCheckUpdateErrorBinding.a(r1)
            int r0 = com.upuphone.xr.sapp.R.id.lay_glass_no_update
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r9, r0)
            if (r1 == 0) goto L_0x0044
            com.upuphone.xr.sapp.databinding.LayGlassNoUpdateBinding r6 = com.upuphone.xr.sapp.databinding.LayGlassNoUpdateBinding.a(r1)
            int r0 = com.upuphone.xr.sapp.R.id.lay_glass_update_info
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r9, r0)
            if (r1 == 0) goto L_0x0044
            com.upuphone.xr.sapp.databinding.LayGlassUpdateInfoBinding r7 = com.upuphone.xr.sapp.databinding.LayGlassUpdateInfoBinding.a(r1)
            int r0 = com.upuphone.xr.sapp.R.id.ll_top_bar
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r9, r0)
            r8 = r1
            android.widget.LinearLayout r8 = (android.widget.LinearLayout) r8
            if (r8 == 0) goto L_0x0044
            com.upuphone.xr.sapp.databinding.ActivityGlassUpdateInfoBinding r0 = new com.upuphone.xr.sapp.databinding.ActivityGlassUpdateInfoBinding
            r3 = r9
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8)
            return r0
        L_0x0044:
            android.content.res.Resources r9 = r9.getResources()
            java.lang.String r9 = r9.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r9 = r1.concat(r9)
            r0.<init>(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.databinding.ActivityGlassUpdateInfoBinding.a(android.view.View):com.upuphone.xr.sapp.databinding.ActivityGlassUpdateInfoBinding");
    }

    public static ActivityGlassUpdateInfoBinding c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityGlassUpdateInfoBinding d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_glass_update_info, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6722a;
    }
}
