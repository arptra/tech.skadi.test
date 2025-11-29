package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.view.NestedScrollViewSelf;

public final class ActivityDebugInfoBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6720a;
    public final ImageButton b;
    public final Button c;
    public final NestedScrollViewSelf d;
    public final LayoutDebugInfoDumpLogBinding e;
    public final LayoutDebugForceMutiDeviceBinding f;
    public final LinearLayout g;
    public final LinearLayout h;
    public final Button i;
    public final Spinner j;
    public final Button k;
    public final Button l;
    public final TextView m;
    public final TextView n;

    public ActivityDebugInfoBinding(ConstraintLayout constraintLayout, ImageButton imageButton, Button button, NestedScrollViewSelf nestedScrollViewSelf, LayoutDebugInfoDumpLogBinding layoutDebugInfoDumpLogBinding, LayoutDebugForceMutiDeviceBinding layoutDebugForceMutiDeviceBinding, LinearLayout linearLayout, LinearLayout linearLayout2, Button button2, Spinner spinner, Button button3, Button button4, TextView textView, TextView textView2) {
        this.f6720a = constraintLayout;
        this.b = imageButton;
        this.c = button;
        this.d = nestedScrollViewSelf;
        this.e = layoutDebugInfoDumpLogBinding;
        this.f = layoutDebugForceMutiDeviceBinding;
        this.g = linearLayout;
        this.h = linearLayout2;
        this.i = button2;
        this.j = spinner;
        this.k = button3;
        this.l = button4;
        this.m = textView;
        this.n = textView2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0023, code lost:
        r1 = com.upuphone.xr.sapp.R.id.dump_layout;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.upuphone.xr.sapp.databinding.ActivityDebugInfoBinding a(android.view.View r18) {
        /*
            r0 = r18
            int r1 = com.upuphone.xr.sapp.R.id.btn_back
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r5 = r2
            android.widget.ImageButton r5 = (android.widget.ImageButton) r5
            if (r5 == 0) goto L_0x009f
            int r1 = com.upuphone.xr.sapp.R.id.debug_feedback
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r6 = r2
            android.widget.Button r6 = (android.widget.Button) r6
            if (r6 == 0) goto L_0x009f
            int r1 = com.upuphone.xr.sapp.R.id.debug_info_scroll_view
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r7 = r2
            com.upuphone.xr.sapp.view.NestedScrollViewSelf r7 = (com.upuphone.xr.sapp.view.NestedScrollViewSelf) r7
            if (r7 == 0) goto L_0x009f
            int r1 = com.upuphone.xr.sapp.R.id.dump_layout
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            if (r2 == 0) goto L_0x009f
            com.upuphone.xr.sapp.databinding.LayoutDebugInfoDumpLogBinding r8 = com.upuphone.xr.sapp.databinding.LayoutDebugInfoDumpLogBinding.a(r2)
            int r1 = com.upuphone.xr.sapp.R.id.flutter_debug_layout
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            if (r2 == 0) goto L_0x009f
            com.upuphone.xr.sapp.databinding.LayoutDebugForceMutiDeviceBinding r9 = com.upuphone.xr.sapp.databinding.LayoutDebugForceMutiDeviceBinding.a(r2)
            int r1 = com.upuphone.xr.sapp.R.id.ll_content_layout
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r10 = r2
            android.widget.LinearLayout r10 = (android.widget.LinearLayout) r10
            if (r10 == 0) goto L_0x009f
            int r1 = com.upuphone.xr.sapp.R.id.ll_top_bar
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r11 = r2
            android.widget.LinearLayout r11 = (android.widget.LinearLayout) r11
            if (r11 == 0) goto L_0x009f
            int r1 = com.upuphone.xr.sapp.R.id.load_so_btn
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r12 = r2
            android.widget.Button r12 = (android.widget.Button) r12
            if (r12 == 0) goto L_0x009f
            int r1 = com.upuphone.xr.sapp.R.id.netconfig_spinner
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r13 = r2
            android.widget.Spinner r13 = (android.widget.Spinner) r13
            if (r13 == 0) goto L_0x009f
            int r1 = com.upuphone.xr.sapp.R.id.open_debug_login_btn
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r14 = r2
            android.widget.Button r14 = (android.widget.Button) r14
            if (r14 == 0) goto L_0x009f
            int r1 = com.upuphone.xr.sapp.R.id.open_rn_page_btn
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r15 = r2
            android.widget.Button r15 = (android.widget.Button) r15
            if (r15 == 0) goto L_0x009f
            int r1 = com.upuphone.xr.sapp.R.id.starry_info_text
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r16 = r2
            android.widget.TextView r16 = (android.widget.TextView) r16
            if (r16 == 0) goto L_0x009f
            int r1 = com.upuphone.xr.sapp.R.id.tv_title_tip
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r17 = r2
            android.widget.TextView r17 = (android.widget.TextView) r17
            if (r17 == 0) goto L_0x009f
            com.upuphone.xr.sapp.databinding.ActivityDebugInfoBinding r1 = new com.upuphone.xr.sapp.databinding.ActivityDebugInfoBinding
            r4 = r0
            androidx.constraintlayout.widget.ConstraintLayout r4 = (androidx.constraintlayout.widget.ConstraintLayout) r4
            r3 = r1
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            return r1
        L_0x009f:
            android.content.res.Resources r0 = r18.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.databinding.ActivityDebugInfoBinding.a(android.view.View):com.upuphone.xr.sapp.databinding.ActivityDebugInfoBinding");
    }

    public static ActivityDebugInfoBinding c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityDebugInfoBinding d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_debug_info, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6720a;
    }
}
